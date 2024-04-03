package com.talabat.talabatcommon.views.wallet.walletCardManagement.view;

import android.widget.LinearLayout;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletAddCardFragment$showErrorStatusNotification$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletAddCardFragment f11955g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f11956h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletAddCardFragment$showErrorStatusNotification$1(WalletAddCardFragment walletAddCardFragment, String str) {
        super(0);
        this.f11955g = walletAddCardFragment;
        this.f11956h = str;
    }

    public final void invoke() {
        Status.Companion.notify$default(Status.Companion, this.f11955g.getActivity(), (LinearLayout) this.f11955g._$_findCachedViewById(R.id.errorNotifyLinearLayout), this.f11956h, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 56, (Object) null);
    }
}
