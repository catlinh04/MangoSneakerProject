/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangosneaker.model.dto;

import java.io.Serializable;

/**
 *
 * @author catlinh
 */
public class CustomerDTO implements Serializable{
    int id;
    String firstName, lastName, mail, 
            username, password, phone;
    boolean isDeleted;
    public CustomerDTO() {
    }

    public CustomerDTO(int id, String firstName, String lastName, String mail, String username, String phone, boolean isDeleted) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.username = username;
        this.phone = phone;
        this.isDeleted = isDeleted;
    }

    public CustomerDTO(String firstName, String lastName, String mail, String username, String password, String phone, boolean isDeleted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.isDeleted = isDeleted;
    }
  
//    public CustomerDTO(String firstName, String lastName, String mail, String username, String password, String phone) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.mail = mail;
//        this.username = username;
//        this.password = password;
//        this.phone = phone;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", mail=" + mail + ", username=" + username + ", password=" + password + ", phone=" + phone + ", isDeleted=" + isDeleted + '}';
    }
    
    
    
}
