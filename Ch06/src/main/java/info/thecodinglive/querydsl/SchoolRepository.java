package info.thecodinglive.querydsl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.thecodinglive.model.School;

@Repository
public interface SchoolRepository  extends JpaRepository<School, Long>{

}
