package androidx.compose.ui.platform;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AndroidComposeView f10003g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ AndroidUriHandler f10004h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f10005i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f10006j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3(AndroidComposeView androidComposeView, AndroidUriHandler androidUriHandler, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f10003g = androidComposeView;
        this.f10004h = androidUriHandler;
        this.f10005i = function2;
        this.f10006j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1471621628, i11, -1, "androidx.compose.ui.platform.ProvideAndroidCompositionLocals.<anonymous> (AndroidCompositionLocals.android.kt:121)");
            }
            CompositionLocalsKt.ProvideCommonCompositionLocals(this.f10003g, this.f10004h, this.f10005i, composer, ((this.f10006j << 3) & 896) | 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
