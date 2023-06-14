package com.infosys.product.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.infosys.product.model.EmployeeModel;
import com.infosys.product.service.ImportExcelService;
import com.infosys.product.validater.ImportExcelValidator;




@RestController
@RequestMapping("/company")
public class ImportExcelController {
    @Autowired
	ImportExcelValidator validator;
    ImportExcelService service;
    
    private static final String FILE_NAME = "D:\\Employee_list.xlsx";
    
    
    @RequestMapping(method=RequestMethod.POST, value="/employeelist")
    @Produces(MediaType.APPLICATION_JSON)
	  public List<EmployeeModel> getList() throws IOException {
    	 //FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
    	 
    	
    	    //XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
			//XSSFSheet worksheet = workbook.getSheetAt(0);
    	  File excel = new File(FILE_NAME);
		  List<EmployeeModel> list=validator.getList(excel);
		
		  return list;
		  
	  }
}
