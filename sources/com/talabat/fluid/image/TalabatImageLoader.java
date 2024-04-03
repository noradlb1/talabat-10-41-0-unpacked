package com.talabat.fluid.image;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.RequestManager;
import com.deliveryhero.fluid.widgets.image.ImageLoader;
import com.deliveryhero.fluid.widgets.image.ImageLocator;
import dq.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002J\u001a\u0010\u0011\u001a\u00020\u000f*\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/fluid/image/TalabatImageLoader;", "Lcom/deliveryhero/fluid/widgets/image/ImageLoader;", "requestManager", "Lcom/bumptech/glide/RequestManager;", "(Lcom/bumptech/glide/RequestManager;)V", "load", "", "widget", "Landroid/widget/ImageView;", "image", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Remote;", "loadingPlaceholder", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Local;", "errorPlaceholder", "isNotDestroyed", "", "Landroid/content/Context;", "postIfContextIsValid", "Landroid/view/View;", "run", "Lkotlin/Function0;", "com_talabat_ThirdPartyLibs_Fluid_Fluid"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatImageLoader implements ImageLoader {
    /* access modifiers changed from: private */
    @NotNull
    public final RequestManager requestManager;

    public TalabatImageLoader(@NotNull RequestManager requestManager2) {
        Intrinsics.checkNotNullParameter(requestManager2, "requestManager");
        this.requestManager = requestManager2;
    }

    private final boolean isNotDestroyed(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            return !activity.isDestroyed() && !activity.isFinishing();
        }
    }

    private final boolean postIfContextIsValid(View view, Function0<Unit> function0) {
        return view.post(new a(this, view, function0));
    }

    /* access modifiers changed from: private */
    /* renamed from: postIfContextIsValid$lambda-0  reason: not valid java name */
    public static final void m10466postIfContextIsValid$lambda0(TalabatImageLoader talabatImageLoader, View view, Function0 function0) {
        Intrinsics.checkNotNullParameter(talabatImageLoader, "this$0");
        Intrinsics.checkNotNullParameter(view, "$this_postIfContextIsValid");
        Intrinsics.checkNotNullParameter(function0, "$run");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (talabatImageLoader.isNotDestroyed(context)) {
            function0.invoke();
        }
    }

    public void load(@NotNull ImageView imageView, @NotNull ImageLocator.Local local) {
        ImageLoader.DefaultImpls.load(this, imageView, local);
    }

    public void load(@NotNull ImageView imageView, @NotNull ImageLocator.Remote remote, @Nullable ImageLocator.Local local, @Nullable ImageLocator.Local local2) {
        Intrinsics.checkNotNullParameter(imageView, "widget");
        Intrinsics.checkNotNullParameter(remote, "image");
        postIfContextIsValid(imageView, new TalabatImageLoader$load$1(this, remote, local2, local, imageView));
    }
}
