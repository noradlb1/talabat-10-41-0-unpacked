package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.AddAddressScreen2;

public final /* synthetic */ class i implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddAddressScreen2 f57568b;

    public /* synthetic */ i(AddAddressScreen2 addAddressScreen2) {
        this.f57568b = addAddressScreen2;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57568b.lambda$setImeOptionAndEditorActionListener$24(textView, i11, keyEvent);
    }
}
