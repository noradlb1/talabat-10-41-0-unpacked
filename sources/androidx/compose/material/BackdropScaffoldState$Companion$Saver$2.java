package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/material/BackdropScaffoldState;", "it", "Landroidx/compose/material/BackdropValue;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BackdropScaffoldState$Companion$Saver$2 extends Lambda implements Function1<BackdropValue, BackdropScaffoldState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnimationSpec<Float> f4043g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<BackdropValue, Boolean> f4044h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SnackbarHostState f4045i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BackdropScaffoldState$Companion$Saver$2(AnimationSpec<Float> animationSpec, Function1<? super BackdropValue, Boolean> function1, SnackbarHostState snackbarHostState) {
        super(1);
        this.f4043g = animationSpec;
        this.f4044h = function1;
        this.f4045i = snackbarHostState;
    }

    @Nullable
    public final BackdropScaffoldState invoke(@NotNull BackdropValue backdropValue) {
        Intrinsics.checkNotNullParameter(backdropValue, "it");
        return new BackdropScaffoldState(backdropValue, this.f4043g, this.f4044h, this.f4045i);
    }
}
