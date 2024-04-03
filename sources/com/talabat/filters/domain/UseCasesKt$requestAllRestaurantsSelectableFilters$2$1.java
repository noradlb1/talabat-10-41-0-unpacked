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
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt$requestAllRestaurantsSelectableFilters$2$1", f = "UseCases.kt", i = {0, 0, 1, 1, 1, 1, 2, 2}, l = {115, 116, 117}, m = "invokeSuspend", n = {"restaurants", "selectedFilters", "restaurants", "selectedFilters", "destination$iv$iv", "element$iv$iv", "selectedFilters", "destination$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$4", "L$0", "L$1"})
public final class UseCasesKt$requestAllRestaurantsSelectableFilters$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SelectableFilter>>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f59490h;

    /* renamed from: i  reason: collision with root package name */
    public Object f59491i;

    /* renamed from: j  reason: collision with root package name */
    public Object f59492j;

    /* renamed from: k  reason: collision with root package name */
    public Object f59493k;

    /* renamed from: l  reason: collision with root package name */
    public int f59494l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FiltersRepository f59495m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UseCasesKt$requestAllRestaurantsSelectableFilters$2$1(FiltersRepository filtersRepository, Continuation<? super UseCasesKt$requestAllRestaurantsSelectableFilters$2$1> continuation) {
        super(2, continuation);
        this.f59495m = filtersRepository;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UseCasesKt$requestAllRestaurantsSelectableFilters$2$1 useCasesKt$requestAllRestaurantsSelectableFilters$2$1 = new UseCasesKt$requestAllRestaurantsSelectableFilters$2$1(this.f59495m, continuation);
        useCasesKt$requestAllRestaurantsSelectableFilters$2$1.L$0 = obj;
        return useCasesKt$requestAllRestaurantsSelectableFilters$2$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<SelectableFilter>> continuation) {
        return ((UseCasesKt$requestAllRestaurantsSelectableFilters$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x014a  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59494l
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0066
            if (r2 == r5) goto L_0x0057
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r2 = r0.f59493k
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r4 = r0.f59492j
            datamodels.Filter r4 = (datamodels.Filter) r4
            java.lang.Object r5 = r0.f59491i
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r0.f59490h
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.Deferred r7 = (kotlinx.coroutines.Deferred) r7
            kotlin.ResultKt.throwOnFailure(r18)
            r8 = r18
            r9 = r7
            r7 = r5
            r5 = r0
            goto L_0x013c
        L_0x0031:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0039:
            java.lang.Object r2 = r0.f59493k
            java.lang.Object r5 = r0.f59492j
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r0.f59491i
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.Object r7 = r0.f59490h
            kotlinx.coroutines.Deferred r7 = (kotlinx.coroutines.Deferred) r7
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.Deferred r8 = (kotlinx.coroutines.Deferred) r8
            kotlin.ResultKt.throwOnFailure(r18)
            r10 = r18
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r0
            goto L_0x00ea
        L_0x0057:
            java.lang.Object r2 = r0.f59490h
            kotlinx.coroutines.Deferred r2 = (kotlinx.coroutines.Deferred) r2
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.Deferred r5 = (kotlinx.coroutines.Deferred) r5
            kotlin.ResultKt.throwOnFailure(r18)
            r6 = r5
            r5 = r18
            goto L_0x00b2
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            com.talabat.filters.domain.UseCasesKt$requestAllRestaurantsSelectableFilters$2$1$filters$1 r11 = new com.talabat.filters.domain.UseCasesKt$requestAllRestaurantsSelectableFilters$2$1$filters$1
            com.talabat.filters.domain.FiltersRepository r6 = r0.f59495m
            r14 = 0
            r11.<init>(r6, r14)
            r12 = 15
            r13 = 0
            r6 = r2
            kotlinx.coroutines.Deferred r15 = com.talabat.talabatcommon.extentions.CoroutinesKt.asyncCatching$default(r6, r7, r8, r9, r10, r11, r12, r13)
            com.talabat.filters.domain.UseCasesKt$requestAllRestaurantsSelectableFilters$2$1$restaurants$1 r11 = new com.talabat.filters.domain.UseCasesKt$requestAllRestaurantsSelectableFilters$2$1$restaurants$1
            com.talabat.filters.domain.FiltersRepository r6 = r0.f59495m
            r11.<init>(r6, r14)
            r6 = r2
            kotlinx.coroutines.Deferred r13 = com.talabat.talabatcommon.extentions.CoroutinesKt.asyncCatching$default(r6, r7, r8, r9, r10, r11, r12, r13)
            com.talabat.filters.domain.UseCasesKt$requestAllRestaurantsSelectableFilters$2$1$selectedFilters$1 r11 = new com.talabat.filters.domain.UseCasesKt$requestAllRestaurantsSelectableFilters$2$1$selectedFilters$1
            com.talabat.filters.domain.FiltersRepository r6 = r0.f59495m
            r11.<init>(r6, r14)
            r6 = r2
            r2 = r13
            r13 = r14
            kotlinx.coroutines.Deferred r6 = com.talabat.talabatcommon.extentions.CoroutinesKt.asyncCatching$default(r6, r7, r8, r9, r10, r11, r12, r13)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r0.L$0 = r2
            r0.f59490h = r6
            r0.f59494l = r5
            java.lang.Object r5 = com.talabat.talabatcommon.extentions.CoroutinesKt.await(r15, r7, r0)
            if (r5 != r1) goto L_0x00ad
            return r1
        L_0x00ad:
            r16 = r6
            r6 = r2
            r2 = r16
        L_0x00b2:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r5 = r5.iterator()
            r8 = r6
            r6 = r7
            r7 = r2
            r2 = r0
        L_0x00c1:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x00fb
            java.lang.Object r9 = r5.next()
            r10 = r9
            datamodels.Filter r10 = (datamodels.Filter) r10
            r2.L$0 = r8
            r2.f59490h = r7
            r2.f59491i = r6
            r2.f59492j = r5
            r2.f59493k = r9
            r2.f59494l = r4
            java.lang.Object r10 = com.talabat.filters.domain.UseCasesKt.withFilterIds(r8, r10, r2)
            if (r10 != r1) goto L_0x00e1
            return r1
        L_0x00e1:
            r16 = r5
            r5 = r2
            r2 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r16
        L_0x00ea:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00f5
            r7.add(r2)
        L_0x00f5:
            r2 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            goto L_0x00c1
        L_0x00fb:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r6, r5)
            r4.<init>(r5)
            java.util.Iterator r5 = r6.iterator()
            r16 = r4
            r4 = r2
            r2 = r16
        L_0x0113:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x014a
            java.lang.Object r6 = r5.next()
            datamodels.Filter r6 = (datamodels.Filter) r6
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r4.L$0 = r7
            r4.f59490h = r2
            r4.f59491i = r5
            r4.f59492j = r6
            r4.f59493k = r2
            r4.f59494l = r3
            java.lang.Object r8 = com.talabat.talabatcommon.extentions.CoroutinesKt.await(r7, r8, r4)
            if (r8 != r1) goto L_0x0137
            return r1
        L_0x0137:
            r9 = r7
            r7 = r5
            r5 = r4
            r4 = r6
            r6 = r2
        L_0x013c:
            java.util.List r8 = (java.util.List) r8
            datamodels.filters.SelectableFilter r4 = com.talabat.filters.domain.UseCasesKt.toSelectableFilter(r4, r8)
            r2.add(r4)
            r4 = r5
            r2 = r6
            r5 = r7
            r7 = r9
            goto L_0x0113
        L_0x014a:
            java.util.List r2 = (java.util.List) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.filters.domain.UseCasesKt$requestAllRestaurantsSelectableFilters$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
