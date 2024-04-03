package com.airbnb.lottie.model;

public class Marker {
    private static final String CARRIAGE_RETURN = "\r";
    public final float durationFrames;

    /* renamed from: name  reason: collision with root package name */
    private final String f40644name;
    public final float startFrame;

    public Marker(String str, float f11, float f12) {
        this.f40644name = str;
        this.durationFrames = f12;
        this.startFrame = f11;
    }

    public float getDurationFrames() {
        return this.durationFrames;
    }

    public String getName() {
        return this.f40644name;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public boolean matchesName(String str) {
        if (this.f40644name.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f40644name.endsWith("\r")) {
            String str2 = this.f40644name;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
