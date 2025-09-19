package com.thucdozz.japaneseVocabExtension.exception;

import org.springframework.http.HttpStatus;

public enum ErrorEnum {
    // ------------------------------------------------
    // 4xx LỖI PHÍA CLIENT
    // ------------------------------------------------
    
    // 400 Bad Request - Lỗi dữ liệu đầu vào
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "Dữ liệu đầu vào không hợp lệ. Vui lòng kiểm tra lại các trường."),           // Đầu vào không hợp lệ
    USERNAME_EXISTS(HttpStatus.BAD_REQUEST, "Tên đăng nhập đã tồn tại."),         // Tên đăng nhập đã tồn tại
    EMAIL_EXISTS(HttpStatus.BAD_REQUEST, "Email đã tồn tại."),            // Email đã tồn tại
    EMAIL_FORMAT_ERROR(HttpStatus.BAD_REQUEST, "Định dạng email sai."),      // Định dạng email sai
    PASSWORD_TOO_SHORT(HttpStatus.BAD_REQUEST, "Mật khẩu quá ngắn."),      // Mật khẩu quá ngắn
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "Không tìm thấy user."),       // Không tìm thấy user
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Không có quyền truy cập."),            // Không có quyền truy cập
    FORBIDDEN(HttpStatus.FORBIDDEN, "Bị từ chối truy cập."),               // Bị từ chối truy cập
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Lỗi hệ thống."),          // Lỗi hệ thống
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "Không tìm thấy tài nguyên."),      // Không tìm thấy tài nguyên
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "Lỗi xác thực dữ liệu.");         // Lỗi xác thực dữ liệu

    private final HttpStatus status;
    private final String message;

    ErrorEnum(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public HttpStatus getStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
}
