package TestCases;

import Utilities.DataProviders;
import Utilities.ExcelUtilities;

import java.io.IOException;

public class sampile {
    public static void main(String[] args) throws IOException {
        DataProviders dp=new DataProviders();
       dp.getUsers();
        ExcelUtilities xlutil=new ExcelUtilities("D:\\intellij Idea\\Project2\\src\\test\\resources\\ExcelData.xlsx");
        System.out.println(xlutil.getRowCoun("Sheet1"));
        System.out.println(xlutil.getCellCount("Sheet1"));
        System.out.println("hello");
    }

}
