package com.talabat.darkstores.feature.search;

import com.talabat.darkstores.data.tracking.SearchTracker;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SearchFragmentViewModel$subscribeToSearchClosed$2 extends Lambda implements Function1<Pair<? extends String, ? extends Integer>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SearchFragmentViewModel f56578g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchFragmentViewModel$subscribeToSearchClosed$2(SearchFragmentViewModel searchFragmentViewModel) {
        super(1);
        this.f56578g = searchFragmentViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<String, Integer>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<String, Integer> pair) {
        String component1 = pair.component1();
        int intValue = pair.component2().intValue();
        SearchTracker access$getSearchTracker$p = this.f56578g.searchTracker;
        String lastSearchRequestId = this.f56578g.discoveryRepo.getLastSearchRequestId();
        Intrinsics.checkNotNullExpressionValue(component1, "query");
        access$getSearchTracker$p.searchClosed(intValue, lastSearchRequestId, component1);
    }
}
