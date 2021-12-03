package sample;


import java.sql.*;
import java.util.ArrayList;


public class SqlSearcherObject {

    static String USER = "root";
    static String PASS = "root";
    static String DB_URL = "jdbc:mysql://localhost:3306/itsgame";
    final String emptyspace = " ";


    public SqlSearcherObject() {
    }

    public String updateClt(String Text1, int boolean1, int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Updating the thing");
        PreparedStatement preparedstatement = conn.prepareStatement("UPDATE  itsgame.checklisttemplate SET description=? ,type=? where id=?");
        preparedstatement.setString(1, Text1);
        preparedstatement.setInt(2, boolean1);
        preparedstatement.setInt(3, id);
        preparedstatement.executeUpdate();
        System.out.println("Updating the thing");
        conn.close();
        System.out.println("Thing uploaded!");
        return "Updated Thing in checklisttemplate on id=" + id;
    }

    public String insertCLT(String Text1, int boolean1) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Uploading the thing");
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO itsgame.checklisttemplate (description, type) VALUES (?, ?)");
        preparedStatement.setString(1, Text1);
        preparedStatement.setInt(2, boolean1);
        preparedStatement.executeUpdate();
        System.out.println("Uploading the thing");
        conn.close();
        System.out.println("Thing uploaded!");
        return " Thing uploaded to checklisttemplate  ";
    }

    public String insertTF(String Text1) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Uploading the thing");
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO itsgame.time_frame (name) VALUES (?)");
        preparedStatement.setString(1, Text1);
        preparedStatement.executeUpdate();
        System.out.println("Uploading the thing");
        conn.close();
        System.out.println("Thing uploaded!");
        return " Thing uploaded to time_frame ";
    }
    //  "UPDATE  itsgame.checklisttemplate SET description=? ,type=? where id=?"

    public String updateTF(String Text1, int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Updating the thing");
        PreparedStatement preparedStatement = conn.prepareStatement("update itsgame.time_frame set name=? where id=?");
        preparedStatement.setString(1, Text1);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        System.out.println("Updating the thing");
        conn.close();
        System.out.println("Thing uploaded!");
        return " Updated time_frame on id=" + id;
    }

    public String insertCLIT(String description, int CheckListID, int timeDropdown, int boolean1) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Uploading the thing");
        if (crossreference("clt", String.valueOf(CheckListID)) && crossreference("tf", String.valueOf(timeDropdown))) {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO itsgame.checklist_item_template (description, checklist_id, time_dropdown, active  ) VALUES (?,?,?,?)");
            preparedStatement.setString(1, description);
            preparedStatement.setInt(2, CheckListID);
            preparedStatement.setInt(3, timeDropdown);
            preparedStatement.setInt(4, boolean1);
            preparedStatement.executeUpdate();
            System.out.println("Uploading the thing");
            conn.close();
            System.out.println("Thing uploaded!");
        }
        return " Uploaded to Check List Item Template ";
    }

    public String updateCLIT(String description, int boolean1, int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Uploading the thing");
        PreparedStatement preparedStatement = conn.prepareStatement("update itsgame.checklist_item_template set description=? , active=? where id=? ");
        preparedStatement.setString(1, description);
        preparedStatement.setInt(2, boolean1);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
        System.out.println("Updating the thing");
        conn.close();
        System.out.println("Thing updated!");

        return " Updated Check List Item Template on id=" + id;
    }

    public String insertEmployee(String firstname, String lastname) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Uploading the thing");

        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO itsgame.employee (firstname, lastname ) VALUES (?,?)");
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, lastname);
        preparedStatement.executeUpdate();
        System.out.println("Uploading the thing");
        conn.close();
        System.out.println("Thing uploaded!");

        return " Thing uploaded to Employee";
    }

    public String updateEmployee(String firstname, String lastname, int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Uploading the thing");

        PreparedStatement preparedStatement = conn.prepareStatement("update  itsgame.employee  set firstname=?, lastname=? where id=?");
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
        System.out.println("Uploading the thing");
        conn.close();
        System.out.println("Thing uploaded!");

        return " Updated Employee on id=" + id;
    }


    public String insertEmployeeChecklist
            (int employeeid, int ischecked, String description, int check_list_id, String time_Dropdown) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Uploading the thing");
        if (crossreference("emp", String.valueOf(employeeid))) {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO itsgame.employee_check_list (employeeid, ischecked, description, check_list_id, time_dropdown  ) VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, employeeid);
            preparedStatement.setInt(2, ischecked);
            preparedStatement.setString(3, description);
            preparedStatement.setInt(4, check_list_id);
            preparedStatement.setString(5, time_Dropdown);
            preparedStatement.executeUpdate();
            System.out.println("Uploading the thing");
            conn.close();
            System.out.println("Thing uploaded!");
        }
        return " Thing uploaded to Employee Checklist ";
    }

    public String updateEmployeeChecklist
            (int ischecked, String description, String time_Dropdown, int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Uploading the thing");
        {
            PreparedStatement preparedStatement = conn.prepareStatement("update itsgame.employee_check_list set  ischecked=? , description=? ,  time_dropdown=? where id=?  ");
            preparedStatement.setInt(1, ischecked);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, time_Dropdown);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            System.out.println("Uploading the thing");
            conn.close();
            System.out.println("Thing uploaded!");
        }
        return " Thing uploaded to Employee Checklist ";
    }

    public String deleteECL(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM itsgame.employee_check_list where id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        conn.close();
        return "Deleted from employee_check_list";
    }

    public String deletetf(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM itsgame.time_frame where id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        conn.close();
        return "Deleted from time_frame";
    }

    public String deleteEMP(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM itsgame.employee where id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        conn.close();
        return "Deleted from employee";
    }

    public String deleteCLT(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM itsgame.checklisttemplate where id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        conn.close();
        return "Deleted from employee_check_list";
    }

    public String deleteCLIT(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM itsgame.checklist_item_template where id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        conn.close();
        return "Deleted from employee_check_list";
    }


    public String pullCLIT(int id) throws SQLException {
        StringBuilder stringBuilder1 = new StringBuilder();

        SixItemHolder bag = new SixItemHolder();
        bag.setText1(String.valueOf(id));
        if (bag.getText1().equals("-8008135")) {
            bag.setText2("select * from itsgame.check_list_item_template");
        } else {
            bag.setText2("select * FROM itsgame.checklist_item_template where id=?");
        }
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement(bag.getText2());
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        stringBuilder1.append(" id / description / checklist_id / time_dropdown / active  ");
        while (rs.next()) {
            stringBuilder1.append("\n " + rs.getInt(1)
                    + emptyspace + rs.getString(2) + emptyspace + rs.getInt(3)
                    + emptyspace + rs.getString(4) + emptyspace+ rs.getInt(5));
        }
        conn.close();

        return String.valueOf(stringBuilder1);
    }

    public String pullCLTnoITEMS(int id) throws SQLException {
        StringBuilder stringBuilder1 = new StringBuilder();

        SixItemHolder bag = new SixItemHolder();
        bag.setText1(String.valueOf(id));
        if (bag.getText1().equals("-8008135")) {
            bag.setText2("select * from itsgame.checklisttemplate");
        } else {
            bag.setText2("select * FROM itsgame.checklisttemplate where id=?");
        }
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement(bag.getText2());
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        stringBuilder1.append(" id / description / type ");
        while (rs.next()) {
            stringBuilder1.append("\n " + rs.getInt(1)
                    + emptyspace + rs.getString(2) + emptyspace + rs.getInt(3)
                    );
        }
        conn.close();

        return String.valueOf(stringBuilder1);
    }

    public String pullEmployee(int id) throws SQLException {
        StringBuilder stringBuilder1 = new StringBuilder();

        SixItemHolder bag = new SixItemHolder();
        bag.setText1(String.valueOf(id));
        if (bag.getText1().equals("-8008135")) {
            bag.setText2("select * from itsgame.employee");
        } else {
            bag.setText2("select * FROM itsgame.employee where id=?");
        }
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement(bag.getText2());
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        stringBuilder1.append(" id / first name / last name  ");
        while (rs.next()) {
            stringBuilder1.append("\n " + rs.getInt(1)
                    + emptyspace + rs.getString(2) + emptyspace + rs.getString(3)
            );
        }
        conn.close();

        return String.valueOf(stringBuilder1);
    }

    public String pullEmployeeCheckListECL(int id) throws SQLException {
        StringBuilder stringBuilder1 = new StringBuilder();

        SixItemHolder bag = new SixItemHolder();
        bag.setText1(String.valueOf(id));
        if (bag.getText1().equals("-8008135")) {
            bag.setText2("select * from itsgame.employee_check_list");
        } else {
            bag.setText2("select * FROM itsgame.employee_check_list where id=?");
        }
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement(bag.getText2());
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        stringBuilder1.append(" id / description / type ");
        while (rs.next()) {
            stringBuilder1.append("\n " + rs.getInt(1)
                    + emptyspace + rs.getString(2) + emptyspace + rs.getInt(3)
            );
        }
        conn.close();

        return String.valueOf(stringBuilder1);
    }

    public String pullTimeFrameTF(int id) throws SQLException {
        System.out.println(id);
        StringBuilder stringBuilder1 = new StringBuilder();

       // SixItemHolder bag = new SixItemHolder();
       // bag.setText1(String.valueOf(id));

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement preparedStatement = conn.prepareStatement("select * FROM itsgame.time_frame where id=?");
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        stringBuilder1.append(" id / name ");
        while (rs.next()) {
            stringBuilder1.append("\n " + rs.getInt(1) + emptyspace + rs.getString(2));
        }
        conn.close();

        return String.valueOf(stringBuilder1);
    }
    // I encountered a bug with the MYSQL software I was using and It wouldn't let me use Foreign Keys,
    // therefore so this and the ticket class are an adhoc solution
    // in a team environment I would ask somebody for help to properly use foreign keys for better performance
    public Boolean crossreference
    (String destination, String id1) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<Ticket> arrayList1 = new ArrayList();

        Statement stmt = conn.createStatement();
        if (destination.equals("clt")) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM itsgame.checklisttemplate");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                arrayList1.add(new Ticket(rs.getString("id")));
            }
            conn.close();
        } else if (destination.equals("tf")) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM itsgame.time_frame");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                arrayList1.add(new Ticket(rs.getString("id")));
            }
            conn.close();
        } else if (destination.equals("emp")) {
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM itsgame.employee");

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                arrayList1.add(new Ticket(rs.getString("id")));
            }
            conn.close();
        }


        for (int i = 0; i < arrayList1.size(); i++) {
            if (arrayList1.get(i).getNumber().equals(id1)) {
                return true;
            } else return false;
        }
        return false;
    }





}