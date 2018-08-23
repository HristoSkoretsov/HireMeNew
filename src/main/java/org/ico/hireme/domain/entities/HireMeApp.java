package org.ico.hireme.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "hire_me_info")
public class HireMeApp {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    private String date;

    private Long totalRegisteredUsers;

    public HireMeApp() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTotalRegisteredUsers() {
        return totalRegisteredUsers;
    }

    public void setTotalRegisteredUsers(Long totalRegisteredUsers) {
        this.totalRegisteredUsers = totalRegisteredUsers;
    }
}
