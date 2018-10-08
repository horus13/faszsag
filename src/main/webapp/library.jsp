<%@ page import="java.util.List" %>
<%@ page import="PDF.Pdf" %>
<%@ page import="PDF.Databases" %>
<html lang="en" >

<head>
    <meta charset="UTF-8">
    <title>PDF List</title>




</head>

<body>

    <%
        List<Pdf> pdfs = new Databases().getPdf();
        for (Pdf pdf : pdfs) {
    %>
<div class="pdf-file">
    <a href="downloadPdfFromDatabase?param=<%=pdf.getId()%>"><%=pdf.getTitle()%></a>
    <span><%=pdf.getAuthor()%></span>


</div>
    <%
        }
    %>



</body>

</html>