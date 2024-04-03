package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "owner", "Landroidx/compose/ui/node/Owner;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidViewHolder$layoutNode$1$3 extends Lambda implements Function1<Owner, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AndroidViewHolder f10288g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LayoutNode f10289h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<View> f10290i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder$layoutNode$1$3(AndroidViewHolder androidViewHolder, LayoutNode layoutNode, Ref.ObjectRef<View> objectRef) {
        super(1);
        this.f10288g = androidViewHolder;
        this.f10289h = layoutNode;
        this.f10290i = objectRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Owner) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Owner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
        if (androidComposeView != null) {
            androidComposeView.addAndroidView(this.f10288g, this.f10289h);
        }
        T t11 = this.f10290i.element;
        if (t11 != null) {
            this.f10288g.setView$ui_release((View) t11);
        }
    }
}
