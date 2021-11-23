package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class SqlRobot {

    static String USER = "root";
    static String PASS = "root";
    static String DB_URL = "jdbc:mysql://localhost:3306/z2";

    // crud

    public SqlRobot() {
    }


    public String insertCLT(String Text1, int boolean2) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Uploading the thing");
        PreparedStatement bullet1 = conn.prepareStatement("INSERT INTO titsgame.questions (description, type) VALUES (?, ?)");
        bullet1.setString(1, Text1);
        bullet1.setInt(2, boolean2);
        bullet1.executeUpdate();
        System.out.println("Uploading the thing");
        conn.close();
        System.out.println("Thing uploaded!");
        return " Thing uploaded! ";
    }

    public String insertCLT(String Text1, int boolean2) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Uploading the thing");
        PreparedStatement bullet1 = conn.prepareStatement("INSERT INTO titsgame.questions (description, type) VALUES (?, ?)");
        bullet1.setString(1, Text1);
        bullet1.setInt(2, boolean2);
        bullet1.executeUpdate();
        System.out.println("Uploading the thing");
        conn.close();
        System.out.println("Thing uploaded!");
        return " Thing uploaded! ";
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
            PreparedStatement bullet1 = conn.prepareStatement("SELECT * FROM titsgame.checklistemplate");

            ResultSet rs = bullet1.executeQuery();
            while (rs.next()) {
                arrayList1.add(new Ticket(rs.getString("id")));
            }
            conn.close();
        }
        else if (destination.equals("tf"))
        {
            PreparedStatement bullet1 = conn.prepareStatement("SELECT * FROM titsgame.time_frame");

            ResultSet rs = bullet1.executeQuery();
            while (rs.next()) {
                arrayList1.add(new Ticket(rs.getString("id")));
            }
            conn.close();
        }
        else if (destination.equals("emp"))
        {
            PreparedStatement bullet1 = conn.prepareStatement("SELECT * FROM titsgame.employee");

            ResultSet rs = bullet1.executeQuery();
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

    public String pull_QUESTION(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<String> arrayList1 = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement bullet1 = conn.prepareStatement("SELECT Text FROM titsgame.questions WHERE id = ?");
        bullet1.setInt(1, id);
        ResultSet rs = bullet1.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("Text"));
            arrayList1.add(rs.getString(1));
        }
        conn.close();
        return arrayList1.get(0);

    }




    public String pull_SITUATION(int id) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<String> arrayList1 = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement bullet1 = conn.prepareStatement("SELECT Text FROM titsgame.situations WHERE id = ?");
        bullet1.setInt(1, id);
        ResultSet rs = bullet1.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("Text"));
            arrayList1.add(rs.getString(1));
        }
        conn.close();
        return arrayList1.get(0);
    }


    public int questSIZE() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<Integer> arrayList1 = new ArrayList();
        Statement stmt = conn.createStatement();
        PreparedStatement bullet1 = conn.prepareStatement("SELECT COUNT(id) FROM titsgame.questions");

        ResultSet rs = bullet1.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1));
            arrayList1.add(rs.getInt(1));
        }

        conn.close();

        return arrayList1.get(0);
    }

    public int sitsSIZE() throws SQLException {
        //   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?user=newuser&password=jojojojo90!");
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ArrayList<Integer> arrayList1 = new ArrayList();

        Statement stmt = conn.createStatement();
        PreparedStatement bullet1 = conn.prepareStatement("SELECT COUNT(id) FROM titsgame.situations");

        ResultSet rs = bullet1.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1));
            arrayList1.add(rs.getInt(1));
        }
        conn.close();
        return arrayList1.get(0);
    }

    public void comboQQQ_BIG_insert(String file, String Creator) throws FileNotFoundException, SQLException {
        File file1 = new File(file);
        Scanner sc = new Scanner(file1);
        ArrayList<String> Bonerstorm = new ArrayList<>();
        while (sc.hasNextLine()) {
            Bonerstorm.add(sc.nextLine());
        }
        big_Questions_INSERT(Bonerstorm, Creator);
    }


    public void big_Questions_INSERT(ArrayList<String> Payload, String Creator) throws SQLException {
        for (int i = 0; i < Payload.size(); i++) {
            insertQUESTION(Payload.get(i), Creator);
        }


    }

    public void big_Situations_INSERT(ArrayList<String> Payload, String Creator) throws SQLException {
        for (int i = 0; i < Payload.size(); i++) {
            insertSituation(Payload.get(i), Creator);
        }
    }

    public void comboSSS_BIG_insert(String file, String Creator) throws FileNotFoundException, SQLException {
        File file1 = new File(file);
        Scanner sc = new Scanner(file1);
        ArrayList<String> Bonerstorm = new ArrayList<>();
        while (sc.hasNextLine()) {
            Bonerstorm.add(sc.nextLine());
        }
        big_Situations_INSERT(Bonerstorm, Creator);
    }


}