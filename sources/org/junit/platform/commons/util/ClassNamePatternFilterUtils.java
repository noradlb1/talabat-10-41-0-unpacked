package org.junit.platform.commons.util;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import j$.util.DesugarArrays;
import j$.util.Optional;
import j$.util.function.Predicate;
import j$.util.stream.Collectors;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l30.q;
import l30.r;
import l30.s;
import l30.t;
import l30.u;
import l30.w;
import org.apiguardian.api.API;
import x20.v;

@API(since = "1.7", status = API.Status.INTERNAL)
public class ClassNamePatternFilterUtils {
    public static final String DEACTIVATE_ALL_PATTERN = "*";

    private ClassNamePatternFilterUtils() {
    }

    private static List<Pattern> convertToRegularExpressions(String str) {
        return (List) DesugarArrays.stream((T[]) str.split(",")).filter(new q()).map(new v()).map(new r()).map(new s()).collect(Collectors.toList());
    }

    /* access modifiers changed from: private */
    public static <T> Predicate<T> createPredicateFromPatterns(String str) {
        if ("*".equals(str)) {
            return new l30.v();
        }
        return new w(convertToRegularExpressions(str));
    }

    public static <T> Predicate<T> excludeMatchingClasses(String str) {
        return (Predicate) Optional.ofNullable(str).filter(new q()).map(new v()).map(new t()).orElse(new u());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createPredicateFromPatterns$1(Object obj) {
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$excludeMatchingClasses$0(Object obj) {
        return true;
    }

    /* access modifiers changed from: private */
    public static String replaceRegExElements(String str) {
        return Matcher.quoteReplacement(str).replace(RealDiscoveryConfigurationRepository.VERSION_DELIMETER, "[.$]").replace("*", ".+");
    }
}
