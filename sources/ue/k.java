package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.AddAddressScreen2;

public final /* synthetic */ class k implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddAddressScreen2 f57601b;

    public /* synthetic */ k(AddAddressScreen2 addAddressScreen2) {
        this.f57601b = addAddressScreen2;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57601b.lambda$setImeOptionAndEditorActionListener$26(textView, i11, keyEvent);
    }
}
