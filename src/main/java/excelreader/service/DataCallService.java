package excelreader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import excelreader.entity.DataCall;
import excelreader.repo.DataCallRepo;



@Service
public class DataCallService 
{
	@Autowired
	private DataCallRepo dcrepo;
	
	public List<DataCall> getAllDetails() 
	{
		// TODO Auto-generated method stub
		return dcrepo.findAll();
	}
	
	public void saveDetails(DataCall datac) 
	{
		this.dcrepo.save(datac);
	}

}
