package xi;

import android.view.View;
import com.talabat.darkstores.feature.categories.CategoriesFragment;
import java.util.List;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CategoriesFragment f57989b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f57990c;

    public /* synthetic */ d(CategoriesFragment categoriesFragment, List list) {
        this.f57989b = categoriesFragment;
        this.f57990c = list;
    }

    public final void onClick(View view) {
        CategoriesFragment.m9856onDataReceived$lambda2(this.f57989b, this.f57990c, view);
    }
}
