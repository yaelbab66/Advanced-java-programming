
import java.io.Serializable;

/*
 * Product.java
 * Represents a product in store
 *  shay.tavor@gmail.com
 */

/**
 *
 * @author Shay Tavor
 */
public class Product implements Serializable{
    private int num;
    private double price;
    private String name;
    public Product(int n, double p, String name)
    {
        num = n;
        price = p;
        this.name = name;
    }
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString()
    {
        return num + ". \t" + price + "\t" + name;
    }
}
