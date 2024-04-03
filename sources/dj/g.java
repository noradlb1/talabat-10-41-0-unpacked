package dj;

import android.view.View;
import com.talabat.darkstores.feature.home.HomeFragment;

public final /* synthetic */ class g implements View.OnScrollChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56739b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f56740c;

    public /* synthetic */ g(HomeFragment homeFragment, boolean z11) {
        this.f56739b = homeFragment;
        this.f56740c = z11;
    }

    public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
        HomeFragment.m9953setUpListeners$lambda4(this.f56739b, this.f56740c, view, i11, i12, i13, i14);
    }
}
