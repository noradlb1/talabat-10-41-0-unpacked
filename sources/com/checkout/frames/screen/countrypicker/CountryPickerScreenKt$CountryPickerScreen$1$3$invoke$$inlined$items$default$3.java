package com.checkout.frames.screen.countrypicker;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke", "androidx/compose/foundation/lazy/LazyDslKt$items$3"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class CountryPickerScreenKt$CountryPickerScreen$1$3$invoke$$inlined$items$default$3 extends Lambda implements Function1<Integer, Object> {
    final /* synthetic */ Function1 $contentType;
    final /* synthetic */ List $items;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryPickerScreenKt$CountryPickerScreen$1$3$invoke$$inlined$items$default$3(Function1 function1, List list) {
        super(1);
        this.$contentType = function1;
        this.$items = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @Nullable
    public final Object invoke(int i11) {
        return this.$contentType.invoke(this.$items.get(i11));
    }
}
