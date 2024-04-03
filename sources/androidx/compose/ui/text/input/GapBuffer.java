package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0006\u0010\u0018\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u001e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u000e\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/input/GapBuffer;", "", "initBuffer", "", "initGapStart", "", "initGapEnd", "([CII)V", "buffer", "capacity", "gapEnd", "gapStart", "append", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "delete", "start", "end", "gapLength", "get", "", "index", "length", "makeSureAvailableSpace", "requestSize", "replace", "text", "", "toString", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class GapBuffer {
    @NotNull
    private char[] buffer;
    private int capacity;
    private int gapEnd;
    private int gapStart;

    public GapBuffer(@NotNull char[] cArr, int i11, int i12) {
        Intrinsics.checkNotNullParameter(cArr, "initBuffer");
        this.capacity = cArr.length;
        this.buffer = cArr;
        this.gapStart = i11;
        this.gapEnd = i12;
    }

    private final void delete(int i11, int i12) {
        int i13 = this.gapStart;
        if (i11 < i13 && i12 <= i13) {
            int i14 = i13 - i12;
            char[] cArr = this.buffer;
            char[] unused = ArraysKt___ArraysJvmKt.copyInto(cArr, cArr, this.gapEnd - i14, i12, i13);
            this.gapStart = i11;
            this.gapEnd -= i14;
        } else if (i11 >= i13 || i12 < i13) {
            int gapLength = i11 + gapLength();
            int gapLength2 = i12 + gapLength();
            int i15 = this.gapEnd;
            char[] cArr2 = this.buffer;
            char[] unused2 = ArraysKt___ArraysJvmKt.copyInto(cArr2, cArr2, this.gapStart, i15, gapLength);
            this.gapStart += gapLength - i15;
            this.gapEnd = gapLength2;
        } else {
            this.gapEnd = i12 + gapLength();
            this.gapStart = i11;
        }
    }

    private final int gapLength() {
        return this.gapEnd - this.gapStart;
    }

    private final void makeSureAvailableSpace(int i11) {
        if (i11 > gapLength()) {
            int gapLength = i11 - gapLength();
            int i12 = this.capacity;
            do {
                i12 *= 2;
            } while (i12 - this.capacity < gapLength);
            char[] cArr = new char[i12];
            char[] unused = ArraysKt___ArraysJvmKt.copyInto(this.buffer, cArr, 0, 0, this.gapStart);
            int i13 = this.capacity;
            int i14 = this.gapEnd;
            int i15 = i13 - i14;
            int i16 = i12 - i15;
            char[] unused2 = ArraysKt___ArraysJvmKt.copyInto(this.buffer, cArr, i16, i14, i15 + i14);
            this.buffer = cArr;
            this.capacity = i12;
            this.gapEnd = i16;
        }
    }

    public final void append(@NotNull StringBuilder sb2) {
        Intrinsics.checkNotNullParameter(sb2, "builder");
        sb2.append(this.buffer, 0, this.gapStart);
        char[] cArr = this.buffer;
        int i11 = this.gapEnd;
        sb2.append(cArr, i11, this.capacity - i11);
    }

    public final char get(int i11) {
        int i12 = this.gapStart;
        if (i11 < i12) {
            return this.buffer[i11];
        }
        return this.buffer[(i11 - i12) + this.gapEnd];
    }

    public final int length() {
        return this.capacity - gapLength();
    }

    public final void replace(int i11, int i12, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        makeSureAvailableSpace(str.length() - (i12 - i11));
        delete(i11, i12);
        GapBufferKt.toCharArray(str, this.buffer, this.gapStart);
        this.gapStart += str.length();
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(sb2);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply { append(this) }.toString()");
        return sb3;
    }
}
