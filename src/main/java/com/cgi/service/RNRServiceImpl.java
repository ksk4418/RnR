package com.cgi.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgi.dao.RNRDAO;
import com.cgi.member.Member;
import com.cgi.nomination.Nomination;
import com.cgi.nomination.NominationForm;
import com.cgi.nomination.NominationPanel;

@Service
public class RNRServiceImpl<T> implements RNRService<T>, Serializable {

   private static final long serialVersionUID = 1L;

   @Autowired
   private RNRDAO<T> rnrDAO;

   @Override
   @Transactional
   public void insert(T t)  {
      rnrDAO.insert(t);
   }

   @Override
   @Transactional
   public void update(T t)  {
      rnrDAO.update(t);

   }

   @Override
   @Transactional
   public void delete(T t)  {
      rnrDAO.delete(t);

   }

   @Override
   @Transactional
   public T getObjectsByCriteria(T t)  {
      return rnrDAO.getObjectsByCriteria(t);
   }

   @Override
   @Transactional
   public Session getSession() {
      return rnrDAO.getSession();
   }

   @Override
   @Transactional
   public Object getMaxId(T t, String memberName)  {
      Object obj = rnrDAO.getMaxId(t, memberName);
      return obj == null ? 0 : obj;
   }

   @Override
   @Transactional
   public void addNominationForm(Nomination nomination,
         List<NominationForm> list, List<NominationPanel> listPanel)
          {
      rnrDAO.addNominationForm(nomination, list, listPanel);

   }

   @Override
   @Transactional
   public List<Member> getObjectsByMemberNameorId(String emplName,
         String emplId)  {

      return rnrDAO.getObjectsByMemberNameorId(emplName,
            emplId);
   }

   @Override
   @Transactional
   public List<T> getObjectsByColumn(String columnName, String columnValue,
         Class<T> t)  {

      return rnrDAO.getObjectsByColumn(columnName, columnValue, t);
   }

   @Override
   @Transactional
   public List<T> getObjectsByColumn(String columnName, int columnValue,
         Class<T> t)  {

      return rnrDAO.getObjectsByColumn(columnName, columnValue, t);
   }

   @Override
   @Transactional
   public List<Object> getResultsBySQL(String sql)  {

      return rnrDAO.getResultsBySQL(sql);
   }

   @Override
   @Transactional
   public List<Member> getObjectsByMemberNameorId(String emplName,
         String emplId, String vertical)  {
      return rnrDAO.getObjectsByMemberNameorId(emplName, emplId, vertical);
   }

   @Override
   @Transactional
   public Object getCount(String cls, Map<String, String> whereClause)
          {
      return rnrDAO.getCount(cls, whereClause);
   }

   @Override
   @Transactional
   public int getCount(String cls, String whereCondition)  {
      return rnrDAO.getCount(cls, whereCondition);
   }

   @SuppressWarnings("rawtypes")
   @Override
   @Transactional
   public List getRecords(String cls, String whereCondition, String orderBy,
         int current, int rowCount)  {
      return rnrDAO.getRecords(cls, whereCondition, orderBy, current,
            rowCount);
   }

   @SuppressWarnings("rawtypes")
   @Override
   @Transactional
   public List getRecordsBySQL(String sql, String orderBy, Class<T> dto,
         int current, int rowCount)  {
      return rnrDAO.getRecordsBySQL(sql, orderBy, dto, current, rowCount);
   }

   @Override
   @Transactional
   public List<T> getRecordsByTable(String tableName)  {
      return rnrDAO.getRecordsByTable(tableName);
   }

   @Override
   @Transactional
   public int getCountBySQL(String sql)  {
      return rnrDAO.getCountBySQL(sql);
   }

   @Override
   @Transactional
   public List<T> getObjectsByColumn(String columnName, long columnValue,
         Class<T> t)  {
      return rnrDAO.getObjectsByColumn(columnName, columnValue, t);
   }

   @Override
   @Transactional
   public List<T> getObjectsByColumn(String[] columnName,
         Object[] columnValue, Class<T> t)  {
      return rnrDAO.getObjectsByColumn(columnName, columnValue, t);
   }

   @SuppressWarnings("rawtypes")
   @Override
   @Transactional
   public List getRecordsBySQL(String sql, Class<T> dto)  {
      return rnrDAO.getRecordsBySQL(sql, dto);
   }

   @SuppressWarnings("rawtypes")
   @Override
   @Transactional
   public List getRequiredRecordsBySQL(String sql, int start, int count)
          {
      return rnrDAO.getRequiredRecordsBySQL(sql, start, count);
   }

   @SuppressWarnings("rawtypes")
   @Override
   @Transactional
   public List getRequiredRecordsBySQL(String sql, int start, int count,
         Class<T> dto)  {
      return rnrDAO.getRequiredRecordsBySQL(sql, start, count, dto);
   }

   @Override
   @Transactional
   public String getPage(String pageCode)  {
      return rnrDAO.getPage(pageCode);
   }

   @Override
   @Transactional
   public String getPage(long id)  {

      return rnrDAO.getPage(id);
   }

   @SuppressWarnings("rawtypes")
   @Override
   @Transactional
   public List getRecords(String sql)  {
      return rnrDAO.getRecords(sql);
   }

   @Override
   @Transactional
   public int runUpdateOrDelete(String sql)  {
      return rnrDAO.runUpdateOrDelete(sql);
   }

}
