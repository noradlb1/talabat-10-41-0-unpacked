package com.talabat.fluid.homescreen.ui.widget;

import com.deliveryhero.fluid.widgets.WidgetModelBuilder;
import com.talabat.fluid.homescreen.ui.widget.gem.GemModelBuilder;
import com.talabat.fluid.homescreen.ui.widget.orderstatus.OrderStatusModelBuilder;
import com.talabat.fluid.homescreen.ui.widget.ramadanclock.RamadanClockModelBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"addHomeScreenWidgetSerializers", "", "Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SerializersKt {
    public static final void addHomeScreenWidgetSerializers(@NotNull PolymorphicModuleBuilder<? super WidgetModelBuilder> polymorphicModuleBuilder) {
        Intrinsics.checkNotNullParameter(polymorphicModuleBuilder, "<this>");
        polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(RamadanClockModelBuilder.class), RamadanClockModelBuilder.Companion.serializer());
        polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(OrderStatusModelBuilder.class), OrderStatusModelBuilder.Companion.serializer());
        polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(GemModelBuilder.class), GemModelBuilder.Companion.serializer());
    }
}
