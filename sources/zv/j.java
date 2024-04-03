package zv;

import android.view.View;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView;

public final /* synthetic */ class j implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddCardCustomView f24254b;

    public /* synthetic */ j(AddCardCustomView addCardCustomView) {
        this.f24254b = addCardCustomView;
    }

    public final void onFocusChange(View view, boolean z11) {
        AddCardCustomView.m5798addExpiryDateOnFocusChangeListener$lambda9(this.f24254b, view, z11);
    }
}
