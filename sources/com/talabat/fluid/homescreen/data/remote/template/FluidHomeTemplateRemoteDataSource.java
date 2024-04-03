package com.talabat.fluid.homescreen.data.remote.template;

import android.content.Context;
import com.deliveryhero.fluid.ParseConfig;
import com.deliveryhero.fluid.template.sources.TemplateInputStreamSource;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u000fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/talabat/fluid/homescreen/data/remote/template/FluidHomeTemplateRemoteDataSource;", "Lcom/deliveryhero/fluid/template/sources/TemplateInputStreamSource;", "homeScreenPerformanceObservability", "Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;", "parseConfig", "Lcom/deliveryhero/fluid/ParseConfig;", "api", "Lcom/talabat/fluid/homescreen/data/remote/template/FluidHomeTemplateApi;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "context", "Landroid/content/Context;", "selectedLanguage", "", "localInputStream", "Lkotlin/Function0;", "Ljava/io/InputStream;", "remoteInputStream", "(Lcom/talabat/fluid/homescreen/domain/tracking/observability/HomeScreenPerformanceObservability;Lcom/deliveryhero/fluid/ParseConfig;Lcom/talabat/fluid/homescreen/data/remote/template/FluidHomeTemplateApi;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "name", "getName", "()Ljava/lang/String;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeTemplateRemoteDataSource extends TemplateInputStreamSource {
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f59702name;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FluidHomeTemplateRemoteDataSource(final com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability r13, com.deliveryhero.fluid.ParseConfig r14, com.talabat.fluid.homescreen.data.remote.template.FluidHomeTemplateApi r15, com.talabat.configuration.ConfigurationLocalRepository r16, com.talabat.core.observabilityNew.domain.IObservabilityManager r17, android.content.Context r18, java.lang.String r19, kotlin.jvm.functions.Function0 r20, kotlin.jvm.functions.Function0 r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r12 = this;
            r0 = r22
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0011
            com.talabat.fluid.homescreen.data.remote.template.FluidHomeTemplateRemoteDataSource$1 r1 = new com.talabat.fluid.homescreen.data.remote.template.FluidHomeTemplateRemoteDataSource$1
            r8 = r13
            r9 = r18
            r10 = r19
            r1.<init>(r13, r9, r10)
            goto L_0x0018
        L_0x0011:
            r8 = r13
            r9 = r18
            r10 = r19
            r1 = r20
        L_0x0018:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x002b
            com.talabat.fluid.homescreen.data.remote.template.FluidHomeTemplateRemoteDataSource$2 r0 = new com.talabat.fluid.homescreen.data.remote.template.FluidHomeTemplateRemoteDataSource$2
            r2 = r0
            r3 = r13
            r4 = r16
            r5 = r15
            r6 = r17
            r7 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            r11 = r0
            goto L_0x002d
        L_0x002b:
            r11 = r21
        L_0x002d:
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.homescreen.data.remote.template.FluidHomeTemplateRemoteDataSource.<init>(com.talabat.fluid.homescreen.domain.tracking.observability.HomeScreenPerformanceObservability, com.deliveryhero.fluid.ParseConfig, com.talabat.fluid.homescreen.data.remote.template.FluidHomeTemplateApi, com.talabat.configuration.ConfigurationLocalRepository, com.talabat.core.observabilityNew.domain.IObservabilityManager, android.content.Context, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @NotNull
    public String getName() {
        return this.f59702name;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FluidHomeTemplateRemoteDataSource(@NotNull HomeScreenPerformanceObservability homeScreenPerformanceObservability, @NotNull ParseConfig parseConfig, @NotNull FluidHomeTemplateApi fluidHomeTemplateApi, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull IObservabilityManager iObservabilityManager, @NotNull Context context, @NotNull String str, @NotNull Function0<? extends InputStream> function0, @NotNull Function0<? extends InputStream> function02) {
        super(function02, parseConfig);
        Intrinsics.checkNotNullParameter(homeScreenPerformanceObservability, "homeScreenPerformanceObservability");
        Intrinsics.checkNotNullParameter(parseConfig, "parseConfig");
        Intrinsics.checkNotNullParameter(fluidHomeTemplateApi, "api");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "selectedLanguage");
        Intrinsics.checkNotNullParameter(function0, "localInputStream");
        Intrinsics.checkNotNullParameter(function02, "remoteInputStream");
        this.f59702name = "RemoteTemplateSource";
    }
}
