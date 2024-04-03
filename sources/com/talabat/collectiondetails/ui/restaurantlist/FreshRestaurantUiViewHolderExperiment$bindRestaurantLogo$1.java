package com.talabat.collectiondetails.ui.restaurantlist;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.helpers.TalabatUtils;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J2\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J:\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/talabat/collectiondetails/ui/restaurantlist/FreshRestaurantUiViewHolderExperiment$bindRestaurantLogo$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FreshRestaurantUiViewHolderExperiment$bindRestaurantLogo$1 implements RequestListener<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Restaurant f55680b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FreshRestaurantUiViewHolderExperiment f55681c;

    public FreshRestaurantUiViewHolderExperiment$bindRestaurantLogo$1(Restaurant restaurant, FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment) {
        this.f55680b = restaurant;
        this.f55681c = freshRestaurantUiViewHolderExperiment;
    }

    public boolean onLoadFailed(@Nullable GlideException glideException, @NotNull Object obj, @NotNull Target<Drawable> target, boolean z11) {
        int i11;
        boolean z12;
        Intrinsics.checkNotNullParameter(obj, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(target, "target");
        String str = this.f55680b.getLogo().toString();
        int length = str.length() - 1;
        int i12 = 0;
        boolean z13 = false;
        while (i12 <= length) {
            if (!z13) {
                i11 = i12;
            } else {
                i11 = length;
            }
            if (Intrinsics.compare((int) str.charAt(i11), 32) <= 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z13) {
                if (!z12) {
                    z13 = true;
                } else {
                    i12++;
                }
            } else if (!z12) {
                break;
            } else {
                length--;
            }
        }
        String obj2 = str.subSequence(i12, length + 1).toString();
        String substring = obj2.substring(StringsKt__StringsKt.lastIndexOf$default((CharSequence) obj2, "/", 0, false, 6, (Object) null) + 1, obj2.length());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        if (!TalabatUtils.isNullOrEmpty(substring)) {
            this.f55681c.getProgressBar().setVisibility(0);
        } else {
            this.f55681c.getProgressBar().setVisibility(8);
            this.f55681c.getRestaurantLogoImageView().setImageResource(0);
            this.f55681c.getRestaurantLogoImageView().setVisibility(0);
        }
        return false;
    }

    public boolean onResourceReady(@Nullable Drawable drawable, @NotNull Object obj, @NotNull Target<Drawable> target, @NotNull DataSource dataSource, boolean z11) {
        Intrinsics.checkNotNullParameter(obj, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.f55681c.getProgressBar().setVisibility(8);
        return false;
    }
}
