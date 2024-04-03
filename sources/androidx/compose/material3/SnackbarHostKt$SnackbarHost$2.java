package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SnackbarHostKt$SnackbarHost$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SnackbarHostState f8236g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f8237h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<SnackbarData, Composer, Integer, Unit> f8238i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f8239j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f8240k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SnackbarHostKt$SnackbarHost$2(SnackbarHostState snackbarHostState, Modifier modifier, Function3<? super SnackbarData, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f8236g = snackbarHostState;
        this.f8237h = modifier;
        this.f8238i = function3;
        this.f8239j = i11;
        this.f8240k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SnackbarHostKt.SnackbarHost(this.f8236g, this.f8237h, this.f8238i, composer, this.f8239j | 1, this.f8240k);
    }
}
