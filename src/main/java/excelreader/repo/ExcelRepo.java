package excelreader.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import excelreader.entity.Excel;

public interface ExcelRepo extends JpaRepository<Excel,Integer> 
{
}
