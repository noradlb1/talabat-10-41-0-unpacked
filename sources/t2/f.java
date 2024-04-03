package t2;

import androidx.annotation.RestrictTo;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.layout.WindowMetricsCalculator;
import androidx.window.layout.WindowMetricsCalculatorDecorator;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public final /* synthetic */ class f {
    static {
        WindowMetricsCalculator.Companion companion = WindowMetricsCalculator.Companion;
    }

    @JvmStatic
    @NotNull
    public static WindowMetricsCalculator a() {
        return WindowMetricsCalculator.Companion.getOrCreate();
    }

    @JvmStatic
    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void b(@NotNull WindowMetricsCalculatorDecorator windowMetricsCalculatorDecorator) {
        WindowMetricsCalculator.Companion.overrideDecorator(windowMetricsCalculatorDecorator);
    }

    @JvmStatic
    @ExperimentalWindowApi
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void c() {
        WindowMetricsCalculator.Companion.reset();
    }
}
