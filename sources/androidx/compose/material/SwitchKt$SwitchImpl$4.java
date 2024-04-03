package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SwitchKt$SwitchImpl$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BoxScope f5707g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f5708h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f5709i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SwitchColors f5710j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ State<Float> f5711k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ InteractionSource f5712l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f5713m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchKt$SwitchImpl$4(BoxScope boxScope, boolean z11, boolean z12, SwitchColors switchColors, State<Float> state, InteractionSource interactionSource, int i11) {
        super(2);
        this.f5707g = boxScope;
        this.f5708h = z11;
        this.f5709i = z12;
        this.f5710j = switchColors;
        this.f5711k = state;
        this.f5712l = interactionSource;
        this.f5713m = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SwitchKt.SwitchImpl(this.f5707g, this.f5708h, this.f5709i, this.f5710j, this.f5711k, this.f5712l, composer, this.f5713m | 1);
    }
}
