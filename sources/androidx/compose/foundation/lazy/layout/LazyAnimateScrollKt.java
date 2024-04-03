package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.Dp;
import com.google.android.gms.common.ConnectionResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0017\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\b\u001a%\u0010\u000b\u001a\u00020\u0007*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"BoundDistance", "Landroidx/compose/ui/unit/Dp;", "F", "DEBUG", "", "TargetDistance", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "animateScrollToItem", "Landroidx/compose/foundation/lazy/layout/LazyAnimateScrollScope;", "index", "", "scrollOffset", "(Landroidx/compose/foundation/lazy/layout/LazyAnimateScrollScope;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LazyAnimateScrollKt {
    /* access modifiers changed from: private */
    public static final float BoundDistance = Dp.m5478constructorimpl((float) ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
    private static final boolean DEBUG = false;
    /* access modifiers changed from: private */
    public static final float TargetDistance = Dp.m5478constructorimpl((float) 2500);

    @Nullable
    public static final Object animateScrollToItem(@NotNull LazyAnimateScrollScope lazyAnimateScrollScope, int i11, int i12, @NotNull Continuation<? super Unit> continuation) {
        Object scroll = lazyAnimateScrollScope.scroll(new LazyAnimateScrollKt$animateScrollToItem$2(i11, lazyAnimateScrollScope, i12, (Continuation<? super LazyAnimateScrollKt$animateScrollToItem$2>) null), continuation);
        return scroll == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
