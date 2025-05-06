package mylab.customer.vo;

import java.util.Date;

public class CustomerVO {

    private int id;
    private String email;
    private String name;
    private int age;
    private Date entry_date;

    // 기본 생성자
    public CustomerVO() {}

    // getter & setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Date getEntry_date() {
        return entry_date;
    }
    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    // toString() for debugging
    @Override
    public String toString() {
        return "CustomerVO [id=" + id + ", email=" + email + ", name=" + name
                + ", age=" + age + ", entry_date=" + entry_date + "]";
    }
}
