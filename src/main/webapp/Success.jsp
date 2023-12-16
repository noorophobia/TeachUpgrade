<%@page import="Classroom.*"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
 
<%@page import="login.*"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>

 $(function()
{
    $('.card-block').each((index, value) =>
    {
        var title = $(value).find('.card-title').text();
        console.log(title);

        $(value).find('.card-text').each((textIndex, textValue) =>
        {
           var cardtext = $(textValue).text();
           console.log(cardtext);
      });
  });
});
</head>
<body>
<div class="content with-padding col-sm-12 no-border education">
  <div class="card flex-row flex-wrap border-bottom m-3 " style="border:none;">
    <div class="card-header no-border p-0">
      <img src="//placehold.it/115" alt="">
    </div>
    <div class="card-block col-sm-10 no-border p-2">
      <h5 class="card-title m-0 p-0">AAA</h5>
      <p class="card-text m-0 p-0">BE-<span>ECE</span></p>
      <p class="card-text m-0 p-0">June 1994 - Pursuing. <span>Full-Time</span></p>
      <p class="card-text m-0 p-0">AAAA,BBBB</p>
    </div>
    <div>

      <button class="float-right rounded-circle  education-remove ripple-effect "><i class="icon-material-outline-delete text-danger ml-2"></i></button>
      <button class="float-right rounded-circle   ripple-effect "><i class="icon-feather-edit "></i></button>
    </div>
  </div>
  <div class="card flex-row flex-wrap border-bottom m-3 " style="border:none;">
    <div class="card-header no-border p-0">
      <img src="//placehold.it/115" alt="">
    </div>
    <div class="card-block col-sm-10 no-border p-2">
      <h5 class="card-title m-0 p-0">BBB</h5>
      <p class="card-text m-0 p-0">BE-<span>CSE</span></p>
      <p class="card-text m-0 p-0">June 2000 - May 2010. <span>Part-Time</span></p>
      <p class="card-text m-0 p-0">DDDD,CCCC</p>
    </div>
    <div>
      <button class="float-right rounded-circle  education-remove ripple-effect "><i class="icon-material-outline-delete text-danger ml-2"></i></button>
      <button class="float-right rounded-circle   ripple-effect "><i class="icon-feather-edit "></i></button>
    </div>
  </div>

</div></body>
</html>