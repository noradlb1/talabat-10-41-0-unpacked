package com.designsystem.ds_input_field;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.lazy.LazyListState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PhoneInputCountriesFragment$CountryPicker$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Interaction> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PhoneInputCountriesFragment f31861b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LazyListState f31862c;

    public PhoneInputCountriesFragment$CountryPicker$1$invokeSuspend$$inlined$collect$1(PhoneInputCountriesFragment phoneInputCountriesFragment, LazyListState lazyListState) {
        this.f31861b = phoneInputCountriesFragment;
        this.f31862c = lazyListState;
    }

    @Nullable
    public Object emit(Interaction interaction, @NotNull Continuation<? super Unit> continuation) {
        boolean z11;
        Interaction interaction2 = interaction;
        PhoneInputCountriesFragment phoneInputCountriesFragment = this.f31861b;
        if (this.f31862c.getFirstVisibleItemScrollOffset() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        phoneInputCountriesFragment.allowSheetDrag(z11);
        return Unit.INSTANCE;
    }
}
