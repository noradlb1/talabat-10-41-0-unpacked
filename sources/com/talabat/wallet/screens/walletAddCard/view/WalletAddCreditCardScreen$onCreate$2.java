package com.talabat.wallet.screens.walletAddCard.view;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"com/talabat/wallet/screens/walletAddCard/view/WalletAddCreditCardScreen$onCreate$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "start", "removed", "added", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCreditCardScreen$onCreate$2 implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WalletAddCreditCardScreen f12677b;

    public WalletAddCreditCardScreen$onCreate$2(WalletAddCreditCardScreen walletAddCreditCardScreen) {
        this.f12677b = walletAddCreditCardScreen;
    }

    public void afterTextChanged(@Nullable Editable editable) {
        this.f12677b.cardExpiryAfterTextValidation(editable);
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i11, int i12, int i13) {
    }
}
