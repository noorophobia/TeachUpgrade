<!DOCTYPE html>
<html>
<body>
<h1>HTML DOM Events</h1>
<h2>The onplay Event</h2>

<p>Assign an "onplay" event to a video element.</p>

<p>Press play.</p>

<video controls onplay="myFunction()">
  <source src="mov_bbb.mp4" type="video/mp4">
  <source src="mov_bbb.ogg" type="video/ogg">
  Your browser does not support HTML5 video.
</video>

<p>Video courtesy of <a href="https://www.bigbuckbunny.org/" target="_blank">Big Buck Bunny</a>.</p>

<p id="demo"></p>

<script>
function myFunction() {
  document.getElementById("demo").innerHTML = "The video has started to play";
}
</script>


</body>
</html>
