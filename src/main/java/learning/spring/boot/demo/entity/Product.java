package learning.spring.boot.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @GeneratedValue
    @Id
    private Long id;
    @Column(name = "product_name")
    private String producName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducName() {
        return producName;
    }

    public void setProducName(String producName) {
        this.producName = producName;
    }
}

