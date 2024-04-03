package qu;

import android.view.View;
import com.talabat.sidemenu.SideMenuHeader;
import com.talabat.sidemenu.SideMenuRecyclerViewAdapter;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SideMenuRecyclerViewAdapter f62852b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SideMenuHeader f62853c;

    public /* synthetic */ j(SideMenuRecyclerViewAdapter sideMenuRecyclerViewAdapter, SideMenuHeader sideMenuHeader) {
        this.f62852b = sideMenuRecyclerViewAdapter;
        this.f62853c = sideMenuHeader;
    }

    public final void onClick(View view) {
        this.f62852b.lambda$onBindViewHolder$0(this.f62853c, view);
    }
}
