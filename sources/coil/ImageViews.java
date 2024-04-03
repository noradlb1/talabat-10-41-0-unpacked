package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.util.CoilUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002\u001a?\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000\u001a?\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000\u001a?\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000\u001a?\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000\u001a?\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000\u001a?\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000\u001a?\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000\u001a?\u0010\u001b\u001a\u00020\u0007*\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0019\b\u0002\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001e"}, d2 = {"metadata", "Lcoil/request/ImageResult$Metadata;", "Landroid/widget/ImageView;", "(Landroid/widget/ImageView;)Lcoil/request/ImageResult$Metadata;", "clear", "", "load", "Lcoil/request/Disposable;", "bitmap", "Landroid/graphics/Bitmap;", "imageLoader", "Lcoil/ImageLoader;", "builder", "Lkotlin/Function1;", "Lcoil/request/ImageRequest$Builder;", "Lkotlin/ExtensionFunctionType;", "drawable", "Landroid/graphics/drawable/Drawable;", "uri", "Landroid/net/Uri;", "file", "Ljava/io/File;", "drawableResId", "", "", "url", "Lokhttp3/HttpUrl;", "loadAny", "data", "", "coil-singleton_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "ImageViews")
public final class ImageViews {
    public static final void clear(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        CoilUtils.clear(imageView);
    }

    public static final /* synthetic */ Disposable load(ImageView imageView, @DrawableRes int i11, ImageLoader imageLoader, Function1<? super ImageRequest.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Integer valueOf = Integer.valueOf(i11);
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context).data(valueOf).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static /* synthetic */ Disposable load$default(ImageView imageView, String str, ImageLoader imageLoader, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "fun ImageView.load(\n    …ri, imageLoader, builder)");
            imageLoader = Coil.imageLoader(context);
        }
        if ((i11 & 4) != 0) {
            function1 = ImageViews$load$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context2).data(str).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static final /* synthetic */ Disposable loadAny(ImageView imageView, Object obj, ImageLoader imageLoader, Function1<? super ImageRequest.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context).data(obj).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static /* synthetic */ Disposable loadAny$default(ImageView imageView, Object obj, ImageLoader imageLoader, Function1 function1, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "fun ImageView.loadAny(\n …Loader.enqueue(request)\n}");
            imageLoader = Coil.imageLoader(context);
        }
        if ((i11 & 4) != 0) {
            function1 = ImageViews$loadAny$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context2).data(obj).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    @Nullable
    @JvmName(name = "metadata")
    public static final ImageResult.Metadata metadata(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        return CoilUtils.metadata(imageView);
    }

    public static final /* synthetic */ Disposable load(ImageView imageView, String str, ImageLoader imageLoader, Function1<? super ImageRequest.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context).data(str).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static /* synthetic */ Disposable load$default(ImageView imageView, HttpUrl httpUrl, ImageLoader imageLoader, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "fun ImageView.load(\n    …rl, imageLoader, builder)");
            imageLoader = Coil.imageLoader(context);
        }
        if ((i11 & 4) != 0) {
            function1 = ImageViews$load$2.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context2).data(httpUrl).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static final /* synthetic */ Disposable load(ImageView imageView, HttpUrl httpUrl, ImageLoader imageLoader, Function1<? super ImageRequest.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context).data(httpUrl).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static final /* synthetic */ Disposable load(ImageView imageView, Uri uri, ImageLoader imageLoader, Function1<? super ImageRequest.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context).data(uri).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static /* synthetic */ Disposable load$default(ImageView imageView, Uri uri, ImageLoader imageLoader, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "fun ImageView.load(\n    …ri, imageLoader, builder)");
            imageLoader = Coil.imageLoader(context);
        }
        if ((i11 & 4) != 0) {
            function1 = ImageViews$load$3.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context2).data(uri).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static final /* synthetic */ Disposable load(ImageView imageView, File file, ImageLoader imageLoader, Function1<? super ImageRequest.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context).data(file).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static /* synthetic */ Disposable load$default(ImageView imageView, File file, ImageLoader imageLoader, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "fun ImageView.load(\n    …le, imageLoader, builder)");
            imageLoader = Coil.imageLoader(context);
        }
        if ((i11 & 4) != 0) {
            function1 = ImageViews$load$4.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context2).data(file).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static final /* synthetic */ Disposable load(ImageView imageView, Drawable drawable, ImageLoader imageLoader, Function1<? super ImageRequest.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context).data(drawable).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static final /* synthetic */ Disposable load(ImageView imageView, Bitmap bitmap, ImageLoader imageLoader, Function1<? super ImageRequest.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context).data(bitmap).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static /* synthetic */ Disposable load$default(ImageView imageView, int i11, ImageLoader imageLoader, Function1 function1, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "fun ImageView.load(\n    …Id, imageLoader, builder)");
            imageLoader = Coil.imageLoader(context);
        }
        if ((i12 & 4) != 0) {
            function1 = ImageViews$load$5.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Integer valueOf = Integer.valueOf(i11);
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context2).data(valueOf).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static /* synthetic */ Disposable load$default(ImageView imageView, Drawable drawable, ImageLoader imageLoader, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "fun ImageView.load(\n    …le, imageLoader, builder)");
            imageLoader = Coil.imageLoader(context);
        }
        if ((i11 & 4) != 0) {
            function1 = ImageViews$load$6.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context2).data(drawable).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }

    public static /* synthetic */ Disposable load$default(ImageView imageView, Bitmap bitmap, ImageLoader imageLoader, Function1 function1, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "fun ImageView.load(\n    …ap, imageLoader, builder)");
            imageLoader = Coil.imageLoader(context);
        }
        if ((i11 & 4) != 0) {
            function1 = ImageViews$load$7.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
        Intrinsics.checkNotNullParameter(function1, "builder");
        Context context2 = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        ImageRequest.Builder target = new ImageRequest.Builder(context2).data(bitmap).target(imageView);
        function1.invoke(target);
        return imageLoader.enqueue(target.build());
    }
}
