<template>
    <aside class="left-sidebar">
        <div class="brand-logo d-flex align-items-center justify-content-between">
          <router-link class="sidebar-link text-nowrap logo-img" to="/ban-hang">
            <img  style="width: 200px; height: 188px; padding-top: 20px; padding-left: 30px;"  src="/src/assets/images/logos/logo.png" alt="" />
             <h3 style="color: red; padding-top: 10px; padding-left: 20px;font-size: xx-large;">chillnfree</h3>
          </router-link>
          <div class="close-btn d-xl-none d-block sidebartoggler cursor-pointer" id="sidebarCollapse">
            <i class="ti ti-x fs-8"></i>
          </div>
        </div>
        <nav class="sidebar-nav scroll-sidebar" data-simplebar="">
          <ul id="sidebarnav">
            <li class="nav-small-cap">
              <i class="ti ti-dots nav-small-cap-icon fs-6"></i>
              <span class="hide-menu">HOME</span>
            </li>
            <li class="sidebar-item">
              <router-link class="sidebar-link" to="/ban-hang">
              <span>
                <i class="ti ti-shopping-cart"></i>
              </span>
              <span class="hide-menu">BÁN HÀNG</span>
             </router-link>
            </li>
            <li class="nav-small-cap">
                <i class="ti ti-dots nav-small-cap-icon fs-6"></i>
              <span class="hide-menu">DANH MỤC </span>
            </li>
            <li class="sidebar-item">
              <ul class="dropdown sidebar-item">
                <button class="btn sidebar-link dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                  <span>
                    <iconify-icon icon="solar:layers-minimalistic-bold-duotone" class="fs-6"></iconify-icon>
                  </span> QUẢN LÍ SẢN PHẨM
                </button>
                <ul class="dropdown-menu">
                  <li>
                    <a href="./sanpham.html">
                      <button class="dropdown-item hide-menu" type="button">SẢN PHẨM CHI TIẾT</button>
                    </a> 
                  </li>
                  <li>
                    <a>
                      <span class="dropdown-item hide-menu nav-small-cap px-3" disabled>DANH MỤC THUỘC TÍNH</span>
                    </a>
                  </li>
                  <li>
                    <a href="./sanpham.html">
                      <button class="dropdown-item hide-menu" type="button">SIZE</button>
                    </a> 
                  </li>
                  <li>
                    <a href="./sanpham.html">
                      <button class="dropdown-item hide-menu" type="button">MÀU SẮC</button>
                    </a> 
                  </li>
                  <li>
                    <a href="./sanpham.html">
                      <button class="dropdown-item hide-menu" type="button">HÃNG SẢN XUẤT</button>
                    </a> 
                  </li>
                  <li>
                    <a href="./sanpham.html">
                      <button class="dropdown-item hide-menu" type="button">LOẠI GIÀY</button>
                    </a> 
                  </li>
                  <li>
                    <a href="./sanpham.html">
                      <button class="dropdown-item hide-menu" type="button">CHẤT LIỆU </button>
                    </a> 
                  </li>
                </ul>
              </ul>  
          </li>
            <li class="sidebar-item">
                <ul class="dropdown sidebar-item">
                  <button class="btn sidebar-link dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <span><i class="ti ti-users"></i></span> QUẢN LÍ TÀI KHOẢN
                  </button>
                  <ul class="dropdown-menu">
                    <li>
                      <a href="./taikhoannhanvien.html">
                        <button class="dropdown-item hide-menu" type="button">NHÂN VIÊN</button>
                      </a> 
                    </li>
                    <li>
                      <a href="./taikhoankhach.html">
                        <button class="dropdown-item hide-menu" type="button">KHÁCH HÀNG</button>
                      </a> 
                    </li>
                  </ul>
                </ul>  
            </li>
            <li class="sidebar-item">   
              <a class="sidebar-link" href="./ui-card.html" aria-expanded="false">
                <span>
                  <i class="ti ti-receipt-2"></i>
                </span>
                <span class="hide-menu"> QUẢN LÍ HÓA ĐƠN</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="./ui-forms.html" aria-expanded="false">
                <span>
                  <i class="ti ti-tags"></i>
                </span>
                <span class="hide-menu">KHUYẾN MẠI</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="./ui-forms.html" aria-expanded="false">
                <span>
                  <i class="ti ti-refresh-dot"></i>
                </span>
                <span class="hide-menu">GIAO HÀNG </span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="./ui-typography.html" aria-expanded="false">
                <span>
                  <i class="ti ti-gift-card"></i>
                </span>
                <span class="hide-menu">VOUCHER</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="./login.html" aria-expanded="false">
                <span>
                  <iconify-icon icon="solar:login-3-bold-duotone" class="fs-6"></iconify-icon>
                </span>
                <span class="hide-menu">LOGIN</span>
              </a>
            </li>
            <li class="sidebar-item">
              <a class="sidebar-link" href="./register.html" aria-expanded="false">
                <span>
                  <iconify-icon icon="solar:user-plus-rounded-bold-duotone" class="fs-6"></iconify-icon>
                </span>
                <span class="hide-menu">REGISTER</span>
              </a>
            </li>   
          </ul>
        </nav>
    </aside>
    <div class="body-wrapper">
      <header class="app-header">
        <nav class="navbar navbar-expand-lg navbar-light">
          <ul class="navbar-nav">
            <li class="nav-item d-block d-xl-none">
              <a class="nav-link sidebartoggler nav-icon-hover" id="headerCollapse" href="javascript:void(0)">
                <i class="ti ti-menu-2"></i>
              </a>
            </li>
          </ul>
          <div class="navbar-collapse justify-content-end px-0" id="navbarNav">
            <ul class="navbar-nav flex-row ms-auto align-items-center justify-content-end">
              <li class="nav-item dropdown">
                <a class="nav-link nav-icon-hover" href="javascript:void(0)" id="drop2" data-bs-toggle="dropdown"
                  aria-expanded="false">
                  <img src="../assets/images/profile/user-1.jpg" alt="" width="35" height="35" class="rounded-circle">
                </a>
                <div class="dropdown-menu dropdown-menu-end dropdown-menu-animate-up" aria-labelledby="drop2">
                  <div class="message-body">
                    <a href="javascript:void(0)" class="d-flex align-items-center gap-2 dropdown-item">
                      <i class="ti ti-user fs-6"></i>
                      <p class="mb-0 fs-3">PROFILE</p>
                    </a>
                    <a href="./login.html" class="btn btn-outline-primary mx-3 mt-2 d-block">Logout</a>
                  </div>
                </div>
              </li>
            </ul>
          </div>
        </nav>  
      </header>
      <div class="container-fluid">
        <BanHang />
      </div>
    </div>  
</template>
<script>
import BanHang from '../views/BanHang.vue'

export default {
  name: 'Menu',
  components: {
    BanHang
  }
}
</script>
<style scoped>
.app-container {
  display: flex;
  min-height: 100vh;
}

.left-sidebar {
  width: 260px;
  position: fixed;
  left: 0;
  top: 0;
  bottom: 0;
  background-color: #f8f9fa;
  z-index: 1000;
  height: 100vh;
  overflow: hidden; 
}

.main-content {
  flex-grow: 1;
  margin-left: 250px;
  display: flex;
  flex-direction: column;
}

.app-header {
  position: sticky;
  top: 0;
  background-color: #fff;
  z-index: 999;
  box-shadow: 0 2px 4px rgba(0,0,0,.1);
}

.page-content {
  flex-grow: 1;
  padding: 20px;
}

.sidebar-nav {
  padding-top: 20px;
  height: calc(100vh - 20px); 
  overflow-y: auto; 
}

.navbar {
  padding-left: 20px;
  padding-right: 20px;
}

body {
  overflow-x: hidden;
}
</style>