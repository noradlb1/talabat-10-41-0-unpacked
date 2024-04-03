package mv;

import android.view.View;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.adapter.GlassProductsAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GlassProductsAdapter f23934b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f23935c;

    public /* synthetic */ a(GlassProductsAdapter glassProductsAdapter, int i11) {
        this.f23934b = glassProductsAdapter;
        this.f23935c = i11;
    }

    public final void onClick(View view) {
        GlassProductsAdapter.m5765onBindViewHolder$lambda0(this.f23934b, this.f23935c, view);
    }
}
