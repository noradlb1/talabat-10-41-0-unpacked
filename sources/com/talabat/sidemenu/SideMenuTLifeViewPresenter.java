package com.talabat.sidemenu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import buisnessmodels.Customer;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.talabatcommon.views.promotionWidget.model.PromotionsWidgetDisplayModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\n\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u0006\u0010\u0019\u001a\u00020\u0017J\u0015\u0010\u001a\u001a\n \u001b*\u0004\u0018\u00010\u00150\u0015H\u0002¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0015J\b\u0010\u001f\u001a\u00020\u0017H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/talabat/sidemenu/SideMenuTLifeViewPresenter;", "", "context", "Landroid/content/Context;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Landroid/content/Context;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getContext", "()Landroid/content/Context;", "coroutineScope", "com/talabat/sidemenu/SideMenuTLifeViewPresenter$coroutineScope$1", "Lcom/talabat/sidemenu/SideMenuTLifeViewPresenter$coroutineScope$1;", "model", "Lcom/talabat/talabatcommon/views/promotionWidget/model/PromotionsWidgetDisplayModel;", "viewHolder", "Lcom/talabat/sidemenu/SideMenuTLifeViewHolder;", "getViewHolder", "()Lcom/talabat/sidemenu/SideMenuTLifeViewHolder;", "setViewHolder", "(Lcom/talabat/sidemenu/SideMenuTLifeViewHolder;)V", "canShowTLifeWidget", "", "enableTLifeWidget", "", "isEnabled", "hideView", "isFreeCoffeeEligible", "kotlin.jvm.PlatformType", "()Ljava/lang/Boolean;", "setView", "isEnable", "updateUI", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SideMenuTLifeViewPresenter {
    @NotNull
    private final Context context;
    @NotNull
    private SideMenuTLifeViewPresenter$coroutineScope$1 coroutineScope = new SideMenuTLifeViewPresenter$coroutineScope$1();
    @Nullable
    private PromotionsWidgetDisplayModel model;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;
    @Nullable
    private SideMenuTLifeViewHolder viewHolder;

    public SideMenuTLifeViewPresenter(@NotNull Context context2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.context = context2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    private final boolean canShowTLifeWidget() {
        if (!this.talabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_TLIFE_WIDGET, false) || !Customer.getInstance().isLoggedIn()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void enableTLifeWidget(boolean z11) {
        ViewGroup.LayoutParams layoutParams;
        int i11;
        View view;
        SideMenuTLifeViewHolder sideMenuTLifeViewHolder = this.viewHolder;
        View view2 = null;
        if (sideMenuTLifeViewHolder == null || (view = sideMenuTLifeViewHolder.itemView) == null) {
            layoutParams = null;
        } else {
            layoutParams = view.getLayoutParams();
        }
        if (layoutParams != null) {
            if (z11) {
                i11 = -2;
            } else {
                i11 = 0;
            }
            layoutParams.height = i11;
        }
        SideMenuTLifeViewHolder sideMenuTLifeViewHolder2 = this.viewHolder;
        if (sideMenuTLifeViewHolder2 != null) {
            view2 = sideMenuTLifeViewHolder2.itemView;
        }
        if (view2 != null) {
            view2.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    public final Boolean isFreeCoffeeEligible() {
        return Customer.getInstance().isFreeCoffeeEligible();
    }

    private final void updateUI() {
        SideMenuTLifeViewHolder sideMenuTLifeViewHolder = this.viewHolder;
        if (sideMenuTLifeViewHolder != null) {
            sideMenuTLifeViewHolder.populate();
        }
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final SideMenuTLifeViewHolder getViewHolder() {
        return this.viewHolder;
    }

    public final void hideView() {
        SideMenuTLifeViewHolder sideMenuTLifeViewHolder = this.viewHolder;
        if (sideMenuTLifeViewHolder != null) {
            sideMenuTLifeViewHolder.hideView();
        }
    }

    public final void setView(@NotNull SideMenuTLifeViewHolder sideMenuTLifeViewHolder, boolean z11) {
        boolean z12;
        Intrinsics.checkNotNullParameter(sideMenuTLifeViewHolder, "viewHolder");
        this.viewHolder = sideMenuTLifeViewHolder;
        if (canShowTLifeWidget()) {
            if (!z11 || !canShowTLifeWidget()) {
                z12 = false;
            } else {
                z12 = true;
            }
            enableTLifeWidget(z12);
            updateUI();
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SideMenuTLifeViewPresenter$setView$1(this, z11, sideMenuTLifeViewHolder, (Continuation<? super SideMenuTLifeViewPresenter$setView$1>) null), 3, (Object) null);
    }

    public final void setViewHolder(@Nullable SideMenuTLifeViewHolder sideMenuTLifeViewHolder) {
        this.viewHolder = sideMenuTLifeViewHolder;
    }
}
