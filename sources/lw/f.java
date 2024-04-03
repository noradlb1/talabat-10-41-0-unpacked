package lw;

import android.view.View;
import android.view.WindowInsets;
import com.talabat.talabatlife.ui.vendorList.VendorsListFragment;

public final /* synthetic */ class f implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f23929a;

    public /* synthetic */ f(VendorsListFragment vendorsListFragment) {
        this.f23929a = vendorsListFragment;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return VendorsListFragment.m5849setStatusBarHeight$lambda5(this.f23929a, view, windowInsets);
    }
}
