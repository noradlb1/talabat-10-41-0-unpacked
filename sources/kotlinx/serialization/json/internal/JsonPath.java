package kotlinx.serialization.json.internal;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\rJ\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkotlinx/serialization/json/internal/JsonPath;", "", "()V", "currentDepth", "", "currentObjectPath", "", "[Ljava/lang/Object;", "indicies", "", "getPath", "", "popDescriptor", "", "prettyString", "it", "pushDescriptor", "sd", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "resetCurrentMapKey", "resize", "toString", "updateCurrentMapKey", "key", "updateDescriptorIndex", "index", "Tombstone", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JsonPath {
    private int currentDepth;
    @NotNull
    private Object[] currentObjectPath = new Object[8];
    @NotNull
    private int[] indicies;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/serialization/json/internal/JsonPath$Tombstone;", "", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Tombstone {
        @NotNull
        public static final Tombstone INSTANCE = new Tombstone();

        private Tombstone() {
        }
    }

    public JsonPath() {
        int[] iArr = new int[8];
        for (int i11 = 0; i11 < 8; i11++) {
            iArr[i11] = -1;
        }
        this.indicies = iArr;
        this.currentDepth = -1;
    }

    private final String prettyString(Object obj) {
        String serialName;
        SerialDescriptor serialDescriptor = obj instanceof SerialDescriptor ? (SerialDescriptor) obj : null;
        return (serialDescriptor == null || (serialName = serialDescriptor.getSerialName()) == null) ? String.valueOf(obj) : serialName;
    }

    private final void resize() {
        int i11 = this.currentDepth * 2;
        Object[] copyOf = Arrays.copyOf(this.currentObjectPath, i11);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        this.currentObjectPath = copyOf;
        int[] copyOf2 = Arrays.copyOf(this.indicies, i11);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        this.indicies = copyOf2;
    }

    @NotNull
    public final String getPath() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("$");
        int i11 = this.currentDepth + 1;
        for (int i12 = 0; i12 < i11; i12++) {
            Object obj = this.currentObjectPath[i12];
            if (obj instanceof SerialDescriptor) {
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                if (!Intrinsics.areEqual((Object) serialDescriptor.getKind(), (Object) StructureKind.LIST.INSTANCE)) {
                    int i13 = this.indicies[i12];
                    if (i13 >= 0) {
                        sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                        sb2.append(serialDescriptor.getElementName(i13));
                    }
                } else if (this.indicies[i12] != -1) {
                    sb2.append("[");
                    sb2.append(this.indicies[i12]);
                    sb2.append("]");
                }
            } else if (obj != Tombstone.INSTANCE) {
                sb2.append("[");
                sb2.append("'");
                sb2.append(obj);
                sb2.append("'");
                sb2.append("]");
            }
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final void popDescriptor() {
        int i11 = this.currentDepth;
        int[] iArr = this.indicies;
        if (iArr[i11] == -2) {
            iArr[i11] = -1;
            this.currentDepth = i11 - 1;
        }
        int i12 = this.currentDepth;
        if (i12 != -1) {
            this.currentDepth = i12 - 1;
        }
    }

    public final void pushDescriptor(@NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "sd");
        int i11 = this.currentDepth + 1;
        this.currentDepth = i11;
        if (i11 == this.currentObjectPath.length) {
            resize();
        }
        this.currentObjectPath[i11] = serialDescriptor;
    }

    public final void resetCurrentMapKey() {
        int[] iArr = this.indicies;
        int i11 = this.currentDepth;
        if (iArr[i11] == -2) {
            this.currentObjectPath[i11] = Tombstone.INSTANCE;
        }
    }

    @NotNull
    public String toString() {
        return getPath();
    }

    public final void updateCurrentMapKey(@Nullable Object obj) {
        int[] iArr = this.indicies;
        int i11 = this.currentDepth;
        if (iArr[i11] != -2) {
            int i12 = i11 + 1;
            this.currentDepth = i12;
            if (i12 == this.currentObjectPath.length) {
                resize();
            }
        }
        Object[] objArr = this.currentObjectPath;
        int i13 = this.currentDepth;
        objArr[i13] = obj;
        this.indicies[i13] = -2;
    }

    public final void updateDescriptorIndex(int i11) {
        this.indicies[this.currentDepth] = i11;
    }
}
