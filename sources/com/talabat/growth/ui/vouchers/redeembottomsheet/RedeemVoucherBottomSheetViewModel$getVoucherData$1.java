package com.talabat.growth.ui.vouchers.redeembottomsheet;

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
@DebugMetadata(c = "com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetViewModel$getVoucherData$1", f = "RedeemVoucherBottomSheetViewModel.kt", i = {}, l = {29, 35}, m = "invokeSuspend", n = {}, s = {})
public final class RedeemVoucherBottomSheetViewModel$getVoucherData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f60732h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f60733i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ RedeemVoucherBottomSheetViewModel f60734j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f60735k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedeemVoucherBottomSheetViewModel$getVoucherData$1(boolean z11, RedeemVoucherBottomSheetViewModel redeemVoucherBottomSheetViewModel, String str, Continuation<? super RedeemVoucherBottomSheetViewModel$getVoucherData$1> continuation) {
        super(2, continuation);
        this.f60733i = z11;
        this.f60734j = redeemVoucherBottomSheetViewModel;
        this.f60735k = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RedeemVoucherBottomSheetViewModel$getVoucherData$1 redeemVoucherBottomSheetViewModel$getVoucherData$1 = new RedeemVoucherBottomSheetViewModel$getVoucherData$1(this.f60733i, this.f60734j, this.f60735k, continuation);
        redeemVoucherBottomSheetViewModel$getVoucherData$1.L$0 = obj;
        return redeemVoucherBottomSheetViewModel$getVoucherData$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RedeemVoucherBottomSheetViewModel$getVoucherData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cc  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.f60732h
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0027
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r0 = r14.L$0
            com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetViewModel r0 = (com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetViewModel) r0
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x009c }
            goto L_0x008d
        L_0x0017:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x001f:
            java.lang.Object r0 = r14.L$0
            com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetViewModel r0 = (com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetViewModel) r0
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x009c }
            goto L_0x0066
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            kotlinx.coroutines.CoroutineScope r15 = (kotlinx.coroutines.CoroutineScope) r15
            boolean r15 = r14.f60733i
            com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetViewModel r1 = r14.f60734j
            java.lang.String r5 = r14.f60735k
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x009c }
            if (r15 == 0) goto L_0x0071
            com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase r4 = r1.redeemVoucherCodeUseCase     // Catch:{ all -> 0x009c }
            r6 = 0
            com.talabat.configuration.ConfigurationLocalRepository r15 = r1.configurationLocalRepository     // Catch:{ all -> 0x009c }
            com.talabat.configuration.country.Country r15 = r15.selectedCountry()     // Catch:{ all -> 0x009c }
            int r7 = r15.getCountryId()     // Catch:{ all -> 0x009c }
            kotlin.jvm.functions.Function0 r15 = r1.selectedAreaId     // Catch:{ all -> 0x009c }
            java.lang.Object r15 = r15.invoke()     // Catch:{ all -> 0x009c }
            r8 = r15
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x009c }
            r9 = 0
            r10 = 0
            r12 = 50
            r13 = 0
            r14.L$0 = r1     // Catch:{ all -> 0x009c }
            r14.f60732h = r3     // Catch:{ all -> 0x009c }
            r11 = r14
            java.lang.Object r15 = com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherCodeUseCase.invoke$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x009c }
            if (r15 != r0) goto L_0x0065
            return r0
        L_0x0065:
            r0 = r1
        L_0x0066:
            com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel r15 = (com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel) r15     // Catch:{ all -> 0x009c }
            android.content.Context r0 = r0.context     // Catch:{ all -> 0x009c }
            com.talabat.growth.ui.vouchers.redeembottomsheet.model.RedeemVoucherBottomSheetDisplayModel r15 = com.talabat.growth.ui.vouchers.redeembottomsheet.model.MapperKt.toRedeemVoucherBottomSheetDisplayModel((com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel) r15, (android.content.Context) r0)     // Catch:{ all -> 0x009c }
            goto L_0x0097
        L_0x0071:
            com.talabat.growth.features.vouchers.domain.GuestVoucherDetailsUseCase r15 = r1.guestVoucherDetails     // Catch:{ all -> 0x009c }
            com.talabat.configuration.ConfigurationLocalRepository r3 = r1.configurationLocalRepository     // Catch:{ all -> 0x009c }
            com.talabat.configuration.country.Country r3 = r3.selectedCountry()     // Catch:{ all -> 0x009c }
            int r3 = r3.getCountryId()     // Catch:{ all -> 0x009c }
            r14.L$0 = r1     // Catch:{ all -> 0x009c }
            r14.f60732h = r2     // Catch:{ all -> 0x009c }
            java.lang.Object r15 = r15.invoke(r5, r3, r14)     // Catch:{ all -> 0x009c }
            if (r15 != r0) goto L_0x008c
            return r0
        L_0x008c:
            r0 = r1
        L_0x008d:
            com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestVoucherDomainModel r15 = (com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestVoucherDomainModel) r15     // Catch:{ all -> 0x009c }
            android.content.Context r0 = r0.context     // Catch:{ all -> 0x009c }
            com.talabat.growth.ui.vouchers.redeembottomsheet.model.RedeemVoucherBottomSheetDisplayModel r15 = com.talabat.growth.ui.vouchers.redeembottomsheet.model.MapperKt.toRedeemVoucherBottomSheetDisplayModel((com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestVoucherDomainModel) r15, (android.content.Context) r0)     // Catch:{ all -> 0x009c }
        L_0x0097:
            java.lang.Object r15 = kotlin.Result.m6329constructorimpl(r15)     // Catch:{ all -> 0x009c }
            goto L_0x00a7
        L_0x009c:
            r15 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r15 = kotlin.ResultKt.createFailure(r15)
            java.lang.Object r15 = kotlin.Result.m6329constructorimpl(r15)
        L_0x00a7:
            com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetViewModel r0 = r14.f60734j
            boolean r1 = r14.f60733i
            boolean r2 = kotlin.Result.m6336isSuccessimpl(r15)
            if (r2 == 0) goto L_0x00c4
            r2 = r15
            com.talabat.growth.ui.vouchers.redeembottomsheet.model.RedeemVoucherBottomSheetDisplayModel r2 = (com.talabat.growth.ui.vouchers.redeembottomsheet.model.RedeemVoucherBottomSheetDisplayModel) r2
            androidx.lifecycle.MutableLiveData r0 = r0.getSuccessResult()
            kotlin.Pair r3 = new kotlin.Pair
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            r3.<init>(r1, r2)
            r0.postValue(r3)
        L_0x00c4:
            com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetViewModel r0 = r14.f60734j
            java.lang.Throwable r15 = kotlin.Result.m6332exceptionOrNullimpl(r15)
            if (r15 == 0) goto L_0x00d5
            androidx.lifecycle.MutableLiveData r0 = r0.getFailureData()
            com.talabat.talabatcore.exception.Failure r15 = (com.talabat.talabatcore.exception.Failure) r15
            r0.postValue(r15)
        L_0x00d5:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.ui.vouchers.redeembottomsheet.RedeemVoucherBottomSheetViewModel$getVoucherData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
