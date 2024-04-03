package com.checkout.frames.screen.countrypicker;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class CountryPickerScreenKt$CountryPickerScreen$1$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public CountryPickerScreenKt$CountryPickerScreen$1$2(Object obj) {
        super(1, obj, CountryPickerViewModel.class, "onSearchChange", "onSearchChange(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        ((CountryPickerViewModel) this.receiver).onSearchChange(str);
    }
}
