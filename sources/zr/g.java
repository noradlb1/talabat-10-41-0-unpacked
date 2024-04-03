package zr;

import android.view.View;
import com.talabat.helpers.MiniCartDisabledLayout;
import com.talabat.helpers.MiniCartLayout;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f63106b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MiniCartLayout.OnCartClickListener f63107c;

    public /* synthetic */ g(int i11, MiniCartLayout.OnCartClickListener onCartClickListener) {
        this.f63106b = i11;
        this.f63107c = onCartClickListener;
    }

    public final void onClick(View view) {
        MiniCartDisabledLayout.lambda$setData$0(this.f63106b, this.f63107c, view);
    }
}
