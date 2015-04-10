package cgi.rnr.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import cgi.rnr.awards.Award;
import cgi.rnr.awards.AwardCriteria;
import cgi.rnr.awards.AwardElig;
import cgi.rnr.awards.AwardPage;
import cgi.rnr.common.FY;
import cgi.rnr.common.Frequency;
import cgi.rnr.common.Hierarchy;
import cgi.rnr.common.NominationPhase;
import cgi.rnr.common.Quarter;
import cgi.rnr.company.City;
import cgi.rnr.company.Company;
import cgi.rnr.company.Continent;
import cgi.rnr.company.Country;
import cgi.rnr.company.Location;
import cgi.rnr.company.State;
import cgi.rnr.company.SubCity;
import cgi.rnr.projects.Project;
import cgi.rnr.projects.Vertical;
import cgi.rnr.security.Access;
import cgi.rnr.security.MemberRole;
import cgi.rnr.security.Pages;
import cgi.rnr.security.Role;
import cgi.rnr.workflow.WorkFlow;
import cgi.rnr.workflow.WorkFlowCriteria;
import cgi.rnr.workflow.WorkFlowLevels;

import com.cgi.nomination.Nomination;
import com.cgi.nomination.NominationForm;
import com.cgi.panel.Panel;
import com.cgi.panel.PanelMembers;

@SuppressWarnings("deprecation")
public class CreateCompanyDB {

