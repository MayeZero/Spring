package com.example.spring.model;

public class User {
    private String username;

    private String password;

    private int sex;

    private Emp emp;

//    private static  User user = new User();

//    public User(String username, String password, int sex, Emp emp) {
//        this.username = username;
//        this.password = password;
//        this.sex = sex;
//        this.emp = emp;
//    }

//Static Factory Method
//    public static User createInstance(){
//        System.out.println("User has init by StaticFactory");
//        return user;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Emp getEmp() {
        return emp;
    }

    @Override
    public String toString(){
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        if(sex == 1){
            System.out.println("sex:男");
        }else{
            System.out.println("sex:女");
        }
        System.out.println("emp:"+emp);
        return "Hello Spring ...";
    }
}

//Instance Factory Method
//class InstanceFactory{
//    private static User user = new User();
//
//    public User createInstance(){
//        System.out.println("User has init by InstanceFactory");
//        return user;
//    }
//}

