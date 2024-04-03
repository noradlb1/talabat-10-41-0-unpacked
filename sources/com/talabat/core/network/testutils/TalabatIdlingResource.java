package com.talabat.core.network.testutils;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.idling.CountingIdlingResource;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\u0006H\u0007J\b\u0010\u000b\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/core/network/testutils/TalabatIdlingResource;", "", "()V", "countingIdlingResource", "Landroidx/test/espresso/idling/CountingIdlingResource;", "busy", "", "name", "", "idle", "register", "unregister", "com_talabat_core_network_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatIdlingResource {
    @NotNull
    public static final TalabatIdlingResource INSTANCE = new TalabatIdlingResource();
    @NotNull
    private static final CountingIdlingResource countingIdlingResource = new CountingIdlingResource("CountingIdlingResource");

    private TalabatIdlingResource() {
    }

    @JvmStatic
    public static final void busy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        LogManager.debug("Making busy: " + str);
        countingIdlingResource.increment();
    }

    @JvmStatic
    public static final void idle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        LogManager.debug("Making idle: " + str);
        CountingIdlingResource countingIdlingResource2 = countingIdlingResource;
        if (!countingIdlingResource2.isIdleNow()) {
            countingIdlingResource2.decrement();
        }
    }

    @JvmStatic
    public static final void register() {
        IdlingRegistry.getInstance().register(countingIdlingResource);
    }

    @JvmStatic
    public static final void unregister() {
        IdlingRegistry.getInstance().unregister(countingIdlingResource);
    }
}
