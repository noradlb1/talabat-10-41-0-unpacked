package fu;

import com.talabat.sdsquad.ui.cuisines.CuisinesViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CuisinesViewModel f62074b;

    public /* synthetic */ d(CuisinesViewModel cuisinesViewModel) {
        this.f62074b = cuisinesViewModel;
    }

    public final void accept(Object obj) {
        CuisinesViewModel.m10815getCuisineList$lambda0(this.f62074b, (List) obj);
    }
}
