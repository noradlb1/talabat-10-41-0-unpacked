package com.bumptech.glide;

public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);
    
    private final float multiplier;

    private MemoryCategory(float f11) {
        this.multiplier = f11;
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
