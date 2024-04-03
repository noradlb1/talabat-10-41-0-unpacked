package ue;

import android.view.KeyEvent;
import android.widget.TextView;
import com.talabat.QuickOrderScreen;

public final /* synthetic */ class qb implements TextView.OnEditorActionListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickOrderScreen f57711b;

    public /* synthetic */ qb(QuickOrderScreen quickOrderScreen) {
        this.f57711b = quickOrderScreen;
    }

    public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
        return this.f57711b.lambda$onCreate$19(textView, i11, keyEvent);
    }
}
