package com.talabat.talabatlife.features.vendors.vendorList.models.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b \u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/talabat/talabatlife/features/vendors/vendorList/models/request/VendorListRequestModel;", "", "countryCode", "", "lat", "", "pathParams", "long", "pageNumber", "pageSize", "searchString", "areaID", "sectionTheList", "", "offerFilterId", "cuisineId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ZII)V", "getAreaID", "()Ljava/lang/String;", "setAreaID", "(Ljava/lang/String;)V", "getCountryCode", "()I", "setCountryCode", "(I)V", "getCuisineId", "setCuisineId", "getLat", "setLat", "getLong", "setLong", "getOfferFilterId", "setOfferFilterId", "getPageNumber", "setPageNumber", "getPageSize", "setPageSize", "getPathParams", "setPathParams", "getSearchString", "setSearchString", "getSectionTheList", "()Z", "setSectionTheList", "(Z)V", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorListRequestModel {
    @Nullable
    private String areaID;
    private int countryCode;
    private int cuisineId;
    @Nullable
    private String lat;
    @Nullable

    /* renamed from: long  reason: not valid java name */
    private String f52long;
    private int offerFilterId;
    private int pageNumber;
    private int pageSize;
    @NotNull
    private String pathParams;
    @Nullable
    private String searchString;
    private boolean sectionTheList;

    public VendorListRequestModel() {
        this(0, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, false, 0, 0, 2047, (DefaultConstructorMarker) null);
    }

    public VendorListRequestModel(int i11, @Nullable String str, @NotNull String str2, @Nullable String str3, int i12, int i13, @Nullable String str4, @Nullable String str5, boolean z11, int i14, int i15) {
        Intrinsics.checkNotNullParameter(str2, "pathParams");
        this.countryCode = i11;
        this.lat = str;
        this.pathParams = str2;
        this.f52long = str3;
        this.pageNumber = i12;
        this.pageSize = i13;
        this.searchString = str4;
        this.areaID = str5;
        this.sectionTheList = z11;
        this.offerFilterId = i14;
        this.cuisineId = i15;
    }

    @Nullable
    public final String getAreaID() {
        return this.areaID;
    }

    public final int getCountryCode() {
        return this.countryCode;
    }

    public final int getCuisineId() {
        return this.cuisineId;
    }

    @Nullable
    public final String getLat() {
        return this.lat;
    }

    @Nullable
    public final String getLong() {
        return this.f52long;
    }

    public final int getOfferFilterId() {
        return this.offerFilterId;
    }

    public final int getPageNumber() {
        return this.pageNumber;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    @NotNull
    public final String getPathParams() {
        return this.pathParams;
    }

    @Nullable
    public final String getSearchString() {
        return this.searchString;
    }

    public final boolean getSectionTheList() {
        return this.sectionTheList;
    }

    public final void setAreaID(@Nullable String str) {
        this.areaID = str;
    }

    public final void setCountryCode(int i11) {
        this.countryCode = i11;
    }

    public final void setCuisineId(int i11) {
        this.cuisineId = i11;
    }

    public final void setLat(@Nullable String str) {
        this.lat = str;
    }

    public final void setLong(@Nullable String str) {
        this.f52long = str;
    }

    public final void setOfferFilterId(int i11) {
        this.offerFilterId = i11;
    }

    public final void setPageNumber(int i11) {
        this.pageNumber = i11;
    }

    public final void setPageSize(int i11) {
        this.pageSize = i11;
    }

    public final void setPathParams(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pathParams = str;
    }

    public final void setSearchString(@Nullable String str) {
        this.searchString = str;
    }

    public final void setSectionTheList(boolean z11) {
        this.sectionTheList = z11;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ VendorListRequestModel(int r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, int r18, java.lang.String r19, java.lang.String r20, boolean r21, int r22, int r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            kotlin.jvm.internal.IntCompanionObject r1 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            int r1 = com.talabat.talabatcommon.extentions.IntKt.orZero((kotlin.jvm.internal.IntCompanionObject) r1)
            goto L_0x000e
        L_0x000d:
            r1 = r13
        L_0x000e:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0015
            r2 = r3
            goto L_0x0016
        L_0x0015:
            r2 = r14
        L_0x0016:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0021
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r4 = com.talabat.talabatcommon.extentions.StringUtils.empty(r4)
            goto L_0x0022
        L_0x0021:
            r4 = r15
        L_0x0022:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0028
            r5 = r3
            goto L_0x002a
        L_0x0028:
            r5 = r16
        L_0x002a:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0030
            r6 = 1
            goto L_0x0032
        L_0x0030:
            r6 = r17
        L_0x0032:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0039
            r7 = 20
            goto L_0x003b
        L_0x0039:
            r7 = r18
        L_0x003b:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0041
            r8 = r3
            goto L_0x0043
        L_0x0041:
            r8 = r19
        L_0x0043:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r3 = r20
        L_0x004a:
            r9 = r0 & 256(0x100, float:3.59E-43)
            r10 = 0
            if (r9 == 0) goto L_0x0051
            r9 = r10
            goto L_0x0053
        L_0x0051:
            r9 = r21
        L_0x0053:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0059
            r11 = r10
            goto L_0x005b
        L_0x0059:
            r11 = r22
        L_0x005b:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r10 = r23
        L_0x0062:
            r13 = r12
            r14 = r1
            r15 = r2
            r16 = r4
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r21 = r3
            r22 = r9
            r23 = r11
            r24 = r10
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.features.vendors.vendorList.models.request.VendorListRequestModel.<init>(int, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String, boolean, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
