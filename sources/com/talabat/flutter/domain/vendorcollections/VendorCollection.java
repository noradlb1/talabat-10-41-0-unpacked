package com.talabat.flutter.domain.vendorcollections;

import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/talabat/flutter/domain/vendorcollections/VendorCollection;", "", "id", "", "name", "", "imageUrl", "backgroundColor", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getId", "()I", "getImageUrl", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorCollection {
    @NotNull
    private final String backgroundColor;

    /* renamed from: id  reason: collision with root package name */
    private final int f59764id;
    @NotNull
    private final String imageUrl;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f59765name;

    public VendorCollection(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str3, TtmlNode.ATTR_TTS_BACKGROUND_COLOR);
        this.f59764id = i11;
        this.f59765name = str;
        this.imageUrl = str2;
        this.backgroundColor = str3;
    }

    public static /* synthetic */ VendorCollection copy$default(VendorCollection vendorCollection, int i11, String str, String str2, String str3, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = vendorCollection.f59764id;
        }
        if ((i12 & 2) != 0) {
            str = vendorCollection.f59765name;
        }
        if ((i12 & 4) != 0) {
            str2 = vendorCollection.imageUrl;
        }
        if ((i12 & 8) != 0) {
            str3 = vendorCollection.backgroundColor;
        }
        return vendorCollection.copy(i11, str, str2, str3);
    }

    public final int component1() {
        return this.f59764id;
    }

    @NotNull
    public final String component2() {
        return this.f59765name;
    }

    @NotNull
    public final String component3() {
        return this.imageUrl;
    }

    @NotNull
    public final String component4() {
        return this.backgroundColor;
    }

    @NotNull
    public final VendorCollection copy(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.IMAGE_URL_V2);
        Intrinsics.checkNotNullParameter(str3, TtmlNode.ATTR_TTS_BACKGROUND_COLOR);
        return new VendorCollection(i11, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VendorCollection)) {
            return false;
        }
        VendorCollection vendorCollection = (VendorCollection) obj;
        return this.f59764id == vendorCollection.f59764id && Intrinsics.areEqual((Object) this.f59765name, (Object) vendorCollection.f59765name) && Intrinsics.areEqual((Object) this.imageUrl, (Object) vendorCollection.imageUrl) && Intrinsics.areEqual((Object) this.backgroundColor, (Object) vendorCollection.backgroundColor);
    }

    @NotNull
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getId() {
        return this.f59764id;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getName() {
        return this.f59765name;
    }

    public int hashCode() {
        return (((((this.f59764id * 31) + this.f59765name.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.backgroundColor.hashCode();
    }

    @NotNull
    public String toString() {
        int i11 = this.f59764id;
        String str = this.f59765name;
        String str2 = this.imageUrl;
        String str3 = this.backgroundColor;
        return "VendorCollection(id=" + i11 + ", name=" + str + ", imageUrl=" + str2 + ", backgroundColor=" + str3 + ")";
    }
}
