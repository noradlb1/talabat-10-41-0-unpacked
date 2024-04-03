package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\b"}, d2 = {"androidx/compose/foundation/text/KeyMappingKt$commonKeyMapping$1", "Landroidx/compose/foundation/text/KeyMapping;", "map", "Landroidx/compose/foundation/text/KeyCommand;", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "map-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/foundation/text/KeyCommand;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KeyMappingKt$commonKeyMapping$1 implements KeyMapping {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1<KeyEvent, Boolean> f3508a;

    public KeyMappingKt$commonKeyMapping$1(Function1<? super KeyEvent, Boolean> function1) {
        this.f3508a = function1;
    }

    @Nullable
    /* renamed from: map-ZmokQxo  reason: not valid java name */
    public KeyCommand m852mapZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
        boolean z11;
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (!this.f3508a.invoke(KeyEvent.m4166boximpl(keyEvent)).booleanValue() || !KeyEvent_androidKt.m4189isShiftPressedZmokQxo(keyEvent)) {
            if (this.f3508a.invoke(KeyEvent.m4166boximpl(keyEvent)).booleanValue()) {
                long r22 = KeyEvent_androidKt.m4183getKeyZmokQxo(keyEvent);
                MappedKeys mappedKeys = MappedKeys.INSTANCE;
                if (Key.m3588equalsimpl0(r22, mappedKeys.m869getCEK5gGoQ())) {
                    z11 = true;
                } else {
                    z11 = Key.m3588equalsimpl0(r22, mappedKeys.m878getInsertEK5gGoQ());
                }
                if (z11) {
                    return KeyCommand.COPY;
                }
                if (Key.m3588equalsimpl0(r22, mappedKeys.m885getVEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m3588equalsimpl0(r22, mappedKeys.m886getXEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m3588equalsimpl0(r22, mappedKeys.m866getAEK5gGoQ())) {
                    return KeyCommand.SELECT_ALL;
                }
                if (Key.m3588equalsimpl0(r22, mappedKeys.m887getZEK5gGoQ())) {
                    return KeyCommand.UNDO;
                }
                return null;
            } else if (KeyEvent_androidKt.m4187isCtrlPressedZmokQxo(keyEvent)) {
                return null;
            } else {
                if (KeyEvent_androidKt.m4189isShiftPressedZmokQxo(keyEvent)) {
                    long r23 = KeyEvent_androidKt.m4183getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m3588equalsimpl0(r23, mappedKeys2.m873getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m3588equalsimpl0(r23, mappedKeys2.m874getDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m3588equalsimpl0(r23, mappedKeys2.m875getDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m3588equalsimpl0(r23, mappedKeys2.m872getDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m3588equalsimpl0(r23, mappedKeys2.m882getPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m3588equalsimpl0(r23, mappedKeys2.m881getPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m3588equalsimpl0(r23, mappedKeys2.m880getMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m3588equalsimpl0(r23, mappedKeys2.m879getMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m3588equalsimpl0(r23, mappedKeys2.m878getInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long r24 = KeyEvent_androidKt.m4183getKeyZmokQxo(keyEvent);
                MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                if (Key.m3588equalsimpl0(r24, mappedKeys3.m873getDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m3588equalsimpl0(r24, mappedKeys3.m874getDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m3588equalsimpl0(r24, mappedKeys3.m875getDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m3588equalsimpl0(r24, mappedKeys3.m872getDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m3588equalsimpl0(r24, mappedKeys3.m882getPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m3588equalsimpl0(r24, mappedKeys3.m881getPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m3588equalsimpl0(r24, mappedKeys3.m880getMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m3588equalsimpl0(r24, mappedKeys3.m879getMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m3588equalsimpl0(r24, mappedKeys3.m876getEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m3588equalsimpl0(r24, mappedKeys3.m868getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m3588equalsimpl0(r24, mappedKeys3.m871getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m3588equalsimpl0(r24, mappedKeys3.m883getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m3588equalsimpl0(r24, mappedKeys3.m870getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m3588equalsimpl0(r24, mappedKeys3.m884getTabEK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        } else if (Key.m3588equalsimpl0(KeyEvent_androidKt.m4183getKeyZmokQxo(keyEvent), MappedKeys.INSTANCE.m887getZEK5gGoQ())) {
            return KeyCommand.REDO;
        } else {
            return null;
        }
    }
}
