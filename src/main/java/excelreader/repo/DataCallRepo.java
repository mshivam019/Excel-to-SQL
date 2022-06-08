package excelreader.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import excelreader.entity.DataCall;
@Repository
public interface DataCallRepo extends JpaRepository<DataCall,Integer>
{
		
}