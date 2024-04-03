package com.talabat.feature.tpro.presentation.benefits.adapter.carousel.autorecylerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.helpers.TalabatUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\rJ\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/carousel/autorecylerview/AutoScrollRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentSpeed", "interpolator", "Lcom/talabat/feature/tpro/presentation/benefits/adapter/carousel/autorecylerview/AutoScrollRecyclerView$UniformSpeedInterpolator;", "isAutoScroll", "", "continueScroll", "", "notifyRtlToLayoutManager", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "isRtl", "onScrolled", "dx", "dy", "onTouchEvent", "e", "Landroid/view/MotionEvent;", "openAutoScroll", "speed", "smoothScroll", "startScroll", "Companion", "UniformSpeedInterpolator", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AutoScrollRecyclerView extends RecyclerView {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int SPEED = 40;
    private int currentSpeed;
    @NotNull
    private UniformSpeedInterpolator interpolator;
    private boolean isAutoScroll;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/carousel/autorecylerview/AutoScrollRecyclerView$Companion;", "", "()V", "SPEED", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/carousel/autorecylerview/AutoScrollRecyclerView$UniformSpeedInterpolator;", "Landroid/view/animation/Interpolator;", "()V", "getInterpolation", "", "input", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UniformSpeedInterpolator implements Interpolator {
        public float getInterpolation(float f11) {
            return f11;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AutoScrollRecyclerView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AutoScrollRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AutoScrollRecyclerView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void continueScroll() {
        this.currentSpeed++;
        startScroll();
        this.currentSpeed--;
    }

    private final void notifyRtlToLayoutManager(RecyclerView.LayoutManager layoutManager, boolean z11) {
        LinearLayoutManager linearLayoutManager;
        if (layoutManager instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) layoutManager;
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager != null) {
            linearLayoutManager.setReverseLayout(z11);
        }
    }

    public static /* synthetic */ void openAutoScroll$default(AutoScrollRecyclerView autoScrollRecyclerView, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 40;
        }
        if ((i12 & 2) != 0) {
            z11 = TalabatUtils.isRTL();
        }
        autoScrollRecyclerView.openAutoScroll(i11, z11);
    }

    private final void smoothScroll() {
        int abs = Math.abs(this.currentSpeed);
        smoothScrollBy(abs, abs, this.interpolator);
    }

    private final void startScroll() {
        smoothScroll();
    }

    public void onScrolled(int i11, int i12) {
        if (this.isAutoScroll) {
            smoothScroll();
        }
    }

    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        int action = motionEvent.getAction();
        if (action != 1 && action != 3) {
            return super.onTouchEvent(motionEvent);
        }
        continueScroll();
        return false;
    }

    public final void openAutoScroll(int i11, boolean z11) {
        this.currentSpeed = i11;
        notifyRtlToLayoutManager(getLayoutManager(), z11);
        startScroll();
        this.isAutoScroll = true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AutoScrollRecyclerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.interpolator = new UniformSpeedInterpolator();
        this.currentSpeed = 40;
    }
}
