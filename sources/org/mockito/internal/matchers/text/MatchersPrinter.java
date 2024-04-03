package org.mockito.internal.matchers.text;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.matchers.ContainsExtraTypeInfo;
import org.mockito.internal.reporting.PrintSettings;

public class MatchersPrinter {
    private Iterator<FormattedText> applyPrintSettings(List<ArgumentMatcher> list, PrintSettings printSettings) {
        String str;
        LinkedList linkedList = new LinkedList();
        int i11 = 0;
        for (ArgumentMatcher next : list) {
            if (next instanceof ContainsExtraTypeInfo) {
                ContainsExtraTypeInfo containsExtraTypeInfo = (ContainsExtraTypeInfo) next;
                Object wanted = containsExtraTypeInfo.getWanted();
                String str2 = "";
                if (wanted != null) {
                    str = wanted.getClass().getSimpleName();
                } else {
                    str = str2;
                }
                if (wanted != null) {
                    str2 = wanted.getClass().getCanonicalName();
                }
                if (printSettings.extraTypeInfoFor(i11)) {
                    linkedList.add(new FormattedText(containsExtraTypeInfo.toStringWithType(str)));
                } else if (printSettings.fullyQualifiedNameFor(str)) {
                    linkedList.add(new FormattedText(containsExtraTypeInfo.toStringWithType(str2)));
                } else {
                    linkedList.add(new FormattedText(MatcherToString.a(next)));
                }
            } else {
                linkedList.add(new FormattedText(MatcherToString.a(next)));
            }
            i11++;
        }
        return linkedList.iterator();
    }

    public String getArgumentsBlock(List<ArgumentMatcher> list, PrintSettings printSettings) {
        return ValuePrinter.printValues("(\n    ", ",\n    ", "\n);", applyPrintSettings(list, printSettings));
    }

    public String getArgumentsLine(List<ArgumentMatcher> list, PrintSettings printSettings) {
        return ValuePrinter.printValues("(", IndicativeSentencesGeneration.DEFAULT_SEPARATOR, ");", applyPrintSettings(list, printSettings));
    }
}
