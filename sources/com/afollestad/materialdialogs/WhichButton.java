package com.afollestad.materialdialogs;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/afollestad/materialdialogs/WhichButton;", "", "index", "", "(Ljava/lang/String;II)V", "getIndex", "()I", "POSITIVE", "NEGATIVE", "NEUTRAL", "Companion", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
public enum WhichButton {
    POSITIVE(0),
    NEGATIVE(1),
    NEUTRAL(2);
    
    public static final Companion Companion = null;
    private final int index;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/afollestad/materialdialogs/WhichButton$Companion;", "", "()V", "fromIndex", "Lcom/afollestad/materialdialogs/WhichButton;", "index", "", "com.afollestad.material-dialogs.core"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WhichButton fromIndex(int i11) {
            if (i11 == 0) {
                return WhichButton.POSITIVE;
            }
            if (i11 == 1) {
                return WhichButton.NEGATIVE;
            }
            if (i11 == 2) {
                return WhichButton.NEUTRAL;
            }
            throw new IndexOutOfBoundsException(i11 + " is not an action button index.");
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private WhichButton(int i11) {
        this.index = i11;
    }

    public final int getIndex() {
        return this.index;
    }
}
