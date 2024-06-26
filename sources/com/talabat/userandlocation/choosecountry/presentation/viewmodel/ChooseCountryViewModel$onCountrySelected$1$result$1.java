package com.talabat.userandlocation.choosecountry.presentation.viewmodel;

import com.talabat.userandlocation.choosecountry.domain.UseCases;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.userandlocation.choosecountry.presentation.viewmodel.ChooseCountryViewModel$onCountrySelected$1$result$1", f = "ChooseCountryViewModel.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
public final class ChooseCountryViewModel$onCountrySelected$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SetUserSelectedCountryUseCase.Result>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12256h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChooseCountryViewModel f12257i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f12258j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChooseCountryViewModel$onCountrySelected$1$result$1(ChooseCountryViewModel chooseCountryViewModel, int i11, Continuation<? super ChooseCountryViewModel$onCountrySelected$1$result$1> continuation) {
        super(2, continuation);
        this.f12257i = chooseCountryViewModel;
        this.f12258j = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChooseCountryViewModel$onCountrySelected$1$result$1(this.f12257i, this.f12258j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super SetUserSelectedCountryUseCase.Result> continuation) {
        return ((ChooseCountryViewModel$onCountrySelected$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12256h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            UseCases access$getUseCases$p = this.f12257i.useCases;
            int i12 = this.f12258j;
            this.f12256h = 1;
            obj = SetUserSelectedCountryUseCase.DefaultImpls.setUserSelectedCountry$default(access$getUseCases$p, i12, false, false, this, 6, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
