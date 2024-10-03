package com.example.ver2.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "product_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SanPhamChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_mau_sac")
    private MauSac idMauSac;

    @ManyToOne
    @JoinColumn(name = "id_size")
    private Size idSize;

    @ManyToOne
    @JoinColumn(name = "id_san_pham")
    private SanPham idSanPham;

    @ManyToOne
    @JoinColumn(name = "id_chat_lieu")
    private ChatLieu idChatLieu;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "gia_sp")
    private BigDecimal giaSp;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "create_by")
    private Integer createBy;

    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "update_by")
    private Integer updateBy;

    @Transient
    private List<String> hinhAnhUrl;
}

