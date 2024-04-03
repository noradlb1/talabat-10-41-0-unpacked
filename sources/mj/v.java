package mj;

import com.talabat.darkstores.feature.search.SearchFragmentViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class v implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchFragmentViewModel f57051b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57052c;

    public /* synthetic */ v(SearchFragmentViewModel searchFragmentViewModel, String str) {
        this.f57051b = searchFragmentViewModel;
        this.f57052c = str;
    }

    public final void accept(Object obj) {
        SearchFragmentViewModel.m10070loadSuggestions$lambda2$lambda0(this.f57051b, this.f57052c, (List) obj);
    }
}
