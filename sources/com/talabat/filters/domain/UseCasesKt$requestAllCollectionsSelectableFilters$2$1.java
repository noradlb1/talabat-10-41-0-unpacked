package com.talabat.filters.domain;

import datamodels.filters.SelectableFilter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Ldatamodels/filters/SelectableFilter;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt$requestAllCollectionsSelectableFilters$2$1", f = "UseCases.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2}, l = {137, 138, 139}, m = "invokeSuspend", n = {"restaurants", "selectedCollectionId", "selectedFilters", "restaurants", "selectedCollectionId", "selectedFilters", "destination$iv$iv", "element$iv$iv", "selectedFilters", "destination$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$5", "L$0", "L$1"})
public final class UseCasesKt$requestAllCollectionsSelectableFilters$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SelectableFilter>>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f59467h;

    /* renamed from: i  reason: collision with root package name */
    public Object f59468i;

    /* renamed from: j  reason: collision with root package name */
    public Object f59469j;

    /* renamed from: k  reason: collision with root package name */
    public Object f59470k;

    /* renamed from: l  reason: collision with root package name */
    public Object f59471l;

    /* renamed from: m  reason: collision with root package name */
    public int f59472m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ FiltersRepository f59473n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UseCasesKt$requestAllCollectionsSelectableFilters$2$1(FiltersRepository filtersRepository, Continuation<? super UseCasesKt$requestAllCollectionsSelectableFilters$2$1> continuation) {
        super(2, continuation);
        this.f59473n = filtersRepository;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UseCasesKt$requestAllCollectionsSelectableFilters$2$1 useCasesKt$requestAllCollectionsSelectableFilters$2$1 = new UseCasesKt$requestAllCollectionsSelectableFilters$2$1(this.f59473n, continuation);
        useCasesKt$requestAllCollectionsSelectableFilters$2$1.L$0 = obj;
        return useCasesKt$requestAllCollectionsSelectableFilters$2$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<SelectableFilter>> continuation) {
        return ((UseCasesKt$requestAllCollectionsSelectableFilters$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0161  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59472m
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x006e
            if (r2 == r5) goto L_0x005b
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r2 = r0.f59470k
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r4 = r0.f59469j
            datamodels.Filter r4 = (datamodels.Filter) r4
            java.lang.Object r5 = r0.f59468i
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r7 = r0.f59467h
            java.util.Collection r7 = (java.util.Collection) r7
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.Deferred r8 = (kotlinx.coroutines.Deferred) r8
            kotlin.ResultKt.throwOnFailure(r20)
            r9 = r3
            r3 = r7
            r10 = r8
            r7 = r20
            r8 = r5
            r5 = r4
            r4 = r0
            goto L_0x0153
        L_0x0035:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003d:
            java.lang.Object r2 = r0.f59471l
            java.lang.Object r5 = r0.f59470k
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r7 = r0.f59469j
            java.util.Collection r7 = (java.util.Collection) r7
            java.lang.Object r8 = r0.f59468i
            kotlinx.coroutines.Deferred r8 = (kotlinx.coroutines.Deferred) r8
            java.lang.Object r9 = r0.f59467h
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.Deferred r10 = (kotlinx.coroutines.Deferred) r10
            kotlin.ResultKt.throwOnFailure(r20)
            r11 = r20
            r3 = r0
            goto L_0x0101
        L_0x005b:
            java.lang.Object r2 = r0.f59468i
            kotlinx.coroutines.Deferred r2 = (kotlinx.coroutines.Deferred) r2
            java.lang.Object r5 = r0.f59467h
            java.lang.Integer r5 = (java.lang.Integer) r5
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.Deferred r7 = (kotlinx.coroutines.Deferred) r7
            kotlin.ResultKt.throwOnFailure(r20)
            r3 = r5
            r5 = r20
            goto L_0x00ca
        L_0x006e:
            kotlin.ResultKt.throwOnFailure(r20)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            com.talabat.filters.domain.UseCasesKt$requestAllCollectionsSelectableFilters$2$1$filters$1 r12 = new com.talabat.filters.domain.UseCasesKt$requestAllCollectionsSelectableFilters$2$1$filters$1
            com.talabat.filters.domain.FiltersRepository r7 = r0.f59473n
            r12.<init>(r7, r6)
            r13 = 15
            r14 = 0
            r7 = r2
            kotlinx.coroutines.Deferred r15 = com.talabat.talabatcommon.extentions.CoroutinesKt.asyncCatching$default(r7, r8, r9, r10, r11, r12, r13, r14)
            com.talabat.filters.domain.UseCasesKt$requestAllCollectionsSelectableFilters$2$1$restaurants$1 r12 = new com.talabat.filters.domain.UseCasesKt$requestAllCollectionsSelectableFilters$2$1$restaurants$1
            com.talabat.filters.domain.FiltersRepository r7 = r0.f59473n
            r12.<init>(r7, r6)
            r7 = r2
            kotlinx.coroutines.Deferred r14 = com.talabat.talabatcommon.extentions.CoroutinesKt.asyncCatching$default(r7, r8, r9, r10, r11, r12, r13, r14)
            com.talabat.filters.domain.FiltersRepository r7 = r0.f59473n
            java.lang.Integer r13 = r7.requestSelectedCollectionId()
            com.talabat.filters.domain.UseCasesKt$requestAllCollectionsSelectableFilters$2$1$selectedFilters$1 r12 = new com.talabat.filters.domain.UseCasesKt$requestAllCollectionsSelectableFilters$2$1$selectedFilters$1
            com.talabat.filters.domain.FiltersRepository r7 = r0.f59473n
            r12.<init>(r7, r6)
            r16 = 15
            r17 = 0
            r7 = r2
            r2 = r13
            r13 = r16
            r3 = r14
            r14 = r17
            kotlinx.coroutines.Deferred r7 = com.talabat.talabatcommon.extentions.CoroutinesKt.asyncCatching$default(r7, r8, r9, r10, r11, r12, r13, r14)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r0.L$0 = r3
            r0.f59467h = r2
            r0.f59468i = r7
            r0.f59472m = r5
            java.lang.Object r5 = com.talabat.talabatcommon.extentions.CoroutinesKt.await(r15, r8, r0)
            if (r5 != r1) goto L_0x00c4
            return r1
        L_0x00c4:
            r18 = r3
            r3 = r2
            r2 = r7
            r7 = r18
        L_0x00ca:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r5 = r5.iterator()
            r9 = r3
            r10 = r7
            r7 = r8
            r8 = r2
            r2 = r0
        L_0x00da:
            boolean r3 = r5.hasNext()
            if (r3 == 0) goto L_0x010e
            java.lang.Object r3 = r5.next()
            r11 = r3
            datamodels.Filter r11 = (datamodels.Filter) r11
            r2.L$0 = r10
            r2.f59467h = r9
            r2.f59468i = r8
            r2.f59469j = r7
            r2.f59470k = r5
            r2.f59471l = r3
            r2.f59472m = r4
            java.lang.Object r11 = com.talabat.filters.domain.UseCasesKt.withFiltersAndCollectionIds(r10, r11, r9, r2)
            if (r11 != r1) goto L_0x00fc
            return r1
        L_0x00fc:
            r18 = r3
            r3 = r2
            r2 = r18
        L_0x0101:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x010c
            r7.add(r2)
        L_0x010c:
            r2 = r3
            goto L_0x00da
        L_0x010e:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r7, r4)
            r3.<init>(r4)
            java.util.Iterator r4 = r7.iterator()
            r5 = r4
            r18 = r3
            r3 = r2
            r2 = r18
        L_0x0127:
            boolean r4 = r5.hasNext()
            if (r4 == 0) goto L_0x0161
            java.lang.Object r4 = r5.next()
            datamodels.Filter r4 = (datamodels.Filter) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r3.L$0 = r8
            r3.f59467h = r2
            r3.f59468i = r5
            r3.f59469j = r4
            r3.f59470k = r2
            r3.f59471l = r6
            r9 = 3
            r3.f59472m = r9
            java.lang.Object r7 = com.talabat.talabatcommon.extentions.CoroutinesKt.await(r8, r7, r3)
            if (r7 != r1) goto L_0x014e
            return r1
        L_0x014e:
            r10 = r8
            r8 = r5
            r5 = r4
            r4 = r3
            r3 = r2
        L_0x0153:
            java.util.List r7 = (java.util.List) r7
            datamodels.filters.SelectableFilter r5 = com.talabat.filters.domain.UseCasesKt.toSelectableFilter(r5, r7)
            r2.add(r5)
            r2 = r3
            r3 = r4
            r5 = r8
            r8 = r10
            goto L_0x0127
        L_0x0161:
            java.util.List r2 = (java.util.List) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.filters.domain.UseCasesKt$requestAllCollectionsSelectableFilters$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
