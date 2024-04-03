package com.talabat.restaurants.inlineads.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/talabat/restaurants/inlineads/data/Ad;", "", "adUnit", "", "position", "", "(Ljava/lang/String;I)V", "getAdUnit", "()Ljava/lang/String;", "setAdUnit", "(Ljava/lang/String;)V", "getPosition", "()I", "setPosition", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Ad {
    @NotNull
    private String adUnit;
    private int position;

    public Ad(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "adUnit");
        this.adUnit = str;
        this.position = i11;
    }

    public static /* synthetic */ Ad copy$default(Ad ad2, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = ad2.adUnit;
        }
        if ((i12 & 2) != 0) {
            i11 = ad2.position;
        }
        return ad2.copy(str, i11);
    }

    @NotNull
    public final String component1() {
        return this.adUnit;
    }

    public final int component2() {
        return this.position;
    }

    @NotNull
    public final Ad copy(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "adUnit");
        return new Ad(str, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ad)) {
            return false;
        }
        Ad ad2 = (Ad) obj;
        return Intrinsics.areEqual((Object) this.adUnit, (Object) ad2.adUnit) && this.position == ad2.position;
    }

    @NotNull
    public final String getAdUnit() {
        return this.adUnit;
    }

    public final int getPosition() {
        return this.position;
    }

    public int hashCode() {
        return (this.adUnit.hashCode() * 31) + this.position;
    }

    public final void setAdUnit(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adUnit = str;
    }

    public final void setPosition(int i11) {
        this.position = i11;
    }

    @NotNull
    public String toString() {
        String str = this.adUnit;
        int i11 = this.position;
        return "Ad(adUnit=" + str + ", position=" + i11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Ad(String str, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i12 & 2) != 0 ? 0 : i11);
    }
}
