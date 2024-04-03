package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;

public final class NameResolverImpl implements NameResolver {
    @NotNull
    private final ProtoBuf.QualifiedNameTable qualifiedNames;
    @NotNull
    private final ProtoBuf.StringTable strings;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NameResolverImpl(@NotNull ProtoBuf.StringTable stringTable, @NotNull ProtoBuf.QualifiedNameTable qualifiedNameTable) {
        Intrinsics.checkNotNullParameter(stringTable, "strings");
        Intrinsics.checkNotNullParameter(qualifiedNameTable, "qualifiedNames");
        this.strings = stringTable;
        this.qualifiedNames = qualifiedNameTable;
    }

    private final Triple<List<String>, List<String>, Boolean> traverseIds(int i11) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z11 = false;
        while (i11 != -1) {
            ProtoBuf.QualifiedNameTable.QualifiedName qualifiedName = this.qualifiedNames.getQualifiedName(i11);
            String string = this.strings.getString(qualifiedName.getShortName());
            ProtoBuf.QualifiedNameTable.QualifiedName.Kind kind = qualifiedName.getKind();
            Intrinsics.checkNotNull(kind);
            int i12 = WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
            if (i12 == 1) {
                linkedList2.addFirst(string);
            } else if (i12 == 2) {
                linkedList.addFirst(string);
            } else if (i12 == 3) {
                linkedList2.addFirst(string);
                z11 = true;
            }
            i11 = qualifiedName.getParentQualifiedName();
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z11));
    }

    @NotNull
    public String getQualifiedClassName(int i11) {
        Triple<List<String>, List<String>, Boolean> traverseIds = traverseIds(i11);
        List component1 = traverseIds.component1();
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(traverseIds.component2(), RealDiscoveryConfigurationRepository.VERSION_DELIMETER, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        if (component1.isEmpty()) {
            return joinToString$default;
        }
        return CollectionsKt___CollectionsKt.joinToString$default(component1, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + '/' + joinToString$default;
    }

    @NotNull
    public String getString(int i11) {
        String string = this.strings.getString(i11);
        Intrinsics.checkNotNullExpressionValue(string, "strings.getString(index)");
        return string;
    }

    public boolean isLocalClassName(int i11) {
        return traverseIds(i11).getThird().booleanValue();
    }
}
