package androidx.compose.ui.tooling;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ComposeViewAdapter$WrapPreview$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposeViewAdapter f10228g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f10229h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f10230i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter$WrapPreview$1(ComposeViewAdapter composeViewAdapter, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f10228g = composeViewAdapter;
        this.f10229h = function2;
        this.f10230i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            InspectableKt.Inspectable(this.f10228g.slotTableRecord, this.f10229h, composer, (this.f10230i << 3) & 112);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
