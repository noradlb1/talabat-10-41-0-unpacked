package com.talabat.talabatcommon.feature.walletCardList.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b7\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0014J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010%J\u0010\u00105\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010%J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÎ\u0001\u0010>\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\u000b2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020CHÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b\u0012\u0010%R\"\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\u0013\u0010%\"\u0004\b'\u0010(R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b\n\u0010%R\"\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\u0010\u0010%\"\u0004\b)\u0010(R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0016R \u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018¨\u0006E"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardList/model/response/WalletCreditCardGetListItemModel;", "", "token", "", "cardNumber", "cardType", "expiryDate", "expiryYear", "expiryMonth", "holderName", "isCardValid", "", "email", "checkoutMessage", "binNumber", "menuMessage", "isCvvForced", "tokenId", "isBinDiscountValid", "isCardDefault", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getBinNumber", "()Ljava/lang/String;", "setBinNumber", "(Ljava/lang/String;)V", "getCardNumber", "setCardNumber", "getCardType", "getCheckoutMessage", "getEmail", "setEmail", "getExpiryDate", "setExpiryDate", "getExpiryMonth", "setExpiryMonth", "getExpiryYear", "getHolderName", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "setCardDefault", "(Ljava/lang/Boolean;)V", "setCvvForced", "getMenuMessage", "getToken", "getTokenId", "setTokenId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/talabat/talabatcommon/feature/walletCardList/model/response/WalletCreditCardGetListItemModel;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCreditCardGetListItemModel {
    @SerializedName("binNumber")
    @Nullable
    private String binNumber;
    @SerializedName("cardnumber")
    @Nullable
    private String cardNumber;
    @SerializedName("cardtype")
    @Nullable
    private final String cardType;
    @SerializedName("chkOutMesg")
    @Nullable
    private final String checkoutMessage;
    @SerializedName("email")
    @Nullable
    private String email;
    @SerializedName("expiredate")
    @Nullable
    private String expiryDate;
    @SerializedName("expiremonth")
    @Nullable
    private String expiryMonth;
    @SerializedName("expireyear")
    @Nullable
    private final String expiryYear;
    @SerializedName("holdername")
    @Nullable
    private final String holderName;
    @SerializedName("isBinDiscountValid")
    @Nullable
    private final Boolean isBinDiscountValid;
    @SerializedName("isDefault")
    @Nullable
    private Boolean isCardDefault;
    @SerializedName("isValidCard")
    @Nullable
    private final Boolean isCardValid;
    @SerializedName("isForceCvv")
    @Nullable
    private Boolean isCvvForced;
    @SerializedName("menuMesg")
    @Nullable
    private final String menuMessage;
    @SerializedName("token")
    @Nullable
    private final String token;
    @SerializedName("tokenId")
    @Nullable
    private String tokenId;

    public WalletCreditCardGetListItemModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Boolean bool, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable Boolean bool2, @Nullable String str12, @Nullable Boolean bool3, @Nullable Boolean bool4) {
        this.token = str;
        this.cardNumber = str2;
        this.cardType = str3;
        this.expiryDate = str4;
        this.expiryYear = str5;
        this.expiryMonth = str6;
        this.holderName = str7;
        this.isCardValid = bool;
        this.email = str8;
        this.checkoutMessage = str9;
        this.binNumber = str10;
        this.menuMessage = str11;
        this.isCvvForced = bool2;
        this.tokenId = str12;
        this.isBinDiscountValid = bool3;
        this.isCardDefault = bool4;
    }

    public static /* synthetic */ WalletCreditCardGetListItemModel copy$default(WalletCreditCardGetListItemModel walletCreditCardGetListItemModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, String str10, String str11, Boolean bool2, String str12, Boolean bool3, Boolean bool4, int i11, Object obj) {
        WalletCreditCardGetListItemModel walletCreditCardGetListItemModel2 = walletCreditCardGetListItemModel;
        int i12 = i11;
        return walletCreditCardGetListItemModel.copy((i12 & 1) != 0 ? walletCreditCardGetListItemModel2.token : str, (i12 & 2) != 0 ? walletCreditCardGetListItemModel2.cardNumber : str2, (i12 & 4) != 0 ? walletCreditCardGetListItemModel2.cardType : str3, (i12 & 8) != 0 ? walletCreditCardGetListItemModel2.expiryDate : str4, (i12 & 16) != 0 ? walletCreditCardGetListItemModel2.expiryYear : str5, (i12 & 32) != 0 ? walletCreditCardGetListItemModel2.expiryMonth : str6, (i12 & 64) != 0 ? walletCreditCardGetListItemModel2.holderName : str7, (i12 & 128) != 0 ? walletCreditCardGetListItemModel2.isCardValid : bool, (i12 & 256) != 0 ? walletCreditCardGetListItemModel2.email : str8, (i12 & 512) != 0 ? walletCreditCardGetListItemModel2.checkoutMessage : str9, (i12 & 1024) != 0 ? walletCreditCardGetListItemModel2.binNumber : str10, (i12 & 2048) != 0 ? walletCreditCardGetListItemModel2.menuMessage : str11, (i12 & 4096) != 0 ? walletCreditCardGetListItemModel2.isCvvForced : bool2, (i12 & 8192) != 0 ? walletCreditCardGetListItemModel2.tokenId : str12, (i12 & 16384) != 0 ? walletCreditCardGetListItemModel2.isBinDiscountValid : bool3, (i12 & 32768) != 0 ? walletCreditCardGetListItemModel2.isCardDefault : bool4);
    }

    @Nullable
    public final String component1() {
        return this.token;
    }

    @Nullable
    public final String component10() {
        return this.checkoutMessage;
    }

    @Nullable
    public final String component11() {
        return this.binNumber;
    }

    @Nullable
    public final String component12() {
        return this.menuMessage;
    }

    @Nullable
    public final Boolean component13() {
        return this.isCvvForced;
    }

    @Nullable
    public final String component14() {
        return this.tokenId;
    }

    @Nullable
    public final Boolean component15() {
        return this.isBinDiscountValid;
    }

    @Nullable
    public final Boolean component16() {
        return this.isCardDefault;
    }

    @Nullable
    public final String component2() {
        return this.cardNumber;
    }

    @Nullable
    public final String component3() {
        return this.cardType;
    }

    @Nullable
    public final String component4() {
        return this.expiryDate;
    }

    @Nullable
    public final String component5() {
        return this.expiryYear;
    }

    @Nullable
    public final String component6() {
        return this.expiryMonth;
    }

    @Nullable
    public final String component7() {
        return this.holderName;
    }

    @Nullable
    public final Boolean component8() {
        return this.isCardValid;
    }

    @Nullable
    public final String component9() {
        return this.email;
    }

    @NotNull
    public final WalletCreditCardGetListItemModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Boolean bool, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable Boolean bool2, @Nullable String str12, @Nullable Boolean bool3, @Nullable Boolean bool4) {
        return new WalletCreditCardGetListItemModel(str, str2, str3, str4, str5, str6, str7, bool, str8, str9, str10, str11, bool2, str12, bool3, bool4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletCreditCardGetListItemModel)) {
            return false;
        }
        WalletCreditCardGetListItemModel walletCreditCardGetListItemModel = (WalletCreditCardGetListItemModel) obj;
        return Intrinsics.areEqual((Object) this.token, (Object) walletCreditCardGetListItemModel.token) && Intrinsics.areEqual((Object) this.cardNumber, (Object) walletCreditCardGetListItemModel.cardNumber) && Intrinsics.areEqual((Object) this.cardType, (Object) walletCreditCardGetListItemModel.cardType) && Intrinsics.areEqual((Object) this.expiryDate, (Object) walletCreditCardGetListItemModel.expiryDate) && Intrinsics.areEqual((Object) this.expiryYear, (Object) walletCreditCardGetListItemModel.expiryYear) && Intrinsics.areEqual((Object) this.expiryMonth, (Object) walletCreditCardGetListItemModel.expiryMonth) && Intrinsics.areEqual((Object) this.holderName, (Object) walletCreditCardGetListItemModel.holderName) && Intrinsics.areEqual((Object) this.isCardValid, (Object) walletCreditCardGetListItemModel.isCardValid) && Intrinsics.areEqual((Object) this.email, (Object) walletCreditCardGetListItemModel.email) && Intrinsics.areEqual((Object) this.checkoutMessage, (Object) walletCreditCardGetListItemModel.checkoutMessage) && Intrinsics.areEqual((Object) this.binNumber, (Object) walletCreditCardGetListItemModel.binNumber) && Intrinsics.areEqual((Object) this.menuMessage, (Object) walletCreditCardGetListItemModel.menuMessage) && Intrinsics.areEqual((Object) this.isCvvForced, (Object) walletCreditCardGetListItemModel.isCvvForced) && Intrinsics.areEqual((Object) this.tokenId, (Object) walletCreditCardGetListItemModel.tokenId) && Intrinsics.areEqual((Object) this.isBinDiscountValid, (Object) walletCreditCardGetListItemModel.isBinDiscountValid) && Intrinsics.areEqual((Object) this.isCardDefault, (Object) walletCreditCardGetListItemModel.isCardDefault);
    }

    @Nullable
    public final String getBinNumber() {
        return this.binNumber;
    }

    @Nullable
    public final String getCardNumber() {
        return this.cardNumber;
    }

    @Nullable
    public final String getCardType() {
        return this.cardType;
    }

    @Nullable
    public final String getCheckoutMessage() {
        return this.checkoutMessage;
    }

    @Nullable
    public final String getEmail() {
        return this.email;
    }

    @Nullable
    public final String getExpiryDate() {
        return this.expiryDate;
    }

    @Nullable
    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    @Nullable
    public final String getExpiryYear() {
        return this.expiryYear;
    }

    @Nullable
    public final String getHolderName() {
        return this.holderName;
    }

    @Nullable
    public final String getMenuMessage() {
        return this.menuMessage;
    }

    @Nullable
    public final String getToken() {
        return this.token;
    }

    @Nullable
    public final String getTokenId() {
        return this.tokenId;
    }

    public int hashCode() {
        String str = this.token;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.cardNumber;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cardType;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.expiryDate;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.expiryYear;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.expiryMonth;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.holderName;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool = this.isCardValid;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str8 = this.email;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.checkoutMessage;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.binNumber;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.menuMessage;
        int hashCode12 = (hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Boolean bool2 = this.isCvvForced;
        int hashCode13 = (hashCode12 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str12 = this.tokenId;
        int hashCode14 = (hashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Boolean bool3 = this.isBinDiscountValid;
        int hashCode15 = (hashCode14 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.isCardDefault;
        if (bool4 != null) {
            i11 = bool4.hashCode();
        }
        return hashCode15 + i11;
    }

    @Nullable
    public final Boolean isBinDiscountValid() {
        return this.isBinDiscountValid;
    }

    @Nullable
    public final Boolean isCardDefault() {
        return this.isCardDefault;
    }

    @Nullable
    public final Boolean isCardValid() {
        return this.isCardValid;
    }

    @Nullable
    public final Boolean isCvvForced() {
        return this.isCvvForced;
    }

    public final void setBinNumber(@Nullable String str) {
        this.binNumber = str;
    }

    public final void setCardDefault(@Nullable Boolean bool) {
        this.isCardDefault = bool;
    }

    public final void setCardNumber(@Nullable String str) {
        this.cardNumber = str;
    }

    public final void setCvvForced(@Nullable Boolean bool) {
        this.isCvvForced = bool;
    }

    public final void setEmail(@Nullable String str) {
        this.email = str;
    }

    public final void setExpiryDate(@Nullable String str) {
        this.expiryDate = str;
    }

    public final void setExpiryMonth(@Nullable String str) {
        this.expiryMonth = str;
    }

    public final void setTokenId(@Nullable String str) {
        this.tokenId = str;
    }

    @NotNull
    public String toString() {
        String str = this.token;
        String str2 = this.cardNumber;
        String str3 = this.cardType;
        String str4 = this.expiryDate;
        String str5 = this.expiryYear;
        String str6 = this.expiryMonth;
        String str7 = this.holderName;
        Boolean bool = this.isCardValid;
        String str8 = this.email;
        String str9 = this.checkoutMessage;
        String str10 = this.binNumber;
        String str11 = this.menuMessage;
        Boolean bool2 = this.isCvvForced;
        String str12 = this.tokenId;
        Boolean bool3 = this.isBinDiscountValid;
        Boolean bool4 = this.isCardDefault;
        return "WalletCreditCardGetListItemModel(token=" + str + ", cardNumber=" + str2 + ", cardType=" + str3 + ", expiryDate=" + str4 + ", expiryYear=" + str5 + ", expiryMonth=" + str6 + ", holderName=" + str7 + ", isCardValid=" + bool + ", email=" + str8 + ", checkoutMessage=" + str9 + ", binNumber=" + str10 + ", menuMessage=" + str11 + ", isCvvForced=" + bool2 + ", tokenId=" + str12 + ", isBinDiscountValid=" + bool3 + ", isCardDefault=" + bool4 + ")";
    }
}
