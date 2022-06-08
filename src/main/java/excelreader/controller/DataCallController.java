package excelreader.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import excelreader.WorkbookApplication;
import excelreader.entity.DataCall;
import excelreader.service.DataCallService;

@RestController
@CrossOrigin("*")
public class DataCallController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkbookApplication.class);
	@Autowired
	private DataCallService dataservice;
	
		@GetMapping("/details")
	    public List<DataCall> getAllDetails() 
		{
	        return this.dataservice.getAllDetails();
	    }
		
		@PostMapping("/details/upload")
	    public ResponseEntity<?> uploa(@Validated @RequestBody DataCall datac){

	            this.dataservice.saveDetails(datac);

	            LOGGER.info("Details are uploaded");
	            return ResponseEntity.ok(Map.of("message", "Details uploaded"));
	            
		}
}
