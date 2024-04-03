package yi;

import android.view.View;
import com.talabat.darkstores.feature.categories.subcategories.ShelfItemsListAdapter;
import com.talabat.darkstores.feature.categories.subcategories.shelf.ShelfItem;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShelfItem f58029b;

    public /* synthetic */ d(ShelfItem shelfItem) {
        this.f58029b = shelfItem;
    }

    public final void onClick(View view) {
        ShelfItemsListAdapter.ViewHolder.m9866bind$lambda2$lambda0(this.f58029b, view);
    }
}
