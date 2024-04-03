package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class InspectableKt$Inspectable$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CompositionDataRecord f10258g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f10259h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f10260i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InspectableKt$Inspectable$1(CompositionDataRecord compositionDataRecord, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f10258g = compositionDataRecord;
        this.f10259h = function2;
        this.f10260i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        InspectableKt.Inspectable(this.f10258g, this.f10259h, composer, this.f10260i | 1);
    }
}
