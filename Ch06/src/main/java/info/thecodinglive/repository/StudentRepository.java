package info.thecodinglive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.thecodinglive.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
