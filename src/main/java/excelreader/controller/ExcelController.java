package excelreader.controller;

import excelreader.WorkbookApplication;
import excelreader.entity.Excel;
import excelreader.helper.Helper;
import excelreader.service.ExcelService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ExcelController {
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkbookApplication.class);
    @Autowired
    private ExcelService excelService;

    @PostMapping("/excel/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) 
    {
        if (Helper.checkExcelFormat(file)) 
        {
            //true

            this.excelService.save(file);

            LOGGER.info("File is uploaded successfully!");
            return ResponseEntity.ok(Map.of("message", "File is uploaded"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


    @GetMapping("/excel")
    public List<Excel> getAllexcel() 
    {
        return this.excelService.getAllData();
    }

}
