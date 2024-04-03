package f6;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class a implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f34436b;

    public /* synthetic */ a(Function2 function2) {
        this.f34436b = function2;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        ProgressiveOfferComposablesKt.m8523ProgressiveOfferSurface$lambda11(this.f34436b, lifecycleOwner, event);
    }
}
