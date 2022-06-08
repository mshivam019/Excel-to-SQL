package excelreader.helper;

import excelreader.WorkbookApplication;
import excelreader.entity.Excel;

import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Helper 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkbookApplication.class);
	

    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) 
    {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) 
        {
            return true;
        } else 
        {
            return false;
        }

    }


    //convert excel to list of products

    public static List<Excel> convertExcelToListOfProduct(MultipartFile is) throws IllegalStateException, IOException 
    {
        List<Excel> list = new ArrayList<>();

        File file = new File(System.getProperty("java.io.tmpdir")+"/targetFile.tmp");

        is.transferTo(file);
        try 
        {

        	Workbook workbook = WorkbookFactory.create(file);
        	Iterator<Sheet> sheetIterator = workbook.sheetIterator();
            LOGGER.info("Retrieving Sheets using Iterator");
            int rowNumber = 0;
            
            
            while (sheetIterator.hasNext()) 
            {
            	Sheet sheet = sheetIterator.next();
            	Iterator<Row> rowIterator = sheet.rowIterator();

            	 while (rowIterator.hasNext()) 
            	 {
                     Row row = rowIterator.next();
                     if (rowNumber == 0) 
                     {
                         rowNumber++;
                         continue;
                     }
                     // Now let's iterate over the columns of the current row
                     Iterator<Cell> cellIterator = row.cellIterator();
                     int cid=0;
                     int status=0;
                     String doctype="",sender="",reciever="";
                     
                     Excel p = new Excel();
                     while (cellIterator.hasNext()) 
                     {
                         Cell cell = cellIterator.next();

                    switch (cid) 
                    {
                        case 0:
                            p.setTestCaseNo((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            p.setDescription(cell.getStringCellValue());
                            break;
                        case 2:
                            p.setSender(cell.getStringCellValue());
                            sender=cell.getStringCellValue();
                            break;
                        case 3:
                            p.setReceiver(cell.getStringCellValue());
                            reciever=cell.getStringCellValue();
                            break;
                        case 4:
                        	p.setDoctype(cell.getStringCellValue());
                        	doctype=cell.getStringCellValue();
                        	break;
                        case 5:
                        	p.setUseApigee(cell.getStringCellValue());
                        	break;
                        case 6:
                        	p.setDevEmail(cell.getStringCellValue());
                        	break;
                        case 7:
                        	p.setPassword(cell.getStringCellValue());
                        	break;
                        case 8:
                        	p.setAssertpayload(cell.getStringCellValue());
                        	break;
                        case 9:
                        	p.setAssertheader(cell.getStringCellValue());
                        	break;
                        case 10:
                        	status=(int) cell.getNumericCellValue();                      	
                        	break;
                        default:
                            break;
                    }
                    cid++;
                    
                }
                     
                     RestTemplate restTemplate = new RestTemplate();
                     HttpHeaders headers = new HttpHeaders();
                     headers.setContentType(MediaType.APPLICATION_JSON);  
                     URI uri = new URI("http://localhost:8080/details/upload");
                     Map<String, Object> params = new HashMap<>();
                             params.put("doctype",doctype);
                             params.put("reciever", reciever);
                             params.put("sender", sender);

                     HttpEntity<Map<String, String>> request = new HttpEntity(params , headers);
                        
                     ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
                     System.out.println(response.getStatusCodeValue());
                     p.setStatuscode(response.getStatusCodeValue());
                     if(status==response.getStatusCodeValue())
                     LOGGER.info("Assert status code is correct");
                     rowNumber++;
                     list.add(p);
            	 }
            	 
            }
            	 


        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return list;

    }


}
