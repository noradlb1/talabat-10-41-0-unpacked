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
public final class SnackbarHostKt$SnackbarHost$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SnackbarHostState f5376g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f5377h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<SnackbarData, Composer, Integer, Unit> f5378i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5379j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f5380k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarHostKt$SnackbarHost$2(SnackbarHostState snackbarHostState, Modifier modifier, Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f5376g = snackbarHostState;
        this.f5377h = modifier;
        this.f5378i = function3;
        this.f5379j = i11;
        this.f5380k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SnackbarHostKt.SnackbarHost(this.f5376g, this.f5377h, this.f5378i, composer, this.f5379j | 1, this.f5380k);
    }
}
