package com.apress.prospring4.ch9.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;


@Entity
@Table(name = "contact")
@NamedQueries({
        @NamedQuery(name = "Contact.findAll",
        query = "select c from Contact c"),
        @NamedQuery(name = "Contact.countAll",
        query = "select count (c) from Contact c")
})

public class Contact implements Serializable {
    private Long id;
    private int version;
    private String firstName;
    private String lastName;
    private Date birthDate;


    public Contact() {
    }

    public Contact(String firstName, String lastName,String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.birthDate = dateFormat.parse(date);
        } catch (ParseException e) {
            this.birthDate = new Date(GregorianCalendar.getInstance().getTimeInMillis());
        }
    }

    public Contact(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    @Override
    public String toString() {
        return "Contact Id: " + id +
                ", First name - " + firstName+
                ", Last name - " + lastName +
                ", Birthday: " + birthDate;
    }
}
