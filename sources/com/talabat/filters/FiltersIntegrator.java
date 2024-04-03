package com.talabat.filters;

import com.talabat.filters.domain.FiltersRepository;
import com.talabat.filters.navigation.FiltersLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\tH\u0004J\u0011\u0010\n\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0004R\u001c\u0010\u0003\u001a\u00020\u00008\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0004\u0010\u0002\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/talabat/filters/FiltersIntegrator;", "", "()V", "set", "getSet$annotations", "getSet", "()Lcom/talabat/filters/FiltersIntegrator;", "logger", "", "Lcom/talabat/filters/navigation/FiltersLogger;", "repository", "Lcom/talabat/filters/domain/FiltersRepository;", "com_talabat_Components_filters_filters"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FiltersIntegrator {
    @NotNull
    public static final FiltersIntegrator INSTANCE;
    @NotNull
    private static final FiltersIntegrator set;

    static {
        FiltersIntegrator filtersIntegrator = new FiltersIntegrator();
        INSTANCE = filtersIntegrator;
        set = filtersIntegrator;
    }

    private FiltersIntegrator() {
    }

    @IntegrationDsl
    public static /* synthetic */ void getSet$annotations() {
    }

    @NotNull
    public final FiltersIntegrator getSet() {
        return set;
    }

    @IntegrationDsl
    public final void logger(@NotNull FiltersLogger filtersLogger) {
        Intrinsics.checkNotNullParameter(filtersLogger, "logger");
        FiltersIntegratorKt.Logger = filtersLogger;
    }

    @IntegrationDsl
    public final void repository(@NotNull FiltersRepository filtersRepository) {
        Intrinsics.checkNotNullParameter(filtersRepository, "repository");
        FiltersIntegratorKt.Repository = filtersRepository;
    }
}
