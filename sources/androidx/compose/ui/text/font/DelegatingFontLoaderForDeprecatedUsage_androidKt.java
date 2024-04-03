package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"createFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontResourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "context", "Landroid/content/Context;", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DelegatingFontLoaderForDeprecatedUsage_androidKt {
    @NotNull
    @Deprecated(message = "This exists to bridge existing Font.ResourceLoader subclasses to be used as aFontFamily.ResourceLoader during upgrade.", replaceWith = @ReplaceWith(expression = "createFontFamilyResolver()", imports = {}))
    public static final FontFamily.Resolver createFontFamilyResolver(@NotNull Font.ResourceLoader resourceLoader, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(resourceLoader, "fontResourceLoader");
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        return new FontFamilyResolverImpl(new DelegatingFontLoaderForBridgeUsage(resourceLoader, applicationContext), (PlatformResolveInterceptor) null, (TypefaceRequestCache) null, (FontListFontFamilyTypefaceAdapter) null, (PlatformFontFamilyTypefaceAdapter) null, 30, (DefaultConstructorMarker) null);
    }

    @NotNull
    @Deprecated(message = "This exists to bridge existing Font.ResourceLoader APIs, and should be removed with them", replaceWith = @ReplaceWith(expression = "createFontFamilyResolver()", imports = {}))
    public static final FontFamily.Resolver createFontFamilyResolver(@NotNull Font.ResourceLoader resourceLoader) {
        Intrinsics.checkNotNullParameter(resourceLoader, "fontResourceLoader");
        return new FontFamilyResolverImpl(new DelegatingFontLoaderForDeprecatedUsage(resourceLoader), (PlatformResolveInterceptor) null, (TypefaceRequestCache) null, (FontListFontFamilyTypefaceAdapter) null, (PlatformFontFamilyTypefaceAdapter) null, 30, (DefaultConstructorMarker) null);
    }
}
