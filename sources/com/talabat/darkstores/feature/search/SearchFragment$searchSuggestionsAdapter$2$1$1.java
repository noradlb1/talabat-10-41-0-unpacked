package com.talabat.darkstores.feature.search;

import com.talabat.darkstores.model.SearchSuggestion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SearchFragment$searchSuggestionsAdapter$2$1$1 extends FunctionReferenceImpl implements Function2<SearchSuggestion, Integer, Unit> {
    public SearchFragment$searchSuggestionsAdapter$2$1$1(Object obj) {
        super(2, obj, SearchFragmentViewModel.class, "onSearchSuggestionClicked", "onSearchSuggestionClicked(Lcom/talabat/darkstores/model/SearchSuggestion;I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((SearchSuggestion) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SearchSuggestion searchSuggestion, int i11) {
        Intrinsics.checkNotNullParameter(searchSuggestion, "p0");
        ((SearchFragmentViewModel) this.receiver).onSearchSuggestionClicked(searchSuggestion, i11);
    }
}
