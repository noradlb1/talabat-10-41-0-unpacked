package dj;

import android.view.View;
import com.talabat.darkstores.feature.home.HomeFragment;
import com.talabat.darkstores.model.Swimlane;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56745b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Swimlane f56746c;

    public /* synthetic */ k(HomeFragment homeFragment, Swimlane swimlane) {
        this.f56745b = homeFragment;
        this.f56746c = swimlane;
    }

    public final void onClick(View view) {
        HomeFragment.m9945addCompactSwimlaneView$lambda44$lambda43(this.f56745b, this.f56746c, view);
    }
}
