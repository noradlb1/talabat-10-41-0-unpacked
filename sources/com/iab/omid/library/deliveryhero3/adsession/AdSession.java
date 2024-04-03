package com.iab.omid.library.deliveryhero3.adsession;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.deliveryhero3.publisher.AdSessionStatePublisher;
import com.iab.omid.library.deliveryhero3.utils.g;

public abstract class AdSession {
    public static AdSession createAdSession(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        g.a();
        g.a((Object) adSessionConfiguration, "AdSessionConfiguration is null");
        g.a((Object) adSessionContext, "AdSessionContext is null");
        return new a(adSessionConfiguration, adSessionContext);
    }

    public abstract void addFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str);

    public abstract void error(ErrorType errorType, String str);

    public abstract void finish();

    public abstract String getAdSessionId();

    public abstract AdSessionStatePublisher getAdSessionStatePublisher();

    public abstract void registerAdView(View view);

    public abstract void removeAllFriendlyObstructions();

    public abstract void removeFriendlyObstruction(View view);

    public abstract void setPossibleObstructionListener(PossibleObstructionListener possibleObstructionListener);

    public abstract void start();
}
