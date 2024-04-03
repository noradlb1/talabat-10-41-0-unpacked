package com.deliveryhero.customerchat.analytics.repository;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AnalyticsRepositoryImpl$baseURL$2 extends Lambda implements Function0<String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AnalyticsRepositoryImpl f29807g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnalyticsRepositoryImpl$baseURL$2(AnalyticsRepositoryImpl analyticsRepositoryImpl) {
        super(0);
        this.f29807g = analyticsRepositoryImpl;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
        r0 = r2.f29807g.buildUrl((r0 = (r0 = r0.getClientConfigOrNull()).getDhEnvironment()));
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String invoke() {
        /*
            r2 = this;
            com.deliveryhero.customerchat.analytics.repository.AnalyticsRepositoryImpl r0 = r2.f29807g
            com.deliveryhero.customerchat.configuration.ChatConfigProvider r0 = r0.chatConfigProvider
            com.deliveryhero.contract.configuration.ChatConfiguration r0 = r0.getChatConfiguration()
            if (r0 == 0) goto L_0x0021
            com.deliveryhero.contract.model.ClientConfig r0 = r0.getClientConfigOrNull()
            if (r0 == 0) goto L_0x0021
            com.deliveryhero.contract.model.DhEnvironment r0 = r0.getDhEnvironment()
            if (r0 == 0) goto L_0x0021
            com.deliveryhero.customerchat.analytics.repository.AnalyticsRepositoryImpl r1 = r2.f29807g
            java.lang.String r0 = r1.buildUrl(r0)
            if (r0 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            java.lang.String r0 = ""
        L_0x0023:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.analytics.repository.AnalyticsRepositoryImpl$baseURL$2.invoke():java.lang.String");
    }
}
