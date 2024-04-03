package du;

import com.talabat.sdsquad.domain.vendorslist.GetCollectionUseCase;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetCollectionUseCase.RequestValues f61958b;

    public /* synthetic */ c(GetCollectionUseCase.RequestValues requestValues) {
        this.f61958b = requestValues;
    }

    public final Object apply(Object obj) {
        return GetCollectionUseCase.m10791executeUseCase$lambda8$lambda6(this.f61958b, (List) obj);
    }
}
