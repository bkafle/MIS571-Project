package ovh.mis571.constant;

/**
 * SQL commands
 * Including select/delete/update/insert
 */

public abstract class SQLCommand 
{
	public static String appnt = "update appnt set start_date=? where pnt_id=?";
	public static String patient_insert = "insert into pnt(first_name,last_name,gender,dob,address,city,phone) values(?,?,?,?,?,?,?)";
	public static String payment_insert = "insert into pmnt(bill_id,paid_amt,pmnt_method,pmnt_date) values(?,?,?,?)";

    /**
     * Patient Queries
     */
	public static String patient_my_info =
            "select firstName, lastName, gender, DOB from PNT where firstname like 'Je%'";

    public static String patient_my_appt =
            "  SELECT STARTDATE, EMP.FirstName, EMP.LastName, Emptype_cd \n" +
                    "  FROM PNT, APPNT, EMP\n" +
                    "  WHERE PNT.Pnt_id = APPNT.Pnt_id and EMP.Emp_id = APPNT.Emp_id and PNT.PNT_id = 1000000;";

    /**
     * Doctor Queries
     */
    public static String doctor_my_info =
            "SELECT firstName, lastName, Dept_cd, Emptype_cd\n" +
                    "FROM EMP\n" +
                    "WHERE EMP_id = 112;";

    public static String doctor_my_appt =
            "SELECT Pnt_id, firstName, lastName, STARTDATE \n" +
                    "FROM APPNT, EMP \n" +
                    "WHERE APPNT.Emp_id = EMP.Emp_id and EMP.Emp_id = 117\n" +
                    "order BY STARTDATE desc;\n";

    public static String doctor_view_patient_details =
            "SELECT DISTINCT PNT.firstName, PNT.lastName, gender, DOB\n" +
                    "FROM EMP, APPNT, PNT\n" +
                    "WHERE APPNT.Emp_id = EMP.Emp_id and APPNT.Pnt_id = PNT.Pnt_id;";

    public static String doctor_view_patient_diagnosis =
            "SELECT PNT_DGNS.Pnt_id, DGNS.Dgns_desc\n" +
                    "FROM PNT_DGNS, DGNS\n" +
                    "WHERE PNT_DGNS.Dgns_id = DGNS.Dgns_id\n" +
                    "AND PNT_DGNS.Pnt_id = '1000000';\n";

    public static String doctor_view_patient_tests =
            "SELECT PNT.firstName, PNT.gender, TEST.test_desc, PNT_TEST.Date\n" +
                    "FROM PNT_TEST, PNT, TEST\n" +
                    "WHERE PNT_TEST.Pnt_id = PNT.Pnt_id and PNT_TEST.Test_id = TEST.Test_id\n" +
                    "AND PNT.Pnt_id = '1000000';\n";

    public static String doctor_view_patient_treatment =
            "SELECT PNT.firstName, PNT.Pnt_id, PNT_TNT.Date, TNT.Tnt_desc\n" +
                    "FROM PNT_TNT, TNT, PNT\n" +
                    "WHERE PNT_TNT.Tnt_id = TNT.Tnt_id and PNT.Pnt_id = PNT_TNT.Pnt_id\n" +
                    "AND PNT.Pnt_id = '1000000';\n";

    /**
     * Admin Queries
     */
    public static String all_patients = "select * from PNT";




    public static String QUERY_31 = "select * from bill";
    public static String QUERY_41 = "select top 10 * from empl";
    public static String QUERY_51 = "select * from PNT where firstname like 'J%";
    public static String QUERY_61 = "select * from PNT where firstname like 'J%";
    public static String QUERY_7 = "select * from PNT where firstname like 'J%";



}
