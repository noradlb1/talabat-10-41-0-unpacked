package com.talabat.darkstores.feature.search;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/darkstores/feature/search/PreSearchAdapter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SearchFragment$preSearchAdapter$2 extends Lambda implements Function0<PreSearchAdapter> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SearchFragment f56574g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchFragment$preSearchAdapter$2(SearchFragment searchFragment) {
        super(0);
        this.f56574g = searchFragment;
    }

    @NotNull
    public final PreSearchAdapter invoke() {
        return new PreSearchAdapter(this.f56574g.getViewModel(), this.f56574g.getViewModel(), this.f56574g.getCartFragmentViewModel());
    }
}
