package tf;

import com.talabat.collectiondetails.data.CollectionsDataSourceImplementation;
import io.reactivex.functions.Function;
import library.talabat.com.talabatlib.RestuarntListResponse;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CollectionsDataSourceImplementation f57416b;

    public /* synthetic */ a(CollectionsDataSourceImplementation collectionsDataSourceImplementation) {
        this.f57416b = collectionsDataSourceImplementation;
    }

    public final Object apply(Object obj) {
        return CollectionsDataSourceImplementation.m9539applyFilteringAndSorting$lambda1(this.f57416b, (RestuarntListResponse) obj);
    }
}
