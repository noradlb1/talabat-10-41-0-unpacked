package com.talabat.verticals.ui.customViewLCAware.model;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/model/Vertical;", "", "()V", "colorCode", "", "getColorCode", "()Ljava/lang/String;", "setColorCode", "(Ljava/lang/String;)V", "deeplink", "getDeeplink", "setDeeplink", "id", "", "getId", "()Ljava/lang/Integer;", "setId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "imageUrl", "getImageUrl", "setImageUrl", "name", "getName", "setName", "position", "getPosition", "setPosition", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Vertical {
    @Nullable
    private String colorCode;
    @Nullable
    private String deeplink = "";
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private Integer f12452id = 0;
    @Nullable
    private String imageUrl = "";
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private String f12453name = "";
    @Nullable
    private Integer position = 0;

    @Nullable
    public final String getColorCode() {
        return this.colorCode;
    }

    @Nullable
    public final String getDeeplink() {
        return this.deeplink;
    }

    @Nullable
    public final Integer getId() {
        return this.f12452id;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final String getName() {
        return this.f12453name;
    }

    @Nullable
    public final Integer getPosition() {
        return this.position;
    }

    public final void setColorCode(@Nullable String str) {
        this.colorCode = str;
    }

    public final void setDeeplink(@Nullable String str) {
        this.deeplink = str;
    }

    public final void setId(@Nullable Integer num) {
        this.f12452id = num;
    }

    public final void setImageUrl(@Nullable String str) {
        this.imageUrl = str;
    }

    public final void setName(@Nullable String str) {
        this.f12453name = str;
    }

    public final void setPosition(@Nullable Integer num) {
        this.position = num;
    }
}
