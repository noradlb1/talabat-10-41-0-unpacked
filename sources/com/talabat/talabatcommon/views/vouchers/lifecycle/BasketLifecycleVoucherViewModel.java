package com.talabat.talabatcommon.views.vouchers.lifecycle;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GuestWelcomeVoucherUseCase;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\r\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0013R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/lifecycle/BasketLifecycleVoucherViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "welcomeVoucherUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/GuestWelcomeVoucherUseCase;", "selectedCountryId", "Lkotlin/Function0;", "", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/GuestWelcomeVoucherUseCase;Lkotlin/jvm/functions/Function0;)V", "_voucherDataLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "voucherDataLiveData", "Landroidx/lifecycle/LiveData;", "getVoucherDataLiveData", "()Landroidx/lifecycle/LiveData;", "getWelcomeVoucherData", "", "getWelcomeVoucherData$com_talabat_NewArchi_TalabatCommon_TalabatCommon", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BasketLifecycleVoucherViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    @NotNull
    public final MutableLiveData<String> _voucherDataLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<Integer> selectedCountryId;
    @NotNull
    private final LiveData<String> voucherDataLiveData;
    /* access modifiers changed from: private */
    @NotNull
    public final GuestWelcomeVoucherUseCase welcomeVoucherUseCase;

    public BasketLifecycleVoucherViewModel() {
        this((CoroutineDispatcher) null, (GuestWelcomeVoucherUseCase) null, (Function0) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BasketLifecycleVoucherViewModel(CoroutineDispatcher coroutineDispatcher, GuestWelcomeVoucherUseCase guestWelcomeVoucherUseCase, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Dispatchers.getIO() : coroutineDispatcher, (i11 & 2) != 0 ? WelcomeVoucherUseCaseFactoryKt.getWelcomeVoucherUseCase$default((Context) null, 1, (Object) null) : guestWelcomeVoucherUseCase, (i11 & 4) != 0 ? AnonymousClass1.INSTANCE : function0);
    }

    @NotNull
    public final LiveData<String> getVoucherDataLiveData() {
        return this.voucherDataLiveData;
    }

    public final void getWelcomeVoucherData$com_talabat_NewArchi_TalabatCommon_TalabatCommon() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BasketLifecycleVoucherViewModel$getWelcomeVoucherData$1(this, (Continuation<? super BasketLifecycleVoucherViewModel$getWelcomeVoucherData$1>) null), 3, (Object) null);
    }

    public BasketLifecycleVoucherViewModel(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull GuestWelcomeVoucherUseCase guestWelcomeVoucherUseCase, @NotNull Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(guestWelcomeVoucherUseCase, "welcomeVoucherUseCase");
        Intrinsics.checkNotNullParameter(function0, "selectedCountryId");
        this.dispatcher = coroutineDispatcher;
        this.welcomeVoucherUseCase = guestWelcomeVoucherUseCase;
        this.selectedCountryId = function0;
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._voucherDataLiveData = mutableLiveData;
        this.voucherDataLiveData = mutableLiveData;
    }
}
