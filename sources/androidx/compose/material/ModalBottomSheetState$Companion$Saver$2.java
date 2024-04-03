package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/material/ModalBottomSheetState;", "it", "Landroidx/compose/material/ModalBottomSheetValue;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ModalBottomSheetState$Companion$Saver$2 extends Lambda implements Function1<ModalBottomSheetValue, ModalBottomSheetState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f4762g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f4763h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<ModalBottomSheetValue, Boolean> f4764i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetState$Companion$Saver$2(AnimationSpec<Float> animationSpec, boolean z11, Function1<? super ModalBottomSheetValue, Boolean> function1) {
        super(1);
        this.f4762g = animationSpec;
        this.f4763h = z11;
        this.f4764i = function1;
    }

    @Nullable
    public final ModalBottomSheetState invoke(@NotNull ModalBottomSheetValue modalBottomSheetValue) {
        Intrinsics.checkNotNullParameter(modalBottomSheetValue, "it");
        return new ModalBottomSheetState(modalBottomSheetValue, this.f4762g, this.f4763h, this.f4764i);
    }
}
