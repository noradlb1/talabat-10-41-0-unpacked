package fj;

import android.view.View;
import com.talabat.darkstores.feature.home.categories.CategoriesMissionItemView;
import com.talabat.darkstores.model.Category;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f56827b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Category f56828c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f56829d;

    public /* synthetic */ a(Function2 function2, Category category, int i11) {
        this.f56827b = function2;
        this.f56828c = category;
        this.f56829d = i11;
    }

    public final void onClick(View view) {
        CategoriesMissionItemView.m9976setContent$lambda0(this.f56827b, this.f56828c, this.f56829d, view);
    }
}
