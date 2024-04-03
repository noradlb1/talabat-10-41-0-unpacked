package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.InternalTextApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@InternalTextApi
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/input/PartialGapBuffer;", "", "text", "", "(Ljava/lang/String;)V", "bufEnd", "", "bufStart", "buffer", "Landroidx/compose/ui/text/input/GapBuffer;", "length", "getLength", "()I", "getText", "()Ljava/lang/String;", "setText", "get", "", "index", "replace", "", "start", "end", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PartialGapBuffer {
    public static final int $stable = 8;
    public static final int BUF_SIZE = 255;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;
    private int bufEnd = -1;
    private int bufStart = -1;
    @Nullable
    private GapBuffer buffer;
    @NotNull
    private String text;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/input/PartialGapBuffer$Companion;", "", "()V", "BUF_SIZE", "", "NOWHERE", "SURROUNDING_SIZE", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PartialGapBuffer(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.text = str;
    }

    public final char get(int i11) {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.charAt(i11);
        }
        if (i11 < this.bufStart) {
            return this.text.charAt(i11);
        }
        int length = gapBuffer.length();
        int i12 = this.bufStart;
        if (i11 < length + i12) {
            return gapBuffer.get(i11 - i12);
        }
        return this.text.charAt(i11 - ((length - this.bufEnd) + i12));
    }

    public final int getLength() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text.length();
        }
        return (this.text.length() - (this.bufEnd - this.bufStart)) + gapBuffer.length();
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final void replace(int i11, int i12, @NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "text");
        boolean z12 = true;
        if (i11 <= i12) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (i11 < 0) {
                z12 = false;
            }
            if (z12) {
                GapBuffer gapBuffer = this.buffer;
                if (gapBuffer == null) {
                    int max = Math.max(255, str.length() + 128);
                    char[] cArr = new char[max];
                    int min = Math.min(i11, 64);
                    int min2 = Math.min(this.text.length() - i12, 64);
                    int i13 = i11 - min;
                    GapBuffer_jvmKt.toCharArray(this.text, cArr, 0, i13, i11);
                    int i14 = max - min2;
                    int i15 = min2 + i12;
                    GapBuffer_jvmKt.toCharArray(this.text, cArr, i14, i12, i15);
                    GapBufferKt.toCharArray(str, cArr, min);
                    this.buffer = new GapBuffer(cArr, min + str.length(), i14);
                    this.bufStart = i13;
                    this.bufEnd = i15;
                    return;
                }
                int i16 = this.bufStart;
                int i17 = i11 - i16;
                int i18 = i12 - i16;
                if (i17 < 0 || i18 > gapBuffer.length()) {
                    this.text = toString();
                    this.buffer = null;
                    this.bufStart = -1;
                    this.bufEnd = -1;
                    replace(i11, i12, str);
                    return;
                }
                gapBuffer.replace(i17, i18, str);
                return;
            }
            throw new IllegalArgumentException(("start must be non-negative, but was " + i11).toString());
        }
        throw new IllegalArgumentException(("start index must be less than or equal to end index: " + i11 + " > " + i12).toString());
    }

    public final void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    @NotNull
    public String toString() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.text, 0, this.bufStart);
        gapBuffer.append(sb2);
        String str = this.text;
        sb2.append(str, this.bufEnd, str.length());
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "sb.toString()");
        return sb3;
    }
}
