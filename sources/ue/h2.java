package ue;

import android.view.View;
import android.widget.RadioButton;
import com.talabat.CheckOutScreen;

public final /* synthetic */ class h2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckOutScreen f57552b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RadioButton f57553c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RadioButton f57554d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f57555e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ RadioButton f57556f;

    public /* synthetic */ h2(CheckOutScreen checkOutScreen, RadioButton radioButton, RadioButton radioButton2, String str, RadioButton radioButton3) {
        this.f57552b = checkOutScreen;
        this.f57553c = radioButton;
        this.f57554d = radioButton2;
        this.f57555e = str;
        this.f57556f = radioButton3;
    }

    public final void onClick(View view) {
        this.f57552b.lambda$onDuplicateOrder$47(this.f57553c, this.f57554d, this.f57555e, this.f57556f, view);
    }
}
