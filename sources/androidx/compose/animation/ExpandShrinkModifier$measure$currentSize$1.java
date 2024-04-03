package androidx.compose.animation;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntSize;", "it", "Landroidx/compose/animation/EnterExitState;", "invoke-YEO4UFw", "(Landroidx/compose/animation/EnterExitState;)J"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExpandShrinkModifier$measure$currentSize$1 extends Lambda implements Function1<EnterExitState, IntSize> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ExpandShrinkModifier f1263g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f1264h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandShrinkModifier$measure$currentSize$1(ExpandShrinkModifier expandShrinkModifier, long j11) {
        super(1);
        this.f1263g = expandShrinkModifier;
        this.f1264h = j11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntSize.m5630boximpl(m79invokeYEO4UFw((EnterExitState) obj));
    }

    /* renamed from: invoke-YEO4UFw  reason: not valid java name */
    public final long m79invokeYEO4UFw(@NotNull EnterExitState enterExitState) {
        Intrinsics.checkNotNullParameter(enterExitState, "it");
        return this.f1263g.m77sizeByStateUzc_VyU(enterExitState, this.f1264h);
    }
}
