package com.talabat.userandlocation.choosecountry.presentation.viewmodel;

import java.util.List;
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
@DebugMetadata(c = "com.talabat.userandlocation.choosecountry.presentation.viewmodel.ChooseCountryViewModel$showCountries$1", f = "ChooseCountryViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
public final class ChooseCountryViewModel$showCountries$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f12264h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChooseCountryViewModel f12265i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChooseCountryViewModel$showCountries$1(ChooseCountryViewModel chooseCountryViewModel, Continuation<? super ChooseCountryViewModel$showCountries$1> continuation) {
        super(2, continuation);
        this.f12265i = chooseCountryViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChooseCountryViewModel$showCountries$1(this.f12265i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChooseCountryViewModel$showCountries$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f12264h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ChooseCountryViewModel chooseCountryViewModel = this.f12265i;
            this.f12264h = 1;
            obj = chooseCountryViewModel.getCountriesList(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f12265i.getCountries().postValue((List) obj);
        return Unit.INSTANCE;
    }
}
