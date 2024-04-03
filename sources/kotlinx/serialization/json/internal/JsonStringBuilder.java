package kotlinx.serialization.json.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u0019\n\u0002\b\f\b\u0010\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u001f\u0010 B\t\b\u0016¢\u0006\u0004\b\u001f\u0010!J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0014J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u0016\u0010\u0018\u001a\u00020\u00168\u0004@\u0004X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00028\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lkotlinx/serialization/json/internal/JsonStringBuilder;", "", "", "firstEscapedChar", "currentSize", "", "string", "", "appendStringSlowPath", "expected", "ensureAdditionalCapacity", "", "value", "append", "", "ch", "appendQuoted", "toString", "oldSize", "additional", "a", "release", "", "[C", "array", "size", "I", "b", "()I", "c", "(I)V", "<init>", "([C)V", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
public class JsonStringBuilder {
    @NotNull
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public char[] f26443a;
    private int size;

    public JsonStringBuilder(@NotNull char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "array");
        this.f26443a = cArr;
    }

    private final void appendStringSlowPath(int i11, int i12, String str) {
        int i13;
        int length = str.length();
        while (i11 < length) {
            int a11 = a(i12, 2);
            char charAt = str.charAt(i11);
            if (charAt < StringOpsKt.getESCAPE_MARKERS().length) {
                byte b11 = StringOpsKt.getESCAPE_MARKERS()[charAt];
                if (b11 == 0) {
                    i13 = a11 + 1;
                    this.f26443a[a11] = (char) charAt;
                } else {
                    if (b11 == 1) {
                        String str2 = StringOpsKt.getESCAPE_STRINGS()[charAt];
                        Intrinsics.checkNotNull(str2);
                        int a12 = a(a11, str2.length());
                        str2.getChars(0, str2.length(), this.f26443a, a12);
                        i12 = a12 + str2.length();
                        this.size = i12;
                    } else {
                        char[] cArr = this.f26443a;
                        cArr[a11] = '\\';
                        cArr[a11 + 1] = (char) b11;
                        i12 = a11 + 2;
                        this.size = i12;
                    }
                    i11++;
                }
            } else {
                i13 = a11 + 1;
                this.f26443a[a11] = (char) charAt;
            }
            i12 = i13;
            i11++;
        }
        int a13 = a(i12, 1);
        this.f26443a[a13] = '\"';
        this.size = a13 + 1;
    }

    private final void ensureAdditionalCapacity(int i11) {
        a(this.size, i11);
    }

    public int a(int i11, int i12) {
        int i13 = i12 + i11;
        char[] cArr = this.f26443a;
        if (cArr.length <= i13) {
            char[] copyOf = Arrays.copyOf(cArr, RangesKt___RangesKt.coerceAtLeast(i13, i11 * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.f26443a = copyOf;
        }
        return i11;
    }

    public final void append(long j11) {
        append(String.valueOf(j11));
    }

    public final void appendQuoted(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        ensureAdditionalCapacity(str.length() + 2);
        char[] cArr = this.f26443a;
        int i11 = this.size;
        int i12 = i11 + 1;
        cArr[i11] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i12);
        int i13 = length + i12;
        int i14 = i12;
        while (i14 < i13) {
            char c11 = cArr[i14];
            if (c11 >= StringOpsKt.getESCAPE_MARKERS().length || StringOpsKt.getESCAPE_MARKERS()[c11] == 0) {
                i14++;
            } else {
                appendStringSlowPath(i14 - i12, i14, str);
                return;
            }
        }
        cArr[i13] = '\"';
        this.size = i13 + 1;
    }

    public final int b() {
        return this.size;
    }

    public final void c(int i11) {
        this.size = i11;
    }

    public void release() {
        CharArrayPool.INSTANCE.release(this.f26443a);
    }

    @NotNull
    public String toString() {
        return new String(this.f26443a, 0, this.size);
    }

    public JsonStringBuilder() {
        this(CharArrayPool.INSTANCE.take());
    }

    public final void append(char c11) {
        ensureAdditionalCapacity(1);
        char[] cArr = this.f26443a;
        int i11 = this.size;
        this.size = i11 + 1;
        cArr[i11] = c11;
    }

    public final void append(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        int length = str.length();
        ensureAdditionalCapacity(length);
        str.getChars(0, str.length(), this.f26443a, this.size);
        this.size += length;
    }
}
