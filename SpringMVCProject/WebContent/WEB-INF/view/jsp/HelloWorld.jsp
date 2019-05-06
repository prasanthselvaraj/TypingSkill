<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>
  function loadLogin(){
	 var host = window.location.hostname;
	  var path = window.location.pathname;
	  var pathArr = path.split("/");
	  var protocol = window.location.protocol;
	  var port = window.location.port;
	  var urlForm = protocol.concat("//",host,":",port,"/",pathArr[1],"/StartPage");
	  window.location.href = urlForm;
  }
</script>
<style>
#buttonloginId {
	left: 3em;
	position: absolute;
	top: 13em;
}

.button {
	background-color: #c60eda;
	height: 36px;
	width: 218px;
	cursor: pointer;
	border-radius: 14px;
}

#loginAreaId {
	height: 21em;
	width: 22em;
	position: absolute;
	top: 10em;
	left: 56em;
}

#HeadLineStatement {
	position: absolute;
	height: 50px;
	top: 8em;
	left: 5em;
	font-style: italic;
	font-family: fantasy;
	font-size: xx-large;
}

#loginLabel {
	position: absolute;
	text-shadow: purple;
	color: #c60eda;
	font-size: 21px;
	font-family: fantasy;
	align-content: right;
	left: 128px;
}

::placeholder {
	font-style: italic;
	color: #c60eda;
}

#userDiv {
	position: absolute;
	top: 4em;
	left: 4em;
}

#passDiv {
	position: absolute;
	top: 8em;
	left: 4em;
}

#userInput, #passInput {
	width: 14em;
	border-radius: 24px;
	height: 2em;
}
</style>
</head>
<body>
	<div id="HeadLineStatement">${headline.title}</div>
	<div id="loginAreaId">
		<label id="loginLabel">Login</label>
		<div id="userDiv">
			<input id="userInput" placeholder="User Name"></input>
		</div>
		<div id="passDiv">
			<input id="passInput" placeholder="Password"></input>
		</div>
		<div id="buttonloginId">
		  <button class="button" onClick="loadLogin()">Start</button>
		</div>
	</div>
</body>
</html>
