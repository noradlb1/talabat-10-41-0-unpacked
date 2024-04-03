package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BinaryVersion {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int major;
    private final int minor;
    @NotNull
    private final int[] numbers;
    private final int patch;
    @NotNull
    private final List<Integer> rest;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BinaryVersion(@NotNull int... iArr) {
        int i11;
        int i12;
        List<Integer> list;
        Intrinsics.checkNotNullParameter(iArr, "numbers");
        this.numbers = iArr;
        Integer orNull = ArraysKt___ArraysKt.getOrNull(iArr, 0);
        int i13 = -1;
        if (orNull != null) {
            i11 = orNull.intValue();
        } else {
            i11 = -1;
        }
        this.major = i11;
        Integer orNull2 = ArraysKt___ArraysKt.getOrNull(iArr, 1);
        if (orNull2 != null) {
            i12 = orNull2.intValue();
        } else {
            i12 = -1;
        }
        this.minor = i12;
        Integer orNull3 = ArraysKt___ArraysKt.getOrNull(iArr, 2);
        this.patch = orNull3 != null ? orNull3.intValue() : i13;
        if (iArr.length <= 3) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else if (iArr.length <= 1024) {
            list = CollectionsKt___CollectionsKt.toList(ArraysKt___ArraysJvmKt.asList(iArr).subList(3, iArr.length));
        } else {
            throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + iArr.length + '.');
        }
        this.rest = list;
    }

    public final boolean a(@NotNull BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(binaryVersion, "ourVersion");
        int i11 = this.major;
        if (i11 == 0) {
            if (binaryVersion.major == 0 && this.minor == binaryVersion.minor) {
                return true;
            }
        } else if (i11 == binaryVersion.major && this.minor <= binaryVersion.minor) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != null && Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            BinaryVersion binaryVersion = (BinaryVersion) obj;
            if (this.major == binaryVersion.major && this.minor == binaryVersion.minor && this.patch == binaryVersion.patch && Intrinsics.areEqual((Object) this.rest, (Object) binaryVersion.rest)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public int hashCode() {
        int i11 = this.major;
        int i12 = i11 + (i11 * 31) + this.minor;
        int i13 = i12 + (i12 * 31) + this.patch;
        return i13 + (i13 * 31) + this.rest.hashCode();
    }

    public final boolean isAtLeast(@NotNull BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(binaryVersion, "version");
        return isAtLeast(binaryVersion.major, binaryVersion.minor, binaryVersion.patch);
    }

    public final boolean isAtMost(int i11, int i12, int i13) {
        int i14 = this.major;
        if (i14 < i11) {
            return true;
        }
        if (i14 > i11) {
            return false;
        }
        int i15 = this.minor;
        if (i15 < i12) {
            return true;
        }
        if (i15 > i12) {
            return false;
        }
        if (this.patch <= i13) {
            return true;
        }
        return false;
    }

    @NotNull
    public final int[] toArray() {
        return this.numbers;
    }

    @NotNull
    public String toString() {
        boolean z11;
        int[] array = toArray();
        ArrayList arrayList = new ArrayList();
        for (int i11 : array) {
            if (i11 != -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                break;
            }
            arrayList.add(Integer.valueOf(i11));
        }
        if (arrayList.isEmpty()) {
            return "unknown";
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList, RealDiscoveryConfigurationRepository.VERSION_DELIMETER, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final boolean isAtLeast(int i11, int i12, int i13) {
        int i14 = this.major;
        if (i14 > i11) {
            return true;
        }
        if (i14 < i11) {
            return false;
        }
        int i15 = this.minor;
        if (i15 > i12) {
            return true;
        }
        if (i15 < i12) {
            return false;
        }
        if (this.patch >= i13) {
            return true;
        }
        return false;
    }
}
