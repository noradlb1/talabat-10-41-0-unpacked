package androidx.compose.material3;

import android.view.View;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ExposedDropdownMenuBoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 implements ExposedDropdownMenuBoxScope {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f7011a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f7012b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7013c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FocusRequester f7014d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Ref<LayoutCoordinates> f7015e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f7016f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f7017g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f7018h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f7019i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Density f7020j;

    public ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(boolean z11, Function1<? super Boolean, Unit> function1, int i11, FocusRequester focusRequester, Ref<LayoutCoordinates> ref, View view, int i12, MutableState<Integer> mutableState, MutableState<Integer> mutableState2, Density density) {
        this.f7011a = z11;
        this.f7012b = function1;
        this.f7013c = i11;
        this.f7014d = focusRequester;
        this.f7015e = ref;
        this.f7016f = view;
        this.f7017g = i12;
        this.f7018h = mutableState;
        this.f7019i = mutableState2;
        this.f7020j = density;
    }

    public /* synthetic */ void ExposedDropdownMenu(boolean z11, Function0 function0, Modifier modifier, Function3 function3, Composer composer, int i11, int i12) {
        ExposedDropdownMenuBoxScope.CC.a(this, z11, function0, modifier, function3, composer, i11, i12);
    }

    @NotNull
    public Modifier exposedDropdownSize(@NotNull Modifier modifier, boolean z11) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Density density = this.f7020j;
        MutableState<Integer> mutableState = this.f7019i;
        MutableState<Integer> mutableState2 = this.f7018h;
        Modifier r72 = SizeKt.m546heightInVpY3zN4$default(modifier, 0.0f, density.m5444toDpu2uoSUM(ExposedDropdownMenuKt.m1673ExposedDropdownMenuBox$lambda4(mutableState)), 1, (Object) null);
        if (z11) {
            return SizeKt.m563width3ABfNKs(r72, density.m5444toDpu2uoSUM(ExposedDropdownMenuKt.m1671ExposedDropdownMenuBox$lambda1(mutableState2)));
        }
        return r72;
    }

    @NotNull
    public Modifier menuAnchor(@NotNull Modifier modifier) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$$inlined$debugInspectorInfo$1();
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return ComposedModifierKt.composed(modifier, function1, new ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2(this.f7011a, this.f7012b, this.f7013c, this.f7014d, this.f7015e, this.f7016f, this.f7017g, this.f7018h, this.f7019i));
    }
}
