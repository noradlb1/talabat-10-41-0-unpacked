package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BottomSheetScaffoldKt$rememberBottomSheetState$2 extends Lambda implements Function0<BottomSheetState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BottomSheetValue f4239g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f4240h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<BottomSheetValue, Boolean> f4241i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomSheetScaffoldKt$rememberBottomSheetState$2(BottomSheetValue bottomSheetValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> function1) {
        super(0);
        this.f4239g = bottomSheetValue;
        this.f4240h = animationSpec;
        this.f4241i = function1;
    }

    @NotNull
    public final BottomSheetState invoke() {
        return new BottomSheetState(this.f4239g, this.f4240h, this.f4241i);
    }
}
