package com.checkout.frames.component.country;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CountryComponentKt$CountryComponent$2 extends Lambda implements Function1<String, Unit> {
    public static final CountryComponentKt$CountryComponent$2 INSTANCE = new CountryComponentKt$CountryComponent$2();

    public CountryComponentKt$CountryComponent$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "it");
    }
}
