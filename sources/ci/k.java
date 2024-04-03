package ci;

import com.talabat.darkstores.common.view.ItemCounterAction;
import com.talabat.darkstores.common.view.ItemCounterNewController;
import com.talabat.darkstores.common.view.ItemCounterState;
import io.reactivex.functions.BiFunction;

public final /* synthetic */ class k implements BiFunction {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ItemCounterNewController f50945b;

    public /* synthetic */ k(ItemCounterNewController itemCounterNewController) {
        this.f50945b = itemCounterNewController;
    }

    public final Object apply(Object obj, Object obj2) {
        return this.f50945b.handleAction((ItemCounterState) obj, (ItemCounterAction) obj2);
    }
}
