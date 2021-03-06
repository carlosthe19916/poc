package io.tackle.controls.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.tackle.controls.annotations.Filterable;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "business_service")
@SQLDelete(sql = "UPDATE business_service SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = false")
public class BusinessService extends AbstractEntity {
    @Column(unique=true)
    @Filterable
    public String name;
    @Filterable
    public String description;
    @ManyToOne
    @JsonIgnoreProperties({"jobFunction", "email"})
    @Filterable(filterName = "owner.displayName")
    public Stakeholder owner;
}
