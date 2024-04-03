package com.instabug.library.model;

import androidx.annotation.Nullable;
import java.io.Serializable;

public abstract class BaseReport implements Serializable {
    private boolean hasVideo = false;
    private boolean isVideoEncoded = false;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    public String f51502m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public State f51503n;

    @Nullable
    public String getId() {
        return this.f51502m;
    }

    @Nullable
    public State getState() {
        return this.f51503n;
    }

    public boolean hasVideo() {
        return this.hasVideo;
    }

    public boolean isVideoEncoded() {
        return this.isVideoEncoded;
    }

    public BaseReport setHasVideo(boolean z11) {
        this.hasVideo = z11;
        return this;
    }

    public BaseReport setId(@Nullable String str) {
        this.f51502m = str;
        return this;
    }

    public BaseReport setState(@Nullable State state) {
        this.f51503n = state;
        return this;
    }

    public BaseReport setVideoEncoded(boolean z11) {
        this.isVideoEncoded = z11;
        return this;
    }
}
