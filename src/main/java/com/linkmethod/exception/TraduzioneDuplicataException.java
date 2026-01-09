package com.linkmethod.exception;

import java.io.Serial;

public class TraduzioneDuplicataException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -7560374081341119668L;

    public TraduzioneDuplicataException(String message) {
        super(message);
    }
}
