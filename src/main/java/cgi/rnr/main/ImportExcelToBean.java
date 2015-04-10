package cgi.rnr.main;

import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.cgi.member.MemberExt;


@SuppressWarnings("deprecation")
public class ImportExcelToBean {

	public static void main(String[] args) throws Exception {
		// File f = new File("c:/Apps/RMG_Allocation_Report_Unique-Nov24.xls");
		ImportExcelToBean ietb = new ImportExcelToBean();
		ietb.writeToMember();
		// session.getTransaction().commit();
	}

	@SuppressWarnings({ "resource" })
	public void writeToMember() throws Exception {
		AnnotationConfiguration config = new org.hibernate.cfg.AnnotationConfiguration();
		config.addAnnotatedClass(MemberExt.class);
		config.configure("hibernate-cfg.xml");
		//new SchemaExport(config).create(true, true);

		SessionFactory factory = config.buildSessionFactory();

//		FileInputStream fis = new FileInputStream(
//				"c:/Apps/RMG_Allocation_Report_Unique-Nov24.xlsx");
		FileInputStream fis = new FileInputStream("c:/Apps/Memberwise_HR_Details - 7th April 2014.xlsx");
		XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);
		Iterator<Row> rowIterator = mySheet.iterator();
		Row row = rowIterator.hasNext() ? rowIterator.next() : null;
		;
		MemberExt memberExt;
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
//			System.out.println(HSSFDateUtil.getJavaDate((Double) getCellValue(row.getCell(2))));
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			memberExt = new MemberExt();
			memberExt.setContact((String)getCellValue(row.getCell(1)));
//			memberExt.setDateOfJoining(HSSFDateUtil.getJavaDate((Double) getCellValue(row.getCell(2))));
			memberExt.setDesignation((String)getCellValue(row.getCell(3)));
			memberExt.setEmployeeId((String)getCellValue(row.getCell(4)));
			memberExt.setGender(getCellValue(row.getCell(5)).toString().charAt(0));
			memberExt.setLastUpdateDate(Calendar.getInstance());
			memberExt.setLastUpdateUID("KSK");
			memberExt.setMemberEmail((String)getCellValue(row.getCell(8)));
			memberExt.setQualification((String)getCellValue(row.getCell(9)));
			memberExt.setRmEmail((String)getCellValue(row.getCell(10)));
			memberExt.setRmId((String)getCellValue(row.getCell(11)));
			memberExt.setRowVersionNumber(1);
			memberExt.setTitleGroup(((Double)getCellValue(row.getCell(13))).toString());
			session.save(memberExt);
			memberExt = null;
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
