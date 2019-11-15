package br.edu.ifrs.canoas.java;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Poi {


    public static void main(String[] args) throws JRException
    {
        CarService carService = new CarService();
        List<Car> cars = new ArrayList<>();
        String file = Poi.class.getClassLoader().getResource("").getPath() + "MyExcel.xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Cars in Java");

        cars = carService.createCars(10);

        int rowNum = 0;
        int colNum = 0;
        System.out.println("Creating excel");
        Row row = sheet.createRow(rowNum++);
        Cell cell;

        row.createCell(colNum++).setCellValue("Id");
        row.createCell(colNum++).setCellValue("Brand");
        row.createCell(colNum++).setCellValue("Year");
        row.createCell(colNum++).setCellValue("Color");
        row.createCell(colNum++).setCellValue("Price");
        row.createCell(colNum++).setCellValue("Sold State");

        for (Car car : cars) {
            row = sheet.createRow(rowNum++);
            colNum=0;
            row.createCell(colNum++).setCellValue(car.getId());
            row.createCell(colNum++).setCellValue(car.getBrand());
            row.createCell(colNum++).setCellValue(car.getYear());
            row.createCell(colNum++).setCellValue(car.getColor());
            row.createCell(colNum++).setCellValue(car.getPrice());
            row.createCell(colNum++).setCellValue(car.isSoldState());
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");

    }

}
