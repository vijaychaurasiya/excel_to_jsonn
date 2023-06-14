package com.infosys.product.validater;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.infosys.product.model.EmployeeModel;
import com.infosys.product.service.ImportExcelService;

@Component
public class ImportExcelValidator {
    @Autowired
	ImportExcelService service;
	
	public List<EmployeeModel> getList(File excel) {
		FileInputStream fileInputStream = null;
        Workbook workbook = null;
        try {
            // Creating file input stream
        	fileInputStream = new FileInputStream(excel);
 
            String filename = excel.getName().toLowerCase();
            if (filename.endsWith(".xls") || filename.endsWith(".xlsx")) {
                // creating workbook object based on excel file format
                if (filename.endsWith(".xls")) {
                    workbook = new HSSFWorkbook(fileInputStream);
                } 
                else {
                    workbook = new XSSFWorkbook(fileInputStream);
                }
                Sheet sheet = workbook.getSheetAt(0);
                
                //System.out.println(sheet.getRow(1).getPhysicalNumberOfCells());
                if(sheet.getRow(1).getPhysicalNumberOfCells()!=5 || sheet.getPhysicalNumberOfRows()<=1){
                	throw new IllegalArgumentException("Invalid or blank file");        			
                }
                else {
                	return service.getList(sheet);
                }
            }
                else {
                throw new IllegalArgumentException("File format not supported.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                	fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
        }
	

}

