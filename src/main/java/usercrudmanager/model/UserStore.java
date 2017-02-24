package usercrudmanager.model;

import javax.persistence.*;

/**
 * Created by Kovalchuk Dmytro on 22.02.2017.
 */
@Entity
@Table(name = "UserCrud")
public class UserStore {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userAge")
    private int age;

    @Column(name = "userName")
    private String name;

    @Column(name = "userSecondName")
    private String secondName;

//    @Column(name = "userGendor")
//    private boolean gendor;

//    public boolean isGendor() {
//        return gendor;
//    }
//
//    public void setGendor(boolean gendor) {
//        this.gendor = gendor;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return "UserStore{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
