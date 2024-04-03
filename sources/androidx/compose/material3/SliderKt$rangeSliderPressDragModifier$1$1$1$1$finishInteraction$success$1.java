package androidx.compose.material3;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$rangeSliderPressDragModifier$1$1$1$1$finishInteraction$success$1 extends Lambda implements Function1<PointerInputChange, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ State<Function2<Boolean, Float, Unit>> f8173g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f8174h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f8175i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$rangeSliderPressDragModifier$1$1$1$1$finishInteraction$success$1(State<? extends Function2<? super Boolean, ? super Float, Unit>> state, Ref.BooleanRef booleanRef, boolean z11) {
        super(1);
        this.f8173g = state;
        this.f8174h = booleanRef;
        this.f8175i = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerInputChange) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "it");
        float r42 = Offset.m2676getXimpl(PointerEventKt.positionChange(pointerInputChange));
        Function2 value = this.f8173g.getValue();
        Boolean valueOf = Boolean.valueOf(this.f8174h.element);
        if (this.f8175i) {
            r42 = -r42;
        }
        value.invoke(valueOf, Float.valueOf(r42));
    }
}
