package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.unit.Velocity;
import h0.a;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface NestedScrollConnection {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Nullable
        @Deprecated
        /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
        public static Object m4198onPostFlingRZ2iAVY(@NotNull NestedScrollConnection nestedScrollConnection, long j11, long j12, @NotNull Continuation<? super Velocity> continuation) {
            return a.a(nestedScrollConnection, j11, j12, continuation);
        }

        @Deprecated
        /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
        public static long m4199onPostScrollDzOQY0M(@NotNull NestedScrollConnection nestedScrollConnection, long j11, long j12, int i11) {
            return a.b(nestedScrollConnection, j11, j12, i11);
        }

        @Nullable
        @Deprecated
        /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
        public static Object m4200onPreFlingQWom1Mo(@NotNull NestedScrollConnection nestedScrollConnection, long j11, @NotNull Continuation<? super Velocity> continuation) {
            return a.c(nestedScrollConnection, j11, continuation);
        }

        @Deprecated
        /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
        public static long m4201onPreScrollOzD1aCk(@NotNull NestedScrollConnection nestedScrollConnection, long j11, int i11) {
            return a.d(nestedScrollConnection, j11, i11);
        }
    }

    @Nullable
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    Object m4194onPostFlingRZ2iAVY(long j11, long j12, @NotNull Continuation<? super Velocity> continuation);

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    long m4195onPostScrollDzOQY0M(long j11, long j12, int i11);

    @Nullable
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    Object m4196onPreFlingQWom1Mo(long j11, @NotNull Continuation<? super Velocity> continuation);

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    long m4197onPreScrollOzD1aCk(long j11, int i11);
}
