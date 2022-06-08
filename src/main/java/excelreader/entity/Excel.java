package excelreader.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Excel 
{

    @Id
    private Integer testCaseNo;

    private String description;

    private String sender;
    private String receiver;
    private String doctype;
    private String useApigee;
    private String devEmail;
    private String password;
    private String assertpayload;
    private String assertheader;
    private int statusCode;
    
	public Integer getTestCaseNo() 
	{
		return testCaseNo;
	}

	public void setTestCaseNo(Integer testCaseNo) 
	{
		this.testCaseNo = testCaseNo;
	}

	public String getDescription() 
	{
		return description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getSender() 
	{
		return sender;
	}

	public void setSender(String sender) 
	{
		this.sender = sender;
	}

	public String getReceiver() 
	{
		return receiver;
	}

	public void setReceiver(String receiver) 
	{
		this.receiver = receiver;
	}

	public String getDoctype() 
	{
		return doctype;
	}

	public void setDoctype(String doctype) 
	{
		this.doctype = doctype;
	}

	public String getUseApigee() 
	{
		return useApigee;
	}

	public void setUseApigee(String useApigee) 
	{
		this.useApigee = useApigee;
	}

	public String getDevEmail() 
	{
		return devEmail;
	}

	public void setDevEmail(String devEmail) 
	{
		this.devEmail = devEmail;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getAssertpayload() 
	{
		return assertpayload;
	}

	public void setAssertpayload(String assertpayload) 
	{
		this.assertpayload = assertpayload;
	}

	public String getAssertheader() 
	{
		return assertheader;
	}

	public void setAssertheader(String assertheader) 
	{
		this.assertheader = assertheader;
	}

	public int getStatuscode() 
	{
		return statusCode;
	}

	public void setStatuscode(int statuscode) 
	{
		statusCode = statuscode;
	}

	public Excel(Integer testCaseNo, String description, String sender, String receiver,
			String doctype, String useApigee, String devEmail, String password, String assertpayload,
			String assertheader, int statuscode) 
	{
		super();
		this.testCaseNo = testCaseNo;
		this.description = description;
		this.sender = sender;
		this.receiver = receiver;
		this.doctype = doctype;
		this.useApigee = useApigee;
		this.devEmail = devEmail;
		this.password = password;
		this.assertpayload = assertpayload;
		this.assertheader = assertheader;
		statusCode = statuscode;
	}

	public Excel() 
	{
		// TODO Auto-generated constructor stub
	} 
}
