package com.talabat.feature.rating.domain.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b>\b\b\u0018\u00002\u00020\u0001Bû\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\n\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\n\u0012\b\b\u0002\u0010\u0019\u001a\u00020\n\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n\u0012\b\b\u0002\u0010\u001b\u001a\u00020\n\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005¢\u0006\u0002\u0010\u001dJ\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u000fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\nHÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003J\t\u00109\u001a\u00020\nHÆ\u0003J\t\u0010:\u001a\u00020\nHÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\nHÆ\u0003J\t\u0010=\u001a\u00020\nHÆ\u0003J\t\u0010>\u001a\u00020\nHÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010C\u001a\u00020\nHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jÿ\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001c\u001a\u00020\u0005HÆ\u0001J\u0013\u0010H\u001a\u00020\n2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\u0005HÖ\u0001J\u0006\u0010K\u001a\u00020\nJ\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0016\u0010\u0019\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\"R\u0016\u0010\u0013\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\"R\u0016\u0010\u001a\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\"R\u0016\u0010\u0015\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\"R\u0016\u0010\u0017\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\"R\u0016\u0010\u001b\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\"R\u0016\u0010\u0016\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\"R\u0016\u0010\u0018\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\"R\u0016\u0010\u0012\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\"R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0016\u0010\u001c\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001fR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006M"}, d2 = {"Lcom/talabat/feature/rating/domain/model/DashboardOrder;", "", "encryptedOrderId", "", "restaurantId", "", "restaurantName", "restaurantLogoName", "orderTime", "orderStatus", "", "orderId", "firstItemName", "firstItemQuantity", "totalOrderCost", "", "totalItems", "newOrderStatus", "isTracking", "isGlrEnabled", "orderReceivedTime", "isOldOrder", "isPreOrder", "isOrderRated", "isTimePassedToRate", "isDarkStore", "isMigrated", "isPickUpOrder", "orderType", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;IZZLjava/lang/String;ZZZZZZZI)V", "getEncryptedOrderId", "()Ljava/lang/String;", "getFirstItemName", "getFirstItemQuantity", "()Z", "getNewOrderStatus", "()I", "getOrderId", "getOrderReceivedTime", "getOrderStatus", "getOrderTime", "getOrderType", "getRestaurantId", "getRestaurantLogoName", "getRestaurantName", "getTotalItems", "getTotalOrderCost", "()F", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "isDineOutOrder", "toString", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DashboardOrder {
    @SerializedName("oid")
    @NotNull
    private final String encryptedOrderId;
    @SerializedName("itn")
    @Nullable
    private final String firstItemName;
    @SerializedName("qty")
    @Nullable
    private final String firstItemQuantity;
    @SerializedName("isds")
    private final boolean isDarkStore;
    @SerializedName("rgrl")
    private final boolean isGlrEnabled;
    @SerializedName("ismgrtd")
    private final boolean isMigrated;
    @SerializedName("iord")
    private final boolean isOldOrder;
    @SerializedName("israted")
    private final boolean isOrderRated;
    @SerializedName("ispickup")
    private final boolean isPickUpOrder;
    @SerializedName("ispr")
    private final boolean isPreOrder;
    @SerializedName("srp")
    private final boolean isTimePassedToRate;
    @SerializedName("ipt")
    private final boolean isTracking;
    @SerializedName("eos")
    private final int newOrderStatus;
    @SerializedName("iid")
    @Nullable
    private final String orderId;
    @SerializedName("recvdt")
    @Nullable
    private final String orderReceivedTime;
    @SerializedName("ost")
    private final boolean orderStatus;
    @SerializedName("odt")
    @Nullable
    private final String orderTime;
    @SerializedName("otyp")
    private final int orderType;
    @SerializedName("rid")
    private final int restaurantId;
    @SerializedName("rlg")
    @Nullable
    private final String restaurantLogoName;
    @SerializedName("rnm")
    @Nullable
    private final String restaurantName;
    @SerializedName("ic")
    @Nullable
    private final String totalItems;
    @SerializedName("tot")
    private final float totalOrderCost;

    public DashboardOrder() {
        this((String) null, 0, (String) null, (String) null, (String) null, false, (String) null, (String) null, (String) null, 0.0f, (String) null, 0, false, false, (String) null, false, false, false, false, false, false, false, 0, 8388607, (DefaultConstructorMarker) null);
    }

    public DashboardOrder(@NotNull String str, int i11, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z11, @Nullable String str5, @Nullable String str6, @Nullable String str7, float f11, @Nullable String str8, int i12, boolean z12, boolean z13, @Nullable String str9, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z21, int i13) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        this.encryptedOrderId = str;
        this.restaurantId = i11;
        this.restaurantName = str2;
        this.restaurantLogoName = str3;
        this.orderTime = str4;
        this.orderStatus = z11;
        this.orderId = str5;
        this.firstItemName = str6;
        this.firstItemQuantity = str7;
        this.totalOrderCost = f11;
        this.totalItems = str8;
        this.newOrderStatus = i12;
        this.isTracking = z12;
        this.isGlrEnabled = z13;
        this.orderReceivedTime = str9;
        this.isOldOrder = z14;
        this.isPreOrder = z15;
        this.isOrderRated = z16;
        this.isTimePassedToRate = z17;
        this.isDarkStore = z18;
        this.isMigrated = z19;
        this.isPickUpOrder = z21;
        this.orderType = i13;
    }

    public static /* synthetic */ DashboardOrder copy$default(DashboardOrder dashboardOrder, String str, int i11, String str2, String str3, String str4, boolean z11, String str5, String str6, String str7, float f11, String str8, int i12, boolean z12, boolean z13, String str9, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z21, int i13, int i14, Object obj) {
        DashboardOrder dashboardOrder2 = dashboardOrder;
        int i15 = i14;
        return dashboardOrder.copy((i15 & 1) != 0 ? dashboardOrder2.encryptedOrderId : str, (i15 & 2) != 0 ? dashboardOrder2.restaurantId : i11, (i15 & 4) != 0 ? dashboardOrder2.restaurantName : str2, (i15 & 8) != 0 ? dashboardOrder2.restaurantLogoName : str3, (i15 & 16) != 0 ? dashboardOrder2.orderTime : str4, (i15 & 32) != 0 ? dashboardOrder2.orderStatus : z11, (i15 & 64) != 0 ? dashboardOrder2.orderId : str5, (i15 & 128) != 0 ? dashboardOrder2.firstItemName : str6, (i15 & 256) != 0 ? dashboardOrder2.firstItemQuantity : str7, (i15 & 512) != 0 ? dashboardOrder2.totalOrderCost : f11, (i15 & 1024) != 0 ? dashboardOrder2.totalItems : str8, (i15 & 2048) != 0 ? dashboardOrder2.newOrderStatus : i12, (i15 & 4096) != 0 ? dashboardOrder2.isTracking : z12, (i15 & 8192) != 0 ? dashboardOrder2.isGlrEnabled : z13, (i15 & 16384) != 0 ? dashboardOrder2.orderReceivedTime : str9, (i15 & 32768) != 0 ? dashboardOrder2.isOldOrder : z14, (i15 & 65536) != 0 ? dashboardOrder2.isPreOrder : z15, (i15 & 131072) != 0 ? dashboardOrder2.isOrderRated : z16, (i15 & 262144) != 0 ? dashboardOrder2.isTimePassedToRate : z17, (i15 & 524288) != 0 ? dashboardOrder2.isDarkStore : z18, (i15 & 1048576) != 0 ? dashboardOrder2.isMigrated : z19, (i15 & 2097152) != 0 ? dashboardOrder2.isPickUpOrder : z21, (i15 & 4194304) != 0 ? dashboardOrder2.orderType : i13);
    }

    @NotNull
    public final String component1() {
        return this.encryptedOrderId;
    }

    public final float component10() {
        return this.totalOrderCost;
    }

    @Nullable
    public final String component11() {
        return this.totalItems;
    }

    public final int component12() {
        return this.newOrderStatus;
    }

    public final boolean component13() {
        return this.isTracking;
    }

    public final boolean component14() {
        return this.isGlrEnabled;
    }

    @Nullable
    public final String component15() {
        return this.orderReceivedTime;
    }

    public final boolean component16() {
        return this.isOldOrder;
    }

    public final boolean component17() {
        return this.isPreOrder;
    }

    public final boolean component18() {
        return this.isOrderRated;
    }

    public final boolean component19() {
        return this.isTimePassedToRate;
    }

    public final int component2() {
        return this.restaurantId;
    }

    public final boolean component20() {
        return this.isDarkStore;
    }

    public final boolean component21() {
        return this.isMigrated;
    }

    public final boolean component22() {
        return this.isPickUpOrder;
    }

    public final int component23() {
        return this.orderType;
    }

    @Nullable
    public final String component3() {
        return this.restaurantName;
    }

    @Nullable
    public final String component4() {
        return this.restaurantLogoName;
    }

    @Nullable
    public final String component5() {
        return this.orderTime;
    }

    public final boolean component6() {
        return this.orderStatus;
    }

    @Nullable
    public final String component7() {
        return this.orderId;
    }

    @Nullable
    public final String component8() {
        return this.firstItemName;
    }

    @Nullable
    public final String component9() {
        return this.firstItemQuantity;
    }

    @NotNull
    public final DashboardOrder copy(@NotNull String str, int i11, @Nullable String str2, @Nullable String str3, @Nullable String str4, boolean z11, @Nullable String str5, @Nullable String str6, @Nullable String str7, float f11, @Nullable String str8, int i12, boolean z12, boolean z13, @Nullable String str9, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19, boolean z21, int i13) {
        String str10 = str;
        String str11 = str10;
        Intrinsics.checkNotNullParameter(str10, "encryptedOrderId");
        return new DashboardOrder(str10, i11, str2, str3, str4, z11, str5, str6, str7, f11, str8, i12, z12, z13, str9, z14, z15, z16, z17, z18, z19, z21, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DashboardOrder)) {
            return false;
        }
        DashboardOrder dashboardOrder = (DashboardOrder) obj;
        return Intrinsics.areEqual((Object) this.encryptedOrderId, (Object) dashboardOrder.encryptedOrderId) && this.restaurantId == dashboardOrder.restaurantId && Intrinsics.areEqual((Object) this.restaurantName, (Object) dashboardOrder.restaurantName) && Intrinsics.areEqual((Object) this.restaurantLogoName, (Object) dashboardOrder.restaurantLogoName) && Intrinsics.areEqual((Object) this.orderTime, (Object) dashboardOrder.orderTime) && this.orderStatus == dashboardOrder.orderStatus && Intrinsics.areEqual((Object) this.orderId, (Object) dashboardOrder.orderId) && Intrinsics.areEqual((Object) this.firstItemName, (Object) dashboardOrder.firstItemName) && Intrinsics.areEqual((Object) this.firstItemQuantity, (Object) dashboardOrder.firstItemQuantity) && Intrinsics.areEqual((Object) Float.valueOf(this.totalOrderCost), (Object) Float.valueOf(dashboardOrder.totalOrderCost)) && Intrinsics.areEqual((Object) this.totalItems, (Object) dashboardOrder.totalItems) && this.newOrderStatus == dashboardOrder.newOrderStatus && this.isTracking == dashboardOrder.isTracking && this.isGlrEnabled == dashboardOrder.isGlrEnabled && Intrinsics.areEqual((Object) this.orderReceivedTime, (Object) dashboardOrder.orderReceivedTime) && this.isOldOrder == dashboardOrder.isOldOrder && this.isPreOrder == dashboardOrder.isPreOrder && this.isOrderRated == dashboardOrder.isOrderRated && this.isTimePassedToRate == dashboardOrder.isTimePassedToRate && this.isDarkStore == dashboardOrder.isDarkStore && this.isMigrated == dashboardOrder.isMigrated && this.isPickUpOrder == dashboardOrder.isPickUpOrder && this.orderType == dashboardOrder.orderType;
    }

    @NotNull
    public final String getEncryptedOrderId() {
        return this.encryptedOrderId;
    }

    @Nullable
    public final String getFirstItemName() {
        return this.firstItemName;
    }

    @Nullable
    public final String getFirstItemQuantity() {
        return this.firstItemQuantity;
    }

    public final int getNewOrderStatus() {
        return this.newOrderStatus;
    }

    @Nullable
    public final String getOrderId() {
        return this.orderId;
    }

    @Nullable
    public final String getOrderReceivedTime() {
        return this.orderReceivedTime;
    }

    public final boolean getOrderStatus() {
        return this.orderStatus;
    }

    @Nullable
    public final String getOrderTime() {
        return this.orderTime;
    }

    public final int getOrderType() {
        return this.orderType;
    }

    public final int getRestaurantId() {
        return this.restaurantId;
    }

    @Nullable
    public final String getRestaurantLogoName() {
        return this.restaurantLogoName;
    }

    @Nullable
    public final String getRestaurantName() {
        return this.restaurantName;
    }

    @Nullable
    public final String getTotalItems() {
        return this.totalItems;
    }

    public final float getTotalOrderCost() {
        return this.totalOrderCost;
    }

    public int hashCode() {
        int hashCode = ((this.encryptedOrderId.hashCode() * 31) + this.restaurantId) * 31;
        String str = this.restaurantName;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.restaurantLogoName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.orderTime;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z11 = this.orderStatus;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode4 + (z11 ? 1 : 0)) * 31;
        String str4 = this.orderId;
        int hashCode5 = (i12 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.firstItemName;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.firstItemQuantity;
        int hashCode7 = (((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + Float.floatToIntBits(this.totalOrderCost)) * 31;
        String str7 = this.totalItems;
        int hashCode8 = (((hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.newOrderStatus) * 31;
        boolean z13 = this.isTracking;
        if (z13) {
            z13 = true;
        }
        int i13 = (hashCode8 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isGlrEnabled;
        if (z14) {
            z14 = true;
        }
        int i14 = (i13 + (z14 ? 1 : 0)) * 31;
        String str8 = this.orderReceivedTime;
        if (str8 != null) {
            i11 = str8.hashCode();
        }
        int i15 = (i14 + i11) * 31;
        boolean z15 = this.isOldOrder;
        if (z15) {
            z15 = true;
        }
        int i16 = (i15 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this.isPreOrder;
        if (z16) {
            z16 = true;
        }
        int i17 = (i16 + (z16 ? 1 : 0)) * 31;
        boolean z17 = this.isOrderRated;
        if (z17) {
            z17 = true;
        }
        int i18 = (i17 + (z17 ? 1 : 0)) * 31;
        boolean z18 = this.isTimePassedToRate;
        if (z18) {
            z18 = true;
        }
        int i19 = (i18 + (z18 ? 1 : 0)) * 31;
        boolean z19 = this.isDarkStore;
        if (z19) {
            z19 = true;
        }
        int i21 = (i19 + (z19 ? 1 : 0)) * 31;
        boolean z21 = this.isMigrated;
        if (z21) {
            z21 = true;
        }
        int i22 = (i21 + (z21 ? 1 : 0)) * 31;
        boolean z22 = this.isPickUpOrder;
        if (!z22) {
            z12 = z22;
        }
        return ((i22 + (z12 ? 1 : 0)) * 31) + this.orderType;
    }

    public final boolean isDarkStore() {
        return this.isDarkStore;
    }

    public final boolean isDineOutOrder() {
        return this.orderType == 3;
    }

    public final boolean isGlrEnabled() {
        return this.isGlrEnabled;
    }

    public final boolean isMigrated() {
        return this.isMigrated;
    }

    public final boolean isOldOrder() {
        return this.isOldOrder;
    }

    public final boolean isOrderRated() {
        return this.isOrderRated;
    }

    public final boolean isPickUpOrder() {
        return this.isPickUpOrder;
    }

    public final boolean isPreOrder() {
        return this.isPreOrder;
    }

    public final boolean isTimePassedToRate() {
        return this.isTimePassedToRate;
    }

    public final boolean isTracking() {
        return this.isTracking;
    }

    @NotNull
    public String toString() {
        String str = this.encryptedOrderId;
        int i11 = this.restaurantId;
        String str2 = this.restaurantName;
        String str3 = this.restaurantLogoName;
        String str4 = this.orderTime;
        boolean z11 = this.orderStatus;
        String str5 = this.orderId;
        String str6 = this.firstItemName;
        String str7 = this.firstItemQuantity;
        float f11 = this.totalOrderCost;
        String str8 = this.totalItems;
        int i12 = this.newOrderStatus;
        boolean z12 = this.isTracking;
        boolean z13 = this.isGlrEnabled;
        String str9 = this.orderReceivedTime;
        boolean z14 = this.isOldOrder;
        boolean z15 = this.isPreOrder;
        boolean z16 = this.isOrderRated;
        boolean z17 = this.isTimePassedToRate;
        boolean z18 = this.isDarkStore;
        boolean z19 = this.isMigrated;
        boolean z21 = this.isPickUpOrder;
        int i13 = this.orderType;
        return "DashboardOrder(encryptedOrderId=" + str + ", restaurantId=" + i11 + ", restaurantName=" + str2 + ", restaurantLogoName=" + str3 + ", orderTime=" + str4 + ", orderStatus=" + z11 + ", orderId=" + str5 + ", firstItemName=" + str6 + ", firstItemQuantity=" + str7 + ", totalOrderCost=" + f11 + ", totalItems=" + str8 + ", newOrderStatus=" + i12 + ", isTracking=" + z12 + ", isGlrEnabled=" + z13 + ", orderReceivedTime=" + str9 + ", isOldOrder=" + z14 + ", isPreOrder=" + z15 + ", isOrderRated=" + z16 + ", isTimePassedToRate=" + z17 + ", isDarkStore=" + z18 + ", isMigrated=" + z19 + ", isPickUpOrder=" + z21 + ", orderType=" + i13 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DashboardOrder(java.lang.String r25, int r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, boolean r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, float r34, java.lang.String r35, int r36, boolean r37, boolean r38, java.lang.String r39, boolean r40, boolean r41, boolean r42, boolean r43, boolean r44, boolean r45, boolean r46, int r47, int r48, kotlin.jvm.internal.DefaultConstructorMarker r49) {
        /*
            r24 = this;
            r0 = r48
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            java.lang.String r1 = ""
            goto L_0x000b
        L_0x0009:
            r1 = r25
        L_0x000b:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0011
            r2 = 0
            goto L_0x0013
        L_0x0011:
            r2 = r26
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = 0
            goto L_0x001b
        L_0x0019:
            r4 = r27
        L_0x001b:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            r6 = 0
            goto L_0x0023
        L_0x0021:
            r6 = r28
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0029
            r7 = 0
            goto L_0x002b
        L_0x0029:
            r7 = r29
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = 0
            goto L_0x0033
        L_0x0031:
            r8 = r30
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = 0
            goto L_0x003b
        L_0x0039:
            r9 = r31
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0041
            r10 = 0
            goto L_0x0043
        L_0x0041:
            r10 = r32
        L_0x0043:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0049
            r11 = 0
            goto L_0x004b
        L_0x0049:
            r11 = r33
        L_0x004b:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0051
            r12 = 0
            goto L_0x0053
        L_0x0051:
            r12 = r34
        L_0x0053:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0059
            r13 = 0
            goto L_0x005b
        L_0x0059:
            r13 = r35
        L_0x005b:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0061
            r14 = -1
            goto L_0x0063
        L_0x0061:
            r14 = r36
        L_0x0063:
            r3 = r0 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x0069
            r3 = 1
            goto L_0x006b
        L_0x0069:
            r3 = r37
        L_0x006b:
            r5 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x0071
            r5 = 0
            goto L_0x0073
        L_0x0071:
            r5 = r38
        L_0x0073:
            r15 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r15 == 0) goto L_0x0079
            r15 = 0
            goto L_0x007b
        L_0x0079:
            r15 = r39
        L_0x007b:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0085
            r16 = 0
            goto L_0x0087
        L_0x0085:
            r16 = r40
        L_0x0087:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0090
            r17 = 0
            goto L_0x0092
        L_0x0090:
            r17 = r41
        L_0x0092:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009b
            r18 = 0
            goto L_0x009d
        L_0x009b:
            r18 = r42
        L_0x009d:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a6
            r19 = 0
            goto L_0x00a8
        L_0x00a6:
            r19 = r43
        L_0x00a8:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b1
            r20 = 0
            goto L_0x00b3
        L_0x00b1:
            r20 = r44
        L_0x00b3:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bc
            r21 = 0
            goto L_0x00be
        L_0x00bc:
            r21 = r45
        L_0x00be:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c7
            r22 = 0
            goto L_0x00c9
        L_0x00c7:
            r22 = r46
        L_0x00c9:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r23
            if (r0 == 0) goto L_0x00d1
            r0 = -1
            goto L_0x00d3
        L_0x00d1:
            r0 = r47
        L_0x00d3:
            r25 = r24
            r26 = r1
            r27 = r2
            r28 = r4
            r29 = r6
            r30 = r7
            r31 = r8
            r32 = r9
            r33 = r10
            r34 = r11
            r35 = r12
            r36 = r13
            r37 = r14
            r38 = r3
            r39 = r5
            r40 = r15
            r41 = r16
            r42 = r17
            r43 = r18
            r44 = r19
            r45 = r20
            r46 = r21
            r47 = r22
            r48 = r0
            r25.<init>(r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rating.domain.model.DashboardOrder.<init>(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, float, java.lang.String, int, boolean, boolean, java.lang.String, boolean, boolean, boolean, boolean, boolean, boolean, boolean, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
