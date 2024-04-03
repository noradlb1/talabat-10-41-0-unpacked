package androidx.preference;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"androidx/preference/PreferenceGroupKt$children$1", "Lkotlin/sequences/Sequence;", "Landroidx/preference/Preference;", "iterator", "", "preference-ktx_release"}, k = 1, mv = {1, 1, 15})
public final class PreferenceGroupKt$children$1 implements Sequence<Preference> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferenceGroup f37326a;

    public PreferenceGroupKt$children$1(PreferenceGroup preferenceGroup) {
        this.f37326a = preferenceGroup;
    }

    @NotNull
    public Iterator<Preference> iterator() {
        return PreferenceGroupKt.iterator(this.f37326a);
    }
}
