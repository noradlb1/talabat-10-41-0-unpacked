package androidx.compose.material3;

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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$3 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f6996g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Ref<LayoutCoordinates> f6997h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f6998i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f6999j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuKt$ExposedDropdownMenuBox$3(View view, Ref<LayoutCoordinates> ref, int i11, MutableState<Integer> mutableState) {
        super(1);
        this.f6996g = view;
        this.f6997h = ref;
        this.f6998i = i11;
        this.f6999j = mutableState;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        View view = this.f6996g;
        return new ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$invoke$$inlined$onDispose$1(new OnGlobalLayoutListener(view, new ExposedDropdownMenuKt$ExposedDropdownMenuBox$3$listener$1(view, this.f6997h, this.f6998i, this.f6999j)));
    }
}
