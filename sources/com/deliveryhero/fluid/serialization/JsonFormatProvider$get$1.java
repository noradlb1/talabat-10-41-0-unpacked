package com.deliveryhero.fluid.serialization;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "TrackingModelT", "Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "Lcom/deliveryhero/fluid/content/ContentBuilder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class JsonFormatProvider$get$1 extends Lambda implements Function1 {
    public static final JsonFormatProvider$get$1 INSTANCE = new JsonFormatProvider$get$1();

    public JsonFormatProvider$get$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PolymorphicModuleBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PolymorphicModuleBuilder polymorphicModuleBuilder) {
        Intrinsics.checkNotNullParameter(polymorphicModuleBuilder, "$this$null");
    }
}
