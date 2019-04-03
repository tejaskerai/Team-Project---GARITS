package com.quickfixfitters.garits.reports;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;

public class ExportExcel {

    int date;
    public ExportExcel() {
    }

    public void exportReport(Map<Integer, Object[]> report)
    {
        date++;
        // Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Report");



        // Iterate over data and write to sheet
        Set<Integer> keyset = report.keySet();

        int rownum = 0;
        for (Integer key : keyset) {
            // this creates a new row in the sheet
            Row row = sheet.createRow(rownum++);
            Object [] objArr = report.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                // this line creates a cell in the next column of that row
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String)obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try {
            // this Writes the workbook gfgcontribute
            FileOutputStream out = new FileOutputStream(new File("garits/files/Report.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("report.xlsx written successfully on disk.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}