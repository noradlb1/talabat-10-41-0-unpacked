package mj;

import android.view.View;
import com.talabat.darkstores.feature.model.PreSearchItem;
import com.talabat.darkstores.feature.search.PreSearchAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PreSearchAdapter f57029b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PreSearchItem.RecentSearch f57030c;

    public /* synthetic */ a(PreSearchAdapter preSearchAdapter, PreSearchItem.RecentSearch recentSearch) {
        this.f57029b = preSearchAdapter;
        this.f57030c = recentSearch;
    }

    public final void onClick(View view) {
        PreSearchAdapter.RecentSearchViewHolder.m10058bind$lambda0(this.f57029b, this.f57030c, view);
    }
}
