package com.talabat.darkstores.feature.main;

import android.app.Activity;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresMainActivity$coroutineDispatchersFactory$2 extends Lambda implements Function0<CoroutineDispatchersFactory> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DarkstoresMainActivity f56446g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DarkstoresMainActivity$coroutineDispatchersFactory$2(DarkstoresMainActivity darkstoresMainActivity) {
        super(0);
        this.f56446g = darkstoresMainActivity;
    }

    @NotNull
    public final CoroutineDispatchersFactory invoke() {
        return ((DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this.f56446g).getFeature(DispatcherCoreLibApi.class)).getCoroutineDispatchersFactory();
    }
}
