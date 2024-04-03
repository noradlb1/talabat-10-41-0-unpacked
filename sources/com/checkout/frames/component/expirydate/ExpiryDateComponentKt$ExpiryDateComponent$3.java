package com.checkout.frames.component.expirydate;

import androidx.compose.runtime.Composer;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.style.component.ExpiryDateComponentStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExpiryDateComponentKt$ExpiryDateComponent$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ Injector $injector;
    final /* synthetic */ ExpiryDateComponentStyle $style;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpiryDateComponentKt$ExpiryDateComponent$3(ExpiryDateComponentStyle expiryDateComponentStyle, Injector injector, int i11) {
        super(2);
        this.$style = expiryDateComponentStyle;
        this.$injector = injector;
        this.$$changed = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ExpiryDateComponentKt.ExpiryDateComponent(this.$style, this.$injector, composer, this.$$changed | 1);
    }
}
