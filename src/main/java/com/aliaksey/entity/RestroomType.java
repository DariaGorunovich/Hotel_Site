package com.aliaksey.entity;

import org.hibernate.validator.constraints.Range;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aliaksey on 17.03.2017.
 */
@Entity
@Table(name = "restroom_type")
public class RestroomType implements Serializable{

    private Integer restroomTypeId;

    @NotNull
    private ToiletType toiletType;

    @NotNull
    @Range(min = 1, max = 5)
    private Integer toiletsCount;

    @NotNull
    @Range(min = 1, max = 5)
    private Integer bathroomsCount;

    @NotNull
    @Size(min = 5, max = 45)
    private String name;

    private Set<Room> rooms = new HashSet<Room>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restroom_type_id", unique = true, nullable = false)
    public Integer getRestroomTypeId() {
        return this.restroomTypeId;
    }

    public void setRestroomTypeId(Integer restroomTypeId) {
        this.restroomTypeId = restroomTypeId;
    }

    @Column(name = "name", unique = true, nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "toilet_type", nullable = false)
    @Enumerated(EnumType.STRING)
    public ToiletType getToiletType() {
        return this.toiletType;
    }

    public void setToiletType(ToiletType toiletType) {
        this.toiletType = toiletType;
    }

    @Column(name = "toilets_count", nullable = false)
    public Integer getToiletsCount() {
        return this.toiletsCount;
    }

    public void setToiletsCount(Integer toiletsCount) {
        this.toiletsCount = toiletsCount;
    }

    @Column(name = "bathrooms_count", nullable = false)
    public Integer getBathroomsCount() {
        return this.bathroomsCount;
    }

    public void setBathroomsCount(Integer bathroomsCount) {
        this.bathroomsCount = bathroomsCount;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restroomType")
    public Set<Room> getRooms() {
        return  this.rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }



}