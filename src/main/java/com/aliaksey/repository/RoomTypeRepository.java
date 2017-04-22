package com.aliaksey.repository;

import com.aliaksey.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Aliaksey on 22.03.2017.
 */
@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType,Integer> {

}
