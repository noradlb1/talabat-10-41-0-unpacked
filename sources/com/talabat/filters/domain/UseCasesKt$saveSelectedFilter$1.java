package com.talabat.filters.domain;

import datamodels.Filter;
import datamodels.filters.SelectableFilter;
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
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt", f = "UseCases.kt", i = {}, l = {246}, m = "saveSelectedFilter", n = {}, s = {})
public final class UseCasesKt$saveSelectedFilter$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f59541h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f59542i;

    /* renamed from: j  reason: collision with root package name */
    public int f59543j;

    public UseCasesKt$saveSelectedFilter$1(Continuation<? super UseCasesKt$saveSelectedFilter$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59542i = obj;
        this.f59543j |= Integer.MIN_VALUE;
        return UseCasesKt.saveSelectedFilter((List<SelectableFilter>) null, (Function2<? super List<? extends Filter>, ? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
