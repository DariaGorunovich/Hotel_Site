package com.aliaksey.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aliaksey on 18.03.2017.
 */
@Entity
@Table(name = "room_type")
public class RoomType implements Serializable {

    private Integer roomTypeId;
    private String roomName;
    private Integer blocksCount;
    private Integer bedsCount;
    private Integer costPerDay;
    private String additionalInformation;
    private RestroomType restroomType;
    private Set<Room> rooms = new HashSet<Room>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_type_id", unique = true, nullable = false)
    public Integer getRoomTypeId() {
        return this.roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "restroom_type_id", nullable = false)
    public RestroomType getRestroomType() {
        return this.restroomType;
    }

    public void setRestroomType(RestroomType restroomType) {
        this.restroomType = restroomType;
    }

    @Column(name = "room_name", unique = true, nullable = false, length = 45)
    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Column(name = "blocks_count", nullable = false)
    public Integer getBlocksCount() {
        return this.blocksCount;
    }

    public void setBlocksCount(Integer blocksCount) {
        this.blocksCount = blocksCount;
    }

    @Column(name = "beds_count", unique = true)
    public Integer getBedsCount() {
        return this.bedsCount;
    }

    public void setBedsCount(Integer bedsCount) {
        this.bedsCount = bedsCount;
    }

    @Column(name = "cost_per_day", nullable = false)
    public Integer getCostPerDay() {
        return this.costPerDay;
    }

    public void setCostPerDay(Integer costPerDay) {
        this.costPerDay = costPerDay;
    }

    @Column(name = "additional_inf", length = 45)
    public String getAdditionalInformation() {
        return this.additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomType")
    public Set<Room> getRooms() {
        return this.rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

}
