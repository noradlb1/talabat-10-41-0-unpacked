package el;

import buisnessmodels.Cart;
import com.talabat.feature.activecarts.data.repository.ActiveCartInfoRepositoryImpl;
import io.reactivex.functions.Predicate;

public final /* synthetic */ class d implements Predicate {
    public final boolean test(Object obj) {
        return ActiveCartInfoRepositoryImpl.m10114getFoodCart$lambda1((Cart) obj);
    }
}
