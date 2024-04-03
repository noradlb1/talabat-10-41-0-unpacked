package org.junit.jupiter.api.extension;

import j$.util.Optional;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.StringUtils;
import org.junit.platform.commons.util.ToStringBuilder;

@API(since = "5.0", status = API.Status.STABLE)
public class ConditionEvaluationResult {
    private final boolean enabled;
    private final Optional<String> reason;

    private ConditionEvaluationResult(boolean z11, String str) {
        this.enabled = z11;
        this.reason = Optional.ofNullable(str);
    }

    public static ConditionEvaluationResult disabled(String str) {
        return new ConditionEvaluationResult(false, str);
    }

    public static ConditionEvaluationResult enabled(String str) {
        return new ConditionEvaluationResult(true, str);
    }

    public Optional<String> getReason() {
        return this.reason;
    }

    public boolean isDisabled() {
        return !this.enabled;
    }

    public String toString() {
        return new ToStringBuilder((Object) this).append("enabled", Boolean.valueOf(this.enabled)).append("reason", this.reason.orElse("<unknown>")).toString();
    }

    @API(since = "5.7", status = API.Status.STABLE)
    public static ConditionEvaluationResult disabled(String str, String str2) {
        if (StringUtils.isBlank(str2)) {
            return disabled(str);
        }
        return disabled(String.format("%s ==> %s", new Object[]{str, str2}));
    }
}
