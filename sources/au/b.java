package au;

import com.talabat.sdsquad.domain.filters.GetFiltersUseCase;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetFiltersUseCase.RequestValues f58136b;

    public /* synthetic */ b(GetFiltersUseCase.RequestValues requestValues) {
        this.f58136b = requestValues;
    }

    public final Object apply(Object obj) {
        return GetFiltersUseCase.m10785executeUseCase$lambda2(this.f58136b, (List) obj);
    }
}
