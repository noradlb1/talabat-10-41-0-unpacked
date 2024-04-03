package du;

import com.talabat.sdsquad.domain.vendorslist.GetCollectionUseCase;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetCollectionUseCase f61957b;

    public /* synthetic */ b(GetCollectionUseCase getCollectionUseCase) {
        this.f61957b = getCollectionUseCase;
    }

    public final Object apply(Object obj) {
        return GetCollectionUseCase.m10790executeUseCase$lambda8$lambda4(this.f61957b, (List) obj);
    }
}
