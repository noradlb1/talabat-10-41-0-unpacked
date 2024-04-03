package com.talabat.gem.adapters.presentation.checkout;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.gem.adapters.R;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.extentions.ThrowablesKt;
import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import com.talabat.talabatcommon.lifecycle.AutoDisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/appcompat/app/AppCompatActivity;", "invoke", "com/talabat/talabatcommon/lifecycle/AutoDisposableKt$bind$4"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCheckoutFooterView$initialize$1$invoke$$inlined$bind$2 extends Lambda implements Function1<AppCompatActivity, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AutoDisposable f59941g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemCheckoutFooterView f59942h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Context f59943i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemCheckoutFooterView$initialize$1$invoke$$inlined$bind$2(AutoDisposable autoDisposable, GemCheckoutFooterView gemCheckoutFooterView, Context context) {
        super(1);
        this.f59941g = autoDisposable;
        this.f59942h = gemCheckoutFooterView;
        this.f59943i = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppCompatActivity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$withLayout");
        final AutoDisposable autoDisposable = this.f59941g;
        if (autoDisposable instanceof View) {
            final GemCheckoutFooterView gemCheckoutFooterView = this.f59942h;
            final Context context = this.f59943i;
            AutoDisposableKt.autoDisposeView(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    GemCheckoutFooterViewModel gemCheckoutFooterViewModel;
                    GemCheckoutFooterView$initialize$1$1$5 gemCheckoutFooterView$initialize$1$1$5;
                    Context context = ((View) autoDisposable).getContext();
                    Class cls = GemCheckoutFooterViewModel.class;
                    if (context instanceof AppCompatActivity) {
                        gemCheckoutFooterViewModel = (GemCheckoutFooterViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
                        TextView textView = (TextView) gemCheckoutFooterView._$_findCachedViewById(R.id.counterLabelTextView);
                        Intrinsics.checkNotNullExpressionValue(textView, "counterLabelTextView");
                        ViewKt.invisible(textView);
                        gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$1(gemCheckoutFooterViewModel));
                        gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$2(gemCheckoutFooterViewModel, gemCheckoutFooterView));
                        gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$3(gemCheckoutFooterViewModel, gemCheckoutFooterView));
                        gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$4(gemCheckoutFooterViewModel, context));
                        gemCheckoutFooterView$initialize$1$1$5 = new GemCheckoutFooterView$initialize$1$1$5(gemCheckoutFooterView, gemCheckoutFooterViewModel);
                    } else if (context instanceof FragmentActivity) {
                        gemCheckoutFooterViewModel = (GemCheckoutFooterViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
                        TextView textView2 = (TextView) gemCheckoutFooterView._$_findCachedViewById(R.id.counterLabelTextView);
                        Intrinsics.checkNotNullExpressionValue(textView2, "counterLabelTextView");
                        ViewKt.invisible(textView2);
                        gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$1(gemCheckoutFooterViewModel));
                        gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$2(gemCheckoutFooterViewModel, gemCheckoutFooterView));
                        gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$3(gemCheckoutFooterViewModel, gemCheckoutFooterView));
                        gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$4(gemCheckoutFooterViewModel, context));
                        gemCheckoutFooterView$initialize$1$1$5 = new GemCheckoutFooterView$initialize$1$1$5(gemCheckoutFooterView, gemCheckoutFooterViewModel);
                    } else if (context instanceof Fragment) {
                        gemCheckoutFooterViewModel = (GemCheckoutFooterViewModel) ViewModelProviders.of((Fragment) context).get(cls);
                        TextView textView3 = (TextView) gemCheckoutFooterView._$_findCachedViewById(R.id.counterLabelTextView);
                        Intrinsics.checkNotNullExpressionValue(textView3, "counterLabelTextView");
                        ViewKt.invisible(textView3);
                        gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$1(gemCheckoutFooterViewModel));
                        gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$2(gemCheckoutFooterViewModel, gemCheckoutFooterView));
                        gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$3(gemCheckoutFooterViewModel, gemCheckoutFooterView));
                        gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$4(gemCheckoutFooterViewModel, context));
                        gemCheckoutFooterView$initialize$1$1$5 = new GemCheckoutFooterView$initialize$1$1$5(gemCheckoutFooterView, gemCheckoutFooterViewModel);
                    } else {
                        throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
                    }
                    gemCheckoutFooterViewModel.autoDispose(gemCheckoutFooterView$initialize$1$1$5);
                }
            });
        } else if (autoDisposable instanceof AppCompatActivity) {
            final GemCheckoutFooterView gemCheckoutFooterView2 = this.f59942h;
            final Context context2 = this.f59943i;
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    GemCheckoutFooterViewModel gemCheckoutFooterViewModel = (GemCheckoutFooterViewModel) ViewModelProviders.of((FragmentActivity) autoDisposable).get(GemCheckoutFooterViewModel.class);
                    TextView textView = (TextView) gemCheckoutFooterView2._$_findCachedViewById(R.id.counterLabelTextView);
                    Intrinsics.checkNotNullExpressionValue(textView, "counterLabelTextView");
                    ViewKt.invisible(textView);
                    gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$1(gemCheckoutFooterViewModel));
                    gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$2(gemCheckoutFooterViewModel, gemCheckoutFooterView2));
                    gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$3(gemCheckoutFooterViewModel, gemCheckoutFooterView2));
                    gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$4(gemCheckoutFooterViewModel, context2));
                    gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$5(gemCheckoutFooterView2, gemCheckoutFooterViewModel));
                }
            });
        } else if (autoDisposable instanceof Fragment) {
            final GemCheckoutFooterView gemCheckoutFooterView3 = this.f59942h;
            final Context context3 = this.f59943i;
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    GemCheckoutFooterViewModel gemCheckoutFooterViewModel = (GemCheckoutFooterViewModel) ViewModelProviders.of((Fragment) autoDisposable).get(GemCheckoutFooterViewModel.class);
                    TextView textView = (TextView) gemCheckoutFooterView3._$_findCachedViewById(R.id.counterLabelTextView);
                    Intrinsics.checkNotNullExpressionValue(textView, "counterLabelTextView");
                    ViewKt.invisible(textView);
                    gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$1(gemCheckoutFooterViewModel));
                    gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$2(gemCheckoutFooterViewModel, gemCheckoutFooterView3));
                    gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$3(gemCheckoutFooterViewModel, gemCheckoutFooterView3));
                    gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$4(gemCheckoutFooterViewModel, context3));
                    gemCheckoutFooterViewModel.autoDispose(new GemCheckoutFooterView$initialize$1$1$5(gemCheckoutFooterView3, gemCheckoutFooterViewModel));
                }
            });
        } else {
            ThrowablesKt.log(new UnsupportedOperationException(autoDisposable + " must be a View, AppCompatActivity, or a Fragment"));
        }
    }
}
