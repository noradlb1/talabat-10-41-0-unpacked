package com.talabat.gem.adapters.presentation.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.gem.adapters.presentation.GemViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemSwimlanesViewHolder$initialize$1 extends Lambda implements Function1<View, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f60067g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemSwimlanesViewHolder f60068h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemSwimlanesViewHolder$initialize$1(ViewGroup viewGroup, GemSwimlanesViewHolder gemSwimlanesViewHolder) {
        super(1);
        this.f60067g = viewGroup;
        this.f60068h = gemSwimlanesViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Context context;
        GemSwimlanesViewHolder$initialize$1$1$1 gemSwimlanesViewHolder$initialize$1$1$1;
        Intrinsics.checkNotNullParameter(view, "$this$withViewHolder");
        ViewGroup viewGroup = this.f60067g;
        GemSwimlanesViewHolder gemSwimlanesViewHolder = this.f60068h;
        Context context2 = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Class cls = GemSwimlanesViewModel.class;
        if (context2 instanceof AppCompatActivity) {
            context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            gemSwimlanesViewHolder$initialize$1$1$1 = new GemSwimlanesViewHolder$initialize$1$1$1(gemSwimlanesViewHolder, view, (GemSwimlanesViewModel) ViewModelProviders.of((FragmentActivity) context2).get(cls));
        } else if (context2 instanceof Fragment) {
            context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            gemSwimlanesViewHolder$initialize$1$1$1 = new GemSwimlanesViewHolder$initialize$1$1$1(gemSwimlanesViewHolder, view, (GemSwimlanesViewModel) ViewModelProviders.of((Fragment) context2).get(cls));
        } else {
            throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
        }
        GemViewKt.withGemFlowTracking(gemSwimlanesViewHolder, context, gemSwimlanesViewHolder$initialize$1$1$1);
    }
}
