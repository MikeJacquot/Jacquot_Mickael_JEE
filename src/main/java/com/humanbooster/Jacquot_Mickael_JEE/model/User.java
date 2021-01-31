package com.humanbooster.Jacquot_Mickael_JEE.model;



import java.util.Date;

public class User {


    private Integer id;
    private String image_link;
    private String lastName;
    private String firstName;
    private Date date_entree;
    private String numero_tel;
    private String role;
    private String login;
    private String password;



    public User(Integer id, String image_link, String lastName, String firstName, Date date_entree, String numero_tel, String role) {
        this.id = id;
        this.image_link = image_link;
        this.lastName = lastName;
        this.firstName = firstName;
        this.date_entree = date_entree;
        this.numero_tel = numero_tel;
        this.role = role;
    }

    public User(String image_link, String lastName, String firstName, Date date_entree, String numero_tel, String role, String login, String password) {
        this.image_link = image_link;
        this.lastName = lastName;
        this.firstName = firstName;
        this.date_entree = date_entree;
        this.numero_tel = numero_tel;
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public User(Integer id, String image_link, String lastName, String firstName, Date date_entree, String numero_tel, String role, String login, String password) {
        this.id = id;
        this.image_link = image_link;
        this.lastName = lastName;
        this.firstName = firstName;
        this.date_entree = date_entree;
        this.numero_tel = numero_tel;
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public User(Integer id, String image_link, String lastName, String firstName, String numero_tel, String role, String login, String password) {
        this.id = id;
        this.image_link = image_link;
        this.lastName = lastName;
        this.firstName = firstName;
        this.numero_tel = numero_tel;
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage_link() {
        return image_link;
    }


    public String getLastName() {
        return lastName;
    }



    public String getFirstName() {
        return firstName;
    }



    public Date getDate_entree() {
        return this.date_entree;
    }



    public String getNumero_tel() {
        return numero_tel;
    }



    public String getRole() {
        return role;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setDate_entree(Date date_entree) {
        this.date_entree = date_entree;
    }

    public void setNumero_tel(String numero_tel) {
        this.numero_tel = numero_tel;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
