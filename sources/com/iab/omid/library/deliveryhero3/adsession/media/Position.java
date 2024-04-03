package com.iab.omid.library.deliveryhero3.adsession.media;

public enum Position {
    PREROLL("preroll"),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");
    
    private final String position;

    private Position(String str) {
        this.position = str;
    }

    public String toString() {
        return this.position;
    }
}
