package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0013J\u001d\u0010\u0014\u001a\u00020\b\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004H\u0002J\u0006\u0010\u0017\u001a\u00020\u0000J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002J\"\u0010\u001a\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004H\u0002¢\u0006\u0002\u0010\u001bJ-\u0010\u001c\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00150\u001e¢\u0006\u0002\u0010\u001fJ1\u0010 \u001a\u0004\u0018\u0001H\u0015\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00150\u001e¢\u0006\u0002\u0010\u001fJ\b\u0010!\u001a\u00020\"H\u0016J!\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030$H\u0002J\u0015\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0000H\u0000¢\u0006\u0002\b'J*\u0010(\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00042\u0006\u0010)\u001a\u0002H\u0015H\u0002¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020,H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR \u0010\u000e\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "()V", "isClearingSemantics", "", "()Z", "setClearingSemantics", "(Z)V", "isMergingSemanticsOfDescendants", "setMergingSemanticsOfDescendants", "props", "", "collapsePeer", "", "peer", "collapsePeer$ui_release", "contains", "T", "key", "copy", "equals", "other", "get", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "hashCode", "", "iterator", "", "mergeChild", "child", "mergeChild$ui_release", "set", "value", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Ljava/lang/Object;)V", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SemanticsConfiguration implements SemanticsPropertyReceiver, Iterable<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>>, KMappedMarker {
    public static final int $stable = 8;
    private boolean isClearingSemantics;
    private boolean isMergingSemanticsOfDescendants;
    @NotNull
    private final Map<SemanticsPropertyKey<?>, Object> props = new LinkedHashMap();

    public final void collapsePeer$ui_release(@NotNull SemanticsConfiguration semanticsConfiguration) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "peer");
        if (semanticsConfiguration.isMergingSemanticsOfDescendants) {
            this.isMergingSemanticsOfDescendants = true;
        }
        if (semanticsConfiguration.isClearingSemantics) {
            this.isClearingSemantics = true;
        }
        for (Map.Entry next : semanticsConfiguration.props.entrySet()) {
            SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) next.getKey();
            Object value = next.getValue();
            if (!this.props.containsKey(semanticsPropertyKey)) {
                this.props.put(semanticsPropertyKey, value);
            } else if (value instanceof AccessibilityAction) {
                Object obj = this.props.get(semanticsPropertyKey);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
                Map<SemanticsPropertyKey<?>, Object> map = this.props;
                String label = accessibilityAction.getLabel();
                if (label == null) {
                    label = ((AccessibilityAction) value).getLabel();
                }
                Function action = accessibilityAction.getAction();
                if (action == null) {
                    action = ((AccessibilityAction) value).getAction();
                }
                map.put(semanticsPropertyKey, new AccessibilityAction(label, action));
            }
        }
    }

    public final <T> boolean contains(@NotNull SemanticsPropertyKey<T> semanticsPropertyKey) {
        Intrinsics.checkNotNullParameter(semanticsPropertyKey, "key");
        return this.props.containsKey(semanticsPropertyKey);
    }

    @NotNull
    public final SemanticsConfiguration copy() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.isMergingSemanticsOfDescendants = this.isMergingSemanticsOfDescendants;
        semanticsConfiguration.isClearingSemantics = this.isClearingSemantics;
        semanticsConfiguration.props.putAll(this.props);
        return semanticsConfiguration;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SemanticsConfiguration)) {
            return false;
        }
        SemanticsConfiguration semanticsConfiguration = (SemanticsConfiguration) obj;
        if (Intrinsics.areEqual((Object) this.props, (Object) semanticsConfiguration.props) && this.isMergingSemanticsOfDescendants == semanticsConfiguration.isMergingSemanticsOfDescendants && this.isClearingSemantics == semanticsConfiguration.isClearingSemantics) {
            return true;
        }
        return false;
    }

    public final <T> T get(@NotNull SemanticsPropertyKey<T> semanticsPropertyKey) {
        Intrinsics.checkNotNullParameter(semanticsPropertyKey, "key");
        T t11 = this.props.get(semanticsPropertyKey);
        if (t11 != null) {
            return t11;
        }
        throw new IllegalStateException("Key not present: " + semanticsPropertyKey + " - consider getOrElse or getOrNull");
    }

    public final <T> T getOrElse(@NotNull SemanticsPropertyKey<T> semanticsPropertyKey, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyKey, "key");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        T t11 = this.props.get(semanticsPropertyKey);
        if (t11 == null) {
            return function0.invoke();
        }
        return t11;
    }

    @Nullable
    public final <T> T getOrElseNullable(@NotNull SemanticsPropertyKey<T> semanticsPropertyKey, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyKey, "key");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        T t11 = this.props.get(semanticsPropertyKey);
        if (t11 == null) {
            return function0.invoke();
        }
        return t11;
    }

    public int hashCode() {
        return (((this.props.hashCode() * 31) + e.a(this.isMergingSemanticsOfDescendants)) * 31) + e.a(this.isClearingSemantics);
    }

    public final boolean isClearingSemantics() {
        return this.isClearingSemantics;
    }

    public final boolean isMergingSemanticsOfDescendants() {
        return this.isMergingSemanticsOfDescendants;
    }

    @NotNull
    public Iterator<Map.Entry<SemanticsPropertyKey<?>, Object>> iterator() {
        return this.props.entrySet().iterator();
    }

    public final void mergeChild$ui_release(@NotNull SemanticsConfiguration semanticsConfiguration) {
        Intrinsics.checkNotNullParameter(semanticsConfiguration, "child");
        for (Map.Entry next : semanticsConfiguration.props.entrySet()) {
            SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) next.getKey();
            Object value = next.getValue();
            Object obj = this.props.get(semanticsPropertyKey);
            Intrinsics.checkNotNull(semanticsPropertyKey, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
            Object merge = semanticsPropertyKey.merge(obj, value);
            if (merge != null) {
                this.props.put(semanticsPropertyKey, merge);
            }
        }
    }

    public <T> void set(@NotNull SemanticsPropertyKey<T> semanticsPropertyKey, T t11) {
        Intrinsics.checkNotNullParameter(semanticsPropertyKey, "key");
        this.props.put(semanticsPropertyKey, t11);
    }

    public final void setClearingSemantics(boolean z11) {
        this.isClearingSemantics = z11;
    }

    public final void setMergingSemanticsOfDescendants(boolean z11) {
        this.isMergingSemanticsOfDescendants = z11;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String str = "";
        if (this.isMergingSemanticsOfDescendants) {
            sb2.append(str);
            sb2.append("mergeDescendants=true");
            str = IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
        }
        if (this.isClearingSemantics) {
            sb2.append(str);
            sb2.append("isClearingSemantics=true");
            str = IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
        }
        for (Map.Entry next : this.props.entrySet()) {
            Object value = next.getValue();
            sb2.append(str);
            sb2.append(((SemanticsPropertyKey) next.getKey()).getName());
            sb2.append(" : ");
            sb2.append(value);
            str = IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
        }
        return JvmActuals_jvmKt.simpleIdentityToString(this, (String) null) + "{ " + sb2 + " }";
    }
}
