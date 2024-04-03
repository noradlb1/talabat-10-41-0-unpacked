package com.talabat.feature.tmart.growth.domain.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthLoaderData;", "", "basicImageUrl", "", "finalImageUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getBasicImageUrl", "()Ljava/lang/String;", "getFinalImageUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TMartGrowthLoaderData {
    @Nullable
    private final String basicImageUrl;
    @Nullable
    private final String finalImageUrl;

    public TMartGrowthLoaderData(@Nullable String str, @Nullable String str2) {
        this.basicImageUrl = str;
        this.finalImageUrl = str2;
    }

    public static /* synthetic */ TMartGrowthLoaderData copy$default(TMartGrowthLoaderData tMartGrowthLoaderData, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tMartGrowthLoaderData.basicImageUrl;
        }
        if ((i11 & 2) != 0) {
            str2 = tMartGrowthLoaderData.finalImageUrl;
        }
        return tMartGrowthLoaderData.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.basicImageUrl;
    }

    @Nullable
    public final String component2() {
        return this.finalImageUrl;
    }

    @NotNull
    public final TMartGrowthLoaderData copy(@Nullable String str, @Nullable String str2) {
        return new TMartGrowthLoaderData(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TMartGrowthLoaderData)) {
            return false;
        }
        TMartGrowthLoaderData tMartGrowthLoaderData = (TMartGrowthLoaderData) obj;
        return Intrinsics.areEqual((Object) this.basicImageUrl, (Object) tMartGrowthLoaderData.basicImageUrl) && Intrinsics.areEqual((Object) this.finalImageUrl, (Object) tMartGrowthLoaderData.finalImageUrl);
    }

    @Nullable
    public final String getBasicImageUrl() {
        return this.basicImageUrl;
    }

    @Nullable
    public final String getFinalImageUrl() {
        return this.finalImageUrl;
    }

    public int hashCode() {
        String str = this.basicImageUrl;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.finalImageUrl;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.basicImageUrl;
        String str2 = this.finalImageUrl;
        return "TMartGrowthLoaderData(basicImageUrl=" + str + ", finalImageUrl=" + str2 + ")";
    }
}
