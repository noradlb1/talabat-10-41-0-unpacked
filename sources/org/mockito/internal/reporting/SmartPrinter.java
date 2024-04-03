package org.mockito.internal.reporting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;

public class SmartPrinter {
    private final List<String> actuals;
    private final String wanted;

    public SmartPrinter(MatchableInvocation matchableInvocation, Invocation invocation, Integer... numArr) {
        this(matchableInvocation, Collections.singletonList(invocation), numArr, Collections.emptySet());
    }

    private static boolean isMultiLine(MatchableInvocation matchableInvocation, List<Invocation> list) {
        boolean contains = matchableInvocation.toString().contains(StringUtils.LF);
        boolean z11 = false;
        for (Invocation obj : list) {
            z11 |= obj.toString().contains(StringUtils.LF);
        }
        if (contains || z11) {
            return true;
        }
        return false;
    }

    public List<String> getActuals() {
        return this.actuals;
    }

    public String getWanted() {
        return this.wanted;
    }

    public SmartPrinter(MatchableInvocation matchableInvocation, List<Invocation> list, Integer[] numArr, Set<String> set) {
        PrintSettings printSettings = new PrintSettings();
        printSettings.setMultiline(isMultiLine(matchableInvocation, list));
        printSettings.setMatchersToBeDescribedWithExtraTypeInfo(numArr);
        printSettings.setMatchersToBeDescribedWithFullName(set);
        this.wanted = printSettings.print(matchableInvocation);
        ArrayList arrayList = new ArrayList();
        for (Invocation print : list) {
            arrayList.add(printSettings.print(print));
        }
        this.actuals = Collections.unmodifiableList(arrayList);
    }
}
