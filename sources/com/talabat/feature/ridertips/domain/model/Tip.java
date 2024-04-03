package com.talabat.feature.ridertips.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000bJD\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\b\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/ridertips/domain/model/Tip;", "", "threshold", "", "preferred", "tipChoices", "", "Lcom/talabat/feature/ridertips/domain/model/TipChoices;", "isDefaultTipEnabled", "", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPreferred", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getThreshold", "getTipChoices", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/util/List;Ljava/lang/Boolean;)Lcom/talabat/feature/ridertips/domain/model/Tip;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_feature_ridertips_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Tip {
    @Nullable
    private final Boolean isDefaultTipEnabled;
    @Nullable
    private final Double preferred;
    @Nullable
    private final Double threshold;
    @Nullable
    private final List<TipChoices> tipChoices;

    public Tip(@Nullable Double d11, @Nullable Double d12, @Nullable List<TipChoices> list, @Nullable Boolean bool) {
        this.threshold = d11;
        this.preferred = d12;
        this.tipChoices = list;
        this.isDefaultTipEnabled = bool;
    }

    public static /* synthetic */ Tip copy$default(Tip tip, Double d11, Double d12, List<TipChoices> list, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d11 = tip.threshold;
        }
        if ((i11 & 2) != 0) {
            d12 = tip.preferred;
        }
        if ((i11 & 4) != 0) {
            list = tip.tipChoices;
        }
        if ((i11 & 8) != 0) {
            bool = tip.isDefaultTipEnabled;
        }
        return tip.copy(d11, d12, list, bool);
    }

    @Nullable
    public final Double component1() {
        return this.threshold;
    }

    @Nullable
    public final Double component2() {
        return this.preferred;
    }

    @Nullable
    public final List<TipChoices> component3() {
        return this.tipChoices;
    }

    @Nullable
    public final Boolean component4() {
        return this.isDefaultTipEnabled;
    }

    @NotNull
    public final Tip copy(@Nullable Double d11, @Nullable Double d12, @Nullable List<TipChoices> list, @Nullable Boolean bool) {
        return new Tip(d11, d12, list, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tip)) {
            return false;
        }
        Tip tip = (Tip) obj;
        return Intrinsics.areEqual((Object) this.threshold, (Object) tip.threshold) && Intrinsics.areEqual((Object) this.preferred, (Object) tip.preferred) && Intrinsics.areEqual((Object) this.tipChoices, (Object) tip.tipChoices) && Intrinsics.areEqual((Object) this.isDefaultTipEnabled, (Object) tip.isDefaultTipEnabled);
    }

    @Nullable
    public final Double getPreferred() {
        return this.preferred;
    }

    @Nullable
    public final Double getThreshold() {
        return this.threshold;
    }

    @Nullable
    public final List<TipChoices> getTipChoices() {
        return this.tipChoices;
    }

    public int hashCode() {
        Double d11 = this.threshold;
        int i11 = 0;
        int hashCode = (d11 == null ? 0 : d11.hashCode()) * 31;
        Double d12 = this.preferred;
        int hashCode2 = (hashCode + (d12 == null ? 0 : d12.hashCode())) * 31;
        List<TipChoices> list = this.tipChoices;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.isDefaultTipEnabled;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode3 + i11;
    }

    @Nullable
    public final Boolean isDefaultTipEnabled() {
        return this.isDefaultTipEnabled;
    }

    @NotNull
    public String toString() {
        Double d11 = this.threshold;
        Double d12 = this.preferred;
        List<TipChoices> list = this.tipChoices;
        Boolean bool = this.isDefaultTipEnabled;
        return "Tip(threshold=" + d11 + ", preferred=" + d12 + ", tipChoices=" + list + ", isDefaultTipEnabled=" + bool + ")";
    }
}
