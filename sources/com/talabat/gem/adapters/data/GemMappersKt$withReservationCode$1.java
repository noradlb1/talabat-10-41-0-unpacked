package com.talabat.gem.adapters.data;

import datamodels.Cuisine;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ldatamodels/Cuisine;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemMappersKt$withReservationCode$1 extends Lambda implements Function1<Cuisine, CharSequence> {
    public static final GemMappersKt$withReservationCode$1 INSTANCE = new GemMappersKt$withReservationCode$1();

    public GemMappersKt$withReservationCode$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(Cuisine cuisine) {
        String str = cuisine.f13849name;
        Intrinsics.checkNotNullExpressionValue(str, "it.name");
        return str;
    }
}
