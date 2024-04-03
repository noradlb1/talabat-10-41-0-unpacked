package androidx.compose.material3;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuKt$expandable$2$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7047g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f7048h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f7049i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f7050j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f7051k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuKt$expandable$2$1(boolean z11, String str, String str2, String str3, Function0<Unit> function0) {
        super(1);
        this.f7047g = z11;
        this.f7048h = str;
        this.f7049i = str2;
        this.f7050j = str3;
        this.f7051k = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, this.f7047g ? this.f7048h : this.f7049i);
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, this.f7050j);
        final Function0<Unit> function0 = this.f7051k;
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
            @NotNull
            public final Boolean invoke() {
                function0.invoke();
                return Boolean.TRUE;
            }
        }, 1, (Object) null);
    }
}
