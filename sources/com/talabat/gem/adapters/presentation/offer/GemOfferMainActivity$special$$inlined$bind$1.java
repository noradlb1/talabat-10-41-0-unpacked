package com.talabat.gem.adapters.presentation.offer;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
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

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "VM", "Landroidx/lifecycle/ViewModel;", "Landroid/view/View;", "invoke", "com/talabat/talabatcommon/lifecycle/AutoDisposableKt$bind$3"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemOfferMainActivity$special$$inlined$bind$1 extends Lambda implements Function1<View, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AutoDisposable f60220g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemOfferMainActivity f60221h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemOfferMainActivity$special$$inlined$bind$1(AutoDisposable autoDisposable, GemOfferMainActivity gemOfferMainActivity) {
        super(1);
        this.f60220g = autoDisposable;
        this.f60221h = gemOfferMainActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "$this$withLayout");
        final AutoDisposable autoDisposable = this.f60220g;
        if (autoDisposable instanceof View) {
            final GemOfferMainActivity gemOfferMainActivity = this.f60221h;
            AutoDisposableKt.autoDisposeView(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    GemOfferViewModel gemOfferViewModel;
                    GemOfferMainActivity$initialize$1$5 gemOfferMainActivity$initialize$1$5;
                    Context context = ((View) autoDisposable).getContext();
                    Class cls = GemOfferViewModel.class;
                    if (context instanceof AppCompatActivity) {
                        gemOfferViewModel = (GemOfferViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
                        ImageView imageView = (ImageView) gemOfferMainActivity._$_findCachedViewById(R.id.backImageView);
                        Intrinsics.checkNotNullExpressionValue(imageView, "backImageView");
                        ViewKt.invoke(imageView, new GemOfferMainActivity$initialize$1$1(gemOfferMainActivity));
                        gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$2(gemOfferViewModel, gemOfferMainActivity));
                        gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$3(gemOfferViewModel));
                        gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$4(gemOfferMainActivity, gemOfferViewModel));
                        gemOfferMainActivity$initialize$1$5 = new GemOfferMainActivity$initialize$1$5(gemOfferViewModel, gemOfferMainActivity);
                    } else if (context instanceof FragmentActivity) {
                        gemOfferViewModel = (GemOfferViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
                        ImageView imageView2 = (ImageView) gemOfferMainActivity._$_findCachedViewById(R.id.backImageView);
                        Intrinsics.checkNotNullExpressionValue(imageView2, "backImageView");
                        ViewKt.invoke(imageView2, new GemOfferMainActivity$initialize$1$1(gemOfferMainActivity));
                        gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$2(gemOfferViewModel, gemOfferMainActivity));
                        gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$3(gemOfferViewModel));
                        gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$4(gemOfferMainActivity, gemOfferViewModel));
                        gemOfferMainActivity$initialize$1$5 = new GemOfferMainActivity$initialize$1$5(gemOfferViewModel, gemOfferMainActivity);
                    } else if (context instanceof Fragment) {
                        gemOfferViewModel = (GemOfferViewModel) ViewModelProviders.of((Fragment) context).get(cls);
                        ImageView imageView3 = (ImageView) gemOfferMainActivity._$_findCachedViewById(R.id.backImageView);
                        Intrinsics.checkNotNullExpressionValue(imageView3, "backImageView");
                        ViewKt.invoke(imageView3, new GemOfferMainActivity$initialize$1$1(gemOfferMainActivity));
                        gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$2(gemOfferViewModel, gemOfferMainActivity));
                        gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$3(gemOfferViewModel));
                        gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$4(gemOfferMainActivity, gemOfferViewModel));
                        gemOfferMainActivity$initialize$1$5 = new GemOfferMainActivity$initialize$1$5(gemOfferViewModel, gemOfferMainActivity);
                    } else {
                        throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
                    }
                    gemOfferViewModel.autoDispose(gemOfferMainActivity$initialize$1$5);
                }
            });
        } else if (autoDisposable instanceof AppCompatActivity) {
            final GemOfferMainActivity gemOfferMainActivity2 = this.f60221h;
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    GemOfferViewModel gemOfferViewModel = (GemOfferViewModel) ViewModelProviders.of((FragmentActivity) autoDisposable).get(GemOfferViewModel.class);
                    ImageView imageView = (ImageView) gemOfferMainActivity2._$_findCachedViewById(R.id.backImageView);
                    Intrinsics.checkNotNullExpressionValue(imageView, "backImageView");
                    ViewKt.invoke(imageView, new GemOfferMainActivity$initialize$1$1(gemOfferMainActivity2));
                    gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$2(gemOfferViewModel, gemOfferMainActivity2));
                    gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$3(gemOfferViewModel));
                    gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$4(gemOfferMainActivity2, gemOfferViewModel));
                    gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$5(gemOfferViewModel, gemOfferMainActivity2));
                }
            });
        } else if (autoDisposable instanceof Fragment) {
            final GemOfferMainActivity gemOfferMainActivity3 = this.f60221h;
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    GemOfferViewModel gemOfferViewModel = (GemOfferViewModel) ViewModelProviders.of((Fragment) autoDisposable).get(GemOfferViewModel.class);
                    ImageView imageView = (ImageView) gemOfferMainActivity3._$_findCachedViewById(R.id.backImageView);
                    Intrinsics.checkNotNullExpressionValue(imageView, "backImageView");
                    ViewKt.invoke(imageView, new GemOfferMainActivity$initialize$1$1(gemOfferMainActivity3));
                    gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$2(gemOfferViewModel, gemOfferMainActivity3));
                    gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$3(gemOfferViewModel));
                    gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$4(gemOfferMainActivity3, gemOfferViewModel));
                    gemOfferViewModel.autoDispose(new GemOfferMainActivity$initialize$1$5(gemOfferViewModel, gemOfferMainActivity3));
                }
            });
        } else {
            ThrowablesKt.log(new UnsupportedOperationException(autoDisposable + " must be a View, AppCompatActivity, or a Fragment"));
        }
    }
}
