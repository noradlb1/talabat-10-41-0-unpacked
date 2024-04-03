package com.talabat.sdsquad.data.restaurantsearch.requests;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/talabat/sdsquad/data/restaurantsearch/requests/ResturantSearchRequest;", "", "searchTerm", "", "branchIds", "keyboardType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBranchIds", "()Ljava/lang/String;", "setBranchIds", "(Ljava/lang/String;)V", "getKeyboardType", "setKeyboardType", "getSearchTerm", "setSearchTerm", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ResturantSearchRequest {
    @SerializedName("BranchIds")
    @NotNull
    private String branchIds;
    @SerializedName("KeyboardType")
    @NotNull
    private String keyboardType;
    @SerializedName("SearchTerm")
    @NotNull
    private String searchTerm;

    public ResturantSearchRequest(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "searchTerm");
        Intrinsics.checkNotNullParameter(str2, "branchIds");
        Intrinsics.checkNotNullParameter(str3, "keyboardType");
        this.searchTerm = str;
        this.branchIds = str2;
        this.keyboardType = str3;
    }

    public static /* synthetic */ ResturantSearchRequest copy$default(ResturantSearchRequest resturantSearchRequest, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = resturantSearchRequest.searchTerm;
        }
        if ((i11 & 2) != 0) {
            str2 = resturantSearchRequest.branchIds;
        }
        if ((i11 & 4) != 0) {
            str3 = resturantSearchRequest.keyboardType;
        }
        return resturantSearchRequest.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.searchTerm;
    }

    @NotNull
    public final String component2() {
        return this.branchIds;
    }

    @NotNull
    public final String component3() {
        return this.keyboardType;
    }

    @NotNull
    public final ResturantSearchRequest copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "searchTerm");
        Intrinsics.checkNotNullParameter(str2, "branchIds");
        Intrinsics.checkNotNullParameter(str3, "keyboardType");
        return new ResturantSearchRequest(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResturantSearchRequest)) {
            return false;
        }
        ResturantSearchRequest resturantSearchRequest = (ResturantSearchRequest) obj;
        return Intrinsics.areEqual((Object) this.searchTerm, (Object) resturantSearchRequest.searchTerm) && Intrinsics.areEqual((Object) this.branchIds, (Object) resturantSearchRequest.branchIds) && Intrinsics.areEqual((Object) this.keyboardType, (Object) resturantSearchRequest.keyboardType);
    }

    @NotNull
    public final String getBranchIds() {
        return this.branchIds;
    }

    @NotNull
    public final String getKeyboardType() {
        return this.keyboardType;
    }

    @NotNull
    public final String getSearchTerm() {
        return this.searchTerm;
    }

    public int hashCode() {
        return (((this.searchTerm.hashCode() * 31) + this.branchIds.hashCode()) * 31) + this.keyboardType.hashCode();
    }

    public final void setBranchIds(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.branchIds = str;
    }

    public final void setKeyboardType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keyboardType = str;
    }

    public final void setSearchTerm(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchTerm = str;
    }

    @NotNull
    public String toString() {
        String str = this.searchTerm;
        String str2 = this.branchIds;
        String str3 = this.keyboardType;
        return "ResturantSearchRequest(searchTerm=" + str + ", branchIds=" + str2 + ", keyboardType=" + str3 + ")";
    }
}
