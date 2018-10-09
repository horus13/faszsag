<%@ page import="java.util.List" %>
<%@ page import="PDF.Pdf" %>
<%@ page import="PDF.Databases" %>
<html lang="en" >

<head>

    <meta charset="UTF-8">
    <title>PDF List</title>

    <link rel="stylesheet" href="library.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">




</head>

<body>

  <header>
    <h1>Library</h1>
  </header>
  <div class="space"></div>

    <%
        List<Pdf> pdfs = new Databases().getPdf();
        for (Pdf pdf : pdfs) {
    %>

  <div class="pdf-file">
      <a href="downloadPdfFromDatabase?param=<%=pdf.getId()%>" id="link"><i class="far fa-file-pdf"></i><p><%=pdf.getTitle()%></p>
          <br>
          <label>Autor: </label><span><%=pdf.getAuthor()%></span>
      </a>
  </div>




    <%
        }
    %>



</body>

</html>