	public static void main(String[] args) {

		AnnotationConfiguration config = new org.hibernate.cfg.AnnotationConfiguration();
		config.addAnnotatedClass(Company.class);
		config.addAnnotatedClass(Continent.class);
		config.addAnnotatedClass(Country.class);
		config.addAnnotatedClass(Location.class);
		config.addAnnotatedClass(State.class);
		config.addAnnotatedClass(City.class);
		config.addAnnotatedClass(SubCity.class);
		config.addAnnotatedClass(Nomination.class);
		config.addAnnotatedClass(NominationForm.class);
//		config.addAnnotatedClass(Member.class);
//		config.addAnnotatedClass(MemberExt.class);
		
		config.addAnnotatedClass(Award.class);
		config.addAnnotatedClass(AwardElig.class);
		config.addAnnotatedClass(AwardPage.class);
		config.addAnnotatedClass(AwardCriteria.class);
		
		config.addAnnotatedClass(Frequency.class);
		config.addAnnotatedClass(NominationPhase.class);
		config.addAnnotatedClass(FY.class);
		config.addAnnotatedClass(Quarter.class);
		
		config.addAnnotatedClass(Panel.class);
		config.addAnnotatedClass(PanelMembers.class);
		
		config.addAnnotatedClass(Hierarchy.class);
		config.addAnnotatedClass(WorkFlow.class);
		config.addAnnotatedClass(WorkFlowCriteria.class);
		config.addAnnotatedClass(WorkFlowLevels.class);
		
		config.addAnnotatedClass(Project.class);
		config.addAnnotatedClass(Vertical.class);
		
		config.addAnnotatedClass(Access.class);
		config.addAnnotatedClass(MemberRole.class);
		config.addAnnotatedClass(Pages.class);
		config.addAnnotatedClass(Role.class);
		
		config.configure("hibernate-cfg.xml");

		 new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		{
//			Criteria criteria = session.createCriteria(Company.class)
//					.setProjection(Projections.max("companyName"));
//			System.err.println(criteria.uniqueResult());
			/****** Company *****/
			Company cmp = new Company();
			cmp.setCompanyName("CGI");
			cmp.setCompanyDisplayName("CGI");
			cmp.setCompanyStartDate(new Date());
			session.save(cmp);

			/****** Continents or Business units *****/
			Continent continent = new Continent();
			continent.setContinentName("Asia");
			continent.setContinentDispName("Asia");
			session.save(continent);

			/****** Countries *****/
			Country country = new Country();
			country.setCountryName("India");
			country.setCountryDisplayName("India");
			session.save(country);

			/****** States *****/
			State state = new State();
			state.setStateName("Karnataka");
			state.setStateDisplayName("Karnataka");
			session.save(state);

			State state2 = new State();
			state2.setStateName("Maharasta");
			state2.setStateDisplayName(state2.getStateName());
			session.save(state2);

			State state4 = new State();
			state4.setStateName("Andhra Pradesh");
			state4.setStateDisplayName(state4.getStateName());
			session.save(state4);

			/****** Cities *****/
			City city = new City();
			city.setCityName("Bangalore");
			city.setCityDisplayName("Bangalore");
			session.save(city);

			City city2 = new City();
			city2.setCityName("Mumbai");
			city2.setCityDisplayName(city2.getCityName());
			session.save(city2);

			City city4 = new City();
			city4.setCityName("Hyderabad");
			city4.setCityDisplayName(city4.getCityName());
			session.save(city4);

			/****** Sub-Cities *****/
			SubCity subCity = new SubCity();
			subCity.setSubCityName("E-City");
			subCity.setSubCityDisplayName("Electronic City");
			session.save(subCity);

			SubCity subCity3 = new SubCity();
			subCity3.setSubCityName("Anderi");
			subCity3.setSubCityDisplayName(subCity3.getSubCityName());
			session.save(subCity3);

			SubCity subCity4 = new SubCity();
			subCity4.setSubCityName("SEPZ");
			subCity4.setSubCityDisplayName(subCity3.getSubCityName());
			session.save(subCity4);

			/****** Location *****/
			Location location = new Location();
			location.setLocationName("E-City, Tower 2");
			location.setLocaltionDisplayName(location.getLocationName());
			session.save(location);

			Location location2 = new Location();
			location2.setLocationName("SEEPZ");
			location2.setLocaltionDisplayName("SEEPZ");
			session.save(location2);

			Location location4 = new Location();
			location4.setLocationName("Cuber Park");
			location4.setLocaltionDisplayName(location2.getLocationName());
			session.save(location4);

			Location location5 = new Location();
			location5.setLocationName("DLF");
			location5.setLocaltionDisplayName("DLF");
			session.save(location5);
			
			Frequency freq = new Frequency();
			freq.setFrequencyName("Daily");
			freq.setFrequencyDesc(freq.getFrequencyName());
			freq.setFrequencyDays(1);
			session.save(freq);

			Frequency freq1 = new Frequency();
			freq1.setFrequencyName("Weekly");
			freq1.setFrequencyDesc(freq.getFrequencyName());
			freq1.setFrequencyDays(1);
			session.save(freq1);

			Frequency freq2 = new Frequency();
			freq2.setFrequencyName("Bi-Weekly");
			freq2.setFrequencyDesc(freq.getFrequencyName());
			freq2.setFrequencyDays(1);
			session.save(freq2);

			Frequency freq3 = new Frequency();
			freq3.setFrequencyName("Monthly");
			freq3.setFrequencyDesc(freq.getFrequencyName());
			freq3.setFrequencyDays(1);
			session.save(freq3);

			Frequency freq4 = new Frequency();
			freq4.setFrequencyName("Bi-Monthly");
			freq4.setFrequencyDesc(freq.getFrequencyName());
			freq4.setFrequencyDays(1);
			session.save(freq4);

			Frequency freq5 = new Frequency();
			freq5.setFrequencyName("Quarterly");
			freq5.setFrequencyDesc(freq.getFrequencyName());
			freq5.setFrequencyDays(1);
			session.save(freq5);

			Frequency freq6 = new Frequency();
			freq6.setFrequencyName("Half-Yearly");
			freq6.setFrequencyDesc(freq.getFrequencyName());
			freq6.setFrequencyDays(1);
			session.save(freq6);

			Frequency freq7 = new Frequency();
			freq7.setFrequencyName("Annual");
			freq7.setFrequencyDesc(freq.getFrequencyName());
			freq7.setFrequencyDays(1);
			session.save(freq7);

			Award award = new Award();
			award.setAwardName("POB");
			award.setAwardDesc("PAT ON THE BACK");
			award.setActiveFl('Y');
			award.setFrequencyId(6);
			session.save(award);
			
			AwardElig aElig = new AwardElig();
			aElig.setAwardId(1);
			aElig.setTitleGroup(1);
			session.save(aElig);

			aElig = new AwardElig();
			aElig.setAwardId(1);
			aElig.setTitleGroup(2);
			session.save(aElig);
			
			aElig = new AwardElig();
			aElig.setAwardId(1);
			aElig.setTitleGroup(3);
			session.save(aElig);
			
			aElig = new AwardElig();
			aElig.setAwardId(1);
			aElig.setTitleGroup(4);
			session.save(aElig);
			
			award = new Award();
			award.setAwardName("PEGASUS");
			award.setAwardDesc("Pegasus");
			award.setActiveFl('Y');
			award.setFrequencyId(6);
			session.save(award);
			
			aElig = new AwardElig();
			aElig.setAwardId(2);
			aElig.setTitleGroup(1);
			session.save(aElig);
			
			award = new Award();
			award.setAwardName("CAPELLA");
			award.setAwardDesc("Capella");
			award.setActiveFl('Y');
			award.setFrequencyId(6);
			session.save(award);
			
			aElig = new AwardElig();
			aElig.setAwardId(3);
			aElig.setTitleGroup(2);
			session.save(aElig);
			
			award = new Award();
			award.setAwardName("CORONA");
			award.setAwardDesc("Corona");
			award.setActiveFl('Y');
			award.setFrequencyId(6);
			session.save(award);
			
			aElig = new AwardElig();
			aElig.setAwardId(4);
			aElig.setTitleGroup(1);
			session.save(aElig);
			
			aElig = new AwardElig();
			aElig.setAwardId(4);
			aElig.setTitleGroup(2);
			session.save(aElig);
			
			aElig = new AwardElig();
			aElig.setAwardId(4);
			aElig.setTitleGroup(3);
			session.save(aElig);
			
			aElig = new AwardElig();
			aElig.setAwardId(4);
			aElig.setTitleGroup(4);
			session.save(aElig);
			
			NominationPhase nomPhase = new NominationPhase();
			nomPhase.setPhase(1);
			nomPhase.setName("Submitted");
			session.save(nomPhase);

			nomPhase = new NominationPhase();
			nomPhase.setPhase(2);
			nomPhase.setName("Ready for review");
			session.save(nomPhase);
			
			nomPhase = new NominationPhase();
			nomPhase.setPhase(3);
			nomPhase.setName("In Process");
			session.save(nomPhase);
			
			nomPhase = new NominationPhase();
			nomPhase.setPhase(4);
			nomPhase.setName("Reviewed");
			session.save(nomPhase);
			
			nomPhase = new NominationPhase();
			nomPhase.setPhase(5);
			nomPhase.setName("Approved");
			session.save(nomPhase);
			
			FY fy = new FY();
			fy.setOpenFl('N');
			fy.setFY("2015");
			fy.setCloseFl('N');
			session.save(fy);
			
			Quarter qtr = new Quarter();
			qtr.setFY("2015");
			qtr.setName("Quarter 1");
			qtr.setQtr("1");
			session.save(qtr);
			
			qtr = new Quarter();
			qtr.setFY("2015");
			qtr.setName("Quarter 2");
			qtr.setQtr("2");
			session.save(qtr);
			
			qtr = new Quarter();
			qtr.setFY("2015");
			qtr.setName("Quarter 3");
			qtr.setQtr("3");
			session.save(qtr);
			
			qtr = new Quarter();
			qtr.setFY("2015");
			qtr.setName("Quarter 4");
			qtr.setQtr("4");
			session.save(qtr);
			
			Panel panel = new Panel();
			panel.setPanelName("SOLCAPELLA");
			panel.setPanelDescription("Solutions Capella");
			panel.setTreshold(250);
			session.save(panel);
			
//			PanelMembers pMember = new PanelMembers();
//			pMember.setMemberId("077990");
//			pMember.setPanelId(1);
//			session.save(pMember);
//			
//			pMember = new PanelMembers();
//			pMember.setMemberId("077972");
//			pMember.setPanelId(1);
//			session.save(pMember);
//			
//			pMember = new PanelMembers();
//			pMember.setMemberId("118061");
//			pMember.setPanelId(1);
//			session.save(pMember);
			
			panel = new Panel();
			panel.setPanelName("SOLCORONA");
			panel.setPanelDescription("Solutions Corona");
			panel.setTreshold(250);
			session.save(panel);
			
			panel = new Panel();
			panel.setPanelName("SOLPOB");
			panel.setPanelDescription("Solutions POB");
			panel.setTreshold(250);
			session.save(panel);
			
//			pMember = new PanelMembers();
//			pMember.setMemberId("085132");
//			pMember.setPanelId(3);
//			session.save(pMember);
//			
//			panel = new Panel();
//			panel.setPanelName("SOLPEGASUS");
//			panel.setPanelDescription("Solutions CapePegasuslla");
//			panel.setTreshold(250);
//			session.save(panel);
//			
//			pMember = new PanelMembers();
//			pMember.setMemberId("118061");
//			pMember.setPanelId(4);
//			session.save(pMember);
//			
//			pMember = new PanelMembers();
//			pMember.setMemberId("077990");
//			pMember.setPanelId(4);
//			session.save(pMember);
			
			Project project = new Project();
			project.setActiveFl(true);
			project.setProjectDesc("Advantage");
			project.setProjectName("Advantage");
			session.save(project);
			
			project = new Project();
			project.setActiveFl(true);
			project.setProjectDesc("Advantage-CSG");
			project.setProjectName("Advantage-CSG");
			session.save(project);
			
			project = new Project();
			project.setActiveFl(true);
			project.setProjectDesc("Advantage-PSMAG");
			project.setProjectName("Advantage-PSMAG");
			session.save(project);
			
			project = new Project();
			project.setActiveFl(true);
			project.setProjectDesc("Advantage-DEV");
			project.setProjectName("Advantage-DEV");
			session.save(project);
			
			Vertical vertical = new Vertical();
			vertical.setActiveFl(true);
			vertical.setVerticalName("Solutions");
			vertical.setVerticalDesc("Solutions Group");
			session.save(vertical);

			Hierarchy hierarchy = new Hierarchy();
			hierarchy.setName("RM");
			hierarchy.setColumnName("reportingManager");
			hierarchy.setTableName("com.cgi.member.Member");
			hierarchy.setDisplayName("Reporting Manager");
			session.save(hierarchy);
			
			hierarchy = new Hierarchy();
			hierarchy.setName("PM");
			hierarchy.setColumnName("projectManager");
			hierarchy.setTableName("com.cgi.member.Member");
			hierarchy.setDisplayName("Project Manager");
			session.save(hierarchy);
			
			hierarchy = new Hierarchy();
			hierarchy.setName("SPM");
			hierarchy.setColumnName("SPMName");
			hierarchy.setTableName("com.cgi.member.Member");
			hierarchy.setDisplayName("SPM");
			session.save(hierarchy);
			
			hierarchy = new Hierarchy();
			hierarchy.setName("ED");
			hierarchy.setColumnName("engagementDirectorName");
			hierarchy.setTableName("com.cgi.member.Member");
			hierarchy.setDisplayName("Engagement Director");
			session.save(hierarchy);
			
			hierarchy = new Hierarchy();
			hierarchy.setName("GH");
			hierarchy.setColumnName("groupHeadName");
			hierarchy.setTableName("com.cgi.member.Member");
			hierarchy.setDisplayName("Group Head");
			session.save(hierarchy);
			
			hierarchy = new Hierarchy();
			hierarchy.setName("GL");
			hierarchy.setColumnName("groupLeadName");
			hierarchy.setTableName("com.cgi.member.Member");
			hierarchy.setDisplayName("Group Lead");
			session.save(hierarchy);
			
			hierarchy = new Hierarchy();
			hierarchy.setName("SGL");
			hierarchy.setColumnName("stratagicGroupLeadName");
			hierarchy.setTableName("com.cgi.member.Member");
			hierarchy.setDisplayName("Strategic Group Lead");
			session.save(hierarchy);

			hierarchy = new Hierarchy();
			hierarchy.setName("PG");
			hierarchy.setColumnName("panelId");
			hierarchy.setTableName("com.cgi.panel.Panel");
			hierarchy.setDisplayName("Panel Group");
			session.save(hierarchy);
			
//			WorkFlow wf = new WorkFlow();
//			wf.setWorkFlowName("POB");
//			wf.setActiveFl(true);
//			wf.setWorkFlowDesc("POB-Solutions");
//			session.save(wf);
			
			WorkFlowCriteria wfc = new WorkFlowCriteria();
//			wfc.setAwardId(1);
//			wfc.setVerticalId(1);
			wfc.setWorkFlowId(1);
			wfc.setWorkFlowCriteriaName("POB");
			wfc.setWorkFlowCriteriaDesc("Pat on the Back");
			session.save(wfc);
			
//			WorkFlowLevels wfl = new WorkFlowLevels();
//			wfl.setEmailFlag(false);
//			wfl.setEnableFl(true);
////			wfl.setPanelId(1);
//			wfl.setWorkFlowId(1);
//			wfl.setWorkFlowLevelDesc("POB");
//			wfl.setWorkFlowLevelName("POB");
//			wfl.setWorkFlowLevelSelectionId(3);
//			session.save(wfl);
			
//			wf = new WorkFlow();
//			wf.setWorkFlowName("CAPELLA");
//			wf.setActiveFl(true);
//			wf.setWorkFlowDesc("CAPELLA-Solutions");
//			session.save(wf);
			
			wfc = new WorkFlowCriteria();
//			wfc.setAwardId(3);
//			wfc.setVerticalId(1);
			wfc.setWorkFlowId(2);
			wfc.setWorkFlowCriteriaName("CAPELLA");
			wfc.setWorkFlowCriteriaDesc("CAPELLA");
			session.save(wfc);
//			
//			wfl = new WorkFlowLevels();
//			wfl.setEmailFlag(false);
//			wfl.setEnableFl(true);
//			wfl.setPanelId(1);
//			wfl.setWorkFlowId(2);
//			wfl.setWorkFlowLevelDesc("CAPELLA");
//			wfl.setWorkFlowLevelName("CAPELLA");
//			wfl.setWorkFlowLevelSelectionId(8);
//			session.save(wfl);
		}
		session.getTransaction().commit();
	}

}
