package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.AddAddressScreen2;

public final /* synthetic */ class g implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddAddressScreen2 f57534b;

    public /* synthetic */ g(AddAddressScreen2 addAddressScreen2) {
        this.f57534b = addAddressScreen2;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57534b.lambda$setImeOptionAndEditorActionListener$22(textView, i11, keyEvent);
    }
}
