package com.cgi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cgi.rnr.security.Pages;

import com.cgi.member.Member;
import com.cgi.nomination.Nomination;
import com.cgi.nomination.NominationForm;
import com.cgi.nomination.NominationPanel;

@Repository
public class RNRDAOImpl<T> implements RNRDAO<T> {

   private static final long serialVersionUID = 1L;

   private static final org.slf4j.Logger logger = LoggerFactory
         .getLogger(RNRDAOImpl.class);

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void insert(Object t) {
      sessionFactory.getCurrentSession().save(t);
   }

   @Override
   public void update(Object t) {
      sessionFactory.getCurrentSession().update(t);

   }

   @Override
   public void delete(Object t) {
      sessionFactory.getCurrentSession().delete(t);

   }

   @SuppressWarnings("unchecked")
   @Override
   public T getObjectsByCriteria(Object t) {
      Example example = Example.create(t);

      return (T) sessionFactory.getCurrentSession()
            .createCriteria(t.getClass()).add(example).list();
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<Member> getObjectsByMemberNameorId(String emplName,
         String emplId) {

      Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
            Member.class);
      String employeeId = (emplId == null || emplId.trim().length() == 0) ? "%"
            : "%" + emplId.replace("*", "%") + "%";
      String employeeName = (emplName == null || emplName.trim().length() == 0) ? "%"
            : "%" + emplName.replace("*", "%") + "%";

      criteria.add(Restrictions.like("employeeId", employeeId)).add(
            Restrictions.like("employeeName", employeeName));
      return (List<Member>) criteria.list();
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<Member> getObjectsByMemberNameorId(String emplName,
         String emplId, String vertical) {

      Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
            Member.class);

      String employeeId = (emplId == null || emplId.trim().length() == 0) ? "%"
            : "%" + emplId.replace("*", "%") + "%";
      String employeeName = (emplName == null || emplName.trim().length() == 0) ? "%"
            : "%" + emplName.replace("*", "%") + "%";

      criteria.add(Restrictions.like("employeeId", employeeId))
            .add(Restrictions.like("employeeName", employeeName))
            .add(Restrictions.eq("vertical", vertical));
      return (List<Member>) criteria.list();
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<T> getObjectsByColumn(String columnName, String columnValue,
         Class<T> t) {

      Criteria criteria = sessionFactory.getCurrentSession()
            .createCriteria(t);
      criteria.add(Restrictions.eq(columnName, columnValue));
      return (List<T>) criteria.list();
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<T> getObjectsByColumn(String columnName, long columnValue,
         Class<T> t) {

      Criteria criteria = sessionFactory.getCurrentSession()
            .createCriteria(t);
      criteria.add(Restrictions.eq(columnName, columnValue));
      return (List<T>) criteria.list();
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<T> getObjectsByColumn(String[] columnName,
         Object[] columnValue, Class<T> t) {
      if (columnName.length != columnValue.length) {
         logger.error("Invalid column names and values");
         return new ArrayList<T>();
      }
      Criteria criteria = sessionFactory.getCurrentSession()
            .createCriteria(t);
      for (int i = 0; i < columnName.length; i++) {
         criteria.add(Restrictions.eq(columnName[i], columnValue[i]));
      }
      return (List<T>) criteria.list();
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<T> getObjectsByColumn(String columnName, int columnValue,
         Class<T> t) {

      Criteria criteria = sessionFactory.getCurrentSession()
            .createCriteria(t);
      criteria.add(Restrictions.eq(columnName, columnValue));
      return (List<T>) criteria.list();
   }

   @SuppressWarnings("unchecked")
   @Override
   public List<Object> getResultsBySQL(String sql) {
      return sessionFactory.getCurrentSession().createQuery(sql).list();
   }

   @Override
   public Session getSession() {
      return sessionFactory.getCurrentSession();
   }

   @Override
   public Object getMaxId(T t, String memberName) {
      Criteria criteria = sessionFactory.getCurrentSession()
            .createCriteria(t.getClass())
            .setProjection(Projections.max(memberName));
      return criteria.uniqueResult();
   }

   @Override
   public void addNominationForm(Nomination nomination,
         List<NominationForm> list, List<NominationPanel> listPanel) {
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      try {
         session.save(nomination);
         for (NominationForm nominationForm : list) {
            session.save(nominationForm);
         }

         if (listPanel != null) {
            for (NominationPanel nominationPanel : listPanel) {
               session.save(nominationPanel);
            }
         }
         session.getTransaction().commit();
      } catch (Exception ex) {
         session.getTransaction().rollback();
         throw ex;
      }
   }

   @Override
   public Object getCount(String cls, Map<String, String> whereClause) {
      StringBuilder whereCond = new StringBuilder();
      if (whereClause != null) {
         Set<String> keys = whereClause.keySet();
         boolean firstCondition = true;
         for (String key : keys) {
            if (firstCondition) {
               whereCond.append(" ").append(key).append(" ")
                     .append(whereClause.get(key));
               firstCondition = false;
            } else {
               whereCond.append(" and ").append(key).append(" ")
                     .append(whereClause.get(key));
            }
         }
      }
      StringBuilder sql = new StringBuilder();
      sql.append("select count(*) from ").append(cls);
      if (whereCond.toString().trim().length() > 0) {
         sql.append(" where ").append(whereCond.toString());
      }
      Query query = sessionFactory.getCurrentSession().createQuery(
            sql.toString());
      return query.uniqueResult();
   }

   @Override
   public int getCount(String cls, String whereCondition) {
      StringBuilder sql = new StringBuilder();
      sql.append("select count(*) from ").append(cls);

      if (whereCondition != null
            && whereCondition.toString().trim().length() > 0) {
         sql.append("where ").append(whereCondition);
      }

      Query query = sessionFactory.getCurrentSession().createQuery(
            sql.toString());
      return Integer.parseInt(query.uniqueResult().toString());
   }

   @Override
   @SuppressWarnings("rawtypes")
   public List getRecords(String cls, String whereCondition, String orderBy,
         int current, int rowCount) {
      StringBuilder sql = new StringBuilder();
      sql.append(" from ").append(cls);

      if (whereCondition != null && whereCondition.trim().length() > 0) {
         sql.append(" where ").append(whereCondition);
      }
      if (orderBy != null && orderBy.trim().length() > 0) {
         sql.append(" order by ").append(orderBy);
      }
      Query query = sessionFactory.getCurrentSession().createQuery(
            sql.toString());
      query.setFirstResult(current);
      query.setMaxResults(rowCount);
      return query.list();
   }

   @Override
   @SuppressWarnings("rawtypes")
   public List getRecordsBySQL(String sql, String orderBy, Class<T> dto,
         int current, int rowCount) {
      Query query = sessionFactory.getCurrentSession()
            .createSQLQuery(sql + " order by " + orderBy)
            .setResultTransformer(Transformers.aliasToBean(dto));
      query.setFirstResult(current);
      query.setMaxResults(rowCount);
      return query.list();
   }

   @Override
   @SuppressWarnings("rawtypes")
   public List getRecordsBySQL(String sql, Class<T> dto) {
      Query query = sessionFactory.getCurrentSession().createSQLQuery(sql)
            .setResultTransformer(Transformers.aliasToBean(dto));
      return query.list();
   }

   @Override
   @SuppressWarnings("rawtypes")
   public List getRequiredRecordsBySQL(String sql, int start, int count) {
      Query query = sessionFactory.getCurrentSession().createQuery(sql);
      query.setFirstResult(start);
      query.setMaxResults(count);
      return query.list();
   }

   @Override
   @SuppressWarnings("rawtypes")
   public List getRequiredRecordsBySQL(String sql, int start, int count,
         Class<T> dto) {
      Query query = sessionFactory.getCurrentSession().createQuery(sql)
            .setResultTransformer(Transformers.aliasToBean(dto));
      query.setFirstResult(start);
      query.setMaxResults(count);
      return query.list();
   }

   @Override
   public int getCountBySQL(String sql) {

      Query query = sessionFactory.getCurrentSession().createQuery(sql);
      return Integer.parseInt(query.uniqueResult().toString());
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<T> getRecordsByTable(String tableName) {
      String sql = "from " + tableName;
      return sessionFactory.getCurrentSession()
            .createQuery(sql).list();
   }

   @Override
   @SuppressWarnings("unchecked")
   public String getPage(String pageCode) {
      String pageName = "invalid";
      String sql = "from Pages where pageName='" + pageCode + "'";
      List<Pages> ls = (List<Pages>) sessionFactory.getCurrentSession()
            .createQuery(sql)
            .list();
      if (!ls.isEmpty())
         pageName = ls.get(0).getPath();
      else {
         ls = (List<Pages>) sessionFactory.getCurrentSession()
               .createQuery("from Pages where pageName='NREQ'").list();
         pageName = ls.get(0).getPath();
      }
      return pageName;
   }

   @Override
   @SuppressWarnings("unchecked")
   public String getPage(long id) {
      String pageName = "invalid";
      String sql = "from Pages where id=" + id;
      List<Pages> ls = (List<Pages>) sessionFactory.getCurrentSession()
            .createQuery(sql).list();
      if (!ls.isEmpty())
         pageName = ls.get(0).getPath();
      else {
         ls = (List<Pages>) sessionFactory.getCurrentSession()
               .createQuery("from Pages where pageName='NREQ'").list();
         pageName = ls.get(0).getPath();
      }
      return pageName;
   }

   @Override
   @SuppressWarnings("rawtypes")
   public List getRecords(String sql) {
      return sessionFactory.getCurrentSession().createSQLQuery(sql).list();
   }

   @Override
   public int runUpdateOrDelete(String sql) {
      return sessionFactory.getCurrentSession().createSQLQuery(sql)
            .executeUpdate();
   }
}
