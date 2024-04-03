package el;

import buisnessmodels.Cart;
import com.talabat.feature.activecarts.data.repository.ActiveCartInfoRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class e implements Function {
    public final Object apply(Object obj) {
        return ActiveCartInfoRepositoryImpl.m10115getFoodCart$lambda2((Cart) obj);
    }
}
