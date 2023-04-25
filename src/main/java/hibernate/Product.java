package hibernate;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private int unitPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "active")
    private boolean active;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @Column(name = "last_updated")
    private LocalDate lastUpdated;

    @Column(name = "category_id")
    private int categoryId;

    public Product() {
    }

    public Product(
            String sku,
            String name,
            String description,
            int unitPrice,
            String imageUrl,
            boolean active,
            int unitsInStock,
            LocalDate dateCreated,
            LocalDate lastUpdated,
            int categoryId) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.imageUrl = imageUrl;
        this.active = active;
        this.unitsInStock = unitsInStock;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDate lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", imageUrl='" + imageUrl + '\'' +
                ", active=" + active +
                ", unitsInStock=" + unitsInStock +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", categoryId=" + categoryId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return getId() == product.getId()
                && getUnitPrice() == product.getUnitPrice()
                && isActive() == product.isActive()
                && getUnitsInStock() == product.getUnitsInStock()
                && getCategoryId() == product.getCategoryId()
                && Objects.equals(getSku(), product.getSku())
                && Objects.equals(getName(), product.getName())
                && Objects.equals(getDescription(), product.getDescription())
                && Objects.equals(getImageUrl(), product.getImageUrl())
                && Objects.equals(getDateCreated(), product.getDateCreated())
                && Objects.equals(getLastUpdated(), product.getLastUpdated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getSku(),
                getName(),
                getDescription(),
                getUnitPrice(),
                getImageUrl(),
                isActive(),
                getUnitsInStock(),
                getDateCreated(),
                getLastUpdated(),
                getCategoryId());
    }
}