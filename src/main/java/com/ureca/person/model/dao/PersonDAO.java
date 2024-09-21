package com.ureca.person.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;

import com.ureca.person.dto.Person;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonDAO {

	@Insert("insert int person (name, age, job) values (#{name}, #{age}, #{job})")
	public int insert(Person person)throws SQLException;//나는 sql실행만 전념하겠어!!

	@Update("update person set age=#{age}, job=#{job} where no=#{no}")
	public int update(Person person)throws SQLException;

	@Delete("delete from person where no=#{no}")
	public int delete(int no)throws SQLException;

	@Select("select no,name,age,job from person where no=#{no}")
	public Person select(int no)throws SQLException; //특정 Person 한명 조회 => 수정폼/상세페이지

	@Select("select no,name,age,job from person order by name desc")
	public List<Person> selectAll()throws SQLException;//모든 Person 조회
	
/*
<DAO작성법>

public int insert(DTO);
public int update(DTO);
public int delete(PK);

public DTO select(PK);//한행에 대한 상세,수정
public List<DTO> selectAll(); //여러행 조회

public List<DTO> selectBy조건(조건을 표현하는 자료형);
	
 */
	

}


















