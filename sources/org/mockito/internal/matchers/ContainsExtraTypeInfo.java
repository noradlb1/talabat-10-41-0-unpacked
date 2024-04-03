package org.mockito.internal.matchers;

public interface ContainsExtraTypeInfo {
    Object getWanted();

    String toStringWithType(String str);

    boolean typeMatches(Object obj);
}
