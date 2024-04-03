package ci;

import com.talabat.darkstores.common.view.ItemCounterAction;
import com.talabat.darkstores.common.view.ItemCounterNewController;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;

public final /* synthetic */ class j implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ItemCounterNewController f50943b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Scheduler f50944c;

    public /* synthetic */ j(ItemCounterNewController itemCounterNewController, Scheduler scheduler) {
        this.f50943b = itemCounterNewController;
        this.f50944c = scheduler;
    }

    public final Object apply(Object obj) {
        return ItemCounterNewController.m9652state$lambda0(this.f50943b, this.f50944c, (ItemCounterAction) obj);
    }
}
