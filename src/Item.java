import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ITEM")
public class Item {

    @JsonIgnore
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("dateCreated")
    private Date dateCreated;

    @JsonProperty("lastUpdatedDate")
    private Date lastUpdatedDate;

    @JsonProperty("description")
    private String description;

    @Id
    @SequenceGenerator(name = "PR_SEQ", sequenceName = "PRODUCT_SEQ", allocationSize = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PR_SEQ")
    @Column(name = "ITEM_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DATECREATED")
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(name = "LASTUPDATEDDATE")
    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", description='" + description + '\'' +
                '}';
    }
}
