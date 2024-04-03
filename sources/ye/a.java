package ye;

import android.view.View;
import com.talabat.adapters.grocery.SearchHistoryAdapter;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchHistoryAdapter f57996b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f57997c;

    public /* synthetic */ a(SearchHistoryAdapter searchHistoryAdapter, Ref.ObjectRef objectRef) {
        this.f57996b = searchHistoryAdapter;
        this.f57997c = objectRef;
    }

    public final void onClick(View view) {
        SearchHistoryAdapter.m9496onBindViewHolder$lambda0(this.f57996b, this.f57997c, view);
    }
}
