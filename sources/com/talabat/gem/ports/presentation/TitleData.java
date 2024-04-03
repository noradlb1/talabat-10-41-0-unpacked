package com.talabat.gem.ports.presentation;

import com.talabat.feature.subscriptions.data.tracking.events.TProEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006!"}, d2 = {"Lcom/talabat/gem/ports/presentation/TitleData;", "", "name", "", "savingsAmount", "currency", "discount", "brandingMessage", "collectionTitle", "collectionSubtitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrandingMessage", "()Ljava/lang/String;", "getCollectionSubtitle", "getCollectionTitle", "getCurrency", "getDiscount", "getName", "getSavingsAmount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TitleData {
    @Nullable
    private final String brandingMessage;
    @Nullable
    private final String collectionSubtitle;
    @Nullable
    private final String collectionTitle;
    @NotNull
    private final String currency;
    @Nullable
    private final String discount;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f60480name;
    @NotNull
    private final String savingsAmount;

    public TitleData(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, TProEvent.ATTR_SAVINGS_AMOUNT);
        Intrinsics.checkNotNullParameter(str3, "currency");
        this.f60480name = str;
        this.savingsAmount = str2;
        this.currency = str3;
        this.discount = str4;
        this.brandingMessage = str5;
        this.collectionTitle = str6;
        this.collectionSubtitle = str7;
    }

    public static /* synthetic */ TitleData copy$default(TitleData titleData, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = titleData.f60480name;
        }
        if ((i11 & 2) != 0) {
            str2 = titleData.savingsAmount;
        }
        String str8 = str2;
        if ((i11 & 4) != 0) {
            str3 = titleData.currency;
        }
        String str9 = str3;
        if ((i11 & 8) != 0) {
            str4 = titleData.discount;
        }
        String str10 = str4;
        if ((i11 & 16) != 0) {
            str5 = titleData.brandingMessage;
        }
        String str11 = str5;
        if ((i11 & 32) != 0) {
            str6 = titleData.collectionTitle;
        }
        String str12 = str6;
        if ((i11 & 64) != 0) {
            str7 = titleData.collectionSubtitle;
        }
        return titleData.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @NotNull
    public final String component1() {
        return this.f60480name;
    }

    @NotNull
    public final String component2() {
        return this.savingsAmount;
    }

    @NotNull
    public final String component3() {
        return this.currency;
    }

    @Nullable
    public final String component4() {
        return this.discount;
    }

    @Nullable
    public final String component5() {
        return this.brandingMessage;
    }

    @Nullable
    public final String component6() {
        return this.collectionTitle;
    }

    @Nullable
    public final String component7() {
        return this.collectionSubtitle;
    }

    @NotNull
    public final TitleData copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, TProEvent.ATTR_SAVINGS_AMOUNT);
        Intrinsics.checkNotNullParameter(str3, "currency");
        return new TitleData(str, str2, str3, str4, str5, str6, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TitleData)) {
            return false;
        }
        TitleData titleData = (TitleData) obj;
        return Intrinsics.areEqual((Object) this.f60480name, (Object) titleData.f60480name) && Intrinsics.areEqual((Object) this.savingsAmount, (Object) titleData.savingsAmount) && Intrinsics.areEqual((Object) this.currency, (Object) titleData.currency) && Intrinsics.areEqual((Object) this.discount, (Object) titleData.discount) && Intrinsics.areEqual((Object) this.brandingMessage, (Object) titleData.brandingMessage) && Intrinsics.areEqual((Object) this.collectionTitle, (Object) titleData.collectionTitle) && Intrinsics.areEqual((Object) this.collectionSubtitle, (Object) titleData.collectionSubtitle);
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

    @Nullable
    public final String getDiscount() {
        return this.discount;
    }

    @NotNull
    public final String getName() {
        return this.f60480name;
    }

    @NotNull
    public final String getSavingsAmount() {
        return this.savingsAmount;
    }

    public int hashCode() {
        int hashCode = ((((this.f60480name.hashCode() * 31) + this.savingsAmount.hashCode()) * 31) + this.currency.hashCode()) * 31;
        String str = this.discount;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.brandingMessage;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.collectionTitle;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.collectionSubtitle;
        if (str4 != null) {
            i11 = str4.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f60480name;
        String str2 = this.savingsAmount;
        String str3 = this.currency;
        String str4 = this.discount;
        String str5 = this.brandingMessage;
        String str6 = this.collectionTitle;
        String str7 = this.collectionSubtitle;
        return "TitleData(name=" + str + ", savingsAmount=" + str2 + ", currency=" + str3 + ", discount=" + str4 + ", brandingMessage=" + str5 + ", collectionTitle=" + str6 + ", collectionSubtitle=" + str7 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TitleData(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? null : str7);
    }
}
