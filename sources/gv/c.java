package gv;

import android.view.View;
import android.view.WindowInsets;
import com.talabat.talabatcommon.utils.DisplayUtils;

public final /* synthetic */ class c implements View.OnApplyWindowInsetsListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f62124a;

    public /* synthetic */ c(View view) {
        this.f62124a = view;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return DisplayUtils.Companion.m10943setStatusBarHeight$lambda1(this.f62124a, view, windowInsets);
    }
}
