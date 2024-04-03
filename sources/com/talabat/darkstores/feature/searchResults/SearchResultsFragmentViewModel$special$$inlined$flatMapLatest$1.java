package com.talabat.darkstores.feature.searchResults;

import androidx.paging.PagingData;
import com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H@¨\u0006\u0005"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel$special$$inlined$flatMapLatest$1", f = "SearchResultsFragmentViewModel.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
public final class SearchResultsFragmentViewModel$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super PagingData<SearchPagingItem>>, String, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f56608h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f56609i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SearchResultsFragmentViewModel f56610j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchResultsFragmentViewModel$special$$inlined$flatMapLatest$1(Continuation continuation, SearchResultsFragmentViewModel searchResultsFragmentViewModel) {
        super(3, continuation);
        this.f56610j = searchResultsFragmentViewModel;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super PagingData<SearchPagingItem>> flowCollector, String str, @Nullable Continuation<? super Unit> continuation) {
        SearchResultsFragmentViewModel$special$$inlined$flatMapLatest$1 searchResultsFragmentViewModel$special$$inlined$flatMapLatest$1 = new SearchResultsFragmentViewModel$special$$inlined$flatMapLatest$1(continuation, this.f56610j);
        searchResultsFragmentViewModel$special$$inlined$flatMapLatest$1.L$0 = flowCollector;
        searchResultsFragmentViewModel$special$$inlined$flatMapLatest$1.f56609i = str;
        return searchResultsFragmentViewModel$special$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f56608h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SearchResultsFragmentViewModel$pagingData$lambda2$$inlined$map$1 r32 = new SearchResultsFragmentViewModel$pagingData$lambda2$$inlined$map$1(this.f56610j.createPagerForCategory((String) this.f56609i).getFlow(), this.f56610j);
            this.f56608h = 1;
            if (FlowKt.emitAll((FlowCollector) this.L$0, r32, (Continuation<? super Unit>) this) == coroutine_suspended) {
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
