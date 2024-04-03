package com.talabat.gem.adapters.presentation.restaurants;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.GemView;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.ActivityKt;
import com.talabat.talabatcommon.extentions.ThrowablesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/gem/adapters/presentation/GemView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemFloatingView$initialize$1 extends Lambda implements Function1<GemView, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemFloatingView f60288g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Context f60289h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemFloatingView$initialize$1(GemFloatingView gemFloatingView, Context context) {
        super(1);
        this.f60288g = gemFloatingView;
        this.f60289h = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemView gemView) {
        Intrinsics.checkNotNullParameter(gemView, "$this$withGemFlowTracking");
        int i11 = R.layout.v2_gem_floating_button;
        GemFloatingView gemFloatingView = this.f60288g;
        Context context = this.f60289h;
        if (gemView instanceof View) {
            ViewKt.withLayout((View) gemView, i11, new GemFloatingView$initialize$1$invoke$$inlined$bind$1(gemView, gemFloatingView, context));
        } else if (gemView instanceof AppCompatActivity) {
            ActivityKt.withLayout((AppCompatActivity) gemView, i11, new GemFloatingView$initialize$1$invoke$$inlined$bind$2(gemView, gemFloatingView, context));
        } else {
            ThrowablesKt.log(new UnsupportedOperationException(gemView + " must be a View or AppCompatActivity"));
        }
    }
}
