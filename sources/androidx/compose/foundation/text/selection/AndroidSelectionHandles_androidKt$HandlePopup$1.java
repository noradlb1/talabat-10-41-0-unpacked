package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidSelectionHandles_androidKt$HandlePopup$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f3630g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ HandleReferencePoint f3631h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3632i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3633j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidSelectionHandles_androidKt$HandlePopup$1(long j11, HandleReferencePoint handleReferencePoint, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f3630g = j11;
        this.f3631h = handleReferencePoint;
        this.f3632i = function2;
        this.f3633j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidSelectionHandles_androidKt.m943HandlePopupULxng0E(this.f3630g, this.f3631h, this.f3632i, composer, this.f3633j | 1);
    }
}
