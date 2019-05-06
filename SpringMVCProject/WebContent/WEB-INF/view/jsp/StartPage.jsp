<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
#mainArea {
	-webkit-filter: blur(5px);
	height: 100%;
}

#workingParaId {
	position: absolute;
	width: 50em;
	left: 17em;
	top: 3em;
}

#workingPara {
	font-size: large;
	font-style: italic;
	font-family: sans-serif;
}

#playAreaId {
	position: absolute;
	top: 24em;
	left: 17em;
}

#dialogSpace {
	position: absolute;
	width: 30em;
	height: 13em;
	left: 27em;
	top: 12em;
	border-radius: 25px;
	border-color: chocolate;
	border-style: groove;
}

#dialogArea {
	height: 100%;
	width: 100%;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	background-color: rgba(0, 0, 0, 0.3);
}

#dialogHeader {
	position: absolute;
	font-family: fantasy;
	font-size: larger;
	font-style: oblique;
	background-color: #04c987;
	border-top-left-radius: 23px;
	width: 25em;
	border-top-right-radius: 23px;
}

#dialogBody {
	position: absolute;
	top: 3em;
	width: 25em;
	height: 117px;
	font-family: fantasy;
	font-size: larger;
	font-style: oblique;
	background-color: #dee0df;
}

#dialogFooter {
	position: absolute;
	width: 30em;
	top: 176px;
	height: 32px;
	background-color: #04c987;
	border-bottom-left-radius: 23px;
	border-bottom-right-radius: 23px;
}

#alertMessageId {
	padding: 10px;
	margin: 37px;
}

#okButtonId {
	background-color: #9E9E9E;
	height: 24px;
	width: 106px;
	cursor: pointer;
	border-radius: 15px;
	position: absolute;
	left: 26em;
	top: 4px;
}

#widgetArea {
	position: absolute;
	left: 67em;
	height: 38em;
	width: 17em;
}

#timerArea {
	position: absolute;
	top: 56px;
	left: 12px;
}

#minAea {
	left: 5em;
	position: absolute; height : 52px;
	width: 56px;
	height: 52px;
}

#divId {
	left: 133px;
	bottom: -50px;
	position: absolute;
	height: 52px;
	width: 24px;
}

#secArea {
	left: 10em;
	position: absolute;
	height: 52px;
	width: 56px;
}

#minLabelId {
	
}

#divLabelId {
	
}

#secLabelId {
	
}
</style>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<div id="mainArea">
		<div id="workingParaId">
			<p id="workingPara">${start.para}</p>
		</div>
		<div id="playAreaId">
			<input id="playAreaInput" size="100" />
		</div>
		<div id="widgetArea">
			<div id="timerArea">
				<div id="minAea">
					<label id="minLabelId">1</label>
				</div>
				<div id="divId">
					<label id="divLabelId">:</label>
				</div>
				<div id="secArea">
					<label id="secLabelId">00</label>
				</div>
			</div>
		</div>
	</div>
	<div id="dialogArea">
		<div id="dialogSpace">
			<div id="dialogHeader">
				<h3 align="left">Alert</h3>
			</div>
			<div id="dialogBody">
				<p id="alertMessageId" align="center">${start.dialogSentence}</p>
			</div>
			<div id="dialogFooter" align="right">
				<button id="okButtonId">OK</button>
			</div>
		</div>
	</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script>
	var mainDisplay = document.getElementById('mainArea');
	var diaDisplay = document.getElementById('dialogArea');
	var okButtonClick = document.getElementById('okButtonId');
	okButtonClick.addEventListener("click", gameStarts);
	var minvar = document.getElementById('minLabelId');
	var secvar = document.getElementById('secLabelId');
	var minutes = minvar.innerHTML;
	var seconds = secvar.innerHTML;
	var timer = null;
	function gameStarts(event) {
		diaDisplay.style.display = "none";
		mainDisplay.setAttribute("style", "-webkit-filter: blur(0px)");
		timer = setInterval(function() {
			if (seconds === '00') {
				seconds = '59';
			} else {
				var secDec = (seconds - 1);
				seconds = (secDec === 0) ? '00' : seconds - 1;
				minutes = (secDec === 0) ? minutes - 1 : minutes;
				if (minutes === 0) {
					seconds = '00';
					minutes = '00';
					timeEnds(event);
				}
			}
			minvar.innerText = minutes;
			secvar.innerText = seconds;
		}, 1000);
	}
	function timeEnds(event) {
		minutes.innerText = minutes;
		seconds.innerText = seconds;
		clearInterval(timer);
		<!-- event.preventDefault(); -->
		$.ajax({
			cache : false,
			type : "GET",
			async : false,
			url : "http://localhost:8080/SpringMVCProject/ajaxcall",
			data : "",
			contentType : "application/json",
			dataType : "json",
			processData : true,
			success : function(result) {
				alert("data");
			}
		});
	}
</script>
</html>