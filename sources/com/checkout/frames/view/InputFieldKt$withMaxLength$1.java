package com.checkout.frames.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class InputFieldKt$withMaxLength$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Integer $maxLength;
    final /* synthetic */ Function1<String, Unit> $this_withMaxLength;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldKt$withMaxLength$1(Integer num, Function1<? super String, Unit> function1) {
        super(1);
        this.$maxLength = num;
        this.$this_withMaxLength = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Unit unit;
        Intrinsics.checkNotNullParameter(str, "it");
        Integer num = this.$maxLength;
        if (num != null) {
            Function1<String, Unit> function1 = this.$this_withMaxLength;
            if (str.length() <= num.intValue()) {
                function1.invoke(str);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.$this_withMaxLength.invoke(str);
        }
    }
}
