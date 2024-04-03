package au;

import com.talabat.sdsquad.domain.filters.GetFiltersUseCase;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetFiltersUseCase f58135b;

    public /* synthetic */ a(GetFiltersUseCase getFiltersUseCase) {
        this.f58135b = getFiltersUseCase;
    }

    public final Object apply(Object obj) {
        return GetFiltersUseCase.m10784executeUseCase$lambda1(this.f58135b, (List) obj);
    }
}
