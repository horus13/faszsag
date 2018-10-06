<!DOCTYPE html>

<html lang="en" dir="ltr">
<head>
    <link rel="stylesheet" href="pdf.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <meta charset="utf-8">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
    <title>Book Upload</title>
</head>
<body>
<h1>Book Upload</h1>
<form action="pdf" method="Post">
    <div class="inner">
        <div class="bk">
            <label for="Title">Title</label>
            <input type="text" name="BookTitle" value="" placeholder="Enter Title">
        </div>
        <div class="ath">
            <label for="Author">Author</label>
            <input type="text" name="Author" value="" placeholder="Enter Author">
        </div>

        <div class="fl">
            <label for="upload" id="labelupload"><i class="fas fa-upload" id="icoana"></i>Upload PDF</label>
            <input type="file" name="file" value="" id="upload">
        </div>


    </div>
    <div class="send">
        <input type="submit" name="button" value="Submit">
        <input type="reset" name="button" value="Reset">
    </div>


</form>

</body>
</html>
