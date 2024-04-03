package com.talabat.darkstores.feature.searchResults;

import android.view.View;
import android.widget.ProgressBar;
import androidx.paging.CombinedLoadStates;
import androidx.paging.LoadState;
import com.talabat.darkstores.R;
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
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.darkstores.feature.searchResults.SearchResultsFragment$observeData$2", f = "SearchResultsFragment.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
public final class SearchResultsFragment$observeData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f56592h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SearchResultsFragment f56593i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchResultsFragment$observeData$2(SearchResultsFragment searchResultsFragment, Continuation<? super SearchResultsFragment$observeData$2> continuation) {
        super(2, continuation);
        this.f56593i = searchResultsFragment;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SearchResultsFragment$observeData$2(this.f56593i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SearchResultsFragment$observeData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f56592h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SearchResultsProductsListAdapter access$getProductsListAdapter$p = this.f56593i.productsListAdapter;
            if (access$getProductsListAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productsListAdapter");
                access$getProductsListAdapter$p = null;
            }
            Flow<CombinedLoadStates> loadStateFlow = access$getProductsListAdapter$p.getLoadStateFlow();
            final SearchResultsFragment searchResultsFragment = this.f56593i;
            AnonymousClass1 r12 = new FlowCollector() {
                @Nullable
                public final Object emit(@NotNull CombinedLoadStates combinedLoadStates, @NotNull Continuation<? super Unit> continuation) {
                    SearchResultsProductsListAdapter access$getProductsListAdapter$p = searchResultsFragment.productsListAdapter;
                    SearchResultsProductsListAdapter searchResultsProductsListAdapter = null;
                    if (access$getProductsListAdapter$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("productsListAdapter");
                        access$getProductsListAdapter$p = null;
                    }
                    boolean z11 = true;
                    int i11 = 0;
                    boolean z12 = access$getProductsListAdapter$p.getItemCount() == 0;
                    ProgressBar progressBar = (ProgressBar) searchResultsFragment._$_findCachedViewById(R.id.progressBar);
                    Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
                    progressBar.setVisibility((combinedLoadStates.getRefresh() instanceof LoadState.Loading) && z12 ? 0 : 8);
                    View _$_findCachedViewById = searchResultsFragment._$_findCachedViewById(R.id.noResultsView);
                    Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "noResultsView");
                    if (!(combinedLoadStates.getAppend() instanceof LoadState.NotLoading) || !combinedLoadStates.getAppend().getEndOfPaginationReached() || !z12) {
                        z11 = false;
                    }
                    if (!z11) {
                        i11 = 8;
                    }
                    _$_findCachedViewById.setVisibility(i11);
                    if (!z12 && (combinedLoadStates.getAppend() instanceof LoadState.NotLoading)) {
                        SearchResultsFragmentViewModel access$getViewModel = searchResultsFragment.getViewModel();
                        SearchResultsProductsListAdapter access$getProductsListAdapter$p2 = searchResultsFragment.productsListAdapter;
                        if (access$getProductsListAdapter$p2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("productsListAdapter");
                        } else {
                            searchResultsProductsListAdapter = access$getProductsListAdapter$p2;
                        }
                        access$getViewModel.updateImpressionData(searchResultsProductsListAdapter.snapshot().getItems());
                    }
                    return Unit.INSTANCE;
                }
            };
            this.f56592h = 1;
            if (loadStateFlow.collect(r12, this) == coroutine_suspended) {
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
