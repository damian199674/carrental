package pl.akdg.carrental.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/file")
public class FileController {
	
	@RequestMapping("/download")
	@ResponseBody
	public void downloadFile(HttpServletResponse response) throws IOException {
		File file= new File(getClass().getClassLoader().getResource("/maluch.jpg").getFile());
		InputStream inputStream=new FileInputStream(file);
		response.setContentType("image/jpeg");
		response.setContentLengthLong(file.length());
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
}
