package zr;

import android.view.View;
import com.talabat.helpers.MiniCartLayout;
import com.talabat.helpers.MiniCartTotalLayout;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MiniCartLayout.OnCartClickListener f63113b;

    public /* synthetic */ j(MiniCartLayout.OnCartClickListener onCartClickListener) {
        this.f63113b = onCartClickListener;
    }

    public final void onClick(View view) {
        MiniCartTotalLayout.lambda$setData$0(this.f63113b, view);
    }
}
