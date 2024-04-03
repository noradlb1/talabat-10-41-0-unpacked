package com.talabat.darkstores.feature.search;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SearchFragmentViewModel$subscribeToSearchQuery$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SearchFragmentViewModel f56579g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchFragmentViewModel$subscribeToSearchQuery$1(SearchFragmentViewModel searchFragmentViewModel) {
        super(1);
        this.f56579g = searchFragmentViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        this.f56579g.searchQueryMutableLiveData.postValue(str);
    }
}
