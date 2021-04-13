package p08_JList.repository;

import p08_JList.model.Person;

import java.sql.*;
import java.util.ArrayList;

public class PersonRepository {
    private Connection con;

    public PersonRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_persons","root", "root");
        }
        catch(ClassNotFoundException cnf) {
            System.out.println("JDBC Driver not found");
        }
        catch(SQLException se) {
            System.out.println("Connection to DB failed");
        }
    }

    public ArrayList<Person> all() {
        ArrayList<Person> persons = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM persons");
            while(rs.next()) {
                Person person = new Person(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("company"));
                persons.add(person);
            }
        }
        catch(SQLException se) {
            System.out.println("SQL problem");
        }
        return persons;
    }

    public Person addNew(String name, String company) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO persons (name, company) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, name);
            pst.setString(2, company);
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next()) {
                int id = rs.getInt(1);
                Statement st = con.createStatement();
                ResultSet rset = st.executeQuery("SELECT * FROM persons WHERE id=" + id);
                if(rset.next()) {
                    Person person = new Person(rset.getInt("id"),
                            rset.getString("name"),
                            rset.getString("company"));
                    return person;
                }
            }
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    public void delete(int id) {
        try {
            Statement st = con.createStatement();
            st.execute("DELETE FROM persons WHERE id=" + id);
        }
        catch(SQLException se) {
            se.printStackTrace();
        }
    }
}
