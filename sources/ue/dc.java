package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.QuickOrderScreen;

public final /* synthetic */ class dc implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickOrderScreen f57492b;

    public /* synthetic */ dc(QuickOrderScreen quickOrderScreen) {
        this.f57492b = quickOrderScreen;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57492b.lambda$onCreate$10(textView, i11, keyEvent);
    }
}
