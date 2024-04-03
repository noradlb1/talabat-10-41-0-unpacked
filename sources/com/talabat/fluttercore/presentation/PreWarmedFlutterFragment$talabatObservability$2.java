package com.talabat.fluttercore.presentation;

import androidx.fragment.app.Fragment;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PreWarmedFlutterFragment$talabatObservability$2 extends Lambda implements Function0<IObservabilityManager> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PreWarmedFlutterFragment f59781g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreWarmedFlutterFragment$talabatObservability$2(PreWarmedFlutterFragment preWarmedFlutterFragment) {
        super(0);
        this.f59781g = preWarmedFlutterFragment;
    }

    @NotNull
    public final IObservabilityManager invoke() {
        return ((ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this.f59781g).getFeature(ObservabilityCoreLibApi.class)).getObservabilityManager();
    }
}
