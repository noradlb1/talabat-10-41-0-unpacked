package androidx.compose.ui.window;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidDialog_androidKt$Dialog$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f10344g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DialogProperties f10345h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f10346i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f10347j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f10348k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidDialog_androidKt$Dialog$3(Function0<Unit> function0, DialogProperties dialogProperties, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f10344g = function0;
        this.f10345h = dialogProperties;
        this.f10346i = function2;
        this.f10347j = i11;
        this.f10348k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidDialog_androidKt.Dialog(this.f10344g, this.f10345h, this.f10346i, composer, this.f10347j | 1, this.f10348k);
    }
}
