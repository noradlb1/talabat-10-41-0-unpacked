package com.talabat.darkstores.feature.searchResults;

import com.talabat.darkstores.data.SearchCategory;
import com.talabat.darkstores.feature.searchResults.paging.SearchPagingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lcom/talabat/darkstores/feature/searchResults/paging/SearchPagingItem;", "item", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.darkstores.feature.searchResults.SearchResultsFragmentViewModel$replaceCategories$1", f = "SearchResultsFragmentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SearchResultsFragmentViewModel$replaceCategories$1 extends SuspendLambda implements Function2<SearchPagingItem, Continuation<? super SearchPagingItem>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f56614h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f56615i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SearchResultsFragmentViewModel f56616j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchResultsFragmentViewModel$replaceCategories$1(SearchResultsFragmentViewModel searchResultsFragmentViewModel, Continuation<? super SearchResultsFragmentViewModel$replaceCategories$1> continuation) {
        super(2, continuation);
        this.f56616j = searchResultsFragmentViewModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SearchResultsFragmentViewModel$replaceCategories$1 searchResultsFragmentViewModel$replaceCategories$1 = new SearchResultsFragmentViewModel$replaceCategories$1(this.f56616j, continuation);
        searchResultsFragmentViewModel$replaceCategories$1.f56615i = obj;
        return searchResultsFragmentViewModel$replaceCategories$1;
    }

    @Nullable
    public final Object invoke(@NotNull SearchPagingItem searchPagingItem, @Nullable Continuation<? super SearchPagingItem> continuation) {
        return ((SearchResultsFragmentViewModel$replaceCategories$1) create(searchPagingItem, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f56614h == 0) {
            ResultKt.throwOnFailure(obj);
            SearchPagingItem searchPagingItem = (SearchPagingItem) this.f56615i;
            boolean z11 = searchPagingItem instanceof SearchPagingItem.Categories;
            SearchPagingItem.Categories categories = searchPagingItem;
            if (z11) {
                SearchPagingItem.Categories categories2 = (SearchPagingItem.Categories) searchPagingItem;
                List<SearchCategory> cachedCategories$com_talabat_NewArchi_darkstores_darkstores = this.f56616j.getCachedCategories$com_talabat_NewArchi_darkstores_darkstores();
                if (cachedCategories$com_talabat_NewArchi_darkstores_darkstores == null) {
                    cachedCategories$com_talabat_NewArchi_darkstores_darkstores = categories2.getCategories();
                }
                SearchPagingItem.Categories copy = categories2.copy(cachedCategories$com_talabat_NewArchi_darkstores_darkstores);
                SearchResultsFragmentViewModel searchResultsFragmentViewModel = this.f56616j;
                boolean areEqual = Intrinsics.areEqual((Object) searchResultsFragmentViewModel.getCachedCategories$com_talabat_NewArchi_darkstores_darkstores(), (Object) copy.getCategories());
                categories = copy;
                if (!areEqual) {
                    searchResultsFragmentViewModel.setCachedCategories$com_talabat_NewArchi_darkstores_darkstores(copy.getCategories());
                    categories = copy;
                }
            }
            return categories;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
