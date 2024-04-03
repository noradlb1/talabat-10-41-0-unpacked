package tq;

import com.google.android.material.appbar.AppBarLayout;
import com.talabat.gem.adapters.presentation.collections.list.GemCollectionActivity;

public final /* synthetic */ class b implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GemCollectionActivity f62922a;

    public /* synthetic */ b(GemCollectionActivity gemCollectionActivity) {
        this.f62922a = gemCollectionActivity;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i11) {
        GemCollectionActivity.m10537configureToolbar$lambda2(this.f62922a, appBarLayout, i11);
    }
}
