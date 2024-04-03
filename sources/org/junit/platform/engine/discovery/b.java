package org.junit.platform.engine.discovery;

public final /* synthetic */ class b {
    public static ClassNameFilter a(String... strArr) {
        return new ExcludeClassNameFilter(strArr);
    }

    public static ClassNameFilter b(String... strArr) {
        return new IncludeClassNameFilter(strArr);
    }
}
