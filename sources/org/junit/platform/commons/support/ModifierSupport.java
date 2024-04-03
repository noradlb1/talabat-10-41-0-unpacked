package org.junit.platform.commons.support;

import java.lang.reflect.Member;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ReflectionUtils;

@API(since = "1.4", status = API.Status.MAINTAINED)
public final class ModifierSupport {
    private ModifierSupport() {
    }

    public static boolean isAbstract(Class<?> cls) {
        return ReflectionUtils.isAbstract(cls);
    }

    @API(since = "1.5", status = API.Status.MAINTAINED)
    public static boolean isFinal(Class<?> cls) {
        return ReflectionUtils.isFinal(cls);
    }

    @API(since = "1.5", status = API.Status.MAINTAINED)
    public static boolean isNotFinal(Class<?> cls) {
        return ReflectionUtils.isNotFinal(cls);
    }

    public static boolean isNotPrivate(Class<?> cls) {
        return ReflectionUtils.isNotPrivate(cls);
    }

    public static boolean isNotStatic(Class<?> cls) {
        return ReflectionUtils.isNotStatic(cls);
    }

    public static boolean isPrivate(Class<?> cls) {
        return ReflectionUtils.isPrivate(cls);
    }

    public static boolean isPublic(Class<?> cls) {
        return ReflectionUtils.isPublic(cls);
    }

    public static boolean isStatic(Class<?> cls) {
        return ReflectionUtils.isStatic(cls);
    }

    public static boolean isAbstract(Member member) {
        return ReflectionUtils.isAbstract(member);
    }

    @API(since = "1.5", status = API.Status.MAINTAINED)
    public static boolean isFinal(Member member) {
        return ReflectionUtils.isFinal(member);
    }

    @API(since = "1.5", status = API.Status.MAINTAINED)
    public static boolean isNotFinal(Member member) {
        return ReflectionUtils.isNotFinal(member);
    }

    public static boolean isNotPrivate(Member member) {
        return ReflectionUtils.isNotPrivate(member);
    }

    public static boolean isNotStatic(Member member) {
        return ReflectionUtils.isNotStatic(member);
    }

    public static boolean isPrivate(Member member) {
        return ReflectionUtils.isPrivate(member);
    }

    public static boolean isPublic(Member member) {
        return ReflectionUtils.isPublic(member);
    }

    public static boolean isStatic(Member member) {
        return ReflectionUtils.isStatic(member);
    }
}
