package es;

import androidx.lifecycle.Observer;
import com.talabat.feature.walletcobrandedcc.domain.model.WalletStatus;
import com.talabat.home.useraccount.UserAccountFragment;

public final /* synthetic */ class a implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserAccountFragment f62000a;

    public /* synthetic */ a(UserAccountFragment userAccountFragment) {
        this.f62000a = userAccountFragment;
    }

    public final void onChanged(Object obj) {
        UserAccountFragment.m10647loadPendingCcApplication$lambda3(this.f62000a, (WalletStatus) obj);
    }
}
