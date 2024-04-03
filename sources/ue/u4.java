package ue;

import android.view.View;
import com.talabat.CheckOutScreen;

public final /* synthetic */ class u4 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57769b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f57770c;

    public /* synthetic */ u4(CheckOutScreen checkOutScreen, View.OnClickListener onClickListener) {
        this.f57769b = checkOutScreen;
        this.f57770c = onClickListener;
    }

    public final void onClick(View view) {
        this.f57769b.lambda$setFeesDescriptions$26(this.f57770c, view);
    }
}
