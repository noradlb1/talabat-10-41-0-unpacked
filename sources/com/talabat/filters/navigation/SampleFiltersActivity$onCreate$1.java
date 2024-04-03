package com.talabat.filters.navigation;

import com.talabat.filters.FiltersIntegrator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/filters/FiltersIntegrator;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleFiltersActivity$onCreate$1 extends Lambda implements Function1<FiltersIntegrator, Unit> {
    public static final SampleFiltersActivity$onCreate$1 INSTANCE = new SampleFiltersActivity$onCreate$1();

    public SampleFiltersActivity$onCreate$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FiltersIntegrator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull FiltersIntegrator filtersIntegrator) {
        Intrinsics.checkNotNullParameter(filtersIntegrator, "$this$FiltersIntegration");
        filtersIntegrator.getSet().repository(FiltersRepositoryStubs.INSTANCE);
        filtersIntegrator.getSet().logger(Logger.INSTANCE);
    }
}
