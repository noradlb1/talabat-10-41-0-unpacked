package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.AddAddressScreen2;

public final /* synthetic */ class f0 implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddAddressScreen2 f57519b;

    public /* synthetic */ f0(AddAddressScreen2 addAddressScreen2) {
        this.f57519b = addAddressScreen2;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57519b.lambda$onCreate$7(textView, i11, keyEvent);
    }
}
