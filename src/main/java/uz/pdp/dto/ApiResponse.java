package uz.pdp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {
    private String message;
    private Boolean success;
    private Object Object;

    public ApiResponse(String message, Boolean success) {
        this.message = message;
        this.success = success;
    }
}
