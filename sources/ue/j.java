package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.AddAddressScreen2;

public final /* synthetic */ class j implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddAddressScreen2 f57584b;

    public /* synthetic */ j(AddAddressScreen2 addAddressScreen2) {
        this.f57584b = addAddressScreen2;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57584b.lambda$setImeOptionAndEditorActionListener$25(textView, i11, keyEvent);
    }
}
