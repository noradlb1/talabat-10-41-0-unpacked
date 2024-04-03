package ue;

import android.view.View;
import com.talabat.CheckOutScreen;

public final /* synthetic */ class w4 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57805b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f57806c;

    public /* synthetic */ w4(CheckOutScreen checkOutScreen, View.OnClickListener onClickListener) {
        this.f57805b = checkOutScreen;
        this.f57806c = onClickListener;
    }

    public final void onClick(View view) {
        this.f57805b.lambda$setFeesDescriptions$27(this.f57806c, view);
    }
}
