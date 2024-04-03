package androidx.compose.foundation;

import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ClickableKt$genericClickableWithoutGesture$clickSemantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Role f1595g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f1596h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1597i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f1598j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f1599k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1600l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$genericClickableWithoutGesture$clickSemantics$1(Role role, String str, Function0<Unit> function0, String str2, boolean z11, Function0<Unit> function02) {
        super(1);
        this.f1595g = role;
        this.f1596h = str;
        this.f1597i = function0;
        this.f1598j = str2;
        this.f1599k = z11;
        this.f1600l = function02;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        Role role = this.f1595g;
        if (role != null) {
            SemanticsPropertiesKt.m4924setRolekuIjeqM(semanticsPropertyReceiver, role.m4910unboximpl());
        }
        String str = this.f1596h;
        final Function0<Unit> function0 = this.f1600l;
        SemanticsPropertiesKt.onClick(semanticsPropertyReceiver, str, new Function0<Boolean>() {
            @NotNull
            public final Boolean invoke() {
                function0.invoke();
                return Boolean.TRUE;
            }
        });
        final Function0<Unit> function02 = this.f1597i;
        if (function02 != null) {
            SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, this.f1598j, new Function0<Boolean>() {
                @NotNull
                public final Boolean invoke() {
                    function02.invoke();
                    return Boolean.TRUE;
                }
            });
        }
        if (!this.f1599k) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
    }
}
