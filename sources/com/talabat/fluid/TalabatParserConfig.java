package com.talabat.fluid;

import android.content.Context;
import com.deliveryhero.fluid.ParseConfig;
import com.deliveryhero.fluid.expression.reference.providers.ValueProviders;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.profile.Profiler;
import com.deliveryhero.fluid.widgets.WidgetModelBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.modules.PolymorphicModuleBuilder;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BT\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u001f\b\u0002\u0010\n\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\u0002\b\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/talabat/fluid/TalabatParserConfig;", "Lcom/deliveryhero/fluid/ParseConfig;", "context", "Landroid/content/Context;", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "profiler", "Lcom/deliveryhero/fluid/telemetry/profile/Profiler;", "valueProviders", "Lcom/deliveryhero/fluid/expression/reference/providers/ValueProviders;", "customWidgetRegisterer", "Lkotlin/Function1;", "Lkotlinx/serialization/modules/PolymorphicModuleBuilder;", "Lcom/deliveryhero/fluid/widgets/WidgetModelBuilder;", "", "Lkotlin/ExtensionFunctionType;", "serialFormat", "Lkotlinx/serialization/SerialFormat;", "(Landroid/content/Context;Lcom/deliveryhero/fluid/telemetry/log/Logger;Lcom/deliveryhero/fluid/telemetry/profile/Profiler;Lcom/deliveryhero/fluid/expression/reference/providers/ValueProviders;Lkotlin/jvm/functions/Function1;Lkotlinx/serialization/SerialFormat;)V", "com_talabat_ThirdPartyLibs_Fluid_Fluid"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatParserConfig extends ParseConfig {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TalabatParserConfig(android.content.Context r14, com.deliveryhero.fluid.telemetry.log.Logger r15, com.deliveryhero.fluid.telemetry.profile.Profiler r16, com.deliveryhero.fluid.expression.reference.providers.ValueProviders r17, kotlin.jvm.functions.Function1 r18, kotlinx.serialization.SerialFormat r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r13 = this;
            r0 = r20 & 4
            if (r0 == 0) goto L_0x000d
            com.deliveryhero.fluid.telemetry.profile.Profiler$Companion r0 = com.deliveryhero.fluid.telemetry.profile.Profiler.Companion
            r3 = r15
            com.deliveryhero.fluid.telemetry.profile.SimpleClockProfiler r0 = r0.createDefault(r15)
            r4 = r0
            goto L_0x0010
        L_0x000d:
            r3 = r15
            r4 = r16
        L_0x0010:
            r0 = r20 & 8
            if (r0 == 0) goto L_0x001c
            com.talabat.fluid.theme.MarshmallowValueProvider r0 = new com.talabat.fluid.theme.MarshmallowValueProvider
            r2 = r14
            r0.<init>(r14)
            r5 = r0
            goto L_0x001f
        L_0x001c:
            r2 = r14
            r5 = r17
        L_0x001f:
            r0 = r20 & 16
            if (r0 == 0) goto L_0x0026
            com.talabat.fluid.TalabatParserConfig$1 r0 = com.talabat.fluid.TalabatParserConfig.AnonymousClass1.INSTANCE
            goto L_0x0028
        L_0x0026:
            r0 = r18
        L_0x0028:
            r1 = r20 & 32
            if (r1 == 0) goto L_0x0045
            com.deliveryhero.fluid.serialization.JsonFormatProvider r6 = com.deliveryhero.fluid.serialization.JsonFormatProvider.INSTANCE
            java.lang.Class<com.talabat.fluid.EmptyTrackingModel> r1 = com.talabat.fluid.EmptyTrackingModel.class
            kotlin.reflect.KType r1 = kotlin.jvm.internal.Reflection.typeOf((java.lang.Class) r1)
            kotlinx.serialization.KSerializer r7 = kotlinx.serialization.SerializersKt.serializer((kotlin.reflect.KType) r1)
            kotlinx.serialization.json.Json$Default r8 = kotlinx.serialization.json.Json.Default
            r10 = 0
            r11 = 8
            r12 = 0
            r9 = r0
            kotlinx.serialization.json.Json r1 = com.deliveryhero.fluid.serialization.JsonFormatProvider.get$default(r6, r7, r8, r9, r10, r11, r12)
            r7 = r1
            goto L_0x0047
        L_0x0045:
            r7 = r19
        L_0x0047:
            r1 = r13
            r2 = r14
            r3 = r15
            r6 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.TalabatParserConfig.<init>(android.content.Context, com.deliveryhero.fluid.telemetry.log.Logger, com.deliveryhero.fluid.telemetry.profile.Profiler, com.deliveryhero.fluid.expression.reference.providers.ValueProviders, kotlin.jvm.functions.Function1, kotlinx.serialization.SerialFormat, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatParserConfig(@NotNull Context context, @NotNull Logger logger, @NotNull Profiler profiler, @NotNull ValueProviders valueProviders, @NotNull Function1<? super PolymorphicModuleBuilder<? super WidgetModelBuilder>, Unit> function1, @NotNull SerialFormat serialFormat) {
        super(context, logger, profiler, serialFormat, valueProviders);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(profiler, "profiler");
        Intrinsics.checkNotNullParameter(valueProviders, "valueProviders");
        Intrinsics.checkNotNullParameter(function1, "customWidgetRegisterer");
        Intrinsics.checkNotNullParameter(serialFormat, "serialFormat");
    }
}
