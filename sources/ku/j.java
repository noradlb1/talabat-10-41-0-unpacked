package ku;

import com.talabat.sdsquad.ui.restaurantssearch.globalsearch.GlobalSearchViewModel;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class j implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GlobalSearchViewModel f62239b;

    public /* synthetic */ j(GlobalSearchViewModel globalSearchViewModel) {
        this.f62239b = globalSearchViewModel;
    }

    public final void accept(Object obj) {
        GlobalSearchViewModel.m10840search$lambda6(this.f62239b, (Flowable) obj);
    }
}
