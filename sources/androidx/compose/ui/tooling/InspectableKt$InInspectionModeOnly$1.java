package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InspectableKt$InInspectionModeOnly$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f10256g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10257h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InspectableKt$InInspectionModeOnly$1(Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f10256g = function2;
        this.f10257h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        InspectableKt.InInspectionModeOnly(this.f10256g, composer, this.f10257h | 1);
    }
}
