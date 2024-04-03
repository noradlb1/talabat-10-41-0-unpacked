package dj;

import com.talabat.darkstores.feature.home.CategoriesListAdapter;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CategoriesListAdapter f56725b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CategoriesListAdapter.Tile f56726c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f56727d;

    public /* synthetic */ a(CategoriesListAdapter categoriesListAdapter, CategoriesListAdapter.Tile tile, int i11) {
        this.f56725b = categoriesListAdapter;
        this.f56726c = tile;
        this.f56727d = i11;
    }

    public final void accept(Object obj) {
        CategoriesListAdapter.m9943onBindViewHolder$lambda0(this.f56725b, this.f56726c, this.f56727d, (Unit) obj);
    }
}
