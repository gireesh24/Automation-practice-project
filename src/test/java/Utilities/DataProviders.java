package Utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;


public class DataProviders {

    //DataProvider1
@DataProvider(name="loginData")
    public String[][] getUsers() throws IOException {
      String path= "D:\\intellij Idea\\Project2\\src\\test\\resources\\ExcelData.xlsx";
    ExcelUtilities xlutil=new ExcelUtilities(path);
      int totalrows=xlutil.getRowCoun("Sheet1");
      int totalcells=xlutil.getCellCount("Sheet1");
      String[][] data=new String[totalrows][totalcells];
      for(int i=1;i<=totalrows;i++) {
          for(int j=0;j<totalcells;j++) {
              data[i-1][j]=xlutil.getCellData("Sheet1",i,j);
//              data[i][j]=xlutil.getCellData("Sheet1",i,j+1);
              System.out.println(data[i-1][j]);
          }
      }
      return data;
    }

    //DataProvider2
}
