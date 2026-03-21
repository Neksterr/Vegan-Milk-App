package project.Vegan_Milk.machine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import project.Vegan_Milk.account.model.entity.BaseEntity;

@Entity
@Table(name = "machines")
public class Machine extends BaseEntity {

    @Column(name = "machine_name", nullable = false)
    private String name;
    @Column(name = "machine_address", nullable = false, unique = true)
    private String address;
    @Column(name = "machine_latitude" , nullable = false)
    private Double latitude;
    @Column(name = "machine_longitude" , nullable = false)
    private Double longitude;
    @Column(name ="estimated_time", nullable = false )
    private Integer estimatedPrepMinutes;
    @Column(nullable = false)
    private Boolean active = true;

    public Machine() {
    }

    public Machine(String name, String address, Double latitude, Double longitude, Integer estimatedPrepMinutes, Boolean active) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.estimatedPrepMinutes = estimatedPrepMinutes;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getEstimatedPrepMinutes() {
        return estimatedPrepMinutes;
    }

    public void setEstimatedPrepMinutes(Integer estimatedPrepMinutes) {
        this.estimatedPrepMinutes = estimatedPrepMinutes;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
