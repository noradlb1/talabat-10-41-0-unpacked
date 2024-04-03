package androidx.compose.ui.text.style;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.ExperimentalTextApi;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@ExperimentalTextApi
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ1\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u001c\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\n\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak;", "", "strategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "strictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "wordBreak", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStrategy-fcGXIks", "()I", "I", "getStrictness-usljTpc", "getWordBreak-jp8hJ3c", "copy", "copy-vyCVYYw", "(III)Landroidx/compose/ui/text/style/LineBreak;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "Strategy", "Strictness", "WordBreak", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LineBreak {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final LineBreak Heading;
    /* access modifiers changed from: private */
    @NotNull
    public static final LineBreak Paragraph;
    /* access modifiers changed from: private */
    @NotNull
    public static final LineBreak Simple;
    private final int strategy;
    private final int strictness;
    private final int wordBreak;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Companion;", "", "()V", "Heading", "Landroidx/compose/ui/text/style/LineBreak;", "getHeading", "()Landroidx/compose/ui/text/style/LineBreak;", "Paragraph", "getParagraph", "Simple", "getSimple", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LineBreak getHeading() {
            return LineBreak.Heading;
        }

        @NotNull
        public final LineBreak getParagraph() {
            return LineBreak.Paragraph;
        }

        @NotNull
        public final LineBreak getSimple() {
            return LineBreak.Simple;
        }
    }

    @JvmInline
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Strategy {
        /* access modifiers changed from: private */
        public static final int Balanced = m5300constructorimpl(3);
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int HighQuality = m5300constructorimpl(2);
        /* access modifiers changed from: private */
        public static final int Simple = m5300constructorimpl(1);
        private final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strategy$Companion;", "", "()V", "Balanced", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "getBalanced-fcGXIks", "()I", "I", "HighQuality", "getHighQuality-fcGXIks", "Simple", "getSimple-fcGXIks", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getBalanced-fcGXIks  reason: not valid java name */
            public final int m5306getBalancedfcGXIks() {
                return Strategy.Balanced;
            }

            /* renamed from: getHighQuality-fcGXIks  reason: not valid java name */
            public final int m5307getHighQualityfcGXIks() {
                return Strategy.HighQuality;
            }

            /* renamed from: getSimple-fcGXIks  reason: not valid java name */
            public final int m5308getSimplefcGXIks() {
                return Strategy.Simple;
            }
        }

        private /* synthetic */ Strategy(int i11) {
            this.value = i11;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Strategy m5299boximpl(int i11) {
            return new Strategy(i11);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        private static int m5300constructorimpl(int i11) {
            return i11;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m5301equalsimpl(int i11, Object obj) {
            return (obj instanceof Strategy) && i11 == ((Strategy) obj).m5305unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m5302equalsimpl0(int i11, int i12) {
            return i11 == i12;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m5303hashCodeimpl(int i11) {
            return i11;
        }

        @NotNull
        /* renamed from: toString-impl  reason: not valid java name */
        public static String m5304toStringimpl(int i11) {
            if (m5302equalsimpl0(i11, Simple)) {
                return "Strategy.Simple";
            }
            if (m5302equalsimpl0(i11, HighQuality)) {
                return "Strategy.HighQuality";
            }
            if (m5302equalsimpl0(i11, Balanced)) {
                return "Strategy.Balanced";
            }
            return "Invalid";
        }

        public boolean equals(Object obj) {
            return m5301equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5303hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m5304toStringimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m5305unboximpl() {
            return this.value;
        }
    }

    @JvmInline
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Strictness {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int Default = m5310constructorimpl(1);
        /* access modifiers changed from: private */
        public static final int Loose = m5310constructorimpl(2);
        /* access modifiers changed from: private */
        public static final int Normal = m5310constructorimpl(3);
        /* access modifiers changed from: private */
        public static final int Strict = m5310constructorimpl(4);
        private final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001c\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$Strictness$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "getDefault-usljTpc", "()I", "I", "Loose", "getLoose-usljTpc", "Normal", "getNormal-usljTpc", "Strict", "getStrict-usljTpc", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getDefault-usljTpc  reason: not valid java name */
            public final int m5316getDefaultusljTpc() {
                return Strictness.Default;
            }

            /* renamed from: getLoose-usljTpc  reason: not valid java name */
            public final int m5317getLooseusljTpc() {
                return Strictness.Loose;
            }

            /* renamed from: getNormal-usljTpc  reason: not valid java name */
            public final int m5318getNormalusljTpc() {
                return Strictness.Normal;
            }

            /* renamed from: getStrict-usljTpc  reason: not valid java name */
            public final int m5319getStrictusljTpc() {
                return Strictness.Strict;
            }
        }

        private /* synthetic */ Strictness(int i11) {
            this.value = i11;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Strictness m5309boximpl(int i11) {
            return new Strictness(i11);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        private static int m5310constructorimpl(int i11) {
            return i11;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m5311equalsimpl(int i11, Object obj) {
            return (obj instanceof Strictness) && i11 == ((Strictness) obj).m5315unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m5312equalsimpl0(int i11, int i12) {
            return i11 == i12;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m5313hashCodeimpl(int i11) {
            return i11;
        }

        @NotNull
        /* renamed from: toString-impl  reason: not valid java name */
        public static String m5314toStringimpl(int i11) {
            if (m5312equalsimpl0(i11, Default)) {
                return "Strictness.None";
            }
            if (m5312equalsimpl0(i11, Loose)) {
                return "Strictness.Loose";
            }
            if (m5312equalsimpl0(i11, Normal)) {
                return "Strictness.Normal";
            }
            if (m5312equalsimpl0(i11, Strict)) {
                return "Strictness.Strict";
            }
            return "Invalid";
        }

        public boolean equals(Object obj) {
            return m5311equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5313hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m5314toStringimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m5315unboximpl() {
            return this.value;
        }
    }

    @JvmInline
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class WordBreak {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final int Default = m5321constructorimpl(1);
        /* access modifiers changed from: private */
        public static final int Phrase = m5321constructorimpl(2);
        private final int value;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/style/LineBreak$WordBreak$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "getDefault-jp8hJ3c", "()I", "I", "Phrase", "getPhrase-jp8hJ3c", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getDefault-jp8hJ3c  reason: not valid java name */
            public final int m5327getDefaultjp8hJ3c() {
                return WordBreak.Default;
            }

            /* renamed from: getPhrase-jp8hJ3c  reason: not valid java name */
            public final int m5328getPhrasejp8hJ3c() {
                return WordBreak.Phrase;
            }
        }

        private /* synthetic */ WordBreak(int i11) {
            this.value = i11;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ WordBreak m5320boximpl(int i11) {
            return new WordBreak(i11);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        private static int m5321constructorimpl(int i11) {
            return i11;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m5322equalsimpl(int i11, Object obj) {
            return (obj instanceof WordBreak) && i11 == ((WordBreak) obj).m5326unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m5323equalsimpl0(int i11, int i12) {
            return i11 == i12;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m5324hashCodeimpl(int i11) {
            return i11;
        }

        @NotNull
        /* renamed from: toString-impl  reason: not valid java name */
        public static String m5325toStringimpl(int i11) {
            if (m5323equalsimpl0(i11, Default)) {
                return "WordBreak.None";
            }
            if (m5323equalsimpl0(i11, Phrase)) {
                return "WordBreak.Phrase";
            }
            return "Invalid";
        }

        public boolean equals(Object obj) {
            return m5322equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m5324hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m5325toStringimpl(this.value);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m5326unboximpl() {
            return this.value;
        }
    }

    static {
        Strategy.Companion companion = Strategy.Companion;
        int r32 = companion.m5308getSimplefcGXIks();
        Strictness.Companion companion2 = Strictness.Companion;
        int r52 = companion2.m5318getNormalusljTpc();
        WordBreak.Companion companion3 = WordBreak.Companion;
        Simple = new LineBreak(r32, r52, companion3.m5327getDefaultjp8hJ3c(), (DefaultConstructorMarker) null);
        Heading = new LineBreak(companion.m5306getBalancedfcGXIks(), companion2.m5317getLooseusljTpc(), companion3.m5328getPhrasejp8hJ3c(), (DefaultConstructorMarker) null);
        Paragraph = new LineBreak(companion.m5307getHighQualityfcGXIks(), companion2.m5319getStrictusljTpc(), companion3.m5327getDefaultjp8hJ3c(), (DefaultConstructorMarker) null);
    }

    private LineBreak(int i11, int i12, int i13) {
        this.strategy = i11;
        this.strictness = i12;
        this.wordBreak = i13;
    }

    public /* synthetic */ LineBreak(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, i13);
    }

    /* renamed from: copy-vyCVYYw$default  reason: not valid java name */
    public static /* synthetic */ LineBreak m5294copyvyCVYYw$default(LineBreak lineBreak, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = lineBreak.strategy;
        }
        if ((i14 & 2) != 0) {
            i12 = lineBreak.strictness;
        }
        if ((i14 & 4) != 0) {
            i13 = lineBreak.wordBreak;
        }
        return lineBreak.m5295copyvyCVYYw(i11, i12, i13);
    }

    @NotNull
    /* renamed from: copy-vyCVYYw  reason: not valid java name */
    public final LineBreak m5295copyvyCVYYw(int i11, int i12, int i13) {
        return new LineBreak(i11, i12, i13, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LineBreak)) {
            return false;
        }
        LineBreak lineBreak = (LineBreak) obj;
        if (Strategy.m5302equalsimpl0(this.strategy, lineBreak.strategy) && Strictness.m5312equalsimpl0(this.strictness, lineBreak.strictness) && WordBreak.m5323equalsimpl0(this.wordBreak, lineBreak.wordBreak)) {
            return true;
        }
        return false;
    }

    /* renamed from: getStrategy-fcGXIks  reason: not valid java name */
    public final int m5296getStrategyfcGXIks() {
        return this.strategy;
    }

    /* renamed from: getStrictness-usljTpc  reason: not valid java name */
    public final int m5297getStrictnessusljTpc() {
        return this.strictness;
    }

    /* renamed from: getWordBreak-jp8hJ3c  reason: not valid java name */
    public final int m5298getWordBreakjp8hJ3c() {
        return this.wordBreak;
    }

    public int hashCode() {
        return (((Strategy.m5303hashCodeimpl(this.strategy) * 31) + Strictness.m5313hashCodeimpl(this.strictness)) * 31) + WordBreak.m5324hashCodeimpl(this.wordBreak);
    }

    @NotNull
    public String toString() {
        return "LineBreak(strategy=" + Strategy.m5304toStringimpl(this.strategy) + ", strictness=" + Strictness.m5314toStringimpl(this.strictness) + ", wordBreak=" + WordBreak.m5325toStringimpl(this.wordBreak) + ')';
    }
}
