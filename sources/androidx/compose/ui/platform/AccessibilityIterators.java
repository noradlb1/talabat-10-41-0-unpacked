package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators;", "", "()V", "AbstractTextSegmentIterator", "CharacterTextSegmentIterator", "LineTextSegmentIterator", "PageTextSegmentIterator", "ParagraphTextSegmentIterator", "TextSegmentIterator", "WordTextSegmentIterator", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AccessibilityIterators {

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0004R\"\u0010\u0003\u001a\u00020\u00028\u0004@\u0004X.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "", "text", "", "initialize", "", "start", "end", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "segment", "[I", "<init>", "()V", "ui_release"}, k = 1, mv = {1, 7, 1})
    public static abstract class AbstractTextSegmentIterator implements TextSegmentIterator {
        public static final int $stable = 8;

        /* renamed from: a  reason: collision with root package name */
        public String f9975a;
        @NotNull
        private final int[] segment = new int[2];

        @Nullable
        public final int[] a(int i11, int i12) {
            if (i11 < 0 || i12 < 0 || i11 == i12) {
                return null;
            }
            int[] iArr = this.segment;
            iArr[0] = i11;
            iArr[1] = i12;
            return iArr;
        }

        @NotNull
        public final String b() {
            String str = this.f9975a;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("text");
            return null;
        }

        public final void c(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f9975a = str;
        }

        public void initialize(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            c(str);
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "locale", "Ljava/util/Locale;", "(Ljava/util/Locale;)V", "impl", "Ljava/text/BreakIterator;", "following", "", "current", "", "initialize", "", "text", "", "onLocaleChanged", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class CharacterTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 8;
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        @Nullable
        public static CharacterTextSegmentIterator instance;
        private BreakIterator impl;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator$Companion;", "", "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator;", "getInstance", "locale", "Ljava/util/Locale;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final CharacterTextSegmentIterator getInstance(@NotNull Locale locale) {
                Intrinsics.checkNotNullParameter(locale, "locale");
                if (CharacterTextSegmentIterator.instance == null) {
                    CharacterTextSegmentIterator.instance = new CharacterTextSegmentIterator(locale, (DefaultConstructorMarker) null);
                }
                CharacterTextSegmentIterator access$getInstance$cp = CharacterTextSegmentIterator.instance;
                Intrinsics.checkNotNull(access$getInstance$cp, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator");
                return access$getInstance$cp;
            }
        }

        private CharacterTextSegmentIterator(Locale locale) {
            onLocaleChanged(locale);
        }

        public /* synthetic */ CharacterTextSegmentIterator(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
            this(locale);
        }

        private final void onLocaleChanged(Locale locale) {
            BreakIterator characterInstance = BreakIterator.getCharacterInstance(locale);
            Intrinsics.checkNotNullExpressionValue(characterInstance, "getCharacterInstance(locale)");
            this.impl = characterInstance;
        }

        @Nullable
        public int[] following(int i11) {
            int length = b().length();
            if (length <= 0 || i11 >= length) {
                return null;
            }
            if (i11 < 0) {
                i11 = 0;
            }
            do {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator = null;
                }
                if (!breakIterator.isBoundary(i11)) {
                    BreakIterator breakIterator2 = this.impl;
                    if (breakIterator2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        breakIterator2 = null;
                    }
                    i11 = breakIterator2.following(i11);
                } else {
                    BreakIterator breakIterator3 = this.impl;
                    if (breakIterator3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        breakIterator3 = null;
                    }
                    int following = breakIterator3.following(i11);
                    if (following == -1) {
                        return null;
                    }
                    return a(i11, following);
                }
            } while (i11 != -1);
            return null;
        }

        public void initialize(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            super.initialize(str);
            BreakIterator breakIterator = this.impl;
            if (breakIterator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator = null;
            }
            breakIterator.setText(str);
        }

        @Nullable
        public int[] preceding(int i11) {
            int length = b().length();
            if (length <= 0 || i11 <= 0) {
                return null;
            }
            if (i11 > length) {
                i11 = length;
            }
            do {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator = null;
                }
                if (!breakIterator.isBoundary(i11)) {
                    BreakIterator breakIterator2 = this.impl;
                    if (breakIterator2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        breakIterator2 = null;
                    }
                    i11 = breakIterator2.preceding(i11);
                } else {
                    BreakIterator breakIterator3 = this.impl;
                    if (breakIterator3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        breakIterator3 = null;
                    }
                    int preceding = breakIterator3.preceding(i11);
                    if (preceding == -1) {
                        return null;
                    }
                    return a(preceding, i11);
                }
            } while (i11 != -1);
            return null;
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "()V", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "following", "", "current", "", "getLineEdgeIndex", "lineNumber", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "initialize", "", "text", "", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class LineTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 8;
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @NotNull
        private static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;
        @NotNull
        private static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;
        /* access modifiers changed from: private */
        @Nullable
        public static LineTextSegmentIterator lineInstance;
        private TextLayoutResult layoutResult;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator$Companion;", "", "()V", "DirectionEnd", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "DirectionStart", "lineInstance", "Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator;", "getInstance", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final LineTextSegmentIterator getInstance() {
                if (LineTextSegmentIterator.lineInstance == null) {
                    LineTextSegmentIterator.lineInstance = new LineTextSegmentIterator((DefaultConstructorMarker) null);
                }
                LineTextSegmentIterator access$getLineInstance$cp = LineTextSegmentIterator.lineInstance;
                Intrinsics.checkNotNull(access$getLineInstance$cp, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator");
                return access$getLineInstance$cp;
            }
        }

        private LineTextSegmentIterator() {
        }

        public /* synthetic */ LineTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int getLineEdgeIndex(int i11, ResolvedTextDirection resolvedTextDirection) {
            TextLayoutResult textLayoutResult = this.layoutResult;
            TextLayoutResult textLayoutResult2 = null;
            if (textLayoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult = null;
            }
            int lineStart = textLayoutResult.getLineStart(i11);
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult3 = null;
            }
            if (resolvedTextDirection != textLayoutResult3.getParagraphDirection(lineStart)) {
                TextLayoutResult textLayoutResult4 = this.layoutResult;
                if (textLayoutResult4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                } else {
                    textLayoutResult2 = textLayoutResult4;
                }
                return textLayoutResult2.getLineStart(i11);
            }
            TextLayoutResult textLayoutResult5 = this.layoutResult;
            if (textLayoutResult5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult5 = null;
            }
            return TextLayoutResult.getLineEnd$default(textLayoutResult5, i11, false, 2, (Object) null) - 1;
        }

        @Nullable
        public int[] following(int i11) {
            int i12;
            if (b().length() <= 0 || i11 >= b().length()) {
                return null;
            }
            if (i11 < 0) {
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult = null;
                }
                i12 = textLayoutResult.getLineForOffset(0);
            } else {
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset = textLayoutResult2.getLineForOffset(i11);
                if (getLineEdgeIndex(lineForOffset, DirectionStart) == i11) {
                    i12 = lineForOffset;
                } else {
                    i12 = lineForOffset + 1;
                }
            }
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult3 = null;
            }
            if (i12 >= textLayoutResult3.getLineCount()) {
                return null;
            }
            return a(getLineEdgeIndex(i12, DirectionStart), getLineEdgeIndex(i12, DirectionEnd) + 1);
        }

        public final void initialize(@NotNull String str, @NotNull TextLayoutResult textLayoutResult) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(textLayoutResult, "layoutResult");
            c(str);
            this.layoutResult = textLayoutResult;
        }

        @Nullable
        public int[] preceding(int i11) {
            int i12;
            if (b().length() <= 0 || i11 <= 0) {
                return null;
            }
            if (i11 > b().length()) {
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult = null;
                }
                i12 = textLayoutResult.getLineForOffset(b().length());
            } else {
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset = textLayoutResult2.getLineForOffset(i11);
                if (getLineEdgeIndex(lineForOffset, DirectionEnd) + 1 == i11) {
                    i12 = lineForOffset;
                } else {
                    i12 = lineForOffset - 1;
                }
            }
            if (i12 < 0) {
                return null;
            }
            return a(getLineEdgeIndex(i12, DirectionStart), getLineEdgeIndex(i12, DirectionEnd) + 1);
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "()V", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "tempRect", "Landroid/graphics/Rect;", "following", "", "current", "", "getLineEdgeIndex", "lineNumber", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "initialize", "", "text", "", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PageTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 8;
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @NotNull
        private static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;
        @NotNull
        private static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;
        /* access modifiers changed from: private */
        @Nullable
        public static PageTextSegmentIterator pageInstance;
        private TextLayoutResult layoutResult;
        private SemanticsNode node;
        @NotNull
        private Rect tempRect;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator$Companion;", "", "()V", "DirectionEnd", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "DirectionStart", "pageInstance", "Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator;", "getInstance", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final PageTextSegmentIterator getInstance() {
                if (PageTextSegmentIterator.pageInstance == null) {
                    PageTextSegmentIterator.pageInstance = new PageTextSegmentIterator((DefaultConstructorMarker) null);
                }
                PageTextSegmentIterator access$getPageInstance$cp = PageTextSegmentIterator.pageInstance;
                Intrinsics.checkNotNull(access$getPageInstance$cp, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator");
                return access$getPageInstance$cp;
            }
        }

        private PageTextSegmentIterator() {
            this.tempRect = new Rect();
        }

        public /* synthetic */ PageTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int getLineEdgeIndex(int i11, ResolvedTextDirection resolvedTextDirection) {
            TextLayoutResult textLayoutResult = this.layoutResult;
            TextLayoutResult textLayoutResult2 = null;
            if (textLayoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult = null;
            }
            int lineStart = textLayoutResult.getLineStart(i11);
            TextLayoutResult textLayoutResult3 = this.layoutResult;
            if (textLayoutResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult3 = null;
            }
            if (resolvedTextDirection != textLayoutResult3.getParagraphDirection(lineStart)) {
                TextLayoutResult textLayoutResult4 = this.layoutResult;
                if (textLayoutResult4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                } else {
                    textLayoutResult2 = textLayoutResult4;
                }
                return textLayoutResult2.getLineStart(i11);
            }
            TextLayoutResult textLayoutResult5 = this.layoutResult;
            if (textLayoutResult5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult5 = null;
            }
            return TextLayoutResult.getLineEnd$default(textLayoutResult5, i11, false, 2, (Object) null) - 1;
        }

        @Nullable
        public int[] following(int i11) {
            int i12;
            TextLayoutResult textLayoutResult = null;
            if (b().length() <= 0 || i11 >= b().length()) {
                return null;
            }
            try {
                SemanticsNode semanticsNode = this.node;
                if (semanticsNode == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("node");
                    semanticsNode = null;
                }
                int roundToInt = MathKt__MathJVMKt.roundToInt(semanticsNode.getBoundsInRoot().getHeight());
                int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, i11);
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset = textLayoutResult2.getLineForOffset(coerceAtLeast);
                TextLayoutResult textLayoutResult3 = this.layoutResult;
                if (textLayoutResult3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult3 = null;
                }
                float lineTop = textLayoutResult3.getLineTop(lineForOffset) + ((float) roundToInt);
                TextLayoutResult textLayoutResult4 = this.layoutResult;
                if (textLayoutResult4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult4 = null;
                }
                TextLayoutResult textLayoutResult5 = this.layoutResult;
                if (textLayoutResult5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult5 = null;
                }
                if (lineTop < textLayoutResult4.getLineTop(textLayoutResult5.getLineCount() - 1)) {
                    TextLayoutResult textLayoutResult6 = this.layoutResult;
                    if (textLayoutResult6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult6;
                    }
                    i12 = textLayoutResult.getLineForVerticalPosition(lineTop);
                } else {
                    TextLayoutResult textLayoutResult7 = this.layoutResult;
                    if (textLayoutResult7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult7;
                    }
                    i12 = textLayoutResult.getLineCount();
                }
                return a(coerceAtLeast, getLineEdgeIndex(i12 - 1, DirectionEnd) + 1);
            } catch (IllegalStateException unused) {
                return null;
            }
        }

        public final void initialize(@NotNull String str, @NotNull TextLayoutResult textLayoutResult, @NotNull SemanticsNode semanticsNode) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(textLayoutResult, "layoutResult");
            Intrinsics.checkNotNullParameter(semanticsNode, "node");
            c(str);
            this.layoutResult = textLayoutResult;
            this.node = semanticsNode;
        }

        @Nullable
        public int[] preceding(int i11) {
            int i12;
            TextLayoutResult textLayoutResult = null;
            if (b().length() <= 0 || i11 <= 0) {
                return null;
            }
            try {
                SemanticsNode semanticsNode = this.node;
                if (semanticsNode == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("node");
                    semanticsNode = null;
                }
                int roundToInt = MathKt__MathJVMKt.roundToInt(semanticsNode.getBoundsInRoot().getHeight());
                int coerceAtMost = RangesKt___RangesKt.coerceAtMost(b().length(), i11);
                TextLayoutResult textLayoutResult2 = this.layoutResult;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int lineForOffset = textLayoutResult2.getLineForOffset(coerceAtMost);
                TextLayoutResult textLayoutResult3 = this.layoutResult;
                if (textLayoutResult3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult3 = null;
                }
                float lineTop = textLayoutResult3.getLineTop(lineForOffset) - ((float) roundToInt);
                if (lineTop > 0.0f) {
                    TextLayoutResult textLayoutResult4 = this.layoutResult;
                    if (textLayoutResult4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult4;
                    }
                    i12 = textLayoutResult.getLineForVerticalPosition(lineTop);
                } else {
                    i12 = 0;
                }
                if (coerceAtMost == b().length() && i12 < lineForOffset) {
                    i12++;
                }
                return a(getLineEdgeIndex(i12, DirectionStart), coerceAtMost);
            } catch (IllegalStateException unused) {
                return null;
            }
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "()V", "following", "", "current", "", "isEndBoundary", "", "index", "isStartBoundary", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ParagraphTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 0;
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        @Nullable
        public static ParagraphTextSegmentIterator instance;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator$Companion;", "", "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator;", "getInstance", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final ParagraphTextSegmentIterator getInstance() {
                if (ParagraphTextSegmentIterator.instance == null) {
                    ParagraphTextSegmentIterator.instance = new ParagraphTextSegmentIterator((DefaultConstructorMarker) null);
                }
                ParagraphTextSegmentIterator access$getInstance$cp = ParagraphTextSegmentIterator.instance;
                Intrinsics.checkNotNull(access$getInstance$cp, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator");
                return access$getInstance$cp;
            }
        }

        private ParagraphTextSegmentIterator() {
        }

        public /* synthetic */ ParagraphTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isEndBoundary(int i11) {
            if (i11 <= 0 || b().charAt(i11 - 1) == 10 || (i11 != b().length() && b().charAt(i11) != 10)) {
                return false;
            }
            return true;
        }

        private final boolean isStartBoundary(int i11) {
            if (b().charAt(i11) == 10 || (i11 != 0 && b().charAt(i11 - 1) != 10)) {
                return false;
            }
            return true;
        }

        @Nullable
        public int[] following(int i11) {
            int length = b().length();
            if (length <= 0 || i11 >= length) {
                return null;
            }
            if (i11 < 0) {
                i11 = 0;
            }
            while (i11 < length && b().charAt(i11) == 10 && !isStartBoundary(i11)) {
                i11++;
            }
            if (i11 >= length) {
                return null;
            }
            int i12 = i11 + 1;
            while (i12 < length && !isEndBoundary(i12)) {
                i12++;
            }
            return a(i11, i12);
        }

        @Nullable
        public int[] preceding(int i11) {
            int length = b().length();
            if (length <= 0 || i11 <= 0) {
                return null;
            }
            if (i11 > length) {
                i11 = length;
            }
            while (i11 > 0 && b().charAt(i11 - 1) == 10 && !isEndBoundary(i11)) {
                i11--;
            }
            if (i11 <= 0) {
                return null;
            }
            int i12 = i11 - 1;
            while (i12 > 0 && !isStartBoundary(i12)) {
                i12--;
            }
            return a(i12, i11);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "", "following", "", "current", "", "preceding", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface TextSegmentIterator {
        @Nullable
        int[] following(int i11);

        @Nullable
        int[] preceding(int i11);
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "locale", "Ljava/util/Locale;", "(Ljava/util/Locale;)V", "impl", "Ljava/text/BreakIterator;", "following", "", "current", "", "initialize", "", "text", "", "isEndBoundary", "", "index", "isLetterOrDigit", "isStartBoundary", "onLocaleChanged", "preceding", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class WordTextSegmentIterator extends AbstractTextSegmentIterator {
        public static final int $stable = 8;
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        @Nullable
        public static WordTextSegmentIterator instance;
        private BreakIterator impl;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator$Companion;", "", "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator;", "getInstance", "locale", "Ljava/util/Locale;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final WordTextSegmentIterator getInstance(@NotNull Locale locale) {
                Intrinsics.checkNotNullParameter(locale, "locale");
                if (WordTextSegmentIterator.instance == null) {
                    WordTextSegmentIterator.instance = new WordTextSegmentIterator(locale, (DefaultConstructorMarker) null);
                }
                WordTextSegmentIterator access$getInstance$cp = WordTextSegmentIterator.instance;
                Intrinsics.checkNotNull(access$getInstance$cp, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator");
                return access$getInstance$cp;
            }
        }

        private WordTextSegmentIterator(Locale locale) {
            onLocaleChanged(locale);
        }

        public /* synthetic */ WordTextSegmentIterator(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
            this(locale);
        }

        private final boolean isEndBoundary(int i11) {
            if (i11 <= 0 || !isLetterOrDigit(i11 - 1) || (i11 != b().length() && isLetterOrDigit(i11))) {
                return false;
            }
            return true;
        }

        private final boolean isLetterOrDigit(int i11) {
            if (i11 < 0 || i11 >= b().length()) {
                return false;
            }
            return Character.isLetterOrDigit(b().codePointAt(i11));
        }

        private final boolean isStartBoundary(int i11) {
            if (!isLetterOrDigit(i11) || (i11 != 0 && isLetterOrDigit(i11 - 1))) {
                return false;
            }
            return true;
        }

        private final void onLocaleChanged(Locale locale) {
            BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
            Intrinsics.checkNotNullExpressionValue(wordInstance, "getWordInstance(locale)");
            this.impl = wordInstance;
        }

        @Nullable
        public int[] following(int i11) {
            if (b().length() <= 0 || i11 >= b().length()) {
                return null;
            }
            if (i11 < 0) {
                i11 = 0;
            }
            while (!isLetterOrDigit(i11) && !isStartBoundary(i11)) {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator = null;
                }
                i11 = breakIterator.following(i11);
                if (i11 == -1) {
                    return null;
                }
            }
            BreakIterator breakIterator2 = this.impl;
            if (breakIterator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator2 = null;
            }
            int following = breakIterator2.following(i11);
            if (following == -1 || !isEndBoundary(following)) {
                return null;
            }
            return a(i11, following);
        }

        public void initialize(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            super.initialize(str);
            BreakIterator breakIterator = this.impl;
            if (breakIterator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator = null;
            }
            breakIterator.setText(str);
        }

        @Nullable
        public int[] preceding(int i11) {
            int length = b().length();
            if (length <= 0 || i11 <= 0) {
                return null;
            }
            if (i11 > length) {
                i11 = length;
            }
            while (i11 > 0 && !isLetterOrDigit(i11 - 1) && !isEndBoundary(i11)) {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator = null;
                }
                i11 = breakIterator.preceding(i11);
                if (i11 == -1) {
                    return null;
                }
            }
            BreakIterator breakIterator2 = this.impl;
            if (breakIterator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator2 = null;
            }
            int preceding = breakIterator2.preceding(i11);
            if (preceding == -1 || !isStartBoundary(preceding)) {
                return null;
            }
            return a(preceding, i11);
        }
    }
}
