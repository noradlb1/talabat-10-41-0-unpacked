package ri;

import com.talabat.darkstores.common.SwimlaneTrackingData;
import com.talabat.darkstores.feature.cart.CartFragmentViewModel;
import com.talabat.darkstores.feature.tracking.TrackingCategoryId;
import com.talabat.feature.darkstorescart.data.model.Product;
import io.reactivex.functions.Function;

public final /* synthetic */ class b1 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Product f57285b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f57286c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Integer f57287d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TrackingCategoryId f57288e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ SwimlaneTrackingData f57289f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f57290g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f57291h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f57292i;

    public /* synthetic */ b1(Product product, int i11, Integer num, TrackingCategoryId trackingCategoryId, SwimlaneTrackingData swimlaneTrackingData, String str, String str2, boolean z11) {
        this.f57285b = product;
        this.f57286c = i11;
        this.f57287d = num;
        this.f57288e = trackingCategoryId;
        this.f57289f = swimlaneTrackingData;
        this.f57290g = str;
        this.f57291h = str2;
        this.f57292i = z11;
    }

    public final Object apply(Object obj) {
        return CartFragmentViewModel.m9792increaseProductCount$lambda38(this.f57285b, this.f57286c, this.f57287d, this.f57288e, this.f57289f, this.f57290g, this.f57291h, this.f57292i, (Integer) obj);
    }
}
