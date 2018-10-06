package PDF;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;



public class Databases {


    private final String url = "jdbc:postgresql://54.93.65.5:5432/gabo8";
    private final String user = "fasttrackit_dev";
    private final String password = "fasttrackit_dev";


    public int register (String title, String author, String location) {

        int found = -1;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://54.93.65.5:5432/gabo8", "fasttrackit_dev", "fasttrackit_dev");
            PreparedStatement pSt = conn.prepareStatement("INSERT INTO Library (title, author, location) VALUES (?,?,?)");
            pSt.setString(1, title);
            pSt.setString(2, author);
            pSt.setString(3, location);
            int rowsInserted = pSt.executeUpdate();
            pSt.close();
            conn.close();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();

        }
        return found;
    }
    public static List<Pdf> getPdf() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://54.93.65.5:5432/gabo8", "fasttrackit_dev", "fasttrackit_dev");
        Statement st = conn.createStatement();
        String query = "SELECT * FROM Library";

        ResultSet rs = st.executeQuery(query);

        List ListaDeObiecte = new ArrayList<Pdf>();
        while (rs.next()) {
            String title = rs.getString("title").trim();
            String author = rs.getString("author").trim();
            String location = rs.getString("location").trim();
            long id = rs.getLong("id");
            Pdf p = new Pdf();
            p.books = id;
            p.title = title;
            p.author= author;
            p.file = location;
            ListaDeObiecte.add(p);
        }


        rs.close();
        st.close();
        conn.close();
        return ListaDeObiecte;

    }


}