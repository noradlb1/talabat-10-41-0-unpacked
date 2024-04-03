package zv;

import android.view.View;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView;

public final /* synthetic */ class i implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddCardCustomView f24253b;

    public /* synthetic */ i(AddCardCustomView addCardCustomView) {
        this.f24253b = addCardCustomView;
    }

    public final void onFocusChange(View view, boolean z11) {
        AddCardCustomView.m5796addCardNumberOnFocusChangeListener$lambda7(this.f24253b, view, z11);
    }
}
