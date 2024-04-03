package androidx.compose.ui.platform;

import android.content.res.Configuration;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1 extends Lambda implements Function1<Configuration, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<Configuration> f10001g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1(MutableState<Configuration> mutableState) {
        super(1);
        this.f10001g = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Configuration) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "it");
        AndroidCompositionLocals_androidKt.m4819ProvideAndroidCompositionLocals$lambda2(this.f10001g, configuration);
    }
}
