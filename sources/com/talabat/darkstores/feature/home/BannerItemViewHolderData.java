package com.talabat.darkstores.feature.home;

import com.talabat.darkstores.model.Banner;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bu\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J9\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\u001b\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0010HÆ\u0003J\u0001\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u000328\b\u0002\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00062\b\b\u0002\u0010\r\u001a\u00020\n2\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017RA\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R#\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006&"}, d2 = {"Lcom/talabat/darkstores/feature/home/BannerItemViewHolderData;", "", "banners", "", "Lcom/talabat/darkstores/model/Banner;", "onBannerClicked", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "banner", "", "position", "", "itemPriority", "onBannerShownListener", "bannerType", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function2;Ljava/lang/String;)V", "getBannerType", "()Ljava/lang/String;", "getBanners", "()Ljava/util/List;", "getItemPriority", "()I", "getOnBannerClicked", "()Lkotlin/jvm/functions/Function2;", "getOnBannerShownListener", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerItemViewHolderData {
    @NotNull
    private final String bannerType;
    @NotNull
    private final List<Banner> banners;
    private final int itemPriority;
    @NotNull
    private final Function2<Banner, Integer, Unit> onBannerClicked;
    @NotNull
    private final Function2<Banner, Integer, Unit> onBannerShownListener;

    public BannerItemViewHolderData(@NotNull List<Banner> list, @NotNull Function2<? super Banner, ? super Integer, Unit> function2, int i11, @NotNull Function2<? super Banner, ? super Integer, Unit> function22, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "banners");
        Intrinsics.checkNotNullParameter(function2, "onBannerClicked");
        Intrinsics.checkNotNullParameter(function22, "onBannerShownListener");
        Intrinsics.checkNotNullParameter(str, "bannerType");
        this.banners = list;
        this.onBannerClicked = function2;
        this.itemPriority = i11;
        this.onBannerShownListener = function22;
        this.bannerType = str;
    }

    public static /* synthetic */ BannerItemViewHolderData copy$default(BannerItemViewHolderData bannerItemViewHolderData, List<Banner> list, Function2<Banner, Integer, Unit> function2, int i11, Function2<Banner, Integer, Unit> function22, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            list = bannerItemViewHolderData.banners;
        }
        if ((i12 & 2) != 0) {
            function2 = bannerItemViewHolderData.onBannerClicked;
        }
        Function2<Banner, Integer, Unit> function23 = function2;
        if ((i12 & 4) != 0) {
            i11 = bannerItemViewHolderData.itemPriority;
        }
        int i13 = i11;
        if ((i12 & 8) != 0) {
            function22 = bannerItemViewHolderData.onBannerShownListener;
        }
        Function2<Banner, Integer, Unit> function24 = function22;
        if ((i12 & 16) != 0) {
            str = bannerItemViewHolderData.bannerType;
        }
        return bannerItemViewHolderData.copy(list, function23, i13, function24, str);
    }

    @NotNull
    public final List<Banner> component1() {
        return this.banners;
    }

    @NotNull
    public final Function2<Banner, Integer, Unit> component2() {
        return this.onBannerClicked;
    }

    public final int component3() {
        return this.itemPriority;
    }

    @NotNull
    public final Function2<Banner, Integer, Unit> component4() {
        return this.onBannerShownListener;
    }

    @NotNull
    public final String component5() {
        return this.bannerType;
    }

    @NotNull
    public final BannerItemViewHolderData copy(@NotNull List<Banner> list, @NotNull Function2<? super Banner, ? super Integer, Unit> function2, int i11, @NotNull Function2<? super Banner, ? super Integer, Unit> function22, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "banners");
        Intrinsics.checkNotNullParameter(function2, "onBannerClicked");
        Intrinsics.checkNotNullParameter(function22, "onBannerShownListener");
        Intrinsics.checkNotNullParameter(str, "bannerType");
        return new BannerItemViewHolderData(list, function2, i11, function22, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannerItemViewHolderData)) {
            return false;
        }
        BannerItemViewHolderData bannerItemViewHolderData = (BannerItemViewHolderData) obj;
        return Intrinsics.areEqual((Object) this.banners, (Object) bannerItemViewHolderData.banners) && Intrinsics.areEqual((Object) this.onBannerClicked, (Object) bannerItemViewHolderData.onBannerClicked) && this.itemPriority == bannerItemViewHolderData.itemPriority && Intrinsics.areEqual((Object) this.onBannerShownListener, (Object) bannerItemViewHolderData.onBannerShownListener) && Intrinsics.areEqual((Object) this.bannerType, (Object) bannerItemViewHolderData.bannerType);
    }

    @NotNull
    public final String getBannerType() {
        return this.bannerType;
    }

    @NotNull
    public final List<Banner> getBanners() {
        return this.banners;
    }

    public final int getItemPriority() {
        return this.itemPriority;
    }

    @NotNull
    public final Function2<Banner, Integer, Unit> getOnBannerClicked() {
        return this.onBannerClicked;
    }

    @NotNull
    public final Function2<Banner, Integer, Unit> getOnBannerShownListener() {
        return this.onBannerShownListener;
    }

    public int hashCode() {
        return (((((((this.banners.hashCode() * 31) + this.onBannerClicked.hashCode()) * 31) + this.itemPriority) * 31) + this.onBannerShownListener.hashCode()) * 31) + this.bannerType.hashCode();
    }

    @NotNull
    public String toString() {
        List<Banner> list = this.banners;
        Function2<Banner, Integer, Unit> function2 = this.onBannerClicked;
        int i11 = this.itemPriority;
        Function2<Banner, Integer, Unit> function22 = this.onBannerShownListener;
        String str = this.bannerType;
        return "BannerItemViewHolderData(banners=" + list + ", onBannerClicked=" + function2 + ", itemPriority=" + i11 + ", onBannerShownListener=" + function22 + ", bannerType=" + str + ")";
    }
}
