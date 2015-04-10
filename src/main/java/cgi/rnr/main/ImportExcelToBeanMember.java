package cgi.rnr.main;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.cgi.member.Member;


@SuppressWarnings("deprecation")
public class ImportExcelToBeanMember {

	public static void main(String[] args) throws Exception {
		// File f = new File("c:/Apps/RMG_Allocation_Report_Unique-Nov24.xls");
		ImportExcelToBeanMember ietb = new ImportExcelToBeanMember();
		ietb.writeToMember();
		// session.getTransaction().commit();
	}

	@SuppressWarnings({ "resource" })
	public void writeToMember() throws Exception {
		AnnotationConfiguration config = new org.hibernate.cfg.AnnotationConfiguration();
		config.addAnnotatedClass(Member.class);
		config.configure("hibernate-cfg.xml");
		new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();

		FileInputStream fis = new FileInputStream(
				"D:/RNR/RMG_Allocation_Report_Unique-23-Feb-2015.xlsx");
		XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		Iterator<Row> rowIterator = mySheet.iterator();
		Row row = rowIterator.hasNext() ? rowIterator.next() : null;
		;
		Member member;
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			member = new Member();
			member.setEmployeeId((String) getCellValue(row.getCell(0)));
			member.setEmployeeName((String) getCellValue(row.getCell(1)));
			member.setMemberEmail((String) getCellValue(row.getCell(2)));
			member.setDateOfJoining(HSSFDateUtil.getJavaDate((Double) getCellValue(row.getCell(3))));
			member.setDesignation((String) getCellValue(row.getCell(4)));
			member.setTitleGroup(Integer.parseInt(getCellValue(row.getCell(5)).toString()));
			member.setTotalExp(Double.valueOf((String) getCellValue(row.getCell(8))));
			member.setPrevExp(Double.valueOf((String) getCellValue(row.getCell(7))));
			member.setCgiExp(Double.valueOf((String) getCellValue(row.getCell(6))));
			member.setLocation((String) getCellValue(row.getCell(9)));
			member.setHRBUId((String) getCellValue(row.getCell(14)));
			member.setProjectId((String) getCellValue(row.getCell(15)));
			member.setProjectDescription((String) getCellValue(row.getCell(16)));
			member.setAssignmentEndDate(HSSFDateUtil.getJavaDate((Double) getCellValue(row.getCell(18))));
			member.setAssignmentStartDate(HSSFDateUtil.getJavaDate((Double) getCellValue(row.getCell(19))));
			member.setWorkHoursPerDay(Double.valueOf(getCellValue(row.getCell(20)).toString()));
			member.setProjectRole((String) getCellValue(row.getCell(21)));
			member.setReleaseMonth((String) getCellValue(row.getCell(22)));
			member.setReportingManager((String) getCellValue(row.getCell(23)));
			member.setProjectManager((String) getCellValue(row.getCell(24)));
			member.setSPMName((String) getCellValue(row.getCell(25)));
			member.setEngagementDirectorName((String) getCellValue(row.getCell(26)));
			member.setGroupHeadName((String) getCellValue(row.getCell(27)));
			member.setGroupLeadName((String) getCellValue(row.getCell(28)));
			member.setStratagicGroupLeadName((String) getCellValue(row.getCell(29)));
			member.setPyramidAccount((String) getCellValue(row.getCell(30)));
			member.setVertical((String) getCellValue(row.getCell(31)));
			member.setDepartmentId((String) getCellValue(row.getCell(32)));			
			session.save(member);
			member = null;
			session.getTransaction().commit();
		}

	}

	public Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();
		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getStringCellValue();
		case Cell.CELL_TYPE_BLANK:
			return null;
		default:
			return cell.getDateCellValue();
		}
	}
}
