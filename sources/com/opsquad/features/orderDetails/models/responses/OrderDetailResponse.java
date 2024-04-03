package com.opsquad.features.orderDetails.models.responses;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001e\u0010$\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001e\u0010*\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010/\"\u0004\b0\u00101R\u001e\u00102\u001a\u00020.8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010/\"\u0004\b3\u00101R\u001e\u00104\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0012\"\u0004\b6\u0010\u0014R\u001e\u00107\u001a\u0002088\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R \u0010=\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR&\u0010@\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010A8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR \u0010G\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0006\"\u0004\bI\u0010\bR \u0010J\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0006\"\u0004\bL\u0010\bR \u0010M\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0006\"\u0004\bO\u0010\bR \u0010P\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0006\"\u0004\bR\u0010\bR \u0010S\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0006\"\u0004\bU\u0010\bR\u001e\u0010V\u001a\u00020.8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010/\"\u0004\bX\u00101R\u001e\u0010Y\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0012\"\u0004\b[\u0010\u0014R\u001e\u0010\\\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0012\"\u0004\b^\u0010\u0014R\u001e\u0010_\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0012\"\u0004\ba\u0010\u0014R\u001e\u0010b\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0012\"\u0004\bd\u0010\u0014¨\u0006e"}, d2 = {"Lcom/opsquad/features/orderDetails/models/responses/OrderDetailResponse;", "", "()V", "alterDeliveryText", "", "getAlterDeliveryText", "()Ljava/lang/String;", "setAlterDeliveryText", "(Ljava/lang/String;)V", "alterMunicipalityText", "getAlterMunicipalityText", "setAlterMunicipalityText", "alterTouristText", "getAlterTouristText", "setAlterTouristText", "couponDiscount", "", "getCouponDiscount", "()D", "setCouponDiscount", "(D)V", "deliveryCharges", "getDeliveryCharges", "setDeliveryCharges", "deliveryOrderAddress", "Lcom/opsquad/features/orderDetails/models/responses/OrderAddressResponse;", "getDeliveryOrderAddress", "()Lcom/opsquad/features/orderDetails/models/responses/OrderAddressResponse;", "setDeliveryOrderAddress", "(Lcom/opsquad/features/orderDetails/models/responses/OrderAddressResponse;)V", "deliveryTime", "getDeliveryTime", "setDeliveryTime", "fullName", "getFullName", "setFullName", "gemDiscoundOrderAmount", "getGemDiscoundOrderAmount", "setGemDiscoundOrderAmount", "generalRequest", "getGeneralRequest", "setGeneralRequest", "grandTotal", "getGrandTotal", "setGrandTotal", "isGemOrder", "", "()Z", "setGemOrder", "(Z)V", "isPreOrder", "setPreOrder", "municipalityTax", "getMunicipalityTax", "setMunicipalityTax", "newOrderStatus", "", "getNewOrderStatus", "()I", "setNewOrderStatus", "(I)V", "orderID", "getOrderID", "setOrderID", "orderItems", "Ljava/util/ArrayList;", "Lcom/opsquad/features/orderDetails/models/responses/OrderItemResponse;", "getOrderItems", "()Ljava/util/ArrayList;", "setOrderItems", "(Ljava/util/ArrayList;)V", "orderStatus", "getOrderStatus", "setOrderStatus", "orderTime", "getOrderTime", "setOrderTime", "paymentMethod", "getPaymentMethod", "setPaymentMethod", "restaurantLogo", "getRestaurantLogo", "setRestaurantLogo", "restaurantName", "getRestaurantName", "setRestaurantName", "status", "getStatus", "setStatus", "subTotal", "getSubTotal", "setSubTotal", "talabatCharges", "getTalabatCharges", "setTalabatCharges", "touristTax", "getTouristTax", "setTouristTax", "voucherDiscount", "getVoucherDiscount", "setVoucherDiscount", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailResponse {
    @SerializedName("adt")
    @Nullable
    private String alterDeliveryText;
    @SerializedName("amtx")
    @Nullable
    private String alterMunicipalityText;
    @SerializedName("attx")
    @Nullable
    private String alterTouristText;
    @SerializedName("cpd")
    private double couponDiscount;
    @SerializedName("dchr")
    private double deliveryCharges;
    @SerializedName("adr")
    @Nullable
    private OrderAddressResponse deliveryOrderAddress;
    @SerializedName("don")
    @Nullable
    private String deliveryTime;
    @SerializedName("cnm")
    @Nullable
    private String fullName;
    @SerializedName("gdt")
    private double gemDiscoundOrderAmount;
    @SerializedName("gr")
    @Nullable
    private String generalRequest;
    @SerializedName("gtot")
    private double grandTotal;
    @SerializedName("igo")
    private boolean isGemOrder;
    @SerializedName("ispre")
    private boolean isPreOrder;
    @SerializedName("mtx")
    private double municipalityTax;
    @SerializedName("eos")
    private int newOrderStatus;
    @SerializedName("roid")
    @Nullable
    private String orderID;
    @SerializedName("oitm")
    @Nullable
    private ArrayList<OrderItemResponse> orderItems;
    @SerializedName("orst")
    @Nullable
    private String orderStatus;
    @SerializedName("ocon")
    @Nullable
    private String orderTime;
    @SerializedName("pmt")
    @Nullable
    private String paymentMethod;
    @SerializedName("logo")
    @Nullable
    private String restaurantLogo;
    @SerializedName("rnm")
    @Nullable
    private String restaurantName;
    @SerializedName("ost")
    private boolean status;
    @SerializedName("stot")
    private double subTotal;
    @SerializedName("cft")
    private double talabatCharges;
    @SerializedName("ttx")
    private double touristTax;
    @SerializedName("vd")
    private double voucherDiscount;

    @Nullable
    public final String getAlterDeliveryText() {
        return this.alterDeliveryText;
    }

    @Nullable
    public final String getAlterMunicipalityText() {
        return this.alterMunicipalityText;
    }

    @Nullable
    public final String getAlterTouristText() {
        return this.alterTouristText;
    }

    public final double getCouponDiscount() {
        return this.couponDiscount;
    }

    public final double getDeliveryCharges() {
        return this.deliveryCharges;
    }

    @Nullable
    public final OrderAddressResponse getDeliveryOrderAddress() {
        return this.deliveryOrderAddress;
    }

    @Nullable
    public final String getDeliveryTime() {
        return this.deliveryTime;
    }

    @Nullable
    public final String getFullName() {
        return this.fullName;
    }

    public final double getGemDiscoundOrderAmount() {
        return this.gemDiscoundOrderAmount;
    }

    @Nullable
    public final String getGeneralRequest() {
        return this.generalRequest;
    }

    public final double getGrandTotal() {
        return this.grandTotal;
    }

    public final double getMunicipalityTax() {
        return this.municipalityTax;
    }

    public final int getNewOrderStatus() {
        return this.newOrderStatus;
    }

    @Nullable
    public final String getOrderID() {
        return this.orderID;
    }

    @Nullable
    public final ArrayList<OrderItemResponse> getOrderItems() {
        return this.orderItems;
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
    public final String getPaymentMethod() {
        return this.paymentMethod;
    }

    @Nullable
    public final String getRestaurantLogo() {
        return this.restaurantLogo;
    }

    @Nullable
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

    public final boolean isGemOrder() {
        return this.isGemOrder;
    }

    public final boolean isPreOrder() {
        return this.isPreOrder;
    }

    public final void setAlterDeliveryText(@Nullable String str) {
        this.alterDeliveryText = str;
    }

    public final void setAlterMunicipalityText(@Nullable String str) {
        this.alterMunicipalityText = str;
    }

    public final void setAlterTouristText(@Nullable String str) {
        this.alterTouristText = str;
    }

    public final void setCouponDiscount(double d11) {
        this.couponDiscount = d11;
    }

    public final void setDeliveryCharges(double d11) {
        this.deliveryCharges = d11;
    }

    public final void setDeliveryOrderAddress(@Nullable OrderAddressResponse orderAddressResponse) {
        this.deliveryOrderAddress = orderAddressResponse;
    }

    public final void setDeliveryTime(@Nullable String str) {
        this.deliveryTime = str;
    }

    public final void setFullName(@Nullable String str) {
        this.fullName = str;
    }

    public final void setGemDiscoundOrderAmount(double d11) {
        this.gemDiscoundOrderAmount = d11;
    }

    public final void setGemOrder(boolean z11) {
        this.isGemOrder = z11;
    }

    public final void setGeneralRequest(@Nullable String str) {
        this.generalRequest = str;
    }

    public final void setGrandTotal(double d11) {
        this.grandTotal = d11;
    }

    public final void setMunicipalityTax(double d11) {
        this.municipalityTax = d11;
    }

    public final void setNewOrderStatus(int i11) {
        this.newOrderStatus = i11;
    }

    public final void setOrderID(@Nullable String str) {
        this.orderID = str;
    }

    public final void setOrderItems(@Nullable ArrayList<OrderItemResponse> arrayList) {
        this.orderItems = arrayList;
    }

    public final void setOrderStatus(@Nullable String str) {
        this.orderStatus = str;
    }

    public final void setOrderTime(@Nullable String str) {
        this.orderTime = str;
    }

    public final void setPaymentMethod(@Nullable String str) {
        this.paymentMethod = str;
    }

    public final void setPreOrder(boolean z11) {
        this.isPreOrder = z11;
    }

    public final void setRestaurantLogo(@Nullable String str) {
        this.restaurantLogo = str;
    }

    public final void setRestaurantName(@Nullable String str) {
        this.restaurantName = str;
    }

    public final void setStatus(boolean z11) {
        this.status = z11;
    }

    public final void setSubTotal(double d11) {
        this.subTotal = d11;
    }

    public final void setTalabatCharges(double d11) {
        this.talabatCharges = d11;
    }

    public final void setTouristTax(double d11) {
        this.touristTax = d11;
    }

    public final void setVoucherDiscount(double d11) {
        this.voucherDiscount = d11;
    }
}
