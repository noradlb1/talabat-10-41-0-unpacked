package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/font/TypefaceResult;", "onAsyncCompletion", "Lkotlin/Function1;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class FontFamilyResolverImpl$resolve$result$1 extends Lambda implements Function1<Function1<? super TypefaceResult, ? extends Unit>, TypefaceResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FontFamilyResolverImpl f10186g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TypefaceRequest f10187h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FontFamilyResolverImpl$resolve$result$1(FontFamilyResolverImpl fontFamilyResolverImpl, TypefaceRequest typefaceRequest) {
        super(1);
        this.f10186g = fontFamilyResolverImpl;
        this.f10187h = typefaceRequest;
    }

    @NotNull
    public final TypefaceResult invoke(@NotNull Function1<? super TypefaceResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onAsyncCompletion");
        TypefaceResult resolve = this.f10186g.fontListFontFamilyTypefaceAdapter.resolve(this.f10187h, this.f10186g.getPlatformFontLoader$ui_text_release(), function1, this.f10186g.createDefaultTypeface);
        if (resolve != null || (resolve = this.f10186g.platformFamilyTypefaceAdapter.resolve(this.f10187h, this.f10186g.getPlatformFontLoader$ui_text_release(), function1, this.f10186g.createDefaultTypeface)) != null) {
            return resolve;
        }
        throw new IllegalStateException("Could not load font");
    }
}
