package com.talabat.feature.ridertips.data.remote.dto;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/ridertips/data/remote/dto/TipChoices;", "", "amount", "", "emoji", "", "(DLjava/lang/String;)V", "getAmount", "()D", "getEmoji", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_ridertips_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TipChoices {
    private final double amount;
    @Nullable
    private final String emoji;

    public TipChoices(@Json(name = "amount") double d11, @Nullable @Json(name = "emoji") String str) {
        this.amount = d11;
        this.emoji = str;
    }

    public static /* synthetic */ TipChoices copy$default(TipChoices tipChoices, double d11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d11 = tipChoices.amount;
        }
        if ((i11 & 2) != 0) {
            str = tipChoices.emoji;
        }
        return tipChoices.copy(d11, str);
    }

    public final double component1() {
        return this.amount;
    }

    @Nullable
    public final String component2() {
        return this.emoji;
    }

    @NotNull
    public final TipChoices copy(@Json(name = "amount") double d11, @Nullable @Json(name = "emoji") String str) {
        return new TipChoices(d11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TipChoices)) {
            return false;
        }
        TipChoices tipChoices = (TipChoices) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this.amount), (Object) Double.valueOf(tipChoices.amount)) && Intrinsics.areEqual((Object) this.emoji, (Object) tipChoices.emoji);
    }

    public final double getAmount() {
        return this.amount;
    }

    @Nullable
    public final String getEmoji() {
        return this.emoji;
    }

    public int hashCode() {
        int a11 = Double.doubleToLongBits(this.amount) * 31;
        String str = this.emoji;
        return a11 + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        double d11 = this.amount;
        String str = this.emoji;
        return "TipChoices(amount=" + d11 + ", emoji=" + str + ")";
    }
}
