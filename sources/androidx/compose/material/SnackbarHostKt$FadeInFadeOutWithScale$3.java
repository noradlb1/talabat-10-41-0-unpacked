package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SnackbarHostKt$FadeInFadeOutWithScale$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SnackbarData f5368g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f5369h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<SnackbarData, Composer, Integer, Unit> f5370i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5371j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5372k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarHostKt$FadeInFadeOutWithScale$3(SnackbarData snackbarData, Modifier modifier, Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f5368g = snackbarData;
        this.f5369h = modifier;
        this.f5370i = function3;
        this.f5371j = i11;
        this.f5372k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SnackbarHostKt.FadeInFadeOutWithScale(this.f5368g, this.f5369h, this.f5370i, composer, this.f5371j | 1, this.f5372k);
    }
}
