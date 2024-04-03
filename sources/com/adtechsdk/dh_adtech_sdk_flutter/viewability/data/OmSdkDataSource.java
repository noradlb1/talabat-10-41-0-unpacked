package com.adtechsdk.dh_adtech_sdk_flutter.viewability.data;

import android.content.Context;
import com.iab.omid.library.deliveryhero3.Omid;
import com.iab.omid.library.deliveryhero3.adsession.AdEvents;
import com.iab.omid.library.deliveryhero3.adsession.AdSession;
import com.iab.omid.library.deliveryhero3.adsession.AdSessionConfiguration;
import com.iab.omid.library.deliveryhero3.adsession.AdSessionContext;
import com.iab.omid.library.deliveryhero3.adsession.CreativeType;
import com.iab.omid.library.deliveryhero3.adsession.ImpressionType;
import com.iab.omid.library.deliveryhero3.adsession.Owner;
import com.iab.omid.library.deliveryhero3.adsession.Partner;
import com.iab.omid.library.deliveryhero3.adsession.VerificationScriptResource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004J.\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J8\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001aJ\u0016\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001aJ\u000e\u0010#\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020%¨\u0006&"}, d2 = {"Lcom/adtechsdk/dh_adtech_sdk_flutter/viewability/data/OmSdkDataSource;", "", "()V", "createAdDisplaySession", "Lcom/iab/omid/library/deliveryhero3/adsession/AdSession;", "configuration", "Lcom/iab/omid/library/deliveryhero3/adsession/AdSessionConfiguration;", "context", "Lcom/iab/omid/library/deliveryhero3/adsession/AdSessionContext;", "createAdEvents", "Lcom/iab/omid/library/deliveryhero3/adsession/AdEvents;", "adSession", "createAdSessionConfiguration", "creativeType", "Lcom/iab/omid/library/deliveryhero3/adsession/CreativeType;", "impressionType", "Lcom/iab/omid/library/deliveryhero3/adsession/ImpressionType;", "impressionOwner", "Lcom/iab/omid/library/deliveryhero3/adsession/Owner;", "mediaEventsOwner", "isolateVerificationScripts", "", "createAdSessionContext", "partner", "Lcom/iab/omid/library/deliveryhero3/adsession/Partner;", "script", "", "resources", "", "Lcom/iab/omid/library/deliveryhero3/adsession/VerificationScriptResource;", "mediaURL", "customReferenceIdentifier", "createPartner", "name", "stringVersion", "ensureOmidIsActivated", "", "Landroid/content/Context;", "dh_adtech_sdk_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OmSdkDataSource {
    @NotNull
    public final AdSession createAdDisplaySession(@NotNull AdSessionConfiguration adSessionConfiguration, @NotNull AdSessionContext adSessionContext) {
        Intrinsics.checkNotNullParameter(adSessionConfiguration, "configuration");
        Intrinsics.checkNotNullParameter(adSessionContext, "context");
        AdSession createAdSession = AdSession.createAdSession(adSessionConfiguration, adSessionContext);
        Intrinsics.checkNotNullExpressionValue(createAdSession, "createAdSession(configuration, context)");
        return createAdSession;
    }

    @NotNull
    public final AdEvents createAdEvents(@NotNull AdSession adSession) {
        Intrinsics.checkNotNullParameter(adSession, "adSession");
        AdEvents createAdEvents = AdEvents.createAdEvents(adSession);
        Intrinsics.checkNotNullExpressionValue(createAdEvents, "createAdEvents(adSession)");
        return createAdEvents;
    }

    @NotNull
    public final AdSessionConfiguration createAdSessionConfiguration(@NotNull CreativeType creativeType, @NotNull ImpressionType impressionType, @NotNull Owner owner, @NotNull Owner owner2, boolean z11) {
        Intrinsics.checkNotNullParameter(creativeType, "creativeType");
        Intrinsics.checkNotNullParameter(impressionType, "impressionType");
        Intrinsics.checkNotNullParameter(owner, "impressionOwner");
        Intrinsics.checkNotNullParameter(owner2, "mediaEventsOwner");
        AdSessionConfiguration createAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner2, z11);
        Intrinsics.checkNotNullExpressionValue(createAdSessionConfiguration, "createAdSessionConfigura…ficationScripts\n        )");
        return createAdSessionConfiguration;
    }

    @NotNull
    public final AdSessionContext createAdSessionContext(@NotNull Partner partner, @NotNull String str, @NotNull List<VerificationScriptResource> list, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(partner, "partner");
        Intrinsics.checkNotNullParameter(str, "script");
        Intrinsics.checkNotNullParameter(list, "resources");
        AdSessionContext createNativeAdSessionContext = AdSessionContext.createNativeAdSessionContext(partner, str, list, str2, str3);
        Intrinsics.checkNotNullExpressionValue(createNativeAdSessionContext, "createNativeAdSessionCon…renceIdentifier\n        )");
        return createNativeAdSessionContext;
    }

    @NotNull
    public final Partner createPartner(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "stringVersion");
        Partner createPartner = Partner.createPartner(str, str2);
        Intrinsics.checkNotNullExpressionValue(createPartner, "createPartner(name, stringVersion)");
        return createPartner;
    }

    public final void ensureOmidIsActivated(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!Omid.isActive()) {
            Omid.activate(context);
        }
    }
}
