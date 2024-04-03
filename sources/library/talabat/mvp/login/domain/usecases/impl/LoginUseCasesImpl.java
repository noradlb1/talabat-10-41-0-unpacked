package library.talabat.mvp.login.domain.usecases.impl;

import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.domain.EnableShowLocationSelectionInHomeScreenUseCase;
import library.talabat.mvp.login.domain.usecases.LoginUseCases;
import library.talabat.mvp.login.domain.usecases.SelectSavedAddressIfCanDeliverToVendorUseCase;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\bH\u0001J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0001¨\u0006\f"}, d2 = {"Llibrary/talabat/mvp/login/domain/usecases/impl/LoginUseCasesImpl;", "Llibrary/talabat/mvp/login/domain/usecases/LoginUseCases;", "Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase;", "Llibrary/talabat/mvp/home/domain/EnableShowLocationSelectionInHomeScreenUseCase;", "selectSavedAddressIfCanDeliverToVendorUseCase", "enableShowLocationSelectionInHomeScreenUseCase", "(Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase;Llibrary/talabat/mvp/home/domain/EnableShowLocationSelectionInHomeScreenUseCase;)V", "enableShowLocationSelectionInHomeScreen", "", "selectSavedAddressIfCanDeliverToVendor", "Lio/reactivex/Single;", "Llibrary/talabat/mvp/login/domain/usecases/SelectSavedAddressIfCanDeliverToVendorUseCase$Result;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoginUseCasesImpl implements LoginUseCases, SelectSavedAddressIfCanDeliverToVendorUseCase, EnableShowLocationSelectionInHomeScreenUseCase {
    private final /* synthetic */ SelectSavedAddressIfCanDeliverToVendorUseCase $$delegate_0;
    private final /* synthetic */ EnableShowLocationSelectionInHomeScreenUseCase $$delegate_1;

    public LoginUseCasesImpl(@NotNull SelectSavedAddressIfCanDeliverToVendorUseCase selectSavedAddressIfCanDeliverToVendorUseCase, @NotNull EnableShowLocationSelectionInHomeScreenUseCase enableShowLocationSelectionInHomeScreenUseCase) {
        Intrinsics.checkNotNullParameter(selectSavedAddressIfCanDeliverToVendorUseCase, "selectSavedAddressIfCanDeliverToVendorUseCase");
        Intrinsics.checkNotNullParameter(enableShowLocationSelectionInHomeScreenUseCase, "enableShowLocationSelectionInHomeScreenUseCase");
        this.$$delegate_0 = selectSavedAddressIfCanDeliverToVendorUseCase;
        this.$$delegate_1 = enableShowLocationSelectionInHomeScreenUseCase;
    }

    public void enableShowLocationSelectionInHomeScreen() {
        this.$$delegate_1.enableShowLocationSelectionInHomeScreen();
    }

    @NotNull
    public Single<SelectSavedAddressIfCanDeliverToVendorUseCase.Result> selectSavedAddressIfCanDeliverToVendor() {
        return this.$$delegate_0.selectSavedAddressIfCanDeliverToVendor();
    }
}
