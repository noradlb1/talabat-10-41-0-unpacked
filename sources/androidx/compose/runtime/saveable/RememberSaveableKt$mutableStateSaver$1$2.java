package androidx.compose.runtime.saveable;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/MutableState;", "T", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class RememberSaveableKt$mutableStateSaver$1$2 extends Lambda implements Function1<MutableState<Object>, MutableState<T>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Saver<T, Object> f9491g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RememberSaveableKt$mutableStateSaver$1$2(Saver<T, Object> saver) {
        super(1);
        this.f9491g = saver;
    }

    @Nullable
    public final MutableState<T> invoke(@NotNull MutableState<Object> mutableState) {
        T t11;
        Intrinsics.checkNotNullParameter(mutableState, "it");
        if (mutableState instanceof SnapshotMutableState) {
            if (mutableState.getValue() != null) {
                Saver<T, Object> saver = this.f9491g;
                Object value = mutableState.getValue();
                Intrinsics.checkNotNull(value);
                t11 = saver.restore(value);
            } else {
                t11 = null;
            }
            SnapshotMutationPolicy policy = ((SnapshotMutableState) mutableState).getPolicy();
            Intrinsics.checkNotNull(policy, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver$lambda-2?>");
            MutableState<T> mutableStateOf = SnapshotStateKt.mutableStateOf(t11, policy);
            Intrinsics.checkNotNull(mutableStateOf, "null cannot be cast to non-null type androidx.compose.runtime.MutableState<T of androidx.compose.runtime.saveable.RememberSaveableKt.mutableStateSaver$lambda-2>");
            return mutableStateOf;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
