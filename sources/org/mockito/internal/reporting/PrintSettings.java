package org.mockito.internal.reporting;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.mockito.ArgumentMatcher;
import org.mockito.internal.matchers.text.MatchersPrinter;
import org.mockito.internal.util.MockUtil;
import org.mockito.invocation.Invocation;
import org.mockito.invocation.MatchableInvocation;

public class PrintSettings {
    public static final int MAX_LINE_LENGTH = 45;
    private boolean multiline;
    private Set<String> withFullyQualifiedName = Collections.emptySet();
    private List<Integer> withTypeInfo = new LinkedList();

    public static PrintSettings verboseMatchers(Integer... numArr) {
        PrintSettings printSettings = new PrintSettings();
        printSettings.setMatchersToBeDescribedWithExtraTypeInfo(numArr);
        return printSettings;
    }

    public boolean extraTypeInfoFor(int i11) {
        return this.withTypeInfo.contains(Integer.valueOf(i11));
    }

    public boolean fullyQualifiedNameFor(String str) {
        return this.withFullyQualifiedName.contains(str);
    }

    public boolean isMultiline() {
        return this.multiline;
    }

    public String print(List<ArgumentMatcher> list, Invocation invocation) {
        MatchersPrinter matchersPrinter = new MatchersPrinter();
        String str = MockUtil.getMockName(invocation.getMock()) + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + invocation.getMethod().getName();
        String str2 = str + matchersPrinter.getArgumentsLine(list, this);
        if (!isMultiline() && (list.isEmpty() || str2.length() <= 45)) {
            return str2;
        }
        return str + matchersPrinter.getArgumentsBlock(list, this);
    }

    public void setMatchersToBeDescribedWithExtraTypeInfo(Integer[] numArr) {
        this.withTypeInfo = Arrays.asList(numArr);
    }

    public void setMatchersToBeDescribedWithFullName(Set<String> set) {
        this.withFullyQualifiedName = set;
    }

    public void setMultiline(boolean z11) {
        this.multiline = z11;
    }

    public String print(Invocation invocation) {
        return print(invocation.getArgumentsAsMatchers(), invocation);
    }

    public String print(MatchableInvocation matchableInvocation) {
        return print(matchableInvocation.getMatchers(), matchableInvocation.getInvocation());
    }
}
