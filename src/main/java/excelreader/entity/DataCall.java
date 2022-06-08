package excelreader.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DataCall 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer sno;
	private String sender;
	public DataCall(Integer sno, String sender, String reciever, String doctype) 
	{
		super();
		this.sno = sno;
		this.sender = sender;
		this.reciever = reciever;
		this.doctype = doctype;
	}
	public Integer getSno() 
	{
		return sno;
	}
	public void setSno(Integer sno) 
	{
		this.sno = sno;
	}
	private String reciever;
	private String doctype;
	public DataCall() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSender() 
	{
		return sender;
	}
	public void setSender(String sender) 
	{
		this.sender = sender;
	}
	public String getReciever() 
	{
		return reciever;
	}
	public void setReciever(String reciever) 
	{
		this.reciever = reciever;
	}
	public String getDoctype() 
	{
		return doctype;
	}
	public void setDoctype(String doctype) 
	{
		this.doctype = doctype;
	}
	
}
