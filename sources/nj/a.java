package nj;

import com.talabat.darkstores.data.search.model.SearchCategoryResponse;
import com.talabat.darkstores.feature.searchCategory.SearchCategoryUseCase;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchCategoryUseCase f57066b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57067c;

    public /* synthetic */ a(SearchCategoryUseCase searchCategoryUseCase, String str) {
        this.f57066b = searchCategoryUseCase;
        this.f57067c = str;
    }

    public final void accept(Object obj) {
        SearchCategoryUseCase.m10078searchCategory$lambda0(this.f57066b, this.f57067c, (SearchCategoryResponse) obj);
    }
}
