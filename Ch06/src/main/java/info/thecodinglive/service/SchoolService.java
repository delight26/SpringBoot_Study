package info.thecodinglive.service;

import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.thecodinglive.model.School;
import info.thecodinglive.model.Student;
import info.thecodinglive.querydsl.SchoolRepository;
import info.thecodinglive.querydsl.StudentRepository;

@Service
public class SchoolService {
	@Autowired
	private SchoolRepository schoolRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	@Transactional
	public void findStudentInfo() {
		School school = new School("매력고");
		schoolRepository.save(school);
		
		Student stu1 = new Student("나라");
		Student stu2 = new Student("민하");
		Student stu3 = new Student("나나");
		
		stu1.setSchool(school);
		stu2.setSchool(school);
		stu3.setSchool(school);
		
		studentRepository.save(stu1);
		studentRepository.save(stu2);
		studentRepository.save(stu3);
		
		List<Student> students = studentRepository.findAll();
		
		for(Student s : students) {
			System.out.println(s.getUserName() + ", " + s.getSchool().getName());
		}
	}
	
	@Transactional
	public void findSchoolInfo() {
		School sc1 = new School("예체능고");
		sc1.registerStudent(new Student("홍길동"));
		sc1.registerStudent(new Student("유재석"));
		
		School sc2 = new School("매력고");
		sc2.registerStudent(new Student("나라"));
		sc2.registerStudent(new Student("민하"));
		
		schoolRepository.saveAll(new HashSet<School>() {{
			add(sc1);
			add(sc2);
		}});
		
		List<School> students = schoolRepository.findAll();
		
		for(School s : students) {
			System.out.println(s.toString());
		}
	}
}
