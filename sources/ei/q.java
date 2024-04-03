package ei;

import com.talabat.darkstores.data.discovery.DiscoveryRepo;
import com.talabat.darkstores.model.SearchSuggestionsResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class q implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiscoveryRepo f56806b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56807c;

    public /* synthetic */ q(DiscoveryRepo discoveryRepo, String str) {
        this.f56806b = discoveryRepo;
        this.f56807c = str;
    }

    public final void accept(Object obj) {
        DiscoveryRepo.m9715search$lambda11$lambda8(this.f56806b, this.f56807c, (SearchSuggestionsResponse) obj);
    }
}
