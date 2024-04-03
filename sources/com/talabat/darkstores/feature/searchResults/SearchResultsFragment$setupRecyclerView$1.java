package com.talabat.darkstores.feature.searchResults;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SearchResultsFragment$setupRecyclerView$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public SearchResultsFragment$setupRecyclerView$1(Object obj) {
        super(1, obj, SearchResultsFragmentViewModel.class, "selectCategory", "selectCategory(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable String str) {
        ((SearchResultsFragmentViewModel) this.receiver).selectCategory(str);
    }
}
