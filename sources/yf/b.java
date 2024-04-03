package yf;

import android.view.View;
import com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment;
import datamodels.Restaurant;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f58005b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58006c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Restaurant f58007d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f58008e;

    public /* synthetic */ b(Function2 function2, String str, Restaurant restaurant, int i11) {
        this.f58005b = function2;
        this.f58006c = str;
        this.f58007d = restaurant;
        this.f58008e = i11;
    }

    public final void onClick(View view) {
        FreshRestaurantUiViewHolderExperiment.m9571bindClickListener$lambda0(this.f58005b, this.f58006c, this.f58007d, this.f58008e, view);
    }
}
