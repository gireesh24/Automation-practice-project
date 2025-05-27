package Utilities;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
//import java.io.FileOutputStream;
//import java.io.IOException;

public class ExcelUtilities {
    public  FileInputStream fi;
    public  FileOutputStream fo;
    public  XSSFWorkbook wb;
    public  XSSFSheet sh;
    public  XSSFRow row;
    public  XSSFCell cell;
    public  CellStyle style;
    String path;
    public ExcelUtilities(String path) {
        this.path=path;
    }


    public  int getRowCoun(String Sheet) throws IOException {
        fi=new FileInputStream(path);
        wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(Sheet);
        int rows=sh.getLastRowNum();
        wb.close();
        fi.close();
        return rows;
    }

    public  int getCellCount( String Sheet) throws IOException {
        fi=new FileInputStream(path);
        wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(Sheet);
        row=sh.getRow(0);
        int cells=row.getLastCellNum();
        wb.close();
        fi.close();
        return cells;
    }

    public  String getCellData( String Sheet, int rows, int cells) throws IOException {
        fi=new FileInputStream(path);
        wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(Sheet);
        row=sh.getRow(rows);
        cell=row.getCell(cells);

        String data="";
        DataFormatter formater=new DataFormatter();
        try {
            data = formater.formatCellValue(cell);
        }catch(Exception e) {
            data="";
        }
        wb.close();
        fi.close();

        return data;
    }

    public  void setCellData(String sheet, int rownum, int columnum, String data) throws IOException {
       File xlFile=new File(path);
       if(!xlFile.exists()) {
           wb=new XSSFWorkbook();
           fo=new FileOutputStream(path);
           wb.write(fo);
       }
        fi=new FileInputStream(path);
        wb=new XSSFWorkbook(fi);
        if(wb.getSheet(sheet)==null){
            wb.createSheet(sheet);
        }
        sh=wb.getSheet(sheet);
        if(sh.getRow(rownum)==null){
            sh.createRow(rownum);
        }
        row=sh.getRow(rownum);

        cell=row.createCell(columnum);
        cell.setCellValue(data);
        fo=new FileOutputStream(path);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }

    public  void fillGreenColour(String filePath, String sheet, int rownum, int columnum) throws IOException {

        fi=new FileInputStream(filePath);
        wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(sheet);
        row=sh.getRow(rownum);
        style=wb.createCellStyle();

        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
        fo=new FileOutputStream(filePath);

        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }


    public  void fillRedColour(String filePath, String sheet, int rownum, int columnum) throws IOException {

        fi=new FileInputStream(filePath);
        wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(sheet);
        row=sh.getRow(rownum);
        style=wb.createCellStyle();

        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
        fo=new FileOutputStream(filePath);

        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }
}
