package com.talabat;

import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.GroceryDetailsViewScreen;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J6\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/talabat/GroceryDetailsViewScreen$ItemListAdapter$onBindViewHolder$1$3", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryDetailsViewScreen$ItemListAdapter$onBindViewHolder$1$3 implements RequestListener<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f54102b;

    public GroceryDetailsViewScreen$ItemListAdapter$onBindViewHolder$1$3(RecyclerView.ViewHolder viewHolder) {
        this.f54102b = viewHolder;
    }

    public boolean onLoadFailed(@Nullable GlideException glideException, @NotNull Object obj, @NotNull Target<Drawable> target, boolean z11) {
        Intrinsics.checkNotNullParameter(obj, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(target, "target");
        ((GroceryDetailsViewScreen.MenuItemViewHolder) this.f54102b).getItemImg().setImageResource(R.drawable.bg_m_grocery_placeholder);
        ((GroceryDetailsViewScreen.MenuItemViewHolder) this.f54102b).getProgress().setVisibility(8);
        return false;
    }

    public boolean onResourceReady(@NotNull Drawable drawable, @NotNull Object obj, @NotNull Target<Drawable> target, @NotNull DataSource dataSource, boolean z11) {
        Intrinsics.checkNotNullParameter(drawable, "resource");
        Intrinsics.checkNotNullParameter(obj, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        ((GroceryDetailsViewScreen.MenuItemViewHolder) this.f54102b).getProgress().setVisibility(8);
        return false;
    }
}
