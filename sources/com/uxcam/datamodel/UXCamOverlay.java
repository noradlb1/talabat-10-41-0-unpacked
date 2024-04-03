package com.uxcam.datamodel;

import java.util.List;

public class UXCamOverlay implements UXCamOcclusion {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f12937a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12938b = -65536;

    /* renamed from: c  reason: collision with root package name */
    public final List f12939c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f12940d;

    public static class Builder {
        private final int color = -65536;
        /* access modifiers changed from: private */
        public boolean excludeMentionedScreens = false;
        /* access modifiers changed from: private */
        public List screens = null;
        /* access modifiers changed from: private */
        public boolean withoutGesture = true;

        public UXCamOverlay build() {
            return new UXCamOverlay(this);
        }

        public Builder excludeMentionedScreens(boolean z11) {
            this.excludeMentionedScreens = z11;
            return this;
        }

        public Builder screens(List list) {
            this.screens = list;
            return this;
        }

        public Builder withoutGesture(boolean z11) {
            this.withoutGesture = z11;
            return this;
        }
    }

    public UXCamOverlay(Builder builder) {
        this.f12937a = builder.withoutGesture;
        this.f12939c = builder.screens;
        this.f12940d = builder.excludeMentionedScreens;
    }

    public boolean getExcludeMentionedScreens() {
        return this.f12940d;
    }

    public List getScreens() {
        return this.f12939c;
    }

    public boolean isWithoutGesture() {
        return this.f12937a;
    }
}
