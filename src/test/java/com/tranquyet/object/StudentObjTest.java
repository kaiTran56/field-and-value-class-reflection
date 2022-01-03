package com.tranquyet.object;

import com.tranquyet.model.Student;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StudentObjTest {
    @ParameterizedTest
    @CsvSource({
            "Jane, Doe, F, 1990-05-20",
    })
    public void testStudent(ArgumentsAccessor arguments){
        Student student = new Student();
        student.setId(arguments.getString(0));
        student.setCourse(arguments.getString(1));
        student.setName(arguments.getString(2));
        System.out.println(student.toString());
        assertEquals(student, student);
    }

    @ParameterizedTest
    @CsvSource({
            "Jane, Doe, F, 1990-05-20",
    })
    public void testStudentAnnotation(@CsvToStudent Student student){
        Student student_1 = new Student();
        student_1.setId("Jane");
        student_1.setCourse("Doe");
        student_1.setName("F");

        System.out.println(student.toString());
        System.out.println(student.equals(student_1));
//        assertEquals(student_1.getCourse(), student.getCourse());
        assertThat(student).isEqualToComparingFieldByField(student_1);
    }
}
