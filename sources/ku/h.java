package ku;

import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.GlobalSearchViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class h implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GlobalSearchViewModel f62232b;

    public /* synthetic */ h(GlobalSearchViewModel globalSearchViewModel) {
        this.f62232b = globalSearchViewModel;
    }

    public final Object apply(Object obj) {
        return GlobalSearchViewModel.m10838search$lambda2(this.f62232b, (List) obj);
    }
}
