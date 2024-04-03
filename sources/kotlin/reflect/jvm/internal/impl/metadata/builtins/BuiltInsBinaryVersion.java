package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import org.jetbrains.annotations.NotNull;

public final class BuiltInsBinaryVersion extends BinaryVersion {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final BuiltInsBinaryVersion INSTANCE = new BuiltInsBinaryVersion(1, 0, 7);
    @NotNull
    @JvmField
    public static final BuiltInsBinaryVersion INVALID_VERSION = new BuiltInsBinaryVersion(new int[0]);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BuiltInsBinaryVersion readFrom(@NotNull InputStream inputStream) {
            Intrinsics.checkNotNullParameter(inputStream, "stream");
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            IntRange intRange = new IntRange(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10));
            Iterator it = intRange.iterator();
            while (it.hasNext()) {
                ((IntIterator) it).nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
            return new BuiltInsBinaryVersion(Arrays.copyOf(intArray, intArray.length));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BuiltInsBinaryVersion(@NotNull int... iArr) {
        super(Arrays.copyOf(iArr, iArr.length));
        Intrinsics.checkNotNullParameter(iArr, "numbers");
    }

    public boolean isCompatible() {
        return a(INSTANCE);
    }
}
