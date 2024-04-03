package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/font/TypefaceResult;", "typeRequest", "Landroidx/compose/ui/text/font/TypefaceRequest;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class FontFamilyResolverImpl$preload$2 extends Lambda implements Function1<TypefaceRequest, TypefaceResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FontFamilyResolverImpl f10185g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FontFamilyResolverImpl$preload$2(FontFamilyResolverImpl fontFamilyResolverImpl) {
        super(1);
        this.f10185g = fontFamilyResolverImpl;
    }

    @NotNull
    public final TypefaceResult invoke(@NotNull TypefaceRequest typefaceRequest) {
        Intrinsics.checkNotNullParameter(typefaceRequest, "typeRequest");
        TypefaceResult resolve = this.f10185g.fontListFontFamilyTypefaceAdapter.resolve(typefaceRequest, this.f10185g.getPlatformFontLoader$ui_text_release(), AnonymousClass1.INSTANCE, this.f10185g.createDefaultTypeface);
        if (resolve != null || (resolve = this.f10185g.platformFamilyTypefaceAdapter.resolve(typefaceRequest, this.f10185g.getPlatformFontLoader$ui_text_release(), AnonymousClass2.INSTANCE, this.f10185g.createDefaultTypeface)) != null) {
            return resolve;
        }
        throw new IllegalStateException("Could not load font");
    }
}
