package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProDefaultConfig;", "", "proPlanId", "", "verticalPromotion", "(Ljava/lang/String;Ljava/lang/String;)V", "getProPlanId", "()Ljava/lang/String;", "getVerticalPromotion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProDefaultConfig {
    @Nullable
    private final String proPlanId;
    @Nullable
    private final String verticalPromotion;

    public TProDefaultConfig() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public TProDefaultConfig(@Nullable String str, @Nullable String str2) {
        this.proPlanId = str;
        this.verticalPromotion = str2;
    }

    public static /* synthetic */ TProDefaultConfig copy$default(TProDefaultConfig tProDefaultConfig, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tProDefaultConfig.proPlanId;
        }
        if ((i11 & 2) != 0) {
            str2 = tProDefaultConfig.verticalPromotion;
        }
        return tProDefaultConfig.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.proPlanId;
    }

    @Nullable
    public final String component2() {
        return this.verticalPromotion;
    }

    @NotNull
    public final TProDefaultConfig copy(@Nullable String str, @Nullable String str2) {
        return new TProDefaultConfig(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProDefaultConfig)) {
            return false;
        }
        TProDefaultConfig tProDefaultConfig = (TProDefaultConfig) obj;
        return Intrinsics.areEqual((Object) this.proPlanId, (Object) tProDefaultConfig.proPlanId) && Intrinsics.areEqual((Object) this.verticalPromotion, (Object) tProDefaultConfig.verticalPromotion);
    }

    @Nullable
    public final String getProPlanId() {
        return this.proPlanId;
    }

    @Nullable
    public final String getVerticalPromotion() {
        return this.verticalPromotion;
    }

    public int hashCode() {
        String str = this.proPlanId;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.verticalPromotion;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.proPlanId;
        String str2 = this.verticalPromotion;
        return "TProDefaultConfig(proPlanId=" + str + ", verticalPromotion=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TProDefaultConfig(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2);
    }
}
