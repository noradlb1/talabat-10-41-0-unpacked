package com.talabat.cuisines.navigation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/cuisines/navigation/CuisinesLogger;", "", "displayErrorMessage", "", "throwable", "", "error", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CuisinesLogger {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void error(@NotNull CuisinesLogger cuisinesLogger, @NotNull Throwable th2) {
            Intrinsics.checkNotNullParameter(th2, "throwable");
            th2.printStackTrace();
        }
    }

    void displayErrorMessage(@NotNull Throwable th2);

    void error(@NotNull Throwable th2);
}
