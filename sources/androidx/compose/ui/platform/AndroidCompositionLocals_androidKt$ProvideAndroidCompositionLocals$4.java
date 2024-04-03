package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$4 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AndroidComposeView f10007g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f10008h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f10009i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$4(AndroidComposeView androidComposeView, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f10007g = androidComposeView;
        this.f10008h = function2;
        this.f10009i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidCompositionLocals_androidKt.ProvideAndroidCompositionLocals(this.f10007g, this.f10008h, composer, this.f10009i | 1);
    }
}
