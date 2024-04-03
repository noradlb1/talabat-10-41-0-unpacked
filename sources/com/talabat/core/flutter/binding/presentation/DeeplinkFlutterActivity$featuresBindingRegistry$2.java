package com.talabat.core.flutter.binding.presentation;

import android.app.Activity;
import com.talabat.core.flutter.binding.domain.EngineBinding;
import com.talabat.core.flutter.binding.domain.di.FlutterBindingFeatureLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/core/flutter/binding/domain/EngineBinding;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DeeplinkFlutterActivity$featuresBindingRegistry$2 extends Lambda implements Function0<Set<? extends EngineBinding>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeeplinkFlutterActivity f55869g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeeplinkFlutterActivity$featuresBindingRegistry$2(DeeplinkFlutterActivity deeplinkFlutterActivity) {
        super(0);
        this.f55869g = deeplinkFlutterActivity;
    }

    @NotNull
    public final Set<EngineBinding> invoke() {
        return ((FlutterBindingFeatureLibApi) AndroidComponentsKt.apiContainer((Activity) this.f55869g).getFeature(FlutterBindingFeatureLibApi.class)).getRegisteredFlutterBindingFeatureModules();
    }
}
