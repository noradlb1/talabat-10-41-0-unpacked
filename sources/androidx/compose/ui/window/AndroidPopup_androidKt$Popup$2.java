package androidx.compose.ui.window;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidPopup_androidKt$Popup$2 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f10364g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f10365h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PopupProperties f10366i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f10367j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LayoutDirection f10368k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidPopup_androidKt$Popup$2(PopupLayout popupLayout, Function0<Unit> function0, PopupProperties popupProperties, String str, LayoutDirection layoutDirection) {
        super(1);
        this.f10364g = popupLayout;
        this.f10365h = function0;
        this.f10366i = popupProperties;
        this.f10367j = str;
        this.f10368k = layoutDirection;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.f10364g.show();
        this.f10364g.updateParameters(this.f10365h, this.f10366i, this.f10367j, this.f10368k);
        return new AndroidPopup_androidKt$Popup$2$invoke$$inlined$onDispose$1(this.f10364g);
    }
}
