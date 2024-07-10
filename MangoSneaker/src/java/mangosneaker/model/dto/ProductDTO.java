/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangosneaker.model.dto;

import java.io.Serializable;
import mangosneaker.model.dao.CategoryDAO;

/**
 *
 * @author Nhatthang
 */
public class ProductDTO implements Serializable{
    
    private int id;
    private CategoryDTO category;
    private String name;
    private double price;
    private String img;
    private double discount;
    private String description;

    public ProductDTO() {
    }

    public ProductDTO(int id, CategoryDTO category, String name, double price, String img, double discount, String description) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.img = img;
        this.discount = discount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "id=" + id + ", category=" + category + ", name=" + name + ", price=" + price + ", img=" + img + ", discount=" + discount + ", description=" + description + '}';
    }

    

    
}
