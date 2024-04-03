package datamodels;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\bHÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006+"}, d2 = {"Ldatamodels/CardInformation;", "", "planId", "", "cardTokenId", "card4Digits", "cardType", "paymentMethod", "", "cardExpiryMonth", "cardExpiryYear", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCard4Digits", "()Ljava/lang/String;", "setCard4Digits", "(Ljava/lang/String;)V", "getCardExpiryMonth", "setCardExpiryMonth", "getCardExpiryYear", "setCardExpiryYear", "getCardTokenId", "setCardTokenId", "getCardType", "setCardType", "getPaymentMethod", "()I", "setPaymentMethod", "(I)V", "getPlanId", "setPlanId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CardInformation {
    @Nullable
    private String card4Digits;
    @Nullable
    private String cardExpiryMonth;
    @Nullable
    private String cardExpiryYear;
    @Nullable
    private String cardTokenId;
    @Nullable
    private String cardType;
    private int paymentMethod;
    @Nullable
    private String planId;

    public CardInformation() {
        this((String) null, (String) null, (String) null, (String) null, 0, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public CardInformation(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i11, @Nullable String str5, @Nullable String str6) {
        this.planId = str;
        this.cardTokenId = str2;
        this.card4Digits = str3;
        this.cardType = str4;
        this.paymentMethod = i11;
        this.cardExpiryMonth = str5;
        this.cardExpiryYear = str6;
    }

    public static /* synthetic */ CardInformation copy$default(CardInformation cardInformation, String str, String str2, String str3, String str4, int i11, String str5, String str6, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = cardInformation.planId;
        }
        if ((i12 & 2) != 0) {
            str2 = cardInformation.cardTokenId;
        }
        String str7 = str2;
        if ((i12 & 4) != 0) {
            str3 = cardInformation.card4Digits;
        }
        String str8 = str3;
        if ((i12 & 8) != 0) {
            str4 = cardInformation.cardType;
        }
        String str9 = str4;
        if ((i12 & 16) != 0) {
            i11 = cardInformation.paymentMethod;
        }
        int i13 = i11;
        if ((i12 & 32) != 0) {
            str5 = cardInformation.cardExpiryMonth;
        }
        String str10 = str5;
        if ((i12 & 64) != 0) {
            str6 = cardInformation.cardExpiryYear;
        }
        return cardInformation.copy(str, str7, str8, str9, i13, str10, str6);
    }

    @Nullable
    public final String component1() {
        return this.planId;
    }

    @Nullable
    public final String component2() {
        return this.cardTokenId;
    }

    @Nullable
    public final String component3() {
        return this.card4Digits;
    }

    @Nullable
    public final String component4() {
        return this.cardType;
    }

    public final int component5() {
        return this.paymentMethod;
    }

    @Nullable
    public final String component6() {
        return this.cardExpiryMonth;
    }

    @Nullable
    public final String component7() {
        return this.cardExpiryYear;
    }

    @NotNull
    public final CardInformation copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, int i11, @Nullable String str5, @Nullable String str6) {
        return new CardInformation(str, str2, str3, str4, i11, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardInformation)) {
            return false;
        }
        CardInformation cardInformation = (CardInformation) obj;
        return Intrinsics.areEqual((Object) this.planId, (Object) cardInformation.planId) && Intrinsics.areEqual((Object) this.cardTokenId, (Object) cardInformation.cardTokenId) && Intrinsics.areEqual((Object) this.card4Digits, (Object) cardInformation.card4Digits) && Intrinsics.areEqual((Object) this.cardType, (Object) cardInformation.cardType) && this.paymentMethod == cardInformation.paymentMethod && Intrinsics.areEqual((Object) this.cardExpiryMonth, (Object) cardInformation.cardExpiryMonth) && Intrinsics.areEqual((Object) this.cardExpiryYear, (Object) cardInformation.cardExpiryYear);
    }

    @Nullable
    public final String getCard4Digits() {
        return this.card4Digits;
    }

    @Nullable
    public final String getCardExpiryMonth() {
        return this.cardExpiryMonth;
    }

    @Nullable
    public final String getCardExpiryYear() {
        return this.cardExpiryYear;
    }

    @Nullable
    public final String getCardTokenId() {
        return this.cardTokenId;
    }

    @Nullable
    public final String getCardType() {
        return this.cardType;
    }

    public final int getPaymentMethod() {
        return this.paymentMethod;
    }

    @Nullable
    public final String getPlanId() {
        return this.planId;
    }

    public int hashCode() {
        String str = this.planId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.cardTokenId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.card4Digits;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cardType;
        int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.paymentMethod) * 31;
        String str5 = this.cardExpiryMonth;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.cardExpiryYear;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        return hashCode5 + i11;
    }

    public final void setCard4Digits(@Nullable String str) {
        this.card4Digits = str;
    }

    public final void setCardExpiryMonth(@Nullable String str) {
        this.cardExpiryMonth = str;
    }

    public final void setCardExpiryYear(@Nullable String str) {
        this.cardExpiryYear = str;
    }

    public final void setCardTokenId(@Nullable String str) {
        this.cardTokenId = str;
    }

    public final void setCardType(@Nullable String str) {
        this.cardType = str;
    }

    public final void setPaymentMethod(int i11) {
        this.paymentMethod = i11;
    }

    public final void setPlanId(@Nullable String str) {
        this.planId = str;
    }

    @NotNull
    public String toString() {
        String str = this.planId;
        String str2 = this.cardTokenId;
        String str3 = this.card4Digits;
        String str4 = this.cardType;
        int i11 = this.paymentMethod;
        String str5 = this.cardExpiryMonth;
        String str6 = this.cardExpiryYear;
        return "CardInformation(planId=" + str + ", cardTokenId=" + str2 + ", card4Digits=" + str3 + ", cardType=" + str4 + ", paymentMethod=" + i11 + ", cardExpiryMonth=" + str5 + ", cardExpiryYear=" + str6 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CardInformation(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, int r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0022
            r11 = 0
        L_0x0022:
            r4 = r11
            r7 = r14 & 32
            if (r7 == 0) goto L_0x0029
            r5 = r0
            goto L_0x002a
        L_0x0029:
            r5 = r12
        L_0x002a:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0030
            r14 = r0
            goto L_0x0031
        L_0x0030:
            r14 = r13
        L_0x0031:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: datamodels.CardInformation.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
