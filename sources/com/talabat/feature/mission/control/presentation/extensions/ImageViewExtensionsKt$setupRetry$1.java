package com.talabat.feature.mission.control.presentation.extensions;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import en.b;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J>\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"com/talabat/feature/mission/control/presentation/extensions/ImageViewExtensionsKt$setupRetry$1", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "com_talabat_feature_mission-control_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImageViewExtensionsKt$setupRetry$1 implements RequestListener<Drawable> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f58603b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WeakReference<ImageView> f58604c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RequestBuilder<Drawable> f58605d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f58606e;

    public ImageViewExtensionsKt$setupRetry$1(Ref.BooleanRef booleanRef, WeakReference<ImageView> weakReference, RequestBuilder<Drawable> requestBuilder, String str) {
        this.f58603b = booleanRef;
        this.f58604c = weakReference;
        this.f58605d = requestBuilder;
        this.f58606e = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: onLoadFailed$lambda-1  reason: not valid java name */
    public static final void m10230onLoadFailed$lambda1(WeakReference weakReference, RequestBuilder requestBuilder, String str) {
        Intrinsics.checkNotNullParameter(weakReference, "$weakImageView");
        Intrinsics.checkNotNullParameter(requestBuilder, "$glideAction");
        Intrinsics.checkNotNullParameter(str, "$imageUrl");
        ImageView imageView = (ImageView) weakReference.get();
        if (imageView != null) {
            requestBuilder.load(str).into(imageView);
        }
    }

    public boolean onLoadFailed(@Nullable GlideException glideException, @Nullable Object obj, @Nullable Target<Drawable> target, boolean z11) {
        Ref.BooleanRef booleanRef = this.f58603b;
        if (booleanRef.element) {
            return false;
        }
        booleanRef.element = true;
        new Handler(Looper.getMainLooper()).postDelayed(new b(this.f58604c, this.f58605d, this.f58606e), 1000);
        return true;
    }

    public boolean onResourceReady(@Nullable Drawable drawable, @Nullable Object obj, @Nullable Target<Drawable> target, @Nullable DataSource dataSource, boolean z11) {
        return false;
    }
}
