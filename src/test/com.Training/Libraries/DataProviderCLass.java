package Libraries;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class DataProviderCLass implements Constants{

    @DataProvider(name = "Login_credential")
    public Object[][] data_ProviderFunction() throws IOException {
        FileInputStream fis = new FileInputStream(Excelpath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetnameofexcel);
        int rowcount = sheet.getLastRowNum()+1;
        System.out.println("No: of rows :"+rowcount);
        int colcount = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("No:of colums :"+colcount);
        Object[][] data = new Object[rowcount][colcount];
        for (int i=0;i<rowcount;i++)
        {
            for (int j=0;j<colcount;j++)
            {
                System.out.println("i :"+i);
                System.out.println("J :"+j);
                data[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }

        return data;


    }
}
