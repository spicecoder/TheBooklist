package io.pronab.booklist.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class TestBookServiceuCurlExecutor {
	@Test
	public void  testJson() {

		String url = "http://localhost:8080/api/books";
	
		//To do : fix surefire plugin
		
		String[] command = { "curl",  "-X", "GET",
				 "-F", "_charset_=utf-8", url };

		ProcessBuilder process = new ProcessBuilder(command);
		Process p;
		try {
			p = process.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			
			}
			String result = builder.toString();
		//	assert(result.contains("Author"));
		//	assert(result.contains("Title"));
			 

		} catch (IOException e) {
			System.out.print("error");
			e.printStackTrace();
		}
	}
}