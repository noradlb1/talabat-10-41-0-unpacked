package com.deliveryhero.fluid.values;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "component", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class Color$toString$toHexString$1 extends Lambda implements Function1<Integer, String> {
    public static final Color$toString$toHexString$1 INSTANCE = new Color$toString$toHexString$1();

    public Color$toString$toHexString$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public final String invoke(int i11) {
        String num = Integer.toString(i11, CharsKt__CharJVMKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        if (num.length() != 1) {
            return num;
        }
        return '0' + num;
    }
}
