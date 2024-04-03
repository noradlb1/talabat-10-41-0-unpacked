package com.talabat.filters.domain;

import datamodels.filters.SelectableFilter;
import datamodels.filters.SelectablePopularFilter;
import datamodels.filters.SelectableSortType;
import datamodels.filters.Selectables;
import datamodels.filters.SortType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Ldatamodels/filters/Selectables;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt$requestSelectables$3", f = "UseCases.kt", i = {0, 0, 1}, l = {96, 97, 98}, m = "invokeSuspend", n = {"sorts", "popularFilters", "popularFilters"}, s = {"L$0", "L$1", "L$0"})
public final class UseCasesKt$requestSelectables$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Selectables>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f59521h;

    /* renamed from: i  reason: collision with root package name */
    public int f59522i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super List<SelectableFilter>>, Object> f59523j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super SortType>, Object> f59524k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super List<SelectableSortType>>, Object> f59525l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super List<SelectablePopularFilter>>, Object> f59526m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UseCasesKt$requestSelectables$3(Function1<? super Continuation<? super List<SelectableFilter>>, ? extends Object> function1, Function1<? super Continuation<? super SortType>, ? extends Object> function12, Function1<? super Continuation<? super List<SelectableSortType>>, ? extends Object> function13, Function1<? super Continuation<? super List<SelectablePopularFilter>>, ? extends Object> function14, Continuation<? super UseCasesKt$requestSelectables$3> continuation) {
        super(2, continuation);
        this.f59523j = function1;
        this.f59524k = function12;
        this.f59525l = function13;
        this.f59526m = function14;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UseCasesKt$requestSelectables$3 useCasesKt$requestSelectables$3 = new UseCasesKt$requestSelectables$3(this.f59523j, this.f59524k, this.f59525l, this.f59526m, continuation);
        useCasesKt$requestSelectables$3.L$0 = obj;
        return useCasesKt$requestSelectables$3;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Selectables> continuation) {
        return ((UseCasesKt$requestSelectables$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00cf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d0  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59522i
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r5) goto L_0x003a
            if (r2 == r4) goto L_0x002a
            if (r2 != r3) goto L_0x0022
            java.lang.Object r1 = r0.f59521h
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = r0.L$0
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.throwOnFailure(r18)
            r3 = r18
            goto L_0x00d1
        L_0x0022:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x002a:
            java.lang.Object r2 = r0.f59521h
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r4 = r0.L$0
            kotlinx.coroutines.Deferred r4 = (kotlinx.coroutines.Deferred) r4
            kotlin.ResultKt.throwOnFailure(r18)
            r5 = r4
            r4 = r18
            goto L_0x00bc
        L_0x003a:
            java.lang.Object r2 = r0.f59521h
            kotlinx.coroutines.Deferred r2 = (kotlinx.coroutines.Deferred) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.Deferred r5 = (kotlinx.coroutines.Deferred) r5
            kotlin.ResultKt.throwOnFailure(r18)
            r6 = r5
            r5 = r18
            goto L_0x00a3
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            com.talabat.filters.domain.UseCasesKt$requestSelectables$3$filters$1 r11 = new com.talabat.filters.domain.UseCasesKt$requestSelectables$3$filters$1
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super java.util.List<datamodels.filters.SelectableFilter>>, java.lang.Object> r6 = r0.f59523j
            r14 = 0
            r11.<init>(r6, r14)
            r12 = 15
            r13 = 0
            r6 = r2
            kotlinx.coroutines.Deferred r15 = com.talabat.talabatcommon.extentions.CoroutinesKt.asyncCatching$default(r6, r7, r8, r9, r10, r11, r12, r13)
            com.talabat.filters.domain.UseCasesKt$requestSelectables$3$selectedSortType$1 r11 = new com.talabat.filters.domain.UseCasesKt$requestSelectables$3$selectedSortType$1
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super datamodels.filters.SortType>, java.lang.Object> r6 = r0.f59524k
            r11.<init>(r6, r14)
            r6 = r2
            kotlinx.coroutines.Deferred r6 = com.talabat.talabatcommon.extentions.CoroutinesKt.asyncCatching$default(r6, r7, r8, r9, r10, r11, r12, r13)
            com.talabat.filters.domain.UseCasesKt$requestSelectables$3$sorts$1 r11 = new com.talabat.filters.domain.UseCasesKt$requestSelectables$3$sorts$1
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super java.util.List<datamodels.filters.SelectableSortType>>, java.lang.Object> r12 = r0.f59525l
            r11.<init>(r12, r6, r14)
            r12 = 15
            r6 = r2
            kotlinx.coroutines.Deferred r13 = com.talabat.talabatcommon.extentions.CoroutinesKt.asyncCatching$default(r6, r7, r8, r9, r10, r11, r12, r13)
            com.talabat.filters.domain.UseCasesKt$requestSelectables$3$popularFilters$1 r11 = new com.talabat.filters.domain.UseCasesKt$requestSelectables$3$popularFilters$1
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super java.util.List<datamodels.filters.SelectablePopularFilter>>, java.lang.Object> r6 = r0.f59526m
            r11.<init>(r6, r14)
            r6 = r2
            r2 = r13
            r13 = r14
            kotlinx.coroutines.Deferred r6 = com.talabat.talabatcommon.extentions.CoroutinesKt.asyncCatching$default(r6, r7, r8, r9, r10, r11, r12, r13)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r0.L$0 = r2
            r0.f59521h = r6
            r0.f59522i = r5
            java.lang.Object r5 = com.talabat.talabatcommon.extentions.CoroutinesKt.await(r15, r7, r0)
            if (r5 != r1) goto L_0x009e
            return r1
        L_0x009e:
            r16 = r6
            r6 = r2
            r2 = r16
        L_0x00a3:
            java.util.List r5 = (java.util.List) r5
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r0.L$0 = r2
            r0.f59521h = r5
            r0.f59522i = r4
            java.lang.Object r4 = com.talabat.talabatcommon.extentions.CoroutinesKt.await(r6, r7, r0)
            if (r4 != r1) goto L_0x00b7
            return r1
        L_0x00b7:
            r16 = r5
            r5 = r2
            r2 = r16
        L_0x00bc:
            java.util.List r4 = (java.util.List) r4
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r0.L$0 = r2
            r0.f59521h = r4
            r0.f59522i = r3
            java.lang.Object r3 = com.talabat.talabatcommon.extentions.CoroutinesKt.await(r5, r6, r0)
            if (r3 != r1) goto L_0x00d0
            return r1
        L_0x00d0:
            r1 = r4
        L_0x00d1:
            java.util.List r3 = (java.util.List) r3
            datamodels.filters.Selectables r4 = new datamodels.filters.Selectables
            r4.<init>(r2, r1, r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.filters.domain.UseCasesKt$requestSelectables$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
