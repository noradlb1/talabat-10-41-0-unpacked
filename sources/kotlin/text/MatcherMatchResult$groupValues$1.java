package kotlin.text;

import kotlin.Metadata;
import kotlin.collections.AbstractList;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"kotlin/text/MatcherMatchResult$groupValues$1", "Lkotlin/collections/AbstractList;", "", "size", "", "getSize", "()I", "get", "index", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MatcherMatchResult$groupValues$1 extends AbstractList<String> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MatcherMatchResult f25074b;

    public MatcherMatchResult$groupValues$1(MatcherMatchResult matcherMatchResult) {
        this.f25074b = matcherMatchResult;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return contains((String) obj);
    }

    public int getSize() {
        return this.f25074b.getMatchResult().groupCount() + 1;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof String)) {
            return -1;
        }
        return indexOf((String) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof String)) {
            return -1;
        }
        return lastIndexOf((String) obj);
    }

    public /* bridge */ boolean contains(String str) {
        return super.contains(str);
    }

    @NotNull
    public String get(int i11) {
        String group = this.f25074b.getMatchResult().group(i11);
        return group == null ? "" : group;
    }

    public /* bridge */ int indexOf(String str) {
        return super.indexOf(str);
    }

    public /* bridge */ int lastIndexOf(String str) {
        return super.lastIndexOf(str);
    }
}
