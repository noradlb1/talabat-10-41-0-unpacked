package com.talabat.filters.domain;

import datamodels.filters.SelectableSortType;
import datamodels.filters.SortType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt", f = "UseCases.kt", i = {0}, l = {263, 264}, m = "saveSelectedSortType", n = {"save"}, s = {"L$0"})
public final class UseCasesKt$saveSelectedSortType$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59548h;

    /* renamed from: i  reason: collision with root package name */
    public Object f59549i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f59550j;

    /* renamed from: k  reason: collision with root package name */
    public int f59551k;

    public UseCasesKt$saveSelectedSortType$1(Continuation<? super UseCasesKt$saveSelectedSortType$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59550j = obj;
        this.f59551k |= Integer.MIN_VALUE;
        return UseCasesKt.saveSelectedSortType((List<SelectableSortType>) null, (Function2<? super SortType, ? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
