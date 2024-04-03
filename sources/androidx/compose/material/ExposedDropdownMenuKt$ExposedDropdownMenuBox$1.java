package androidx.compose.material;

import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref<LayoutCoordinates> f4534g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ View f4535h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f4536i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f4537j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f4538k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuKt$ExposedDropdownMenuBox$1(Ref<LayoutCoordinates> ref, View view, int i11, MutableState<Integer> mutableState, MutableState<Integer> mutableState2) {
        super(1);
        this.f4534g = ref;
        this.f4535h = view;
        this.f4536i = i11;
        this.f4537j = mutableState;
        this.f4538k = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "it");
        ExposedDropdownMenuKt.m1254ExposedDropdownMenuBox$lambda2(this.f4537j, IntSize.m5638getWidthimpl(layoutCoordinates.m4473getSizeYbymL2g()));
        this.f4534g.setValue(layoutCoordinates);
        View rootView = this.f4535h.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
        int i11 = this.f4536i;
        final MutableState<Integer> mutableState = this.f4538k;
        ExposedDropdownMenuKt.updateHeight(rootView, this.f4534g.getValue(), i11, new Function1<Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i11) {
                ExposedDropdownMenuKt.m1256ExposedDropdownMenuBox$lambda5(mutableState, i11);
            }
        });
    }
}
