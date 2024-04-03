package ze;

import android.view.View;
import com.talabat.adapters.homeMap.HomeMapSearchAreaAdapter;
import datamodels.AreaExpandableListViewModel;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeMapSearchAreaAdapter f58056b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AreaExpandableListViewModel f58057c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58058d;

    public /* synthetic */ f(HomeMapSearchAreaAdapter homeMapSearchAreaAdapter, AreaExpandableListViewModel areaExpandableListViewModel, int i11) {
        this.f58056b = homeMapSearchAreaAdapter;
        this.f58057c = areaExpandableListViewModel;
        this.f58058d = i11;
    }

    public final void onClick(View view) {
        HomeMapSearchAreaAdapter.m9504getChildView$lambda0(this.f58056b, this.f58057c, this.f58058d, view);
    }
}
