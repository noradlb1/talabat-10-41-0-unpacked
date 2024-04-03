package com.braze.ui.inappmessage;

import android.view.View;
import android.view.ViewGroup;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import z3.i;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"com/braze/ui/inappmessage/DefaultInAppMessageViewWrapper$open$2", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultInAppMessageViewWrapper$open$2 implements View.OnLayoutChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f44087b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DefaultInAppMessageViewWrapper f44088c;

    public DefaultInAppMessageViewWrapper$open$2(ViewGroup viewGroup, DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper) {
        this.f44087b = viewGroup;
        this.f44088c = defaultInAppMessageViewWrapper;
    }

    /* access modifiers changed from: private */
    /* renamed from: onLayoutChange$lambda-0  reason: not valid java name */
    public static final void m9214onLayoutChange$lambda0(DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(defaultInAppMessageViewWrapper, "this$0");
        Intrinsics.checkNotNullParameter(viewGroup, "$parentViewGroup");
        defaultInAppMessageViewWrapper.addInAppMessageViewToViewGroup(viewGroup, defaultInAppMessageViewWrapper.getInAppMessage(), defaultInAppMessageViewWrapper.getInAppMessageView(), defaultInAppMessageViewWrapper.getInAppMessageViewLifecycleListener());
    }

    public void onLayoutChange(@NotNull View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f44087b.removeOnLayoutChangeListener(this);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new DefaultInAppMessageViewWrapper$open$2$onLayoutChange$1(i14, i12), 7, (Object) null);
        this.f44087b.removeView(this.f44088c.getInAppMessageView());
        ViewGroup viewGroup = this.f44087b;
        viewGroup.post(new i(this.f44088c, viewGroup));
    }
}
