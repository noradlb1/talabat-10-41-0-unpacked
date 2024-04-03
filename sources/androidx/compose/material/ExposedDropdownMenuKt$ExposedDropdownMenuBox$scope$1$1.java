package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ExposedDropdownMenuBoxScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1 implements ExposedDropdownMenuBoxScope {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Density f4559a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f4560b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f4561c;

    public ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1(Density density, MutableState<Integer> mutableState, MutableState<Integer> mutableState2) {
        this.f4559a = density;
        this.f4560b = mutableState;
        this.f4561c = mutableState2;
    }

    @Composable
    public void ExposedDropdownMenu(boolean z11, @NotNull Function0<Unit> function0, @NotNull Modifier modifier, @NotNull Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i11, int i12) {
        ExposedDropdownMenuBoxScope.DefaultImpls.ExposedDropdownMenu(this, z11, function0, modifier, function3, composer, i11, i12);
    }

    @NotNull
    public Modifier exposedDropdownSize(@NotNull Modifier modifier, boolean z11) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Density density = this.f4559a;
        MutableState<Integer> mutableState = this.f4560b;
        MutableState<Integer> mutableState2 = this.f4561c;
        Modifier r72 = SizeKt.m546heightInVpY3zN4$default(modifier, 0.0f, density.m5444toDpu2uoSUM(ExposedDropdownMenuKt.m1255ExposedDropdownMenuBox$lambda4(mutableState)), 1, (Object) null);
        if (z11) {
            return SizeKt.m563width3ABfNKs(r72, density.m5444toDpu2uoSUM(ExposedDropdownMenuKt.m1253ExposedDropdownMenuBox$lambda1(mutableState2)));
        }
        return r72;
    }
}
