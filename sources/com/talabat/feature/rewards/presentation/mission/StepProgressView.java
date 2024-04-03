package com.talabat.feature.rewards.presentation.mission;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.core.view.OneShotPreDrawListener;
import com.designsystem.marshmallow.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u0012\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u0007H\u0002J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0014J\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/StepProgressView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "completedStepColor", "completedSteps", "isInitialized", "", "stepHeight", "stepMargin", "totalSteps", "uncompletedStepColor", "addStepView", "", "isFirstStep", "stepViewWidth", "color", "makeStepView", "width", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setProgress", "Companion", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StepProgressView extends LinearLayout {
    public static final int $stable = 8;
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final float STEP_HEIGHT_DP = 3.0f;
    private final int completedStepColor;
    private int completedSteps;
    private boolean isInitialized;
    private final int stepHeight;
    private final int stepMargin;
    private int totalSteps;
    private final int uncompletedStepColor;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/rewards/presentation/mission/StepProgressView$Companion;", "", "()V", "STEP_HEIGHT_DP", "", "com_talabat_feature_rewards_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StepProgressView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StepProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StepProgressView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public static /* synthetic */ void a(StepProgressView stepProgressView, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = stepProgressView.getWidth();
        }
        stepProgressView.makeStepView(i11);
    }

    private final void addStepView(boolean z11, int i11, int i12) {
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i11, this.stepHeight);
        if (!z11) {
            layoutParams.setMarginStart(this.stepMargin);
        }
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(i12);
        addView(view);
    }

    /* access modifiers changed from: private */
    public final void makeStepView(int i11) {
        boolean z11;
        removeAllViewsInLayout();
        int i12 = this.totalSteps;
        if (i12 != 0) {
            int i13 = (i11 - (this.stepMargin * (i12 - 1))) / i12;
            int i14 = this.completedSteps;
            int i15 = i12 - i14;
            List[] listArr = new List[2];
            ArrayList arrayList = new ArrayList(i14);
            for (int i16 = 0; i16 < i14; i16++) {
                arrayList.add(Integer.valueOf(this.completedStepColor));
            }
            listArr[0] = arrayList;
            ArrayList arrayList2 = new ArrayList(i15);
            for (int i17 = 0; i17 < i15; i17++) {
                arrayList2.add(Integer.valueOf(this.uncompletedStepColor));
            }
            listArr[1] = arrayList2;
            int i18 = 0;
            for (Object next : CollectionsKt__IterablesKt.flatten(CollectionsKt__CollectionsKt.listOf(listArr))) {
                int i19 = i18 + 1;
                if (i18 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                int intValue = ((Number) next).intValue();
                if (i18 == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                addStepView(z11, i13, intValue);
                i18 = i19;
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i11);
        super.onMeasure(defaultSize, this.stepHeight);
        if (!this.isInitialized) {
            this.isInitialized = true;
            Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(this, new StepProgressView$onMeasure$$inlined$doOnPreDraw$1(this, this, defaultSize)), "View.doOnPreDraw(\n    cr…dd(this) { action(this) }");
        }
    }

    public final void setProgress(int i11, int i12) {
        this.totalSteps = i11;
        this.completedSteps = i12;
        a(this, 0, 1, (Object) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public StepProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.completedStepColor = ContextCompat.getColor(context, R.color.ds_primary_100);
        this.uncompletedStepColor = ContextCompat.getColor(context, R.color.ds_primary_30);
        this.stepHeight = (int) TypedValue.applyDimension(1, 3.0f, getResources().getDisplayMetrics());
        this.stepMargin = getResources().getDimensionPixelSize(R.dimen.ds_xxxs);
    }
}
