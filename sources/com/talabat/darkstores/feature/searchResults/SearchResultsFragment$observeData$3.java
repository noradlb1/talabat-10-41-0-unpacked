package com.talabat.darkstores.feature.searchResults;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.darkstores.feature.searchResults.SearchResultsFragment$observeData$3", f = "SearchResultsFragment.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
public final class SearchResultsFragment$observeData$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f56595h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SearchResultsFragment f56596i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H@"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "com.talabat.darkstores.feature.searchResults.SearchResultsFragment$observeData$3$1", f = "SearchResultsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.talabat.darkstores.feature.searchResults.SearchResultsFragment$observeData$3$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f56597h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ Object f56598i;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(searchResultsFragment, continuation);
            r02.f56598i = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@Nullable String str, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f56597h == 0) {
                ResultKt.throwOnFailure(obj);
                String str = (String) this.f56598i;
                SearchResultsProductsListAdapter access$getProductsListAdapter$p = searchResultsFragment.productsListAdapter;
                if (access$getProductsListAdapter$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("productsListAdapter");
                    access$getProductsListAdapter$p = null;
                }
                access$getProductsListAdapter$p.changeCategorySelection(str);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchResultsFragment$observeData$3(SearchResultsFragment searchResultsFragment, Continuation<? super SearchResultsFragment$observeData$3> continuation) {
        super(2, continuation);
        this.f56596i = searchResultsFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SearchResultsFragment$observeData$3(this.f56596i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SearchResultsFragment$observeData$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f56595h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<String> currentCategoryId = this.f56596i.getViewModel().getCurrentCategoryId();
            final SearchResultsFragment searchResultsFragment = this.f56596i;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f56595h = 1;
            if (FlowKt.collectLatest(currentCategoryId, r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
