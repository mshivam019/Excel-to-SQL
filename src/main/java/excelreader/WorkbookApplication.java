package excelreader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class WorkbookApplication implements CommandLineRunner 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkbookApplication.class);
	public static void main(String[] args) 
    {
        SpringApplication.run(WorkbookApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception 
    {
        LOGGER.info("Application Started");
    }
}
