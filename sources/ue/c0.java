package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.AddAddressScreen2;

public final /* synthetic */ class c0 implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddAddressScreen2 f57458b;

    public /* synthetic */ c0(AddAddressScreen2 addAddressScreen2) {
        this.f57458b = addAddressScreen2;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57458b.lambda$onCreate$4(textView, i11, keyEvent);
    }
}
