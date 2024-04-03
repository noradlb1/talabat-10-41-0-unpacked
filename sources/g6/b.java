package g6;

import android.view.View;
import com.designsystem.ds_tabs.DSTabBar;

public final /* synthetic */ class b implements View.OnScrollChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DSTabBar f34471b;

    public /* synthetic */ b(DSTabBar dSTabBar) {
        this.f34471b = dSTabBar;
    }

    public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
        DSTabBar.m8625setupListeners$lambda4(this.f34471b, view, i11, i12, i13, i14);
    }
}
