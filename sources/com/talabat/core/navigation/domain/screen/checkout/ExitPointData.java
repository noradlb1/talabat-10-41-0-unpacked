package com.talabat.core.navigation.domain.screen.checkout;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B³\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001aJ\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\t\u00108\u001a\u00020\fHÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003HÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J\t\u0010;\u001a\u00020\fHÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\t\u0010@\u001a\u00020\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0006HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010*J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\t\u0010E\u001a\u00020\fHÆ\u0003J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003JÚ\u0001\u0010H\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010IJ\u0013\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020NHÖ\u0001J\t\u0010O\u001a\u00020\fHÖ\u0001R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u001a\u0010\u0016\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u001a\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010!R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u0011\u0010\u0013\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010+\u001a\u0004\b/\u0010*R\u001a\u0010\u0015\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010+\u001a\u0004\b2\u0010*R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001c¨\u0006P"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointData;", "", "items", "", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointProduct;", "subtotal", "", "deliveryFee", "serviceFee", "absoluteTotalDiscount", "total", "targetAudience", "", "absoluteCartDiscount", "deliveryAbsoluteDiscount", "deliveryTotal", "cartId", "appliedCampaigns", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointCampaign;", "dijiniVendorId", "darkstoresSpecialRequest", "selectedFulfillmentPreference", "ageRestricedLimit", "feeDescriptions", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointFeeDescription;", "scheduledDeliveryDiscount", "(Ljava/util/List;FFLjava/lang/Float;FFLjava/lang/String;FFLjava/lang/Float;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Float;)V", "getAbsoluteCartDiscount", "()F", "getAbsoluteTotalDiscount", "getAgeRestricedLimit", "()Ljava/lang/String;", "setAgeRestricedLimit", "(Ljava/lang/String;)V", "getAppliedCampaigns", "()Ljava/util/List;", "getCartId", "getDarkstoresSpecialRequest", "setDarkstoresSpecialRequest", "getDeliveryAbsoluteDiscount", "getDeliveryFee", "getDeliveryTotal", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getDijiniVendorId", "getFeeDescriptions", "getItems", "getScheduledDeliveryDiscount", "getSelectedFulfillmentPreference", "setSelectedFulfillmentPreference", "getServiceFee", "getSubtotal", "getTargetAudience", "getTotal", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;FFLjava/lang/Float;FFLjava/lang/String;FFLjava/lang/Float;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Float;)Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointData;", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExitPointData {
    private final float absoluteCartDiscount;
    private final float absoluteTotalDiscount;
    @NotNull
    private String ageRestricedLimit;
    @NotNull
    private final List<ExitPointCampaign> appliedCampaigns;
    @NotNull
    private final String cartId;
    @NotNull
    private String darkstoresSpecialRequest;
    private final float deliveryAbsoluteDiscount;
    private final float deliveryFee;
    @Nullable
    private final Float deliveryTotal;
    @NotNull
    private final String dijiniVendorId;
    @NotNull
    private final List<ExitPointFeeDescription> feeDescriptions;
    @NotNull
    private final List<ExitPointProduct> items;
    @Nullable
    private final Float scheduledDeliveryDiscount;
    @NotNull
    private String selectedFulfillmentPreference;
    @Nullable
    private final Float serviceFee;
    private final float subtotal;
    @NotNull
    private final String targetAudience;
    private final float total;

    public ExitPointData(@NotNull List<ExitPointProduct> list, float f11, float f12, @Nullable Float f13, float f14, float f15, @NotNull String str, float f16, float f17, @Nullable Float f18, @NotNull String str2, @NotNull List<ExitPointCampaign> list2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull List<ExitPointFeeDescription> list3, @Nullable Float f19) {
        String str7 = str;
        String str8 = str2;
        List<ExitPointCampaign> list4 = list2;
        String str9 = str3;
        String str10 = str4;
        String str11 = str5;
        String str12 = str6;
        List<ExitPointFeeDescription> list5 = list3;
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(str7, "targetAudience");
        Intrinsics.checkNotNullParameter(str8, FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullParameter(list4, "appliedCampaigns");
        Intrinsics.checkNotNullParameter(str9, "dijiniVendorId");
        Intrinsics.checkNotNullParameter(str10, "darkstoresSpecialRequest");
        Intrinsics.checkNotNullParameter(str11, "selectedFulfillmentPreference");
        Intrinsics.checkNotNullParameter(str12, "ageRestricedLimit");
        Intrinsics.checkNotNullParameter(list5, "feeDescriptions");
        this.items = list;
        this.subtotal = f11;
        this.deliveryFee = f12;
        this.serviceFee = f13;
        this.absoluteTotalDiscount = f14;
        this.total = f15;
        this.targetAudience = str7;
        this.absoluteCartDiscount = f16;
        this.deliveryAbsoluteDiscount = f17;
        this.deliveryTotal = f18;
        this.cartId = str8;
        this.appliedCampaigns = list4;
        this.dijiniVendorId = str9;
        this.darkstoresSpecialRequest = str10;
        this.selectedFulfillmentPreference = str11;
        this.ageRestricedLimit = str12;
        this.feeDescriptions = list5;
        this.scheduledDeliveryDiscount = f19;
    }

    public static /* synthetic */ ExitPointData copy$default(ExitPointData exitPointData, List list, float f11, float f12, Float f13, float f14, float f15, String str, float f16, float f17, Float f18, String str2, List list2, String str3, String str4, String str5, String str6, List list3, Float f19, int i11, Object obj) {
        ExitPointData exitPointData2 = exitPointData;
        int i12 = i11;
        return exitPointData.copy((i12 & 1) != 0 ? exitPointData2.items : list, (i12 & 2) != 0 ? exitPointData2.subtotal : f11, (i12 & 4) != 0 ? exitPointData2.deliveryFee : f12, (i12 & 8) != 0 ? exitPointData2.serviceFee : f13, (i12 & 16) != 0 ? exitPointData2.absoluteTotalDiscount : f14, (i12 & 32) != 0 ? exitPointData2.total : f15, (i12 & 64) != 0 ? exitPointData2.targetAudience : str, (i12 & 128) != 0 ? exitPointData2.absoluteCartDiscount : f16, (i12 & 256) != 0 ? exitPointData2.deliveryAbsoluteDiscount : f17, (i12 & 512) != 0 ? exitPointData2.deliveryTotal : f18, (i12 & 1024) != 0 ? exitPointData2.cartId : str2, (i12 & 2048) != 0 ? exitPointData2.appliedCampaigns : list2, (i12 & 4096) != 0 ? exitPointData2.dijiniVendorId : str3, (i12 & 8192) != 0 ? exitPointData2.darkstoresSpecialRequest : str4, (i12 & 16384) != 0 ? exitPointData2.selectedFulfillmentPreference : str5, (i12 & 32768) != 0 ? exitPointData2.ageRestricedLimit : str6, (i12 & 65536) != 0 ? exitPointData2.feeDescriptions : list3, (i12 & 131072) != 0 ? exitPointData2.scheduledDeliveryDiscount : f19);
    }

    @NotNull
    public final List<ExitPointProduct> component1() {
        return this.items;
    }

    @Nullable
    public final Float component10() {
        return this.deliveryTotal;
    }

    @NotNull
    public final String component11() {
        return this.cartId;
    }

    @NotNull
    public final List<ExitPointCampaign> component12() {
        return this.appliedCampaigns;
    }

    @NotNull
    public final String component13() {
        return this.dijiniVendorId;
    }

    @NotNull
    public final String component14() {
        return this.darkstoresSpecialRequest;
    }

    @NotNull
    public final String component15() {
        return this.selectedFulfillmentPreference;
    }

    @NotNull
    public final String component16() {
        return this.ageRestricedLimit;
    }

    @NotNull
    public final List<ExitPointFeeDescription> component17() {
        return this.feeDescriptions;
    }

    @Nullable
    public final Float component18() {
        return this.scheduledDeliveryDiscount;
    }

    public final float component2() {
        return this.subtotal;
    }

    public final float component3() {
        return this.deliveryFee;
    }

    @Nullable
    public final Float component4() {
        return this.serviceFee;
    }

    public final float component5() {
        return this.absoluteTotalDiscount;
    }

    public final float component6() {
        return this.total;
    }

    @NotNull
    public final String component7() {
        return this.targetAudience;
    }

    public final float component8() {
        return this.absoluteCartDiscount;
    }

    public final float component9() {
        return this.deliveryAbsoluteDiscount;
    }

    @NotNull
    public final ExitPointData copy(@NotNull List<ExitPointProduct> list, float f11, float f12, @Nullable Float f13, float f14, float f15, @NotNull String str, float f16, float f17, @Nullable Float f18, @NotNull String str2, @NotNull List<ExitPointCampaign> list2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull List<ExitPointFeeDescription> list3, @Nullable Float f19) {
        List<ExitPointProduct> list4 = list;
        Intrinsics.checkNotNullParameter(list4, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(str, "targetAudience");
        Intrinsics.checkNotNullParameter(str2, FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullParameter(list2, "appliedCampaigns");
        Intrinsics.checkNotNullParameter(str3, "dijiniVendorId");
        Intrinsics.checkNotNullParameter(str4, "darkstoresSpecialRequest");
        Intrinsics.checkNotNullParameter(str5, "selectedFulfillmentPreference");
        Intrinsics.checkNotNullParameter(str6, "ageRestricedLimit");
        Intrinsics.checkNotNullParameter(list3, "feeDescriptions");
        return new ExitPointData(list4, f11, f12, f13, f14, f15, str, f16, f17, f18, str2, list2, str3, str4, str5, str6, list3, f19);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExitPointData)) {
            return false;
        }
        ExitPointData exitPointData = (ExitPointData) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) exitPointData.items) && Intrinsics.areEqual((Object) Float.valueOf(this.subtotal), (Object) Float.valueOf(exitPointData.subtotal)) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryFee), (Object) Float.valueOf(exitPointData.deliveryFee)) && Intrinsics.areEqual((Object) this.serviceFee, (Object) exitPointData.serviceFee) && Intrinsics.areEqual((Object) Float.valueOf(this.absoluteTotalDiscount), (Object) Float.valueOf(exitPointData.absoluteTotalDiscount)) && Intrinsics.areEqual((Object) Float.valueOf(this.total), (Object) Float.valueOf(exitPointData.total)) && Intrinsics.areEqual((Object) this.targetAudience, (Object) exitPointData.targetAudience) && Intrinsics.areEqual((Object) Float.valueOf(this.absoluteCartDiscount), (Object) Float.valueOf(exitPointData.absoluteCartDiscount)) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryAbsoluteDiscount), (Object) Float.valueOf(exitPointData.deliveryAbsoluteDiscount)) && Intrinsics.areEqual((Object) this.deliveryTotal, (Object) exitPointData.deliveryTotal) && Intrinsics.areEqual((Object) this.cartId, (Object) exitPointData.cartId) && Intrinsics.areEqual((Object) this.appliedCampaigns, (Object) exitPointData.appliedCampaigns) && Intrinsics.areEqual((Object) this.dijiniVendorId, (Object) exitPointData.dijiniVendorId) && Intrinsics.areEqual((Object) this.darkstoresSpecialRequest, (Object) exitPointData.darkstoresSpecialRequest) && Intrinsics.areEqual((Object) this.selectedFulfillmentPreference, (Object) exitPointData.selectedFulfillmentPreference) && Intrinsics.areEqual((Object) this.ageRestricedLimit, (Object) exitPointData.ageRestricedLimit) && Intrinsics.areEqual((Object) this.feeDescriptions, (Object) exitPointData.feeDescriptions) && Intrinsics.areEqual((Object) this.scheduledDeliveryDiscount, (Object) exitPointData.scheduledDeliveryDiscount);
    }

    public final float getAbsoluteCartDiscount() {
        return this.absoluteCartDiscount;
    }

    public final float getAbsoluteTotalDiscount() {
        return this.absoluteTotalDiscount;
    }

    @NotNull
    public final String getAgeRestricedLimit() {
        return this.ageRestricedLimit;
    }

    @NotNull
    public final List<ExitPointCampaign> getAppliedCampaigns() {
        return this.appliedCampaigns;
    }

    @NotNull
    public final String getCartId() {
        return this.cartId;
    }

    @NotNull
    public final String getDarkstoresSpecialRequest() {
        return this.darkstoresSpecialRequest;
    }

    public final float getDeliveryAbsoluteDiscount() {
        return this.deliveryAbsoluteDiscount;
    }

    public final float getDeliveryFee() {
        return this.deliveryFee;
    }

    @Nullable
    public final Float getDeliveryTotal() {
        return this.deliveryTotal;
    }

    @NotNull
    public final String getDijiniVendorId() {
        return this.dijiniVendorId;
    }

    @NotNull
    public final List<ExitPointFeeDescription> getFeeDescriptions() {
        return this.feeDescriptions;
    }

    @NotNull
    public final List<ExitPointProduct> getItems() {
        return this.items;
    }

    @Nullable
    public final Float getScheduledDeliveryDiscount() {
        return this.scheduledDeliveryDiscount;
    }

    @NotNull
    public final String getSelectedFulfillmentPreference() {
        return this.selectedFulfillmentPreference;
    }

    @Nullable
    public final Float getServiceFee() {
        return this.serviceFee;
    }

    public final float getSubtotal() {
        return this.subtotal;
    }

    @NotNull
    public final String getTargetAudience() {
        return this.targetAudience;
    }

    public final float getTotal() {
        return this.total;
    }

    public int hashCode() {
        int hashCode = ((((this.items.hashCode() * 31) + Float.floatToIntBits(this.subtotal)) * 31) + Float.floatToIntBits(this.deliveryFee)) * 31;
        Float f11 = this.serviceFee;
        int i11 = 0;
        int hashCode2 = (((((((((((hashCode + (f11 == null ? 0 : f11.hashCode())) * 31) + Float.floatToIntBits(this.absoluteTotalDiscount)) * 31) + Float.floatToIntBits(this.total)) * 31) + this.targetAudience.hashCode()) * 31) + Float.floatToIntBits(this.absoluteCartDiscount)) * 31) + Float.floatToIntBits(this.deliveryAbsoluteDiscount)) * 31;
        Float f12 = this.deliveryTotal;
        int hashCode3 = (((((((((((((((hashCode2 + (f12 == null ? 0 : f12.hashCode())) * 31) + this.cartId.hashCode()) * 31) + this.appliedCampaigns.hashCode()) * 31) + this.dijiniVendorId.hashCode()) * 31) + this.darkstoresSpecialRequest.hashCode()) * 31) + this.selectedFulfillmentPreference.hashCode()) * 31) + this.ageRestricedLimit.hashCode()) * 31) + this.feeDescriptions.hashCode()) * 31;
        Float f13 = this.scheduledDeliveryDiscount;
        if (f13 != null) {
            i11 = f13.hashCode();
        }
        return hashCode3 + i11;
    }

    public final void setAgeRestricedLimit(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ageRestricedLimit = str;
    }

    public final void setDarkstoresSpecialRequest(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.darkstoresSpecialRequest = str;
    }

    public final void setSelectedFulfillmentPreference(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectedFulfillmentPreference = str;
    }

    @NotNull
    public String toString() {
        List<ExitPointProduct> list = this.items;
        float f11 = this.subtotal;
        float f12 = this.deliveryFee;
        Float f13 = this.serviceFee;
        float f14 = this.absoluteTotalDiscount;
        float f15 = this.total;
        String str = this.targetAudience;
        float f16 = this.absoluteCartDiscount;
        float f17 = this.deliveryAbsoluteDiscount;
        Float f18 = this.deliveryTotal;
        String str2 = this.cartId;
        List<ExitPointCampaign> list2 = this.appliedCampaigns;
        String str3 = this.dijiniVendorId;
        String str4 = this.darkstoresSpecialRequest;
        String str5 = this.selectedFulfillmentPreference;
        String str6 = this.ageRestricedLimit;
        List<ExitPointFeeDescription> list3 = this.feeDescriptions;
        Float f19 = this.scheduledDeliveryDiscount;
        return "ExitPointData(items=" + list + ", subtotal=" + f11 + ", deliveryFee=" + f12 + ", serviceFee=" + f13 + ", absoluteTotalDiscount=" + f14 + ", total=" + f15 + ", targetAudience=" + str + ", absoluteCartDiscount=" + f16 + ", deliveryAbsoluteDiscount=" + f17 + ", deliveryTotal=" + f18 + ", cartId=" + str2 + ", appliedCampaigns=" + list2 + ", dijiniVendorId=" + str3 + ", darkstoresSpecialRequest=" + str4 + ", selectedFulfillmentPreference=" + str5 + ", ageRestricedLimit=" + str6 + ", feeDescriptions=" + list3 + ", scheduledDeliveryDiscount=" + f19 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ExitPointData(java.util.List r23, float r24, float r25, java.lang.Float r26, float r27, float r28, java.lang.String r29, float r30, float r31, java.lang.Float r32, java.lang.String r33, java.util.List r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.util.List r39, java.lang.Float r40, int r41, kotlin.jvm.internal.DefaultConstructorMarker r42) {
        /*
            r22 = this;
            r0 = r41
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000b
            r17 = r2
            goto L_0x000d
        L_0x000b:
            r17 = r36
        L_0x000d:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0014
            r18 = r2
            goto L_0x0016
        L_0x0014:
            r18 = r37
        L_0x0016:
            r1 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x001f
            r19 = r2
            goto L_0x0021
        L_0x001f:
            r19 = r38
        L_0x0021:
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r8 = r27
            r9 = r28
            r10 = r29
            r11 = r30
            r12 = r31
            r13 = r32
            r14 = r33
            r15 = r34
            r16 = r35
            r20 = r39
            r21 = r40
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.core.navigation.domain.screen.checkout.ExitPointData.<init>(java.util.List, float, float, java.lang.Float, float, float, java.lang.String, float, float, java.lang.Float, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.Float, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
