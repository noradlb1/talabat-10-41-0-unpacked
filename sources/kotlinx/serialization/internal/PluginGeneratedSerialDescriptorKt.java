package kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialKind;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0007H\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\r*\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0000¢\u0006\u0002\u0010\u0010\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0011"}, d2 = {"equalsImpl", "", "SD", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "other", "", "typeParamsAreEqual", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "otherDescriptor", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "hashCodeImpl", "", "typeParams", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PluginGeneratedSerialDescriptorKt {
    public static final /* synthetic */ <SD extends SerialDescriptor> boolean equalsImpl(SD sd2, Object obj, Function1<? super SD, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sd2, "<this>");
        Intrinsics.checkNotNullParameter(function1, "typeParamsAreEqual");
        if (sd2 == obj) {
            return true;
        }
        Intrinsics.reifiedOperationMarker(3, "SD");
        if (!(obj instanceof SerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        if (!Intrinsics.areEqual((Object) sd2.getSerialName(), (Object) serialDescriptor.getSerialName()) || !function1.invoke(obj).booleanValue() || sd2.getElementsCount() != serialDescriptor.getElementsCount()) {
            return false;
        }
        int elementsCount = sd2.getElementsCount();
        for (int i11 = 0; i11 < elementsCount; i11++) {
            if (!Intrinsics.areEqual((Object) sd2.getElementDescriptor(i11).getSerialName(), (Object) serialDescriptor.getElementDescriptor(i11).getSerialName()) || !Intrinsics.areEqual((Object) sd2.getElementDescriptor(i11).getKind(), (Object) serialDescriptor.getElementDescriptor(i11).getKind())) {
                return false;
            }
        }
        return true;
    }

    public static final int hashCodeImpl(@NotNull SerialDescriptor serialDescriptor, @NotNull SerialDescriptor[] serialDescriptorArr) {
        int i11;
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(serialDescriptorArr, "typeParams");
        int hashCode = (serialDescriptor.getSerialName().hashCode() * 31) + Arrays.hashCode(serialDescriptorArr);
        Iterable<SerialDescriptor> elementDescriptors = SerialDescriptorKt.getElementDescriptors(serialDescriptor);
        Iterator<SerialDescriptor> it = elementDescriptors.iterator();
        int i12 = 1;
        int i13 = 1;
        while (true) {
            int i14 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i15 = i13 * 31;
            String serialName = it.next().getSerialName();
            if (serialName != null) {
                i14 = serialName.hashCode();
            }
            i13 = i15 + i14;
        }
        for (SerialDescriptor kind : elementDescriptors) {
            int i16 = i12 * 31;
            SerialKind kind2 = kind.getKind();
            if (kind2 != null) {
                i11 = kind2.hashCode();
            } else {
                i11 = 0;
            }
            i12 = i16 + i11;
        }
        return (((hashCode * 31) + i13) * 31) + i12;
    }
}
