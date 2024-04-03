package com.talabat.feature.tmart.growth.presentation.sheet;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.compose.DialogNavigator;
import androidx.transition.TransitionManager;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.tmart.growth.domain.TMartGrowthFeatureApi;
import com.talabat.feature.tmart.growth.presentation.di.DaggerTMartGrowthViewComponent;
import com.talabat.feature.tmart.growth.presentation.sheet.BottomSheetAction;
import com.talabat.feature.tmart.growth.presentation.sheet.BottomSheetState;
import com.talabat.presentation.tmart.growth.databinding.TmartGrowthBottomSheetBinding;
import com.talabat.talabatcommon.R;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mo.a;
import mo.b;
import mo.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001FB*\u0012!\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00030*¢\u0006\u0004\bD\u0010EJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\tH\u0002J\u001d\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H\u0016J\u0017\u0010)\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b'\u0010(R2\u0010.\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u00030*8\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0000@\u0000X.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001b\u0010>\u001a\u0002098BX\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0002¢\u0006\f\n\u0004\b@\u0010;\u001a\u0004\bA\u0010B\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/TMartGrowthBottomSheet;", "Lcom/talabat/feature/tmart/growth/presentation/sheet/TMartGrowthBaseBottomSheet;", "Lcom/talabat/presentation/tmart/growth/databinding/TmartGrowthBottomSheetBinding;", "", "setupListeners", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState;", "state", "handleState", "handleVisibility", "Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState$OpenTMart;", "openTMart", "Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "filePath", "showAnimation-yxrKQzk", "(Ljava/lang/String;)V", "showAnimation", "", "title", "subtitle", "logoUrl", "showInfo", "iconUrl", "showSuccess", "initDagger", "Landroid/view/LayoutInflater;", "inflater", "d", "Landroid/content/Context;", "context", "onAttach", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroid/view/View;", "view", "onViewCreated", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "setState$com_talabat_feature_tmartGrowth_presentation_presentation", "(Lcom/talabat/feature/tmart/growth/presentation/sheet/BottomSheetState;)V", "setState", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "deeplink", "openTMartListener", "Lkotlin/jvm/functions/Function1;", "getOpenTMartListener", "()Lkotlin/jvm/functions/Function1;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory$com_talabat_feature_tmartGrowth_presentation_presentation", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory$com_talabat_feature_tmartGrowth_presentation_presentation", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "Lcom/talabat/feature/tmart/growth/presentation/sheet/TMartGrowthBottomSheetViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/talabat/feature/tmart/growth/presentation/sheet/TMartGrowthBottomSheetViewModel;", "viewModel", "Lcom/bumptech/glide/RequestManager;", "glide$delegate", "getGlide", "()Lcom/bumptech/glide/RequestManager;", "glide", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Companion", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0})
public final class TMartGrowthBottomSheet extends TMartGrowthBaseBottomSheet<TmartGrowthBottomSheetBinding> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAG = "TMartGrowthBottomSheet";
    @NotNull
    private final Lazy glide$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new TMartGrowthBottomSheet$glide$2(this));
    @NotNull
    private final Function1<String, Unit> openTMartListener;
    @NotNull
    private final Lazy viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(TMartGrowthBottomSheetViewModel.class), new TMartGrowthBottomSheet$special$$inlined$viewModels$default$2(new TMartGrowthBottomSheet$special$$inlined$viewModels$default$1(this)), new TMartGrowthBottomSheet$viewModel$2(this));
    @Inject
    public ViewModelProvider.Factory viewModelFactory;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/tmart/growth/presentation/sheet/TMartGrowthBottomSheet$Companion;", "", "()V", "TAG", "", "show", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "openTMartListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "deeplink", "com_talabat_feature_tmartGrowth_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void show(@NotNull FragmentManager fragmentManager, @NotNull Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(function1, "openTMartListener");
            new TMartGrowthBottomSheet(function1).show(fragmentManager, TMartGrowthBottomSheet.TAG);
        }
    }

    public TMartGrowthBottomSheet(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "openTMartListener");
        this.openTMartListener = function1;
    }

    private final RequestManager getGlide() {
        return (RequestManager) this.glide$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TMartGrowthBottomSheetViewModel getViewModel() {
        return (TMartGrowthBottomSheetViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void handleState(BottomSheetState bottomSheetState) {
        TransitionManager.beginDelayedTransition(((TmartGrowthBottomSheetBinding) getBinding()).getRoot());
        handleVisibility(bottomSheetState);
        if (bottomSheetState instanceof BottomSheetState.OpenTMart) {
            openTMart((BottomSheetState.OpenTMart) bottomSheetState);
        } else if (bottomSheetState instanceof BottomSheetState.ShowImage) {
            m10345showAnimationyxrKQzk(((BottomSheetState.ShowImage) bottomSheetState).m10341getFilePathUYv4Z4());
        } else if (bottomSheetState instanceof BottomSheetState.ShowInfo) {
            BottomSheetState.ShowInfo showInfo = (BottomSheetState.ShowInfo) bottomSheetState;
            showInfo(showInfo.getTitle(), showInfo.getSubtitle(), showInfo.getLogoUrl());
        } else if (bottomSheetState instanceof BottomSheetState.ShowSuccess) {
            BottomSheetState.ShowSuccess showSuccess = (BottomSheetState.ShowSuccess) bottomSheetState;
            showSuccess(showSuccess.getTitle(), showSuccess.getSubtitle(), showSuccess.getImageUrl());
        } else if (Intrinsics.areEqual((Object) bottomSheetState, (Object) BottomSheetState.Dismiss.INSTANCE)) {
            dismiss();
        } else {
            Intrinsics.areEqual((Object) bottomSheetState, (Object) BottomSheetState.Loading.INSTANCE);
        }
    }

    private final void handleVisibility(BottomSheetState bottomSheetState) {
        int i11;
        int i12;
        int i13;
        TmartGrowthBottomSheetBinding tmartGrowthBottomSheetBinding = (TmartGrowthBottomSheetBinding) getBinding();
        ProgressBar progressBar = tmartGrowthBottomSheetBinding.progress;
        Intrinsics.checkNotNullExpressionValue(progressBar, "progress");
        int i14 = 0;
        if (Intrinsics.areEqual((Object) bottomSheetState, (Object) BottomSheetState.Loading.INSTANCE)) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        progressBar.setVisibility(i11);
        ImageView imageView = tmartGrowthBottomSheetBinding.bigImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "bigImage");
        if (bottomSheetState instanceof BottomSheetState.ShowImage) {
            i12 = 0;
        } else {
            i12 = 8;
        }
        imageView.setVisibility(i12);
        Group group = tmartGrowthBottomSheetBinding.infoGroup;
        Intrinsics.checkNotNullExpressionValue(group, "infoGroup");
        if (bottomSheetState instanceof BottomSheetState.ShowInfo) {
            i13 = 0;
        } else {
            i13 = 8;
        }
        group.setVisibility(i13);
        Group group2 = tmartGrowthBottomSheetBinding.successGroup;
        Intrinsics.checkNotNullExpressionValue(group2, "successGroup");
        if (!(bottomSheetState instanceof BottomSheetState.ShowSuccess)) {
            i14 = 8;
        }
        group2.setVisibility(i14);
    }

    private final void initDagger() {
        DaggerTMartGrowthViewComponent.factory().create((TMartGrowthFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(TMartGrowthFeatureApi.class)).inject(this);
    }

    private final void openTMart(BottomSheetState.OpenTMart openTMart) {
        this.openTMartListener.invoke(openTMart.getDeeplink());
        dismiss();
    }

    private final void setupListeners() {
        TmartGrowthBottomSheetBinding tmartGrowthBottomSheetBinding = (TmartGrowthBottomSheetBinding) getBinding();
        tmartGrowthBottomSheetBinding.dismissButton.setOnClickListener(new a(this));
        tmartGrowthBottomSheetBinding.secondaryButton.setOnClickListener(new b(this));
        tmartGrowthBottomSheetBinding.primaryButton.setOnClickListener(new c(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupListeners$lambda-3$lambda-0  reason: not valid java name */
    public static final void m10342setupListeners$lambda3$lambda0(TMartGrowthBottomSheet tMartGrowthBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(tMartGrowthBottomSheet, "this$0");
        tMartGrowthBottomSheet.getViewModel().performAction(BottomSheetAction.Dismiss.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupListeners$lambda-3$lambda-1  reason: not valid java name */
    public static final void m10343setupListeners$lambda3$lambda1(TMartGrowthBottomSheet tMartGrowthBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(tMartGrowthBottomSheet, "this$0");
        tMartGrowthBottomSheet.getViewModel().performAction(BottomSheetAction.Save.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupListeners$lambda-3$lambda-2  reason: not valid java name */
    public static final void m10344setupListeners$lambda3$lambda2(TMartGrowthBottomSheet tMartGrowthBottomSheet, View view) {
        Intrinsics.checkNotNullParameter(tMartGrowthBottomSheet, "this$0");
        tMartGrowthBottomSheet.getViewModel().performAction(BottomSheetAction.OpenTMart.INSTANCE);
    }

    /* renamed from: showAnimation-yxrKQzk  reason: not valid java name */
    private final void m10345showAnimationyxrKQzk(String str) {
        ((RequestBuilder) getGlide().load(str).skipMemoryCache(true)).addListener(new TMartGrowthGifLoadListener(new TMartGrowthBottomSheet$showAnimation$1(getViewModel()))).into(((TmartGrowthBottomSheetBinding) getBinding()).bigImage);
    }

    private final void showInfo(String str, String str2, String str3) {
        ((RequestBuilder) getGlide().load(str3).fitCenter()).into(((TmartGrowthBottomSheetBinding) getBinding()).logo);
        ((TmartGrowthBottomSheetBinding) getBinding()).title.setText(str);
        ((TmartGrowthBottomSheetBinding) getBinding()).subtitle.setText(str2);
    }

    private final void showSuccess(String str, String str2, String str3) {
        ((RequestBuilder) getGlide().load(str3).fitCenter()).into(((TmartGrowthBottomSheetBinding) getBinding()).successIcon);
        ((TmartGrowthBottomSheetBinding) getBinding()).successTitle.setText(str);
        ((TmartGrowthBottomSheetBinding) getBinding()).successSubtitle.setText(str2);
    }

    @NotNull
    /* renamed from: d */
    public TmartGrowthBottomSheetBinding bindingFactory(@NotNull LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        TmartGrowthBottomSheetBinding inflate = TmartGrowthBottomSheetBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    @NotNull
    public final Function1<String, Unit> getOpenTMartListener() {
        return this.openTMartListener;
    }

    @NotNull
    public final ViewModelProvider.Factory getViewModelFactory$com_talabat_feature_tmartGrowth_presentation_presentation() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        initDagger();
        super.onAttach(context);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.AppBottomSheetDialogTheme);
    }

    public void onDismiss(@NotNull DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, DialogNavigator.NAME);
        getViewModel().onDismiss();
        super.onDismiss(dialogInterface);
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupListeners();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner).launchWhenStarted(new TMartGrowthBottomSheet$onViewCreated$1(this, (Continuation<? super TMartGrowthBottomSheet$onViewCreated$1>) null));
    }

    public final void setState$com_talabat_feature_tmartGrowth_presentation_presentation(@NotNull BottomSheetState bottomSheetState) {
        Intrinsics.checkNotNullParameter(bottomSheetState, "state");
        handleState(bottomSheetState);
    }

    public final void setViewModelFactory$com_talabat_feature_tmartGrowth_presentation_presentation(@NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}
