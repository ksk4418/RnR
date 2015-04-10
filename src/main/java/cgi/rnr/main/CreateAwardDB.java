package cgi.rnr.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import cgi.rnr.awards.Award;
import cgi.rnr.awards.AwardElig;
import cgi.rnr.awards.AwardPage;
import cgi.rnr.common.Frequency;

@SuppressWarnings("deprecation")
public class CreateAwardDB {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		AnnotationConfiguration config = new org.hibernate.cfg.AnnotationConfiguration();
		config.addAnnotatedClass(Award.class);
		config.addAnnotatedClass(AwardElig.class);
		config.addAnnotatedClass(AwardPage.class);
		config.addAnnotatedClass(Frequency.class);

		config.configure("hibernate-cfg.xml");

//		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		{
			List list = session.createSQLQuery("select nom.nominationId, nom.FY, nom.quarter, nom.employeeId, rmg.employeeName, rmg.designation, rmg.projectDescription, phase.name, award.awardName from com.cgi.nomination.Nomination nom, com.cgi.Member rmg, cgi.rnr.common.NominationPhase phase, cgi.rnr.awards.Award award where award.awardId = nom.awardId and nom.employeeId = '077990' "
					+ " and nom.employeeId = rmg.employeeId and phase.nomPhase= nom.nominationPhase order by nom.FY desc, nom.quarter desc").list();
			for(Object l:list){
				Object[] obj = (Object[])l;
				System.out.println(obj[0]);
			}
		}
		session.getTransaction().commit();
	}

}
