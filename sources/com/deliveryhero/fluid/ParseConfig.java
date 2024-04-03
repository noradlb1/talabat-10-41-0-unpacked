package com.deliveryhero.fluid;

import android.content.Context;
import com.deliveryhero.fluid.expression.reference.providers.ValueProviders;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.deliveryhero.fluid.telemetry.profile.Profiler;
import com.deliveryhero.fluid.values.providers.CoreValueProviders;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialFormat;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/deliveryhero/fluid/ParseConfig;", "", "context", "Landroid/content/Context;", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "profiler", "Lcom/deliveryhero/fluid/telemetry/profile/Profiler;", "serialFormat", "Lkotlinx/serialization/SerialFormat;", "valueProviders", "Lcom/deliveryhero/fluid/expression/reference/providers/ValueProviders;", "(Landroid/content/Context;Lcom/deliveryhero/fluid/telemetry/log/Logger;Lcom/deliveryhero/fluid/telemetry/profile/Profiler;Lkotlinx/serialization/SerialFormat;Lcom/deliveryhero/fluid/expression/reference/providers/ValueProviders;)V", "getContext", "()Landroid/content/Context;", "getLogger", "()Lcom/deliveryhero/fluid/telemetry/log/Logger;", "getProfiler", "()Lcom/deliveryhero/fluid/telemetry/profile/Profiler;", "getSerialFormat", "()Lkotlinx/serialization/SerialFormat;", "getValueProviders", "()Lcom/deliveryhero/fluid/expression/reference/providers/ValueProviders;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ParseConfig {
    @NotNull
    private final Context context;
    @NotNull
    private final Logger logger;
    @NotNull
    private final Profiler profiler;
    @NotNull
    private final SerialFormat serialFormat;
    @NotNull
    private final ValueProviders valueProviders;

    public ParseConfig(@NotNull Context context2, @NotNull Logger logger2, @NotNull Profiler profiler2, @NotNull SerialFormat serialFormat2, @NotNull ValueProviders valueProviders2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(profiler2, "profiler");
        Intrinsics.checkNotNullParameter(serialFormat2, "serialFormat");
        Intrinsics.checkNotNullParameter(valueProviders2, "valueProviders");
        this.context = context2;
        this.logger = logger2;
        this.profiler = profiler2;
        this.serialFormat = serialFormat2;
        this.valueProviders = valueProviders2;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final Logger getLogger() {
        return this.logger;
    }

    @NotNull
    public final Profiler getProfiler() {
        return this.profiler;
    }

    @NotNull
    public final SerialFormat getSerialFormat() {
        return this.serialFormat;
    }

    @NotNull
    public final ValueProviders getValueProviders() {
        return this.valueProviders;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ParseConfig(Context context2, Logger logger2, Profiler profiler2, SerialFormat serialFormat2, ValueProviders valueProviders2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, logger2, (i11 & 4) != 0 ? Profiler.Companion.createDefault(logger2) : profiler2, serialFormat2, (i11 & 16) != 0 ? new CoreValueProviders(context2) : valueProviders2);
    }
}
