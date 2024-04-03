package androidx.compose.ui.viewinterop;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidViewHolder$onCommitAffectingUpdate$1 extends Lambda implements Function1<AndroidViewHolder, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AndroidViewHolder f10301g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder$onCommitAffectingUpdate$1(AndroidViewHolder androidViewHolder) {
        super(1);
        this.f10301g = androidViewHolder;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m5716invoke$lambda0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AndroidViewHolder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AndroidViewHolder androidViewHolder) {
        Intrinsics.checkNotNullParameter(androidViewHolder, "it");
        this.f10301g.getHandler().post(new a(this.f10301g.runUpdate));
    }
}
