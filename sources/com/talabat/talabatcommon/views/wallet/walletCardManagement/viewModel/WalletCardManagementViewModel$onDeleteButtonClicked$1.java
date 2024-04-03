package com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel;

import com.talabat.talabatcommon.feature.walletCardManagement.SendCardDeleteClickedEventUseCase;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.WalletCardManagementViewModel$onDeleteButtonClicked$1", f = "WalletCardManagementViewModel.kt", i = {}, l = {275}, m = "invokeSuspend", n = {}, s = {})
public final class WalletCardManagementViewModel$onDeleteButtonClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f11966h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletCardManagementViewModel f11967i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCardManagementViewModel$onDeleteButtonClicked$1(WalletCardManagementViewModel walletCardManagementViewModel, Continuation<? super WalletCardManagementViewModel$onDeleteButtonClicked$1> continuation) {
        super(2, continuation);
        this.f11967i = walletCardManagementViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletCardManagementViewModel$onDeleteButtonClicked$1(this.f11967i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletCardManagementViewModel$onDeleteButtonClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f11966h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SendCardDeleteClickedEventUseCase access$getSendCardDeleteClickedEventUseCase$p = this.f11967i.sendCardDeleteClickedEventUseCase;
            this.f11966h = 1;
            if (access$getSendCardDeleteClickedEventUseCase$p.invoke(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e11) {
                this.f11967i.trackUnExpectedScenario(e11);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
