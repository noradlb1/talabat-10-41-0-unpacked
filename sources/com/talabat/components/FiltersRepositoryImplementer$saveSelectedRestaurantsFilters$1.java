package com.talabat.components;

import datamodels.Filter;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.components.FiltersRepositoryImplementer", f = "Filters.kt", i = {}, l = {118}, m = "saveSelectedRestaurantsFilters", n = {}, s = {})
public final class FiltersRepositoryImplementer$saveSelectedRestaurantsFilters$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55695h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55696i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FiltersRepositoryImplementer f55697j;

    /* renamed from: k  reason: collision with root package name */
    public int f55698k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersRepositoryImplementer$saveSelectedRestaurantsFilters$1(FiltersRepositoryImplementer filtersRepositoryImplementer, Continuation<? super FiltersRepositoryImplementer$saveSelectedRestaurantsFilters$1> continuation) {
        super(continuation);
        this.f55697j = filtersRepositoryImplementer;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55696i = obj;
        this.f55698k |= Integer.MIN_VALUE;
        return this.f55697j.saveSelectedRestaurantsFilters((List<? extends Filter>) null, this);
    }
}
