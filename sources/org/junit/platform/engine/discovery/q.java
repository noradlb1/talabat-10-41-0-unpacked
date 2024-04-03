package org.junit.platform.engine.discovery;

import java.util.List;

public final /* synthetic */ class q {
    public static PackageNameFilter a(List<String> list) {
        return b((String[]) list.toArray(new String[0]));
    }

    public static PackageNameFilter b(String... strArr) {
        return new ExcludePackageNameFilter(strArr);
    }

    public static PackageNameFilter c(List<String> list) {
        return d((String[]) list.toArray(new String[0]));
    }

    public static PackageNameFilter d(String... strArr) {
        return new IncludePackageNameFilter(strArr);
    }
}
