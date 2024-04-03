package com.talabat.darkstores.feature.searchResults;

import androidx.paging.PagingData;
import com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.darkstores.feature.searchResults.SearchResultsFragment$observeData$1", f = "SearchResultsFragment.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
public final class SearchResultsFragment$observeData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f56590h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SearchResultsFragment f56591i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchResultsFragment$observeData$1(SearchResultsFragment searchResultsFragment, Continuation<? super SearchResultsFragment$observeData$1> continuation) {
        super(2, continuation);
        this.f56591i = searchResultsFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SearchResultsFragment$observeData$1(this.f56591i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SearchResultsFragment$observeData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f56590h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<PagingData<SearchPagingItem>> pagingData = this.f56591i.getViewModel().getPagingData();
            SearchResultsProductsListAdapter access$getProductsListAdapter$p = this.f56591i.productsListAdapter;
            if (access$getProductsListAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productsListAdapter");
                access$getProductsListAdapter$p = null;
            }
            AnonymousClass1 r12 = new FunctionReferenceImpl(access$getProductsListAdapter$p) {
                @Nullable
                public final Object invoke(@NotNull PagingData<SearchPagingItem> pagingData, @NotNull Continuation<? super Unit> continuation) {
                    return ((SearchResultsProductsListAdapter) this.receiver).submitData(pagingData, continuation);
                }
            };
            this.f56590h = 1;
            if (FlowKt.collectLatest(pagingData, r12, this) == coroutine_suspended) {
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
