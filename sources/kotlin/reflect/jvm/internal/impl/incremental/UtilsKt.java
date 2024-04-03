package kotlin.reflect.jvm.internal.impl.incremental;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;

public final class UtilsKt {
    public static final void record(@NotNull LookupTracker lookupTracker, @NotNull LookupLocation lookupLocation, @NotNull ClassDescriptor classDescriptor, @NotNull Name name2) {
        LocationInfo location;
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(lookupLocation, "from");
        Intrinsics.checkNotNullParameter(classDescriptor, "scopeOwner");
        Intrinsics.checkNotNullParameter(name2, "name");
        if (lookupTracker != LookupTracker.DO_NOTHING.INSTANCE && (location = lookupLocation.getLocation()) != null) {
            Position position = lookupTracker.getRequiresPosition() ? location.getPosition() : Position.Companion.getNO_POSITION();
            String filePath = location.getFilePath();
            String asString = DescriptorUtils.getFqName(classDescriptor).asString();
            Intrinsics.checkNotNullExpressionValue(asString, "getFqName(scopeOwner).asString()");
            ScopeKind scopeKind = ScopeKind.CLASSIFIER;
            String asString2 = name2.asString();
            Intrinsics.checkNotNullExpressionValue(asString2, "name.asString()");
            lookupTracker.record(filePath, position, asString, scopeKind, asString2);
        }
    }

    public static final void recordPackageLookup(@NotNull LookupTracker lookupTracker, @NotNull LookupLocation lookupLocation, @NotNull String str, @NotNull String str2) {
        LocationInfo location;
        Position position;
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(lookupLocation, "from");
        Intrinsics.checkNotNullParameter(str, "packageFqName");
        Intrinsics.checkNotNullParameter(str2, "name");
        if (lookupTracker != LookupTracker.DO_NOTHING.INSTANCE && (location = lookupLocation.getLocation()) != null) {
            if (lookupTracker.getRequiresPosition()) {
                position = location.getPosition();
            } else {
                position = Position.Companion.getNO_POSITION();
            }
            LookupTracker lookupTracker2 = lookupTracker;
            lookupTracker2.record(location.getFilePath(), position, str, ScopeKind.PACKAGE, str2);
        }
    }

    public static final void record(@NotNull LookupTracker lookupTracker, @NotNull LookupLocation lookupLocation, @NotNull PackageFragmentDescriptor packageFragmentDescriptor, @NotNull Name name2) {
        Intrinsics.checkNotNullParameter(lookupTracker, "<this>");
        Intrinsics.checkNotNullParameter(lookupLocation, "from");
        Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "scopeOwner");
        Intrinsics.checkNotNullParameter(name2, "name");
        String asString = packageFragmentDescriptor.getFqName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "scopeOwner.fqName.asString()");
        String asString2 = name2.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "name.asString()");
        recordPackageLookup(lookupTracker, lookupLocation, asString, asString2);
    }
}
