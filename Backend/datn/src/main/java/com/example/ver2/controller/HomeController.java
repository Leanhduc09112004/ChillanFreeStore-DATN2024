package com.example.ver2.controller;

import com.example.ver2.entity.HinhAnh;
import com.example.ver2.entity.SanPham;
import com.example.ver2.entity.SanPhamChiTiet;
import com.example.ver2.repository.respone.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private SanPhamChiTietRepo spChiTietRepo;

    @Autowired
    private HinhAnhRepo hinhAnhRepo;

    @Autowired
    private MauSacRepo mauSacRepo;

    @Autowired
    private HangSanXuatRepo hangSanXuatRepo;

    @Autowired
    private LoaiGiayRepo loaiGiayRepo;

    @Autowired
    private SizeRepo sizeRepo;

    @Autowired
    private ChatLieuRepo chatLieuRepo;

    @Autowired
    private SanPhamRepo sanPhamRepo;

    @GetMapping("/san-pham")
    public ResponseEntity<Map<String, Object>> getSanPham(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size,
            @RequestParam(required = false) String search) {

        Pageable pageable = PageRequest.of(page, size);
        Page<SanPhamChiTiet> sanPhamPage;

        if (search != null && !search.isEmpty()) {
            sanPhamPage = spChiTietRepo.findByTenSpOrTenHangContaining(search, pageable);
        } else {
            sanPhamPage = spChiTietRepo.findAll(pageable);
        }

        List<HinhAnh> hinhAnhList = hinhAnhRepo.findAll();

        Map<Integer, List<String>> hinhAnhMap = processHinhAnhList(hinhAnhList);
        List<Map<String, Object>> processedSanPhamList = processSanPhamList(sanPhamPage.getContent(), hinhAnhMap);

        Map<String, Object> response = new HashMap<>();
        response.put("sanPhamList", processedSanPhamList);
        response.put("currentPage", sanPhamPage.getNumber());
        response.put("totalItems", sanPhamPage.getTotalElements());
        response.put("totalPages", sanPhamPage.getTotalPages());
        response.put("search", search);

        return ResponseEntity.ok(response);
    }


    @GetMapping("/san-pham/{id}")
    public ResponseEntity<Map<String, Object>> getSanPhamDetail(@PathVariable Integer id) {
        SanPhamChiTiet sanPham = spChiTietRepo.findById(id).orElse(null);
        if (sanPham == null) {
            return ResponseEntity.notFound().build();
        }

        List<HinhAnh> hinhAnhList = hinhAnhRepo.findByIdProductDetailId(id);
        Map<Integer, List<String>> hinhAnhMap = processHinhAnhList(hinhAnhList);

        Map<String, Object> sanPhamMap = new HashMap<>();
        sanPhamMap.put("id", sanPham.getId());
        sanPhamMap.put("soLuong", sanPham.getSoLuong());
        sanPhamMap.put("giaSp", sanPham.getGiaSp());
        sanPhamMap.put("trangThai", sanPham.getTrangThai());


        if (sanPham.getIdSanPham() != null) {
            Map<String, Object> sanPhamInfo = new HashMap<>();
            sanPhamInfo.put("id", sanPham.getIdSanPham().getId());
            sanPhamInfo.put("tenSp", sanPham.getIdSanPham().getTenSp());
            sanPhamInfo.put("moTa", sanPham.getIdSanPham().getMoTa());
            sanPhamInfo.put("trangThai", sanPham.getTrangThai());

            if (sanPham.getIdSanPham().getIdHangSx() != null) {
                Map<String, Object> hangInfo = new HashMap<>();
                hangInfo.put("id", sanPham.getIdSanPham().getIdHangSx().getId());
                hangInfo.put("tenHang", sanPham.getIdSanPham().getIdHangSx().getTenHang());
                sanPhamMap.put("idHang", hangInfo);
            }
            ;

            if (sanPham.getIdSanPham().getIdLoaiGiay() != null) {
                Map<String, Object> loaiGiayInfo = new HashMap<>();
                loaiGiayInfo.put("id", sanPham.getIdSanPham().getIdLoaiGiay().getId());
                loaiGiayInfo.put("tenLoaiGiay", sanPham.getIdSanPham().getIdLoaiGiay().getTenLoaiGiay());
                sanPhamMap.put("idLoaiGiay", loaiGiayInfo);
            }
            ;

            if (sanPham.getIdMauSac() != null) {
                Map<String, Object> mauSacInfo = new HashMap<>();
                mauSacInfo.put("id", sanPham.getIdMauSac().getId());
                mauSacInfo.put("tenMauSac", sanPham.getIdMauSac().getTenMauSac());
                sanPhamMap.put("idMauSac", mauSacInfo);
            }
            ;


            if (sanPham.getIdSize() != null) {
                Map<String, Object> sizeInfo = new HashMap<>();
                sizeInfo.put("id", sanPham.getIdSize().getId());
                sizeInfo.put("tenSize", sanPham.getIdSize().getTenSize());
                sanPhamMap.put("idSize", sizeInfo);
            }

            if (sanPham.getIdChatLieu() != null) {
                Map<String, Object> chatLieuInfo = new HashMap<>();
                chatLieuInfo.put("id", sanPham.getIdChatLieu().getId());
                chatLieuInfo.put("tenChatLieu", sanPham.getIdChatLieu().getTenChatLieu());
                sanPhamMap.put("idChatLieu", chatLieuInfo);
            }

            sanPhamMap.put("idSanPham", sanPhamInfo);
        }

        sanPhamMap.put("hinhAnhs", hinhAnhMap.getOrDefault(sanPham.getId(), new ArrayList<>()));
        sanPhamMap.put("mauSacList", mauSacRepo.findAll());
        sanPhamMap.put("sizeList", sizeRepo.findAll());
        sanPhamMap.put("hangList", hangSanXuatRepo.findAll());
        sanPhamMap.put("loaiGiayList", loaiGiayRepo.findAll());
        sanPhamMap.put("chatLieuList", chatLieuRepo.findAll());


        return ResponseEntity.ok(sanPhamMap);
    }

    private Map<Integer, List<String>> processHinhAnhList(List<HinhAnh> hinhAnhList) {
        return hinhAnhList.stream()
                .collect(Collectors.groupingBy
                        (ha -> ha.getIdProductDetail().getId(), Collectors.mapping(HinhAnh::getHinhAnh, Collectors.toList())));
    }

    private List<Map<String, Object>> processSanPhamList(List<SanPhamChiTiet> sanPhamList, Map<Integer, List<String>> hinhAnhMap) {
        return sanPhamList.stream().map(sp -> {
            Map<String, Object> sanPhamMap = new HashMap<>();
            sanPhamMap.put("id", sp.getId());
            sanPhamMap.put("soLuong", sp.getSoLuong());
            sanPhamMap.put("giaSp", sp.getGiaSp());
            sanPhamMap.put("trangThai", sp.getTrangThai());

            if (sp.getIdSanPham() != null) {
                Map<String, Object> sanPhamInfo = new HashMap<>();
                sanPhamInfo.put("id", sp.getIdSanPham().getId());
                sanPhamInfo.put("tenSp", sp.getIdSanPham().getTenSp());
                sanPhamInfo.put("moTa", sp.getIdSanPham().getMoTa());

                if (sp.getIdSanPham().getIdLoaiGiay() != null) {
                    Map<String, Object> loaiGiayInfo = new HashMap<>();
                    loaiGiayInfo.put("id", sp.getIdSanPham().getIdLoaiGiay().getId());
                    loaiGiayInfo.put("tenLoaiGiay", sp.getIdSanPham().getIdLoaiGiay().getTenLoaiGiay());
                    sanPhamInfo.put("idLoaiGiay", loaiGiayInfo);
                }

                if (sp.getIdSanPham().getIdHangSx() != null) {
                    Map<String, Object> HangInfo = new HashMap<>();
                    HangInfo.put("id", sp.getIdSanPham().getIdHangSx().getId());
                    HangInfo.put("tenHang", sp.getIdSanPham().getIdHangSx().getTenHang());
                    sanPhamInfo.put("idHang", HangInfo);
                }

                sanPhamMap.put("idSanPham", sanPhamInfo);
            }
            ;

            if (sp.getIdMauSac() != null) {
                Map<String, Object> mauSacInfo = new HashMap<>();
                mauSacInfo.put("id", sp.getIdMauSac().getId());
                mauSacInfo.put("tenMauSac", sp.getIdMauSac().getTenMauSac());
                sanPhamMap.put("idMauSac", mauSacInfo);
            }
            ;
            if (sp.getIdSize() != null) {
                Map<String, Object> sizeInfo = new HashMap<>();
                sizeInfo.put("id", sp.getIdSize().getId());
                sizeInfo.put("tenSize", sp.getIdSize().getTenSize());
                sanPhamMap.put("idSize", sizeInfo);
            }
            ;

            if (sp.getIdChatLieu() != null) {
                Map<String, Object> chatLieuInfo = new HashMap<>();
                chatLieuInfo.put("id", sp.getIdChatLieu().getId());
                chatLieuInfo.put("tenChatLieu", sp.getIdChatLieu().getTenChatLieu());
                sanPhamMap.put("idChatLieu", chatLieuInfo);
            }

            sanPhamMap.put("hinhAnhs", hinhAnhMap.getOrDefault(sp.getId(), new ArrayList<>()));

            return sanPhamMap;
        }).collect(Collectors.toList());
    }

    @GetMapping("/view-them")
    public ResponseEntity<Map<String, Object>> getViewThem() {
        Map<String, Object> response = new HashMap<>();
        response.put("mauSacList", mauSacRepo.findAll());
        response.put("sizeList", sizeRepo.findAll());
        response.put("hangList", hangSanXuatRepo.findAll());
        response.put("loaiGiayList", loaiGiayRepo.findAll());
        response.put("chatLieuList", chatLieuRepo.findAll());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/them-sp")
    public ResponseEntity<SanPhamChiTiet> addSanPhamChiTiet(@RequestBody SanPhamChiTiet sanPhamChiTiet) {
        if (sanPhamChiTiet.getIdSanPham() != null && sanPhamChiTiet.getIdSanPham().getId() == null) {
            SanPham sanPham = sanPhamRepo.save(sanPhamChiTiet.getIdSanPham());
            sanPhamChiTiet.setIdSanPham(sanPham);
        }

        SanPhamChiTiet savedSanPhamChiTiet = spChiTietRepo.save(sanPhamChiTiet);

        List<String> hinhAnhUrls = sanPhamChiTiet.getHinhAnhUrl();
        if (hinhAnhUrls != null && !hinhAnhUrls.isEmpty()) {
            for (String url : hinhAnhUrls) {
                HinhAnh hinhAnh = new HinhAnh();
                hinhAnh.setIdProductDetail(savedSanPhamChiTiet);
                hinhAnh.setHinhAnh(url);
                hinhAnhRepo.save(hinhAnh);
            }
        }

        return ResponseEntity.ok(savedSanPhamChiTiet);
    }
}
