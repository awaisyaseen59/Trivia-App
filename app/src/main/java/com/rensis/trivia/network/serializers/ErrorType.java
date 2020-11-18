package com.rensis.trivia.network.serializers;

public enum ErrorType {
    Email("email", "Email");
    private String key;
    private String alphaNumeric;

    ErrorType(String key, String alphaNumericName) {
        this.key = key;
        this.alphaNumeric = alphaNumericName;
    }

    public String getAlphaNumeric() {
        return alphaNumeric;
    }

    @Override
    public String toString() {
        return key;
    }
}
