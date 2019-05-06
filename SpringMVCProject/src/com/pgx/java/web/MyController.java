package com.pgx.java.web;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@RequestMapping("/ajaxcall")
	@ResponseBody
	public String ajaxcall() {
		Gson gson = new Gson();
		return gson.toJson("okokookokkoko");
	}
}