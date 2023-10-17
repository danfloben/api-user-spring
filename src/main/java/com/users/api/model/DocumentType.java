package com.users.api.model;

public enum DocumentType {

    PASSPORT("P"),
    ID_CARD("C");

    private String documentType;

    private DocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentType() {
        return documentType;
    }

}