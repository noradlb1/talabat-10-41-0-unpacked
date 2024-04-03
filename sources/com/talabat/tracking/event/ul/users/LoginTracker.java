package com.talabat.tracking.event.ul.users;

import com.talabat.configuration.country.Country;
import com.talabat.core.tracking.domain.TalabatTracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/tracking/event/ul/users/LoginTracker;", "", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "trackLoginClick", "", "from", "", "loginType", "country", "Lcom/talabat/configuration/country/Country;", "trackLoginScreenOpened", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoginTracker {
    @NotNull
    private final TalabatTracker talabatTracker;

    @Inject
    public LoginTracker(@NotNull TalabatTracker talabatTracker2) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        this.talabatTracker = talabatTracker2;
    }

    public final void trackLoginClick(@NotNull String str, @NotNull String str2, @NotNull Country country) {
        Intrinsics.checkNotNullParameter(str, "from");
        Intrinsics.checkNotNullParameter(str2, "loginType");
        Intrinsics.checkNotNullParameter(country, "country");
        this.talabatTracker.track(new HybridLoginClickedEvent(str, str2, country));
    }

    public final void trackLoginScreenOpened(@NotNull String str, @NotNull Country country) {
        Intrinsics.checkNotNullParameter(str, "from");
        Intrinsics.checkNotNullParameter(country, "country");
        this.talabatTracker.track(new HybridLoginLoadedEvent(str, country));
    }
}
