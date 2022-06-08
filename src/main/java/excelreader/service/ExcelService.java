package excelreader.service;

import excelreader.entity.Excel;
import excelreader.helper.Helper;
import excelreader.repo.ExcelRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private ExcelRepo excelRepo;

    public void save(MultipartFile file) {

        List<Excel> excels = null;
		try {
			excels = Helper.convertExcelToListOfProduct(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.excelRepo.saveAll(excels);

    }

    public List<Excel> getAllData() {
        return this.excelRepo.findAll();
    }


}
