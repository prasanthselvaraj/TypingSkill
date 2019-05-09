package com.pgx.java.web;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;


@Controller
public class MyController {

	public static final String headLine = "CHECK YOUR TYPING ABILITY";
	HeadlineStatement headlineStatement = new HeadlineStatement(); 
	
	@RequestMapping("/Hello")
	public String helloView(Model model) {
		headlineStatement.setTitle(headLine);
		model.addAttribute("headline", headlineStatement);
		return "HelloWorld";
	}

	@RequestMapping("/StartPage")
	public String StartPage(Model model) {
		String exception = "";
		String paraString = "";
		try {
			Path scriptPath = Paths.get("D:/TypingScript.txt");
			Charset charset = Charset.forName("ISO-8859-1");
			List<String> linesList = Files.readAllLines(scriptPath, charset);
			paraString = linesList.get(0);
		} catch (IOException ioexception) {
			exception = "io";
		} catch (FileSystemNotFoundException fileFound) {
			exception = "fnf";
		} finally{
			if(exception.equalsIgnoreCase("io") || 
					exception.equalsIgnoreCase("fnf")) {
				System.out.println("--->> " + "io/fnf error" );
			} else {
				headlineStatement.setPara(paraString);
				headlineStatement.setDialogSentence("Timer Starts on OK click");
				model.addAttribute("start", headlineStatement);
			}
		}
		return "StartPage";
	}
	
	@RequestMapping("/GameEnds")
	@ResponseBody
	public String ajaxcall() {
		Gson gson = new Gson();
	    Map<String, String> stateMap = new HashMap<>();
	    stateMap.put("dialogState", "Timer stops");
		return gson.toJson(stateMap);
	}
	
	@RequestMapping("/loginVerification")
	@ResponseBody
	public String loginVerification(@RequestBody String jsonData) {
		Gson gson = new Gson();
		Map<String, String> jMap = gson.fromJson(jsonData, Map.class);
	    Map<String, String> stateMap = new HashMap<>();
	    stateMap.put("dialogState", "Timer stops");
		return gson.toJson(stateMap);
	}
	
	@RequestMapping("/EndPage")
	public String EndPage(Model model) {
		return "EndPage";
	}
}