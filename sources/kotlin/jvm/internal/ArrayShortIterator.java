package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ShortIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\n\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/jvm/internal/ArrayShortIterator;", "Lkotlin/collections/ShortIterator;", "array", "", "([S)V", "index", "", "hasNext", "", "nextShort", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class ArrayShortIterator extends ShortIterator {
    @NotNull
    private final short[] array;
    private int index;

    public ArrayShortIterator(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "array");
        this.array = sArr;
    }

    public boolean hasNext() {
        return this.index < this.array.length;
    }

    public short nextShort() {
        try {
            short[] sArr = this.array;
            int i11 = this.index;
            this.index = i11 + 1;
            return sArr[i11];
        } catch (ArrayIndexOutOfBoundsException e11) {
            this.index--;
            throw new NoSuchElementException(e11.getMessage());
        }
    }
}
