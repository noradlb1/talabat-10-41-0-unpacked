package androidx.compose.ui.platform;

import a0.c;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/compose/ui/platform/MotionDurationScaleImpl;", "Landroidx/compose/ui/MotionDurationScale;", "()V", "<set-?>", "", "scaleFactor", "getScaleFactor", "()F", "setScaleFactor", "(F)V", "scaleFactor$delegate", "Landroidx/compose/runtime/MutableState;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class MotionDurationScaleImpl implements MotionDurationScale {
    @NotNull
    private final MutableState scaleFactor$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);

    public <R> R fold(R r11, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return MotionDurationScale.DefaultImpls.fold(this, r11, function2);
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return MotionDurationScale.DefaultImpls.get(this, key);
    }

    public /* synthetic */ CoroutineContext.Key getKey() {
        return c.a(this);
    }

    public float getScaleFactor() {
        return ((Number) this.scaleFactor$delegate.getValue()).floatValue();
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return MotionDurationScale.DefaultImpls.minusKey(this, key);
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return MotionDurationScale.DefaultImpls.plus(this, coroutineContext);
    }

    public void setScaleFactor(float f11) {
        this.scaleFactor$delegate.setValue(Float.valueOf(f11));
    }
}
