package com.tutorialsninja.qa.testcases;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelReader {

	public static void main(String[] args)  {

		try {
			
			FileInputStream fis = new FileInputStream("C:\\Users\\mali204\\git\\TutorialsninjaProjectRepository\\TutorialsninjaProject\\src\\config\\webdata.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(0);
			XSSFCell cell1 = row.getCell(0); 
			String cellData1 = cell1.getStringCellValue();
			XSSFCell cell2 = row.getCell(1); 
			String cellData2 = cell2.getStringCellValue();
			System.out.println("row Data: " + cellData1+"\t"+cellData2);
			workbook.close();
			fis.close();

		} catch (Exception exe) {
			System.out.println("Panga: "+exe);
		}
	}
}
