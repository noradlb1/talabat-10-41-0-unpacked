package com.talabat.cuisines;

import com.talabat.cuisines.domain.CuisinesRepository;
import com.talabat.cuisines.navigation.CuisinesLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000bH\u0004J\u0011\u0010\f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0004R\u001c\u0010\u0003\u001a\u00020\u00008\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0004\u0010\u0002\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/talabat/cuisines/CuisinesIntegrator;", "", "()V", "set", "getSet$annotations", "getSet", "()Lcom/talabat/cuisines/CuisinesIntegrator;", "isLoggerInitialized", "", "logger", "", "Lcom/talabat/cuisines/navigation/CuisinesLogger;", "repository", "Lcom/talabat/cuisines/domain/CuisinesRepository;", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisinesIntegrator {
    @NotNull
    public static final CuisinesIntegrator INSTANCE;
    @NotNull
    private static final CuisinesIntegrator set;

    static {
        CuisinesIntegrator cuisinesIntegrator = new CuisinesIntegrator();
        INSTANCE = cuisinesIntegrator;
        set = cuisinesIntegrator;
    }

    private CuisinesIntegrator() {
    }

    @IntegrationDsl
    public static /* synthetic */ void getSet$annotations() {
    }

    @NotNull
    public final CuisinesIntegrator getSet() {
        return set;
    }

    public final boolean isLoggerInitialized() {
        return CuisinesIntegratorKt.Logger != null;
    }

    @IntegrationDsl
    public final void logger(@NotNull CuisinesLogger cuisinesLogger) {
        Intrinsics.checkNotNullParameter(cuisinesLogger, "logger");
        CuisinesIntegratorKt.Logger = cuisinesLogger;
    }

    @IntegrationDsl
    public final void repository(@NotNull CuisinesRepository cuisinesRepository) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "repository");
        CuisinesIntegratorKt.Repository = cuisinesRepository;
    }
}
