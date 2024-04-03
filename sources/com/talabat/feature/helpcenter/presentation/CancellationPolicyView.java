package com.talabat.feature.helpcenter.presentation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.designsystem.ds_alert.DSAlert;
import com.designsystem.ds_alert.DSAlertActionButtonModel;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.helpcenter.R;
import com.talabat.feature.helpcenter.databinding.LayoutCancellationPolicyViewBinding;
import com.talabat.feature.helpcenter.presentation.di.DaggerCancellationPolicyViewComponent;
import java.util.ArrayList;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xm.b;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/talabat/feature/helpcenter/databinding/LayoutCancellationPolicyViewBinding;", "bottomSheetTile", "", "cancellationPolicyList", "Ljava/util/ArrayList;", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyItemDisplayModel;", "Lkotlin/collections/ArrayList;", "cancellationPolicyViewModel", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyViewModel;", "cancellationPolicyViewModelFactory", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyViewModelFactory;", "getCancellationPolicyViewModelFactory", "()Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyViewModelFactory;", "setCancellationPolicyViewModelFactory", "(Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyViewModelFactory;)V", "getLifeCycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "init", "", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyView extends FrameLayout {
    @NotNull
    private final LayoutCancellationPolicyViewBinding binding;
    /* access modifiers changed from: private */
    @NotNull
    public String bottomSheetTile;
    /* access modifiers changed from: private */
    @NotNull
    public final ArrayList<CancellationPolicyItemDisplayModel> cancellationPolicyList;
    /* access modifiers changed from: private */
    @NotNull
    public CancellationPolicyViewModel cancellationPolicyViewModel;
    @Inject
    public CancellationPolicyViewModelFactory cancellationPolicyViewModelFactory;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CancellationPolicyView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CancellationPolicyView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CancellationPolicyView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final LifecycleOwner getLifeCycleOwner() {
        LifecycleOwner lifecycleOwner;
        ContextThemeWrapper contextThemeWrapper;
        Context context;
        Context context2 = getContext();
        if (context2 instanceof LifecycleOwner) {
            lifecycleOwner = (LifecycleOwner) context2;
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        Context context3 = getContext();
        if (context3 instanceof ContextThemeWrapper) {
            contextThemeWrapper = (ContextThemeWrapper) context3;
        } else {
            contextThemeWrapper = null;
        }
        if (contextThemeWrapper != null) {
            context = contextThemeWrapper.getBaseContext();
        } else {
            context = null;
        }
        if (context instanceof LifecycleOwner) {
            return (LifecycleOwner) context;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-3$lambda-2$lambda-1  reason: not valid java name */
    public static final void m10219init$lambda3$lambda2$lambda1(CancellationPolicyView cancellationPolicyView, CancellationPolicyDisplayModel cancellationPolicyDisplayModel) {
        Intrinsics.checkNotNullParameter(cancellationPolicyView, "this$0");
        if (cancellationPolicyDisplayModel == null || !cancellationPolicyDisplayModel.isEnabled()) {
            cancellationPolicyView.binding.dsAlertCancellationPolicyNote.setVisibility(8);
            return;
        }
        cancellationPolicyView.bottomSheetTile = cancellationPolicyDisplayModel.getTitle();
        cancellationPolicyView.cancellationPolicyList.addAll(cancellationPolicyDisplayModel.getCancellationPolicyList());
        cancellationPolicyView.binding.dsAlertCancellationPolicyNote.setVisibility(0);
        cancellationPolicyView.cancellationPolicyViewModel.cancellationPolicyShown();
    }

    @NotNull
    public final CancellationPolicyViewModelFactory getCancellationPolicyViewModelFactory() {
        CancellationPolicyViewModelFactory cancellationPolicyViewModelFactory2 = this.cancellationPolicyViewModelFactory;
        if (cancellationPolicyViewModelFactory2 != null) {
            return cancellationPolicyViewModelFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cancellationPolicyViewModelFactory");
        return null;
    }

    public final void init() {
        CancellationPolicyViewModel cancellationPolicyViewModel2 = this.cancellationPolicyViewModel;
        this.cancellationPolicyList.clear();
        cancellationPolicyViewModel2.checkIfCancellationPolicyIsEnabled();
        LifecycleOwner lifeCycleOwner = getLifeCycleOwner();
        if (lifeCycleOwner != null) {
            cancellationPolicyViewModel2.getCancellationPolicyContent().observe(lifeCycleOwner, new b(this));
        }
    }

    public final void setCancellationPolicyViewModelFactory(@NotNull CancellationPolicyViewModelFactory cancellationPolicyViewModelFactory2) {
        Intrinsics.checkNotNullParameter(cancellationPolicyViewModelFactory2, "<set-?>");
        this.cancellationPolicyViewModelFactory = cancellationPolicyViewModelFactory2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CancellationPolicyView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.cancellationPolicyList = new ArrayList<>();
        this.bottomSheetTile = "";
        DaggerCancellationPolicyViewComponent.factory().create((HelpCenterFeatureApi) AndroidComponentsKt.apiContainer((View) this).getFeature(HelpCenterFeatureApi.class)).inject(this);
        this.cancellationPolicyViewModel = (CancellationPolicyViewModel) getCancellationPolicyViewModelFactory().create(CancellationPolicyViewModel.class);
        LayoutCancellationPolicyViewBinding inflate = LayoutCancellationPolicyViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…xt), this, true\n        )");
        this.binding = inflate;
        DSAlert dSAlert = inflate.dsAlertCancellationPolicyNote;
        dSAlert.setDescriptor(context.getString(R.string.cancellation_policy_view_desc));
        String string = context.getString(R.string.cancellation_policy_view_action_text);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…_policy_view_action_text)");
        dSAlert.setActionButton(new DSAlertActionButtonModel(string, new CancellationPolicyView$1$1(this, context)));
    }
}
