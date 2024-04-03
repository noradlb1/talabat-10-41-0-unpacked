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
@DebugMetadata(c = "com.talabat.filters.domain.UseCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1", f = "UseCases.kt", i = {0, 1, 1}, l = {162, 163}, m = "invokeSuspend", n = {"selectedFilters", "selectedFilters", "destination$iv$iv"}, s = {"L$0", "L$0", "L$1"})
public final class UseCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends SelectableFilter>>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f59502h;

    /* renamed from: i  reason: collision with root package name */
    public Object f59503i;

    /* renamed from: j  reason: collision with root package name */
    public Object f59504j;

    /* renamed from: k  reason: collision with root package name */
    public Object f59505k;

    /* renamed from: l  reason: collision with root package name */
    public int f59506l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ FiltersRepository f59507m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UseCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1(FiltersRepository filtersRepository, Continuation<? super UseCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1> continuation) {
        super(2, continuation);
        this.f59507m = filtersRepository;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UseCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1 useCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1 = new UseCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1(this.f59507m, continuation);
        useCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1.L$0 = obj;
        return useCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<SelectableFilter>> continuation) {
        return ((UseCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0092  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.f59506l
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003d
            if (r1 == r3) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            java.lang.Object r1 = r14.f59505k
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.Object r3 = r14.f59504j
            datamodels.Filter r3 = (datamodels.Filter) r3
            java.lang.Object r4 = r14.f59503i
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r14.f59502h
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Object r6 = r14.L$0
            kotlinx.coroutines.Deferred r6 = (kotlinx.coroutines.Deferred) r6
            kotlin.ResultKt.throwOnFailure(r15)
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r14
            goto L_0x00b8
        L_0x002d:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0035:
            java.lang.Object r1 = r14.L$0
            kotlinx.coroutines.Deferred r1 = (kotlinx.coroutines.Deferred) r1
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0077
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            kotlinx.coroutines.CoroutineScope r15 = (kotlinx.coroutines.CoroutineScope) r15
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            com.talabat.filters.domain.UseCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1$filters$1 r9 = new com.talabat.filters.domain.UseCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1$filters$1
            com.talabat.filters.domain.FiltersRepository r1 = r14.f59507m
            r12 = 0
            r9.<init>(r1, r12)
            r10 = 15
            r11 = 0
            r4 = r15
            kotlinx.coroutines.Deferred r1 = com.talabat.talabatcommon.extentions.CoroutinesKt.asyncCatching$default(r4, r5, r6, r7, r8, r9, r10, r11)
            com.talabat.filters.domain.UseCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1$selectedFilters$1 r9 = new com.talabat.filters.domain.UseCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1$selectedFilters$1
            com.talabat.filters.domain.FiltersRepository r4 = r14.f59507m
            r9.<init>(r4, r12)
            r4 = r15
            kotlinx.coroutines.Deferred r15 = com.talabat.talabatcommon.extentions.CoroutinesKt.asyncCatching$default(r4, r5, r6, r7, r8, r9, r10, r11)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r14.L$0 = r15
            r14.f59506l = r3
            java.lang.Object r1 = com.talabat.talabatcommon.extentions.CoroutinesKt.await(r1, r4, r14)
            if (r1 != r0) goto L_0x0074
            return r0
        L_0x0074:
            r13 = r1
            r1 = r15
            r15 = r13
        L_0x0077:
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r15, r4)
            r3.<init>(r4)
            java.util.Iterator r15 = r15.iterator()
            r4 = r15
            r6 = r1
            r1 = r3
            r15 = r14
        L_0x008c:
            boolean r3 = r4.hasNext()
            if (r3 == 0) goto L_0x00c7
            java.lang.Object r3 = r4.next()
            datamodels.Filter r3 = (datamodels.Filter) r3
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r15.L$0 = r6
            r15.f59502h = r1
            r15.f59503i = r4
            r15.f59504j = r3
            r15.f59505k = r1
            r15.f59506l = r2
            java.lang.Object r5 = com.talabat.talabatcommon.extentions.CoroutinesKt.await(r6, r5, r15)
            if (r5 != r0) goto L_0x00b0
            return r0
        L_0x00b0:
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r15
            r15 = r5
            r5 = r3
        L_0x00b8:
            java.util.List r15 = (java.util.List) r15
            datamodels.filters.SelectableFilter r15 = com.talabat.filters.domain.UseCasesKt.toSelectableFilter(r4, r15)
            r3.add(r15)
            r15 = r0
            r0 = r1
            r1 = r5
            r4 = r6
            r6 = r7
            goto L_0x008c
        L_0x00c7:
            java.util.List r1 = (java.util.List) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.filters.domain.UseCasesKt$requestAllRestaurantsSelectableFiltersBEFiltration$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
