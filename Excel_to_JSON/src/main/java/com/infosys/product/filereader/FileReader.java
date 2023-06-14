package com.infosys.product.filereader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

//@Component
public class FileReader {
	
   //private static final String FILE_NAME1 = "D:\\Employee_list.xlsx";
    
    public Sheet getSheet(String FILE_NAME){
    	File excel = new File(FILE_NAME);
        FileInputStream fileInputStream = null;
        Workbook workbook = null;
        // Creating file input stream
    	try {
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
            return sheet;
        }
        else {
        	throw new IllegalArgumentException("File format not supported."); 
        }
    	}
        catch (Exception e) {
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


