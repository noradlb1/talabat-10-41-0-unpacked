package yi;

import android.view.View;
import com.talabat.darkstores.feature.categories.subcategories.ShelfItemsListAdapter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f58030b;

    public /* synthetic */ e(View view) {
        this.f58030b = view;
    }

    public final void accept(Object obj) {
        ShelfItemsListAdapter.ViewHolder.m9867bind$lambda2$lambda1(this.f58030b, (Boolean) obj);
    }
}
