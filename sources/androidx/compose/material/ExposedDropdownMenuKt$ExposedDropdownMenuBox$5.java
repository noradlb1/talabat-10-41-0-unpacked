package androidx.compose.material;

import android.view.View;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$5 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f4544g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Ref<LayoutCoordinates> f4545h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f4546i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f4547j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuKt$ExposedDropdownMenuBox$5(View view, Ref<LayoutCoordinates> ref, int i11, MutableState<Integer> mutableState) {
        super(1);
        this.f4544g = view;
        this.f4545h = ref;
        this.f4546i = i11;
        this.f4547j = mutableState;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        View view = this.f4544g;
        return new ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$invoke$$inlined$onDispose$1(new OnGlobalLayoutListener(view, new ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1(view, this.f4545h, this.f4546i, this.f4547j)));
    }
}
