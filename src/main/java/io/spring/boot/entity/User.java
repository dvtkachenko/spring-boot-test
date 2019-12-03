package io.spring.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "USER_TABLE")
@NamedQuery(name=User.NQ_FIND_ALL, query="SELECT u FROM User u WHERE 1=1")
public class User {

    public static final String NQ_FIND_ALL = "User.findAll";

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min=2, message="Name should have at least 2 characters")
    @Column(name = "USER_NAME", nullable = true, length = 255)
    private String name;

//    @Column(name = "USER_BIRTH_DATE", nullable = true)
    @Past
    private Date birthDate;

    @Column(name = "USER_AGE", nullable = true)
    private Integer age;

    @Column(name = "USER_COMMENT", nullable = true, length = 255)
    private String comment;

    protected User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
