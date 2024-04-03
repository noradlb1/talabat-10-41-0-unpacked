package androidx.compose.animation.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"androidx/compose/animation/core/VectorizedAnimationSpecKt$createSpringAnimations$1", "Landroidx/compose/animation/core/Animations;", "anims", "", "Landroidx/compose/animation/core/FloatSpringSpec;", "get", "index", "", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VectorizedAnimationSpecKt$createSpringAnimations$1 implements Animations {
    @NotNull
    private final List<FloatSpringSpec> anims;

    public VectorizedAnimationSpecKt$createSpringAnimations$1(V v11, float f11, float f12) {
        IntRange until = RangesKt___RangesKt.until(0, v11.getSize$animation_core_release());
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10));
        Iterator it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(new FloatSpringSpec(f11, f12, v11.get$animation_core_release(((IntIterator) it).nextInt())));
        }
        this.anims = arrayList;
    }

    @NotNull
    public FloatSpringSpec get(int i11) {
        return this.anims.get(i11);
    }
}
