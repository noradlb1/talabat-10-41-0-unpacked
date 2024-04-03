package zr;

import android.view.View;
import com.talabat.helpers.MiniCartDisabledLayout;
import com.talabat.helpers.MiniCartLayout;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f63111b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MiniCartLayout.OnCartClickListener f63112c;

    public /* synthetic */ i(int i11, MiniCartLayout.OnCartClickListener onCartClickListener) {
        this.f63111b = i11;
        this.f63112c = onCartClickListener;
    }

    public final void onClick(View view) {
        MiniCartDisabledLayout.lambda$setData$2(this.f63111b, this.f63112c, view);
    }
}
