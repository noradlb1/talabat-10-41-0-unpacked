package dj;

import com.talabat.darkstores.feature.home.CategoriesListAdapter;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CategoriesListAdapter f56729b;

    public /* synthetic */ b(CategoriesListAdapter categoriesListAdapter) {
        this.f56729b = categoriesListAdapter;
    }

    public final void accept(Object obj) {
        CategoriesListAdapter.m9944onBindViewHolder$lambda1(this.f56729b, (Unit) obj);
    }
}
