package el;

import com.talabat.feature.activecarts.data.repository.ActiveCartInfoRepositoryImpl;
import io.reactivex.functions.Predicate;
import java.util.List;

public final /* synthetic */ class a implements Predicate {
    public final boolean test(Object obj) {
        return ActiveCartInfoRepositoryImpl.m10119getQCommerceCartList$lambda6((List) obj);
    }
}
