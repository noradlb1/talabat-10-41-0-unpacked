package androidx.compose.foundation.layout;

import android.view.View;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class WindowInsetsHolder$Companion$current$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsHolder f2594g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ View f2595h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WindowInsetsHolder$Companion$current$1(WindowInsetsHolder windowInsetsHolder, View view) {
        super(1);
        this.f2594g = windowInsetsHolder;
        this.f2595h = view;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.f2594g.incrementAccessors(this.f2595h);
        return new WindowInsetsHolder$Companion$current$1$invoke$$inlined$onDispose$1(this.f2594g, this.f2595h);
    }
}
