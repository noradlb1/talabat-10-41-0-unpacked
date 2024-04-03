package org.mockito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.mockito.internal.matchers.Any;
import org.mockito.internal.matchers.Contains;
import org.mockito.internal.matchers.EndsWith;
import org.mockito.internal.matchers.Equals;
import org.mockito.internal.matchers.InstanceOf;
import org.mockito.internal.matchers.Matches;
import org.mockito.internal.matchers.NotNull;
import org.mockito.internal.matchers.Null;
import org.mockito.internal.matchers.Same;
import org.mockito.internal.matchers.StartsWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.internal.progress.ThreadSafeMockingProgress;
import org.mockito.internal.util.Primitives;

@CheckReturnValue
public class ArgumentMatchers {
    public static <T> T any() {
        reportMatcher(Any.ANY);
        return null;
    }

    public static boolean anyBoolean() {
        reportMatcher(new InstanceOf(Boolean.class, "<any boolean>"));
        return false;
    }

    public static byte anyByte() {
        reportMatcher(new InstanceOf(Byte.class, "<any byte>"));
        return 0;
    }

    public static char anyChar() {
        reportMatcher(new InstanceOf(Character.class, "<any char>"));
        return 0;
    }

    public static <T> Collection<T> anyCollection() {
        reportMatcher(new InstanceOf(Collection.class, "<any collection>"));
        return new ArrayList(0);
    }

    public static double anyDouble() {
        reportMatcher(new InstanceOf(Double.class, "<any double>"));
        return 0.0d;
    }

    public static float anyFloat() {
        reportMatcher(new InstanceOf(Float.class, "<any float>"));
        return 0.0f;
    }

    public static int anyInt() {
        reportMatcher(new InstanceOf(Integer.class, "<any integer>"));
        return 0;
    }

    public static <T> Iterable<T> anyIterable() {
        reportMatcher(new InstanceOf(Iterable.class, "<any iterable>"));
        return new ArrayList(0);
    }

    public static <T> List<T> anyList() {
        reportMatcher(new InstanceOf(List.class, "<any List>"));
        return new ArrayList(0);
    }

    public static long anyLong() {
        reportMatcher(new InstanceOf(Long.class, "<any long>"));
        return 0;
    }

    public static <K, V> Map<K, V> anyMap() {
        reportMatcher(new InstanceOf(Map.class, "<any map>"));
        return new HashMap(0);
    }

    public static <T> Set<T> anySet() {
        reportMatcher(new InstanceOf(Set.class, "<any set>"));
        return new HashSet(0);
    }

    public static short anyShort() {
        reportMatcher(new InstanceOf(Short.class, "<any short>"));
        return 0;
    }

    public static String anyString() {
        reportMatcher(new InstanceOf(String.class, "<any string>"));
        return "";
    }

    public static <T> T argThat(ArgumentMatcher<T> argumentMatcher) {
        reportMatcher(argumentMatcher);
        return null;
    }

    public static boolean booleanThat(ArgumentMatcher<Boolean> argumentMatcher) {
        reportMatcher(argumentMatcher);
        return false;
    }

    public static byte byteThat(ArgumentMatcher<Byte> argumentMatcher) {
        reportMatcher(argumentMatcher);
        return 0;
    }

    public static char charThat(ArgumentMatcher<Character> argumentMatcher) {
        reportMatcher(argumentMatcher);
        return 0;
    }

    public static String contains(String str) {
        reportMatcher(new Contains(str));
        return "";
    }

    public static double doubleThat(ArgumentMatcher<Double> argumentMatcher) {
        reportMatcher(argumentMatcher);
        return 0.0d;
    }

    public static String endsWith(String str) {
        reportMatcher(new EndsWith(str));
        return "";
    }

    public static boolean eq(boolean z11) {
        reportMatcher(new Equals(Boolean.valueOf(z11)));
        return false;
    }

    public static float floatThat(ArgumentMatcher<Float> argumentMatcher) {
        reportMatcher(argumentMatcher);
        return 0.0f;
    }

    public static int intThat(ArgumentMatcher<Integer> argumentMatcher) {
        reportMatcher(argumentMatcher);
        return 0;
    }

    public static <T> T isA(Class<T> cls) {
        reportMatcher(new InstanceOf(cls));
        return Primitives.defaultValue(cls);
    }

    public static <T> T isNotNull() {
        return notNull();
    }

    public static <T> T isNull() {
        reportMatcher(Null.NULL);
        return null;
    }

    public static long longThat(ArgumentMatcher<Long> argumentMatcher) {
        reportMatcher(argumentMatcher);
        return 0;
    }

    public static String matches(String str) {
        reportMatcher(new Matches(str));
        return "";
    }

    public static <T> T notNull() {
        reportMatcher(NotNull.NOT_NULL);
        return null;
    }

    public static <T> T nullable(Class<T> cls) {
        AdditionalMatchers.or(isNull(), isA(cls));
        return Primitives.defaultValue(cls);
    }

    public static <T> T refEq(T t11, String... strArr) {
        reportMatcher(new ReflectionEquals(t11, strArr));
        return null;
    }

    private static void reportMatcher(ArgumentMatcher<?> argumentMatcher) {
        ThreadSafeMockingProgress.mockingProgress().getArgumentMatcherStorage().reportMatcher(argumentMatcher);
    }

    public static <T> T same(T t11) {
        reportMatcher(new Same(t11));
        if (t11 == null) {
            return null;
        }
        return Primitives.defaultValue(t11.getClass());
    }

    public static short shortThat(ArgumentMatcher<Short> argumentMatcher) {
        reportMatcher(argumentMatcher);
        return 0;
    }

    public static String startsWith(String str) {
        reportMatcher(new StartsWith(str));
        return "";
    }

    public static <T> T any(Class<T> cls) {
        reportMatcher(new InstanceOf.VarArgAware(cls, "<any " + cls.getCanonicalName() + ">"));
        return Primitives.defaultValue(cls);
    }

    public static byte eq(byte b11) {
        reportMatcher(new Equals(Byte.valueOf(b11)));
        return 0;
    }

    public static String matches(Pattern pattern) {
        reportMatcher(new Matches(pattern));
        return "";
    }

    public static char eq(char c11) {
        reportMatcher(new Equals(Character.valueOf(c11)));
        return 0;
    }

    public static double eq(double d11) {
        reportMatcher(new Equals(Double.valueOf(d11)));
        return 0.0d;
    }

    public static float eq(float f11) {
        reportMatcher(new Equals(Float.valueOf(f11)));
        return 0.0f;
    }

    public static int eq(int i11) {
        reportMatcher(new Equals(Integer.valueOf(i11)));
        return 0;
    }

    public static long eq(long j11) {
        reportMatcher(new Equals(Long.valueOf(j11)));
        return 0;
    }

    public static short eq(short s11) {
        reportMatcher(new Equals(Short.valueOf(s11)));
        return 0;
    }

    public static <T> T eq(T t11) {
        reportMatcher(new Equals(t11));
        if (t11 == null) {
            return null;
        }
        return Primitives.defaultValue(t11.getClass());
    }
}
