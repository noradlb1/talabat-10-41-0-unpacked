package com.talabat.homescreen.adapter.model.order_tracking;

import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\bP\b\b\u0018\u0000 h2\u00020\u0001:\u0001hB\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u0019\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\"J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010H\u001a\u00020\tHÆ\u0003J\t\u0010I\u001a\u00020\tHÆ\u0003J\t\u0010J\u001a\u00020\tHÆ\u0003J\t\u0010K\u001a\u00020\tHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0017HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0019HÆ\u0003J\t\u0010S\u001a\u00020\tHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0019HÆ\u0003J\t\u0010V\u001a\u00020\u0019HÆ\u0003J\t\u0010W\u001a\u00020\u0019HÆ\u0003J\t\u0010X\u001a\u00020\u0019HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0019HÆ\u0003¢\u0006\u0002\u0010.J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010^\u001a\u00020\tHÆ\u0003J\t\u0010_\u001a\u00020\tHÆ\u0003J\t\u0010`\u001a\u00020\tHÆ\u0003J\t\u0010a\u001a\u00020\tHÆ\u0003Jº\u0002\u0010b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\t2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020\u00192\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0002\u0010cJ\u0013\u0010d\u001a\u00020\u00192\b\u0010e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010f\u001a\u00020\u0017HÖ\u0001J\t\u0010g\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0011\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0011\u0010\u001a\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010-R\u0011\u0010\u001e\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010-R\u0015\u0010!\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010/\u001a\u0004\b!\u0010.R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010$R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u0011\u0010\u001d\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b;\u0010-R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010$R\u001a\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010-\"\u0004\b?\u0010@R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bA\u0010&R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bB\u0010&R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bC\u0010&R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bD\u0010&R\u0011\u0010\u001f\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bE\u0010-¨\u0006i"}, d2 = {"Lcom/talabat/homescreen/adapter/model/order_tracking/OrderTrackingItem;", "", "id", "", "restaurantName", "estimatedDelivery", "orderStatus", "fullName", "subTotal", "", "grandTotal", "deliveryCharges", "talabatCharges", "paymentMethod", "municipalityTax", "touristTax", "voucherDiscount", "couponDiscount", "alterDeliveryText", "restaurantLogo", "orderTime", "orderReceivedTime", "newOrderStatus", "", "isGemOrder", "", "gemDiscountOrderAmount", "orderTransactionID", "status", "providesTracking", "isPreorder", "wasOrderSuccessStatus", "preOrderDeliveryTime", "isTgo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDDDLjava/lang/String;DDDDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZDLjava/lang/String;ZZZZLjava/lang/String;Ljava/lang/Boolean;)V", "getAlterDeliveryText", "()Ljava/lang/String;", "getCouponDiscount", "()D", "getDeliveryCharges", "getEstimatedDelivery", "getFullName", "getGemDiscountOrderAmount", "getGrandTotal", "getId", "()Z", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMunicipalityTax", "getNewOrderStatus", "()I", "setNewOrderStatus", "(I)V", "getOrderReceivedTime", "getOrderStatus", "getOrderTime", "getOrderTransactionID", "getPaymentMethod", "getPreOrderDeliveryTime", "getProvidesTracking", "getRestaurantLogo", "getRestaurantName", "getStatus", "setStatus", "(Z)V", "getSubTotal", "getTalabatCharges", "getTouristTax", "getVoucherDiscount", "getWasOrderSuccessStatus", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDDDLjava/lang/String;DDDDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZDLjava/lang/String;ZZZZLjava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/homescreen/adapter/model/order_tracking/OrderTrackingItem;", "equals", "other", "hashCode", "toString", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingItem {
    public static final int CANCELED = 5;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DELIVERED = 4;
    public static final int DELIVERING = 3;
    public static final int OLD_STATUS = -5;
    public static final int ORDERED = 1;
    public static final int PREPARING = 2;
    public static final int REPLACEMENT = 6;
    @Nullable
    private final String alterDeliveryText;
    private final double couponDiscount;
    private final double deliveryCharges;
    @NotNull
    private final String estimatedDelivery;
    @Nullable
    private final String fullName;
    private final double gemDiscountOrderAmount;
    private final double grandTotal;
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f60965id;
    private final boolean isGemOrder;
    private final boolean isPreorder;
    @Nullable
    private final Boolean isTgo;
    private final double municipalityTax;
    private int newOrderStatus;
    @Nullable
    private final String orderReceivedTime;
    @Nullable
    private final String orderStatus;
    @Nullable
    private final String orderTime;
    @Nullable
    private final String orderTransactionID;
    @Nullable
    private final String paymentMethod;
    @Nullable
    private final String preOrderDeliveryTime;
    private final boolean providesTracking;
    @Nullable
    private final String restaurantLogo;
    @NotNull
    private final String restaurantName;
    private boolean status;
    private final double subTotal;
    private final double talabatCharges;
    private final double touristTax;
    private final double voucherDiscount;
    private final boolean wasOrderSuccessStatus;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/homescreen/adapter/model/order_tracking/OrderTrackingItem$Companion;", "", "()V", "CANCELED", "", "DELIVERED", "DELIVERING", "OLD_STATUS", "ORDERED", "PREPARING", "REPLACEMENT", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OrderTrackingItem(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, double d11, double d12, double d13, double d14, @Nullable String str6, double d15, double d16, double d17, double d18, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, int i11, boolean z11, double d19, @Nullable String str11, boolean z12, boolean z13, boolean z14, boolean z15, @Nullable String str12, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "restaurantName");
        Intrinsics.checkNotNullParameter(str3, "estimatedDelivery");
        this.f60965id = str;
        this.restaurantName = str2;
        this.estimatedDelivery = str3;
        this.orderStatus = str4;
        this.fullName = str5;
        this.subTotal = d11;
        this.grandTotal = d12;
        this.deliveryCharges = d13;
        this.talabatCharges = d14;
        this.paymentMethod = str6;
        this.municipalityTax = d15;
        this.touristTax = d16;
        this.voucherDiscount = d17;
        this.couponDiscount = d18;
        this.alterDeliveryText = str7;
        this.restaurantLogo = str8;
        this.orderTime = str9;
        this.orderReceivedTime = str10;
        this.newOrderStatus = i11;
        this.isGemOrder = z11;
        this.gemDiscountOrderAmount = d19;
        this.orderTransactionID = str11;
        this.status = z12;
        this.providesTracking = z13;
        this.isPreorder = z14;
        this.wasOrderSuccessStatus = z15;
        this.preOrderDeliveryTime = str12;
        this.isTgo = bool;
    }

    public static /* synthetic */ OrderTrackingItem copy$default(OrderTrackingItem orderTrackingItem, String str, String str2, String str3, String str4, String str5, double d11, double d12, double d13, double d14, String str6, double d15, double d16, double d17, double d18, String str7, String str8, String str9, String str10, int i11, boolean z11, double d19, String str11, boolean z12, boolean z13, boolean z14, boolean z15, String str12, Boolean bool, int i12, Object obj) {
        OrderTrackingItem orderTrackingItem2 = orderTrackingItem;
        int i13 = i12;
        String str13 = (i13 & 1) != 0 ? orderTrackingItem2.f60965id : str;
        String str14 = (i13 & 2) != 0 ? orderTrackingItem2.restaurantName : str2;
        String str15 = (i13 & 4) != 0 ? orderTrackingItem2.estimatedDelivery : str3;
        String str16 = (i13 & 8) != 0 ? orderTrackingItem2.orderStatus : str4;
        String str17 = (i13 & 16) != 0 ? orderTrackingItem2.fullName : str5;
        double d21 = (i13 & 32) != 0 ? orderTrackingItem2.subTotal : d11;
        double d22 = (i13 & 64) != 0 ? orderTrackingItem2.grandTotal : d12;
        double d23 = (i13 & 128) != 0 ? orderTrackingItem2.deliveryCharges : d13;
        double d24 = (i13 & 256) != 0 ? orderTrackingItem2.talabatCharges : d14;
        return orderTrackingItem.copy(str13, str14, str15, str16, str17, d21, d22, d23, d24, (i13 & 512) != 0 ? orderTrackingItem2.paymentMethod : str6, (i13 & 1024) != 0 ? orderTrackingItem2.municipalityTax : d15, (i13 & 2048) != 0 ? orderTrackingItem2.touristTax : d16, (i13 & 4096) != 0 ? orderTrackingItem2.voucherDiscount : d17, (i13 & 8192) != 0 ? orderTrackingItem2.couponDiscount : d18, (i13 & 16384) != 0 ? orderTrackingItem2.alterDeliveryText : str7, (i13 & 32768) != 0 ? orderTrackingItem2.restaurantLogo : str8, (i13 & 65536) != 0 ? orderTrackingItem2.orderTime : str9, (i13 & 131072) != 0 ? orderTrackingItem2.orderReceivedTime : str10, (i13 & 262144) != 0 ? orderTrackingItem2.newOrderStatus : i11, (i13 & 524288) != 0 ? orderTrackingItem2.isGemOrder : z11, (i13 & 1048576) != 0 ? orderTrackingItem2.gemDiscountOrderAmount : d19, (i13 & 2097152) != 0 ? orderTrackingItem2.orderTransactionID : str11, (4194304 & i13) != 0 ? orderTrackingItem2.status : z12, (i13 & 8388608) != 0 ? orderTrackingItem2.providesTracking : z13, (i13 & 16777216) != 0 ? orderTrackingItem2.isPreorder : z14, (i13 & 33554432) != 0 ? orderTrackingItem2.wasOrderSuccessStatus : z15, (i13 & 67108864) != 0 ? orderTrackingItem2.preOrderDeliveryTime : str12, (i13 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? orderTrackingItem2.isTgo : bool);
    }

    @NotNull
    public final String component1() {
        return this.f60965id;
    }

    @Nullable
    public final String component10() {
        return this.paymentMethod;
    }

    public final double component11() {
        return this.municipalityTax;
    }

    public final double component12() {
        return this.touristTax;
    }

    public final double component13() {
        return this.voucherDiscount;
    }

    public final double component14() {
        return this.couponDiscount;
    }

    @Nullable
    public final String component15() {
        return this.alterDeliveryText;
    }

    @Nullable
    public final String component16() {
        return this.restaurantLogo;
    }

    @Nullable
    public final String component17() {
        return this.orderTime;
    }

    @Nullable
    public final String component18() {
        return this.orderReceivedTime;
    }

    public final int component19() {
        return this.newOrderStatus;
    }

    @NotNull
    public final String component2() {
        return this.restaurantName;
    }

    public final boolean component20() {
        return this.isGemOrder;
    }

    public final double component21() {
        return this.gemDiscountOrderAmount;
    }

    @Nullable
    public final String component22() {
        return this.orderTransactionID;
    }

    public final boolean component23() {
        return this.status;
    }

    public final boolean component24() {
        return this.providesTracking;
    }

    public final boolean component25() {
        return this.isPreorder;
    }

    public final boolean component26() {
        return this.wasOrderSuccessStatus;
    }

    @Nullable
    public final String component27() {
        return this.preOrderDeliveryTime;
    }

    @Nullable
    public final Boolean component28() {
        return this.isTgo;
    }

    @NotNull
    public final String component3() {
        return this.estimatedDelivery;
    }

    @Nullable
    public final String component4() {
        return this.orderStatus;
    }

    @Nullable
    public final String component5() {
        return this.fullName;
    }

    public final double component6() {
        return this.subTotal;
    }

    public final double component7() {
        return this.grandTotal;
    }

    public final double component8() {
        return this.deliveryCharges;
    }

    public final double component9() {
        return this.talabatCharges;
    }

    @NotNull
    public final OrderTrackingItem copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, double d11, double d12, double d13, double d14, @Nullable String str6, double d15, double d16, double d17, double d18, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, int i11, boolean z11, double d19, @Nullable String str11, boolean z12, boolean z13, boolean z14, boolean z15, @Nullable String str12, @Nullable Boolean bool) {
        String str13 = str;
        Intrinsics.checkNotNullParameter(str13, "id");
        Intrinsics.checkNotNullParameter(str2, "restaurantName");
        Intrinsics.checkNotNullParameter(str3, "estimatedDelivery");
        return new OrderTrackingItem(str13, str2, str3, str4, str5, d11, d12, d13, d14, str6, d15, d16, d17, d18, str7, str8, str9, str10, i11, z11, d19, str11, z12, z13, z14, z15, str12, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderTrackingItem)) {
            return false;
        }
        OrderTrackingItem orderTrackingItem = (OrderTrackingItem) obj;
        return Intrinsics.areEqual((Object) this.f60965id, (Object) orderTrackingItem.f60965id) && Intrinsics.areEqual((Object) this.restaurantName, (Object) orderTrackingItem.restaurantName) && Intrinsics.areEqual((Object) this.estimatedDelivery, (Object) orderTrackingItem.estimatedDelivery) && Intrinsics.areEqual((Object) this.orderStatus, (Object) orderTrackingItem.orderStatus) && Intrinsics.areEqual((Object) this.fullName, (Object) orderTrackingItem.fullName) && Intrinsics.areEqual((Object) Double.valueOf(this.subTotal), (Object) Double.valueOf(orderTrackingItem.subTotal)) && Intrinsics.areEqual((Object) Double.valueOf(this.grandTotal), (Object) Double.valueOf(orderTrackingItem.grandTotal)) && Intrinsics.areEqual((Object) Double.valueOf(this.deliveryCharges), (Object) Double.valueOf(orderTrackingItem.deliveryCharges)) && Intrinsics.areEqual((Object) Double.valueOf(this.talabatCharges), (Object) Double.valueOf(orderTrackingItem.talabatCharges)) && Intrinsics.areEqual((Object) this.paymentMethod, (Object) orderTrackingItem.paymentMethod) && Intrinsics.areEqual((Object) Double.valueOf(this.municipalityTax), (Object) Double.valueOf(orderTrackingItem.municipalityTax)) && Intrinsics.areEqual((Object) Double.valueOf(this.touristTax), (Object) Double.valueOf(orderTrackingItem.touristTax)) && Intrinsics.areEqual((Object) Double.valueOf(this.voucherDiscount), (Object) Double.valueOf(orderTrackingItem.voucherDiscount)) && Intrinsics.areEqual((Object) Double.valueOf(this.couponDiscount), (Object) Double.valueOf(orderTrackingItem.couponDiscount)) && Intrinsics.areEqual((Object) this.alterDeliveryText, (Object) orderTrackingItem.alterDeliveryText) && Intrinsics.areEqual((Object) this.restaurantLogo, (Object) orderTrackingItem.restaurantLogo) && Intrinsics.areEqual((Object) this.orderTime, (Object) orderTrackingItem.orderTime) && Intrinsics.areEqual((Object) this.orderReceivedTime, (Object) orderTrackingItem.orderReceivedTime) && this.newOrderStatus == orderTrackingItem.newOrderStatus && this.isGemOrder == orderTrackingItem.isGemOrder && Intrinsics.areEqual((Object) Double.valueOf(this.gemDiscountOrderAmount), (Object) Double.valueOf(orderTrackingItem.gemDiscountOrderAmount)) && Intrinsics.areEqual((Object) this.orderTransactionID, (Object) orderTrackingItem.orderTransactionID) && this.status == orderTrackingItem.status && this.providesTracking == orderTrackingItem.providesTracking && this.isPreorder == orderTrackingItem.isPreorder && this.wasOrderSuccessStatus == orderTrackingItem.wasOrderSuccessStatus && Intrinsics.areEqual((Object) this.preOrderDeliveryTime, (Object) orderTrackingItem.preOrderDeliveryTime) && Intrinsics.areEqual((Object) this.isTgo, (Object) orderTrackingItem.isTgo);
    }

    @Nullable
    public final String getAlterDeliveryText() {
        return this.alterDeliveryText;
    }

    public final double getCouponDiscount() {
        return this.couponDiscount;
    }

    public final double getDeliveryCharges() {
        return this.deliveryCharges;
    }

    @NotNull
    public final String getEstimatedDelivery() {
        return this.estimatedDelivery;
    }

    @Nullable
    public final String getFullName() {
        return this.fullName;
    }

    public final double getGemDiscountOrderAmount() {
        return this.gemDiscountOrderAmount;
    }

    public final double getGrandTotal() {
        return this.grandTotal;
    }

    @NotNull
    public final String getId() {
        return this.f60965id;
    }

    public final double getMunicipalityTax() {
        return this.municipalityTax;
    }

    public final int getNewOrderStatus() {
        return this.newOrderStatus;
    }

    @Nullable
    public final String getOrderReceivedTime() {
        return this.orderReceivedTime;
    }

    @Nullable
    public final String getOrderStatus() {
        return this.orderStatus;
    }

    @Nullable
    public final String getOrderTime() {
        return this.orderTime;
    }

    @Nullable
    public final String getOrderTransactionID() {
        return this.orderTransactionID;
    }

    @Nullable
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    @Nullable
    public final String getPreOrderDeliveryTime() {
        return this.preOrderDeliveryTime;
    }

    public final boolean getProvidesTracking() {
        return this.providesTracking;
    }

    @Nullable
    public final String getRestaurantLogo() {
        return this.restaurantLogo;
    }

    @NotNull
    public final String getRestaurantName() {
        return this.restaurantName;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final double getSubTotal() {
        return this.subTotal;
    }

    public final double getTalabatCharges() {
        return this.talabatCharges;
    }

    public final double getTouristTax() {
        return this.touristTax;
    }

    public final double getVoucherDiscount() {
        return this.voucherDiscount;
    }

    public final boolean getWasOrderSuccessStatus() {
        return this.wasOrderSuccessStatus;
    }

    public int hashCode() {
        int hashCode = ((((this.f60965id.hashCode() * 31) + this.restaurantName.hashCode()) * 31) + this.estimatedDelivery.hashCode()) * 31;
        String str = this.orderStatus;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fullName;
        int hashCode3 = (((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Double.doubleToLongBits(this.subTotal)) * 31) + Double.doubleToLongBits(this.grandTotal)) * 31) + Double.doubleToLongBits(this.deliveryCharges)) * 31) + Double.doubleToLongBits(this.talabatCharges)) * 31;
        String str3 = this.paymentMethod;
        int hashCode4 = (((((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Double.doubleToLongBits(this.municipalityTax)) * 31) + Double.doubleToLongBits(this.touristTax)) * 31) + Double.doubleToLongBits(this.voucherDiscount)) * 31) + Double.doubleToLongBits(this.couponDiscount)) * 31;
        String str4 = this.alterDeliveryText;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.restaurantLogo;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.orderTime;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.orderReceivedTime;
        int hashCode8 = (((hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.newOrderStatus) * 31;
        boolean z11 = this.isGemOrder;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int a11 = (((hashCode8 + (z11 ? 1 : 0)) * 31) + Double.doubleToLongBits(this.gemDiscountOrderAmount)) * 31;
        String str8 = this.orderTransactionID;
        int hashCode9 = (a11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        boolean z13 = this.status;
        if (z13) {
            z13 = true;
        }
        int i12 = (hashCode9 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.providesTracking;
        if (z14) {
            z14 = true;
        }
        int i13 = (i12 + (z14 ? 1 : 0)) * 31;
        boolean z15 = this.isPreorder;
        if (z15) {
            z15 = true;
        }
        int i14 = (i13 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this.wasOrderSuccessStatus;
        if (!z16) {
            z12 = z16;
        }
        int i15 = (i14 + (z12 ? 1 : 0)) * 31;
        String str9 = this.preOrderDeliveryTime;
        int hashCode10 = (i15 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Boolean bool = this.isTgo;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode10 + i11;
    }

    public final boolean isGemOrder() {
        return this.isGemOrder;
    }

    public final boolean isPreorder() {
        return this.isPreorder;
    }

    @Nullable
    public final Boolean isTgo() {
        return this.isTgo;
    }

    public final void setNewOrderStatus(int i11) {
        this.newOrderStatus = i11;
    }

    public final void setStatus(boolean z11) {
        this.status = z11;
    }

    @NotNull
    public String toString() {
        String str = this.f60965id;
        String str2 = this.restaurantName;
        String str3 = this.estimatedDelivery;
        String str4 = this.orderStatus;
        String str5 = this.fullName;
        double d11 = this.subTotal;
        double d12 = this.grandTotal;
        double d13 = this.deliveryCharges;
        double d14 = this.talabatCharges;
        String str6 = this.paymentMethod;
        double d15 = this.municipalityTax;
        double d16 = this.touristTax;
        double d17 = this.voucherDiscount;
        double d18 = this.couponDiscount;
        String str7 = this.alterDeliveryText;
        String str8 = this.restaurantLogo;
        String str9 = this.orderTime;
        String str10 = this.orderReceivedTime;
        int i11 = this.newOrderStatus;
        String str11 = str7;
        boolean z11 = this.isGemOrder;
        double d19 = this.gemDiscountOrderAmount;
        String str12 = this.orderTransactionID;
        boolean z12 = this.status;
        boolean z13 = this.providesTracking;
        boolean z14 = this.isPreorder;
        boolean z15 = this.wasOrderSuccessStatus;
        String str13 = this.preOrderDeliveryTime;
        Boolean bool = this.isTgo;
        return "OrderTrackingItem(id=" + str + ", restaurantName=" + str2 + ", estimatedDelivery=" + str3 + ", orderStatus=" + str4 + ", fullName=" + str5 + ", subTotal=" + d11 + ", grandTotal=" + d12 + ", deliveryCharges=" + d13 + ", talabatCharges=" + d14 + ", paymentMethod=" + str6 + ", municipalityTax=" + d15 + ", touristTax=" + d16 + ", voucherDiscount=" + d17 + ", couponDiscount=" + d18 + ", alterDeliveryText=" + str11 + ", restaurantLogo=" + str8 + ", orderTime=" + str9 + ", orderReceivedTime=" + str10 + ", newOrderStatus=" + i11 + ", isGemOrder=" + z11 + ", gemDiscountOrderAmount=" + d19 + ", orderTransactionID=" + str12 + ", status=" + z12 + ", providesTracking=" + z13 + ", isPreorder=" + z14 + ", wasOrderSuccessStatus=" + z15 + ", preOrderDeliveryTime=" + str13 + ", isTgo=" + bool + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderTrackingItem(String str, String str2, String str3, String str4, String str5, double d11, double d12, double d13, double d14, String str6, double d15, double d16, double d17, double d18, String str7, String str8, String str9, String str10, int i11, boolean z11, double d19, String str11, boolean z12, boolean z13, boolean z14, boolean z15, String str12, Boolean bool, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, d11, d12, d13, d14, str6, d15, d16, d17, d18, str7, str8, str9, (i12 & 131072) != 0 ? null : str10, i11, z11, d19, (i12 & 2097152) != 0 ? null : str11, (i12 & 4194304) != 0 ? false : z12, z13, z14, z15, (i12 & 67108864) != 0 ? null : str12, (i12 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? null : bool);
    }
}
