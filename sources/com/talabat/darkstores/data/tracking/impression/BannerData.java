package com.talabat.darkstores.data.tracking.impression;

import com.talabat.darkstores.model.Banner;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/data/tracking/impression/BannerData;", "", "bannerList", "", "Lcom/talabat/darkstores/model/Banner;", "screenName", "", "trackingName", "bannerType", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBannerList", "()Ljava/util/List;", "getBannerType", "()Ljava/lang/String;", "getScreenName", "getTrackingName", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerData {
    @NotNull
    private final List<Banner> bannerList;
    @NotNull
    private final String bannerType;
    @NotNull
    private final String screenName;
    @NotNull
    private final String trackingName;

    public BannerData(@NotNull List<Banner> list, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(list, "bannerList");
        Intrinsics.checkNotNullParameter(str, "screenName");
        Intrinsics.checkNotNullParameter(str2, "trackingName");
        Intrinsics.checkNotNullParameter(str3, "bannerType");
        this.bannerList = list;
        this.screenName = str;
        this.trackingName = str2;
        this.bannerType = str3;
    }

    @NotNull
    public final List<Banner> getBannerList() {
        return this.bannerList;
    }

    @NotNull
    public final String getBannerType() {
        return this.bannerType;
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final String getTrackingName() {
        return this.trackingName;
    }
}
