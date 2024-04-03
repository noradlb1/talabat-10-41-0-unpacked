package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.key.Key;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ClickableKt$PressedInteractionSourceDisposableEffect$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1521g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<PressInteraction.Press> f1522h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Map<Key, PressInteraction.Press> f1523i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f1524j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$PressedInteractionSourceDisposableEffect$2(MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, Map<Key, PressInteraction.Press> map, int i11) {
        super(2);
        this.f1521g = mutableInteractionSource;
        this.f1522h = mutableState;
        this.f1523i = map;
        this.f1524j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ClickableKt.PressedInteractionSourceDisposableEffect(this.f1521g, this.f1522h, this.f1523i, composer, this.f1524j | 1);
    }
}
