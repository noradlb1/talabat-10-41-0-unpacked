package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0019B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\bJ\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/UndoManager;", "", "maxStoredCharacters", "", "(I)V", "forceNextSnapshot", "", "lastSnapshot", "", "Ljava/lang/Long;", "getMaxStoredCharacters", "()I", "redoStack", "Landroidx/compose/foundation/text/UndoManager$Entry;", "storedCharacters", "undoStack", "", "makeSnapshot", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "redo", "removeLastUndo", "snapshotIfNeeded", "now", "undo", "Entry", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UndoManager {
    private boolean forceNextSnapshot;
    @Nullable
    private Long lastSnapshot;
    private final int maxStoredCharacters;
    @Nullable
    private Entry redoStack;
    private int storedCharacters;
    @Nullable
    private Entry undoStack;

    public UndoManager() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public UndoManager(int i11) {
        this.maxStoredCharacters = i11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e A[LOOP:0: B:6:0x000e->B:12:0x001e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0023 A[EDGE_INSN: B:15:0x0023->B:13:0x0023 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void removeLastUndo() {
        /*
            r3 = this;
            androidx.compose.foundation.text.UndoManager$Entry r0 = r3.undoStack
            r1 = 0
            if (r0 == 0) goto L_0x000a
            androidx.compose.foundation.text.UndoManager$Entry r2 = r0.getNext()
            goto L_0x000b
        L_0x000a:
            r2 = r1
        L_0x000b:
            if (r2 != 0) goto L_0x000e
            return
        L_0x000e:
            if (r0 == 0) goto L_0x001b
            androidx.compose.foundation.text.UndoManager$Entry r2 = r0.getNext()
            if (r2 == 0) goto L_0x001b
            androidx.compose.foundation.text.UndoManager$Entry r2 = r2.getNext()
            goto L_0x001c
        L_0x001b:
            r2 = r1
        L_0x001c:
            if (r2 == 0) goto L_0x0023
            androidx.compose.foundation.text.UndoManager$Entry r0 = r0.getNext()
            goto L_0x000e
        L_0x0023:
            if (r0 != 0) goto L_0x0026
            goto L_0x0029
        L_0x0026:
            r0.setNext(r1)
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.UndoManager.removeLastUndo():void");
    }

    public static /* synthetic */ void snapshotIfNeeded$default(UndoManager undoManager, TextFieldValue textFieldValue, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = UndoManager_jvmKt.timeNowMillis();
        }
        undoManager.snapshotIfNeeded(textFieldValue, j11);
    }

    public final void forceNextSnapshot() {
        this.forceNextSnapshot = true;
    }

    public final int getMaxStoredCharacters() {
        return this.maxStoredCharacters;
    }

    public final void makeSnapshot(@NotNull TextFieldValue textFieldValue) {
        TextFieldValue textFieldValue2;
        String str;
        TextFieldValue value;
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        this.forceNextSnapshot = false;
        Entry entry = this.undoStack;
        if (entry != null) {
            textFieldValue2 = entry.getValue();
        } else {
            textFieldValue2 = null;
        }
        if (!Intrinsics.areEqual((Object) textFieldValue, (Object) textFieldValue2)) {
            String text = textFieldValue.getText();
            Entry entry2 = this.undoStack;
            if (entry2 == null || (value = entry2.getValue()) == null) {
                str = null;
            } else {
                str = value.getText();
            }
            if (Intrinsics.areEqual((Object) text, (Object) str)) {
                Entry entry3 = this.undoStack;
                if (entry3 != null) {
                    entry3.setValue(textFieldValue);
                    return;
                }
                return;
            }
            this.undoStack = new Entry(this.undoStack, textFieldValue);
            this.redoStack = null;
            int length = this.storedCharacters + textFieldValue.getText().length();
            this.storedCharacters = length;
            if (length > this.maxStoredCharacters) {
                removeLastUndo();
            }
        }
    }

    @Nullable
    public final TextFieldValue redo() {
        Entry entry = this.redoStack;
        if (entry == null) {
            return null;
        }
        this.redoStack = entry.getNext();
        this.undoStack = new Entry(this.undoStack, entry.getValue());
        this.storedCharacters += entry.getValue().getText().length();
        return entry.getValue();
    }

    public final void snapshotIfNeeded(@NotNull TextFieldValue textFieldValue, long j11) {
        long j12;
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        if (!this.forceNextSnapshot) {
            Long l11 = this.lastSnapshot;
            if (l11 != null) {
                j12 = l11.longValue();
            } else {
                j12 = 0;
            }
            if (j11 <= j12 + ((long) UndoManagerKt.getSNAPSHOTS_INTERVAL_MILLIS())) {
                return;
            }
        }
        this.lastSnapshot = Long.valueOf(j11);
        makeSnapshot(textFieldValue);
    }

    @Nullable
    public final TextFieldValue undo() {
        Entry next;
        Entry entry = this.undoStack;
        if (entry == null || (next = entry.getNext()) == null) {
            return null;
        }
        this.undoStack = next;
        this.storedCharacters -= entry.getValue().getText().length();
        this.redoStack = new Entry(this.redoStack, entry.getValue());
        return next.getValue();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/text/UndoManager$Entry;", "", "next", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/foundation/text/UndoManager$Entry;Landroidx/compose/ui/text/input/TextFieldValue;)V", "getNext", "()Landroidx/compose/foundation/text/UndoManager$Entry;", "setNext", "(Landroidx/compose/foundation/text/UndoManager$Entry;)V", "getValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Entry {
        @Nullable
        private Entry next;
        @NotNull
        private TextFieldValue value;

        public Entry(@Nullable Entry entry, @NotNull TextFieldValue textFieldValue) {
            Intrinsics.checkNotNullParameter(textFieldValue, "value");
            this.next = entry;
            this.value = textFieldValue;
        }

        @Nullable
        public final Entry getNext() {
            return this.next;
        }

        @NotNull
        public final TextFieldValue getValue() {
            return this.value;
        }

        public final void setNext(@Nullable Entry entry) {
            this.next = entry;
        }

        public final void setValue(@NotNull TextFieldValue textFieldValue) {
            Intrinsics.checkNotNullParameter(textFieldValue, "<set-?>");
            this.value = textFieldValue;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Entry(Entry entry, TextFieldValue textFieldValue, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? null : entry, textFieldValue);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UndoManager(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 100000 : i11);
    }
}
