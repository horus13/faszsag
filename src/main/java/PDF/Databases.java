package PDF;

import javax.servlet.ServletException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;



public class Databases {


    private final String url = "jdbc:postgresql://54.93.65.5:5432/gabo8";
    private final String user = "fasttrackit_dev";
    private final String password = "fasttrackit_dev";


    public int register (String title, String author, InputStream file) {

        int found = -1;

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://54.93.65.5:5432/gabo8", "fasttrackit_dev", "fasttrackit_dev");
            PreparedStatement pSt = conn.prepareStatement("INSERT INTO booklet (title, author, file) VALUES (?,?,?)");



            pSt.setString(1, title);
            pSt.setString(2, author);
            pSt.setBinaryStream(3, file);
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

        List<Pdf> Pdfs = new ArrayList<Pdf>();
        try {


            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://54.93.65.5:5432/gabo8", "fasttrackit_dev", "fasttrackit_dev");
            PreparedStatement pSt = conn.prepareStatement("SELECT * FROM booklet");
            ResultSet result = pSt.executeQuery();

            while (result.next()) {
                // gets file name and file blob data


                Pdf currentPdf = new Pdf();currentPdf.setId(result.getString("id"));
                currentPdf.setTitle(result.getString("title"));
                currentPdf.setAuthor(result.getString("author"));
                Pdfs.add(currentPdf);

            }

        } catch (Exception e) {

        }


        return Pdfs;
    }


}