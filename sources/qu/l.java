package qu;

import android.view.View;
import com.talabat.sidemenu.SideMenuHeader;
import com.talabat.sidemenu.SideMenuRecyclerViewAdapter;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SideMenuRecyclerViewAdapter f62854b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SideMenuHeader f62855c;

    public /* synthetic */ l(SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter, SideMenuHeader sideMenuHeader) {
        this.f62854b = sideMenuRecyclerViewAdapter;
        this.f62855c = sideMenuHeader;
    }

    public final void onClick(View view) {
        this.f62854b.lambda$bindRewardsViewHolder$1(this.f62855c, view);
    }
}
