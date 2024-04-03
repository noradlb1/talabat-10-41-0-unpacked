package com.talabat.home.useraccount;

import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.feature.subscriptions.domain.usecase.UpdateAutoRenewalUseCase;
import com.talabat.feature.tpro.presentation.savings.account.SideMenuTProSavingsViewPresenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/feature/tpro/presentation/savings/account/SideMenuTProSavingsViewPresenter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UserAccountRecyclerViewAdapter$sideMenuTProSavingsViewPresenter$2 extends Lambda implements Function0<SideMenuTProSavingsViewPresenter> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CoroutineDispatchersFactory f60941g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GetSavingsInfoUseCase f60942h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ UpdateAutoRenewalUseCase f60943i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ UserAccountRecyclerViewAdapter f60944j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserAccountRecyclerViewAdapter$sideMenuTProSavingsViewPresenter$2(CoroutineDispatchersFactory coroutineDispatchersFactory, GetSavingsInfoUseCase getSavingsInfoUseCase, UpdateAutoRenewalUseCase updateAutoRenewalUseCase, UserAccountRecyclerViewAdapter userAccountRecyclerViewAdapter) {
        super(0);
        this.f60941g = coroutineDispatchersFactory;
        this.f60942h = getSavingsInfoUseCase;
        this.f60943i = updateAutoRenewalUseCase;
        this.f60944j = userAccountRecyclerViewAdapter;
    }

    @NotNull
    public final SideMenuTProSavingsViewPresenter invoke() {
        return new SideMenuTProSavingsViewPresenter(this.f60941g, this.f60942h, this.f60943i, this.f60944j.subscriptionStatusRepository, this.f60944j.selectedCountry.getCountryId(), this.f60944j.onUpdateRenewalResult, this.f60944j.subscriptionTracker);
    }
}
