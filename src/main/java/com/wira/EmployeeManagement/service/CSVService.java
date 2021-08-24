package com.wira.EmployeeManagement.service;

import com.wira.EmployeeManagement.helper.CSVHelper;
import com.wira.EmployeeManagement.model.File;
import com.wira.EmployeeManagement.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    FileRepository fileRepository;

    public void save(MultipartFile file) {
        try {
            List<File> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
            fileRepository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<File> tutorials = fileRepository.findAll();

        ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
        return in;
    }

    public List<File> getAllTutorials() {
        return fileRepository.findAll();
    }
}
