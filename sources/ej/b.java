package ej;

import com.talabat.darkstores.feature.home.banner.LoopingViewPager;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LoopingViewPager f56823b;

    public /* synthetic */ b(LoopingViewPager loopingViewPager) {
        this.f56823b = loopingViewPager;
    }

    public final void run() {
        LoopingViewPager.m9975autoScrollRunnable$lambda1(this.f56823b);
    }
}
