package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.AddAddressScreen2;

public final /* synthetic */ class m implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddAddressScreen2 f57638b;

    public /* synthetic */ m(AddAddressScreen2 addAddressScreen2) {
        this.f57638b = addAddressScreen2;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57638b.lambda$setImeOptionAndEditorActionListener$28(textView, i11, keyEvent);
    }
}
