package com.talabat.sdsquad.ui.restaurantssearch.globalsearch.adapters.viewholders;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.talabat.sdsquad.R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J>\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/talabat/sdsquad/ui/restaurantssearch/globalsearch/adapters/viewholders/DishViewHolder$setDishLogo$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DishViewHolder$setDishLogo$1 implements RequestListener<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DishViewHolder f61343b;

    public DishViewHolder$setDishLogo$1(DishViewHolder dishViewHolder) {
        this.f61343b = dishViewHolder;
    }

    public boolean onLoadFailed(@Nullable GlideException glideException, @Nullable Object obj, @Nullable Target<Drawable> target, boolean z11) {
        ((ImageView) this.f61343b.getContainerView().findViewById(R.id.dishLogo)).setVisibility(8);
        ((ProgressBar) this.f61343b.getContainerView().findViewById(R.id.progressBar)).setVisibility(8);
        return false;
    }

    public boolean onResourceReady(@Nullable Drawable drawable, @Nullable Object obj, @Nullable Target<Drawable> target, @Nullable DataSource dataSource, boolean z11) {
        ((ProgressBar) this.f61343b.getContainerView().findViewById(R.id.progressBar)).setVisibility(8);
        View containerView = this.f61343b.getContainerView();
        int i11 = R.id.dishLogo;
        ((ImageView) containerView.findViewById(i11)).setImageDrawable(drawable);
        ((ImageView) this.f61343b.getContainerView().findViewById(i11)).setVisibility(0);
        return false;
    }
}
