package com.talabat.feature.rewards.data.tracking.events.attributes;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H&J\u000e\u0010\u0005\u001a\u00020\u0006*\u0004\u0018\u00010\u0006H\u0016J\u0013\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u0004*\u0004\u0018\u00010\u0004H\u0016¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/rewards/data/tracking/events/attributes/TrackingAttributes;", "", "getAttributes", "", "", "or0", "", "orFalse", "", "(Ljava/lang/Boolean;)Z", "orNA", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TrackingAttributes {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static Number or0(@NotNull TrackingAttributes trackingAttributes, @Nullable Number number) {
            if (number == null) {
                return 0;
            }
            return number;
        }

        public static boolean orFalse(@NotNull TrackingAttributes trackingAttributes, @Nullable Boolean bool) {
            return Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE);
        }

        @NotNull
        public static String orNA(@NotNull TrackingAttributes trackingAttributes, @Nullable String str) {
            return str == null || str.length() == 0 ? "N/A" : str;
        }
    }

    @NotNull
    Map<String, Object> getAttributes();

    @NotNull
    Number or0(@Nullable Number number);

    boolean orFalse(@Nullable Boolean bool);

    @NotNull
    String orNA(@Nullable String str);
}
