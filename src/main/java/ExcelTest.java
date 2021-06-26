import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelTest {
    public static void main(String[] args) throws IOException {
        try {
            FileInputStream fis = new FileInputStream("./Exceltestda/Excelone.xlsx");
            XSSFWorkbook workbook =new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowcount = sheet.getLastRowNum()+1;
            System.out.println("Rowcount :"+rowcount);
            int colcount = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println(colcount);
            for (int i=0;i<rowcount;i++)
            {

                for (int j=0;j<colcount;j++)
                {
                    System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
