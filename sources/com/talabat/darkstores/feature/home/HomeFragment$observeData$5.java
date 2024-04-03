package com.talabat.darkstores.feature.home;

import com.talabat.darkstores.model.viewstate.TproBannerViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "state", "Lcom/talabat/darkstores/model/viewstate/TproBannerViewState;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeFragment$observeData$5 extends Lambda implements Function1<TproBannerViewState, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56396g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$observeData$5(HomeFragment homeFragment) {
        super(1);
        this.f56396g = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TproBannerViewState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TproBannerViewState tproBannerViewState) {
        Intrinsics.checkNotNullParameter(tproBannerViewState, "state");
        if (tproBannerViewState instanceof TproBannerViewState.Shown) {
            this.f56396g.showTproSubscriptionHeader(((TproBannerViewState.Shown) tproBannerViewState).getShowSubscribeButton());
        } else if (Intrinsics.areEqual((Object) tproBannerViewState, (Object) TproBannerViewState.Hidden.INSTANCE)) {
            this.f56396g.hideTproSubscriptionHeader();
        }
    }
}
