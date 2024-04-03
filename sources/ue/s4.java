package ue;

import android.view.View;
import com.talabat.CheckOutScreen;

public final /* synthetic */ class s4 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57732b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f57733c;

    public /* synthetic */ s4(CheckOutScreen checkOutScreen, View.OnClickListener onClickListener) {
        this.f57732b = checkOutScreen;
        this.f57733c = onClickListener;
    }

    public final void onClick(View view) {
        this.f57732b.lambda$setFeesDescriptions$24(this.f57733c, view);
    }
}
