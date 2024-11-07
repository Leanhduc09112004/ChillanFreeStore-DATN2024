<script>
    const existingCustomers = [
        { phone: '0355650496', email: 'nguyenvana@example.com', name: 'Nguyễn Văn A', gender: 'Nam', dob: '1990-01-01' },
        // Có thể thêm các khách hàng khác nếu cần
    ];

    function isPhoneAndEmailUnique(phone, email, index) {
        return !existingCustomers.some((customer, i) => (i !== index) && (customer.phone === phone || customer.email === email));
    }

    function submitCustomerForm() {
        const phone = document.getElementById('customerPhone').value;
        const email = document.getElementById('customerEmail').value;

        if (!isPhoneAndEmailUnique(phone, email, -1)) {
            alert("Số điện thoại hoặc email đã tồn tại. Vui lòng kiểm tra lại!");
            return;
        }

        const newCustomer = {
            phone,
            email,
            name: document.getElementById('customerName').value,
            gender: document.getElementById('customerGender').value,
            dob: document.getElementById('customerDob').value
        };
        
        existingCustomers.push(newCustomer);
        
        // Cập nhật bảng
        updateCustomerTable();
        
        // Đóng modal và reset form
        $('#addCustomerModal').modal('hide');
        document.getElementById('addCustomerForm').reset();
    }

    function editCustomer(index, phone, name, gender, dob, email) {
        document.getElementById('editCustomerIndex').value = index - 1; // Lưu trữ chỉ số
        document.getElementById('editCustomerName').value = name;
        document.getElementById('editCustomerPhone').value = phone;
        document.getElementById('editCustomerGender').value = gender;
        document.getElementById('editCustomerDob').value = dob;
        document.getElementById('editCustomerEmail').value = email;
        
        // Mở modal chỉnh sửa
        $('#editCustomerModal').modal('show');
    }

    function updateCustomer() {
        const index = document.getElementById('editCustomerIndex').value;
        const phone = document.getElementById('editCustomerPhone').value;
        const email = document.getElementById('editCustomerEmail').value;

        if (!isPhoneAndEmailUnique(phone, email, index)) {
            alert("Số điện thoại hoặc email đã tồn tại. Vui lòng kiểm tra lại!");
            return;
        }

        existingCustomers[index] = {
            phone,
            email,
            name: document.getElementById('editCustomerName').value,
            gender: document.getElementById('editCustomerGender').value,
            dob: document.getElementById('editCustomerDob').value
        };

        // Cập nhật bảng
        updateCustomerTable();
        
        // Đóng modal và reset form
        $('#editCustomerModal').modal('hide');
        document.getElementById('editCustomerForm').reset();
    }

    function updateCustomerTable() {
        const tbody = document.querySelector('#customerTable tbody');
        tbody.innerHTML = ''; // Xóa nội dung hiện tại
        
        existingCustomers.forEach((customer, index) => {
            const newRow = `
                <tr>
                    <td class="text-center">${index + 1}</td>
                    <td class="text-center">${customer.phone}</td>
                    <td class="text-center">${customer.name}</td>
                    <td class="text-center">${customer.gender}</td>
                    <td class="text-center">${customer.dob}</td>
                    <td class="text-center">${customer.email}</td>
                    <td class="text-center">
                        <button class="btn btn-link" onclick="editCustomer(${index + 1}, '${customer.phone}', '${customer.name}', '${customer.gender}', '${customer.dob}', '${customer.email}')">
                            <i class="fas fa-edit"></i>
                        </button>
                    </td>
                </tr>
            `;
            tbody.insertAdjacentHTML('beforeend', newRow);
        });
    }
