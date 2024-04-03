package gl;

import com.talabat.feature.activecarts.domain.usecase.GetActiveCartInfoUseCaseImpl;
import io.reactivex.functions.Predicate;
import java.util.List;

public final /* synthetic */ class b implements Predicate {
    public final boolean test(Object obj) {
        return GetActiveCartInfoUseCaseImpl.m10126invoke$lambda4((List) obj);
    }
}
