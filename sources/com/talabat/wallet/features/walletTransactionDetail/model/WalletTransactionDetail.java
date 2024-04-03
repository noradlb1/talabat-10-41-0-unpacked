package com.talabat.wallet.features.walletTransactionDetail.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.asm.Advice;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B¹\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00104\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÂ\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u0003HÖ\u0001J\t\u0010F\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b/\u0010#R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001f¨\u0006G"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetail;", "", "id", "", "name", "", "imageUrl", "transactionTypeId", "transactionTypeName", "description", "date", "amount", "", "orderId", "creditSource", "expiryDays", "cashBack", "Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailCashBackModel;", "restaurant", "Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailRestaurantModel;", "payment", "Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailPaymentModel;", "refund", "Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailRefundModel;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailCashBackModel;Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailRestaurantModel;Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailPaymentModel;Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailRefundModel;)V", "getAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getCashBack", "()Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailCashBackModel;", "getCreditSource", "()Ljava/lang/String;", "getDate", "getDescription", "getExpiryDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getImageUrl", "getName", "getOrderId", "getPayment", "()Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailPaymentModel;", "getRefund", "()Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailRefundModel;", "getRestaurant", "()Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailRestaurantModel;", "getTransactionTypeId", "getTransactionTypeName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailCashBackModel;Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailRestaurantModel;Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailPaymentModel;Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetailRefundModel;)Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetail;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetail {
    @SerializedName("amount")
    @Nullable
    private final Float amount;
    @SerializedName("cashback")
    @Nullable
    private final WalletTransactionDetailCashBackModel cashBack;
    @SerializedName("creditSource")
    @Nullable
    private final String creditSource;
    @SerializedName("date")
    @Nullable
    private final String date;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("expiryDays")
    @Nullable
    private final Integer expiryDays;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f12598id;
    @SerializedName("imageUrl")
    @Nullable
    private final String imageUrl;
    @SerializedName("name")
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f12599name;
    @SerializedName("orderId")
    @Nullable
    private final String orderId;
    @SerializedName("payment")
    @Nullable
    private final WalletTransactionDetailPaymentModel payment;
    @SerializedName("refund")
    @Nullable
    private final WalletTransactionDetailRefundModel refund;
    @SerializedName("restaurant")
    @Nullable
    private final WalletTransactionDetailRestaurantModel restaurant;
    @SerializedName("transactionTypeId")
    @Nullable
    private final Integer transactionTypeId;
    @SerializedName("transactionTypeName")
    @Nullable
    private final String transactionTypeName;

    public WalletTransactionDetail() {
        this((Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (Float) null, (String) null, (String) null, (Integer) null, (WalletTransactionDetailCashBackModel) null, (WalletTransactionDetailRestaurantModel) null, (WalletTransactionDetailPaymentModel) null, (WalletTransactionDetailRefundModel) null, Advice.MethodSizeHandler.UNDEFINED_SIZE, (DefaultConstructorMarker) null);
    }

    public WalletTransactionDetail(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Integer num2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Float f11, @Nullable String str6, @Nullable String str7, @Nullable Integer num3, @Nullable WalletTransactionDetailCashBackModel walletTransactionDetailCashBackModel, @Nullable WalletTransactionDetailRestaurantModel walletTransactionDetailRestaurantModel, @Nullable WalletTransactionDetailPaymentModel walletTransactionDetailPaymentModel, @Nullable WalletTransactionDetailRefundModel walletTransactionDetailRefundModel) {
        this.f12598id = num;
        this.f12599name = str;
        this.imageUrl = str2;
        this.transactionTypeId = num2;
        this.transactionTypeName = str3;
        this.description = str4;
        this.date = str5;
        this.amount = f11;
        this.orderId = str6;
        this.creditSource = str7;
        this.expiryDays = num3;
        this.cashBack = walletTransactionDetailCashBackModel;
        this.restaurant = walletTransactionDetailRestaurantModel;
        this.payment = walletTransactionDetailPaymentModel;
        this.refund = walletTransactionDetailRefundModel;
    }

    public static /* synthetic */ WalletTransactionDetail copy$default(WalletTransactionDetail walletTransactionDetail, Integer num, String str, String str2, Integer num2, String str3, String str4, String str5, Float f11, String str6, String str7, Integer num3, WalletTransactionDetailCashBackModel walletTransactionDetailCashBackModel, WalletTransactionDetailRestaurantModel walletTransactionDetailRestaurantModel, WalletTransactionDetailPaymentModel walletTransactionDetailPaymentModel, WalletTransactionDetailRefundModel walletTransactionDetailRefundModel, int i11, Object obj) {
        WalletTransactionDetail walletTransactionDetail2 = walletTransactionDetail;
        int i12 = i11;
        return walletTransactionDetail.copy((i12 & 1) != 0 ? walletTransactionDetail2.f12598id : num, (i12 & 2) != 0 ? walletTransactionDetail2.f12599name : str, (i12 & 4) != 0 ? walletTransactionDetail2.imageUrl : str2, (i12 & 8) != 0 ? walletTransactionDetail2.transactionTypeId : num2, (i12 & 16) != 0 ? walletTransactionDetail2.transactionTypeName : str3, (i12 & 32) != 0 ? walletTransactionDetail2.description : str4, (i12 & 64) != 0 ? walletTransactionDetail2.date : str5, (i12 & 128) != 0 ? walletTransactionDetail2.amount : f11, (i12 & 256) != 0 ? walletTransactionDetail2.orderId : str6, (i12 & 512) != 0 ? walletTransactionDetail2.creditSource : str7, (i12 & 1024) != 0 ? walletTransactionDetail2.expiryDays : num3, (i12 & 2048) != 0 ? walletTransactionDetail2.cashBack : walletTransactionDetailCashBackModel, (i12 & 4096) != 0 ? walletTransactionDetail2.restaurant : walletTransactionDetailRestaurantModel, (i12 & 8192) != 0 ? walletTransactionDetail2.payment : walletTransactionDetailPaymentModel, (i12 & 16384) != 0 ? walletTransactionDetail2.refund : walletTransactionDetailRefundModel);
    }

    @Nullable
    public final Integer component1() {
        return this.f12598id;
    }

    @Nullable
    public final String component10() {
        return this.creditSource;
    }

    @Nullable
    public final Integer component11() {
        return this.expiryDays;
    }

    @Nullable
    public final WalletTransactionDetailCashBackModel component12() {
        return this.cashBack;
    }

    @Nullable
    public final WalletTransactionDetailRestaurantModel component13() {
        return this.restaurant;
    }

    @Nullable
    public final WalletTransactionDetailPaymentModel component14() {
        return this.payment;
    }

    @Nullable
    public final WalletTransactionDetailRefundModel component15() {
        return this.refund;
    }

    @Nullable
    public final String component2() {
        return this.f12599name;
    }

    @Nullable
    public final String component3() {
        return this.imageUrl;
    }

    @Nullable
    public final Integer component4() {
        return this.transactionTypeId;
    }

    @Nullable
    public final String component5() {
        return this.transactionTypeName;
    }

    @Nullable
    public final String component6() {
        return this.description;
    }

    @Nullable
    public final String component7() {
        return this.date;
    }

    @Nullable
    public final Float component8() {
        return this.amount;
    }

    @Nullable
    public final String component9() {
        return this.orderId;
    }

    @NotNull
    public final WalletTransactionDetail copy(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Integer num2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Float f11, @Nullable String str6, @Nullable String str7, @Nullable Integer num3, @Nullable WalletTransactionDetailCashBackModel walletTransactionDetailCashBackModel, @Nullable WalletTransactionDetailRestaurantModel walletTransactionDetailRestaurantModel, @Nullable WalletTransactionDetailPaymentModel walletTransactionDetailPaymentModel, @Nullable WalletTransactionDetailRefundModel walletTransactionDetailRefundModel) {
        return new WalletTransactionDetail(num, str, str2, num2, str3, str4, str5, f11, str6, str7, num3, walletTransactionDetailCashBackModel, walletTransactionDetailRestaurantModel, walletTransactionDetailPaymentModel, walletTransactionDetailRefundModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletTransactionDetail)) {
            return false;
        }
        WalletTransactionDetail walletTransactionDetail = (WalletTransactionDetail) obj;
        return Intrinsics.areEqual((Object) this.f12598id, (Object) walletTransactionDetail.f12598id) && Intrinsics.areEqual((Object) this.f12599name, (Object) walletTransactionDetail.f12599name) && Intrinsics.areEqual((Object) this.imageUrl, (Object) walletTransactionDetail.imageUrl) && Intrinsics.areEqual((Object) this.transactionTypeId, (Object) walletTransactionDetail.transactionTypeId) && Intrinsics.areEqual((Object) this.transactionTypeName, (Object) walletTransactionDetail.transactionTypeName) && Intrinsics.areEqual((Object) this.description, (Object) walletTransactionDetail.description) && Intrinsics.areEqual((Object) this.date, (Object) walletTransactionDetail.date) && Intrinsics.areEqual((Object) this.amount, (Object) walletTransactionDetail.amount) && Intrinsics.areEqual((Object) this.orderId, (Object) walletTransactionDetail.orderId) && Intrinsics.areEqual((Object) this.creditSource, (Object) walletTransactionDetail.creditSource) && Intrinsics.areEqual((Object) this.expiryDays, (Object) walletTransactionDetail.expiryDays) && Intrinsics.areEqual((Object) this.cashBack, (Object) walletTransactionDetail.cashBack) && Intrinsics.areEqual((Object) this.restaurant, (Object) walletTransactionDetail.restaurant) && Intrinsics.areEqual((Object) this.payment, (Object) walletTransactionDetail.payment) && Intrinsics.areEqual((Object) this.refund, (Object) walletTransactionDetail.refund);
    }

    @Nullable
    public final Float getAmount() {
        return this.amount;
    }

    @Nullable
    public final WalletTransactionDetailCashBackModel getCashBack() {
        return this.cashBack;
    }

    @Nullable
    public final String getCreditSource() {
        return this.creditSource;
    }

    @Nullable
    public final String getDate() {
        return this.date;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Integer getExpiryDays() {
        return this.expiryDays;
    }

    @Nullable
    public final Integer getId() {
        return this.f12598id;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final String getName() {
        return this.f12599name;
    }

    @Nullable
    public final String getOrderId() {
        return this.orderId;
    }

    @Nullable
    public final WalletTransactionDetailPaymentModel getPayment() {
        return this.payment;
    }

    @Nullable
    public final WalletTransactionDetailRefundModel getRefund() {
        return this.refund;
    }

    @Nullable
    public final WalletTransactionDetailRestaurantModel getRestaurant() {
        return this.restaurant;
    }

    @Nullable
    public final Integer getTransactionTypeId() {
        return this.transactionTypeId;
    }

    @Nullable
    public final String getTransactionTypeName() {
        return this.transactionTypeName;
    }

    public int hashCode() {
        Integer num = this.f12598id;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.f12599name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.imageUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.transactionTypeId;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.transactionTypeName;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.date;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Float f11 = this.amount;
        int hashCode8 = (hashCode7 + (f11 == null ? 0 : f11.hashCode())) * 31;
        String str6 = this.orderId;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.creditSource;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num3 = this.expiryDays;
        int hashCode11 = (hashCode10 + (num3 == null ? 0 : num3.hashCode())) * 31;
        WalletTransactionDetailCashBackModel walletTransactionDetailCashBackModel = this.cashBack;
        int hashCode12 = (hashCode11 + (walletTransactionDetailCashBackModel == null ? 0 : walletTransactionDetailCashBackModel.hashCode())) * 31;
        WalletTransactionDetailRestaurantModel walletTransactionDetailRestaurantModel = this.restaurant;
        int hashCode13 = (hashCode12 + (walletTransactionDetailRestaurantModel == null ? 0 : walletTransactionDetailRestaurantModel.hashCode())) * 31;
        WalletTransactionDetailPaymentModel walletTransactionDetailPaymentModel = this.payment;
        int hashCode14 = (hashCode13 + (walletTransactionDetailPaymentModel == null ? 0 : walletTransactionDetailPaymentModel.hashCode())) * 31;
        WalletTransactionDetailRefundModel walletTransactionDetailRefundModel = this.refund;
        if (walletTransactionDetailRefundModel != null) {
            i11 = walletTransactionDetailRefundModel.hashCode();
        }
        return hashCode14 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.f12598id;
        String str = this.f12599name;
        String str2 = this.imageUrl;
        Integer num2 = this.transactionTypeId;
        String str3 = this.transactionTypeName;
        String str4 = this.description;
        String str5 = this.date;
        Float f11 = this.amount;
        String str6 = this.orderId;
        String str7 = this.creditSource;
        Integer num3 = this.expiryDays;
        WalletTransactionDetailCashBackModel walletTransactionDetailCashBackModel = this.cashBack;
        WalletTransactionDetailRestaurantModel walletTransactionDetailRestaurantModel = this.restaurant;
        WalletTransactionDetailPaymentModel walletTransactionDetailPaymentModel = this.payment;
        WalletTransactionDetailRefundModel walletTransactionDetailRefundModel = this.refund;
        return "WalletTransactionDetail(id=" + num + ", name=" + str + ", imageUrl=" + str2 + ", transactionTypeId=" + num2 + ", transactionTypeName=" + str3 + ", description=" + str4 + ", date=" + str5 + ", amount=" + f11 + ", orderId=" + str6 + ", creditSource=" + str7 + ", expiryDays=" + num3 + ", cashBack=" + walletTransactionDetailCashBackModel + ", restaurant=" + walletTransactionDetailRestaurantModel + ", payment=" + walletTransactionDetailPaymentModel + ", refund=" + walletTransactionDetailRefundModel + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WalletTransactionDetail(java.lang.Integer r17, java.lang.String r18, java.lang.String r19, java.lang.Integer r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.Float r24, java.lang.String r25, java.lang.String r26, java.lang.Integer r27, com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailCashBackModel r28, com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailRestaurantModel r29, com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailPaymentModel r30, com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailRefundModel r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001b
        L_0x0019:
            r4 = r19
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r2
            goto L_0x0023
        L_0x0021:
            r5 = r20
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = r2
            goto L_0x002b
        L_0x0029:
            r6 = r21
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = r2
            goto L_0x0033
        L_0x0031:
            r7 = r22
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r23
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = r2
            goto L_0x0043
        L_0x0041:
            r9 = r24
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = r2
            goto L_0x004b
        L_0x0049:
            r10 = r25
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = r2
            goto L_0x0053
        L_0x0051:
            r11 = r26
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = r2
            goto L_0x005b
        L_0x0059:
            r12 = r27
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0061
            r13 = r2
            goto L_0x0063
        L_0x0061:
            r13 = r28
        L_0x0063:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0069
            r14 = r2
            goto L_0x006b
        L_0x0069:
            r14 = r29
        L_0x006b:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0071
            r15 = r2
            goto L_0x0073
        L_0x0071:
            r15 = r30
        L_0x0073:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0078
            goto L_0x007a
        L_0x0078:
            r2 = r31
        L_0x007a:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r31 = r15
            r32 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetail.<init>(java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Float, java.lang.String, java.lang.String, java.lang.Integer, com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailCashBackModel, com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailRestaurantModel, com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailPaymentModel, com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailRefundModel, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
