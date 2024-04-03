package org.junit.platform.engine.discovery;

import j$.util.function.Predicate;
import java.util.regex.Pattern;
import org.junit.platform.engine.FilterResult;

class ExcludeClassNameFilter extends AbstractClassNameFilter {
    public ExcludeClassNameFilter(String... strArr) {
        super(strArr);
    }

    private String formatExclusionReason(String str, Pattern pattern) {
        return String.format("Class name [%s] matches excluded pattern: '%s'", new Object[]{str, pattern});
    }

    private String formatInclusionReason(String str) {
        return String.format("Class name [%s] does not match any excluded pattern: %s", new Object[]{str, this.f28025b});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ FilterResult lambda$apply$0(String str, Pattern pattern) {
        return FilterResult.excluded(formatExclusionReason(str, pattern));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ FilterResult lambda$apply$1(String str) {
        return FilterResult.included(formatInclusionReason(str));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$toPredicate$2(String str) {
        return !b(str).isPresent();
    }

    public Predicate<String> toPredicate() {
        return new e(this);
    }

    public String toString() {
        return String.format("%s that excludes class names that match one of the following regular expressions: %s", new Object[]{getClass().getSimpleName(), this.f28025b});
    }

    public FilterResult apply(String str) {
        return (FilterResult) b(str).map(new c(this, str)).orElseGet(new d(this, str));
    }
}
