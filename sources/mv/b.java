package mv;

import android.view.View;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.adapter.HeadlinesAdapter;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HeadlinesAdapter f23936b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f23937c;

    public /* synthetic */ b(HeadlinesAdapter headlinesAdapter, int i11) {
        this.f23936b = headlinesAdapter;
        this.f23937c = i11;
    }

    public final void onClick(View view) {
        HeadlinesAdapter.m5766onBindViewHolder$lambda0(this.f23936b, this.f23937c, view);
    }
}
