package br.com.library.common.exception.dto;

public class ErrorResponse {

    private Integer status;
    private String message;
    private Long timestamp;
    private String origin;

    public ErrorResponse(Integer status, String message, Long timestamp, String origin) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.origin = origin;
    }

    Integer getStatus() {
        return status;
    }

    void setStatus(Integer status) {
        this.status = status;
    }

    String getMessage() {
        return message;
    }

    void setMessage(String message) {
        this.message = message;
    }

    Long getTimestamp() {
        return timestamp;
    }

    void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    String getOrigin() {
        return origin;
    }

    void setOrigin(String origin) {
        this.origin = origin;
    }
}
