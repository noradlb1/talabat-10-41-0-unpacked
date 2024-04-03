package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.AddAddressScreen2;

public final /* synthetic */ class e implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddAddressScreen2 f57497b;

    public /* synthetic */ e(AddAddressScreen2 addAddressScreen2) {
        this.f57497b = addAddressScreen2;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57497b.lambda$setImeOptionAndEditorActionListener$20(textView, i11, keyEvent);
    }
}
