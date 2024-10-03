package com.example.ver2.repository.respone;

import com.example.ver2.entity.SanPhamChiTiet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamChiTietRepo extends JpaRepository<SanPhamChiTiet,Integer> {
    Page<SanPhamChiTiet> findAll(Pageable pageable);

    @Query("SELECT spct FROM SanPhamChiTiet spct " +
            "WHERE LOWER(CONCAT(spct.idSanPham.idHangSx.tenHang,' ', spct.idSanPham.tenSp)) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(spct.idSanPham.tenSp) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(spct.idSanPham.idHangSx.tenHang) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<SanPhamChiTiet> findByTenSpOrTenHangContaining(
            @Param("search") String search,
            Pageable pageable);
}
