package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.QuickOrderScreen;

public final /* synthetic */ class jc implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickOrderScreen f57598b;

    public /* synthetic */ jc(QuickOrderScreen quickOrderScreen) {
        this.f57598b = quickOrderScreen;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57598b.lambda$onCreate$15(textView, i11, keyEvent);
    }
}
