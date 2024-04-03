package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.QuickOrderScreen;

public final /* synthetic */ class lc implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickOrderScreen f57636b;

    public /* synthetic */ lc(QuickOrderScreen quickOrderScreen) {
        this.f57636b = quickOrderScreen;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57636b.lambda$onCreate$17(textView, i11, keyEvent);
    }
}
