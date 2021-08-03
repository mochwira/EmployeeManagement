package com.wira.EmployeeManagement.service;

import com.wira.EmployeeManagement.model.Project;
import com.wira.EmployeeManagement.model.Reports;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ProjectFileServiceImpl implements ProjectFileService{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ByteArrayInputStream export(List<Project> projects) {
        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("Project");

            Row row = sheet.createRow(0);

            // Define header cell style
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Creating header cells
            Cell cell = row.createCell(0);
            cell.setCellValue("Project Id");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(1);
            cell.setCellValue("Project Name");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(2);
            cell.setCellValue("Keterangan ");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(3);
            cell.setCellValue("Asal");
            cell.setCellStyle(headerCellStyle);

            cell = row.createCell(4);
            cell.setCellValue("Durasi");
            cell.setCellStyle(headerCellStyle);



            // Creating data rows for each contact
            for(int i = 0; i < projects.size(); i++) {
                Row dataRow = sheet.createRow(i + 1);
                dataRow.createCell(0).setCellValue(projects.get(i).getProjectId());
                dataRow.createCell(1).setCellValue(projects.get(i).getNamaProject());
                dataRow.createCell(2).setCellValue(projects.get(i).getKeteranganProject());
                dataRow.createCell(3).setCellValue(projects.get(i).getAsalProject());
                dataRow.createCell(4).setCellValue(projects.get(i).getDurasiProject());
            }

            // Making size of column auto resize to fit with data
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            sheet.autoSizeColumn(4);


            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } catch (IOException ex) {
            logger.error("Error during export Excel file", ex);
            return null;
        }
    }
}
