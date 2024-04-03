package androidx.compose.ui.window;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidDialog_androidKt$DialogLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f10352g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f10353h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f10354i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f10355j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidDialog_androidKt$DialogLayout$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f10352g = modifier;
        this.f10353h = function2;
        this.f10354i = i11;
        this.f10355j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidDialog_androidKt.DialogLayout(this.f10352g, this.f10353h, composer, this.f10354i | 1, this.f10355j);
    }
}
