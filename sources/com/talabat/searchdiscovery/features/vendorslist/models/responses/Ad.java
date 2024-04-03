package com.talabat.searchdiscovery.features.vendorslist.models.responses;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/searchdiscovery/features/vendorslist/models/responses/Ad;", "", "adUnit", "", "position", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getAdUnit", "()Ljava/lang/String;", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/talabat/searchdiscovery/features/vendorslist/models/responses/Ad;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Ad {
    @SerializedName("adUnit")
    @Nullable
    private final String adUnit;
    @SerializedName("position")
    @Nullable
    private final Integer position;

    public Ad(@Nullable String str, @Nullable Integer num) {
        this.adUnit = str;
        this.position = num;
    }

    public static /* synthetic */ Ad copy$default(Ad ad2, String str, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = ad2.adUnit;
        }
        if ((i11 & 2) != 0) {
            num = ad2.position;
        }
        return ad2.copy(str, num);
    }

    @Nullable
    public final String component1() {
        return this.adUnit;
    }

    @Nullable
    public final Integer component2() {
        return this.position;
    }

    @NotNull
    public final Ad copy(@Nullable String str, @Nullable Integer num) {
        return new Ad(str, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ad)) {
            return false;
        }
        Ad ad2 = (Ad) obj;
        return Intrinsics.areEqual((Object) this.adUnit, (Object) ad2.adUnit) && Intrinsics.areEqual((Object) this.position, (Object) ad2.position);
    }

    @Nullable
    public final String getAdUnit() {
        return this.adUnit;
    }

    @Nullable
    public final Integer getPosition() {
        return this.position;
    }

    public int hashCode() {
        String str = this.adUnit;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.position;
        if (num != null) {
            i11 = num.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.adUnit;
        Integer num = this.position;
        return "Ad(adUnit=" + str + ", position=" + num + ")";
    }
}
