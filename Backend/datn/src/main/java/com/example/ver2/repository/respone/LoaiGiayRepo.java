package com.example.ver2.repository.respone;

import com.example.ver2.entity.LoaiGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiGiayRepo extends JpaRepository<LoaiGiay,Integer> {
}
