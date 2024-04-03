package com.talabat.feature.darkstorestooltip.presentation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.feature.darkstorestooltip.presentation.TooltipViewState;
import com.talabat.feature.darkstorestooltip.presentation.di.DaggerDarkstoresTooltipComponent;
import com.talabat.wrapper.EventWrapper;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rm.a;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001,B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u001dJ\b\u0010\"\u001a\u00020\u001dH\u0014J\b\u0010#\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0002J\u0018\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u0017H\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006-"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/presentation/TooltipView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isInitialized", "", "()Z", "setInitialized", "(Z)V", "tooltip", "Landroid/view/View;", "tooltipViewController", "Lcom/talabat/feature/darkstorestooltip/presentation/TooltipViewController;", "getTooltipViewController", "()Lcom/talabat/feature/darkstorestooltip/presentation/TooltipViewController;", "setTooltipViewController", "(Lcom/talabat/feature/darkstorestooltip/presentation/TooltipViewController;)V", "computeAnchorViewSpecs", "Lcom/talabat/feature/darkstorestooltip/presentation/TooltipView$AnchorViewSpecs;", "anchorView", "getLocationOnScreen", "", "view", "hide", "", "initialize", "tooltipData", "Lcom/talabat/feature/darkstorestooltip/presentation/TooltipData;", "onClick", "onDetachedFromWindow", "removeTooltip", "renderTooltip", "renderViewState", "viewState", "Lcom/talabat/feature/darkstorestooltip/presentation/TooltipViewState;", "setUpArrowView", "arrowView", "anchorSpecs", "showTooltip", "AnchorViewSpecs", "com_talabat_feature_darkstores-tooltip_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TooltipView extends FrameLayout {
    private boolean isInitialized;
    /* access modifiers changed from: private */
    @Nullable
    public View tooltip;
    @Inject
    public TooltipViewController tooltipViewController;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/presentation/TooltipView$AnchorViewSpecs;", "", "x", "", "y", "width", "height", "(IIII)V", "getHeight", "()I", "getWidth", "getX", "getY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_feature_darkstores-tooltip_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnchorViewSpecs {
        private final int height;
        private final int width;

        /* renamed from: x  reason: collision with root package name */
        private final int f58506x;

        /* renamed from: y  reason: collision with root package name */
        private final int f58507y;

        public AnchorViewSpecs(int i11, int i12, int i13, int i14) {
            this.f58506x = i11;
            this.f58507y = i12;
            this.width = i13;
            this.height = i14;
        }

        public static /* synthetic */ AnchorViewSpecs copy$default(AnchorViewSpecs anchorViewSpecs, int i11, int i12, int i13, int i14, int i15, Object obj) {
            if ((i15 & 1) != 0) {
                i11 = anchorViewSpecs.f58506x;
            }
            if ((i15 & 2) != 0) {
                i12 = anchorViewSpecs.f58507y;
            }
            if ((i15 & 4) != 0) {
                i13 = anchorViewSpecs.width;
            }
            if ((i15 & 8) != 0) {
                i14 = anchorViewSpecs.height;
            }
            return anchorViewSpecs.copy(i11, i12, i13, i14);
        }

        public final int component1() {
            return this.f58506x;
        }

        public final int component2() {
            return this.f58507y;
        }

        public final int component3() {
            return this.width;
        }

        public final int component4() {
            return this.height;
        }

        @NotNull
        public final AnchorViewSpecs copy(int i11, int i12, int i13, int i14) {
            return new AnchorViewSpecs(i11, i12, i13, i14);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnchorViewSpecs)) {
                return false;
            }
            AnchorViewSpecs anchorViewSpecs = (AnchorViewSpecs) obj;
            return this.f58506x == anchorViewSpecs.f58506x && this.f58507y == anchorViewSpecs.f58507y && this.width == anchorViewSpecs.width && this.height == anchorViewSpecs.height;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getX() {
            return this.f58506x;
        }

        public final int getY() {
            return this.f58507y;
        }

        public int hashCode() {
            return (((((this.f58506x * 31) + this.f58507y) * 31) + this.width) * 31) + this.height;
        }

        @NotNull
        public String toString() {
            int i11 = this.f58506x;
            int i12 = this.f58507y;
            int i13 = this.width;
            int i14 = this.height;
            return "AnchorViewSpecs(x=" + i11 + ", y=" + i12 + ", width=" + i13 + ", height=" + i14 + ")";
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TooltipView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TooltipView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TooltipView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final AnchorViewSpecs computeAnchorViewSpecs(View view) {
        int[] locationOnScreen = getLocationOnScreen(view);
        int[] locationOnScreen2 = getLocationOnScreen(this);
        return new AnchorViewSpecs(locationOnScreen[0] - locationOnScreen2[0], locationOnScreen[1] - locationOnScreen2[1], view.getWidth(), view.getHeight());
    }

    private final int[] getLocationOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: initialize$lambda-0  reason: not valid java name */
    public static final void m10212initialize$lambda0(TooltipView tooltipView, EventWrapper eventWrapper) {
        Intrinsics.checkNotNullParameter(tooltipView, "this$0");
        TooltipViewState tooltipViewState = (TooltipViewState) eventWrapper.getContentIfNotHandled();
        if (tooltipViewState != null) {
            tooltipView.renderViewState(tooltipViewState);
        }
    }

    private final void removeTooltip() {
        View view = this.tooltip;
        if (view != null) {
            view.setAlpha(1.0f);
            view.animate().alpha(0.0f).setDuration(150).setListener(new TooltipView$removeTooltip$1$1(this)).start();
        }
    }

    /* access modifiers changed from: private */
    public final void renderTooltip(TooltipData tooltipData) {
        AnchorViewSpecs computeAnchorViewSpecs = computeAnchorViewSpecs(tooltipData.getAnchor());
        View inflate = View.inflate(getContext(), R.layout.tooltip_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = computeAnchorViewSpecs.getY() + computeAnchorViewSpecs.getHeight();
        inflate.setLayoutParams(layoutParams);
        View findViewById = inflate.findViewById(R.id.arrowTop);
        if (findViewById != null) {
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.arrowTop)");
            setUpArrowView(findViewById, computeAnchorViewSpecs);
        }
        ((TextView) inflate.findViewById(R.id.tooltipText)).setText(tooltipData.getMessage());
        addView(inflate);
        inflate.setAlpha(0.0f);
        inflate.animate().alpha(1.0f).setDuration(150).start();
        this.tooltip = inflate;
    }

    private final void renderViewState(TooltipViewState tooltipViewState) {
        if (tooltipViewState instanceof TooltipViewState.Hidden) {
            removeTooltip();
        } else if (tooltipViewState instanceof TooltipViewState.Shown) {
            showTooltip(((TooltipViewState.Shown) tooltipViewState).getTooltipData());
        }
    }

    private final void setUpArrowView(View view, AnchorViewSpecs anchorViewSpecs) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            view.setVisibility(8);
        } else {
            marginLayoutParams.leftMargin = (anchorViewSpecs.getX() + (anchorViewSpecs.getWidth() / 2)) - (view.getLayoutParams().width / 2);
        }
    }

    private final void showTooltip(TooltipData tooltipData) {
        setVisibility(0);
        View anchor = tooltipData.getAnchor();
        if (!ViewCompat.isLaidOut(anchor) || anchor.isLayoutRequested()) {
            anchor.addOnLayoutChangeListener(new TooltipView$showTooltip$$inlined$doOnLayout$1(this, tooltipData));
        } else {
            renderTooltip(tooltipData);
        }
    }

    @NotNull
    public final TooltipViewController getTooltipViewController() {
        TooltipViewController tooltipViewController2 = this.tooltipViewController;
        if (tooltipViewController2 != null) {
            return tooltipViewController2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tooltipViewController");
        return null;
    }

    public final void hide() {
        if (this.isInitialized) {
            getTooltipViewController().hideTooltip$com_talabat_feature_darkstores_tooltip_presentation_presentation();
        }
    }

    public final void initialize(@NotNull TooltipData tooltipData) {
        Intrinsics.checkNotNullParameter(tooltipData, "tooltipData");
        if (this.tooltipViewController == null) {
            Context applicationContext = getContext().getApplicationContext();
            if (applicationContext != null) {
                ApiContainer apiContainer = (ApiContainer) applicationContext;
                DaggerDarkstoresTooltipComponent.factory().create((ContextCoreLibApi) apiContainer.getFeature(ContextCoreLibApi.class), (DispatcherCoreLibApi) apiContainer.getFeature(DispatcherCoreLibApi.class)).inject(this);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
            }
        }
        LiveData<EventWrapper<TooltipViewState>> viewState = getTooltipViewController().getViewState();
        Context context = getContext();
        if (context != null) {
            viewState.observe((FragmentActivity) context, new a(this));
            getTooltipViewController().setUp(tooltipData);
            this.isInitialized = true;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public final boolean isInitialized() {
        return this.isInitialized;
    }

    public final void onClick() {
        if (this.isInitialized) {
            getTooltipViewController().onTooltipClicked();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.isInitialized) {
            getTooltipViewController().onCleared();
        }
    }

    public final void setInitialized(boolean z11) {
        this.isInitialized = z11;
    }

    public final void setTooltipViewController(@NotNull TooltipViewController tooltipViewController2) {
        Intrinsics.checkNotNullParameter(tooltipViewController2, "<set-?>");
        this.tooltipViewController = tooltipViewController2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TooltipView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        setVisibility(8);
        setLayoutDirection(0);
    }
}
