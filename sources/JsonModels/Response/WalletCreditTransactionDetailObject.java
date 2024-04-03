package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÂ\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u0003HÖ\u0001J\t\u0010@\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b)\u0010#R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001a¨\u0006A"}, d2 = {"LJsonModels/Response/WalletCreditTransactionDetailObject;", "", "id", "", "name", "", "imageUrl", "transactionTypeId", "transactionTypeName", "description", "date", "amount", "", "areaName", "orderId", "expiryDays", "cardType", "card4Digits", "creditSource", "cashBack", "LJsonModels/Response/WalletCreditTransactionDetailCashBack;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LJsonModels/Response/WalletCreditTransactionDetailCashBack;)V", "getAmount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getAreaName", "()Ljava/lang/String;", "getCard4Digits", "getCardType", "getCashBack", "()LJsonModels/Response/WalletCreditTransactionDetailCashBack;", "getCreditSource", "getDate", "getDescription", "getExpiryDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getImageUrl", "getName", "getOrderId", "getTransactionTypeId", "getTransactionTypeName", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LJsonModels/Response/WalletCreditTransactionDetailCashBack;)LJsonModels/Response/WalletCreditTransactionDetailObject;", "equals", "", "other", "hashCode", "toString", "com_talabat_core_legacy-models_legacy-models"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCreditTransactionDetailObject {
    @SerializedName("amount")
    @Nullable
    private final Float amount;
    @SerializedName("areaName")
    @Nullable
    private final String areaName;
    @SerializedName("card4Digits")
    @Nullable
    private final String card4Digits;
    @SerializedName("cardType")
    @Nullable
    private final String cardType;
    @SerializedName("cashback")
    @Nullable
    private final WalletCreditTransactionDetailCashBack cashBack;
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
    private final Integer f482id;
    @SerializedName("imageUrl")
    @Nullable
    private final String imageUrl;
    @SerializedName("name")
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f483name;
    @SerializedName("orderId")
    @Nullable
    private final String orderId;
    @SerializedName("transactionTypeId")
    @Nullable
    private final Integer transactionTypeId;
    @SerializedName("transactionTypeName")
    @Nullable
    private final String transactionTypeName;

    public WalletCreditTransactionDetailObject(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Integer num2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Float f11, @Nullable String str6, @Nullable String str7, @Nullable Integer num3, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable WalletCreditTransactionDetailCashBack walletCreditTransactionDetailCashBack) {
        this.f482id = num;
        this.f483name = str;
        this.imageUrl = str2;
        this.transactionTypeId = num2;
        this.transactionTypeName = str3;
        this.description = str4;
        this.date = str5;
        this.amount = f11;
        this.areaName = str6;
        this.orderId = str7;
        this.expiryDays = num3;
        this.cardType = str8;
        this.card4Digits = str9;
        this.creditSource = str10;
        this.cashBack = walletCreditTransactionDetailCashBack;
    }

    public static /* synthetic */ WalletCreditTransactionDetailObject copy$default(WalletCreditTransactionDetailObject walletCreditTransactionDetailObject, Integer num, String str, String str2, Integer num2, String str3, String str4, String str5, Float f11, String str6, String str7, Integer num3, String str8, String str9, String str10, WalletCreditTransactionDetailCashBack walletCreditTransactionDetailCashBack, int i11, Object obj) {
        WalletCreditTransactionDetailObject walletCreditTransactionDetailObject2 = walletCreditTransactionDetailObject;
        int i12 = i11;
        return walletCreditTransactionDetailObject.copy((i12 & 1) != 0 ? walletCreditTransactionDetailObject2.f482id : num, (i12 & 2) != 0 ? walletCreditTransactionDetailObject2.f483name : str, (i12 & 4) != 0 ? walletCreditTransactionDetailObject2.imageUrl : str2, (i12 & 8) != 0 ? walletCreditTransactionDetailObject2.transactionTypeId : num2, (i12 & 16) != 0 ? walletCreditTransactionDetailObject2.transactionTypeName : str3, (i12 & 32) != 0 ? walletCreditTransactionDetailObject2.description : str4, (i12 & 64) != 0 ? walletCreditTransactionDetailObject2.date : str5, (i12 & 128) != 0 ? walletCreditTransactionDetailObject2.amount : f11, (i12 & 256) != 0 ? walletCreditTransactionDetailObject2.areaName : str6, (i12 & 512) != 0 ? walletCreditTransactionDetailObject2.orderId : str7, (i12 & 1024) != 0 ? walletCreditTransactionDetailObject2.expiryDays : num3, (i12 & 2048) != 0 ? walletCreditTransactionDetailObject2.cardType : str8, (i12 & 4096) != 0 ? walletCreditTransactionDetailObject2.card4Digits : str9, (i12 & 8192) != 0 ? walletCreditTransactionDetailObject2.creditSource : str10, (i12 & 16384) != 0 ? walletCreditTransactionDetailObject2.cashBack : walletCreditTransactionDetailCashBack);
    }

    @Nullable
    public final Integer component1() {
        return this.f482id;
    }

    @Nullable
    public final String component10() {
        return this.orderId;
    }

    @Nullable
    public final Integer component11() {
        return this.expiryDays;
    }

    @Nullable
    public final String component12() {
        return this.cardType;
    }

    @Nullable
    public final String component13() {
        return this.card4Digits;
    }

    @Nullable
    public final String component14() {
        return this.creditSource;
    }

    @Nullable
    public final WalletCreditTransactionDetailCashBack component15() {
        return this.cashBack;
    }

    @Nullable
    public final String component2() {
        return this.f483name;
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
        return this.areaName;
    }

    @NotNull
    public final WalletCreditTransactionDetailObject copy(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Integer num2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Float f11, @Nullable String str6, @Nullable String str7, @Nullable Integer num3, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable WalletCreditTransactionDetailCashBack walletCreditTransactionDetailCashBack) {
        return new WalletCreditTransactionDetailObject(num, str, str2, num2, str3, str4, str5, f11, str6, str7, num3, str8, str9, str10, walletCreditTransactionDetailCashBack);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletCreditTransactionDetailObject)) {
            return false;
        }
        WalletCreditTransactionDetailObject walletCreditTransactionDetailObject = (WalletCreditTransactionDetailObject) obj;
        return Intrinsics.areEqual((Object) this.f482id, (Object) walletCreditTransactionDetailObject.f482id) && Intrinsics.areEqual((Object) this.f483name, (Object) walletCreditTransactionDetailObject.f483name) && Intrinsics.areEqual((Object) this.imageUrl, (Object) walletCreditTransactionDetailObject.imageUrl) && Intrinsics.areEqual((Object) this.transactionTypeId, (Object) walletCreditTransactionDetailObject.transactionTypeId) && Intrinsics.areEqual((Object) this.transactionTypeName, (Object) walletCreditTransactionDetailObject.transactionTypeName) && Intrinsics.areEqual((Object) this.description, (Object) walletCreditTransactionDetailObject.description) && Intrinsics.areEqual((Object) this.date, (Object) walletCreditTransactionDetailObject.date) && Intrinsics.areEqual((Object) this.amount, (Object) walletCreditTransactionDetailObject.amount) && Intrinsics.areEqual((Object) this.areaName, (Object) walletCreditTransactionDetailObject.areaName) && Intrinsics.areEqual((Object) this.orderId, (Object) walletCreditTransactionDetailObject.orderId) && Intrinsics.areEqual((Object) this.expiryDays, (Object) walletCreditTransactionDetailObject.expiryDays) && Intrinsics.areEqual((Object) this.cardType, (Object) walletCreditTransactionDetailObject.cardType) && Intrinsics.areEqual((Object) this.card4Digits, (Object) walletCreditTransactionDetailObject.card4Digits) && Intrinsics.areEqual((Object) this.creditSource, (Object) walletCreditTransactionDetailObject.creditSource) && Intrinsics.areEqual((Object) this.cashBack, (Object) walletCreditTransactionDetailObject.cashBack);
    }

    @Nullable
    public final Float getAmount() {
        return this.amount;
    }

    @Nullable
    public final String getAreaName() {
        return this.areaName;
    }

    @Nullable
    public final String getCard4Digits() {
        return this.card4Digits;
    }

    @Nullable
    public final String getCardType() {
        return this.cardType;
    }

    @Nullable
    public final WalletCreditTransactionDetailCashBack getCashBack() {
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
        return this.f482id;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final String getName() {
        return this.f483name;
    }

    @Nullable
    public final String getOrderId() {
        return this.orderId;
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
        Integer num = this.f482id;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.f483name;
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
        String str6 = this.areaName;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.orderId;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num3 = this.expiryDays;
        int hashCode11 = (hashCode10 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str8 = this.cardType;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.card4Digits;
        int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.creditSource;
        int hashCode14 = (hashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        WalletCreditTransactionDetailCashBack walletCreditTransactionDetailCashBack = this.cashBack;
        if (walletCreditTransactionDetailCashBack != null) {
            i11 = walletCreditTransactionDetailCashBack.hashCode();
        }
        return hashCode14 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.f482id;
        String str = this.f483name;
        String str2 = this.imageUrl;
        Integer num2 = this.transactionTypeId;
        String str3 = this.transactionTypeName;
        String str4 = this.description;
        String str5 = this.date;
        Float f11 = this.amount;
        String str6 = this.areaName;
        String str7 = this.orderId;
        Integer num3 = this.expiryDays;
        String str8 = this.cardType;
        String str9 = this.card4Digits;
        String str10 = this.creditSource;
        WalletCreditTransactionDetailCashBack walletCreditTransactionDetailCashBack = this.cashBack;
        return "WalletCreditTransactionDetailObject(id=" + num + ", name=" + str + ", imageUrl=" + str2 + ", transactionTypeId=" + num2 + ", transactionTypeName=" + str3 + ", description=" + str4 + ", date=" + str5 + ", amount=" + f11 + ", areaName=" + str6 + ", orderId=" + str7 + ", expiryDays=" + num3 + ", cardType=" + str8 + ", card4Digits=" + str9 + ", creditSource=" + str10 + ", cashBack=" + walletCreditTransactionDetailCashBack + ")";
    }
}
