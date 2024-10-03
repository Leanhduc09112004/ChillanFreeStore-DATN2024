package com.example.ver2.repository.respone;

import com.example.ver2.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepo extends JpaRepository<MauSac,Integer> {
}
