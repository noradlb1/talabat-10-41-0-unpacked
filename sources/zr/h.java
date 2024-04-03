package zr;

import android.view.View;
import com.talabat.helpers.MiniCartDisabledLayout;
import com.talabat.helpers.MiniCartLayout;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f63109b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MiniCartLayout.OnCartClickListener f63110c;

    public /* synthetic */ h(int i11, MiniCartLayout.OnCartClickListener onCartClickListener) {
        this.f63109b = i11;
        this.f63110c = onCartClickListener;
    }

    public final void onClick(View view) {
        MiniCartDisabledLayout.lambda$setData$1(this.f63109b, this.f63110c, view);
    }
}
