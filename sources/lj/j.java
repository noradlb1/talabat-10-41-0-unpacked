package lj;

import android.view.View;
import com.talabat.darkstores.feature.product.views.ProductTagsContainer;
import java.util.List;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProductTagsContainer f57017b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f57018c;

    public /* synthetic */ j(ProductTagsContainer productTagsContainer, List list) {
        this.f57017b = productTagsContainer;
        this.f57018c = list;
    }

    public final void onClick(View view) {
        ProductTagsContainer.m10055setProductTags$lambda3(this.f57017b, this.f57018c, view);
    }
}
