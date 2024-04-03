package zr;

import android.view.View;
import com.talabat.helpers.MiniCartLayout;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MiniCartLayout.OnCartClickListener f63114b;

    public /* synthetic */ k(MiniCartLayout.OnCartClickListener onCartClickListener) {
        this.f63114b = onCartClickListener;
    }

    public final void onClick(View view) {
        this.f63114b.cartButtonClicked();
    }
}
