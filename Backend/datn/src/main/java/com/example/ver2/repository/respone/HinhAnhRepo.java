package com.example.ver2.repository.respone;

import com.example.ver2.entity.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HinhAnhRepo extends JpaRepository<HinhAnh, Integer> {
    List<HinhAnh> findByIdProductDetailId(Integer id);
}
