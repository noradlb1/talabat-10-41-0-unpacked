package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.QuickOrderScreen;

public final /* synthetic */ class ic implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickOrderScreen f57582b;

    public /* synthetic */ ic(QuickOrderScreen quickOrderScreen) {
        this.f57582b = quickOrderScreen;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57582b.lambda$onCreate$14(textView, i11, keyEvent);
    }
}
