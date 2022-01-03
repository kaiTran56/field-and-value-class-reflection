package com.tranquyet.object;

import com.tranquyet.model.Student;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class StudentAggregator implements ArgumentsAggregator {
    @Override
    public Student aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
        Student student = new Student();
        student.setId(accessor.getString(0));
        student.setCourse(accessor.getString(1));
        student.setName(accessor.getString(2));
        return student;
    }
}
