package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class BackdropScaffoldKt$rememberBackdropScaffoldState$3 extends Lambda implements Function0<BackdropScaffoldState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BackdropValue f4039g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f4040h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<BackdropValue, Boolean> f4041i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SnackbarHostState f4042j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldKt$rememberBackdropScaffoldState$3(BackdropValue backdropValue, AnimationSpec<Float> animationSpec, Function1<? super BackdropValue, Boolean> function1, SnackbarHostState snackbarHostState) {
        super(0);
        this.f4039g = backdropValue;
        this.f4040h = animationSpec;
        this.f4041i = function1;
        this.f4042j = snackbarHostState;
    }

    @NotNull
    public final BackdropScaffoldState invoke() {
        return new BackdropScaffoldState(this.f4039g, this.f4040h, this.f4041i, this.f4042j);
    }
}
