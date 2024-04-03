package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinClassHeader {
    @Nullable
    private final String[] data;
    private final int extraInt;
    @Nullable
    private final String extraString;
    @Nullable
    private final String[] incompatibleData;
    @NotNull
    private final Kind kind;
    @NotNull
    private final JvmMetadataVersion metadataVersion;
    @Nullable
    private final String packageName;
    @Nullable
    private final byte[] serializedIr;
    @Nullable
    private final String[] strings;

    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        @NotNull
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        @NotNull
        public static final Map<Integer, Kind> entryById = null;

        /* renamed from: id  reason: collision with root package name */
        private final int f24732id;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @NotNull
            public final Kind getById(int i11) {
                Kind kind = (Kind) Kind.entryById.get(Integer.valueOf(i11));
                return kind == null ? Kind.UNKNOWN : kind;
            }
        }

        /* access modifiers changed from: public */
        static {
            int i11;
            Companion = new Companion((DefaultConstructorMarker) null);
            Kind[] values = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(values.length), 16));
            for (Kind kind : values) {
                linkedHashMap.put(Integer.valueOf(kind.f24732id), kind);
            }
            entryById = linkedHashMap;
        }

        private Kind(int i11) {
            this.f24732id = i11;
        }

        @JvmStatic
        @NotNull
        public static final Kind getById(int i11) {
            return Companion.getById(i11);
        }
    }

    public KotlinClassHeader(@NotNull Kind kind2, @NotNull JvmMetadataVersion jvmMetadataVersion, @Nullable String[] strArr, @Nullable String[] strArr2, @Nullable String[] strArr3, @Nullable String str, int i11, @Nullable String str2, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(kind2, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(jvmMetadataVersion, "metadataVersion");
        this.kind = kind2;
        this.metadataVersion = jvmMetadataVersion;
        this.data = strArr;
        this.incompatibleData = strArr2;
        this.strings = strArr3;
        this.extraString = str;
        this.extraInt = i11;
        this.packageName = str2;
        this.serializedIr = bArr;
    }

    private final boolean has(int i11, int i12) {
        return (i11 & i12) != 0;
    }

    @Nullable
    public final String[] getData() {
        return this.data;
    }

    @Nullable
    public final String[] getIncompatibleData() {
        return this.incompatibleData;
    }

    @NotNull
    public final Kind getKind() {
        return this.kind;
    }

    @NotNull
    public final JvmMetadataVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    @Nullable
    public final String getMultifileClassName() {
        String str = this.extraString;
        if (this.kind == Kind.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    @NotNull
    public final List<String> getMultifilePartNames() {
        String[] strArr = this.data;
        List<String> list = null;
        if (!(this.kind == Kind.MULTIFILE_CLASS)) {
            strArr = null;
        }
        if (strArr != null) {
            list = ArraysKt___ArraysJvmKt.asList((T[]) strArr);
        }
        return list == null ? CollectionsKt__CollectionsKt.emptyList() : list;
    }

    @Nullable
    public final String[] getStrings() {
        return this.strings;
    }

    public final boolean isPreRelease() {
        return has(this.extraInt, 2);
    }

    public final boolean isUnstableFirBinary() {
        return has(this.extraInt, 64) && !has(this.extraInt, 32);
    }

    public final boolean isUnstableJvmIrBinary() {
        return has(this.extraInt, 16) && !has(this.extraInt, 32);
    }

    @NotNull
    public String toString() {
        return this.kind + " version=" + this.metadataVersion;
    }
}