</script>
<template><div class="container mx-auto bg-white p-6 rounded shadow">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h1 class="h4">Quản lý khách hàng</h1>
        <button class="btn btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#addCustomerModal">+ Tạo tài khoản</button>
    </div>
    
    <div class="d-flex justify-content-between align-items-center mb-4">
        <div class="d-flex align-items-center">
            <label for="recordsCustomer" class="me-2">Hiển thị</label>
            <select id="recordsCustomer" class="form-select">
                <option>10</option>
                <option>20</option>
                <option>30</option>
            </select>
            <span class="ms-2">bản ghi</span>
        </div>
        <div>
            <label for="searchCustomer" class="me-2">Tìm kiếm:</label>
            <input type="text" id="searchCustomer" class="form-control" placeholder="Nhập từ khóa">
        </div>
    </div>
    
    <div class="table-responsive">
        <table class="table table-bordered" id="customerTable">
            <thead class="table-light">
                <tr>
                    <th>STT</th>
                    <th>Số điện thoại</th>
                    <th>Họ và tên</th>
                    <th>Giới tính</th>
                    <th>Ngày sinh</th>
                    <th>Email</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="text-center">1</td>
                    <td class="text-center">0355650496</td>
                    <td class="text-center">Nguyễn Văn A</td>
                    <td class="text-center">Nam</td>
                    <td class="text-center">01/01/1990</td>
                    <td class="text-center">nguyenvana@example.com</td>
                    <td class="text-center">
                        <button class="btn btn-link" onclick="editCustomer(1, '0355650496', 'Nguyễn Văn A', 'Nam', '1990-01-01', 'nguyenvana@example.com')">
                            <i class="fas fa-edit"></i>
                        </button>
                    </td>
                </tr>
                <!-- Repeat for each row as needed -->
            </tbody>
        </table>
    </div>
</div>

<!-- Modal Thêm mới khách hàng -->
<div class="modal fade" id="addCustomerModal" tabindex="-1" aria-labelledby="addCustomerModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addCustomerModalLabel">Thêm mới khách hàng</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="addCustomerForm">
                    <div class="mb-3">
                        <label for="customerName" class="form-label">Họ và tên</label>
                        <input type="text" class="form-control" id="customerName" required>
                    </div>
                    <div class="mb-3">
                        <label for="customerPhone" class="form-label">Số điện thoại</label>
                        <input type="tel" class="form-control" id="customerPhone" required>
                    </div>
                    <div class="mb-3">
                        <label for="customerGender" class="form-label">Giới tính</label>
                        <select class="form-select" id="customerGender" required>
                            <option value="">Chọn giới tính</option>
                            <option value="male">Nam</option>
                            <option value="female">Nữ</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="customerDob" class="form-label">Ngày sinh</label>
                        <input type="date" class="form-control" id="customerDob" required>
                    </div>
                    <div class="mb-3">
                        <label for="customerEmail" class="form-label">Email</label>
                        <input type="email" class="form-control" id="customerEmail" required>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                <button type="button" class="btn btn-primary" onclick="submitCustomerForm()">Lưu</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal Chỉnh sửa khách hàng -->
<div class="modal fade" id="editCustomerModal" tabindex="-1" aria-labelledby="editCustomerModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editCustomerModalLabel">Chỉnh sửa khách hàng</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="editCustomerForm">
                    <input type="hidden" id="editCustomerIndex">
                    <div class="mb-3">
                        <label for="editCustomerName" class="form-label">Họ và tên</label>
                        <input type="text" class="form-control" id="editCustomerName" required>
                    </div>
                    <div class="mb-3">
                        <label for="editCustomerPhone" class="form-label">Số điện thoại</label>
                        <input type="tel" class="form-control" id="editCustomerPhone" required>
                    </div>
                    <div class="mb-3">
                        <label for="editCustomerGender" class="form-label">Giới tính</label>
                        <select class="form-select" id="editCustomerGender" required>
                            <option value="">Chọn giới tính</option>
                            <option value="male">Nam</option>
                            <option value="female">Nữ</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="editCustomerDob" class="form-label">Ngày sinh</label>
                        <input type="date" class="form-control" id="editCustomerDob" required>
                    </div>
                    <div class="mb-3">
                        <label for="editCustomerEmail" class="form-label">Email</label>
                        <input type="email" class="form-control" id="editCustomerEmail" required>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                <button type="button" class="btn btn-primary" onclick="updateCustomer()">Cập nhật</button>
            </div>
        </div>
    </div>
</div></template>

<style></style>