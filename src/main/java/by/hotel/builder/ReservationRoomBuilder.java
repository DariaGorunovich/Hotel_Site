package by.hotel.builder;

import by.hotel.bean.Reservation;
import by.hotel.bean.ReservationRoom;
import by.hotel.bean.Room;

public class ReservationRoomBuilder {
    private Room room;
    private Reservation reservation;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public ReservationRoomBuilder id(Integer id) {
        this.id = id;
        return this;
    }

    public ReservationRoomBuilder room(Room room){
        this.room = room;
        return this;
    }

    public ReservationRoomBuilder reservation(Reservation reservation){
        this.reservation = reservation;
        return this;
    }

    public Room getRoom() {
        return room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public ReservationRoom build(){
        return new ReservationRoom(this);
    }
}
