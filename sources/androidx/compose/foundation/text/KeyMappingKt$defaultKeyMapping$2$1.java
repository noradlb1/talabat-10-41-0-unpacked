package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\b"}, d2 = {"androidx/compose/foundation/text/KeyMappingKt$defaultKeyMapping$2$1", "Landroidx/compose/foundation/text/KeyMapping;", "map", "Landroidx/compose/foundation/text/KeyCommand;", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "map-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/foundation/text/KeyCommand;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KeyMappingKt$defaultKeyMapping$2$1 implements KeyMapping {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KeyMapping f3509a;

    public KeyMappingKt$defaultKeyMapping$2$1(KeyMapping keyMapping) {
        this.f3509a = keyMapping;
    }

    @Nullable
    /* renamed from: map-ZmokQxo  reason: not valid java name */
    public KeyCommand m853mapZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        KeyCommand keyCommand = null;
        if (KeyEvent_androidKt.m4189isShiftPressedZmokQxo(keyEvent) && KeyEvent_androidKt.m4187isCtrlPressedZmokQxo(keyEvent)) {
            long r22 = KeyEvent_androidKt.m4183getKeyZmokQxo(keyEvent);
            MappedKeys mappedKeys = MappedKeys.INSTANCE;
            if (Key.m3588equalsimpl0(r22, mappedKeys.m873getDirectionLeftEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_LEFT_WORD;
            } else if (Key.m3588equalsimpl0(r22, mappedKeys.m874getDirectionRightEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_RIGHT_WORD;
            } else if (Key.m3588equalsimpl0(r22, mappedKeys.m875getDirectionUpEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
            } else if (Key.m3588equalsimpl0(r22, mappedKeys.m872getDirectionDownEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
            }
        } else if (KeyEvent_androidKt.m4187isCtrlPressedZmokQxo(keyEvent)) {
            long r23 = KeyEvent_androidKt.m4183getKeyZmokQxo(keyEvent);
            MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
            if (Key.m3588equalsimpl0(r23, mappedKeys2.m873getDirectionLeftEK5gGoQ())) {
                keyCommand = KeyCommand.LEFT_WORD;
            } else if (Key.m3588equalsimpl0(r23, mappedKeys2.m874getDirectionRightEK5gGoQ())) {
                keyCommand = KeyCommand.RIGHT_WORD;
            } else if (Key.m3588equalsimpl0(r23, mappedKeys2.m875getDirectionUpEK5gGoQ())) {
                keyCommand = KeyCommand.PREV_PARAGRAPH;
            } else if (Key.m3588equalsimpl0(r23, mappedKeys2.m872getDirectionDownEK5gGoQ())) {
                keyCommand = KeyCommand.NEXT_PARAGRAPH;
            } else if (Key.m3588equalsimpl0(r23, mappedKeys2.m877getHEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_PREV_CHAR;
            } else if (Key.m3588equalsimpl0(r23, mappedKeys2.m871getDeleteEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_NEXT_WORD;
            } else if (Key.m3588equalsimpl0(r23, mappedKeys2.m868getBackspaceEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_PREV_WORD;
            } else if (Key.m3588equalsimpl0(r23, mappedKeys2.m867getBackslashEK5gGoQ())) {
                keyCommand = KeyCommand.DESELECT;
            }
        } else if (KeyEvent_androidKt.m4189isShiftPressedZmokQxo(keyEvent)) {
            long r24 = KeyEvent_androidKt.m4183getKeyZmokQxo(keyEvent);
            MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
            if (Key.m3588equalsimpl0(r24, mappedKeys3.m880getMoveHomeEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_HOME;
            } else if (Key.m3588equalsimpl0(r24, mappedKeys3.m879getMoveEndEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_END;
            }
        }
        if (keyCommand == null) {
            return this.f3509a.m851mapZmokQxo(keyEvent);
        }
        return keyCommand;
    }
}
