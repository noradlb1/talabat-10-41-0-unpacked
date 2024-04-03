package ue;

import android.view.View;
import android.widget.RadioButton;
import com.talabat.CheckOutScreen;

public final /* synthetic */ class x2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57820b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RadioButton f57821c;

    public /* synthetic */ x2(CheckOutScreen checkOutScreen, RadioButton radioButton) {
        this.f57820b = checkOutScreen;
        this.f57821c = radioButton;
    }

    public final void onClick(View view) {
        this.f57820b.lambda$onCreate$1(this.f57821c, view);
    }
}
