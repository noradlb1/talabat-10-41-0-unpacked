package ci;

import com.talabat.darkstores.common.view.ItemCounterNew;
import com.talabat.darkstores.common.view.ItemCounterState;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ItemCounterNew f50942b;

    public /* synthetic */ i(ItemCounterNew itemCounterNew) {
        this.f50942b = itemCounterNew;
    }

    public final void accept(Object obj) {
        this.f50942b.handleViewState((ItemCounterState) obj);
    }
}
