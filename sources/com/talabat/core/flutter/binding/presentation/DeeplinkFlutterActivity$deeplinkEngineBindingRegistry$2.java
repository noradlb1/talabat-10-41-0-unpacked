package com.talabat.core.flutter.binding.presentation;

import android.app.Activity;
import com.talabat.core.flutter.binding.domain.DeeplinkEngineBindingRegistry;
import com.talabat.core.flutter.binding.domain.di.FlutterBindingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/core/flutter/binding/domain/DeeplinkEngineBindingRegistry;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DeeplinkFlutterActivity$deeplinkEngineBindingRegistry$2 extends Lambda implements Function0<DeeplinkEngineBindingRegistry> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeeplinkFlutterActivity f55868g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeeplinkFlutterActivity$deeplinkEngineBindingRegistry$2(DeeplinkFlutterActivity deeplinkFlutterActivity) {
        super(0);
        this.f55868g = deeplinkFlutterActivity;
    }

    @NotNull
    public final DeeplinkEngineBindingRegistry invoke() {
        return ((FlutterBindingCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this.f55868g).getFeature(FlutterBindingCoreLibApi.class)).getDeeplinkEngineBindingRegistry();
    }
}
