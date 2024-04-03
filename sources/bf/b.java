package bf;

import android.view.View;
import com.talabat.adapters.restaurantslist.RecentSearchAdapter;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RecentSearchAdapter f50844b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f50845c;

    public /* synthetic */ b(RecentSearchAdapter recentSearchAdapter, String str) {
        this.f50844b = recentSearchAdapter;
        this.f50845c = str;
    }

    public final void onClick(View view) {
        this.f50844b.lambda$onBindViewHolder$0(this.f50845c, view);
    }
}
