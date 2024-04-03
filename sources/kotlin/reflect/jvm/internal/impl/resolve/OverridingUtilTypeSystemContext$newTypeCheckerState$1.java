package kotlin.reflect.jvm.internal.impl.resolve;

import com.huawei.location.lite.common.util.filedownload.DownloadConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class OverridingUtilTypeSystemContext$newTypeCheckerState$1 extends TypeCheckerState {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OverridingUtilTypeSystemContext f24800a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OverridingUtilTypeSystemContext$newTypeCheckerState$1(boolean z11, boolean z12, OverridingUtilTypeSystemContext overridingUtilTypeSystemContext, KotlinTypePreparator kotlinTypePreparator, KotlinTypeRefiner kotlinTypeRefiner) {
        super(z11, z12, true, overridingUtilTypeSystemContext, kotlinTypePreparator, kotlinTypeRefiner);
        this.f24800a = overridingUtilTypeSystemContext;
    }

    public boolean customIsSubtypeOf(@NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, DownloadConstants.PARAM_SUB_TYPE);
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "superType");
        if (!(kotlinTypeMarker instanceof KotlinType)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (kotlinTypeMarker2 instanceof KotlinType) {
            return ((Boolean) this.f24800a.customSubtype.invoke(kotlinTypeMarker, kotlinTypeMarker2)).booleanValue();
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }
}
