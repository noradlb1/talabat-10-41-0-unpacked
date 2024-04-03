package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.InternalTextApi;
import androidx.compose.ui.text.font.FontFamily;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"createFontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "context", "Landroid/content/Context;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "emptyCacheFontFamilyResolver", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FontFamilyResolver_androidKt {
    @NotNull
    public static final FontFamily.Resolver createFontFamilyResolver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new FontFamilyResolverImpl(new AndroidFontLoader(context), AndroidFontResolveInterceptor_androidKt.AndroidFontResolveInterceptor(context), (TypefaceRequestCache) null, (FontListFontFamilyTypefaceAdapter) null, (PlatformFontFamilyTypefaceAdapter) null, 28, (DefaultConstructorMarker) null);
    }

    @NotNull
    @InternalTextApi
    public static final FontFamily.Resolver emptyCacheFontFamilyResolver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new FontFamilyResolverImpl(new AndroidFontLoader(context), (PlatformResolveInterceptor) null, new TypefaceRequestCache(), new FontListFontFamilyTypefaceAdapter(new AsyncTypefaceCache(), (CoroutineContext) null, 2, (DefaultConstructorMarker) null), (PlatformFontFamilyTypefaceAdapter) null, 18, (DefaultConstructorMarker) null);
    }

    @ExperimentalTextApi
    @NotNull
    public static final FontFamily.Resolver createFontFamilyResolver(@NotNull Context context, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return new FontFamilyResolverImpl(new AndroidFontLoader(context), AndroidFontResolveInterceptor_androidKt.AndroidFontResolveInterceptor(context), FontFamilyResolverKt.getGlobalTypefaceRequestCache(), new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), coroutineContext), (PlatformFontFamilyTypefaceAdapter) null, 16, (DefaultConstructorMarker) null);
    }
}
