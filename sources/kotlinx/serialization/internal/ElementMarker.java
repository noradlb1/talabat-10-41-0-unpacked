package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0006\u0010\u0012\u001a\u00020\u0006J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkotlinx/serialization/internal/ElementMarker;", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "readIfAbsent", "Lkotlin/Function2;", "", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function2;)V", "highMarksArray", "", "lowerMarks", "", "mark", "", "index", "markHigh", "nextUnmarkedHighIndex", "nextUnmarkedIndex", "prepareHighMarksArray", "elementsCount", "Companion", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PublishedApi
public final class ElementMarker {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final long[] EMPTY_HIGH_MARKS = new long[0];
    @NotNull
    private final SerialDescriptor descriptor;
    @NotNull
    private final long[] highMarksArray;
    private long lowerMarks;
    @NotNull
    private final Function2<SerialDescriptor, Integer, Boolean> readIfAbsent;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/serialization/internal/ElementMarker$Companion;", "", "()V", "EMPTY_HIGH_MARKS", "", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ElementMarker(@NotNull SerialDescriptor serialDescriptor, @NotNull Function2<? super SerialDescriptor, ? super Integer, Boolean> function2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(function2, "readIfAbsent");
        this.descriptor = serialDescriptor;
        this.readIfAbsent = function2;
        int elementsCount = serialDescriptor.getElementsCount();
        long j11 = 0;
        if (elementsCount <= 64) {
            this.lowerMarks = elementsCount != 64 ? -1 << elementsCount : j11;
            this.highMarksArray = EMPTY_HIGH_MARKS;
            return;
        }
        this.lowerMarks = 0;
        this.highMarksArray = prepareHighMarksArray(elementsCount);
    }

    private final void markHigh(int i11) {
        int i12 = (i11 >>> 6) - 1;
        long[] jArr = this.highMarksArray;
        jArr[i12] = jArr[i12] | (1 << (i11 & 63));
    }

    private final int nextUnmarkedHighIndex() {
        int length = this.highMarksArray.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            int i13 = i12 * 64;
            long j11 = this.highMarksArray[i11];
            while (j11 != -1) {
                int numberOfTrailingZeros = Long.numberOfTrailingZeros(~j11);
                j11 |= 1 << numberOfTrailingZeros;
                int i14 = numberOfTrailingZeros + i13;
                if (this.readIfAbsent.invoke(this.descriptor, Integer.valueOf(i14)).booleanValue()) {
                    this.highMarksArray[i11] = j11;
                    return i14;
                }
            }
            this.highMarksArray[i11] = j11;
            i11 = i12;
        }
        return -1;
    }

    private final long[] prepareHighMarksArray(int i11) {
        long[] jArr = new long[((i11 - 1) >>> 6)];
        if ((i11 & 63) != 0) {
            jArr[ArraysKt___ArraysKt.getLastIndex(jArr)] = -1 << i11;
        }
        return jArr;
    }

    public final void mark(int i11) {
        if (i11 < 64) {
            this.lowerMarks |= 1 << i11;
        } else {
            markHigh(i11);
        }
    }

    public final int nextUnmarkedIndex() {
        int numberOfTrailingZeros;
        int elementsCount = this.descriptor.getElementsCount();
        do {
            long j11 = this.lowerMarks;
            if (j11 != -1) {
                numberOfTrailingZeros = Long.numberOfTrailingZeros(~j11);
                this.lowerMarks |= 1 << numberOfTrailingZeros;
            } else if (elementsCount > 64) {
                return nextUnmarkedHighIndex();
            } else {
                return -1;
            }
        } while (!this.readIfAbsent.invoke(this.descriptor, Integer.valueOf(numberOfTrailingZeros)).booleanValue());
        return numberOfTrailingZeros;
    }
}
