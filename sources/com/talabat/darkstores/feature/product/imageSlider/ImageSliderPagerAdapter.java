package com.talabat.darkstores.feature.product.imageSlider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.load.Transformation;
import com.jsibbold.zoomage.ZoomageView;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.common.bindingAdapters.ResizeStrategy;
import com.talabat.darkstores.feature.home.LoopingPagerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b\u001e\u0010\u001fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0014J \u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/talabat/darkstores/feature/product/imageSlider/ImageSliderPagerAdapter;", "Lcom/talabat/darkstores/feature/home/LoopingPagerAdapter;", "", "", "viewType", "Landroid/view/ViewGroup;", "container", "listPosition", "Landroid/view/View;", "b", "convertView", "", "a", "", "enable", "isZoomEnabled", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "zoomEnabled", "Z", "getZoomEnabled", "()Z", "setZoomEnabled", "(Z)V", "", "itemList", "isInfinite", "<init>", "(Landroid/content/Context;Ljava/util/List;Z)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public final class ImageSliderPagerAdapter extends LoopingPagerAdapter<String> {
    @NotNull
    private final Context context;
    private boolean zoomEnabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageSliderPagerAdapter(@NotNull Context context2, @NotNull List<String> list, boolean z11) {
        super(list, z11);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(list, "itemList");
        this.context = context2;
    }

    public void a(@NotNull View view, int i11, int i12) {
        String str;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(view, "convertView");
        if (this.zoomEnabled) {
            imageView = (ZoomageView) view.findViewById(R.id.sliderZoomImage);
            str = "convertView.sliderZoomImage";
        } else {
            imageView = (ImageView) view.findViewById(R.id.sliderImage);
            str = "convertView.sliderImage";
        }
        Intrinsics.checkNotNullExpressionValue(imageView, str);
        BindingAdaptersKt.loadImageWithGlide$default(imageView, (String) getItemList().get(i11), Integer.valueOf(R.drawable.product_tile_placeholder_new), (ResizeStrategy) null, (Transformation) null, Integer.MIN_VALUE, 12, (Object) null);
    }

    @NotNull
    public View b(int i11, @NotNull ViewGroup viewGroup, int i12) {
        Intrinsics.checkNotNullParameter(viewGroup, TtmlNode.RUBY_CONTAINER);
        if (this.zoomEnabled) {
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.item_darkstores_image_slider, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "{\n            LayoutInfl…ntainer, false)\n        }");
            return inflate;
        }
        View inflate2 = LayoutInflater.from(this.context).inflate(R.layout.item_darkstores_image_slider_no_zoom, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "{\n            LayoutInfl…ntainer, false)\n        }");
        return inflate2;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final boolean getZoomEnabled() {
        return this.zoomEnabled;
    }

    public final void isZoomEnabled(boolean z11) {
        this.zoomEnabled = z11;
    }

    public final void setZoomEnabled(boolean z11) {
        this.zoomEnabled = z11;
    }
}
