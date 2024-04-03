package com.deliveryhero.customerchat.fwf;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/deliveryhero/customerchat/fwf/FWFRequest;", "", "custom", "Lcom/deliveryhero/customerchat/fwf/Custom;", "featureList", "", "", "userId", "(Lcom/deliveryhero/customerchat/fwf/Custom;Ljava/util/List;Ljava/lang/String;)V", "getCustom", "()Lcom/deliveryhero/customerchat/fwf/Custom;", "getFeatureList", "()Ljava/util/List;", "getUserId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FWFRequest {
    @Nullable
    private final Custom custom;
    @NotNull
    private final List<String> featureList;
    @NotNull
    private final String userId;

    public FWFRequest(@Nullable @Json(name = "custom") Custom custom2, @NotNull @Json(name = "featureList") List<String> list, @NotNull @Json(name = "userId") String str) {
        Intrinsics.checkNotNullParameter(list, "featureList");
        Intrinsics.checkNotNullParameter(str, "userId");
        this.custom = custom2;
        this.featureList = list;
        this.userId = str;
    }

    public static /* synthetic */ FWFRequest copy$default(FWFRequest fWFRequest, Custom custom2, List<String> list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            custom2 = fWFRequest.custom;
        }
        if ((i11 & 2) != 0) {
            list = fWFRequest.featureList;
        }
        if ((i11 & 4) != 0) {
            str = fWFRequest.userId;
        }
        return fWFRequest.copy(custom2, list, str);
    }

    @Nullable
    public final Custom component1() {
        return this.custom;
    }

    @NotNull
    public final List<String> component2() {
        return this.featureList;
    }

    @NotNull
    public final String component3() {
        return this.userId;
    }

    @NotNull
    public final FWFRequest copy(@Nullable @Json(name = "custom") Custom custom2, @NotNull @Json(name = "featureList") List<String> list, @NotNull @Json(name = "userId") String str) {
        Intrinsics.checkNotNullParameter(list, "featureList");
        Intrinsics.checkNotNullParameter(str, "userId");
        return new FWFRequest(custom2, list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FWFRequest)) {
            return false;
        }
        FWFRequest fWFRequest = (FWFRequest) obj;
        return Intrinsics.areEqual((Object) this.custom, (Object) fWFRequest.custom) && Intrinsics.areEqual((Object) this.featureList, (Object) fWFRequest.featureList) && Intrinsics.areEqual((Object) this.userId, (Object) fWFRequest.userId);
    }

    @Nullable
    public final Custom getCustom() {
        return this.custom;
    }

    @NotNull
    public final List<String> getFeatureList() {
        return this.featureList;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        Custom custom2 = this.custom;
        return ((((custom2 == null ? 0 : custom2.hashCode()) * 31) + this.featureList.hashCode()) * 31) + this.userId.hashCode();
    }

    @NotNull
    public String toString() {
        return "FWFRequest(custom=" + this.custom + ", featureList=" + this.featureList + ", userId=" + this.userId + ')';
    }
}
