package androidx.compose.ui.text.android;

import java.text.CharacterIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\f\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\t\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/text/android/CharSequenceCharacterIterator;", "Ljava/text/CharacterIterator;", "charSequence", "", "start", "", "end", "(Ljava/lang/CharSequence;II)V", "index", "clone", "", "current", "", "first", "getBeginIndex", "getEndIndex", "getIndex", "last", "next", "previous", "setIndex", "position", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CharSequenceCharacterIterator implements CharacterIterator {
    @NotNull
    private final CharSequence charSequence;
    private final int end;
    private int index;
    private final int start;

    public CharSequenceCharacterIterator(@NotNull CharSequence charSequence2, int i11, int i12) {
        Intrinsics.checkNotNullParameter(charSequence2, "charSequence");
        this.charSequence = charSequence2;
        this.start = i11;
        this.end = i12;
        this.index = i11;
    }

    @NotNull
    public Object clone() {
        try {
            Object clone = super.clone();
            Intrinsics.checkNotNullExpressionValue(clone, "{\n            @Suppress(…  super.clone()\n        }");
            return clone;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public char current() {
        int i11 = this.index;
        return i11 == this.end ? CharCompanionObject.MAX_VALUE : this.charSequence.charAt(i11);
    }

    public char first() {
        this.index = this.start;
        return current();
    }

    public int getBeginIndex() {
        return this.start;
    }

    public int getEndIndex() {
        return this.end;
    }

    public int getIndex() {
        return this.index;
    }

    public char last() {
        int i11 = this.start;
        int i12 = this.end;
        if (i11 == i12) {
            this.index = i12;
            return CharCompanionObject.MAX_VALUE;
        }
        int i13 = i12 - 1;
        this.index = i13;
        return this.charSequence.charAt(i13);
    }

    public char next() {
        int i11 = this.index + 1;
        this.index = i11;
        int i12 = this.end;
        if (i11 < i12) {
            return this.charSequence.charAt(i11);
        }
        this.index = i12;
        return CharCompanionObject.MAX_VALUE;
    }

    public char previous() {
        int i11 = this.index;
        if (i11 <= this.start) {
            return CharCompanionObject.MAX_VALUE;
        }
        int i12 = i11 - 1;
        this.index = i12;
        return this.charSequence.charAt(i12);
    }

    public char setIndex(int i11) {
        int i12 = this.start;
        boolean z11 = false;
        if (i11 <= this.end && i12 <= i11) {
            z11 = true;
        }
        if (z11) {
            this.index = i11;
            return current();
        }
        throw new IllegalArgumentException("invalid position");
    }
}
