package br.edu.ifrs.canoas.java;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;

import java.util.ArrayList;
import java.util.List;

public class Jasper {


    public static void main(String[] args) throws JRException
    {
        CarService carService = new CarService();
        List<Car> cars = new ArrayList<>();
        String path = Jasper.class.getClassLoader().getResource("jasper/").getPath();

        //Obtem o valor atual do sistema
        JasperFillManager.fillReportToFile(path + "cars.jasper", carService.get(10), new JREmptyDataSource(1));
        //Geracao do PDF
        JasperExportManager.exportReportToPdfFile(path+"cars.jrprint");
        System.out.println("Arquivo disponível em: " + path);
    }

}
