package com.talabat.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import library.talabat.mvp.home.IHomePresenter;
import library.talabat.mvp.home.domain.model.ActiveCartInfo;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity$showCartView$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f60897g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ActiveCartInfo f60898h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenActivity$showCartView$1$1(HomeScreenActivity homeScreenActivity, ActiveCartInfo activeCartInfo) {
        super(0);
        this.f60897g = homeScreenActivity;
        this.f60898h = activeCartInfo;
    }

    public final void invoke() {
        IHomePresenter homePresenter = this.f60897g.getHomePresenter();
        if (homePresenter != null) {
            homePresenter.basketSelection(this.f60898h);
        }
    }
}
