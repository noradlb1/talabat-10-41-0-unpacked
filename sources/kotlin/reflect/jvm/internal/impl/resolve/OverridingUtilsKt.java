package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.LinkedList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;

public final class OverridingUtilsKt {
    @NotNull
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(@NotNull Collection<? extends H> collection, @NotNull Function1<? super H, ? extends CallableDescriptor> function1) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(function1, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        SmartSet create = SmartSet.Companion.create();
        while (!linkedList.isEmpty()) {
            Object first = CollectionsKt___CollectionsKt.first(linkedList);
            SmartSet create2 = SmartSet.Companion.create();
            Collection<H> extractMembersOverridableInBothWays = OverridingUtil.extractMembersOverridableInBothWays(first, linkedList, function1, new OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(create2));
            Intrinsics.checkNotNullExpressionValue(extractMembersOverridableInBothWays, "val conflictedHandles = …nflictedHandles.add(it) }");
            if (extractMembersOverridableInBothWays.size() != 1 || !create2.isEmpty()) {
                Object selectMostSpecificMember = OverridingUtil.selectMostSpecificMember(extractMembersOverridableInBothWays, function1);
                Intrinsics.checkNotNullExpressionValue(selectMostSpecificMember, "selectMostSpecificMember…roup, descriptorByHandle)");
                CallableDescriptor callableDescriptor = (CallableDescriptor) function1.invoke(selectMostSpecificMember);
                for (Object next : extractMembersOverridableInBothWays) {
                    Intrinsics.checkNotNullExpressionValue(next, "it");
                    if (!OverridingUtil.isMoreSpecific(callableDescriptor, (CallableDescriptor) function1.invoke(next))) {
                        create2.add(next);
                    }
                }
                if (!create2.isEmpty()) {
                    create.addAll(create2);
                }
                create.add(selectMostSpecificMember);
            } else {
                Object single = CollectionsKt___CollectionsKt.single(extractMembersOverridableInBothWays);
                Intrinsics.checkNotNullExpressionValue(single, "overridableGroup.single()");
                create.add(single);
            }
        }
        return create;
    }
}
