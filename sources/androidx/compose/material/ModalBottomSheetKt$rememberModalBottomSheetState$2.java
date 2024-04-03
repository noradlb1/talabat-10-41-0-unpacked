package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ModalBottomSheetKt$rememberModalBottomSheetState$2 extends Lambda implements Function0<ModalBottomSheetState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ModalBottomSheetValue f4758g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f4759h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f4760i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<ModalBottomSheetValue, Boolean> f4761j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetKt$rememberModalBottomSheetState$2(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec<Float> animationSpec, boolean z11, Function1<? super ModalBottomSheetValue, Boolean> function1) {
        super(0);
        this.f4758g = modalBottomSheetValue;
        this.f4759h = animationSpec;
        this.f4760i = z11;
        this.f4761j = function1;
    }

    @NotNull
    public final ModalBottomSheetState invoke() {
        return new ModalBottomSheetState(this.f4758g, this.f4759h, this.f4760i, this.f4761j);
    }
}
