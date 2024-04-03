package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.ExperimentalTextApi;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

@Immutable
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010R#\u0010\u0002\u001a\u00020\u00038gX§\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\tX¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eø\u0001\u0003\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/font/Font;", "", "loadingStrategy", "Landroidx/compose/ui/text/font/FontLoadingStrategy;", "getLoadingStrategy-PKNRLFQ$annotations", "()V", "getLoadingStrategy-PKNRLFQ", "()I", "style", "Landroidx/compose/ui/text/font/FontStyle;", "getStyle-_-LCdwA", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "getWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "Companion", "ResourceLoader", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface Font {
    @NotNull
    public static final Companion Companion = Companion.f10178a;
    public static final long MaximumAsyncTimeout = 15000;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/text/font/Font$Companion;", "", "()V", "MaximumAsyncTimeout", "", "getMaximumAsyncTimeout$ui_text_release$annotations", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public static final long MaximumAsyncTimeout = 15000;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f10178a = new Companion();

        private Companion() {
        }

        @ExperimentalTextApi
        public static /* synthetic */ void getMaximumAsyncTimeout$ui_text_release$annotations() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H'ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/font/Font$ResourceLoader;", "", "load", "font", "Landroidx/compose/ui/text/font/Font;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Deprecated(message = "Replaced with FontFamily.Resolver during the introduction of async fonts, all usages should be replaced. Custom subclasses can be converted into a FontFamily.Resolver by calling createFontFamilyResolver(myFontFamilyResolver, context)")
    public interface ResourceLoader {
        @NotNull
        @Deprecated(message = "Replaced by FontFamily.Resolver, this method should not be called", replaceWith = @ReplaceWith(expression = "FontFamily.Resolver.resolve(font, )", imports = {}))
        Object load(@NotNull Font font);
    }

    @ExperimentalTextApi
    /* renamed from: getLoadingStrategy-PKNRLFQ  reason: not valid java name */
    int m5098getLoadingStrategyPKNRLFQ();

    /* renamed from: getStyle-_-LCdwA  reason: not valid java name */
    int m5099getStyle_LCdwA();

    @NotNull
    FontWeight getWeight();
}
