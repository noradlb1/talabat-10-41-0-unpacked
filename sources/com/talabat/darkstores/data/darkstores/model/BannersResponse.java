package com.talabat.darkstores.data.darkstores.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import com.talabat.darkstores.model.Banner;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0003\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/data/darkstores/model/BannersResponse;", "", "heroBanners", "", "Lcom/talabat/darkstores/model/Banner;", "banners", "(Ljava/util/List;Ljava/util/List;)V", "getBanners", "()Ljava/util/List;", "getHeroBanners", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannersResponse {
    @NotNull
    private final List<Banner> banners;
    @NotNull
    private final List<Banner> heroBanners;

    public BannersResponse(@NotNull @Json(name = "hero_banners") List<Banner> list, @NotNull @Json(name = "banners") List<Banner> list2) {
        Intrinsics.checkNotNullParameter(list, "heroBanners");
        Intrinsics.checkNotNullParameter(list2, "banners");
        this.heroBanners = list;
        this.banners = list2;
    }

    public static /* synthetic */ BannersResponse copy$default(BannersResponse bannersResponse, List<Banner> list, List<Banner> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = bannersResponse.heroBanners;
        }
        if ((i11 & 2) != 0) {
            list2 = bannersResponse.banners;
        }
        return bannersResponse.copy(list, list2);
    }

    @NotNull
    public final List<Banner> component1() {
        return this.heroBanners;
    }

    @NotNull
    public final List<Banner> component2() {
        return this.banners;
    }

    @NotNull
    public final BannersResponse copy(@NotNull @Json(name = "hero_banners") List<Banner> list, @NotNull @Json(name = "banners") List<Banner> list2) {
        Intrinsics.checkNotNullParameter(list, "heroBanners");
        Intrinsics.checkNotNullParameter(list2, "banners");
        return new BannersResponse(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannersResponse)) {
            return false;
        }
        BannersResponse bannersResponse = (BannersResponse) obj;
        return Intrinsics.areEqual((Object) this.heroBanners, (Object) bannersResponse.heroBanners) && Intrinsics.areEqual((Object) this.banners, (Object) bannersResponse.banners);
    }

    @NotNull
    public final List<Banner> getBanners() {
        return this.banners;
    }

    @NotNull
    public final List<Banner> getHeroBanners() {
        return this.heroBanners;
    }

    public int hashCode() {
        return (this.heroBanners.hashCode() * 31) + this.banners.hashCode();
    }

    @NotNull
    public String toString() {
        List<Banner> list = this.heroBanners;
        List<Banner> list2 = this.banners;
        return "BannersResponse(heroBanners=" + list + ", banners=" + list2 + ")";
    }
}
