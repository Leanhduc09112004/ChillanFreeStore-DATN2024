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
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn (name = "so_dien_thoai_khach")
    private KhachHang soDienThoaiKhach;
    @ManyToOne
    @JoinColumn(name = "so_dien_thoai_user")
    private User soDienThoaiUser;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name = "thoi_gian")
    private Date thoiGian;

    @Column(name = "trang_thai")
    private Integer trangThai;
    @ManyToOne
    @JoinColumn(name = "id_voucher")
    private Voucher idVoucher;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "create_by")
    private Integer createBy;

    @Column(name = "update_at")
    private Date updateAt;

    @Column(name = "update_by")
    private Integer updateBy;
}
