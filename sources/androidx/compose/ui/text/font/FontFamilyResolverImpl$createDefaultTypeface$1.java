package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/text/font/TypefaceRequest;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class FontFamilyResolverImpl$createDefaultTypeface$1 extends Lambda implements Function1<TypefaceRequest, Object> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FontFamilyResolverImpl f10179g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FontFamilyResolverImpl$createDefaultTypeface$1(FontFamilyResolverImpl fontFamilyResolverImpl) {
        super(1);
        this.f10179g = fontFamilyResolverImpl;
    }

    @NotNull
    public final Object invoke(@NotNull TypefaceRequest typefaceRequest) {
        Intrinsics.checkNotNullParameter(typefaceRequest, "it");
        return this.f10179g.resolve(TypefaceRequest.m5171copye1PVR60$default(typefaceRequest, (FontFamily) null, (FontWeight) null, 0, 0, (Object) null, 30, (Object) null)).getValue();
    }
}
