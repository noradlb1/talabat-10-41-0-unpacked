package com.talabat.darkstores.feature.home;

import com.talabat.darkstores.R;
import com.talabat.darkstores.data.darkstores.model.BannersResponse;
import com.talabat.darkstores.feature.home.HomeFragment;
import com.talabat.darkstores.feature.home.banner.BannerView;
import com.talabat.darkstores.model.Banner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/darkstores/data/darkstores/model/BannersResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$observeData$1 extends Lambda implements Function1<BannersResponse, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56394g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$observeData$1(HomeFragment homeFragment) {
        super(1);
        this.f56394g = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BannersResponse) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull BannersResponse bannersResponse) {
        Intrinsics.checkNotNullParameter(bannersResponse, "it");
        if (this.f56394g.getViewModel().shouldBuildUIUsingRecyclerView()) {
            this.f56394g.updateHomeBannerItems(bannersResponse);
            return;
        }
        ((BannerView) this.f56394g._$_findCachedViewById(R.id.heroBanner)).setupAdapter(bannersResponse.getHeroBanners(), new Function2<Banner, Integer, Unit>(this.f56394g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Banner) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Banner banner, int i11) {
                Intrinsics.checkNotNullParameter(banner, "p0");
                ((HomeFragment) this.receiver).onHeroBannerClicked(banner, i11);
            }
        }, HomeFragment.BannerType.HERO.getType());
        ((BannerView) this.f56394g._$_findCachedViewById(R.id.banner)).setupAdapter(bannersResponse.getBanners(), new Function2<Banner, Integer, Unit>(this.f56394g) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Banner) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Banner banner, int i11) {
                Intrinsics.checkNotNullParameter(banner, "p0");
                ((HomeFragment) this.receiver).onSmallBannerClicked(banner, i11);
            }
        }, HomeFragment.BannerType.SMALL.getType());
    }
}
