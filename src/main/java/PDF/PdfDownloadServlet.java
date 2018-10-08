package PDF;

import com.sun.xml.internal.messaging.saaj.util.Base64;
import org.json.JSONObject;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/downloadPdfFromDatabase")
public class PdfDownloadServlet extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException{

        String img64str = "null";
        Blob image = null;
       String searchId = request.getParameter("param");
        try {


            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://54.93.65.5:5432/gabo8", "fasttrackit_dev", "fasttrackit_dev");
            PreparedStatement pSt = conn.prepareStatement("SELECT file FROM booklet WHERE id ="+searchId);
            ResultSet result = pSt.executeQuery();


            //Ergebniss zur�ckliefern
            while (result.next()) {
                System.out.println("while");
                image = result.getBlob("file");
                InputStream binaryStream = image.getBinaryStream(1, image.length());

                int ch;

//read bytes from ByteArrayInputStream using read method
                String str= binaryStream.toString();
                byte[] bdata=str.getBytes();
                byte[] img64 = Base64.encode(bdata);
                img64str = new String(img64);


            }


        } catch (Exception e) {

        }
        response= img64str;
    }


}
