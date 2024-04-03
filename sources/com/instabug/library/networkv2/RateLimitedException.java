package com.instabug.library.networkv2;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.instabug.library.networkv2.RequestResponse;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class RateLimitedException extends RequestException {
    @NotNull
    public static final a Companion = new a((DefaultConstructorMarker) null);
    @NotNull
    public static final String RATE_LIMIT_REACHED = "You've reached the maximum number of requests in %s. You can read more about our rate limiting policy at this link: https://docs.instabug.com/docs/rate-limits";
    private final int period;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final RateLimitedException a(@Nullable String str) throws JSONException {
            boolean z11;
            int i11 = 0;
            if (str == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Integer num = null;
            if (z11) {
                str = null;
            }
            if (str != null) {
                num = Integer.valueOf(new JSONObject(str).optInt(TypedValues.CycleType.S_WAVE_PERIOD, 0));
            }
            if (num != null) {
                i11 = num.intValue();
            }
            return new RateLimitedException(i11);
        }
    }

    public RateLimitedException(int i11) {
        super(RequestResponse.HttpStatusCode._4xx.RATE_LIMIT_REACHED, (String) null, 2, (DefaultConstructorMarker) null);
        this.period = i11;
    }

    public static /* synthetic */ RateLimitedException copy$default(RateLimitedException rateLimitedException, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = rateLimitedException.period;
        }
        return rateLimitedException.copy(i11);
    }

    @JvmStatic
    @NotNull
    public static final RateLimitedException fromResponse(@Nullable String str) throws JSONException {
        return Companion.a(str);
    }

    public final int component1() {
        return this.period;
    }

    @NotNull
    public final RateLimitedException copy(int i11) {
        return new RateLimitedException(i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RateLimitedException) && this.period == ((RateLimitedException) obj).period;
    }

    public final int getPeriod() {
        return this.period;
    }

    public int hashCode() {
        return this.period;
    }

    @NotNull
    public String toString() {
        return "RateLimitedException(period=" + this.period + ')';
    }
}
