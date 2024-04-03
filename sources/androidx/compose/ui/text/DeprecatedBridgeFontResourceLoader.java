package androidx.compose.ui.text;

import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import q0.b;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/DeprecatedBridgeFontResourceLoader;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "load", "", "font", "Landroidx/compose/ui/text/font/Font;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class DeprecatedBridgeFontResourceLoader implements Font.ResourceLoader {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static Map<FontFamily.Resolver, Font.ResourceLoader> cache = new LinkedHashMap();
    /* access modifiers changed from: private */
    @NotNull
    public static final SynchronizedObject lock = Synchronization_jvmKt.createSynchronizedObject();
    @NotNull
    private final FontFamily.Resolver fontFamilyResolver;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0005R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/DeprecatedBridgeFontResourceLoader$Companion;", "", "()V", "cache", "", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getCache", "()Ljava/util/Map;", "setCache", "(Ljava/util/Map;)V", "lock", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "getLock", "()Landroidx/compose/ui/text/platform/SynchronizedObject;", "from", "fontFamilyResolver", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Font.ResourceLoader from(@NotNull FontFamily.Resolver resolver) {
            Intrinsics.checkNotNullParameter(resolver, "fontFamilyResolver");
            synchronized (getLock()) {
                Companion companion = DeprecatedBridgeFontResourceLoader.Companion;
                Font.ResourceLoader resourceLoader = companion.getCache().get(resolver);
                if (resourceLoader != null) {
                    return resourceLoader;
                }
                DeprecatedBridgeFontResourceLoader deprecatedBridgeFontResourceLoader = new DeprecatedBridgeFontResourceLoader(resolver, (DefaultConstructorMarker) null);
                companion.getCache().put(resolver, deprecatedBridgeFontResourceLoader);
                return deprecatedBridgeFontResourceLoader;
            }
        }

        @NotNull
        public final Map<FontFamily.Resolver, Font.ResourceLoader> getCache() {
            return DeprecatedBridgeFontResourceLoader.cache;
        }

        @NotNull
        public final SynchronizedObject getLock() {
            return DeprecatedBridgeFontResourceLoader.lock;
        }

        public final void setCache(@NotNull Map<FontFamily.Resolver, Font.ResourceLoader> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            DeprecatedBridgeFontResourceLoader.cache = map;
        }
    }

    private DeprecatedBridgeFontResourceLoader(FontFamily.Resolver resolver) {
        this.fontFamilyResolver = resolver;
    }

    public /* synthetic */ DeprecatedBridgeFontResourceLoader(FontFamily.Resolver resolver, DefaultConstructorMarker defaultConstructorMarker) {
        this(resolver);
    }

    @NotNull
    @Deprecated(message = "Replaced by FontFamily.Resolver, this method should not be called", replaceWith = @ReplaceWith(expression = "FontFamily.Resolver.resolve(font, )", imports = {}))
    public Object load(@NotNull Font font) {
        Intrinsics.checkNotNullParameter(font, "font");
        return b.a(this.fontFamilyResolver, FontKt.toFontFamily(font), font.getWeight(), font.m5099getStyle_LCdwA(), 0, 8, (Object) null).getValue();
    }
}
