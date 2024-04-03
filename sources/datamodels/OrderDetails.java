package datamodels;

import buisnessmodels.TalabatFormatter;
import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.talabat.domain.address.Address;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b]\b\b\u0018\u00002\u00020\u0001B\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\t\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\t\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010+J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010X\u001a\u00020\tHÆ\u0003J\t\u0010Y\u001a\u00020\tHÆ\u0003J\t\u0010Z\u001a\u00020\tHÆ\u0003J\t\u0010[\u001a\u00020\tHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0005HÆ\u0003J\u0013\u0010c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001bHÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010f\u001a\u00020!HÆ\u0003J\t\u0010g\u001a\u00020\u0005HÆ\u0003J\t\u0010h\u001a\u00020\tHÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010l\u001a\u00020\tHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010MJ\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010p\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010MJ\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010r\u001a\u00020\tHÆ\u0003J\t\u0010s\u001a\u00020\tHÆ\u0003J\t\u0010t\u001a\u00020\tHÆ\u0003J\t\u0010u\u001a\u00020\tHÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0003\u0010w\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00052\u0012\b\u0002\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\t2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\t2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010xJ\u0013\u0010y\u001a\u00020\u00052\b\u0010z\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u00100\u001a\u00020\u0003J\u0006\u00104\u001a\u00020\u0003J\u0006\u0010;\u001a\u00020\u0003J\u0006\u0010T\u001a\u00020\u0003J\t\u0010{\u001a\u00020!HÖ\u0001J\u0006\u0010|\u001a\u00020\u0005J\t\u0010}\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0016\u0010\u0013\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00101R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010-R\u0011\u00106\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b7\u0010-R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010-R\u0016\u0010#\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u00101R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010-R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00101R\u0016\u0010\"\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010<R\u0016\u0010\u0019\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010<R\u0016\u0010\u0010\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u00101R\u0016\u0010 \u001a\u00020!8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R \u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010-R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010-R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010-R\u0018\u0010$\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010-R\u0016\u0010%\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010-R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010-R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010-R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010-R\u0016\u0010&\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u00101R\u0018\u0010'\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010-R\u001a\u0010(\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010N\u001a\u0004\bL\u0010MR\u0018\u0010)\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010-R\u001a\u0010*\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\n\n\u0002\u0010N\u001a\u0004\bP\u0010MR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u00101R\u0016\u0010\f\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u00101R\u0016\u0010\u0011\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u00101R\u0016\u0010\u0012\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u00101¨\u0006~"}, d2 = {"Ldatamodels/OrderDetails;", "", "restaurantName", "", "status", "", "orderStatus", "fullName", "subTotal", "", "grandTotal", "deliveryCharges", "talabatCharges", "orderID", "paymentMethod", "deliveryTime", "municipalityTax", "touristTax", "voucherDiscount", "couponDiscount", "alterDeliveryText", "alterMunicipalityText", "alterTouristText", "restaurantLogo", "orderTime", "isPreOrder", "orderDetailsItems", "Ljava/util/ArrayList;", "Ldatamodels/OrderDetailsItem;", "deliveryAddress", "Lcom/talabat/domain/address/Address;", "generalRequest", "newOrderStatus", "", "isGemOrder", "gemDiscountOrderAmount", "orderTransactionID", "orderType", "riderTipAmount", "serviceFeeLabel", "serviceFeeValue", "smallOrderFeeLabel", "smallOrderFeeValue", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;FFFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;FFFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/ArrayList;Lcom/talabat/domain/address/Address;Ljava/lang/String;IZFLjava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;)V", "getAlterDeliveryText", "()Ljava/lang/String;", "getAlterMunicipalityText", "getAlterTouristText", "getCouponDiscount", "()F", "getDeliveryAddress", "()Lcom/talabat/domain/address/Address;", "getDeliveryCharges", "getDeliveryTime", "displayTalabatCharges", "getDisplayTalabatCharges", "getFullName", "getGemDiscountOrderAmount", "getGeneralRequest", "getGrandTotal", "()Z", "getMunicipalityTax", "getNewOrderStatus", "()I", "getOrderDetailsItems", "()Ljava/util/ArrayList;", "getOrderID", "getOrderStatus", "getOrderTime", "getOrderTransactionID", "getOrderType", "getPaymentMethod", "getRestaurantLogo", "getRestaurantName", "getRiderTipAmount", "getServiceFeeLabel", "getServiceFeeValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getSmallOrderFeeLabel", "getSmallOrderFeeValue", "getSubTotal", "getTalabatCharges", "getTouristTax", "getVoucherDiscount", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;FFFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;FFFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/ArrayList;Lcom/talabat/domain/address/Address;Ljava/lang/String;IZFLjava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/Float;)Ldatamodels/OrderDetails;", "equals", "other", "hashCode", "isPickup", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetails {
    @SerializedName("adt")
    @Nullable
    private final String alterDeliveryText;
    @SerializedName("amtx")
    @Nullable
    private final String alterMunicipalityText;
    @SerializedName("attx")
    @Nullable
    private final String alterTouristText;
    @SerializedName("cpd")
    private final float couponDiscount;
    @SerializedName("adr")
    @Nullable
    private final Address deliveryAddress;
    @SerializedName("dchr")
    private final float deliveryCharges;
    @SerializedName("don")
    @Nullable
    private final String deliveryTime;
    @SerializedName("cnm")
    @Nullable
    private final String fullName;
    @SerializedName("gdt")
    private final float gemDiscountOrderAmount;
    @SerializedName("gr")
    @Nullable
    private final String generalRequest;
    @SerializedName("gtot")
    private final float grandTotal;
    @SerializedName("igo")
    private final boolean isGemOrder;
    @SerializedName("ispre")
    private final boolean isPreOrder;
    @SerializedName("mtx")
    private final float municipalityTax;
    @SerializedName("eos")
    private final int newOrderStatus;
    @SerializedName("oitm")
    @Nullable
    private final ArrayList<OrderDetailsItem> orderDetailsItems;
    @SerializedName("roid")
    @Nullable
    private final String orderID;
    @SerializedName("orst")
    @Nullable
    private final String orderStatus;
    @SerializedName("ocon")
    @Nullable
    private final String orderTime;
    @SerializedName("oid")
    @Nullable
    private final String orderTransactionID;
    @SerializedName("otp")
    @NotNull
    private final String orderType;
    @SerializedName("pmt")
    @Nullable
    private final String paymentMethod;
    @SerializedName("logo")
    @Nullable
    private final String restaurantLogo;
    @SerializedName("rnm")
    @Nullable
    private final String restaurantName;
    @SerializedName("rtip")
    private final float riderTipAmount;
    @SerializedName("sfl")
    @Nullable
    private final String serviceFeeLabel;
    @SerializedName("sf")
    @Nullable
    private final Float serviceFeeValue;
    @SerializedName("sofl")
    @Nullable
    private final String smallOrderFeeLabel;
    @SerializedName("sof")
    @Nullable
    private final Float smallOrderFeeValue;
    @SerializedName("ost")
    @JvmField
    public final boolean status;
    @SerializedName("stot")
    private final float subTotal;
    @SerializedName("cft")
    private final float talabatCharges;
    @SerializedName("ttx")
    private final float touristTax;
    @SerializedName("vd")
    private final float voucherDiscount;

    public OrderDetails() {
        this((String) null, false, (String) null, (String) null, 0.0f, 0.0f, 0.0f, 0.0f, (String) null, (String) null, (String) null, 0.0f, 0.0f, 0.0f, 0.0f, (String) null, (String) null, (String) null, (String) null, (String) null, false, (ArrayList) null, (Address) null, (String) null, 0, false, 0.0f, (String) null, (String) null, 0.0f, (String) null, (Float) null, (String) null, (Float) null, -1, 3, (DefaultConstructorMarker) null);
    }

    public OrderDetails(@Nullable String str, boolean z11, @Nullable String str2, @Nullable String str3, float f11, float f12, float f13, float f14, @Nullable String str4, @Nullable String str5, @Nullable String str6, float f15, float f16, float f17, float f18, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, boolean z12, @Nullable ArrayList<OrderDetailsItem> arrayList, @Nullable Address address, @Nullable String str12, int i11, boolean z13, float f19, @Nullable String str13, @NotNull String str14, float f21, @Nullable String str15, @Nullable Float f22, @Nullable String str16, @Nullable Float f23) {
        String str17 = str14;
        Intrinsics.checkNotNullParameter(str17, "orderType");
        this.restaurantName = str;
        this.status = z11;
        this.orderStatus = str2;
        this.fullName = str3;
        this.subTotal = f11;
        this.grandTotal = f12;
        this.deliveryCharges = f13;
        this.talabatCharges = f14;
        this.orderID = str4;
        this.paymentMethod = str5;
        this.deliveryTime = str6;
        this.municipalityTax = f15;
        this.touristTax = f16;
        this.voucherDiscount = f17;
        this.couponDiscount = f18;
        this.alterDeliveryText = str7;
        this.alterMunicipalityText = str8;
        this.alterTouristText = str9;
        this.restaurantLogo = str10;
        this.orderTime = str11;
        this.isPreOrder = z12;
        this.orderDetailsItems = arrayList;
        this.deliveryAddress = address;
        this.generalRequest = str12;
        this.newOrderStatus = i11;
        this.isGemOrder = z13;
        this.gemDiscountOrderAmount = f19;
        this.orderTransactionID = str13;
        this.orderType = str17;
        this.riderTipAmount = f21;
        this.serviceFeeLabel = str15;
        this.serviceFeeValue = f22;
        this.smallOrderFeeLabel = str16;
        this.smallOrderFeeValue = f23;
    }

    public static /* synthetic */ OrderDetails copy$default(OrderDetails orderDetails, String str, boolean z11, String str2, String str3, float f11, float f12, float f13, float f14, String str4, String str5, String str6, float f15, float f16, float f17, float f18, String str7, String str8, String str9, String str10, String str11, boolean z12, ArrayList arrayList, Address address, String str12, int i11, boolean z13, float f19, String str13, String str14, float f21, String str15, Float f22, String str16, Float f23, int i12, int i13, Object obj) {
        OrderDetails orderDetails2 = orderDetails;
        int i14 = i12;
        return orderDetails.copy((i14 & 1) != 0 ? orderDetails2.restaurantName : str, (i14 & 2) != 0 ? orderDetails2.status : z11, (i14 & 4) != 0 ? orderDetails2.orderStatus : str2, (i14 & 8) != 0 ? orderDetails2.fullName : str3, (i14 & 16) != 0 ? orderDetails2.subTotal : f11, (i14 & 32) != 0 ? orderDetails2.grandTotal : f12, (i14 & 64) != 0 ? orderDetails2.deliveryCharges : f13, (i14 & 128) != 0 ? orderDetails2.talabatCharges : f14, (i14 & 256) != 0 ? orderDetails2.orderID : str4, (i14 & 512) != 0 ? orderDetails2.paymentMethod : str5, (i14 & 1024) != 0 ? orderDetails2.deliveryTime : str6, (i14 & 2048) != 0 ? orderDetails2.municipalityTax : f15, (i14 & 4096) != 0 ? orderDetails2.touristTax : f16, (i14 & 8192) != 0 ? orderDetails2.voucherDiscount : f17, (i14 & 16384) != 0 ? orderDetails2.couponDiscount : f18, (i14 & 32768) != 0 ? orderDetails2.alterDeliveryText : str7, (i14 & 65536) != 0 ? orderDetails2.alterMunicipalityText : str8, (i14 & 131072) != 0 ? orderDetails2.alterTouristText : str9, (i14 & 262144) != 0 ? orderDetails2.restaurantLogo : str10, (i14 & 524288) != 0 ? orderDetails2.orderTime : str11, (i14 & 1048576) != 0 ? orderDetails2.isPreOrder : z12, (i14 & 2097152) != 0 ? orderDetails2.orderDetailsItems : arrayList, (i14 & 4194304) != 0 ? orderDetails2.deliveryAddress : address, (i14 & 8388608) != 0 ? orderDetails2.generalRequest : str12, (i14 & 16777216) != 0 ? orderDetails2.newOrderStatus : i11, (i14 & 33554432) != 0 ? orderDetails2.isGemOrder : z13, (i14 & 67108864) != 0 ? orderDetails2.gemDiscountOrderAmount : f19, (i14 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? orderDetails2.orderTransactionID : str13, (i14 & 268435456) != 0 ? orderDetails2.orderType : str14, (i14 & 536870912) != 0 ? orderDetails2.riderTipAmount : f21, (i14 & 1073741824) != 0 ? orderDetails2.serviceFeeLabel : str15, (i14 & Integer.MIN_VALUE) != 0 ? orderDetails2.serviceFeeValue : f22, (i13 & 1) != 0 ? orderDetails2.smallOrderFeeLabel : str16, (i13 & 2) != 0 ? orderDetails2.smallOrderFeeValue : f23);
    }

    @Nullable
    public final String component1() {
        return this.restaurantName;
    }

    @Nullable
    public final String component10() {
        return this.paymentMethod;
    }

    @Nullable
    public final String component11() {
        return this.deliveryTime;
    }

    public final float component12() {
        return this.municipalityTax;
    }

    public final float component13() {
        return this.touristTax;
    }

    public final float component14() {
        return this.voucherDiscount;
    }

    public final float component15() {
        return this.couponDiscount;
    }

    @Nullable
    public final String component16() {
        return this.alterDeliveryText;
    }

    @Nullable
    public final String component17() {
        return this.alterMunicipalityText;
    }

    @Nullable
    public final String component18() {
        return this.alterTouristText;
    }

    @Nullable
    public final String component19() {
        return this.restaurantLogo;
    }

    public final boolean component2() {
        return this.status;
    }

    @Nullable
    public final String component20() {
        return this.orderTime;
    }

    public final boolean component21() {
        return this.isPreOrder;
    }

    @Nullable
    public final ArrayList<OrderDetailsItem> component22() {
        return this.orderDetailsItems;
    }

    @Nullable
    public final Address component23() {
        return this.deliveryAddress;
    }

    @Nullable
    public final String component24() {
        return this.generalRequest;
    }

    public final int component25() {
        return this.newOrderStatus;
    }

    public final boolean component26() {
        return this.isGemOrder;
    }

    public final float component27() {
        return this.gemDiscountOrderAmount;
    }

    @Nullable
    public final String component28() {
        return this.orderTransactionID;
    }

    @NotNull
    public final String component29() {
        return this.orderType;
    }

    @Nullable
    public final String component3() {
        return this.orderStatus;
    }

    public final float component30() {
        return this.riderTipAmount;
    }

    @Nullable
    public final String component31() {
        return this.serviceFeeLabel;
    }

    @Nullable
    public final Float component32() {
        return this.serviceFeeValue;
    }

    @Nullable
    public final String component33() {
        return this.smallOrderFeeLabel;
    }

    @Nullable
    public final Float component34() {
        return this.smallOrderFeeValue;
    }

    @Nullable
    public final String component4() {
        return this.fullName;
    }

    public final float component5() {
        return this.subTotal;
    }

    public final float component6() {
        return this.grandTotal;
    }

    public final float component7() {
        return this.deliveryCharges;
    }

    public final float component8() {
        return this.talabatCharges;
    }

    @Nullable
    public final String component9() {
        return this.orderID;
    }

    @NotNull
    public final OrderDetails copy(@Nullable String str, boolean z11, @Nullable String str2, @Nullable String str3, float f11, float f12, float f13, float f14, @Nullable String str4, @Nullable String str5, @Nullable String str6, float f15, float f16, float f17, float f18, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, boolean z12, @Nullable ArrayList<OrderDetailsItem> arrayList, @Nullable Address address, @Nullable String str12, int i11, boolean z13, float f19, @Nullable String str13, @NotNull String str14, float f21, @Nullable String str15, @Nullable Float f22, @Nullable String str16, @Nullable Float f23) {
        String str17 = str;
        Intrinsics.checkNotNullParameter(str14, "orderType");
        return new OrderDetails(str, z11, str2, str3, f11, f12, f13, f14, str4, str5, str6, f15, f16, f17, f18, str7, str8, str9, str10, str11, z12, arrayList, address, str12, i11, z13, f19, str13, str14, f21, str15, f22, str16, f23);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderDetails)) {
            return false;
        }
        OrderDetails orderDetails = (OrderDetails) obj;
        return Intrinsics.areEqual((Object) this.restaurantName, (Object) orderDetails.restaurantName) && this.status == orderDetails.status && Intrinsics.areEqual((Object) this.orderStatus, (Object) orderDetails.orderStatus) && Intrinsics.areEqual((Object) this.fullName, (Object) orderDetails.fullName) && Intrinsics.areEqual((Object) Float.valueOf(this.subTotal), (Object) Float.valueOf(orderDetails.subTotal)) && Intrinsics.areEqual((Object) Float.valueOf(this.grandTotal), (Object) Float.valueOf(orderDetails.grandTotal)) && Intrinsics.areEqual((Object) Float.valueOf(this.deliveryCharges), (Object) Float.valueOf(orderDetails.deliveryCharges)) && Intrinsics.areEqual((Object) Float.valueOf(this.talabatCharges), (Object) Float.valueOf(orderDetails.talabatCharges)) && Intrinsics.areEqual((Object) this.orderID, (Object) orderDetails.orderID) && Intrinsics.areEqual((Object) this.paymentMethod, (Object) orderDetails.paymentMethod) && Intrinsics.areEqual((Object) this.deliveryTime, (Object) orderDetails.deliveryTime) && Intrinsics.areEqual((Object) Float.valueOf(this.municipalityTax), (Object) Float.valueOf(orderDetails.municipalityTax)) && Intrinsics.areEqual((Object) Float.valueOf(this.touristTax), (Object) Float.valueOf(orderDetails.touristTax)) && Intrinsics.areEqual((Object) Float.valueOf(this.voucherDiscount), (Object) Float.valueOf(orderDetails.voucherDiscount)) && Intrinsics.areEqual((Object) Float.valueOf(this.couponDiscount), (Object) Float.valueOf(orderDetails.couponDiscount)) && Intrinsics.areEqual((Object) this.alterDeliveryText, (Object) orderDetails.alterDeliveryText) && Intrinsics.areEqual((Object) this.alterMunicipalityText, (Object) orderDetails.alterMunicipalityText) && Intrinsics.areEqual((Object) this.alterTouristText, (Object) orderDetails.alterTouristText) && Intrinsics.areEqual((Object) this.restaurantLogo, (Object) orderDetails.restaurantLogo) && Intrinsics.areEqual((Object) this.orderTime, (Object) orderDetails.orderTime) && this.isPreOrder == orderDetails.isPreOrder && Intrinsics.areEqual((Object) this.orderDetailsItems, (Object) orderDetails.orderDetailsItems) && Intrinsics.areEqual((Object) this.deliveryAddress, (Object) orderDetails.deliveryAddress) && Intrinsics.areEqual((Object) this.generalRequest, (Object) orderDetails.generalRequest) && this.newOrderStatus == orderDetails.newOrderStatus && this.isGemOrder == orderDetails.isGemOrder && Intrinsics.areEqual((Object) Float.valueOf(this.gemDiscountOrderAmount), (Object) Float.valueOf(orderDetails.gemDiscountOrderAmount)) && Intrinsics.areEqual((Object) this.orderTransactionID, (Object) orderDetails.orderTransactionID) && Intrinsics.areEqual((Object) this.orderType, (Object) orderDetails.orderType) && Intrinsics.areEqual((Object) Float.valueOf(this.riderTipAmount), (Object) Float.valueOf(orderDetails.riderTipAmount)) && Intrinsics.areEqual((Object) this.serviceFeeLabel, (Object) orderDetails.serviceFeeLabel) && Intrinsics.areEqual((Object) this.serviceFeeValue, (Object) orderDetails.serviceFeeValue) && Intrinsics.areEqual((Object) this.smallOrderFeeLabel, (Object) orderDetails.smallOrderFeeLabel) && Intrinsics.areEqual((Object) this.smallOrderFeeValue, (Object) orderDetails.smallOrderFeeValue);
    }

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

    public final float getCouponDiscount() {
        return this.couponDiscount;
    }

    @Nullable
    public final Address getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public final float getDeliveryCharges() {
        return this.deliveryCharges;
    }

    @Nullable
    public final String getDeliveryTime() {
        return this.deliveryTime;
    }

    @NotNull
    public final String getDisplayTalabatCharges() {
        String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(this.talabatCharges);
        Intrinsics.checkNotNullExpressionValue(formattedCurrency, "getInstance().getFormattedCurrency(talabatCharges)");
        return formattedCurrency;
    }

    @Nullable
    public final String getFullName() {
        return this.fullName;
    }

    public final float getGemDiscountOrderAmount() {
        return this.gemDiscountOrderAmount;
    }

    @Nullable
    public final String getGeneralRequest() {
        return this.generalRequest;
    }

    public final float getGrandTotal() {
        return this.grandTotal;
    }

    public final float getMunicipalityTax() {
        return this.municipalityTax;
    }

    public final int getNewOrderStatus() {
        return this.newOrderStatus;
    }

    @Nullable
    public final ArrayList<OrderDetailsItem> getOrderDetailsItems() {
        return this.orderDetailsItems;
    }

    @Nullable
    public final String getOrderID() {
        return this.orderID;
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

    @NotNull
    public final String getOrderType() {
        return this.orderType;
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

    public final float getRiderTipAmount() {
        return this.riderTipAmount;
    }

    @Nullable
    public final String getServiceFeeLabel() {
        return this.serviceFeeLabel;
    }

    @Nullable
    public final Float getServiceFeeValue() {
        return this.serviceFeeValue;
    }

    @Nullable
    public final String getSmallOrderFeeLabel() {
        return this.smallOrderFeeLabel;
    }

    @Nullable
    public final Float getSmallOrderFeeValue() {
        return this.smallOrderFeeValue;
    }

    public final float getSubTotal() {
        return this.subTotal;
    }

    public final float getTalabatCharges() {
        return this.talabatCharges;
    }

    public final float getTouristTax() {
        return this.touristTax;
    }

    public final float getVoucherDiscount() {
        return this.voucherDiscount;
    }

    public int hashCode() {
        String str = this.restaurantName;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z11 = this.status;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i12 = (hashCode + (z11 ? 1 : 0)) * 31;
        String str2 = this.orderStatus;
        int hashCode2 = (i12 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fullName;
        int hashCode3 = (((((((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + Float.floatToIntBits(this.subTotal)) * 31) + Float.floatToIntBits(this.grandTotal)) * 31) + Float.floatToIntBits(this.deliveryCharges)) * 31) + Float.floatToIntBits(this.talabatCharges)) * 31;
        String str4 = this.orderID;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.paymentMethod;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.deliveryTime;
        int hashCode6 = (((((((((hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31) + Float.floatToIntBits(this.municipalityTax)) * 31) + Float.floatToIntBits(this.touristTax)) * 31) + Float.floatToIntBits(this.voucherDiscount)) * 31) + Float.floatToIntBits(this.couponDiscount)) * 31;
        String str7 = this.alterDeliveryText;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.alterMunicipalityText;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.alterTouristText;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.restaurantLogo;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.orderTime;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        boolean z13 = this.isPreOrder;
        if (z13) {
            z13 = true;
        }
        int i13 = (hashCode11 + (z13 ? 1 : 0)) * 31;
        ArrayList<OrderDetailsItem> arrayList = this.orderDetailsItems;
        int hashCode12 = (i13 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        Address address = this.deliveryAddress;
        int hashCode13 = (hashCode12 + (address == null ? 0 : address.hashCode())) * 31;
        String str12 = this.generalRequest;
        int hashCode14 = (((hashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31) + this.newOrderStatus) * 31;
        boolean z14 = this.isGemOrder;
        if (!z14) {
            z12 = z14;
        }
        int floatToIntBits = (((hashCode14 + (z12 ? 1 : 0)) * 31) + Float.floatToIntBits(this.gemDiscountOrderAmount)) * 31;
        String str13 = this.orderTransactionID;
        int hashCode15 = (((((floatToIntBits + (str13 == null ? 0 : str13.hashCode())) * 31) + this.orderType.hashCode()) * 31) + Float.floatToIntBits(this.riderTipAmount)) * 31;
        String str14 = this.serviceFeeLabel;
        int hashCode16 = (hashCode15 + (str14 == null ? 0 : str14.hashCode())) * 31;
        Float f11 = this.serviceFeeValue;
        int hashCode17 = (hashCode16 + (f11 == null ? 0 : f11.hashCode())) * 31;
        String str15 = this.smallOrderFeeLabel;
        int hashCode18 = (hashCode17 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Float f12 = this.smallOrderFeeValue;
        if (f12 != null) {
            i11 = f12.hashCode();
        }
        return hashCode18 + i11;
    }

    public final boolean isGemOrder() {
        return this.isGemOrder;
    }

    public final boolean isPickup() {
        String str = this.orderType;
        return str != null && StringsKt__StringsJVMKt.equals(str, "pickup", true);
    }

    public final boolean isPreOrder() {
        return this.isPreOrder;
    }

    @NotNull
    public String toString() {
        String str = this.restaurantName;
        boolean z11 = this.status;
        String str2 = this.orderStatus;
        String str3 = this.fullName;
        float f11 = this.subTotal;
        float f12 = this.grandTotal;
        float f13 = this.deliveryCharges;
        float f14 = this.talabatCharges;
        String str4 = this.orderID;
        String str5 = this.paymentMethod;
        String str6 = this.deliveryTime;
        float f15 = this.municipalityTax;
        float f16 = this.touristTax;
        float f17 = this.voucherDiscount;
        float f18 = this.couponDiscount;
        String str7 = this.alterDeliveryText;
        String str8 = this.alterMunicipalityText;
        String str9 = this.alterTouristText;
        String str10 = this.restaurantLogo;
        String str11 = this.orderTime;
        boolean z12 = this.isPreOrder;
        ArrayList<OrderDetailsItem> arrayList = this.orderDetailsItems;
        Address address = this.deliveryAddress;
        String str12 = this.generalRequest;
        int i11 = this.newOrderStatus;
        boolean z13 = this.isGemOrder;
        float f19 = this.gemDiscountOrderAmount;
        String str13 = this.orderTransactionID;
        String str14 = this.orderType;
        float f21 = this.riderTipAmount;
        String str15 = this.serviceFeeLabel;
        Float f22 = this.serviceFeeValue;
        String str16 = this.smallOrderFeeLabel;
        Float f23 = this.smallOrderFeeValue;
        return "OrderDetails(restaurantName=" + str + ", status=" + z11 + ", orderStatus=" + str2 + ", fullName=" + str3 + ", subTotal=" + f11 + ", grandTotal=" + f12 + ", deliveryCharges=" + f13 + ", talabatCharges=" + f14 + ", orderID=" + str4 + ", paymentMethod=" + str5 + ", deliveryTime=" + str6 + ", municipalityTax=" + f15 + ", touristTax=" + f16 + ", voucherDiscount=" + f17 + ", couponDiscount=" + f18 + ", alterDeliveryText=" + str7 + ", alterMunicipalityText=" + str8 + ", alterTouristText=" + str9 + ", restaurantLogo=" + str10 + ", orderTime=" + str11 + ", isPreOrder=" + z12 + ", orderDetailsItems=" + arrayList + ", deliveryAddress=" + address + ", generalRequest=" + str12 + ", newOrderStatus=" + i11 + ", isGemOrder=" + z13 + ", gemDiscountOrderAmount=" + f19 + ", orderTransactionID=" + str13 + ", orderType=" + str14 + ", riderTipAmount=" + f21 + ", serviceFeeLabel=" + str15 + ", serviceFeeValue=" + f22 + ", smallOrderFeeLabel=" + str16 + ", smallOrderFeeValue=" + f23 + ")";
    }

    @NotNull
    /* renamed from: getCouponDiscount  reason: collision with other method in class */
    public final String m6321getCouponDiscount() {
        String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(this.couponDiscount);
        Intrinsics.checkNotNullExpressionValue(formattedCurrency, "getInstance().getFormattedCurrency(couponDiscount)");
        return formattedCurrency;
    }

    @NotNull
    /* renamed from: getDeliveryCharges  reason: collision with other method in class */
    public final String m6322getDeliveryCharges() {
        String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(this.deliveryCharges, true);
        Intrinsics.checkNotNullExpressionValue(formattedCurrency, "getInstance().getFormatt…cy(deliveryCharges, true)");
        return formattedCurrency;
    }

    @NotNull
    /* renamed from: getGrandTotal  reason: collision with other method in class */
    public final String m6323getGrandTotal() {
        String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(this.grandTotal, false);
        Intrinsics.checkNotNullExpressionValue(formattedCurrency, "getInstance().getFormatt…rrency(grandTotal, false)");
        return formattedCurrency;
    }

    @NotNull
    /* renamed from: getVoucherDiscount  reason: collision with other method in class */
    public final String m6324getVoucherDiscount() {
        String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(this.voucherDiscount);
        Intrinsics.checkNotNullExpressionValue(formattedCurrency, "getInstance().getFormatt…Currency(voucherDiscount)");
        return formattedCurrency;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OrderDetails(java.lang.String r36, boolean r37, java.lang.String r38, java.lang.String r39, float r40, float r41, float r42, float r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, float r47, float r48, float r49, float r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, boolean r56, java.util.ArrayList r57, com.talabat.domain.address.Address r58, java.lang.String r59, int r60, boolean r61, float r62, java.lang.String r63, java.lang.String r64, float r65, java.lang.String r66, java.lang.Float r67, java.lang.String r68, java.lang.Float r69, int r70, int r71, kotlin.jvm.internal.DefaultConstructorMarker r72) {
        /*
            r35 = this;
            r0 = r70
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r36
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r37
        L_0x0012:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0018
            r5 = 0
            goto L_0x001a
        L_0x0018:
            r5 = r38
        L_0x001a:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0020
            r6 = 0
            goto L_0x0022
        L_0x0020:
            r6 = r39
        L_0x0022:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0028
            r7 = 0
            goto L_0x002a
        L_0x0028:
            r7 = r40
        L_0x002a:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0030
            r9 = 0
            goto L_0x0032
        L_0x0030:
            r9 = r41
        L_0x0032:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0038
            r10 = 0
            goto L_0x003a
        L_0x0038:
            r10 = r42
        L_0x003a:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0040
            r11 = 0
            goto L_0x0042
        L_0x0040:
            r11 = r43
        L_0x0042:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0048
            r12 = 0
            goto L_0x004a
        L_0x0048:
            r12 = r44
        L_0x004a:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0050
            r13 = 0
            goto L_0x0052
        L_0x0050:
            r13 = r45
        L_0x0052:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0058
            r14 = 0
            goto L_0x005a
        L_0x0058:
            r14 = r46
        L_0x005a:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0060
            r15 = 0
            goto L_0x0062
        L_0x0060:
            r15 = r47
        L_0x0062:
            r2 = r0 & 4096(0x1000, float:5.74E-42)
            if (r2 == 0) goto L_0x0068
            r2 = 0
            goto L_0x006a
        L_0x0068:
            r2 = r48
        L_0x006a:
            r4 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r4 == 0) goto L_0x0070
            r4 = 0
            goto L_0x0072
        L_0x0070:
            r4 = r49
        L_0x0072:
            r8 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r8 == 0) goto L_0x0078
            r8 = 0
            goto L_0x007a
        L_0x0078:
            r8 = r50
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r51
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r52
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r53
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r54
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r55
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r56
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r57
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r58
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00dc
            r24 = 0
            goto L_0x00de
        L_0x00dc:
            r24 = r59
        L_0x00de:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e7
            r25 = -5
            goto L_0x00e9
        L_0x00e7:
            r25 = r60
        L_0x00e9:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00f2
            r26 = 0
            goto L_0x00f4
        L_0x00f2:
            r26 = r61
        L_0x00f4:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00fd
            r27 = 0
            goto L_0x00ff
        L_0x00fd:
            r27 = r62
        L_0x00ff:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0108
            r28 = 0
            goto L_0x010a
        L_0x0108:
            r28 = r63
        L_0x010a:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x0113
            java.lang.String r29 = ""
            goto L_0x0115
        L_0x0113:
            r29 = r64
        L_0x0115:
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x011e
            r30 = 0
            goto L_0x0120
        L_0x011e:
            r30 = r65
        L_0x0120:
            r31 = 1073741824(0x40000000, float:2.0)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x0129
            r31 = 0
            goto L_0x012b
        L_0x0129:
            r31 = r66
        L_0x012b:
            r32 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r32
            if (r0 == 0) goto L_0x0137
            r0 = 0
            java.lang.Float r32 = java.lang.Float.valueOf(r0)
            goto L_0x013a
        L_0x0137:
            r0 = 0
            r32 = r67
        L_0x013a:
            r33 = r71 & 1
            if (r33 == 0) goto L_0x0141
            r33 = 0
            goto L_0x0143
        L_0x0141:
            r33 = r68
        L_0x0143:
            r34 = r71 & 2
            if (r34 == 0) goto L_0x014c
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            goto L_0x014e
        L_0x014c:
            r0 = r69
        L_0x014e:
            r36 = r35
            r37 = r1
            r38 = r3
            r39 = r5
            r40 = r6
            r41 = r7
            r42 = r9
            r43 = r10
            r44 = r11
            r45 = r12
            r46 = r13
            r47 = r14
            r48 = r15
            r49 = r2
            r50 = r4
            r51 = r8
            r52 = r16
            r53 = r17
            r54 = r18
            r55 = r19
            r56 = r20
            r57 = r21
            r58 = r22
            r59 = r23
            r60 = r24
            r61 = r25
            r62 = r26
            r63 = r27
            r64 = r28
            r65 = r29
            r66 = r30
            r67 = r31
            r68 = r32
            r69 = r33
            r70 = r0
            r36.<init>(r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: datamodels.OrderDetails.<init>(java.lang.String, boolean, java.lang.String, java.lang.String, float, float, float, float, java.lang.String, java.lang.String, java.lang.String, float, float, float, float, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.util.ArrayList, com.talabat.domain.address.Address, java.lang.String, int, boolean, float, java.lang.String, java.lang.String, float, java.lang.String, java.lang.Float, java.lang.String, java.lang.Float, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
