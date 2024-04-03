package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a\f\u0010\u0010\u001a\u00020\u0005*\u00020\u0011H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001b\u0010\t\u001a\u00020\u0005*\u00020\u00068BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u001b\u0010\u000b\u001a\u00020\u0005*\u00020\u00068@X\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\f\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"TapIndicationDelay", "", "getTapIndicationDelay", "()J", "isClick", "", "Landroidx/compose/ui/input/key/KeyEvent;", "isClick-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isEnter", "isEnter-ZmokQxo", "isPress", "isPress-ZmokQxo", "isComposeRootInScrollableContainer", "Lkotlin/Function0;", "(Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "isInScrollableViewGroup", "Landroid/view/View;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class Clickable_androidKt {
    private static final long TapIndicationDelay = ((long) ViewConfiguration.getTapTimeout());

    public static final long getTapIndicationDelay() {
        return TapIndicationDelay;
    }

    /* renamed from: isClick-ZmokQxo  reason: not valid java name */
    public static final boolean m211isClickZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "$this$isClick");
        if (!KeyEventType.m4176equalsimpl0(KeyEvent_androidKt.m4184getTypeZmokQxo(keyEvent), KeyEventType.Companion.m4181getKeyUpCS__XNY()) || !m212isEnterZmokQxo(keyEvent)) {
            return false;
        }
        return true;
    }

    @NotNull
    @Composable
    public static final Function0<Boolean> isComposeRootInScrollableContainer(@Nullable Composer composer, int i11) {
        composer.startReplaceableGroup(-1990508712);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1990508712, i11, -1, "androidx.compose.foundation.isComposeRootInScrollableContainer (Clickable.android.kt:34)");
        }
        Clickable_androidKt$isComposeRootInScrollableContainer$1 clickable_androidKt$isComposeRootInScrollableContainer$1 = new Clickable_androidKt$isComposeRootInScrollableContainer$1((View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return clickable_androidKt$isComposeRootInScrollableContainer$1;
    }

    /* renamed from: isEnter-ZmokQxo  reason: not valid java name */
    private static final boolean m212isEnterZmokQxo(KeyEvent keyEvent) {
        int r22 = Key_androidKt.m4193getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m4183getKeyZmokQxo(keyEvent));
        return r22 == 23 || r22 == 66 || r22 == 160;
    }

    /* access modifiers changed from: private */
    public static final boolean isInScrollableViewGroup(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = viewGroup.getParent();
        }
        return false;
    }

    /* renamed from: isPress-ZmokQxo  reason: not valid java name */
    public static final boolean m213isPressZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "$this$isPress");
        if (!KeyEventType.m4176equalsimpl0(KeyEvent_androidKt.m4184getTypeZmokQxo(keyEvent), KeyEventType.Companion.m4180getKeyDownCS__XNY()) || !m212isEnterZmokQxo(keyEvent)) {
            return false;
        }
        return true;
    }
}
