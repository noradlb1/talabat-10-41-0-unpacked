package com.talabat.feature.ridertips.domain.model;

import com.talabat.talabatlife.features.UrlConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/ridertips/domain/model/RiderTip;", "", "title", "", "subtitle", "tip", "Lcom/talabat/feature/ridertips/domain/model/Tip;", "terms", "Lcom/talabat/feature/ridertips/domain/model/Terms;", "(Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/ridertips/domain/model/Tip;Lcom/talabat/feature/ridertips/domain/model/Terms;)V", "getSubtitle", "()Ljava/lang/String;", "getTerms", "()Lcom/talabat/feature/ridertips/domain/model/Terms;", "getTip", "()Lcom/talabat/feature/ridertips/domain/model/Tip;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_ridertips_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTip {
    @Nullable
    private final String subtitle;
    @NotNull
    private final Terms terms;
    @NotNull
    private final Tip tip;
    @Nullable
    private final String title;

    public RiderTip(@Nullable String str, @Nullable String str2, @NotNull Tip tip2, @NotNull Terms terms2) {
        Intrinsics.checkNotNullParameter(tip2, "tip");
        Intrinsics.checkNotNullParameter(terms2, UrlConstantsKt.TLIFE_TERMS_AND_CONDITION_PATH);
        this.title = str;
        this.subtitle = str2;
        this.tip = tip2;
        this.terms = terms2;
    }

    public static /* synthetic */ RiderTip copy$default(RiderTip riderTip, String str, String str2, Tip tip2, Terms terms2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = riderTip.title;
        }
        if ((i11 & 2) != 0) {
            str2 = riderTip.subtitle;
        }
        if ((i11 & 4) != 0) {
            tip2 = riderTip.tip;
        }
        if ((i11 & 8) != 0) {
            terms2 = riderTip.terms;
        }
        return riderTip.copy(str, str2, tip2, terms2);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.subtitle;
    }

    @NotNull
    public final Tip component3() {
        return this.tip;
    }

    @NotNull
    public final Terms component4() {
        return this.terms;
    }

    @NotNull
    public final RiderTip copy(@Nullable String str, @Nullable String str2, @NotNull Tip tip2, @NotNull Terms terms2) {
        Intrinsics.checkNotNullParameter(tip2, "tip");
        Intrinsics.checkNotNullParameter(terms2, UrlConstantsKt.TLIFE_TERMS_AND_CONDITION_PATH);
        return new RiderTip(str, str2, tip2, terms2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RiderTip)) {
            return false;
        }
        RiderTip riderTip = (RiderTip) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) riderTip.title) && Intrinsics.areEqual((Object) this.subtitle, (Object) riderTip.subtitle) && Intrinsics.areEqual((Object) this.tip, (Object) riderTip.tip) && Intrinsics.areEqual((Object) this.terms, (Object) riderTip.terms);
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final Terms getTerms() {
        return this.terms;
    }

    @NotNull
    public final Tip getTip() {
        return this.tip;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subtitle;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return ((((hashCode + i11) * 31) + this.tip.hashCode()) * 31) + this.terms.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.subtitle;
        Tip tip2 = this.tip;
        Terms terms2 = this.terms;
        return "RiderTip(title=" + str + ", subtitle=" + str2 + ", tip=" + tip2 + ", terms=" + terms2 + ")";
    }
}
