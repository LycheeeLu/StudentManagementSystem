package com.it.mapper;

import com.it.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Package : com.it.mapper
 * @ClassName : StudentMapper.java
 * @Version : 1.0
 * @Description :
 */
@Mapper
public interface StudentMapper {
    /**
     * write in student info (including grade)
     *
     * @param student Student Object
     * @return row being affected
     */
    int insertScore(Student student);

    /**
     * list all students info
     *
     * @param
     * @return List<Student> a list of students
     */
     List<Student> showStudentList();

    /**
     * check student info based on id
     *
     * @param id
     * @return Student Student object
     */
     Student queryById(String id);


    /**
     * edit student info based on id
     *
     * @param student Student Object
     * @return affected row number
     */
     int updateById(Student student);

    /**
     * delete student info based on id
     *
     * @param id
     * @return affected row number
     */
     int deleteById(String id);
}
