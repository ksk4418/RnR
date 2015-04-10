package com.cgi.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.cgi.member.Member;
import com.cgi.nomination.Nomination;
import com.cgi.nomination.NominationForm;
import com.cgi.nomination.NominationPanel;

public interface RNRDAO<T> extends Serializable {

   public void insert(T t);

   public void update(T t);

   public void delete(T t);

   public T getObjectsByCriteria(T t);

   public Session getSession();
   
   public Object getMaxId(T t, String memberName);
   
   public void addNominationForm(Nomination nomination, List<NominationForm> list, List<NominationPanel> listPanel);

   public List<Member> getObjectsByMemberNameorId(String emplName, String emplId);
   
   public List<Member> getObjectsByMemberNameorId(String emplName, String emplId, String vertical);
   
   public List<T> getObjectsByColumn(String columnName, String columnValue, Class<T> t);
   
   public List<T> getObjectsByColumn(String columnName, int columnValue, Class<T> t);
   
   public List<T> getObjectsByColumn(String columnName, long columnValue, Class<T> t);
   
   public List<T> getObjectsByColumn(String[] columnName, Object[] columnValue, Class<T> t);
   
   public List<Object> getResultsBySQL(String sql);
   
   public Object getCount(String cls, Map<String, String> whereClause);
   
   public int getCount(String cls, String whereCondition);

   @SuppressWarnings("rawtypes")
   public List getRecords(String cls, String whereCondition, String orderBy, int current, int rowCount);
   
   @SuppressWarnings("rawtypes")
   public List getRecordsBySQL(String sql, String orderBy, Class<T> dto, int current, int rowCount);
   
   @SuppressWarnings("rawtypes")
   public List getRecordsBySQL(String sql, Class<T> dto);
   
   public List<T> getRecordsByTable(String tableName);
   
   public int getCountBySQL(String sql);
   
   @SuppressWarnings("rawtypes")
   public List getRequiredRecordsBySQL(String sql, int start, int count);
   
   @SuppressWarnings("rawtypes")
   public List getRequiredRecordsBySQL(String sql, int start, int count, Class<T> dto);

   public String getPage(String pageCode);
   
   public String getPage(long id);
   
   @SuppressWarnings("rawtypes")
   public List getRecords(String sql);
   
   public int runUpdateOrDelete(String sql);
}
