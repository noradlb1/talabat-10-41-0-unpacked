package com.talabat.feature.darkstores.vendorlanding.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/model/Banner;", "", "globalId", "", "name", "bannerUrl", "position", "", "isStatic", "", "tracking", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/BannerTracking;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLcom/talabat/feature/darkstores/vendorlanding/domain/model/BannerTracking;)V", "getBannerUrl", "()Ljava/lang/String;", "getGlobalId", "()Z", "getName", "getPosition", "()I", "getTracking", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/model/BannerTracking;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Banner {
    @NotNull
    private final String bannerUrl;
    @NotNull
    private final String globalId;
    private final boolean isStatic;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58416name;
    private final int position;
    @Nullable

    /* renamed from: tracking  reason: collision with root package name */
    private final BannerTracking f58417tracking;

    public Banner(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, boolean z11, @Nullable BannerTracking bannerTracking) {
        Intrinsics.checkNotNullParameter(str, "globalId");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "bannerUrl");
        this.globalId = str;
        this.f58416name = str2;
        this.bannerUrl = str3;
        this.position = i11;
        this.isStatic = z11;
        this.f58417tracking = bannerTracking;
    }

    public static /* synthetic */ Banner copy$default(Banner banner, String str, String str2, String str3, int i11, boolean z11, BannerTracking bannerTracking, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = banner.globalId;
        }
        if ((i12 & 2) != 0) {
            str2 = banner.f58416name;
        }
        String str4 = str2;
        if ((i12 & 4) != 0) {
            str3 = banner.bannerUrl;
        }
        String str5 = str3;
        if ((i12 & 8) != 0) {
            i11 = banner.position;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            z11 = banner.isStatic;
        }
        boolean z12 = z11;
        if ((i12 & 32) != 0) {
            bannerTracking = banner.f58417tracking;
        }
        return banner.copy(str, str4, str5, i13, z12, bannerTracking);
    }

    @NotNull
    public final String component1() {
        return this.globalId;
    }

    @NotNull
    public final String component2() {
        return this.f58416name;
    }

    @NotNull
    public final String component3() {
        return this.bannerUrl;
    }

    public final int component4() {
        return this.position;
    }

    public final boolean component5() {
        return this.isStatic;
    }

    @Nullable
    public final BannerTracking component6() {
        return this.f58417tracking;
    }

    @NotNull
    public final Banner copy(@NotNull String str, @NotNull String str2, @NotNull String str3, int i11, boolean z11, @Nullable BannerTracking bannerTracking) {
        Intrinsics.checkNotNullParameter(str, "globalId");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "bannerUrl");
        return new Banner(str, str2, str3, i11, z11, bannerTracking);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Banner)) {
            return false;
        }
        Banner banner = (Banner) obj;
        return Intrinsics.areEqual((Object) this.globalId, (Object) banner.globalId) && Intrinsics.areEqual((Object) this.f58416name, (Object) banner.f58416name) && Intrinsics.areEqual((Object) this.bannerUrl, (Object) banner.bannerUrl) && this.position == banner.position && this.isStatic == banner.isStatic && Intrinsics.areEqual((Object) this.f58417tracking, (Object) banner.f58417tracking);
    }

    @NotNull
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    @NotNull
    public final String getGlobalId() {
        return this.globalId;
    }

    @NotNull
    public final String getName() {
        return this.f58416name;
    }

    public final int getPosition() {
        return this.position;
    }

    @Nullable
    public final BannerTracking getTracking() {
        return this.f58417tracking;
    }

    public int hashCode() {
        int hashCode = ((((((this.globalId.hashCode() * 31) + this.f58416name.hashCode()) * 31) + this.bannerUrl.hashCode()) * 31) + this.position) * 31;
        boolean z11 = this.isStatic;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        BannerTracking bannerTracking = this.f58417tracking;
        return i11 + (bannerTracking == null ? 0 : bannerTracking.hashCode());
    }

    public final boolean isStatic() {
        return this.isStatic;
    }

    @NotNull
    public String toString() {
        String str = this.globalId;
        String str2 = this.f58416name;
        String str3 = this.bannerUrl;
        int i11 = this.position;
        boolean z11 = this.isStatic;
        BannerTracking bannerTracking = this.f58417tracking;
        return "Banner(globalId=" + str + ", name=" + str2 + ", bannerUrl=" + str3 + ", position=" + i11 + ", isStatic=" + z11 + ", tracking=" + bannerTracking + ")";
    }
}
