package ue;

import android.view.View;
import com.talabat.CheckOutScreen;

public final /* synthetic */ class t4 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57751b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f57752c;

    public /* synthetic */ t4(CheckOutScreen checkOutScreen, View.OnClickListener onClickListener) {
        this.f57751b = checkOutScreen;
        this.f57752c = onClickListener;
    }

    public final void onClick(View view) {
        this.f57751b.lambda$setFeesDescriptions$25(this.f57752c, view);
    }
}
