package com.tranquyet.model;

import lombok.NonNull;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.*;

public final class Test {
    @SneakyThrows
    public static void main(String ... args) {
        Student student = new Student();
        student.setCourse("Hello");
        student.setId("123");
        student.setName("TranQuyet");
        List<String> listString = Arrays.asList(new String[]{"a", "b", "c"});
        //List<String> listString_1 = Arrays.asList(new String[]{"a", "b", "c"});
        student.setListString(listString);

//            Class<?> clazz = Class.forName("com.tranquyet.model.Student");
//            Field[] fieldlist = clazz.getDeclaredFields();
//            Arrays.asList(fieldlist).forEach(p->{
//                p.setAccessible(true); // permit access to private
//                System.out.println("field name = " + p.getName()); // get field name
//                try {
//                    System.out.println("value = " + p.get(student)); // get value
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("field type  = " + p.getType()); // get type of value
//                System.out.println("modifiers = " +  Modifier.toString(p.getModifiers())); // get access modifiers
//            });
//
//        new Student().toString();
//        System.out.println("Check Property: "+student.toString());
//        String test_1 = "Hello";
//        String test_2 ="Hey";
        String path = "com.tranquyet.model.Student";
        List<String > params = Arrays.asList("listString", "id", "name");
        Map<String, Object> check = new Test().getFieldsAndValues(path,
                student, params);
        System.out.println(check);
    }

    /**
     * Get fields name and values of class
     * @param objPath       path of class field
     * @param obj           Object of class
     * @param omitFields    prevent get value from fields
     * @param <T>           generic type of object
     * @return              a map with keys are fields and value is properties of object
     */
    public <T> Map<String, Object> getFieldsAndValues(@NonNull String objPath, @NonNull T obj, List<String> omitFields){
        try {
            Map<String, Object> objMap = new HashMap<>();
            Class<?> classObj = Class.forName(objPath);
            Field[] fields = classObj.getDeclaredFields();
            Arrays.asList(fields).forEach(p->{
                p.setAccessible(true);
                try {
                    objMap.put(p.getName(), p.get(obj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
            Optional.ofNullable(omitFields)
                    .ifPresent(p->p.forEach(objMap::remove));
            return objMap;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
