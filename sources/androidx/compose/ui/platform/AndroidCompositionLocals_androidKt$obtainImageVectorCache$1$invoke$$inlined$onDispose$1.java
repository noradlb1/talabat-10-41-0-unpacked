package androidx.compose.ui.platform;

import android.content.Context;
import androidx.compose.runtime.DisposableEffectResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f9999a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 f10000b;

    public AndroidCompositionLocals_androidKt$obtainImageVectorCache$1$invoke$$inlined$onDispose$1(Context context, AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1 androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1) {
        this.f9999a = context;
        this.f10000b = androidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1;
    }

    public void dispose() {
        this.f9999a.getApplicationContext().unregisterComponentCallbacks(this.f10000b);
    }
}
