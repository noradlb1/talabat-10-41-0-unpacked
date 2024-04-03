package com.talabat.gem.adapters.presentation.restaurants;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.ImageViewsKt;
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
public final class GemFloatingView$initialize$1$invoke$$inlined$bind$2 extends Lambda implements Function1<AppCompatActivity, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AutoDisposable f60276g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemFloatingView f60277h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Context f60278i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemFloatingView$initialize$1$invoke$$inlined$bind$2(AutoDisposable autoDisposable, GemFloatingView gemFloatingView, Context context) {
        super(1);
        this.f60276g = autoDisposable;
        this.f60277h = gemFloatingView;
        this.f60278i = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppCompatActivity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$withLayout");
        final AutoDisposable autoDisposable = this.f60276g;
        if (autoDisposable instanceof View) {
            final GemFloatingView gemFloatingView = this.f60277h;
            final Context context = this.f60278i;
            AutoDisposableKt.autoDisposeView(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    Context context = ((View) autoDisposable).getContext();
                    Class cls = GemFloatingViewModel.class;
                    if (context instanceof AppCompatActivity) {
                        GemFloatingViewModel gemFloatingViewModel = (GemFloatingViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
                        gemFloatingView.registerOnMenuBackClicked(gemFloatingViewModel, context);
                        ImageView imageView = (ImageView) gemFloatingView._$_findCachedViewById(R.id.gemFloatingLogoImageView);
                        Intrinsics.checkNotNullExpressionValue(imageView, "gemFloatingLogoImageView");
                        ImageViewsKt.loadResource(imageView, R.raw.gem_gif_logo);
                        gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$1(gemFloatingViewModel));
                        gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$2(gemFloatingViewModel, gemFloatingView));
                        gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$3(gemFloatingViewModel, gemFloatingView));
                        gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$4(gemFloatingViewModel, gemFloatingView));
                        gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$5(gemFloatingViewModel, gemFloatingView));
                        CardView cardView = (CardView) gemFloatingView._$_findCachedViewById(R.id.gemFloatingLayout);
                        Intrinsics.checkNotNullExpressionValue(cardView, "gemFloatingLayout");
                        ViewKt.invoke(cardView, new GemFloatingView$initialize$1$1$6(gemFloatingView));
                        gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$7(gemFloatingView, gemFloatingViewModel));
                    } else if (context instanceof FragmentActivity) {
                        GemFloatingViewModel gemFloatingViewModel2 = (GemFloatingViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
                        gemFloatingView.registerOnMenuBackClicked(gemFloatingViewModel2, context);
                        ImageView imageView2 = (ImageView) gemFloatingView._$_findCachedViewById(R.id.gemFloatingLogoImageView);
                        Intrinsics.checkNotNullExpressionValue(imageView2, "gemFloatingLogoImageView");
                        ImageViewsKt.loadResource(imageView2, R.raw.gem_gif_logo);
                        gemFloatingViewModel2.autoDispose(new GemFloatingView$initialize$1$1$1(gemFloatingViewModel2));
                        gemFloatingViewModel2.autoDispose(new GemFloatingView$initialize$1$1$2(gemFloatingViewModel2, gemFloatingView));
                        gemFloatingViewModel2.autoDispose(new GemFloatingView$initialize$1$1$3(gemFloatingViewModel2, gemFloatingView));
                        gemFloatingViewModel2.autoDispose(new GemFloatingView$initialize$1$1$4(gemFloatingViewModel2, gemFloatingView));
                        gemFloatingViewModel2.autoDispose(new GemFloatingView$initialize$1$1$5(gemFloatingViewModel2, gemFloatingView));
                        CardView cardView2 = (CardView) gemFloatingView._$_findCachedViewById(R.id.gemFloatingLayout);
                        Intrinsics.checkNotNullExpressionValue(cardView2, "gemFloatingLayout");
                        ViewKt.invoke(cardView2, new GemFloatingView$initialize$1$1$6(gemFloatingView));
                        gemFloatingViewModel2.autoDispose(new GemFloatingView$initialize$1$1$7(gemFloatingView, gemFloatingViewModel2));
                    } else if (context instanceof Fragment) {
                        GemFloatingViewModel gemFloatingViewModel3 = (GemFloatingViewModel) ViewModelProviders.of((Fragment) context).get(cls);
                        gemFloatingView.registerOnMenuBackClicked(gemFloatingViewModel3, context);
                        ImageView imageView3 = (ImageView) gemFloatingView._$_findCachedViewById(R.id.gemFloatingLogoImageView);
                        Intrinsics.checkNotNullExpressionValue(imageView3, "gemFloatingLogoImageView");
                        ImageViewsKt.loadResource(imageView3, R.raw.gem_gif_logo);
                        gemFloatingViewModel3.autoDispose(new GemFloatingView$initialize$1$1$1(gemFloatingViewModel3));
                        gemFloatingViewModel3.autoDispose(new GemFloatingView$initialize$1$1$2(gemFloatingViewModel3, gemFloatingView));
                        gemFloatingViewModel3.autoDispose(new GemFloatingView$initialize$1$1$3(gemFloatingViewModel3, gemFloatingView));
                        gemFloatingViewModel3.autoDispose(new GemFloatingView$initialize$1$1$4(gemFloatingViewModel3, gemFloatingView));
                        gemFloatingViewModel3.autoDispose(new GemFloatingView$initialize$1$1$5(gemFloatingViewModel3, gemFloatingView));
                        CardView cardView3 = (CardView) gemFloatingView._$_findCachedViewById(R.id.gemFloatingLayout);
                        Intrinsics.checkNotNullExpressionValue(cardView3, "gemFloatingLayout");
                        ViewKt.invoke(cardView3, new GemFloatingView$initialize$1$1$6(gemFloatingView));
                        gemFloatingViewModel3.autoDispose(new GemFloatingView$initialize$1$1$7(gemFloatingView, gemFloatingViewModel3));
                    } else {
                        throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
                    }
                }
            });
        } else if (autoDisposable instanceof AppCompatActivity) {
            final GemFloatingView gemFloatingView2 = this.f60277h;
            final Context context2 = this.f60278i;
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    GemFloatingViewModel gemFloatingViewModel = (GemFloatingViewModel) ViewModelProviders.of((FragmentActivity) autoDisposable).get(GemFloatingViewModel.class);
                    gemFloatingView2.registerOnMenuBackClicked(gemFloatingViewModel, context2);
                    ImageView imageView = (ImageView) gemFloatingView2._$_findCachedViewById(R.id.gemFloatingLogoImageView);
                    Intrinsics.checkNotNullExpressionValue(imageView, "gemFloatingLogoImageView");
                    ImageViewsKt.loadResource(imageView, R.raw.gem_gif_logo);
                    gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$1(gemFloatingViewModel));
                    gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$2(gemFloatingViewModel, gemFloatingView2));
                    gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$3(gemFloatingViewModel, gemFloatingView2));
                    gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$4(gemFloatingViewModel, gemFloatingView2));
                    gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$5(gemFloatingViewModel, gemFloatingView2));
                    CardView cardView = (CardView) gemFloatingView2._$_findCachedViewById(R.id.gemFloatingLayout);
                    Intrinsics.checkNotNullExpressionValue(cardView, "gemFloatingLayout");
                    ViewKt.invoke(cardView, new GemFloatingView$initialize$1$1$6(gemFloatingView2));
                    gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$7(gemFloatingView2, gemFloatingViewModel));
                }
            });
        } else if (autoDisposable instanceof Fragment) {
            final GemFloatingView gemFloatingView3 = this.f60277h;
            final Context context3 = this.f60278i;
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    GemFloatingViewModel gemFloatingViewModel = (GemFloatingViewModel) ViewModelProviders.of((Fragment) autoDisposable).get(GemFloatingViewModel.class);
                    gemFloatingView3.registerOnMenuBackClicked(gemFloatingViewModel, context3);
                    ImageView imageView = (ImageView) gemFloatingView3._$_findCachedViewById(R.id.gemFloatingLogoImageView);
                    Intrinsics.checkNotNullExpressionValue(imageView, "gemFloatingLogoImageView");
                    ImageViewsKt.loadResource(imageView, R.raw.gem_gif_logo);
                    gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$1(gemFloatingViewModel));
                    gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$2(gemFloatingViewModel, gemFloatingView3));
                    gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$3(gemFloatingViewModel, gemFloatingView3));
                    gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$4(gemFloatingViewModel, gemFloatingView3));
                    gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$5(gemFloatingViewModel, gemFloatingView3));
                    CardView cardView = (CardView) gemFloatingView3._$_findCachedViewById(R.id.gemFloatingLayout);
                    Intrinsics.checkNotNullExpressionValue(cardView, "gemFloatingLayout");
                    ViewKt.invoke(cardView, new GemFloatingView$initialize$1$1$6(gemFloatingView3));
                    gemFloatingViewModel.autoDispose(new GemFloatingView$initialize$1$1$7(gemFloatingView3, gemFloatingViewModel));
                }
            });
        } else {
            ThrowablesKt.log(new UnsupportedOperationException(autoDisposable + " must be a View, AppCompatActivity, or a Fragment"));
        }
    }
}
