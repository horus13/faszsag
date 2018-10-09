package PDF;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/pdf")
public class PdfServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {


        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String file = request.getParameter("file");
        InputStream fileStream = new ByteArrayInputStream(file.getBytes());


        Databases database = new Databases();
        database.register(title, author, fileStream);
        response.sendRedirect("http://localhost:8081/library.jsp");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) {


        System.out.println("getting books");


        List ListaDeObiecte = new ArrayList<Pdf>();

        try {
            ListaDeObiecte = Databases.getPdf();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        JSONObject json = new JSONObject();


        //json.put("pdf", ListaDeObiecte);



        returnJsonResponse(response, json.toString());
    }

    private void returnJsonResponse(HttpServletResponse response, String jsonResponse) {
        response.setContentType("application/json;charset=UTF-8");


        PrintWriter pr = null;
        try {
            pr = response.getWriter();

        } catch (IOException e) {

            e.printStackTrace();

        }

        assert pr != null;
        pr.write(jsonResponse);
        pr.close();

    }


}
