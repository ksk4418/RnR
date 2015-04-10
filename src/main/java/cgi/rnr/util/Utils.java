package cgi.rnr.util;

import org.slf4j.LoggerFactory;

import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;

public class Utils {

    private static String HOST = "corp.ad.cginet";
    private static int PORT = 389;
    private static String LOCATION = "CN=";
    private static String GEN = "OU=INDIA,OU=SERVICE ACCOUNTS,OU=ID Mgmt,DC=corp,DC=ad,DC=cginet";
    private static String INDIA = "OU=ASINDIA,OU=USERS,OU=CGI USER ACCOUNTS,OU=ID Mgmt,DC=corp,DC=ad,DC=cginet";
    private static String GIS = "OU=GIS,OU=USERS,OU=CGI USER ACCOUNTS,OU=ID Mgmt,DC=corp,DC=ad,DC=cginet";
    private static String INDIAGIS = "OU=INDIAGIS,OU=USERS,OU=CGI USER ACCOUNTS,OU=ID Mgmt,DC=corp,DC=ad,DC=cginet";
    private static String VP = "OU=USEVP,OU=USERS,OU=CGI USER ACCOUNTS,OU=ID Mgmt,DC=corp,DC=ad,DC=cginet";
    private static String GEORGE = "OU=USSOUTH,OU=USERS,OU=CGI USER ACCOUNTS,OU=ID Mgmt,DC=corp,DC=ad,DC=cginet";
    private static String ATUL = "OU=USIPOD,OU=USERS,OU=CGI USER ACCOUNTS,OU=ID Mgmt,DC=corp,DC=ad,DC=cginet";
    private static String FINANCE = "OU=CORPO,OU=USERS,OU=CGI USER ACCOUNTS,OU=ID Mgmt,DC=corp,DC=ad,DC=cginet";
    public static final int ORACLE = 1;
    public static final int SQLSERVER = 2;
    public static final int DB2 = 3;
    public static final int MYSQL = 4;

    private static final org.slf4j.Logger logger = LoggerFactory
            .getLogger(Utils.class);

    private Utils() {

    }

    public static String getNullValueCheckDB(int dbType) {
        if (dbType == MYSQL)
            return "IFNULL";
        else
            return "IFNULL";
    }

    public static boolean authorize(String userName, String password)
            throws LDAPException {
        LDAPConnection connection = new LDAPConnection();

        connection.connect(HOST, PORT);

        StringBuilder sb1 = new StringBuilder();
        sb1.append(LOCATION).append(userName).append(",").append(GEN);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(LOCATION).append(userName).append(",").append(INDIA);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(LOCATION).append(userName).append(",").append(GIS);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(LOCATION).append(userName).append(",").append(INDIAGIS);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(LOCATION).append(userName).append(",").append(VP);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(LOCATION).append(userName).append(",").append(GEORGE);
        StringBuilder sb7 = new StringBuilder();
        sb7.append(LOCATION).append(userName).append(",").append(ATUL);
        StringBuilder sb8 = new StringBuilder();
        sb8.append(LOCATION).append(userName).append(",").append(FINANCE);

        try {
            connection.bind(LDAPConnection.LDAP_V3, sb1.toString(),
                    password.getBytes("UTF8"));
        } catch (Exception ex) {
            logger.info("", ex);
            try {
                connection.bind(LDAPConnection.LDAP_V3, sb2.toString(),
                        password.getBytes("UTF8"));
            } catch (Exception ex1) {
                try {
                    logger.info("", ex1);
                    connection.bind(LDAPConnection.LDAP_V3, sb3.toString(),
                            password.getBytes("UTF8"));
                } catch (Exception ex2) {
                    logger.info("", ex2);
                    try {
                        connection.bind(LDAPConnection.LDAP_V3, sb4.toString(),
                                password.getBytes("UTF8"));
                    } catch (Exception ex3) {
                        logger.info("", ex3);
                        try {
                            connection.bind(LDAPConnection.LDAP_V3,
                                    sb5.toString(), password.getBytes("UTF8"));
                        } catch (Exception ex4) {
                            logger.info("", ex4);
                            try {
                                connection.bind(LDAPConnection.LDAP_V3,
                                        sb6.toString(),
                                        password.getBytes("UTF8"));
                            } catch (Exception ex5) {
                                logger.info("", ex5);
                                try {
                                    connection.bind(LDAPConnection.LDAP_V3,
                                            sb7.toString(),
                                            password.getBytes("UTF8"));
                                } catch (Exception ex6) {
                                    logger.info("", ex6);
                                    try {
                                        connection.bind(LDAPConnection.LDAP_V3,
                                                sb8.toString(),
                                                password.getBytes("UTF8"));
                                    } catch (Exception ex7) {
                                        logger.info("", ex7);
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public static String getCountry(String ctry) {
        if ("us".equalsIgnoreCase(ctry)) {
            return "USA";
        } else if ("ca".equalsIgnoreCase(ctry)) {
            return "Canada";
        }
        if ("in".equalsIgnoreCase(ctry)) {
            return "India";
        }
        return "";
    }

    public static boolean stringEmpty(String str) {
        if (str == null || str.trim().length() == 0)
            return true;
        return false;
    }

    public static boolean stringEqual(String val1, String val2) {
        if (val1 == null && val2 == null)
            return true;
        if (val1 != null && val2 != null && val1.equals(val2))
            return true;
        return false;
    }
}
