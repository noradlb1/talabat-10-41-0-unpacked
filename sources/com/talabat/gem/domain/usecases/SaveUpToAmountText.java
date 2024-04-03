package com.talabat.gem.domain.usecases;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JK\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/talabat/gem/domain/usecases/SaveUpToAmountText;", "", "saveAmount", "", "currency", "discount", "brandingMessage", "collectionTitle", "collectionSubtitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrandingMessage", "()Ljava/lang/String;", "getCollectionSubtitle", "getCollectionTitle", "getCurrency", "getDiscount", "getSaveAmount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SaveUpToAmountText {
    @Nullable
    private final String brandingMessage;
    @Nullable
    private final String collectionSubtitle;
    @Nullable
    private final String collectionTitle;
    @NotNull
    private final String currency;
    @NotNull
    private final String discount;
    @NotNull
    private final String saveAmount;

    public SaveUpToAmountText(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        Intrinsics.checkNotNullParameter(str, "saveAmount");
        Intrinsics.checkNotNullParameter(str2, "currency");
        Intrinsics.checkNotNullParameter(str3, "discount");
        this.saveAmount = str;
        this.currency = str2;
        this.discount = str3;
        this.brandingMessage = str4;
        this.collectionTitle = str5;
        this.collectionSubtitle = str6;
    }

    public static /* synthetic */ SaveUpToAmountText copy$default(SaveUpToAmountText saveUpToAmountText, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = saveUpToAmountText.saveAmount;
        }
        if ((i11 & 2) != 0) {
            str2 = saveUpToAmountText.currency;
        }
        String str7 = str2;
        if ((i11 & 4) != 0) {
            str3 = saveUpToAmountText.discount;
        }
        String str8 = str3;
        if ((i11 & 8) != 0) {
            str4 = saveUpToAmountText.brandingMessage;
        }
        String str9 = str4;
        if ((i11 & 16) != 0) {
            str5 = saveUpToAmountText.collectionTitle;
        }
        String str10 = str5;
        if ((i11 & 32) != 0) {
            str6 = saveUpToAmountText.collectionSubtitle;
        }
        return saveUpToAmountText.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.saveAmount;
    }

    @NotNull
    public final String component2() {
        return this.currency;
    }

    @NotNull
    public final String component3() {
        return this.discount;
    }

    @Nullable
    public final String component4() {
        return this.brandingMessage;
    }

    @Nullable
    public final String component5() {
        return this.collectionTitle;
    }

    @Nullable
    public final String component6() {
        return this.collectionSubtitle;
    }

    @NotNull
    public final SaveUpToAmountText copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        Intrinsics.checkNotNullParameter(str, "saveAmount");
        Intrinsics.checkNotNullParameter(str2, "currency");
        Intrinsics.checkNotNullParameter(str3, "discount");
        return new SaveUpToAmountText(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SaveUpToAmountText)) {
            return false;
        }
        SaveUpToAmountText saveUpToAmountText = (SaveUpToAmountText) obj;
        return Intrinsics.areEqual((Object) this.saveAmount, (Object) saveUpToAmountText.saveAmount) && Intrinsics.areEqual((Object) this.currency, (Object) saveUpToAmountText.currency) && Intrinsics.areEqual((Object) this.discount, (Object) saveUpToAmountText.discount) && Intrinsics.areEqual((Object) this.brandingMessage, (Object) saveUpToAmountText.brandingMessage) && Intrinsics.areEqual((Object) this.collectionTitle, (Object) saveUpToAmountText.collectionTitle) && Intrinsics.areEqual((Object) this.collectionSubtitle, (Object) saveUpToAmountText.collectionSubtitle);
    }

    @Nullable
    public final String getBrandingMessage() {
        return this.brandingMessage;
    }

    @Nullable
    public final String getCollectionSubtitle() {
        return this.collectionSubtitle;
    }

    @Nullable
    public final String getCollectionTitle() {
        return this.collectionTitle;
    }

    @NotNull
    public final String getCurrency() {
        return this.currency;
    }

    @NotNull
    public final String getDiscount() {
        return this.discount;
    }

    @NotNull
    public final String getSaveAmount() {
        return this.saveAmount;
    }

    public int hashCode() {
        int hashCode = ((((this.saveAmount.hashCode() * 31) + this.currency.hashCode()) * 31) + this.discount.hashCode()) * 31;
        String str = this.brandingMessage;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.collectionTitle;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.collectionSubtitle;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.saveAmount;
        String str2 = this.currency;
        String str3 = this.discount;
        String str4 = this.brandingMessage;
        String str5 = this.collectionTitle;
        String str6 = this.collectionSubtitle;
        return "SaveUpToAmountText(saveAmount=" + str + ", currency=" + str2 + ", discount=" + str3 + ", brandingMessage=" + str4 + ", collectionTitle=" + str5 + ", collectionSubtitle=" + str6 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SaveUpToAmountText(String str, String str2, String str3, String str4, String str5, String str6, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6);
    }
}
