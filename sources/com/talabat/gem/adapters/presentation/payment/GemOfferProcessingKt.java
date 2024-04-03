package com.talabat.gem.adapters.presentation.payment;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.talabat.gem.adapters.presentation.GemOfferProcessingConfigurations;
import com.talabat.gem.adapters.presentation.GemViewsDsl;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.subjects.ReplaySubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a&\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0004¨\u0006\t"}, d2 = {"onInitialize", "", "Lcom/talabat/gem/adapters/presentation/payment/GemOfferProcessingViewModel;", "withGemOfferProcessing", "Landroid/view/View;", "configurationInitializer", "Lkotlin/Function1;", "Lcom/talabat/gem/adapters/presentation/GemOfferProcessingConfigurations;", "Lkotlin/ExtensionFunctionType;", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemOfferProcessingKt {
    public static final void onInitialize(@NotNull GemOfferProcessingViewModel gemOfferProcessingViewModel) {
        Intrinsics.checkNotNullParameter(gemOfferProcessingViewModel, "<this>");
        gemOfferProcessingViewModel.autoDispose(new GemOfferProcessingKt$onInitialize$1(gemOfferProcessingViewModel));
        gemOfferProcessingViewModel.autoDispose(new GemOfferProcessingKt$onInitialize$2(gemOfferProcessingViewModel));
        gemOfferProcessingViewModel.autoDispose(new GemOfferProcessingKt$onInitialize$3(gemOfferProcessingViewModel));
        gemOfferProcessingViewModel.autoDispose(new GemOfferProcessingKt$onInitialize$4(gemOfferProcessingViewModel));
    }

    @GemViewsDsl
    public static final void withGemOfferProcessing(@NotNull View view, @NotNull Function1<? super GemOfferProcessingConfigurations, Unit> function1) {
        GemOfferProcessingKt$withGemOfferProcessing$1$1 gemOfferProcessingKt$withGemOfferProcessing$1$1;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, "configurationInitializer");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Class cls = GemOfferProcessingViewModel.class;
        if (context instanceof AppCompatActivity) {
            GemOfferProcessingViewModel gemOfferProcessingViewModel = (GemOfferProcessingViewModel) ViewModelProviders.of((FragmentActivity) context).get(cls);
            ReplaySubject<GemOfferProcessingConfigurations> configurations$com_talabat_Components_gem_gem = gemOfferProcessingViewModel.getConfigurations$com_talabat_Components_gem_gem();
            GemOfferProcessingConfigurations gemOfferProcessingConfigurations = new GemOfferProcessingConfigurations();
            function1.invoke(gemOfferProcessingConfigurations);
            RxKt.plusAssign(configurations$com_talabat_Components_gem_gem, gemOfferProcessingConfigurations);
            gemOfferProcessingKt$withGemOfferProcessing$1$1 = new GemOfferProcessingKt$withGemOfferProcessing$1$1(gemOfferProcessingViewModel);
        } else if (context instanceof Fragment) {
            GemOfferProcessingViewModel gemOfferProcessingViewModel2 = (GemOfferProcessingViewModel) ViewModelProviders.of((Fragment) context).get(cls);
            ReplaySubject<GemOfferProcessingConfigurations> configurations$com_talabat_Components_gem_gem2 = gemOfferProcessingViewModel2.getConfigurations$com_talabat_Components_gem_gem();
            GemOfferProcessingConfigurations gemOfferProcessingConfigurations2 = new GemOfferProcessingConfigurations();
            function1.invoke(gemOfferProcessingConfigurations2);
            RxKt.plusAssign(configurations$com_talabat_Components_gem_gem2, gemOfferProcessingConfigurations2);
            gemOfferProcessingKt$withGemOfferProcessing$1$1 = new GemOfferProcessingKt$withGemOfferProcessing$1$1(gemOfferProcessingViewModel2);
        } else {
            throw new UnsupportedOperationException("ViewModelProviders works with Activities and Fragment hosts only");
        }
        view.setOnClickListener(gemOfferProcessingKt$withGemOfferProcessing$1$1);
    }
}
