package com.aliaksey.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aliaksey on 17.03.2017.
 */
@Entity
@Table(name = "restroom_type")
@Transactional
public class RestroomType implements Serializable{

    private Integer restroomTypeId;
    private ToiletType toiletType;
    private Integer toiletsCount;
    private Integer bathroomsCount;
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

    @Column(name = "bathromms_count", nullable = false)
    public Integer getBathtoomsCount() {
        return this.bathroomsCount;
    }

    public void setBathtoomsCount(Integer bathtoomsCount) {
        this.bathroomsCount = bathtoomsCount;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restroomType")
    public Set<Room> getRooms() {
        return  this.rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }



}