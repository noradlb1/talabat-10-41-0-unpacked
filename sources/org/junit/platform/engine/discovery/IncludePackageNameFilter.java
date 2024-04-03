package org.junit.platform.engine.discovery;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import j$.util.Collection;
import j$.util.DesugarArrays;
import j$.util.Optional;
import j$.util.function.Predicate;
import j$.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.FilterResult;

class IncludePackageNameFilter implements PackageNameFilter {
    private final List<String> packageNames;
    private final String patternDescription;

    public IncludePackageNameFilter(String... strArr) {
        Preconditions.notEmpty((T[]) strArr, "packageNames array must not be null or empty");
        Preconditions.containsNoNullElements((T[]) strArr, "packageNames array must not contain null elements");
        this.packageNames = Arrays.asList(strArr);
        this.patternDescription = (String) DesugarArrays.stream((T[]) strArr).collect(Collectors.joining("' OR '", "'", "'"));
    }

    private Optional<String> findMatchingName(String str) {
        return Collection.EL.stream(this.packageNames).filter(new m(str)).findAny();
    }

    private String formatExclusionReason(String str) {
        return String.format("Package name [%s] does not match any included names: %s", new Object[]{str, this.patternDescription});
    }

    private String formatInclusionReason(String str, String str2) {
        return String.format("Package name [%s] matches included name: '%s'", new Object[]{str, str2});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ FilterResult lambda$apply$0(String str, String str2) {
        return FilterResult.included(formatInclusionReason(str, str2));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ FilterResult lambda$apply$1(String str) {
        return FilterResult.excluded(formatExclusionReason(str));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$findMatchingName$3(String str, String str2) {
        if (!str2.equals(str)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            return str.startsWith(sb2.toString());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$toPredicate$2(String str) {
        return findMatchingName(str).isPresent();
    }

    public Predicate<String> toPredicate() {
        return new n(this);
    }

    public String toString() {
        return String.format("%s that includes packages whose names are either equal to or start with one of the following: %s", new Object[]{getClass().getSimpleName(), this.patternDescription});
    }

    public FilterResult apply(String str) {
        return (FilterResult) findMatchingName(str).map(new o(this, str)).orElseGet(new p(this, str));
    }
}
