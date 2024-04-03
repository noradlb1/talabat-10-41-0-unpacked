package com.talabat.talabatcommon.views.wallet.walletCardManagement.view;

import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCardFragment$addLearnMoreListener$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletAddCardFragment f11953g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SecureMoreInfoBottomSheetDialog f11954h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletAddCardFragment$addLearnMoreListener$1$1(WalletAddCardFragment walletAddCardFragment, SecureMoreInfoBottomSheetDialog secureMoreInfoBottomSheetDialog) {
        super(0);
        this.f11953g = walletAddCardFragment;
        this.f11954h = secureMoreInfoBottomSheetDialog;
    }

    public final void invoke() {
        FragmentManager fragmentManager = this.f11953g.getFragmentManager();
        if (fragmentManager != null) {
            this.f11954h.show(fragmentManager, "");
        }
    }
}
