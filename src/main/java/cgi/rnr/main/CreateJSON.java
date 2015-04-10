package cgi.rnr.main;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

import cgi.rnr.company.Company;
import cgi.rnr.company.Continent;

public class CreateJSON {

	public static void main(String[] args) throws Exception {

		Company company[] = new Company[2];
		company[1] = new Company();
		company[0] = new Company();

		Continent con = new Continent();
con.setContinentName("India");
con.setContinentDispName("Asia P");
		
		CreateJSON json = new CreateJSON();
		json.readClass(company);
		json.readClass(con);
	}

	public void readClass(Object inputClass) throws Exception {

		Object obj1;

		if (inputClass.getClass().isArray()) {
			for (int i = 0; i < Array.getLength(inputClass); i++) {
				obj1 = Array.get(inputClass, i);
				Object obj = Class.forName(obj1.getClass().toString().substring(6,obj1.getClass().toString().length())+ "JSON").newInstance();

				Field fields[] = obj.getClass().getFields();
				System.out.println("Column Lenght" + fields.length);
				for (Field field : fields) {
					System.out.println(field.getName());
					System.out.println(field.get(obj));
				}
			}
			return;
		} else {
			obj1 = inputClass;
		}

		Object obj = Class.forName(
				obj1.getClass().toString()
						.substring(6, obj1.getClass().toString().length())
						+ "JSON").newInstance();

		Field fields[] = obj.getClass().getFields();
		for (Field field : fields) {
			System.err.println(field.getName());
			System.err.println(field.get(obj));
//			System.err.println(obj1.getClass().getMethod("get" + field.getName(), null).invoke(inputClass, null));
		}
	}
}
