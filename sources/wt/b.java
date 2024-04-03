package wt;

import com.talabat.sdsquad.data.inlineads.InLineAdsRepositoryImp;
import com.talabat.searchdiscovery.features.vendorslist.models.responses.InlineAdsResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InLineAdsRepositoryImp f63011b;

    public /* synthetic */ b(InLineAdsRepositoryImp inLineAdsRepositoryImp) {
        this.f63011b = inLineAdsRepositoryImp;
    }

    public final void accept(Object obj) {
        InLineAdsRepositoryImp.m10776loadInlineAds$lambda1(this.f63011b, (InlineAdsResponse) obj);
    }
}
