package es;

import androidx.lifecycle.Observer;
import com.talabat.home.useraccount.UserAccountFragment;
import library.talabat.mvp.home.VoucherStateDomainModel;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserAccountFragment f62001a;

    public /* synthetic */ b(UserAccountFragment userAccountFragment) {
        this.f62001a = userAccountFragment;
    }

    public final void onChanged(Object obj) {
        UserAccountFragment.m10646loadCreditBalanceAndVouchers$lambda4(this.f62001a, (VoucherStateDomainModel) obj);
    }
}
