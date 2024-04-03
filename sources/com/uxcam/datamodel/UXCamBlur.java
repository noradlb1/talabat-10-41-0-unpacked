package com.uxcam.datamodel;

import com.uxcam.internals.gm;
import java.util.List;

public class UXCamBlur implements UXCamOcclusion {

    /* renamed from: a  reason: collision with root package name */
    public final int f12931a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f12932b;

    /* renamed from: c  reason: collision with root package name */
    public final List f12933c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f12934d;

    public static class Builder {
        /* access modifiers changed from: private */
        public int blurRadius = gm.E;
        /* access modifiers changed from: private */
        public boolean excludeMentionedScreens = false;
        /* access modifiers changed from: private */
        public List screens = null;
        /* access modifiers changed from: private */
        public boolean withoutGesture = true;

        public Builder blurRadius(int i11) {
            this.blurRadius = i11;
            return this;
        }

        public UXCamBlur build() {
            return new UXCamBlur(this);
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

    public UXCamBlur(Builder builder) {
        this.f12931a = builder.blurRadius;
        this.f12932b = builder.withoutGesture;
        this.f12933c = builder.screens;
        this.f12934d = builder.excludeMentionedScreens;
    }

    public boolean getExcludeMentionedScreens() {
        return this.f12934d;
    }

    public List getScreens() {
        return this.f12933c;
    }

    public boolean isWithoutGesture() {
        return this.f12932b;
    }
}
