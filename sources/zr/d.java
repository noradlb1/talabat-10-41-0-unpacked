package zr;

import com.talabat.helpers.GlobalDataModel;
import datamodels.Restaurant;
import io.reactivex.functions.BiPredicate;

public final /* synthetic */ class d implements BiPredicate {
    public final boolean test(Object obj, Object obj2) {
        return GlobalDataModel.SELECTED.lambda$static$0((Restaurant) obj, (Restaurant) obj2);
    }
}
