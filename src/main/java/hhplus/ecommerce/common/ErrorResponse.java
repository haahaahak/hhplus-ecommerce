package hhplus.ecommerce.common;

public record ErrorResponse(
        int status,
		String error,
        String message
) {}
