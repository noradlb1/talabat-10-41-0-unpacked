package androidx.compose.ui.text.platform;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontListFontFamily;
import androidx.compose.ui.text.font.FontMatcher;
import androidx.compose.ui.text.font.FontSynthesis_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\fø\u0001\u0000¢\u0006\u0002\u0010\rJ-\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u00020\f¢\u0006\n\n\u0002\b\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Landroidx/compose/ui/text/platform/AndroidFontListTypeface;", "Landroidx/compose/ui/text/platform/AndroidTypeface;", "fontFamily", "Landroidx/compose/ui/text/font/FontListFontFamily;", "context", "Landroid/content/Context;", "necessaryStyles", "", "Lkotlin/Pair;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroid/content/Context;Ljava/util/List;Landroidx/compose/ui/text/font/FontMatcher;)V", "Landroidx/compose/ui/text/font/FontFamily;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "fontMatcher$1", "loadedTypefaces", "", "Landroidx/compose/ui/text/font/Font;", "Landroid/graphics/Typeface;", "getNativeTypeface", "fontWeight", "fontStyle", "synthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "getNativeTypeface-PYhJU0U", "(Landroidx/compose/ui/text/font/FontWeight;II)Landroid/graphics/Typeface;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(message = "This is not supported after downloadable fonts.")
public final class AndroidFontListTypeface implements AndroidTypeface {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    @Deprecated
    public static final FontMatcher fontMatcher = new FontMatcher();
    @NotNull
    private final FontFamily fontFamily;
    @NotNull
    private final FontMatcher fontMatcher$1;
    @NotNull
    private final Map<Font, Typeface> loadedTypefaces;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidFontListTypeface$Companion;", "", "()V", "fontMatcher", "Landroidx/compose/ui/text/font/FontMatcher;", "getFontMatcher", "()Landroidx/compose/ui/text/font/FontMatcher;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FontMatcher getFontMatcher() {
            return AndroidFontListTypeface.fontMatcher;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AndroidFontListTypeface(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.FontListFontFamily r8, @org.jetbrains.annotations.NotNull android.content.Context r9, @org.jetbrains.annotations.Nullable java.util.List<kotlin.Pair<androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle>> r10, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.FontMatcher r11) {
        /*
            r7 = this;
            java.lang.String r0 = "fontFamily"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "fontMatcher"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r7.<init>()
            r7.fontMatcher$1 = r11
            java.util.List r11 = r8.getFonts()
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r11.size()
            r0.<init>(r1)
            int r1 = r11.size()
            r2 = 0
            r3 = r2
        L_0x0027:
            if (r3 >= r1) goto L_0x0046
            java.lang.Object r4 = r11.get(r3)
            r5 = r4
            androidx.compose.ui.text.font.Font r5 = (androidx.compose.ui.text.font.Font) r5
            int r5 = r5.m5098getLoadingStrategyPKNRLFQ()
            androidx.compose.ui.text.font.FontLoadingStrategy$Companion r6 = androidx.compose.ui.text.font.FontLoadingStrategy.Companion
            int r6 = r6.m5116getBlockingPKNRLFQ()
            boolean r5 = androidx.compose.ui.text.font.FontLoadingStrategy.m5111equalsimpl0(r5, r6)
            if (r5 == 0) goto L_0x0043
            r0.add(r4)
        L_0x0043:
            int r3 = r3 + 1
            goto L_0x0027
        L_0x0046:
            if (r10 == 0) goto L_0x00b2
            java.util.ArrayList r11 = new java.util.ArrayList
            int r1 = r10.size()
            r11.<init>(r1)
            int r1 = r10.size()
            r3 = r2
        L_0x0056:
            if (r3 >= r1) goto L_0x0080
            java.lang.Object r4 = r10.get(r3)
            kotlin.Pair r4 = (kotlin.Pair) r4
            java.lang.Object r5 = r4.component1()
            androidx.compose.ui.text.font.FontWeight r5 = (androidx.compose.ui.text.font.FontWeight) r5
            java.lang.Object r4 = r4.component2()
            androidx.compose.ui.text.font.FontStyle r4 = (androidx.compose.ui.text.font.FontStyle) r4
            int r4 = r4.m5127unboximpl()
            androidx.compose.ui.text.font.FontMatcher r6 = r7.fontMatcher$1
            java.util.List r4 = r6.m5120matchFontRetOiIg((java.util.List<? extends androidx.compose.ui.text.font.Font>) r0, (androidx.compose.ui.text.font.FontWeight) r5, (int) r4)
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r4)
            androidx.compose.ui.text.font.Font r4 = (androidx.compose.ui.text.font.Font) r4
            r11.add(r4)
            int r3 = r3 + 1
            goto L_0x0056
        L_0x0080:
            java.util.List r10 = androidx.compose.ui.text.TempListUtilsKt.fastFilterNotNull(r11)
            if (r10 == 0) goto L_0x00b2
            java.util.HashSet r11 = new java.util.HashSet
            int r1 = r10.size()
            r11.<init>(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            int r3 = r10.size()
            r1.<init>(r3)
            int r3 = r10.size()
            r4 = r2
        L_0x009d:
            if (r4 >= r3) goto L_0x00b3
            java.lang.Object r5 = r10.get(r4)
            r6 = r5
            androidx.compose.ui.text.font.Font r6 = (androidx.compose.ui.text.font.Font) r6
            boolean r6 = r11.add(r6)
            if (r6 == 0) goto L_0x00af
            r1.add(r5)
        L_0x00af:
            int r4 = r4 + 1
            goto L_0x009d
        L_0x00b2:
            r1 = 0
        L_0x00b3:
            if (r1 != 0) goto L_0x00b6
            goto L_0x00b7
        L_0x00b6:
            r0 = r1
        L_0x00b7:
            boolean r10 = r0.isEmpty()
            if (r10 != 0) goto L_0x00f6
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            int r11 = r0.size()
        L_0x00c6:
            if (r2 >= r11) goto L_0x00f1
            java.lang.Object r1 = r0.get(r2)
            androidx.compose.ui.text.font.Font r1 = (androidx.compose.ui.text.font.Font) r1
            androidx.compose.ui.text.platform.AndroidTypefaceCache r3 = androidx.compose.ui.text.platform.AndroidTypefaceCache.INSTANCE     // Catch:{ Exception -> 0x00da }
            android.graphics.Typeface r3 = r3.getOrCreate(r9, r1)     // Catch:{ Exception -> 0x00da }
            r10.put(r1, r3)     // Catch:{ Exception -> 0x00da }
            int r2 = r2 + 1
            goto L_0x00c6
        L_0x00da:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Cannot create Typeface from "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x00f1:
            r7.loadedTypefaces = r10
            r7.fontFamily = r8
            return
        L_0x00f6:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Could not match font"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidFontListTypeface.<init>(androidx.compose.ui.text.font.FontListFontFamily, android.content.Context, java.util.List, androidx.compose.ui.text.font.FontMatcher):void");
    }

    @NotNull
    public FontFamily getFontFamily() {
        return this.fontFamily;
    }

    @NotNull
    public final FontMatcher getFontMatcher() {
        return this.fontMatcher$1;
    }

    @NotNull
    /* renamed from: getNativeTypeface-PYhJU0U  reason: not valid java name */
    public Typeface m5239getNativeTypefacePYhJU0U(@NotNull FontWeight fontWeight, int i11, int i12) {
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        Font font = (Font) CollectionsKt___CollectionsKt.firstOrNull(this.fontMatcher$1.m5120matchFontRetOiIg((List<? extends Font>) new ArrayList(this.loadedTypefaces.keySet()), fontWeight, i11));
        if (font != null) {
            Typeface typeface = this.loadedTypefaces.get(font);
            if (typeface != null) {
                Object r42 = FontSynthesis_androidKt.m5143synthesizeTypefaceFxwP2eA(i12, typeface, font, fontWeight, i11);
                Intrinsics.checkNotNull(r42, "null cannot be cast to non-null type android.graphics.Typeface");
                return (Typeface) r42;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalStateException("Could not load font");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidFontListTypeface(FontListFontFamily fontListFontFamily, Context context, List list, FontMatcher fontMatcher2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(fontListFontFamily, context, (i11 & 4) != 0 ? null : list, (i11 & 8) != 0 ? fontMatcher : fontMatcher2);
    }
}
