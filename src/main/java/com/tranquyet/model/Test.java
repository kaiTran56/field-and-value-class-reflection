package com.tranquyet.model;

import lombok.NonNull;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

public final class Test {
    @SneakyThrows
    public static void main(String ... args) {
        Student student = new Student();
        student.setCourse("Hello");
        student.setId("123");
        student.setName("TranQuyet");
        List<String> listString = Arrays.asList("a", "b", "c");
        //List<String> listString_1 = Arrays.asList(new String[]{"a", "b", "c"});
        student.setListString(listString);

//        List<Parameter> params = Arrays.asList(Test.class.getMethod("checkParametersMethod").getParameters());
//        params.forEach(System.out::println);
        /**
         * GET ALL METHODS and PARAM in class
         */
        Test test = new Test();
        Class<?> checkParams = test.getClass();
        Method[] methods = checkParams.getMethods();
        Arrays.stream(methods).filter(p->p.getName().equals("checkParametersMethod")).forEach(p->{
            System.out.println("METHOD: "+p.getName());
            Parameter[] params = p.getParameters();
            List.of(params).forEach(param->{
                System.out.println("Parameter: "+param.getName());
                System.out.println("Type: "+param.getParameterizedType());
            });
        });

    }

    /**
     * Get fields name and values of class
     * @param objPath       path of class field
     * @param obj           Object of class
     * @param omitFields    prevent get value from fields
     * @param <T>           generic type of object
     * @return              a map with keys are fields and value is properties of object
     */
    public <T> Map<String, Object> getFieldsAndValues(@NonNull String objPath,
                                                      @NonNull T obj, List<String> omitFields){
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
    public void checkParametersMethod(String name, String id,
                                      String password, String address){
        System.out.println(name + " "+ id + " "+ password + " "+ address);
    }
}
