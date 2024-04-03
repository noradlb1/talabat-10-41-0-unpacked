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
@DebugMetadata(c = "com.talabat.components.FiltersRepositoryImplementer", f = "Filters.kt", i = {}, l = {111}, m = "saveSelectedCollectionsFilters", n = {}, s = {})
public final class FiltersRepositoryImplementer$saveSelectedCollectionsFilters$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55691h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55692i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FiltersRepositoryImplementer f55693j;

    /* renamed from: k  reason: collision with root package name */
    public int f55694k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersRepositoryImplementer$saveSelectedCollectionsFilters$1(FiltersRepositoryImplementer filtersRepositoryImplementer, Continuation<? super FiltersRepositoryImplementer$saveSelectedCollectionsFilters$1> continuation) {
        super(continuation);
        this.f55693j = filtersRepositoryImplementer;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55692i = obj;
        this.f55694k |= Integer.MIN_VALUE;
        return this.f55693j.saveSelectedCollectionsFilters((List<? extends Filter>) null, this);
    }
}
