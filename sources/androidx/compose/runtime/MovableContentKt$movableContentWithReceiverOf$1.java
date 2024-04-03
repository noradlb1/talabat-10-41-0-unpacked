package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0002H\u0002H\u000b¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "R", "invoke", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MovableContentKt$movableContentWithReceiverOf$1 extends Lambda implements Function3<R, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MovableContent<R> f9133g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MovableContentKt$movableContentWithReceiverOf$1(MovableContent<R> movableContent) {
        super(3);
        this.f9133g = movableContent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(R r11, @Nullable Composer composer, int i11) {
        int i12;
        if ((i11 & 14) == 0) {
            i12 = (composer.changed((Object) r11) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 91) != 18 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(506997506, i11, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:171)");
            }
            composer.insertMovableContent(this.f9133g, r11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
