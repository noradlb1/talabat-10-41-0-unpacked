package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.AddAddressScreen2;

public final /* synthetic */ class h implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddAddressScreen2 f57549b;

    public /* synthetic */ h(AddAddressScreen2 addAddressScreen2) {
        this.f57549b = addAddressScreen2;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57549b.lambda$setImeOptionAndEditorActionListener$23(textView, i11, keyEvent);
    }
}
