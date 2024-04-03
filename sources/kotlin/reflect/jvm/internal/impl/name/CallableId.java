package kotlin.reflect.jvm.internal.impl.name;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CallableId {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final Name LOCAL_NAME;
    @NotNull
    @Deprecated
    private static final FqName PACKAGE_FQ_NAME_FOR_LOCAL;
    @NotNull
    private final Name callableName;
    @Nullable
    private final FqName className;
    @NotNull
    private final FqName packageName;
    @Nullable
    private final FqName pathToLocal;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Name name2 = SpecialNames.LOCAL;
        LOCAL_NAME = name2;
        FqName fqName = FqName.topLevel(name2);
        Intrinsics.checkNotNullExpressionValue(fqName, "topLevel(LOCAL_NAME)");
        PACKAGE_FQ_NAME_FOR_LOCAL = fqName;
    }

    public CallableId(@NotNull FqName fqName, @Nullable FqName fqName2, @NotNull Name name2, @Nullable FqName fqName3) {
        Intrinsics.checkNotNullParameter(fqName, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(name2, "callableName");
        this.packageName = fqName;
        this.className = fqName2;
        this.callableName = name2;
        this.pathToLocal = fqName3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallableId)) {
            return false;
        }
        CallableId callableId = (CallableId) obj;
        return Intrinsics.areEqual((Object) this.packageName, (Object) callableId.packageName) && Intrinsics.areEqual((Object) this.className, (Object) callableId.className) && Intrinsics.areEqual((Object) this.callableName, (Object) callableId.callableName) && Intrinsics.areEqual((Object) this.pathToLocal, (Object) callableId.pathToLocal);
    }

    public int hashCode() {
        int hashCode = this.packageName.hashCode() * 31;
        FqName fqName = this.className;
        int i11 = 0;
        int hashCode2 = (((hashCode + (fqName == null ? 0 : fqName.hashCode())) * 31) + this.callableName.hashCode()) * 31;
        FqName fqName2 = this.pathToLocal;
        if (fqName2 != null) {
            i11 = fqName2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String asString = this.packageName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "packageName.asString()");
        sb2.append(StringsKt__StringsJVMKt.replace$default(asString, '.', '/', false, 4, (Object) null));
        sb2.append("/");
        FqName fqName = this.className;
        if (fqName != null) {
            sb2.append(fqName);
            sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        }
        sb2.append(this.callableName);
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallableId(FqName fqName, FqName fqName2, Name name2, FqName fqName3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(fqName, fqName2, name2, (i11 & 8) != 0 ? null : fqName3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CallableId(@NotNull FqName fqName, @NotNull Name name2) {
        this(fqName, (FqName) null, name2, (FqName) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fqName, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(name2, "callableName");
    }
}
