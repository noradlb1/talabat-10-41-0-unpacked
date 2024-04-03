package com.talabat.darkstores.feature.product.views;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
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
public final class CampaignProgressView$special$$inlined$bind$2 extends Lambda implements Function1<AppCompatActivity, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AutoDisposable f56548g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CampaignProgressView f56549h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CampaignProgressView$special$$inlined$bind$2(AutoDisposable autoDisposable, CampaignProgressView campaignProgressView) {
        super(1);
        this.f56548g = autoDisposable;
        this.f56549h = campaignProgressView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppCompatActivity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$withLayout");
        final AutoDisposable autoDisposable = this.f56548g;
        if (autoDisposable instanceof View) {
            final CampaignProgressView campaignProgressView = this.f56549h;
            AutoDisposableKt.autoDisposeView(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    CampaignProgressView campaignProgressView;
                    CampaignProgressView$1$3 campaignProgressView$1$3;
                    Context context = ((View) autoDisposable).getContext();
                    Class cls = CampaignProgressViewModel.class;
                    if (context instanceof AppCompatActivity) {
                        CampaignProgressViewModel campaignProgressViewModel = (CampaignProgressViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
                        campaignProgressView.setOrientation(1);
                        CampaignProgressView campaignProgressView2 = campaignProgressView;
                        campaignProgressView2.autoDispose(new CampaignProgressView$1$1(campaignProgressViewModel, campaignProgressView2));
                        CampaignProgressView campaignProgressView3 = campaignProgressView;
                        campaignProgressView3.autoDispose(new CampaignProgressView$1$2(campaignProgressView3, campaignProgressViewModel));
                        campaignProgressView = campaignProgressView;
                        campaignProgressView$1$3 = new CampaignProgressView$1$3(campaignProgressView, campaignProgressViewModel);
                    } else if (context instanceof FragmentActivity) {
                        CampaignProgressViewModel campaignProgressViewModel2 = (CampaignProgressViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
                        campaignProgressView.setOrientation(1);
                        CampaignProgressView campaignProgressView4 = campaignProgressView;
                        campaignProgressView4.autoDispose(new CampaignProgressView$1$1(campaignProgressViewModel2, campaignProgressView4));
                        CampaignProgressView campaignProgressView5 = campaignProgressView;
                        campaignProgressView5.autoDispose(new CampaignProgressView$1$2(campaignProgressView5, campaignProgressViewModel2));
                        campaignProgressView = campaignProgressView;
                        campaignProgressView$1$3 = new CampaignProgressView$1$3(campaignProgressView, campaignProgressViewModel2);
                    } else if (context instanceof Fragment) {
                        CampaignProgressViewModel campaignProgressViewModel3 = (CampaignProgressViewModel) ViewModelProviders.of((Fragment) context).get(cls);
                        campaignProgressView.setOrientation(1);
                        CampaignProgressView campaignProgressView6 = campaignProgressView;
                        campaignProgressView6.autoDispose(new CampaignProgressView$1$1(campaignProgressViewModel3, campaignProgressView6));
                        CampaignProgressView campaignProgressView7 = campaignProgressView;
                        campaignProgressView7.autoDispose(new CampaignProgressView$1$2(campaignProgressView7, campaignProgressViewModel3));
                        campaignProgressView = campaignProgressView;
                        campaignProgressView$1$3 = new CampaignProgressView$1$3(campaignProgressView, campaignProgressViewModel3);
                    } else {
                        throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
                    }
                    campaignProgressView.autoDispose(campaignProgressView$1$3);
                }
            });
        } else if (autoDisposable instanceof AppCompatActivity) {
            final CampaignProgressView campaignProgressView2 = this.f56549h;
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    CampaignProgressViewModel campaignProgressViewModel = (CampaignProgressViewModel) ViewModelProviders.of((FragmentActivity) autoDisposable).get(CampaignProgressViewModel.class);
                    campaignProgressView2.setOrientation(1);
                    CampaignProgressView campaignProgressView = campaignProgressView2;
                    campaignProgressView.autoDispose(new CampaignProgressView$1$1(campaignProgressViewModel, campaignProgressView));
                    CampaignProgressView campaignProgressView2 = campaignProgressView2;
                    campaignProgressView2.autoDispose(new CampaignProgressView$1$2(campaignProgressView2, campaignProgressViewModel));
                    CampaignProgressView campaignProgressView3 = campaignProgressView2;
                    campaignProgressView3.autoDispose(new CampaignProgressView$1$3(campaignProgressView3, campaignProgressViewModel));
                }
            });
        } else if (autoDisposable instanceof Fragment) {
            final CampaignProgressView campaignProgressView3 = this.f56549h;
            AutoDisposableKt.autoDisposeOwner(autoDisposable, new Function0<Unit>() {
                public final void invoke() {
                    CampaignProgressViewModel campaignProgressViewModel = (CampaignProgressViewModel) ViewModelProviders.of((Fragment) autoDisposable).get(CampaignProgressViewModel.class);
                    campaignProgressView3.setOrientation(1);
                    CampaignProgressView campaignProgressView = campaignProgressView3;
                    campaignProgressView.autoDispose(new CampaignProgressView$1$1(campaignProgressViewModel, campaignProgressView));
                    CampaignProgressView campaignProgressView2 = campaignProgressView3;
                    campaignProgressView2.autoDispose(new CampaignProgressView$1$2(campaignProgressView2, campaignProgressViewModel));
                    CampaignProgressView campaignProgressView3 = campaignProgressView3;
                    campaignProgressView3.autoDispose(new CampaignProgressView$1$3(campaignProgressView3, campaignProgressViewModel));
                }
            });
        } else {
            ThrowablesKt.log(new UnsupportedOperationException(autoDisposable + " must be a View, AppCompatActivity, or a Fragment"));
        }
    }
}
