package Libraries;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelManipulations implements Constants {
public XSSFWorkbook workbook;
public XSSFSheet sheet;

    public void read_Excel(String excelpath,String sheetname,int r,int c) throws IOException {
        try {
            FileInputStream fis = new FileInputStream(excelpath);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetname);
            System.out.println(sheet.getRow(r).getCell(c).getStringCellValue());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public int get_rowcount(String sheetname)
    {
        XSSFSheet sheet = workbook.getSheet(sheetname);
        int rowcount = sheet.getLastRowNum()+1;
        return rowcount;
    }

    public int colcount(int rownumber)
    {
       int colcount = sheet.getRow(rownumber).getPhysicalNumberOfCells();
       return colcount;
    }




}
