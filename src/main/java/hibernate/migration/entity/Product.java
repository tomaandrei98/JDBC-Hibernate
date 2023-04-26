package hibernate.migration.entity;
/*
 * 1. NoArgsConstructor - genereaza un constructor implicit fara niciun parametru, setand totul by default la 0, "" sau null
 *       - parametru force - daca este true, va permite initializarea by default si a atributelor de tip final sau @NonNull
 * 2. RequiredArgsConstructor - genereaza o serie de contructori care urmeaza niste reguli
 *       - (eg. sa includem un atribut - ii punem @NonNull)
 * 3. Data - genereaza getter, setter, toString si equals and hashcode
 * 4. GenerationType = este un enum transversal pentru db
 *       - AUTO - se foloseste pentru PK de tipul id care folosesc o strategie UUID
 *       - IDENTITY - se foloseste pentru PK de tipul id care folosesc o strategie auto incremented
 * */

import hibernate.migration.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "product")
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Data
public class Product extends BaseEntity {
    @Column(name = "sku")
    @NonNull
    private String sku;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "description")
    @NonNull
    private String description;

    @Column(name = "unit_price")
    @NonNull
    private int unitPrice;

    @Column(name = "image_url")
    @NonNull
    private String imageUrl;

    @Column(name = "active")
    @NonNull
    private boolean active;

    @Column(name = "units_in_stock")
    @NonNull
    private int unitsInStock;

    @Column(name = "date_created")
    @NonNull
    private LocalDate dateCreated;

    @Column(name = "last_updated")
    @NonNull
    private LocalDate lastUpdated;

    @Column(name = "category_id")
    @NonNull
    private int categoryId;
}