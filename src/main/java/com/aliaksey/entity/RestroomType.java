package com.aliaksey.entity;

import javax.persistence.*;
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
    private ToiletType toiletType;
    private Integer toiletsCount;
    private Integer bathroomsCount;
    private Set<RoomType> roomTypes = new HashSet<RoomType>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restroom_type_id", unique = true, nullable = false)
    public Integer getRestroomTypeId() {
        return this.restroomTypeId;
    }

    public void setRestroomTypeId(Integer restroomTypeId) {
        this.restroomTypeId = restroomTypeId;
    }

    @Column(name = "toilet_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
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
    public Integer getBathtoomsCount() {
        return this.bathroomsCount;
    }

    public void setBathtoomsCount(Integer bathtoomsCount) {
        this.bathroomsCount = bathtoomsCount;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restroom_type")
    public Set<RoomType> getRoomTypes() {
        return  this.roomTypes;
    }

    public void setRoomTypes(Set<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }



}