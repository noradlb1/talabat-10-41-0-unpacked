package com.checkout.tokenization.model;

import com.talabat.card_tokenization.CardTokenizationPlugin;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003JM\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/checkout/tokenization/model/Card;", "", "expiryDate", "Lcom/checkout/tokenization/model/ExpiryDate;", "name", "", "number", "cvv", "billingAddress", "Lcom/checkout/tokenization/model/Address;", "phone", "Lcom/checkout/tokenization/model/Phone;", "(Lcom/checkout/tokenization/model/ExpiryDate;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/checkout/tokenization/model/Address;Lcom/checkout/tokenization/model/Phone;)V", "getBillingAddress", "()Lcom/checkout/tokenization/model/Address;", "getCvv", "()Ljava/lang/String;", "getExpiryDate", "()Lcom/checkout/tokenization/model/ExpiryDate;", "getName", "getNumber", "getPhone", "()Lcom/checkout/tokenization/model/Phone;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "checkout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Card {
    @Nullable
    private final Address billingAddress;
    @Nullable
    private final String cvv;
    @NotNull
    private final ExpiryDate expiryDate;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f29377name;
    @NotNull
    private final String number;
    @Nullable
    private final Phone phone;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Card(@NotNull ExpiryDate expiryDate2, @NotNull String str) {
        this(expiryDate2, (String) null, str, (String) null, (Address) null, (Phone) null, 58, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(expiryDate2, "expiryDate");
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_NUMBER_KEY);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Card(@NotNull ExpiryDate expiryDate2, @Nullable String str, @NotNull String str2) {
        this(expiryDate2, str, str2, (String) null, (Address) null, (Phone) null, 56, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(expiryDate2, "expiryDate");
        Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_NUMBER_KEY);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Card(@NotNull ExpiryDate expiryDate2, @Nullable String str, @NotNull String str2, @Nullable String str3) {
        this(expiryDate2, str, str2, str3, (Address) null, (Phone) null, 48, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(expiryDate2, "expiryDate");
        Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_NUMBER_KEY);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public Card(@NotNull ExpiryDate expiryDate2, @Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable Address address) {
        this(expiryDate2, str, str2, str3, address, (Phone) null, 32, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(expiryDate2, "expiryDate");
        Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_NUMBER_KEY);
    }

    @JvmOverloads
    public Card(@NotNull ExpiryDate expiryDate2, @Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable Address address, @Nullable Phone phone2) {
        Intrinsics.checkNotNullParameter(expiryDate2, "expiryDate");
        Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_NUMBER_KEY);
        this.expiryDate = expiryDate2;
        this.f29377name = str;
        this.number = str2;
        this.cvv = str3;
        this.billingAddress = address;
        this.phone = phone2;
    }

    public static /* synthetic */ Card copy$default(Card card, ExpiryDate expiryDate2, String str, String str2, String str3, Address address, Phone phone2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            expiryDate2 = card.expiryDate;
        }
        if ((i11 & 2) != 0) {
            str = card.f29377name;
        }
        String str4 = str;
        if ((i11 & 4) != 0) {
            str2 = card.number;
        }
        String str5 = str2;
        if ((i11 & 8) != 0) {
            str3 = card.cvv;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            address = card.billingAddress;
        }
        Address address2 = address;
        if ((i11 & 32) != 0) {
            phone2 = card.phone;
        }
        return card.copy(expiryDate2, str4, str5, str6, address2, phone2);
    }

    @NotNull
    public final ExpiryDate component1() {
        return this.expiryDate;
    }

    @Nullable
    public final String component2() {
        return this.f29377name;
    }

    @NotNull
    public final String component3() {
        return this.number;
    }

    @Nullable
    public final String component4() {
        return this.cvv;
    }

    @Nullable
    public final Address component5() {
        return this.billingAddress;
    }

    @Nullable
    public final Phone component6() {
        return this.phone;
    }

    @NotNull
    public final Card copy(@NotNull ExpiryDate expiryDate2, @Nullable String str, @NotNull String str2, @Nullable String str3, @Nullable Address address, @Nullable Phone phone2) {
        Intrinsics.checkNotNullParameter(expiryDate2, "expiryDate");
        Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_NUMBER_KEY);
        return new Card(expiryDate2, str, str2, str3, address, phone2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        Card card = (Card) obj;
        return Intrinsics.areEqual((Object) this.expiryDate, (Object) card.expiryDate) && Intrinsics.areEqual((Object) this.f29377name, (Object) card.f29377name) && Intrinsics.areEqual((Object) this.number, (Object) card.number) && Intrinsics.areEqual((Object) this.cvv, (Object) card.cvv) && Intrinsics.areEqual((Object) this.billingAddress, (Object) card.billingAddress) && Intrinsics.areEqual((Object) this.phone, (Object) card.phone);
    }

    @Nullable
    public final Address getBillingAddress() {
        return this.billingAddress;
    }

    @Nullable
    public final String getCvv() {
        return this.cvv;
    }

    @NotNull
    public final ExpiryDate getExpiryDate() {
        return this.expiryDate;
    }

    @Nullable
    public final String getName() {
        return this.f29377name;
    }

    @NotNull
    public final String getNumber() {
        return this.number;
    }

    @Nullable
    public final Phone getPhone() {
        return this.phone;
    }

    public int hashCode() {
        int hashCode = this.expiryDate.hashCode() * 31;
        String str = this.f29377name;
        int i11 = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.number.hashCode()) * 31;
        String str2 = this.cvv;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Address address = this.billingAddress;
        int hashCode4 = (hashCode3 + (address == null ? 0 : address.hashCode())) * 31;
        Phone phone2 = this.phone;
        if (phone2 != null) {
            i11 = phone2.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        ExpiryDate expiryDate2 = this.expiryDate;
        String str = this.f29377name;
        String str2 = this.number;
        String str3 = this.cvv;
        Address address = this.billingAddress;
        Phone phone2 = this.phone;
        return "Card(expiryDate=" + expiryDate2 + ", name=" + str + ", number=" + str2 + ", cvv=" + str3 + ", billingAddress=" + address + ", phone=" + phone2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Card(ExpiryDate expiryDate2, String str, String str2, String str3, Address address, Phone phone2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(expiryDate2, (i11 & 2) != 0 ? null : str, str2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : address, (i11 & 32) != 0 ? null : phone2);
    }
}
