package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.AddAddressScreen2;

public final /* synthetic */ class l implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddAddressScreen2 f57617b;

    public /* synthetic */ l(AddAddressScreen2 addAddressScreen2) {
        this.f57617b = addAddressScreen2;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57617b.lambda$setImeOptionAndEditorActionListener$27(textView, i11, keyEvent);
    }
}
