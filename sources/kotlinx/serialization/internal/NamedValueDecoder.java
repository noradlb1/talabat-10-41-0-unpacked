package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0004J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0004J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/internal/TaggedDecoder;", "", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "", "index", "h", "nestedName", "i", "desc", "g", "parentName", "childName", "f", "<init>", "()V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
@InternalSerializationApi
public abstract class NamedValueDecoder extends TaggedDecoder<String> {
    @NotNull
    public String f(@NotNull String str, @NotNull String str2) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "parentName");
        Intrinsics.checkNotNullParameter(str2, "childName");
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return str2;
        }
        return str + '.' + str2;
    }

    @NotNull
    public String g(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "desc");
        return serialDescriptor.getElementName(i11);
    }

    @NotNull
    /* renamed from: h */
    public final String getTag(@NotNull SerialDescriptor serialDescriptor, int i11) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return i(g(serialDescriptor, i11));
    }

    @NotNull
    public final String i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "nestedName");
        String str2 = (String) c();
        if (str2 == null) {
            str2 = "";
        }
        return f(str2, str);
    }
}
