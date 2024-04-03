package coil.fetch;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import android.webkit.MimeTypeMap;
import coil.bitmap.BitmapPool;
import coil.decode.DataSource;
import coil.decode.DrawableDecoderService;
import coil.decode.Options;
import coil.size.Size;
import coil.util.Contexts;
import coil.util.Extensions;
import java.io.InputStream;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J1\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u0002H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcoil/fetch/ResourceUriFetcher;", "Lcoil/fetch/Fetcher;", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "drawableDecoder", "Lcoil/decode/DrawableDecoderService;", "(Landroid/content/Context;Lcoil/decode/DrawableDecoderService;)V", "fetch", "Lcoil/fetch/FetchResult;", "pool", "Lcoil/bitmap/BitmapPool;", "data", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Landroid/net/Uri;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handles", "", "key", "", "throwInvalidUriException", "", "Companion", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ResourceUriFetcher implements Fetcher<Uri> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String MIME_TYPE_XML = "text/xml";
    @NotNull
    private final Context context;
    @NotNull
    private final DrawableDecoderService drawableDecoder;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/fetch/ResourceUriFetcher$Companion;", "", "()V", "MIME_TYPE_XML", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ResourceUriFetcher(@NotNull Context context2, @NotNull DrawableDecoderService drawableDecoderService) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(drawableDecoderService, "drawableDecoder");
        this.context = context2;
        this.drawableDecoder = drawableDecoderService;
    }

    private final Void throwInvalidUriException(Uri uri) {
        throw new IllegalStateException(Intrinsics.stringPlus("Invalid android.resource URI: ", uri));
    }

    @Nullable
    public Object fetch(@NotNull BitmapPool bitmapPool, @NotNull Uri uri, @NotNull Size size, @NotNull Options options, @NotNull Continuation<? super FetchResult> continuation) {
        Drawable drawable;
        String authority = uri.getAuthority();
        Integer num = null;
        if (authority == null || !(!StringsKt__StringsJVMKt.isBlank(authority))) {
            authority = null;
        }
        if (authority != null) {
            List<String> pathSegments = uri.getPathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments, "data.pathSegments");
            String str = (String) CollectionsKt___CollectionsKt.lastOrNull(pathSegments);
            if (str != null) {
                num = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
            }
            if (num != null) {
                int intValue = num.intValue();
                Context context2 = options.getContext();
                Resources resourcesForApplication = context2.getPackageManager().getResourcesForApplication(authority);
                Intrinsics.checkNotNullExpressionValue(resourcesForApplication, "context.packageManager.g…rApplication(packageName)");
                TypedValue typedValue = new TypedValue();
                resourcesForApplication.getValue(intValue, typedValue, true);
                CharSequence charSequence = typedValue.string;
                Intrinsics.checkNotNullExpressionValue(charSequence, "path");
                String obj = charSequence.subSequence(StringsKt__StringsKt.lastIndexOf$default(charSequence, '/', 0, false, 6, (Object) null), charSequence.length()).toString();
                MimeTypeMap singleton = MimeTypeMap.getSingleton();
                Intrinsics.checkNotNullExpressionValue(singleton, "getSingleton()");
                String mimeTypeFromUrl = Extensions.getMimeTypeFromUrl(singleton, obj);
                if (Intrinsics.areEqual((Object) mimeTypeFromUrl, (Object) "text/xml")) {
                    if (Intrinsics.areEqual((Object) authority, (Object) context2.getPackageName())) {
                        drawable = Contexts.getDrawableCompat(context2, intValue);
                    } else {
                        drawable = Contexts.getXmlDrawableCompat(context2, resourcesForApplication, intValue);
                    }
                    Drawable drawable2 = drawable;
                    boolean isVector = Extensions.isVector(drawable2);
                    if (isVector) {
                        Bitmap convert = this.drawableDecoder.convert(drawable2, options.getConfig(), size, options.getScale(), options.getAllowInexactSize());
                        Resources resources = context2.getResources();
                        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
                        drawable2 = new BitmapDrawable(resources, convert);
                    }
                    return new DrawableResult(drawable2, isVector, DataSource.DISK);
                }
                InputStream openRawResource = resourcesForApplication.openRawResource(intValue);
                Intrinsics.checkNotNullExpressionValue(openRawResource, "resources.openRawResource(resId)");
                return new SourceResult(Okio.buffer(Okio.source(openRawResource)), mimeTypeFromUrl, DataSource.DISK);
            }
            throwInvalidUriException(uri);
            throw new KotlinNothingValueException();
        }
        throwInvalidUriException(uri);
        throw new KotlinNothingValueException();
    }

    public boolean handles(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "data");
        return Intrinsics.areEqual((Object) uri.getScheme(), (Object) "android.resource");
    }

    @NotNull
    public String key(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "data");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(uri);
        sb2.append(SignatureVisitor.SUPER);
        Configuration configuration = this.context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "context.resources.configuration");
        sb2.append(Extensions.getNightMode(configuration));
        return sb2.toString();
    }
}
