package com.example.ver2.entity;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class User {
    @Id
    @Column(name = "so_dien_thoai")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String soDienThoai;

    @Column(name = "username")
    private String username;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "gioi_tinh")
    private String gioiTinh;

    @Column(name = "ngay_sinh")
    private Date ngaySinh;

    @Column(name = "mat_khau", nullable = false)
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role idRole;

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
}

