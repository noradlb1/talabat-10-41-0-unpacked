package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.AddAddressScreen2;

public final /* synthetic */ class f implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddAddressScreen2 f57518b;

    public /* synthetic */ f(AddAddressScreen2 addAddressScreen2) {
        this.f57518b = addAddressScreen2;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57518b.lambda$setImeOptionAndEditorActionListener$21(textView, i11, keyEvent);
    }
}
