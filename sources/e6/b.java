package e6;

import android.view.View;
import com.designsystem.ds_navigation_bar.behaviour.DSNavigationBarAnimationBehaviorFixed;

public final /* synthetic */ class b implements View.OnScrollChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DSNavigationBarAnimationBehaviorFixed f34423b;

    public /* synthetic */ b(DSNavigationBarAnimationBehaviorFixed dSNavigationBarAnimationBehaviorFixed) {
        this.f34423b = dSNavigationBarAnimationBehaviorFixed;
    }

    public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
        DSNavigationBarAnimationBehaviorFixed.m8506_init_$lambda1(this.f34423b, view, i11, i12, i13, i14);
    }
}
