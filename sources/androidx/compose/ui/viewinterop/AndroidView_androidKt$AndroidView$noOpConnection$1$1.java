package androidx.compose.ui.viewinterop;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import h0.a;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidView_androidKt$AndroidView$noOpConnection$1$1 implements NestedScrollConnection {
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    public /* synthetic */ Object m5718onPostFlingRZ2iAVY(long j11, long j12, Continuation continuation) {
        return a.a(this, j11, j12, continuation);
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public /* synthetic */ long m5719onPostScrollDzOQY0M(long j11, long j12, int i11) {
        return a.b(this, j11, j12, i11);
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public /* synthetic */ Object m5720onPreFlingQWom1Mo(long j11, Continuation continuation) {
        return a.c(this, j11, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public /* synthetic */ long m5721onPreScrollOzD1aCk(long j11, int i11) {
        return a.d(this, j11, i11);
    }
}
