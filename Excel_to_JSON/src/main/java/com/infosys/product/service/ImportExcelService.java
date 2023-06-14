package com.infosys.product.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.infosys.product.model.EmployeeModel;

@Service
public class ImportExcelService {
	@Autowired
	EmployeeModel employeeModel;

	public List<EmployeeModel> getList(Sheet sheet) {
		List<EmployeeModel> list=new ArrayList<>();
		 Iterator<Row> rowIterator = sheet.iterator(); //create a cursor called iterator to all rows in sheet
	        Row currentRow ;
	        Cell currentCell;
	        //to travel into the Excel spreadsheet
	        //System.out.println(currentRow.getCell(0));
	        rowIterator.hasNext();
	        while(rowIterator.hasNext())    {
	        	currentRow = rowIterator.next();
	        	//System.out.println(currentRow.getCell(0).get);
	            //Cursor points to row
	        	employeeModel.setEmpid(currentRow.getCell(0).getStringCellValue());
	        	employeeModel.setFirstname(currentRow.getCell(1).getStringCellValue());
	        	employeeModel.setLastname(currentRow.getCell(2).getStringCellValue());
	        	employeeModel.setFullname(currentRow.getCell(1).getStringCellValue()+" "+currentRow.getCell(2).getStringCellValue());
	        	employeeModel.setRole(currentRow.getCell(3).getStringCellValue());
	        	employeeModel.setLocation(currentRow.getCell(4).getStringCellValue());
	        	list.add(employeeModel);
	            Iterator<Cell> cell_Iterator = currentRow.cellIterator();
	            int i=0;
	            while(cell_Iterator.hasNext())  {
	            	i++;
	            	currentCell = cell_Iterator.next();
	            	//employeeModel.setEmpid((int)currentCell.getNumericCellValue());
	            	//System.out.println("Service");
	                //Cursor points to cell
//	                 if (currentCell.getCellType().equals("STRING")) {
//	                	 switch (currentRow.){
//                         case emi:
//                             rowData.put(headerName, cell.getCellFormula());
//                             break;
//                         case BOOLEAN:
//                             rowData.put(headerName, cell.getBooleanCellValue());
//                             break;
//                         case NUMERIC:
//                             rowData.put(headerName, cell.getNumericCellValue());
//                             break; 
//	                    } 
	                 
	                 
	               
	                }                   
	            }
	        
	
		return list;
	}

}
