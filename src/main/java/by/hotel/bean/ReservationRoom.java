package by.hotel.bean;

import by.hotel.builder.ReservationRoomBuilder;
import org.springframework.stereotype.Component;

@Component
public class ReservationRoom {
    private Integer roomId;
    private Room room;
    private Reservation reservation;
    private Integer reservationRoomId;
    private Integer reservationId;

    public Integer getReservationRoomId() {
        return reservationRoomId;
    }

    public void setReservationRoomId(Integer reservationRoomId) {
        this.reservationRoomId = reservationRoomId;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public ReservationRoom(){super();}

    public ReservationRoom(ReservationRoomBuilder reservationRoomBuilder){
        this.room = reservationRoomBuilder.getRoom();
        this.reservation = reservationRoomBuilder.getReservation();
        this.roomId = reservationRoomBuilder.getId();
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationRoom that = (ReservationRoom) o;

        if (room != null ? !room.equals(that.room) : that.room != null) return false;
        return reservation != null ? reservation.equals(that.reservation) : that.reservation == null;
    }

    @Override
    public int hashCode() {
        int result = room != null ? room.hashCode() : 0;
        result = 31 * result + (reservation != null ? reservation.hashCode() : 0);
        return result;
    }
}
