package androidx.compose.foundation.layout;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import h0.a;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/DoNothingNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "()V", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class DoNothingNestedScrollConnection implements NestedScrollConnection {
    @NotNull
    public static final DoNothingNestedScrollConnection INSTANCE = new DoNothingNestedScrollConnection();

    private DoNothingNestedScrollConnection() {
    }

    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public /* synthetic */ Object m449onPostFlingRZ2iAVY(long j11, long j12, Continuation continuation) {
        return a.a(this, j11, j12, continuation);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public /* synthetic */ long m450onPostScrollDzOQY0M(long j11, long j12, int i11) {
        return a.b(this, j11, j12, i11);
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public /* synthetic */ Object m451onPreFlingQWom1Mo(long j11, Continuation continuation) {
        return a.c(this, j11, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public /* synthetic */ long m452onPreScrollOzD1aCk(long j11, int i11) {
        return a.d(this, j11, i11);
    }
}
