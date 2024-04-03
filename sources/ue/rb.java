package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.QuickOrderScreen;

public final /* synthetic */ class rb implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickOrderScreen f57725b;

    public /* synthetic */ rb(QuickOrderScreen quickOrderScreen) {
        this.f57725b = quickOrderScreen;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57725b.lambda$onCreate$20(textView, i11, keyEvent);
    }
}
