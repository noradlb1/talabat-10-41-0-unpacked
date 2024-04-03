package ej;

import android.view.View;
import com.talabat.darkstores.feature.home.banner.BannerPagerAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BannerPagerAdapter f56821b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f56822c;

    public /* synthetic */ a(BannerPagerAdapter bannerPagerAdapter, int i11) {
        this.f56821b = bannerPagerAdapter;
        this.f56822c = i11;
    }

    public final void onClick(View view) {
        BannerPagerAdapter.m9974bindView$lambda0(this.f56821b, this.f56822c, view);
    }
}
