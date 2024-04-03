package com.talabat.darkstores.data.voucher.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/data/voucher/model/Voucher;", "", "iconUrl", "", "text", "(Ljava/lang/String;Ljava/lang/String;)V", "getIconUrl", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Voucher {
    @NotNull
    private final String iconUrl;
    @NotNull
    private final String text;

    public Voucher(@NotNull @Json(name = "icon_image_url") String str, @NotNull @Json(name = "text") String str2) {
        Intrinsics.checkNotNullParameter(str, "iconUrl");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.iconUrl = str;
        this.text = str2;
    }

    public static /* synthetic */ Voucher copy$default(Voucher voucher, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = voucher.iconUrl;
        }
        if ((i11 & 2) != 0) {
            str2 = voucher.text;
        }
        return voucher.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.iconUrl;
    }

    @NotNull
    public final String component2() {
        return this.text;
    }

    @NotNull
    public final Voucher copy(@NotNull @Json(name = "icon_image_url") String str, @NotNull @Json(name = "text") String str2) {
        Intrinsics.checkNotNullParameter(str, "iconUrl");
        Intrinsics.checkNotNullParameter(str2, "text");
        return new Voucher(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Voucher)) {
            return false;
        }
        Voucher voucher = (Voucher) obj;
        return Intrinsics.areEqual((Object) this.iconUrl, (Object) voucher.iconUrl) && Intrinsics.areEqual((Object) this.text, (Object) voucher.text);
    }

    @NotNull
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (this.iconUrl.hashCode() * 31) + this.text.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.iconUrl;
        String str2 = this.text;
        return "Voucher(iconUrl=" + str + ", text=" + str2 + ")";
    }
}
