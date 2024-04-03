package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class VectorPainterKt$RenderVectorGroup$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VectorGroup f9742g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Map<String, VectorConfig> f9743h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f9744i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f9745j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VectorPainterKt$RenderVectorGroup$2(VectorGroup vectorGroup, Map<String, ? extends VectorConfig> map, int i11, int i12) {
        super(2);
        this.f9742g = vectorGroup;
        this.f9743h = map;
        this.f9744i = i11;
        this.f9745j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        VectorPainterKt.RenderVectorGroup(this.f9742g, this.f9743h, composer, this.f9744i | 1, this.f9745j);
    }
}
