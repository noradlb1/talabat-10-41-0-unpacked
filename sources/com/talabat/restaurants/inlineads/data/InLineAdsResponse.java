package com.talabat.restaurants.inlineads.data;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/talabat/restaurants/inlineads/data/InLineAdsResponse;", "", "ads", "Ljava/util/ArrayList;", "Lcom/talabat/restaurants/inlineads/data/Ad;", "(Ljava/util/ArrayList;)V", "getAds", "()Ljava/util/ArrayList;", "setAds", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InLineAdsResponse {
    @Nullable
    private ArrayList<Ad> ads;

    public InLineAdsResponse() {
        this((ArrayList) null, 1, (DefaultConstructorMarker) null);
    }

    public InLineAdsResponse(@Nullable ArrayList<Ad> arrayList) {
        this.ads = arrayList;
    }

    public static /* synthetic */ InLineAdsResponse copy$default(InLineAdsResponse inLineAdsResponse, ArrayList<Ad> arrayList, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            arrayList = inLineAdsResponse.ads;
        }
        return inLineAdsResponse.copy(arrayList);
    }

    @Nullable
    public final ArrayList<Ad> component1() {
        return this.ads;
    }

    @NotNull
    public final InLineAdsResponse copy(@Nullable ArrayList<Ad> arrayList) {
        return new InLineAdsResponse(arrayList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InLineAdsResponse) && Intrinsics.areEqual((Object) this.ads, (Object) ((InLineAdsResponse) obj).ads);
    }

    @Nullable
    public final ArrayList<Ad> getAds() {
        return this.ads;
    }

    public int hashCode() {
        ArrayList<Ad> arrayList = this.ads;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.hashCode();
    }

    public final void setAds(@Nullable ArrayList<Ad> arrayList) {
        this.ads = arrayList;
    }

    @NotNull
    public String toString() {
        ArrayList<Ad> arrayList = this.ads;
        return "InLineAdsResponse(ads=" + arrayList + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InLineAdsResponse(ArrayList arrayList, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : arrayList);
    }
}
