package mj;

import com.talabat.darkstores.feature.search.SearchFragmentViewModel;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class t implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f57049b;

    public /* synthetic */ t(String str) {
        this.f57049b = str;
    }

    public final Object apply(Object obj) {
        return SearchFragmentViewModel.m10073subscribeToEmptySearchResults$lambda4$lambda3(this.f57049b, (Vendor) obj);
    }
}
