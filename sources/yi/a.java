package yi;

import android.view.View;
import com.talabat.darkstores.feature.categories.subcategories.HeadlinesChipsListAdapter;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoryHeadline;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HeadlinesChipsListAdapter f58023b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SubcategoryHeadline f58024c;

    public /* synthetic */ a(HeadlinesChipsListAdapter headlinesChipsListAdapter, SubcategoryHeadline subcategoryHeadline) {
        this.f58023b = headlinesChipsListAdapter;
        this.f58024c = subcategoryHeadline;
    }

    public final void onClick(View view) {
        HeadlinesChipsListAdapter.m9863onBindViewHolder$lambda0(this.f58023b, this.f58024c, view);
    }
}
