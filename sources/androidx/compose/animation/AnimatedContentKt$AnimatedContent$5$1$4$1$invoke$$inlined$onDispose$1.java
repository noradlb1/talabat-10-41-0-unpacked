package androidx.compose.animation;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnimatedContentKt$AnimatedContent$5$1$4$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SnapshotStateList f1049a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f1050b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AnimatedContentScope f1051c;

    public AnimatedContentKt$AnimatedContent$5$1$4$1$invoke$$inlined$onDispose$1(SnapshotStateList snapshotStateList, Object obj, AnimatedContentScope animatedContentScope) {
        this.f1049a = snapshotStateList;
        this.f1050b = obj;
        this.f1051c = animatedContentScope;
    }

    public void dispose() {
        this.f1049a.remove(this.f1050b);
        this.f1051c.getTargetSizeMap$animation_release().remove(this.f1050b);
    }
}
