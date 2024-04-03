package com.deliveryhero.fluid.widgets.containers;

import android.view.View;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke", "(Landroid/view/View;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnhancedLinearLayout$applyCompressionResistancePriority$minChild$1 extends Lambda implements Function1<View, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Set<View> f30264g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ EnhancedLinearLayout f30265h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnhancedLinearLayout$applyCompressionResistancePriority$minChild$1(Set<View> set, EnhancedLinearLayout enhancedLinearLayout) {
        super(1);
        this.f30264g = set;
        this.f30265h = enhancedLinearLayout;
    }

    @NotNull
    public final Boolean invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        return Boolean.valueOf(!this.f30264g.contains(view) && (this.f30265h.getMainAxisSize(view) == -2 || this.f30265h.getMainAxisSize(view) == -1));
    }
}
