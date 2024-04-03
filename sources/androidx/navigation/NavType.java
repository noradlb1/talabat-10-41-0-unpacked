package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.pool.TypePool;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0006\u0019\u001a\u001b\u001c\u001d\u001eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH¦\u0002¢\u0006\u0002\u0010\u000fJ%\u0010\u0010\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\bH&¢\u0006\u0002\u0010\u0014J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, d2 = {"Landroidx/navigation/NavType;", "T", "", "isNullableAllowed", "", "(Z)V", "()Z", "name", "", "getName", "()Ljava/lang/String;", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "parseAndPut", "value", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "parseValue", "(Ljava/lang/String;)Ljava/lang/Object;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "toString", "Companion", "EnumType", "ParcelableArrayType", "ParcelableType", "SerializableArrayType", "SerializableType", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class NavType<T> {
    @NotNull
    @JvmField
    public static final NavType<boolean[]> BoolArrayType = new NavType$Companion$BoolArrayType$1();
    @NotNull
    @JvmField
    public static final NavType<Boolean> BoolType = new NavType$Companion$BoolType$1();
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final NavType<float[]> FloatArrayType = new NavType$Companion$FloatArrayType$1();
    @NotNull
    @JvmField
    public static final NavType<Float> FloatType = new NavType$Companion$FloatType$1();
    @NotNull
    @JvmField
    public static final NavType<int[]> IntArrayType = new NavType$Companion$IntArrayType$1();
    @NotNull
    @JvmField
    public static final NavType<Integer> IntType = new NavType$Companion$IntType$1();
    @NotNull
    @JvmField
    public static final NavType<long[]> LongArrayType = new NavType$Companion$LongArrayType$1();
    @NotNull
    @JvmField
    public static final NavType<Long> LongType = new NavType$Companion$LongType$1();
    @NotNull
    @JvmField
    public static final NavType<Integer> ReferenceType = new NavType$Companion$ReferenceType$1();
    @NotNull
    @JvmField
    public static final NavType<String[]> StringArrayType = new NavType$Companion$StringArrayType$1();
    @NotNull
    @JvmField
    public static final NavType<String> StringType = new NavType$Companion$StringType$1();
    private final boolean isNullableAllowed;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f36356name = "nav_type";

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0017J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u0017H\u0007J\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0007R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00160\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/navigation/NavType$Companion;", "", "()V", "BoolArrayType", "Landroidx/navigation/NavType;", "", "BoolType", "", "FloatArrayType", "", "FloatType", "", "IntArrayType", "", "IntType", "", "LongArrayType", "", "LongType", "", "ReferenceType", "StringArrayType", "", "", "StringType", "fromArgType", "type", "packageName", "inferFromValue", "value", "inferFromValueType", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public NavType<?> fromArgType(@Nullable String str, @Nullable String str2) {
            boolean z11;
            String str3;
            NavType<Integer> navType = NavType.IntType;
            if (Intrinsics.areEqual((Object) navType.getName(), (Object) str)) {
                return navType;
            }
            NavType<int[]> navType2 = NavType.IntArrayType;
            if (Intrinsics.areEqual((Object) navType2.getName(), (Object) str)) {
                return navType2;
            }
            NavType<Long> navType3 = NavType.LongType;
            if (Intrinsics.areEqual((Object) navType3.getName(), (Object) str)) {
                return navType3;
            }
            NavType<long[]> navType4 = NavType.LongArrayType;
            if (Intrinsics.areEqual((Object) navType4.getName(), (Object) str)) {
                return navType4;
            }
            NavType<Boolean> navType5 = NavType.BoolType;
            if (Intrinsics.areEqual((Object) navType5.getName(), (Object) str)) {
                return navType5;
            }
            NavType<boolean[]> navType6 = NavType.BoolArrayType;
            if (Intrinsics.areEqual((Object) navType6.getName(), (Object) str)) {
                return navType6;
            }
            NavType<String> navType7 = NavType.StringType;
            if (Intrinsics.areEqual((Object) navType7.getName(), (Object) str)) {
                return navType7;
            }
            NavType<String[]> navType8 = NavType.StringArrayType;
            if (Intrinsics.areEqual((Object) navType8.getName(), (Object) str)) {
                return navType8;
            }
            NavType<Float> navType9 = NavType.FloatType;
            if (Intrinsics.areEqual((Object) navType9.getName(), (Object) str)) {
                return navType9;
            }
            NavType<float[]> navType10 = NavType.FloatArrayType;
            if (Intrinsics.areEqual((Object) navType10.getName(), (Object) str)) {
                return navType10;
            }
            NavType<Integer> navType11 = NavType.ReferenceType;
            if (Intrinsics.areEqual((Object) navType11.getName(), (Object) str)) {
                return navType11;
            }
            if (str == null || str.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return navType7;
            }
            try {
                if (!StringsKt__StringsJVMKt.startsWith$default(str, RealDiscoveryConfigurationRepository.VERSION_DELIMETER, false, 2, (Object) null) || str2 == null) {
                    str3 = str;
                } else {
                    str3 = str2 + str;
                }
                Class<Serializable> cls = Serializable.class;
                Class<Parcelable> cls2 = Parcelable.class;
                if (StringsKt__StringsJVMKt.endsWith$default(str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, false, 2, (Object) null)) {
                    str3 = str3.substring(0, str3.length() - 2);
                    Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String…ing(startIndex, endIndex)");
                    Class<?> cls3 = Class.forName(str3);
                    if (cls2.isAssignableFrom(cls3)) {
                        return new ParcelableArrayType(cls3);
                    }
                    if (cls.isAssignableFrom(cls3)) {
                        return new SerializableArrayType(cls3);
                    }
                } else {
                    Class<?> cls4 = Class.forName(str3);
                    if (cls2.isAssignableFrom(cls4)) {
                        return new ParcelableType(cls4);
                    }
                    if (Enum.class.isAssignableFrom(cls4)) {
                        return new EnumType(cls4);
                    }
                    if (cls.isAssignableFrom(cls4)) {
                        return new SerializableType(cls4);
                    }
                }
                throw new IllegalArgumentException(str3 + " is not Serializable or Parcelable.");
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException(e11);
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:10|11|12) */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r0 = androidx.navigation.NavType.BoolType;
            r0.parseValue(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
            return androidx.navigation.NavType.StringType;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
            r0 = androidx.navigation.NavType.LongType;
            r0.parseValue(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
            r0 = androidx.navigation.NavType.FloatType;
            r0.parseValue(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            return r0;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0018 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0012 */
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.navigation.NavType<java.lang.Object> inferFromValue(@org.jetbrains.annotations.NotNull java.lang.String r2) {
            /*
                r1 = this;
                java.lang.String r0 = "value"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                androidx.navigation.NavType<java.lang.Integer> r0 = androidx.navigation.NavType.IntType     // Catch:{ IllegalArgumentException -> 0x000c }
                r0.parseValue(r2)     // Catch:{ IllegalArgumentException -> 0x000c }
                return r0
            L_0x000c:
                androidx.navigation.NavType<java.lang.Long> r0 = androidx.navigation.NavType.LongType     // Catch:{ IllegalArgumentException -> 0x0012 }
                r0.parseValue(r2)     // Catch:{ IllegalArgumentException -> 0x0012 }
                return r0
            L_0x0012:
                androidx.navigation.NavType<java.lang.Float> r0 = androidx.navigation.NavType.FloatType     // Catch:{ IllegalArgumentException -> 0x0018 }
                r0.parseValue(r2)     // Catch:{ IllegalArgumentException -> 0x0018 }
                return r0
            L_0x0018:
                androidx.navigation.NavType<java.lang.Boolean> r0 = androidx.navigation.NavType.BoolType     // Catch:{ IllegalArgumentException -> 0x001e }
                r0.parseValue(r2)     // Catch:{ IllegalArgumentException -> 0x001e }
                return r0
            L_0x001e:
                androidx.navigation.NavType<java.lang.String> r2 = androidx.navigation.NavType.StringType
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType.Companion.inferFromValue(java.lang.String):androidx.navigation.NavType");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @JvmStatic
        @NotNull
        public final NavType<Object> inferFromValueType(@Nullable Object obj) {
            NavType<Object> navType;
            if (obj instanceof Integer) {
                return NavType.IntType;
            }
            if (obj instanceof int[]) {
                return NavType.IntArrayType;
            }
            if (obj instanceof Long) {
                return NavType.LongType;
            }
            if (obj instanceof long[]) {
                return NavType.LongArrayType;
            }
            if (obj instanceof Float) {
                return NavType.FloatType;
            }
            if (obj instanceof float[]) {
                return NavType.FloatArrayType;
            }
            if (obj instanceof Boolean) {
                return NavType.BoolType;
            }
            if (obj instanceof boolean[]) {
                return NavType.BoolArrayType;
            }
            if ((obj instanceof String) || obj == null) {
                return NavType.StringType;
            }
            if ((obj instanceof Object[]) && (((Object[]) obj) instanceof String[])) {
                return NavType.StringArrayType;
            }
            if (obj.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                Intrinsics.checkNotNull(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    Class<?> componentType2 = obj.getClass().getComponentType();
                    if (componentType2 != null) {
                        navType = new ParcelableArrayType<>(componentType2);
                        return navType;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                }
            }
            if (obj.getClass().isArray()) {
                Class<?> componentType3 = obj.getClass().getComponentType();
                Intrinsics.checkNotNull(componentType3);
                if (Serializable.class.isAssignableFrom(componentType3)) {
                    Class<?> componentType4 = obj.getClass().getComponentType();
                    if (componentType4 != null) {
                        navType = new SerializableArrayType<>(componentType4);
                        return navType;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                }
            }
            if (obj instanceof Parcelable) {
                navType = new ParcelableType<>(obj.getClass());
            } else if (obj instanceof Enum) {
                navType = new EnumType<>(obj.getClass());
            } else if (obj instanceof Serializable) {
                navType = new SerializableType<>(obj.getClass());
            } else {
                throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
            }
            return navType;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00040\u0003B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u001dR\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavType$ParcelableArrayType;", "D", "Landroid/os/Parcelable;", "Landroidx/navigation/NavType;", "", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "arrayType", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Parcelable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)[Landroid/os/Parcelable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {
        @NotNull
        private final Class<D[]> arrayType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ParcelableArrayType(@NotNull Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    this.arrayType = Class.forName("[L" + cls.getName() + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
                } catch (ClassNotFoundException e11) {
                    throw new RuntimeException(e11);
                }
            } else {
                throw new IllegalArgumentException((cls + " does not implement Parcelable.").toString());
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual((Object) ParcelableArrayType.class, (Object) obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.arrayType, (Object) ((ParcelableArrayType) obj).arrayType);
        }

        @NotNull
        public String getName() {
            String name2 = this.arrayType.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "arrayType.name");
            return name2;
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }

        @Nullable
        public D[] get(@NotNull Bundle bundle, @NotNull String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            return (Parcelable[]) bundle.get(str);
        }

        @NotNull
        public D[] parseValue(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public void put(@NotNull Bundle bundle, @NotNull String str, @Nullable D[] dArr) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            this.arrayType.cast(dArr);
            bundle.putParcelableArray(str, dArr);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J \u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0015\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/navigation/NavType$ParcelableType;", "D", "Landroidx/navigation/NavType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Object;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ParcelableType<D> extends NavType<D> {
        @NotNull
        private final Class<D> type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ParcelableType(@NotNull Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "type");
            boolean z11 = true;
            if (!Parcelable.class.isAssignableFrom(cls) && !Serializable.class.isAssignableFrom(cls)) {
                z11 = false;
            }
            if (z11) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Parcelable or Serializable.").toString());
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual((Object) ParcelableType.class, (Object) obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.type, (Object) ((ParcelableType) obj).type);
        }

        @Nullable
        public D get(@NotNull Bundle bundle, @NotNull String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            return bundle.get(str);
        }

        @NotNull
        public String getName() {
            String name2 = this.type.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "type.name");
            return name2;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        public D parseValue(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public void put(@NotNull Bundle bundle, @NotNull String str, D d11) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            this.type.cast(d11);
            if (d11 == null || (d11 instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) d11);
            } else if (d11 instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) d11);
            }
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00040\u0003B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u001dR\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavType$SerializableArrayType;", "D", "Ljava/io/Serializable;", "Landroidx/navigation/NavType;", "", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "arrayType", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/io/Serializable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)[Ljava/io/Serializable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/io/Serializable;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {
        @NotNull
        private final Class<D[]> arrayType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableArrayType(@NotNull Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    this.arrayType = Class.forName("[L" + cls.getName() + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
                } catch (ClassNotFoundException e11) {
                    throw new RuntimeException(e11);
                }
            } else {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual((Object) SerializableArrayType.class, (Object) obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.arrayType, (Object) ((SerializableArrayType) obj).arrayType);
        }

        @NotNull
        public String getName() {
            String name2 = this.arrayType.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "arrayType.name");
            return name2;
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }

        @Nullable
        public D[] get(@NotNull Bundle bundle, @NotNull String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            return (Serializable[]) bundle.get(str);
        }

        @NotNull
        public D[] parseValue(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [D[], java.lang.Object, java.io.Serializable] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void put(@org.jetbrains.annotations.NotNull android.os.Bundle r2, @org.jetbrains.annotations.NotNull java.lang.String r3, @org.jetbrains.annotations.Nullable D[] r4) {
            /*
                r1 = this;
                java.lang.String r0 = "bundle"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "key"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.Class<D[]> r0 = r1.arrayType
                r0.cast(r4)
                r2.putSerializable(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType.SerializableArrayType.put(android.os.Bundle, java.lang.String, java.io.Serializable[]):void");
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001d\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J \u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0015\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001dR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/navigation/NavType$SerializableType;", "D", "Ljava/io/Serializable;", "Landroidx/navigation/NavType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "nullableAllowed", "", "(ZLjava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "equals", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)Ljava/io/Serializable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/io/Serializable;)V", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class SerializableType<D extends Serializable> extends NavType<D> {
        @NotNull
        private final Class<D> type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableType(@NotNull Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            } else if (true ^ cls.isEnum()) {
                this.type = cls;
            } else {
                throw new IllegalArgumentException((cls + " is an Enum. You should use EnumType instead.").toString());
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableType)) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.type, (Object) ((SerializableType) obj).type);
        }

        @NotNull
        public String getName() {
            String name2 = this.type.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "type.name");
            return name2;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        @Nullable
        public D get(@NotNull Bundle bundle, @NotNull String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            return (Serializable) bundle.get(str);
        }

        @NotNull
        public D parseValue(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public void put(@NotNull Bundle bundle, @NotNull String str, @NotNull D d11) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(d11, "value");
            this.type.cast(d11);
            bundle.putSerializable(str, d11);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableType(boolean z11, @NotNull Class<D> cls) {
            super(z11);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (Serializable.class.isAssignableFrom(cls)) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
        }
    }

    public NavType(boolean z11) {
        this.isNullableAllowed = z11;
    }

    @JvmStatic
    @NotNull
    public static NavType<?> fromArgType(@Nullable String str, @Nullable String str2) {
        return Companion.fromArgType(str, str2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @JvmStatic
    @NotNull
    public static final NavType<Object> inferFromValue(@NotNull String str) {
        return Companion.inferFromValue(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @JvmStatic
    @NotNull
    public static final NavType<Object> inferFromValueType(@Nullable Object obj) {
        return Companion.inferFromValueType(obj);
    }

    @Nullable
    public abstract T get(@NotNull Bundle bundle, @NotNull String str);

    @NotNull
    public String getName() {
        return this.f36356name;
    }

    public boolean isNullableAllowed() {
        return this.isNullableAllowed;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final T parseAndPut(@NotNull Bundle bundle, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        T parseValue = parseValue(str2);
        put(bundle, str, parseValue);
        return parseValue;
    }

    public abstract T parseValue(@NotNull String str);

    public abstract void put(@NotNull Bundle bundle, @NotNull String str, T t11);

    @NotNull
    public String toString() {
        return getName();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\f\b\u0001\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\rR\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/navigation/NavType$EnumType;", "D", "", "Landroidx/navigation/NavType$SerializableType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Enum;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class EnumType<D extends Enum<?>> extends SerializableType<D> {
        @NotNull
        private final Class<D> type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EnumType(@NotNull Class<D> cls) {
            super(false, cls);
            Intrinsics.checkNotNullParameter(cls, "type");
            if (cls.isEnum()) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " is not an Enum type.").toString());
        }

        @NotNull
        public String getName() {
            String name2 = this.type.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "type.name");
            return name2;
        }

        @NotNull
        public D parseValue(@NotNull String str) {
            D d11;
            Intrinsics.checkNotNullParameter(str, "value");
            D[] enumConstants = this.type.getEnumConstants();
            Intrinsics.checkNotNullExpressionValue(enumConstants, "type.enumConstants");
            int length = enumConstants.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    d11 = null;
                    break;
                }
                d11 = enumConstants[i11];
                if (StringsKt__StringsJVMKt.equals(((Enum) d11).name(), str, true)) {
                    break;
                }
                i11++;
            }
            D d12 = (Enum) d11;
            if (d12 != null) {
                return d12;
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.type.getName() + '.');
        }
    }
}
