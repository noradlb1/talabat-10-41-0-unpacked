package com.talabat.restaurants.v2.domain.vendors;

import buisnessmodels.FilterEngine;
import datamodels.filters.SelectablePopularFilter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ApplyVendorListFiltersUseCaseKt$applyFilters$1 extends Lambda implements Function0<Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FilterEngine f61243g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<SelectablePopularFilter> f61244h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApplyVendorListFiltersUseCaseKt$applyFilters$1(FilterEngine filterEngine, List<SelectablePopularFilter> list) {
        super(0);
        this.f61243g = filterEngine;
        this.f61244h = list;
    }

    @NotNull
    public final Boolean invoke() {
        return Boolean.valueOf(ApplyVendorListFiltersUseCaseKt.isAnyFilterApplied(this.f61243g, this.f61244h));
    }
}
