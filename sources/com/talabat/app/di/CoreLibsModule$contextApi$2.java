package com.talabat.app.di;

import android.app.Application;
import android.content.Context;
import com.talabat.core.context.data.ContextCoreLibComponent;
import com.talabat.core.context.data.DaggerContextCoreLibComponent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/core/context/data/ContextCoreLibComponent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CoreLibsModule$contextApi$2 extends Lambda implements Function0<ContextCoreLibComponent> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CoreLibsModule f55384g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreLibsModule$contextApi$2(CoreLibsModule coreLibsModule) {
        super(0);
        this.f55384g = coreLibsModule;
    }

    @NotNull
    public final ContextCoreLibComponent invoke() {
        ContextCoreLibComponent.Factory factory = DaggerContextCoreLibComponent.factory();
        Application access$getApplication$p = this.f55384g.application;
        Context applicationContext = this.f55384g.application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "application.applicationContext");
        return factory.create(access$getApplication$p, applicationContext);
    }
}
