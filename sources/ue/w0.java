package ue;

import com.talabat.userandlocation.compliance.status.di.module.UserStatusDomainModule;
import library.talabat.mvp.cart.CartPresenter;

public final /* synthetic */ class w0 implements CartPresenter.CanCheckComplianceStatusOfUserDelegate {
    public final boolean canCheckComplianceStatusOfUser() {
        return UserStatusDomainModule.INSTANCE;
    }
}
