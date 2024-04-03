package com.talabat.wallet.debitcarddeflection.presentation.viewmodel;

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
@DebugMetadata(c = "com.talabat.wallet.debitcarddeflection.presentation.viewmodel.BenefitManagerViewModel$onDebitCardBinVerified$1", f = "DebitCardDeflectionViewModel.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
public final class BenefitManagerViewModel$onDebitCardBinVerified$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f12570h;

    /* renamed from: i  reason: collision with root package name */
    public int f12571i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f12572j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ BenefitManagerViewModel f12573k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BenefitManagerViewModel$onDebitCardBinVerified$1(String str, BenefitManagerViewModel benefitManagerViewModel, Continuation<? super BenefitManagerViewModel$onDebitCardBinVerified$1> continuation) {
        super(2, continuation);
        this.f12572j = str;
        this.f12573k = benefitManagerViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BenefitManagerViewModel$onDebitCardBinVerified$1(this.f12572j, this.f12573k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BenefitManagerViewModel$onDebitCardBinVerified$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r1v9, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.f12571i
            r2 = 1
            if (r1 == 0) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            java.lang.Object r0 = r6.f12570h
            androidx.lifecycle.MutableLiveData r0 = (androidx.lifecycle.MutableLiveData) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0066
        L_0x0013:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = r6.f12572j
            r1 = 0
            if (r7 == 0) goto L_0x002c
            int r7 = r7.length()
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            goto L_0x002d
        L_0x002c:
            r7 = r1
        L_0x002d:
            int r7 = com.talabat.talabatcommon.extentions.IntKt.orZero((java.lang.Integer) r7)
            r3 = 6
            if (r7 < r3) goto L_0x006a
            com.talabat.wallet.debitcarddeflection.presentation.viewmodel.BenefitManagerViewModel r7 = r6.f12573k
            boolean r7 = r7.isDebitCardBinAPICalled()
            if (r7 != 0) goto L_0x006a
            com.talabat.wallet.debitcarddeflection.presentation.viewmodel.BenefitManagerViewModel r7 = r6.f12573k
            r7.setDebitCardBinAPICalled(r2)
            java.lang.String r7 = r6.f12572j
            if (r7 == 0) goto L_0x0049
            java.lang.String r1 = kotlin.text.StringsKt___StringsKt.take((java.lang.String) r7, (int) r3)
        L_0x0049:
            com.talabat.wallet.debitcarddeflection.presentation.viewmodel.BenefitManagerViewModel r7 = r6.f12573k
            androidx.lifecycle.MutableLiveData r7 = r7.getDebitCardBinVerificationData()
            com.talabat.wallet.debitcarddeflection.presentation.viewmodel.BenefitManagerViewModel r3 = r6.f12573k
            com.talabat.wallet.debitcarddeflection.domain.business.GetBinVerificationDisplayModelUseCase r3 = r3.getBinVerificationDisplayModelUseCase
            if (r1 != 0) goto L_0x0059
            java.lang.String r1 = ""
        L_0x0059:
            r6.f12570h = r7
            r6.f12571i = r2
            java.lang.Object r1 = r3.invoke(r1, r6)
            if (r1 != r0) goto L_0x0064
            return r0
        L_0x0064:
            r0 = r7
            r7 = r1
        L_0x0066:
            r0.postValue(r7)
            goto L_0x009e
        L_0x006a:
            java.lang.String r7 = r6.f12572j
            if (r7 == 0) goto L_0x0076
            int r7 = r7.length()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
        L_0x0076:
            int r7 = com.talabat.talabatcommon.extentions.IntKt.orZero((java.lang.Integer) r1)
            if (r7 >= r3) goto L_0x008e
            com.talabat.wallet.debitcarddeflection.presentation.viewmodel.BenefitManagerViewModel r7 = r6.f12573k
            androidx.lifecycle.MutableLiveData r7 = r7.getDebitCardBinVerificationData()
            com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinVerificationDisplayModel$ShowDefaultAddCardViews r0 = com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinVerificationDisplayModel.ShowDefaultAddCardViews.INSTANCE
            r7.postValue(r0)
            com.talabat.wallet.debitcarddeflection.presentation.viewmodel.BenefitManagerViewModel r7 = r6.f12573k
            r0 = 0
            r7.setDebitCardBinAPICalled(r0)
            goto L_0x009e
        L_0x008e:
            com.talabat.wallet.debitcarddeflection.presentation.viewmodel.BenefitManagerViewModel r7 = r6.f12573k
            com.talabat.core.observabilityNew.domain.IObservabilityManager r0 = r7.observabilityManager
            java.lang.String r1 = "BenefitBinVerification"
            java.lang.String r2 = "no UI changes"
            r3 = 0
            r4 = 4
            r5 = 0
            com.talabat.core.observabilityNew.domain.IObservabilityManager.DefaultImpls.trackEvent$default((com.talabat.core.observabilityNew.domain.IObservabilityManager) r0, (java.lang.String) r1, (java.lang.String) r2, (java.util.Map) r3, (int) r4, (java.lang.Object) r5)
        L_0x009e:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.debitcarddeflection.presentation.viewmodel.BenefitManagerViewModel$onDebitCardBinVerified$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
