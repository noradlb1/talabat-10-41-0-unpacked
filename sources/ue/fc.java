package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.QuickOrderScreen;

public final /* synthetic */ class fc implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickOrderScreen f57531b;

    public /* synthetic */ fc(QuickOrderScreen quickOrderScreen) {
        this.f57531b = quickOrderScreen;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57531b.lambda$onCreate$11(textView, i11, keyEvent);
    }
}
