package au;

import com.talabat.sdsquad.domain.filters.GetSortUseCase;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetSortUseCase.RequestValues f58137b;

    public /* synthetic */ c(GetSortUseCase.RequestValues requestValues) {
        this.f58137b = requestValues;
    }

    public final Object apply(Object obj) {
        return GetSortUseCase.m10786executeUseCase$lambda0(this.f58137b, (List) obj);
    }
}
