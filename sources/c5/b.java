package c5;

import android.view.ViewGroup;
import com.deliveryhero.fluid.values.Size;
import com.deliveryhero.fluid.widgets.collections.pager.CarouselWidget;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Size f29354b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CarouselWidget f29355c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f29356d;

    public /* synthetic */ b(Size size, CarouselWidget carouselWidget, ViewGroup viewGroup) {
        this.f29354b = size;
        this.f29355c = carouselWidget;
        this.f29356d = viewGroup;
    }

    public final void run() {
        CarouselWidget.m8211setWidgetPadding$lambda1(this.f29354b, this.f29355c, this.f29356d);
    }
}
