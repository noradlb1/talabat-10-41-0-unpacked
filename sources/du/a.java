package du;

import com.talabat.sdsquad.domain.vendorslist.GetCollectionUseCase;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetCollectionUseCase.RequestValues f61956b;

    public /* synthetic */ a(GetCollectionUseCase.RequestValues requestValues) {
        this.f61956b = requestValues;
    }

    public final Object apply(Object obj) {
        return GetCollectionUseCase.m10789executeUseCase$lambda8$lambda2(this.f61956b, (List) obj);
    }
}
