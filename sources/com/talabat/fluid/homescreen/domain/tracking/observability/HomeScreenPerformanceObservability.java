package com.talabat.fluid.homescreen.domain.tracking.observability;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\bf\u0018\u0000 \r2\u00020\u0001:\u0003\r\u000e\u000fJ\b\u0010\u0002\u001a\u00020\u0003H&J.\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH&J.\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH&J.\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH&¨\u0006\u0010"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "", "generateTraceId", "", "traceEnd", "level", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability$Level;", "eventName", "", "extraAttributes", "", "traceEvent", "traceStart", "Companion", "HomeScreenPerformanceObservabilityAccessException", "Level", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface HomeScreenPerformanceObservability {
    @NotNull
    public static final String ATTRIBUTE_NUMBER_OF_COMPONENTS = "numberOfComponents";
    @NotNull
    public static final String ATTRIBUTE_TEMPLATE_HASH = "templateHash";
    @NotNull
    public static final String ATTRIBUTE_TEMPLATE_ID = "templateId";
    @NotNull
    public static final Companion Companion = Companion.f59719a;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability$Companion;", "", "()V", "ATTRIBUTE_NUMBER_OF_COMPONENTS", "", "ATTRIBUTE_TEMPLATE_HASH", "ATTRIBUTE_TEMPLATE_ID", "instance", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "getInstance$com_talabat_NewArchi_Homescreen_Homescreen", "()Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "setInstance$com_talabat_NewArchi_Homescreen_Homescreen", "(Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;)V", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        @NotNull
        public static final String ATTRIBUTE_NUMBER_OF_COMPONENTS = "numberOfComponents";
        @NotNull
        public static final String ATTRIBUTE_TEMPLATE_HASH = "templateHash";
        @NotNull
        public static final String ATTRIBUTE_TEMPLATE_ID = "templateId";

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f59719a = new Companion();
        @Nullable
        private static HomeScreenPerformanceObservability instance;

        private Companion() {
        }

        @Nullable
        public final HomeScreenPerformanceObservability getInstance$com_talabat_NewArchi_Homescreen_Homescreen() {
            return instance;
        }

        public final void setInstance$com_talabat_NewArchi_Homescreen_Homescreen(@Nullable HomeScreenPerformanceObservability homeScreenPerformanceObservability) {
            instance = homeScreenPerformanceObservability;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void traceEnd$default(HomeScreenPerformanceObservability homeScreenPerformanceObservability, Level level, String str, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                homeScreenPerformanceObservability.traceEnd(level, str, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: traceEnd");
        }

        public static /* synthetic */ void traceEvent$default(HomeScreenPerformanceObservability homeScreenPerformanceObservability, Level level, String str, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                homeScreenPerformanceObservability.traceEvent(level, str, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: traceEvent");
        }

        public static /* synthetic */ void traceStart$default(HomeScreenPerformanceObservability homeScreenPerformanceObservability, Level level, String str, Map map, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                homeScreenPerformanceObservability.traceStart(level, str, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: traceStart");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability$HomeScreenPerformanceObservabilityAccessException;", "", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HomeScreenPerformanceObservabilityAccessException extends Throwable {
        @Nullable
        private final String message;

        public HomeScreenPerformanceObservabilityAccessException(@Nullable String str) {
            this.message = str;
        }

        @Nullable
        public String getMessage() {
            return this.message;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability$Level;", "", "(Ljava/lang/String;I)V", "INFO", "DEBUG", "WARNING", "ERROR", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Level {
        INFO,
        DEBUG,
        WARNING,
        ERROR
    }

    void generateTraceId();

    void traceEnd(@NotNull Level level, @NotNull String str, @NotNull Map<String, String> map);

    void traceEvent(@NotNull Level level, @NotNull String str, @NotNull Map<String, String> map);

    void traceStart(@NotNull Level level, @NotNull String str, @NotNull Map<String, String> map);
}
