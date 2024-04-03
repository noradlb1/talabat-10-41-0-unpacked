package zr;

import android.view.View;
import com.talabat.helpers.MiniCartLayout;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MiniCartLayout.OnCartClickListener f63115b;

    public /* synthetic */ l(MiniCartLayout.OnCartClickListener onCartClickListener) {
        this.f63115b = onCartClickListener;
    }

    public final void onClick(View view) {
        this.f63115b.cartButtonClicked();
    }
}
