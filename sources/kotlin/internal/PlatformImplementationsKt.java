package kotlin.internal;

import com.facebook.internal.NativeProtocol;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.internal.jdk8.JDK8PlatformImplementations;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\b¢\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PlatformImplementationsKt {
    @NotNull
    @JvmField
    public static final PlatformImplementations IMPLEMENTATIONS;

    static {
        PlatformImplementations platformImplementations;
        JDK7PlatformImplementations newInstance;
        JDK8PlatformImplementations newInstance2;
        int javaVersion = getJavaVersion();
        Class<PlatformImplementations> cls = PlatformImplementations.class;
        if (javaVersion >= 65544 || javaVersion < 65536) {
            try {
                newInstance2 = JDK8PlatformImplementations.class.newInstance();
                Intrinsics.checkNotNullExpressionValue(newInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                if (newInstance2 != null) {
                    platformImplementations = newInstance2;
                    IMPLEMENTATIONS = platformImplementations;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            } catch (ClassCastException e11) {
                ClassLoader classLoader = newInstance2.getClass().getClassLoader();
                ClassLoader classLoader2 = cls.getClassLoader();
                if (!Intrinsics.areEqual((Object) classLoader, (Object) classLoader2)) {
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e11);
                }
                throw e11;
            } catch (ClassNotFoundException unused) {
                try {
                    Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    Intrinsics.checkNotNullExpressionValue(newInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                    if (newInstance3 != null) {
                        try {
                            platformImplementations = (PlatformImplementations) newInstance3;
                        } catch (ClassCastException e12) {
                            ClassLoader classLoader3 = newInstance3.getClass().getClassLoader();
                            ClassLoader classLoader4 = cls.getClassLoader();
                            if (!Intrinsics.areEqual((Object) classLoader3, (Object) classLoader4)) {
                                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e12);
                            }
                            throw e12;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassNotFoundException unused2) {
                }
            }
        }
        if (javaVersion >= 65543 || javaVersion < 65536) {
            try {
                newInstance = JDK7PlatformImplementations.class.newInstance();
                Intrinsics.checkNotNullExpressionValue(newInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                if (newInstance != null) {
                    platformImplementations = newInstance;
                    IMPLEMENTATIONS = platformImplementations;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            } catch (ClassCastException e13) {
                ClassLoader classLoader5 = newInstance.getClass().getClassLoader();
                ClassLoader classLoader6 = cls.getClassLoader();
                if (!Intrinsics.areEqual((Object) classLoader5, (Object) classLoader6)) {
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e13);
                }
                throw e13;
            } catch (ClassNotFoundException unused3) {
                try {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    Intrinsics.checkNotNullExpressionValue(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                    if (newInstance4 != null) {
                        try {
                            platformImplementations = (PlatformImplementations) newInstance4;
                        } catch (ClassCastException e14) {
                            ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                            ClassLoader classLoader8 = cls.getClassLoader();
                            if (!Intrinsics.areEqual((Object) classLoader7, (Object) classLoader8)) {
                                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e14);
                            }
                            throw e14;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                } catch (ClassNotFoundException unused4) {
                }
            }
        }
        platformImplementations = new PlatformImplementations();
        IMPLEMENTATIONS = platformImplementations;
    }

    @SinceKotlin(version = "1.2")
    @PublishedApi
    public static final boolean apiVersionIsAtLeast(int i11, int i12, int i13) {
        return KotlinVersion.CURRENT.isAtLeast(i11, i12, i13);
    }

    @InlineOnly
    private static final /* synthetic */ <T> T castToBaseType(Object obj) {
        try {
            Intrinsics.reifiedOperationMarker(1, "T");
            return obj;
        } catch (ClassCastException e11) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            Intrinsics.reifiedOperationMarker(4, "T");
            ClassLoader classLoader2 = Object.class.getClassLoader();
            if (!Intrinsics.areEqual((Object) classLoader, (Object) classLoader2)) {
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e11);
            }
            throw e11;
        }
    }

    private static final int getJavaVersion() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
        }
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) property, '.', 0, false, 6, (Object) null);
        if (indexOf$default < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
            }
        } else {
            int i11 = indexOf$default + 1;
            int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) property, '.', i11, false, 4, (Object) null);
            if (indexOf$default2 < 0) {
                indexOf$default2 = property.length();
            }
            String substring = property.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String substring2 = property.substring(i11, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            try {
                return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
            } catch (NumberFormatException unused2) {
                return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
            }
        }
    }
}
