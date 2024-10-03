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


@Data
@Entity
@Table(name = "cart_detail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CartDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cart")
    private CartItem idCart;

    @ManyToOne
    @JoinColumn(name = "id_product_detail")
    private SanPhamChiTiet idProductDetail;

    @Column(name = "so_luong")
    private Integer soLuong;
}
