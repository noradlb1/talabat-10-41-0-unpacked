package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/geometry/Offset;", "invoke-k-4lQ0M", "(J)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LongPressTextDragObserverKt$detectDragGesturesWithObserver$2 extends Lambda implements Function1<Offset, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextDragObserver f3523g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LongPressTextDragObserverKt$detectDragGesturesWithObserver$2(TextDragObserver textDragObserver) {
        super(1);
        this.f3523g = textDragObserver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m864invokek4lQ0M(((Offset) obj).m2686unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
    public final void m864invokek4lQ0M(long j11) {
        this.f3523g.m905onStartk4lQ0M(j11);
    }
}
