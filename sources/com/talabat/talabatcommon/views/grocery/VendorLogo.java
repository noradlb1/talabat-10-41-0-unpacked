package com.talabat.talabatcommon.views.grocery;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.helpers.GlideActivityExceptionHandler;
import com.talabat.talabatcommon.helpers.GlideApp;
import com.talabat.talabatcommon.helpers.GlideRequests;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\t¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/views/grocery/VendorLogo;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setVendorLogo", "", "imageUrl", "", "vendorStatus", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorLogo extends FrameLayout {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorLogo(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.view_vendor_logo, this, true);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public final void setVendorLogo(@Nullable String str, int i11) {
        if (str == null) {
            int i12 = R.id.vendorLogoImg;
            ((ImageView) _$_findCachedViewById(i12)).setImageResource(0);
            ((ImageView) _$_findCachedViewById(i12)).setVisibility(0);
        } else if (GlideActivityExceptionHandler.INSTANCE.isValidContextForGlide(getContext())) {
            Resources resources = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            float applyDimension = TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics());
            GlideRequests with = GlideApp.with(getContext());
            int i13 = R.id.vendorLogoImg;
            with.clear((View) (ImageView) _$_findCachedViewById(i13));
            GlideApp.with(getContext()).load(str).transform((Transformation) new MultiTransformation((Transformation<T>[]) new Transformation[]{new CenterCrop(), new RoundedCorners((int) applyDimension)})).listener((RequestListener) new VendorLogo$setVendorLogo$1(str, this)).placeholder(R.drawable.glide_placeholder).into((ImageView) _$_findCachedViewById(i13));
        }
        if (i11 != 0) {
            if (i11 == 1) {
                ((TextView) _$_findCachedViewById(R.id.vendorStatusTxt)).setText(getContext().getResources().getText(com.talabat.localization.R.string.closed));
                ((FrameLayout) _$_findCachedViewById(R.id.frameLayout_statusContainer)).setVisibility(0);
                return;
            } else if (i11 != 5) {
                ((TextView) _$_findCachedViewById(R.id.vendorStatusTxt)).setText(getContext().getResources().getText(com.talabat.localization.R.string.busy));
                ((FrameLayout) _$_findCachedViewById(R.id.frameLayout_statusContainer)).setVisibility(0);
                return;
            }
        }
        ((FrameLayout) _$_findCachedViewById(R.id.frameLayout_statusContainer)).setVisibility(8);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorLogo(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        LayoutInflater.from(getContext()).inflate(R.layout.view_vendor_logo, this, true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorLogo(@NotNull Context context, @NotNull AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        LayoutInflater.from(getContext()).inflate(R.layout.view_vendor_logo, this, true);
    }
}
