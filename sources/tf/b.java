package tf;

import com.talabat.collectiondetails.data.CollectionsDataSourceImplementation;
import io.reactivex.functions.Function;
import library.talabat.com.talabatlib.RestuarntListResponse;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CollectionsDataSourceImplementation f57417b;

    public /* synthetic */ b(CollectionsDataSourceImplementation collectionsDataSourceImplementation) {
        this.f57417b = collectionsDataSourceImplementation;
    }

    public final Object apply(Object obj) {
        return CollectionsDataSourceImplementation.m9540getAllVendorsForCollection$lambda0(this.f57417b, (RestuarntListResponse) obj);
    }
}
