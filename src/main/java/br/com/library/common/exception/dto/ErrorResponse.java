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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
