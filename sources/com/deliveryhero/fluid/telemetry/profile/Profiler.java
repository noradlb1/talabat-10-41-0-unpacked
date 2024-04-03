package com.deliveryhero.fluid.telemetry.profile;

import com.deliveryhero.fluid.telemetry.log.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ)\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H&¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/deliveryhero/fluid/telemetry/profile/Profiler;", "", "trace", "ResultT", "tag", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Profiler {
    @NotNull
    public static final Companion Companion = Companion.f30203a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/fluid/telemetry/profile/Profiler$Companion;", "", "()V", "createDefault", "Lcom/deliveryhero/fluid/telemetry/profile/SimpleClockProfiler;", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f30203a = new Companion();

        private Companion() {
        }

        @NotNull
        public final SimpleClockProfiler createDefault(@NotNull Logger logger) {
            Intrinsics.checkNotNullParameter(logger, "logger");
            return new SimpleClockProfiler(logger);
        }
    }

    <ResultT> ResultT trace(@NotNull String str, @NotNull Function0<? extends ResultT> function0);
}
