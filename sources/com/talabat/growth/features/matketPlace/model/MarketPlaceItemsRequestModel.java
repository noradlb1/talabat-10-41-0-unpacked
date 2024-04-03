package com.talabat.growth.features.matketPlace.model;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tR\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/talabat/growth/features/matketPlace/model/MarketPlaceItemsRequestModel;", "", "country", "", "languageCode", "pageNumber", "", "pageSize", "areaId", "(Ljava/lang/String;Ljava/lang/String;III)V", "getAreaId", "()I", "setAreaId", "(I)V", "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "getLanguageCode", "setLanguageCode", "getPageNumber", "setPageNumber", "getPageSize", "setPageSize", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MarketPlaceItemsRequestModel {
    private int areaId;
    @NotNull
    private String country;
    @NotNull
    private String languageCode;
    private int pageNumber;
    private int pageSize;

    public MarketPlaceItemsRequestModel(@NotNull String str, @NotNull String str2, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(str2, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        this.country = str;
        this.languageCode = str2;
        this.pageNumber = i11;
        this.pageSize = i12;
        this.areaId = i13;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    @NotNull
    public final String getCountry() {
        return this.country;
    }

    @NotNull
    public final String getLanguageCode() {
        return this.languageCode;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final void setAreaId(int i11) {
        this.areaId = i11;
    }

    public final void setCountry(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.country = str;
    }

    public final void setLanguageCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.languageCode = str;
    }

    public final void setPageNumber(int i11) {
        this.pageNumber = i11;
    }

    public final void setPageSize(int i11) {
        this.pageSize = i11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MarketPlaceItemsRequestModel(String str, String str2, int i11, int i12, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? "" : str, (i14 & 2) != 0 ? "en" : str2, (i14 & 4) != 0 ? 1 : i11, (i14 & 8) != 0 ? 20 : i12, i13);
    }
}
