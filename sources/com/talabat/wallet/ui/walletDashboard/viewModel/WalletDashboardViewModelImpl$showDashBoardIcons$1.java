package com.talabat.wallet.ui.walletDashboard.viewModel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl$showDashBoardIcons$1", f = "WalletDashboardViewModelImpl.kt", i = {0, 1, 2, 3}, l = {137, 138, 139, 140}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u2d0", "$this$invokeSuspend_u24lambda_u2d0", "$this$invokeSuspend_u24lambda_u2d0", "$this$invokeSuspend_u24lambda_u2d0"}, s = {"L$2", "L$2", "L$2", "L$2"})
public final class WalletDashboardViewModelImpl$showDashBoardIcons$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12795h;

    /* renamed from: i  reason: collision with root package name */
    public Object f12796i;

    /* renamed from: j  reason: collision with root package name */
    public Object f12797j;

    /* renamed from: k  reason: collision with root package name */
    public Object f12798k;

    /* renamed from: l  reason: collision with root package name */
    public Object f12799l;

    /* renamed from: m  reason: collision with root package name */
    public int f12800m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ WalletDashboardViewModelImpl f12801n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDashboardViewModelImpl$showDashBoardIcons$1(WalletDashboardViewModelImpl walletDashboardViewModelImpl, Continuation<? super WalletDashboardViewModelImpl$showDashBoardIcons$1> continuation) {
        super(2, continuation);
        this.f12801n = walletDashboardViewModelImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WalletDashboardViewModelImpl$showDashBoardIcons$1(this.f12801n, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WalletDashboardViewModelImpl$showDashBoardIcons$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00f5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x011b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x011c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.f12800m
            java.lang.String r2 = "topup-"
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x0084
            if (r1 == r6) goto L_0x0069
            if (r1 == r5) goto L_0x0050
            if (r1 == r4) goto L_0x0037
            if (r1 != r3) goto L_0x002f
            java.lang.Object r0 = r11.f12799l
            androidx.lifecycle.MutableLiveData r0 = (androidx.lifecycle.MutableLiveData) r0
            java.lang.Object r1 = r11.f12798k
            com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel r1 = (com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel) r1
            java.lang.Object r2 = r11.f12797j
            com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel r2 = (com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel) r2
            java.lang.Object r3 = r11.f12796i
            com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl r3 = (com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl) r3
            java.lang.Object r4 = r11.f12795h
            com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel r4 = (com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel) r4
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0121
        L_0x002f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0037:
            java.lang.Object r1 = r11.f12799l
            androidx.lifecycle.MutableLiveData r1 = (androidx.lifecycle.MutableLiveData) r1
            java.lang.Object r2 = r11.f12798k
            com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel r2 = (com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel) r2
            java.lang.Object r4 = r11.f12797j
            com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel r4 = (com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel) r4
            java.lang.Object r5 = r11.f12796i
            com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl r5 = (com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl) r5
            java.lang.Object r6 = r11.f12795h
            com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel r6 = (com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel) r6
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00fa
        L_0x0050:
            java.lang.Object r1 = r11.f12799l
            androidx.lifecycle.MutableLiveData r1 = (androidx.lifecycle.MutableLiveData) r1
            java.lang.Object r2 = r11.f12798k
            com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl r2 = (com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl) r2
            java.lang.Object r5 = r11.f12797j
            com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel r5 = (com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel) r5
            java.lang.Object r6 = r11.f12796i
            com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl r6 = (com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl) r6
            java.lang.Object r7 = r11.f12795h
            com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel r7 = (com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel) r7
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00d4
        L_0x0069:
            java.lang.Object r1 = r11.f12799l
            androidx.lifecycle.MutableLiveData r1 = (androidx.lifecycle.MutableLiveData) r1
            java.lang.Object r6 = r11.f12798k
            com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel r6 = (com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel) r6
            java.lang.Object r7 = r11.f12797j
            com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel r7 = (com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel) r7
            java.lang.Object r8 = r11.f12796i
            com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl r8 = (com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl) r8
            java.lang.Object r9 = r11.f12795h
            com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel r9 = (com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel) r9
            kotlin.ResultKt.throwOnFailure(r12)
            r10 = r8
            r8 = r7
            r7 = r10
            goto L_0x00b0
        L_0x0084:
            kotlin.ResultKt.throwOnFailure(r12)
            com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl r12 = r11.f12801n
            androidx.lifecycle.MutableLiveData r12 = r12.getWalletDashboardIconsData()
            com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel r1 = new com.talabat.wallet.ui.walletDashboard.model.WalletDashBoardIconsDisplayModel
            r1.<init>()
            com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl r7 = r11.f12801n
            com.talabat.wallet.features.walletTransactionList.GetWalletDashboardFlagEnabledUseCase r8 = r7.getWalletDashboardFlagEnabledUseCase
            r11.f12795h = r1
            r11.f12796i = r7
            r11.f12797j = r1
            r11.f12798k = r1
            r11.f12799l = r12
            r11.f12800m = r6
            java.lang.Object r6 = r8.invoke(r2, r11)
            if (r6 != r0) goto L_0x00ab
            return r0
        L_0x00ab:
            r8 = r1
            r9 = r8
            r1 = r12
            r12 = r6
            r6 = r9
        L_0x00b0:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            r6.setShouldShowTopUpIcon(r12)
            com.talabat.wallet.features.walletTransactionList.GetWalletDashboardFlagEnabledUseCase r12 = r7.getWalletDashboardFlagEnabledUseCase
            r11.f12795h = r9
            r11.f12796i = r7
            r11.f12797j = r8
            r11.f12798k = r7
            r11.f12799l = r1
            r11.f12800m = r5
            java.lang.Object r12 = r12.invoke(r2, r11)
            if (r12 != r0) goto L_0x00d0
            return r0
        L_0x00d0:
            r2 = r7
            r6 = r2
            r5 = r8
            r7 = r9
        L_0x00d4:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            r2.setShouldShowTopUpMessage(r12)
            com.talabat.wallet.features.walletTransactionList.GetWalletDashboardFlagEnabledUseCase r12 = r6.getWalletDashboardFlagEnabledUseCase
            r11.f12795h = r7
            r11.f12796i = r6
            r11.f12797j = r5
            r11.f12798k = r5
            r11.f12799l = r1
            r11.f12800m = r4
            java.lang.String r2 = "cardmanagement-"
            java.lang.Object r12 = r12.invoke(r2, r11)
            if (r12 != r0) goto L_0x00f6
            return r0
        L_0x00f6:
            r2 = r5
            r4 = r2
            r5 = r6
            r6 = r7
        L_0x00fa:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            r2.setShouldShowCardManagementIcon(r12)
            com.talabat.wallet.features.walletTransactionList.GetWalletDashboardFlagEnabledUseCase r12 = r5.getWalletDashboardFlagEnabledUseCase
            r11.f12795h = r6
            r11.f12796i = r5
            r11.f12797j = r4
            r11.f12798k = r4
            r11.f12799l = r1
            r11.f12800m = r3
            java.lang.String r2 = "sendgift-"
            java.lang.Object r12 = r12.invoke(r2, r11)
            if (r12 != r0) goto L_0x011c
            return r0
        L_0x011c:
            r0 = r1
            r1 = r4
            r2 = r1
            r3 = r5
            r4 = r6
        L_0x0121:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            r1.setShouldShowSendGiftIcon(r12)
            com.talabat.wallet.features.walletTransactionList.GetWalletDashboardMoreButtonEnabledUseCase r12 = r3.getWalletDashboardMoreButtonEnabledUseCase
            boolean r12 = r12.invoke()
            r2.setShouldShowMoreIcon(r12)
            r0.setValue(r4)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.ui.walletDashboard.viewModel.WalletDashboardViewModelImpl$showDashBoardIcons$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
