package com.talabat.darkstores.feature.searchResults;

import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.darkstores.feature.tracking.EventOriginType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/darkstores/feature/tracking/EventOriginType;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SearchResultsFragment$eventOriginType$2 extends Lambda implements Function0<EventOriginType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SearchResultsFragment f56589g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchResultsFragment$eventOriginType$2(SearchResultsFragment searchResultsFragment) {
        super(0);
        this.f56589g = searchResultsFragment;
    }

    @NotNull
    public final EventOriginType invoke() {
        if (this.f56589g.getArgs().getResultsType() instanceof SearchResultsType.Banner) {
            return EventOriginType.Banner;
        }
        return EventOriginType.Search;
    }
}
