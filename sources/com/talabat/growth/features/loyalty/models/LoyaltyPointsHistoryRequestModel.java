package com.talabat.growth.features.loyalty.models;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.talabat.growth.features.loyalty.network.PointsHistoryFilterType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/talabat/growth/features/loyalty/models/LoyaltyPointsHistoryRequestModel;", "", "userId", "", "pageNumber", "", "pageSize", "filterID", "Lcom/talabat/growth/features/loyalty/network/PointsHistoryFilterType;", "languageCode", "(Ljava/lang/String;IILcom/talabat/growth/features/loyalty/network/PointsHistoryFilterType;Ljava/lang/String;)V", "getFilterID", "()Lcom/talabat/growth/features/loyalty/network/PointsHistoryFilterType;", "setFilterID", "(Lcom/talabat/growth/features/loyalty/network/PointsHistoryFilterType;)V", "getLanguageCode", "()Ljava/lang/String;", "setLanguageCode", "(Ljava/lang/String;)V", "getPageNumber", "()I", "setPageNumber", "(I)V", "getPageSize", "setPageSize", "getUserId", "setUserId", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyPointsHistoryRequestModel {
    @NotNull
    private PointsHistoryFilterType filterID;
    @NotNull
    private String languageCode;
    private int pageNumber;
    private int pageSize;
    @NotNull
    private String userId;

    public LoyaltyPointsHistoryRequestModel() {
        this((String) null, 0, 0, (PointsHistoryFilterType) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public LoyaltyPointsHistoryRequestModel(@NotNull String str, int i11, int i12, @NotNull PointsHistoryFilterType pointsHistoryFilterType, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(pointsHistoryFilterType, "filterID");
        Intrinsics.checkNotNullParameter(str2, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
        this.userId = str;
        this.pageNumber = i11;
        this.pageSize = i12;
        this.filterID = pointsHistoryFilterType;
        this.languageCode = str2;
    }

    @NotNull
    public final PointsHistoryFilterType getFilterID() {
        return this.filterID;
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

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public final void setFilterID(@NotNull PointsHistoryFilterType pointsHistoryFilterType) {
        Intrinsics.checkNotNullParameter(pointsHistoryFilterType, "<set-?>");
        this.filterID = pointsHistoryFilterType;
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

    public final void setUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LoyaltyPointsHistoryRequestModel(java.lang.String r5, int r6, int r7, com.talabat.growth.features.loyalty.network.PointsHistoryFilterType r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x0008
            r11 = r0
            goto L_0x0009
        L_0x0008:
            r11 = r5
        L_0x0009:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r6 = 1
        L_0x000e:
            r1 = r6
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r7 = 20
        L_0x0015:
            r2 = r7
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            com.talabat.growth.features.loyalty.network.PointsHistoryFilterType r8 = com.talabat.growth.features.loyalty.network.PointsHistoryFilterType.ALL
        L_0x001c:
            r3 = r8
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.features.loyalty.models.LoyaltyPointsHistoryRequestModel.<init>(java.lang.String, int, int, com.talabat.growth.features.loyalty.network.PointsHistoryFilterType, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
