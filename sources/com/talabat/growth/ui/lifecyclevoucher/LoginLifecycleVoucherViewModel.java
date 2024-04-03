package com.talabat.growth.ui.lifecyclevoucher;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GuestWelcomeVoucherUseCase;
import com.talabat.talabatcommon.views.vouchers.lifecycle.WelcomeVoucherUseCaseFactoryKt;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/growth/ui/lifecyclevoucher/LoginLifecycleVoucherViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "welcomeVoucherUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/GuestWelcomeVoucherUseCase;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/GuestWelcomeVoucherUseCase;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "_voucherDataLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/growth/ui/lifecyclevoucher/LoginLifecycleVoucherDisplayModel;", "voucherDataLiveData", "Landroidx/lifecycle/LiveData;", "getVoucherDataLiveData", "()Landroidx/lifecycle/LiveData;", "getWelcomeVoucherData", "", "getWelcomeVoucherData$com_talabat_NewArchi_GrowthSquad_GrowthSquad", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoginLifecycleVoucherViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<LoginLifecycleVoucherDisplayModel> _voucherDataLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalRepository configurationLocalRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineDispatcher dispatcher;
    @NotNull
    private final LiveData<LoginLifecycleVoucherDisplayModel> voucherDataLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final GuestWelcomeVoucherUseCase welcomeVoucherUseCase;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoginLifecycleVoucherViewModel(CoroutineDispatcher coroutineDispatcher, GuestWelcomeVoucherUseCase guestWelcomeVoucherUseCase, ConfigurationLocalRepository configurationLocalRepository2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Dispatchers.getIO() : coroutineDispatcher, (i11 & 2) != 0 ? WelcomeVoucherUseCaseFactoryKt.getWelcomeVoucherUseCase$default((Context) null, 1, (Object) null) : guestWelcomeVoucherUseCase, configurationLocalRepository2);
    }

    @NotNull
    public final LiveData<LoginLifecycleVoucherDisplayModel> getVoucherDataLiveData() {
        return this.voucherDataLiveData;
    }

    public final void getWelcomeVoucherData$com_talabat_NewArchi_GrowthSquad_GrowthSquad() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new LoginLifecycleVoucherViewModel$getWelcomeVoucherData$1(this, (Continuation<? super LoginLifecycleVoucherViewModel$getWelcomeVoucherData$1>) null), 3, (Object) null);
    }

    public LoginLifecycleVoucherViewModel(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull GuestWelcomeVoucherUseCase guestWelcomeVoucherUseCase, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(guestWelcomeVoucherUseCase, "welcomeVoucherUseCase");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.dispatcher = coroutineDispatcher;
        this.welcomeVoucherUseCase = guestWelcomeVoucherUseCase;
        this.configurationLocalRepository = configurationLocalRepository2;
        MutableLiveData<LoginLifecycleVoucherDisplayModel> mutableLiveData = new MutableLiveData<>();
        this._voucherDataLiveData = mutableLiveData;
        this.voucherDataLiveData = mutableLiveData;
    }
}
