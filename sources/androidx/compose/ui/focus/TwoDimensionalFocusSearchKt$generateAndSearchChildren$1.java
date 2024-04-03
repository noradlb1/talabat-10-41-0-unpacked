package androidx.compose.ui.focus;

import androidx.compose.ui.layout.BeyondBoundsLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "invoke", "(Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TwoDimensionalFocusSearchKt$generateAndSearchChildren$1 extends Lambda implements Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FocusModifier f9606g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FocusModifier f9607h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f9608i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<FocusModifier, Boolean> f9609j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TwoDimensionalFocusSearchKt$generateAndSearchChildren$1(FocusModifier focusModifier, FocusModifier focusModifier2, int i11, Function1<? super FocusModifier, Boolean> function1) {
        super(1);
        this.f9606g = focusModifier;
        this.f9607h = focusModifier2;
        this.f9608i = i11;
        this.f9609j = function1;
    }

    @Nullable
    public final Boolean invoke(@NotNull BeyondBoundsLayout.BeyondBoundsScope beyondBoundsScope) {
        Intrinsics.checkNotNullParameter(beyondBoundsScope, "$this$searchBeyondBounds");
        Boolean valueOf = Boolean.valueOf(TwoDimensionalFocusSearchKt.m2640searchChildren4C6V_qg(this.f9606g, this.f9607h, this.f9608i, this.f9609j));
        if (valueOf.booleanValue() || !beyondBoundsScope.getHasMoreContent()) {
            return valueOf;
        }
        return null;
    }
}
