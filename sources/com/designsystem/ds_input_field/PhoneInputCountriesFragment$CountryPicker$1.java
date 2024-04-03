package com.designsystem.ds_input_field;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.lazy.LazyListState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.designsystem.ds_input_field.PhoneInputCountriesFragment$CountryPicker$1", f = "PhoneInputCountriesFragment.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
public final class PhoneInputCountriesFragment$CountryPicker$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f31874h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LazyListState f31875i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PhoneInputCountriesFragment f31876j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneInputCountriesFragment$CountryPicker$1(LazyListState lazyListState, PhoneInputCountriesFragment phoneInputCountriesFragment, Continuation<? super PhoneInputCountriesFragment$CountryPicker$1> continuation) {
        super(2, continuation);
        this.f31875i = lazyListState;
        this.f31876j = phoneInputCountriesFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PhoneInputCountriesFragment$CountryPicker$1(this.f31875i, this.f31876j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PhoneInputCountriesFragment$CountryPicker$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f31874h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Interaction> interactions = this.f31875i.getInteractionSource().getInteractions();
            PhoneInputCountriesFragment$CountryPicker$1$invokeSuspend$$inlined$collect$1 phoneInputCountriesFragment$CountryPicker$1$invokeSuspend$$inlined$collect$1 = new PhoneInputCountriesFragment$CountryPicker$1$invokeSuspend$$inlined$collect$1(this.f31876j, this.f31875i);
            this.f31874h = 1;
            if (interactions.collect(phoneInputCountriesFragment$CountryPicker$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
