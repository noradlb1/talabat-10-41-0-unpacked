package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Immutable
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u000201B;\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005¢\u0006\u0002\u0010\nBS\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u00060\u0005¢\u0006\u0002\u0010\rJ\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0002J\u0011\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011H\u0002J\"\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u00052\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011J*\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00060\u00052\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011J\"\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00060\u00052\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011J$\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00060\u00052\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0011H\u0007J\b\u0010&\u001a\u00020\u0011H\u0016J\u0011\u0010'\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\u0002J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,J\u0018\u0010(\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0011H\u0016J\b\u0010/\u001a\u00020\u0003H\u0016R\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00062"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString;", "", "text", "", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "annotations", "", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAnnotations$ui_text_release", "()Ljava/util/List;", "length", "", "getLength", "()I", "getParagraphStyles", "getSpanStyles", "getText", "()Ljava/lang/String;", "equals", "", "other", "get", "", "index", "getStringAnnotations", "start", "end", "tag", "getTtsAnnotations", "Landroidx/compose/ui/text/TtsAnnotation;", "getUrlAnnotations", "Landroidx/compose/ui/text/UrlAnnotation;", "hashCode", "plus", "subSequence", "range", "Landroidx/compose/ui/text/TextRange;", "subSequence-5zc-tL8", "(J)Landroidx/compose/ui/text/AnnotatedString;", "startIndex", "endIndex", "toString", "Builder", "Range", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AnnotatedString implements CharSequence {
    @NotNull
    private final List<Range<? extends Object>> annotations;
    @NotNull
    private final List<Range<ParagraphStyle>> paragraphStyles;
    @NotNull
    private final List<Range<SpanStyle>> spanStyles;
    @NotNull
    private final String text;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001/B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bJ\u001e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bJ\u001e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bJ \u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0007J \u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH\u0007J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010(\u001a\u00020\u0018J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\bJ\u0016\u0010*\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003J\u000e\u0010+\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0011J\u000e\u0010+\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0013J\u000e\u0010,\u001a\u00020\b2\u0006\u0010 \u001a\u00020!J\u0010\u0010-\u001a\u00020\b2\u0006\u0010#\u001a\u00020$H\u0007J\u0006\u0010.\u001a\u00020\u0005R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00060\u0015j\u0002`\u0016X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder;", "", "text", "", "(Ljava/lang/String;)V", "Landroidx/compose/ui/text/AnnotatedString;", "(Landroidx/compose/ui/text/AnnotatedString;)V", "capacity", "", "(I)V", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "length", "getLength", "()I", "paragraphStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "spanStyles", "Landroidx/compose/ui/text/SpanStyle;", "styleStack", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "addStringAnnotation", "", "tag", "annotation", "start", "end", "addStyle", "style", "addTtsAnnotation", "ttsAnnotation", "Landroidx/compose/ui/text/TtsAnnotation;", "addUrlAnnotation", "urlAnnotation", "Landroidx/compose/ui/text/UrlAnnotation;", "append", "char", "", "pop", "index", "pushStringAnnotation", "pushStyle", "pushTtsAnnotation", "pushUrlAnnotation", "toAnnotatedString", "MutableRange", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        @NotNull
        private final List<MutableRange<? extends Object>> annotations;
        @NotNull
        private final List<MutableRange<ParagraphStyle>> paragraphStyles;
        @NotNull
        private final List<MutableRange<SpanStyle>> spanStyles;
        @NotNull
        private final List<MutableRange<? extends Object>> styleStack;
        @NotNull
        private final StringBuilder text;

        public Builder() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        public Builder(int i11) {
            this.text = new StringBuilder(i11);
            this.spanStyles = new ArrayList();
            this.paragraphStyles = new ArrayList();
            this.annotations = new ArrayList();
            this.styleStack = new ArrayList();
        }

        public final void addStringAnnotation(@NotNull String str, @NotNull String str2, int i11, int i12) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, "annotation");
            this.annotations.add(new MutableRange(str2, i11, i12, str));
        }

        public final void addStyle(@NotNull SpanStyle spanStyle, int i11, int i12) {
            Intrinsics.checkNotNullParameter(spanStyle, "style");
            this.spanStyles.add(new MutableRange(spanStyle, i11, i12, (String) null, 8, (DefaultConstructorMarker) null));
        }

        @ExperimentalTextApi
        public final void addTtsAnnotation(@NotNull TtsAnnotation ttsAnnotation, int i11, int i12) {
            Intrinsics.checkNotNullParameter(ttsAnnotation, "ttsAnnotation");
            this.annotations.add(new MutableRange(ttsAnnotation, i11, i12, (String) null, 8, (DefaultConstructorMarker) null));
        }

        @ExperimentalTextApi
        public final void addUrlAnnotation(@NotNull UrlAnnotation urlAnnotation, int i11, int i12) {
            Intrinsics.checkNotNullParameter(urlAnnotation, "urlAnnotation");
            this.annotations.add(new MutableRange(urlAnnotation, i11, i12, (String) null, 8, (DefaultConstructorMarker) null));
        }

        public final void append(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.text.append(str);
        }

        public final int getLength() {
            return this.text.length();
        }

        public final void pop() {
            if (!this.styleStack.isEmpty()) {
                List<MutableRange<? extends Object>> list = this.styleStack;
                list.remove(list.size() - 1).setEnd(this.text.length());
                return;
            }
            throw new IllegalStateException("Nothing to pop.".toString());
        }

        public final int pushStringAnnotation(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "tag");
            Intrinsics.checkNotNullParameter(str2, "annotation");
            MutableRange mutableRange = new MutableRange(str2, this.text.length(), 0, str, 4, (DefaultConstructorMarker) null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushStyle(@NotNull SpanStyle spanStyle) {
            Intrinsics.checkNotNullParameter(spanStyle, "style");
            MutableRange mutableRange = new MutableRange(spanStyle, this.text.length(), 0, (String) null, 12, (DefaultConstructorMarker) null);
            this.styleStack.add(mutableRange);
            this.spanStyles.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        public final int pushTtsAnnotation(@NotNull TtsAnnotation ttsAnnotation) {
            Intrinsics.checkNotNullParameter(ttsAnnotation, "ttsAnnotation");
            MutableRange mutableRange = new MutableRange(ttsAnnotation, this.text.length(), 0, (String) null, 12, (DefaultConstructorMarker) null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        @ExperimentalTextApi
        public final int pushUrlAnnotation(@NotNull UrlAnnotation urlAnnotation) {
            Intrinsics.checkNotNullParameter(urlAnnotation, "urlAnnotation");
            MutableRange mutableRange = new MutableRange(urlAnnotation, this.text.length(), 0, (String) null, 12, (DefaultConstructorMarker) null);
            this.styleStack.add(mutableRange);
            this.annotations.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        @NotNull
        public final AnnotatedString toAnnotatedString() {
            String sb2 = this.text.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "text.toString()");
            List<MutableRange<SpanStyle>> list = this.spanStyles;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(list.get(i11).toRange(this.text.length()));
            }
            List<MutableRange<ParagraphStyle>> list2 = this.paragraphStyles;
            ArrayList arrayList2 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                arrayList2.add(list2.get(i12).toRange(this.text.length()));
            }
            List<MutableRange<? extends Object>> list3 = this.annotations;
            ArrayList arrayList3 = new ArrayList(list3.size());
            int size3 = list3.size();
            for (int i13 = 0; i13 < size3; i13++) {
                arrayList3.add(list3.get(i13).toRange(this.text.length()));
            }
            return new AnnotatedString(sb2, arrayList, arrayList2, arrayList3);
        }

        public final void addStyle(@NotNull ParagraphStyle paragraphStyle, int i11, int i12) {
            Intrinsics.checkNotNullParameter(paragraphStyle, "style");
            this.paragraphStyles.add(new MutableRange(paragraphStyle, i11, i12, (String) null, 8, (DefaultConstructorMarker) null));
        }

        public final void append(char c11) {
            this.text.append(c11);
        }

        public final void append(@NotNull AnnotatedString annotatedString) {
            Intrinsics.checkNotNullParameter(annotatedString, "text");
            int length = this.text.length();
            this.text.append(annotatedString.getText());
            List<Range<SpanStyle>> spanStyles2 = annotatedString.getSpanStyles();
            int size = spanStyles2.size();
            for (int i11 = 0; i11 < size; i11++) {
                Range range = spanStyles2.get(i11);
                addStyle((SpanStyle) range.getItem(), range.getStart() + length, range.getEnd() + length);
            }
            List<Range<ParagraphStyle>> paragraphStyles2 = annotatedString.getParagraphStyles();
            int size2 = paragraphStyles2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                Range range2 = paragraphStyles2.get(i12);
                addStyle((ParagraphStyle) range2.getItem(), range2.getStart() + length, range2.getEnd() + length);
            }
            List<Range<? extends Object>> annotations$ui_text_release = annotatedString.getAnnotations$ui_text_release();
            int size3 = annotations$ui_text_release.size();
            for (int i13 = 0; i13 < size3; i13++) {
                Range range3 = annotations$ui_text_release.get(i13);
                this.annotations.add(new MutableRange(range3.getItem(), range3.getStart() + length, range3.getEnd() + length, range3.getTag()));
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0014\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J<\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\b\b\u0002\u0010 \u001a\u00020\u0005J\t\u0010!\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "T", "", "item", "start", "", "end", "tag", "", "(Ljava/lang/Object;IILjava/lang/String;)V", "getEnd", "()I", "setEnd", "(I)V", "getItem", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStart", "getTag", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Builder$MutableRange;", "equals", "", "other", "hashCode", "toRange", "Landroidx/compose/ui/text/AnnotatedString$Range;", "defaultEnd", "toString", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class MutableRange<T> {
            private int end;
            private final T item;
            private final int start;
            @NotNull
            private final String tag;

            public MutableRange(T t11, int i11, int i12, @NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "tag");
                this.item = t11;
                this.start = i11;
                this.end = i12;
                this.tag = str;
            }

            public static /* synthetic */ MutableRange copy$default(MutableRange mutableRange, T t11, int i11, int i12, String str, int i13, Object obj) {
                if ((i13 & 1) != 0) {
                    t11 = mutableRange.item;
                }
                if ((i13 & 2) != 0) {
                    i11 = mutableRange.start;
                }
                if ((i13 & 4) != 0) {
                    i12 = mutableRange.end;
                }
                if ((i13 & 8) != 0) {
                    str = mutableRange.tag;
                }
                return mutableRange.copy(t11, i11, i12, str);
            }

            public static /* synthetic */ Range toRange$default(MutableRange mutableRange, int i11, int i12, Object obj) {
                if ((i12 & 1) != 0) {
                    i11 = Integer.MIN_VALUE;
                }
                return mutableRange.toRange(i11);
            }

            public final T component1() {
                return this.item;
            }

            public final int component2() {
                return this.start;
            }

            public final int component3() {
                return this.end;
            }

            @NotNull
            public final String component4() {
                return this.tag;
            }

            @NotNull
            public final MutableRange<T> copy(T t11, int i11, int i12, @NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "tag");
                return new MutableRange<>(t11, i11, i12, str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MutableRange)) {
                    return false;
                }
                MutableRange mutableRange = (MutableRange) obj;
                return Intrinsics.areEqual((Object) this.item, (Object) mutableRange.item) && this.start == mutableRange.start && this.end == mutableRange.end && Intrinsics.areEqual((Object) this.tag, (Object) mutableRange.tag);
            }

            public final int getEnd() {
                return this.end;
            }

            public final T getItem() {
                return this.item;
            }

            public final int getStart() {
                return this.start;
            }

            @NotNull
            public final String getTag() {
                return this.tag;
            }

            public int hashCode() {
                T t11 = this.item;
                return ((((((t11 == null ? 0 : t11.hashCode()) * 31) + this.start) * 31) + this.end) * 31) + this.tag.hashCode();
            }

            public final void setEnd(int i11) {
                this.end = i11;
            }

            @NotNull
            public final Range<T> toRange(int i11) {
                boolean z11;
                int i12 = this.end;
                if (i12 != Integer.MIN_VALUE) {
                    i11 = i12;
                }
                if (i11 != Integer.MIN_VALUE) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    return new Range<>(this.item, this.start, i11, this.tag);
                }
                throw new IllegalStateException("Item.end should be set first".toString());
            }

            @NotNull
            public String toString() {
                return "MutableRange(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ MutableRange(Object obj, int i11, int i12, String str, int i13, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj, i11, (i13 & 4) != 0 ? Integer.MIN_VALUE : i12, (i13 & 8) != 0 ? "" : str);
            }
        }

        public final void pop(int i11) {
            if (i11 < this.styleStack.size()) {
                while (this.styleStack.size() - 1 >= i11) {
                    pop();
                }
                return;
            }
            throw new IllegalStateException((i11 + " should be less than " + this.styleStack.size()).toString());
        }

        public final int pushStyle(@NotNull ParagraphStyle paragraphStyle) {
            Intrinsics.checkNotNullParameter(paragraphStyle, "style");
            MutableRange mutableRange = new MutableRange(paragraphStyle, this.text.length(), 0, (String) null, 12, (DefaultConstructorMarker) null);
            this.styleStack.add(mutableRange);
            this.paragraphStyles.add(mutableRange);
            return this.styleStack.size() - 1;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 16 : i11);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull String str) {
            this(0, 1, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "text");
            append(str);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull AnnotatedString annotatedString) {
            this(0, 1, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(annotatedString, "text");
            append(annotatedString);
        }
    }

    public AnnotatedString(@NotNull String str, @NotNull List<Range<SpanStyle>> list, @NotNull List<Range<ParagraphStyle>> list2, @NotNull List<? extends Range<? extends Object>> list3) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(list2, "paragraphStyles");
        Intrinsics.checkNotNullParameter(list3, "annotations");
        this.text = str;
        this.spanStyles = list;
        this.paragraphStyles = list2;
        this.annotations = list3;
        List sortedWith = CollectionsKt___CollectionsKt.sortedWith(list2, new AnnotatedString$special$$inlined$sortedBy$1());
        int size = sortedWith.size();
        int i11 = -1;
        int i12 = 0;
        while (i12 < size) {
            Range range = (Range) sortedWith.get(i12);
            boolean z11 = true;
            if (range.getStart() >= i11) {
                if (range.getEnd() > this.text.length() ? false : z11) {
                    i11 = range.getEnd();
                    i12++;
                } else {
                    throw new IllegalArgumentException(("ParagraphStyle range [" + range.getStart() + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + range.getEnd() + ") is out of boundary").toString());
                }
            } else {
                throw new IllegalArgumentException("ParagraphStyle should not overlap".toString());
            }
        }
    }

    public final /* bridge */ char charAt(int i11) {
        return get(i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnotatedString)) {
            return false;
        }
        AnnotatedString annotatedString = (AnnotatedString) obj;
        if (Intrinsics.areEqual((Object) this.text, (Object) annotatedString.text) && Intrinsics.areEqual((Object) this.spanStyles, (Object) annotatedString.spanStyles) && Intrinsics.areEqual((Object) this.paragraphStyles, (Object) annotatedString.paragraphStyles) && Intrinsics.areEqual((Object) this.annotations, (Object) annotatedString.annotations)) {
            return true;
        }
        return false;
    }

    public char get(int i11) {
        return this.text.charAt(i11);
    }

    @NotNull
    public final List<Range<? extends Object>> getAnnotations$ui_text_release() {
        return this.annotations;
    }

    public int getLength() {
        return this.text.length();
    }

    @NotNull
    public final List<Range<ParagraphStyle>> getParagraphStyles() {
        return this.paragraphStyles;
    }

    @NotNull
    public final List<Range<SpanStyle>> getSpanStyles() {
        return this.spanStyles;
    }

    @NotNull
    public final List<Range<String>> getStringAnnotations(@NotNull String str, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "tag");
        List<Range<? extends Object>> list = this.annotations;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i13 = 0; i13 < size; i13++) {
            Range<? extends Object> range = list.get(i13);
            Range range2 = range;
            if ((range2.getItem() instanceof String) && Intrinsics.areEqual((Object) str, (Object) range2.getTag()) && AnnotatedStringKt.intersect(i11, i12, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        return arrayList;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final List<Range<TtsAnnotation>> getTtsAnnotations(int i11, int i12) {
        boolean z11;
        List<Range<? extends Object>> list = this.annotations;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i13 = 0; i13 < size; i13++) {
            Range<? extends Object> range = list.get(i13);
            Range range2 = range;
            if (!(range2.getItem() instanceof TtsAnnotation) || !AnnotatedStringKt.intersect(i11, i12, range2.getStart(), range2.getEnd())) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList.add(range);
            }
        }
        return arrayList;
    }

    @ExperimentalTextApi
    @NotNull
    public final List<Range<UrlAnnotation>> getUrlAnnotations(int i11, int i12) {
        boolean z11;
        List<Range<? extends Object>> list = this.annotations;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i13 = 0; i13 < size; i13++) {
            Range<? extends Object> range = list.get(i13);
            Range range2 = range;
            if (!(range2.getItem() instanceof UrlAnnotation) || !AnnotatedStringKt.intersect(i11, i12, range2.getStart(), range2.getEnd())) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList.add(range);
            }
        }
        return arrayList;
    }

    public int hashCode() {
        return (((((this.text.hashCode() * 31) + this.spanStyles.hashCode()) * 31) + this.paragraphStyles.hashCode()) * 31) + this.annotations.hashCode();
    }

    public final /* bridge */ int length() {
        return getLength();
    }

    @NotNull
    @Stable
    public final AnnotatedString plus(@NotNull AnnotatedString annotatedString) {
        Intrinsics.checkNotNullParameter(annotatedString, "other");
        Builder builder = new Builder(this);
        builder.append(annotatedString);
        return builder.toAnnotatedString();
    }

    @NotNull
    /* renamed from: subSequence-5zc-tL8  reason: not valid java name */
    public final AnnotatedString m4940subSequence5zctL8(long j11) {
        return subSequence(TextRange.m5036getMinimpl(j11), TextRange.m5035getMaximpl(j11));
    }

    @NotNull
    public String toString() {
        return this.text;
    }

    @NotNull
    public AnnotatedString subSequence(int i11, int i12) {
        if (!(i11 <= i12)) {
            throw new IllegalArgumentException(("start (" + i11 + ") should be less or equal to end (" + i12 + ')').toString());
        } else if (i11 == 0 && i12 == this.text.length()) {
            return this;
        } else {
            String substring = this.text.substring(i11, i12);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return new AnnotatedString(substring, AnnotatedStringKt.filterRanges(this.spanStyles, i11, i12), AnnotatedStringKt.filterRanges(this.paragraphStyles, i11, i12), AnnotatedStringKt.filterRanges(this.annotations, i11, i12));
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B%\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0013\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J<\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/text/AnnotatedString$Range;", "T", "", "item", "start", "", "end", "(Ljava/lang/Object;II)V", "tag", "", "(Ljava/lang/Object;IILjava/lang/String;)V", "getEnd", "()I", "getItem", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getStart", "getTag", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;IILjava/lang/String;)Landroidx/compose/ui/text/AnnotatedString$Range;", "equals", "", "other", "hashCode", "toString", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Range<T> {
        private final int end;
        private final T item;
        private final int start;
        @NotNull
        private final String tag;

        public Range(T t11, int i11, int i12, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "tag");
            this.item = t11;
            this.start = i11;
            this.end = i12;
            this.tag = str;
            if (!(i11 <= i12)) {
                throw new IllegalArgumentException("Reversed range is not supported".toString());
            }
        }

        public static /* synthetic */ Range copy$default(Range range, T t11, int i11, int i12, String str, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                t11 = range.item;
            }
            if ((i13 & 2) != 0) {
                i11 = range.start;
            }
            if ((i13 & 4) != 0) {
                i12 = range.end;
            }
            if ((i13 & 8) != 0) {
                str = range.tag;
            }
            return range.copy(t11, i11, i12, str);
        }

        public final T component1() {
            return this.item;
        }

        public final int component2() {
            return this.start;
        }

        public final int component3() {
            return this.end;
        }

        @NotNull
        public final String component4() {
            return this.tag;
        }

        @NotNull
        public final Range<T> copy(T t11, int i11, int i12, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "tag");
            return new Range<>(t11, i11, i12, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Range)) {
                return false;
            }
            Range range = (Range) obj;
            return Intrinsics.areEqual((Object) this.item, (Object) range.item) && this.start == range.start && this.end == range.end && Intrinsics.areEqual((Object) this.tag, (Object) range.tag);
        }

        public final int getEnd() {
            return this.end;
        }

        public final T getItem() {
            return this.item;
        }

        public final int getStart() {
            return this.start;
        }

        @NotNull
        public final String getTag() {
            return this.tag;
        }

        public int hashCode() {
            T t11 = this.item;
            return ((((((t11 == null ? 0 : t11.hashCode()) * 31) + this.start) * 31) + this.end) * 31) + this.tag.hashCode();
        }

        @NotNull
        public String toString() {
            return "Range(item=" + this.item + ", start=" + this.start + ", end=" + this.end + ", tag=" + this.tag + ')';
        }

        public Range(T t11, int i11, int i12) {
            this(t11, i11, i12, "");
        }
    }

    @NotNull
    public final List<Range<String>> getStringAnnotations(int i11, int i12) {
        List<Range<? extends Object>> list = this.annotations;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i13 = 0; i13 < size; i13++) {
            Range<? extends Object> range = list.get(i13);
            Range range2 = range;
            if ((range2.getItem() instanceof String) && AnnotatedStringKt.intersect(i11, i12, range2.getStart(), range2.getEnd())) {
                arrayList.add(range);
            }
        }
        return arrayList;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnnotatedString(String str, List list, List list2, List list3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i11 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, (i11 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnnotatedString(String str, List list, List list2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i11 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AnnotatedString(@NotNull String str, @NotNull List<Range<SpanStyle>> list, @NotNull List<Range<ParagraphStyle>> list2) {
        this(str, list, list2, CollectionsKt__CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(list, "spanStyles");
        Intrinsics.checkNotNullParameter(list2, "paragraphStyles");
    }
}
