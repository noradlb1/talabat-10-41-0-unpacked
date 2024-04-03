package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.unit.IntRect;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001BK\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\n¢\u0006\u0002\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001a\u0001\u0003 !\"¨\u0006#"}, d2 = {"Landroidx/compose/ui/tooling/data/Group;", "", "key", "name", "", "location", "Landroidx/compose/ui/tooling/data/SourceLocation;", "box", "Landroidx/compose/ui/unit/IntRect;", "data", "", "children", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/ui/tooling/data/SourceLocation;Landroidx/compose/ui/unit/IntRect;Ljava/util/Collection;Ljava/util/Collection;)V", "getBox", "()Landroidx/compose/ui/unit/IntRect;", "getChildren", "()Ljava/util/Collection;", "getData", "getKey", "()Ljava/lang/Object;", "getLocation", "()Landroidx/compose/ui/tooling/data/SourceLocation;", "modifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "getModifierInfo", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "parameters", "Landroidx/compose/ui/tooling/data/ParameterInformation;", "getParameters", "Landroidx/compose/ui/tooling/data/CallGroup;", "Landroidx/compose/ui/tooling/data/NodeGroup;", "Landroidx/compose/ui/tooling/data/EmptyGroup;", "ui-tooling-data_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@UiToolingDataApi
public abstract class Group {
    public static final int $stable = 8;
    @NotNull
    private final IntRect box;
    @NotNull
    private final Collection<Group> children;
    @NotNull
    private final Collection<Object> data;
    @Nullable
    private final Object key;
    @Nullable
    private final SourceLocation location;
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f10280name;

    private Group(Object obj, String str, SourceLocation sourceLocation, IntRect intRect, Collection<? extends Object> collection, Collection<? extends Group> collection2) {
        this.key = obj;
        this.f10280name = str;
        this.location = sourceLocation;
        this.box = intRect;
        this.data = collection;
        this.children = collection2;
    }

    public /* synthetic */ Group(Object obj, String str, SourceLocation sourceLocation, IntRect intRect, Collection collection, Collection collection2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, str, sourceLocation, intRect, collection, collection2);
    }

    @NotNull
    public final IntRect getBox() {
        return this.box;
    }

    @NotNull
    public final Collection<Group> getChildren() {
        return this.children;
    }

    @NotNull
    public final Collection<Object> getData() {
        return this.data;
    }

    @Nullable
    public final Object getKey() {
        return this.key;
    }

    @Nullable
    public final SourceLocation getLocation() {
        return this.location;
    }

    @NotNull
    public List<ModifierInfo> getModifierInfo() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Nullable
    public final String getName() {
        return this.f10280name;
    }

    @NotNull
    public List<ParameterInformation> getParameters() {
        return CollectionsKt__CollectionsKt.emptyList();
    }
}
