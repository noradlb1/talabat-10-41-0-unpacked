package androidx.compose.material;

import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f4548g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Ref<LayoutCoordinates> f4549h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f4550i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f4551j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1(View view, Ref<LayoutCoordinates> ref, int i11, MutableState<Integer> mutableState) {
        super(0);
        this.f4548g = view;
        this.f4549h = ref;
        this.f4550i = i11;
        this.f4551j = mutableState;
    }

    public final void invoke() {
        View rootView = this.f4548g.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "view.rootView");
        int i11 = this.f4550i;
        final MutableState<Integer> mutableState = this.f4551j;
        ExposedDropdownMenuKt.updateHeight(rootView, this.f4549h.getValue(), i11, new Function1<Integer, Unit>() {
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
