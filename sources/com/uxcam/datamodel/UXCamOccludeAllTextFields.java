package com.uxcam.datamodel;

import java.util.List;

public class UXCamOccludeAllTextFields implements UXCamOcclusion {

    /* renamed from: a  reason: collision with root package name */
    public final List f12935a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f12936b;

    public static class Builder {
        /* access modifiers changed from: private */
        public boolean excludeMentionedScreens = false;
        /* access modifiers changed from: private */
        public List screens = null;

        public UXCamOccludeAllTextFields build() {
            return new UXCamOccludeAllTextFields(this);
        }

        public Builder excludeMentionedScreens(boolean z11) {
            this.excludeMentionedScreens = z11;
            return this;
        }

        public Builder screens(List list) {
            this.screens = list;
            return this;
        }
    }

    public UXCamOccludeAllTextFields(Builder builder) {
        this.f12935a = builder.screens;
        this.f12936b = builder.excludeMentionedScreens;
    }

    public boolean getExcludeMentionedScreens() {
        return this.f12936b;
    }

    public List getScreens() {
        return this.f12935a;
    }

    public boolean isWithoutGesture() {
        return false;
    }
}
