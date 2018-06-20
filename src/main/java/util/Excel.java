package util;

import java.io.*;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

    /**
     * To write list into a excel file
     * @param fileName
     * @param titles
     * @throws Exception
     */
    public static void writeListToFile(String fileName, List<String> titles) throws Exception{
        Workbook workbook = null;

        if(fileName.endsWith("xlsx")){
            workbook = new XSSFWorkbook();
        }else if(fileName.endsWith("xls")){
            workbook = new HSSFWorkbook();
        }else{
            throw new Exception("invalid file name, should be xls or xlsx");
        }

        Sheet sheet = workbook.createSheet("Show");
        Sheet sheetDuplicate = workbook.createSheet("Duplicate Record");

        Iterator<String> iterator = titles.iterator();

        int rowIndex = 0;
        while(iterator.hasNext()){
            String value = iterator.next();
            Row row = sheet.createRow(rowIndex++);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(value);

        }

        FileOutputStream fos = new FileOutputStream(fileName);
        workbook.write(fos);
        fos.close();
        System.out.println(fileName + " written successfully");
    }


    /**
     *  To update existing file
     * @param fileName
     * @param titles
     * @throws InvalidFormatException
     * @throws IOException
     */
    public static void modifyExistingFile(String fileName, List<String> titles) throws InvalidFormatException, IOException {
        InputStream inp = new FileInputStream(fileName);
        Workbook workbook = WorkbookFactory.create(inp);

        Sheet sheet = workbook.getSheetAt(1);

        Iterator<String> iterator = titles.iterator();

        int rowIndex = 0;
        while(iterator.hasNext()){
            String value = iterator.next();
            Row row = sheet.createRow(rowIndex++);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(value);
        }
        inp.close();

        FileOutputStream fos = new FileOutputStream(fileName);
        workbook.write(fos);
        fos.close();
        System.out.println(fileName + " written successfully");
    }

}
