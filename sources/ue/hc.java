package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.QuickOrderScreen;

public final /* synthetic */ class hc implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickOrderScreen f57565b;

    public /* synthetic */ hc(QuickOrderScreen quickOrderScreen) {
        this.f57565b = quickOrderScreen;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57565b.lambda$onCreate$13(textView, i11, keyEvent);
    }
}
