package com.talabat.gem.adapters.presentation.home.entrypoint;

import android.view.View;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.ui.di.AndroidComponentsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemHomeEntryPointView$locationConfigRepository$2 extends Lambda implements Function0<LocationConfigurationRepository> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemHomeEntryPointView f60142g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemHomeEntryPointView$locationConfigRepository$2(GemHomeEntryPointView gemHomeEntryPointView) {
        super(0);
        this.f60142g = gemHomeEntryPointView;
    }

    @NotNull
    public final LocationConfigurationRepository invoke() {
        return ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((View) this.f60142g).getFeature(ConfigurationRemoteCoreLibApi.class)).getLocationConfigurationRepository();
    }
}
