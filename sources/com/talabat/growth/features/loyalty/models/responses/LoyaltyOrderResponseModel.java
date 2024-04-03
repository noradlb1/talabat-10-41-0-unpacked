package com.talabat.growth.features.loyalty.models.responses;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR \u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/talabat/growth/features/loyalty/models/responses/LoyaltyOrderResponseModel;", "", "points", "", "pointsType", "createdOnUTC", "", "subTitle", "orderId", "title", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getCreatedOnUTC", "()Ljava/lang/String;", "setCreatedOnUTC", "(Ljava/lang/String;)V", "getOrderId", "()Ljava/lang/Integer;", "setOrderId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPoints", "setPoints", "getPointsType", "setPointsType", "getSubTitle", "setSubTitle", "getTitle", "setTitle", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyOrderResponseModel {
    @SerializedName("createdOnUTC")
    @Nullable
    private String createdOnUTC;
    @SerializedName("orderId")
    @Nullable
    private Integer orderId;
    @SerializedName("points")
    @Nullable
    private Integer points;
    @SerializedName("pointsType")
    @Nullable
    private Integer pointsType;
    @Nullable
    private String subTitle;
    @SerializedName("title")
    @Nullable
    private String title;

    public LoyaltyOrderResponseModel() {
        this((Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public LoyaltyOrderResponseModel(@Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable String str2, @Nullable Integer num3, @Nullable String str3) {
        this.points = num;
        this.pointsType = num2;
        this.createdOnUTC = str;
        this.subTitle = str2;
        this.orderId = num3;
        this.title = str3;
    }

    @Nullable
    public final String getCreatedOnUTC() {
        return this.createdOnUTC;
    }

    @Nullable
    public final Integer getOrderId() {
        return this.orderId;
    }

    @Nullable
    public final Integer getPoints() {
        return this.points;
    }

    @Nullable
    public final Integer getPointsType() {
        return this.pointsType;
    }

    @Nullable
    public final String getSubTitle() {
        return this.subTitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final void setCreatedOnUTC(@Nullable String str) {
        this.createdOnUTC = str;
    }

    public final void setOrderId(@Nullable Integer num) {
        this.orderId = num;
    }

    public final void setPoints(@Nullable Integer num) {
        this.points = num;
    }

    public final void setPointsType(@Nullable Integer num) {
        this.pointsType = num;
    }

    public final void setSubTitle(@Nullable String str) {
        this.subTitle = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LoyaltyOrderResponseModel(java.lang.Integer r6, java.lang.Integer r7, java.lang.String r8, java.lang.String r9, java.lang.Integer r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.features.loyalty.models.responses.LoyaltyOrderResponseModel.<init>(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
