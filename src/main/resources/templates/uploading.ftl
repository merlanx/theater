<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Uploading Files</title>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/ui-darkness/jquery-ui.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/site.css"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body onload="updateSize();">
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand">Merlan Movie Theater</a>
        </div>
    </div>
</nav>
<div class="container">
    <div class="page-header">
        <h1>Welcome to File Loading Page</h1>
    </div>
    <div  class="input-group">
        <form name="uploadingForm" enctype="multipart/form-data" action="/upload/uploaded" method="POST">
            <p>
                <input id="fileInput" value = "Select csv files" type="file" name="uploadingFiles" onchange="updateSize();" multiple>
                selected files: <span id="fileNum">0</span>;
                total size: <span id="fileSize">0</span>
            </p>
            <p>
                <input type="submit" value="Upload csv files">
            </p>
        </form>
    </div>
    <div>
        <div>Uploaded files:</div>
    <#list files as file>
        <div>
        ${file.getName()}
        </div>
    </#list>
    </div>
</div>
<footer class="footer navbar-inverse navbar-fixed-bottom">
    <div class="container">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4"><p class="text-muted">@Copyright 2017 Meilan Xie</p></div>
        </div>
    </div>
</footer>
<script>
    function updateSize() {
        var nBytes = 0,
                oFiles = document.getElementById("fileInput").files,
                nFiles = oFiles.length;
        for (var nFileId = 0; nFileId < nFiles; nFileId++) {
            nBytes += oFiles[nFileId].size;
        }

        var sOutput = nBytes + " bytes";
        // optional code for multiples approximation
        for (var aMultiples = ["KiB", "MiB", "GiB", "TiB", "PiB", "EiB", "ZiB", "YiB"], nMultiple = 0, nApprox = nBytes / 1024; nApprox > 1; nApprox /= 1024, nMultiple++) {
            sOutput = nApprox.toFixed(3) + " " + aMultiples[nMultiple] + " (" + nBytes + " bytes)";
        }
        // end of optional code

        document.getElementById("fileNum").innerHTML = nFiles;
        document.getElementById("fileSize").innerHTML = sOutput;
    }
</script>

<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/site.js"></script>
</body>
</html>