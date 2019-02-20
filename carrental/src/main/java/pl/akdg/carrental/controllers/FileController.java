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
	
	@RequestMapping("/maluch")
	@ResponseBody
	public void showCar1(HttpServletResponse response) throws IOException {
		File file= new File(getClass().getClassLoader().getResource("/WEB-INF/templates/static/img/maluch.jpg").getFile());
		InputStream inputStream=new FileInputStream(file);
		response.setContentType("image/jpeg");
		response.setContentLengthLong(file.length());
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
	@RequestMapping("/poldek")
	@ResponseBody
	public void showCar2(HttpServletResponse response) throws IOException {
		File file= new File(getClass().getClassLoader().getResource("/WEB-INF/templates/static/img/polonez.jpg").getFile());
		InputStream inputStream=new FileInputStream(file);
		response.setContentType("image/jpeg");
		response.setContentLengthLong(file.length());
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
	@RequestMapping("/ferrari")
	@ResponseBody
	public void showCar3(HttpServletResponse response) throws IOException {
		File file= new File(getClass().getClassLoader().getResource("/WEB-INF/templates/static/img/testarossa.jpg").getFile());
		InputStream inputStream=new FileInputStream(file);
		response.setContentType("image/jpeg");
		response.setContentLengthLong(file.length());
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
}
