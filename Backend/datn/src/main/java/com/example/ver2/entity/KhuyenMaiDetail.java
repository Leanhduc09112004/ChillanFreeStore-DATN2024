package com.example.ver2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Data
@Entity
@Table(name = "khuyen_mai_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class KhuyenMaiDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_product_detail")
    private SanPhamChiTiet idProductDetail;

    @ManyToOne
    @JoinColumn(name = "id_khuyen_mai")
    private KhuyenMai idKhuyenMai;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "create_by")
    private Integer createBy;

    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "update_by")
    private Integer updateBy;
}
