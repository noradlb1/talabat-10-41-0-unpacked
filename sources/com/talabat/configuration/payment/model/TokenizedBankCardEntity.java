package com.talabat.configuration.payment.model;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b'\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010+\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0001\u0010,\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0007HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\n\u0010\u001bR\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\f\u0010\u001bR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\r\u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00062"}, d2 = {"Lcom/talabat/configuration/payment/model/TokenizedBankCardEntity;", "", "binMessage", "", "binNumber", "expiryDate", "expiryMonth", "", "expiryYear", "holderName", "isBinDiscountValid", "", "isForceCvv", "isValid", "number", "token", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBinMessage", "()Ljava/lang/String;", "getBinNumber", "getExpiryDate", "getExpiryMonth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExpiryYear", "getHolderName", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getNumber", "getToken", "getType", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/configuration/payment/model/TokenizedBankCardEntity;", "equals", "other", "hashCode", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenizedBankCardEntity {
    @SerializedName("message")
    @Nullable
    private final String binMessage;
    @SerializedName("binNumber")
    @Nullable
    private final String binNumber;
    @SerializedName("expiredate")
    @Nullable
    private final String expiryDate;
    @SerializedName("expiremonth")
    @Nullable
    private final Integer expiryMonth;
    @SerializedName("expireyear")
    @Nullable
    private final Integer expiryYear;
    @SerializedName("holdername")
    @Nullable
    private final String holderName;
    @SerializedName("isBinDiscountValid")
    @Nullable
    private final Boolean isBinDiscountValid;
    @SerializedName("isForceCvv")
    @Nullable
    private final Boolean isForceCvv;
    @SerializedName("isValidCard")
    @Nullable
    private final Boolean isValid;
    @SerializedName("cardnumber")
    @Nullable
    private final String number;
    @SerializedName("token")
    @Nullable
    private final String token;
    @SerializedName("cardtype")
    @Nullable
    private final String type;

    public TokenizedBankCardEntity() {
        this((String) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, UnixStat.PERM_MASK, (DefaultConstructorMarker) null);
    }

    public TokenizedBankCardEntity(@Nullable @Json(name = "message") String str, @Nullable @Json(name = "binNumber") String str2, @Nullable @Json(name = "expiredate") String str3, @Nullable @Json(name = "expiremonth") Integer num, @Nullable @Json(name = "expireyear") Integer num2, @Nullable @Json(name = "holdername") String str4, @Nullable @Json(name = "isBinDiscountValid") Boolean bool, @Nullable @Json(name = "isForceCvv") Boolean bool2, @Nullable @Json(name = "isValidCard") Boolean bool3, @Nullable @Json(name = "cardnumber") String str5, @Nullable @Json(name = "token") String str6, @Nullable @Json(name = "cardtype") String str7) {
        this.binMessage = str;
        this.binNumber = str2;
        this.expiryDate = str3;
        this.expiryMonth = num;
        this.expiryYear = num2;
        this.holderName = str4;
        this.isBinDiscountValid = bool;
        this.isForceCvv = bool2;
        this.isValid = bool3;
        this.number = str5;
        this.token = str6;
        this.type = str7;
    }

    public static /* synthetic */ TokenizedBankCardEntity copy$default(TokenizedBankCardEntity tokenizedBankCardEntity, String str, String str2, String str3, Integer num, Integer num2, String str4, Boolean bool, Boolean bool2, Boolean bool3, String str5, String str6, String str7, int i11, Object obj) {
        TokenizedBankCardEntity tokenizedBankCardEntity2 = tokenizedBankCardEntity;
        int i12 = i11;
        return tokenizedBankCardEntity.copy((i12 & 1) != 0 ? tokenizedBankCardEntity2.binMessage : str, (i12 & 2) != 0 ? tokenizedBankCardEntity2.binNumber : str2, (i12 & 4) != 0 ? tokenizedBankCardEntity2.expiryDate : str3, (i12 & 8) != 0 ? tokenizedBankCardEntity2.expiryMonth : num, (i12 & 16) != 0 ? tokenizedBankCardEntity2.expiryYear : num2, (i12 & 32) != 0 ? tokenizedBankCardEntity2.holderName : str4, (i12 & 64) != 0 ? tokenizedBankCardEntity2.isBinDiscountValid : bool, (i12 & 128) != 0 ? tokenizedBankCardEntity2.isForceCvv : bool2, (i12 & 256) != 0 ? tokenizedBankCardEntity2.isValid : bool3, (i12 & 512) != 0 ? tokenizedBankCardEntity2.number : str5, (i12 & 1024) != 0 ? tokenizedBankCardEntity2.token : str6, (i12 & 2048) != 0 ? tokenizedBankCardEntity2.type : str7);
    }

    @Nullable
    public final String component1() {
        return this.binMessage;
    }

    @Nullable
    public final String component10() {
        return this.number;
    }

    @Nullable
    public final String component11() {
        return this.token;
    }

    @Nullable
    public final String component12() {
        return this.type;
    }

    @Nullable
    public final String component2() {
        return this.binNumber;
    }

    @Nullable
    public final String component3() {
        return this.expiryDate;
    }

    @Nullable
    public final Integer component4() {
        return this.expiryMonth;
    }

    @Nullable
    public final Integer component5() {
        return this.expiryYear;
    }

    @Nullable
    public final String component6() {
        return this.holderName;
    }

    @Nullable
    public final Boolean component7() {
        return this.isBinDiscountValid;
    }

    @Nullable
    public final Boolean component8() {
        return this.isForceCvv;
    }

    @Nullable
    public final Boolean component9() {
        return this.isValid;
    }

    @NotNull
    public final TokenizedBankCardEntity copy(@Nullable @Json(name = "message") String str, @Nullable @Json(name = "binNumber") String str2, @Nullable @Json(name = "expiredate") String str3, @Nullable @Json(name = "expiremonth") Integer num, @Nullable @Json(name = "expireyear") Integer num2, @Nullable @Json(name = "holdername") String str4, @Nullable @Json(name = "isBinDiscountValid") Boolean bool, @Nullable @Json(name = "isForceCvv") Boolean bool2, @Nullable @Json(name = "isValidCard") Boolean bool3, @Nullable @Json(name = "cardnumber") String str5, @Nullable @Json(name = "token") String str6, @Nullable @Json(name = "cardtype") String str7) {
        return new TokenizedBankCardEntity(str, str2, str3, num, num2, str4, bool, bool2, bool3, str5, str6, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenizedBankCardEntity)) {
            return false;
        }
        TokenizedBankCardEntity tokenizedBankCardEntity = (TokenizedBankCardEntity) obj;
        return Intrinsics.areEqual((Object) this.binMessage, (Object) tokenizedBankCardEntity.binMessage) && Intrinsics.areEqual((Object) this.binNumber, (Object) tokenizedBankCardEntity.binNumber) && Intrinsics.areEqual((Object) this.expiryDate, (Object) tokenizedBankCardEntity.expiryDate) && Intrinsics.areEqual((Object) this.expiryMonth, (Object) tokenizedBankCardEntity.expiryMonth) && Intrinsics.areEqual((Object) this.expiryYear, (Object) tokenizedBankCardEntity.expiryYear) && Intrinsics.areEqual((Object) this.holderName, (Object) tokenizedBankCardEntity.holderName) && Intrinsics.areEqual((Object) this.isBinDiscountValid, (Object) tokenizedBankCardEntity.isBinDiscountValid) && Intrinsics.areEqual((Object) this.isForceCvv, (Object) tokenizedBankCardEntity.isForceCvv) && Intrinsics.areEqual((Object) this.isValid, (Object) tokenizedBankCardEntity.isValid) && Intrinsics.areEqual((Object) this.number, (Object) tokenizedBankCardEntity.number) && Intrinsics.areEqual((Object) this.token, (Object) tokenizedBankCardEntity.token) && Intrinsics.areEqual((Object) this.type, (Object) tokenizedBankCardEntity.type);
    }

    @Nullable
    public final String getBinMessage() {
        return this.binMessage;
    }

    @Nullable
    public final String getBinNumber() {
        return this.binNumber;
    }

    @Nullable
    public final String getExpiryDate() {
        return this.expiryDate;
    }

    @Nullable
    public final Integer getExpiryMonth() {
        return this.expiryMonth;
    }

    @Nullable
    public final Integer getExpiryYear() {
        return this.expiryYear;
    }

    @Nullable
    public final String getHolderName() {
        return this.holderName;
    }

    @Nullable
    public final String getNumber() {
        return this.number;
    }

    @Nullable
    public final String getToken() {
        return this.token;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.binMessage;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.binNumber;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.expiryDate;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.expiryMonth;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.expiryYear;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.holderName;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.isBinDiscountValid;
        int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isForceCvv;
        int hashCode8 = (hashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isValid;
        int hashCode9 = (hashCode8 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str5 = this.number;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.token;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.type;
        if (str7 != null) {
            i11 = str7.hashCode();
        }
        return hashCode11 + i11;
    }

    @Nullable
    public final Boolean isBinDiscountValid() {
        return this.isBinDiscountValid;
    }

    @Nullable
    public final Boolean isForceCvv() {
        return this.isForceCvv;
    }

    @Nullable
    public final Boolean isValid() {
        return this.isValid;
    }

    @NotNull
    public String toString() {
        String str = this.binMessage;
        String str2 = this.binNumber;
        String str3 = this.expiryDate;
        Integer num = this.expiryMonth;
        Integer num2 = this.expiryYear;
        String str4 = this.holderName;
        Boolean bool = this.isBinDiscountValid;
        Boolean bool2 = this.isForceCvv;
        Boolean bool3 = this.isValid;
        String str5 = this.number;
        String str6 = this.token;
        String str7 = this.type;
        return "TokenizedBankCardEntity(binMessage=" + str + ", binNumber=" + str2 + ", expiryDate=" + str3 + ", expiryMonth=" + num + ", expiryYear=" + num2 + ", holderName=" + str4 + ", isBinDiscountValid=" + bool + ", isForceCvv=" + bool2 + ", isValid=" + bool3 + ", number=" + str5 + ", token=" + str6 + ", type=" + str7 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TokenizedBankCardEntity(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Integer r17, java.lang.Integer r18, java.lang.String r19, java.lang.Boolean r20, java.lang.Boolean r21, java.lang.Boolean r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r15
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0019
        L_0x0017:
            r4 = r16
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0021
        L_0x001f:
            r5 = r17
        L_0x0021:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0027
            r6 = r2
            goto L_0x0029
        L_0x0027:
            r6 = r18
        L_0x0029:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002f
            r7 = r2
            goto L_0x0031
        L_0x002f:
            r7 = r19
        L_0x0031:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0037
            r8 = r2
            goto L_0x0039
        L_0x0037:
            r8 = r20
        L_0x0039:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003f
            r9 = r2
            goto L_0x0041
        L_0x003f:
            r9 = r21
        L_0x0041:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0047
            r10 = r2
            goto L_0x0049
        L_0x0047:
            r10 = r22
        L_0x0049:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004f
            r11 = r2
            goto L_0x0051
        L_0x004f:
            r11 = r23
        L_0x0051:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0057
            r12 = r2
            goto L_0x0059
        L_0x0057:
            r12 = r24
        L_0x0059:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r2 = r25
        L_0x0060:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.payment.model.TokenizedBankCardEntity.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
