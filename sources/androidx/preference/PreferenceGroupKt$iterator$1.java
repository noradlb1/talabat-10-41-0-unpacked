package androidx.preference;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/preference/PreferenceGroupKt$iterator$1", "", "Landroidx/preference/Preference;", "index", "", "hasNext", "", "next", "remove", "", "preference-ktx_release"}, k = 1, mv = {1, 1, 15})
public final class PreferenceGroupKt$iterator$1 implements Iterator<Preference>, KMutableIterator, j$.util.Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PreferenceGroup f37327b;
    private int index;

    public PreferenceGroupKt$iterator$1(PreferenceGroup preferenceGroup) {
        this.f37327b = preferenceGroup;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public boolean hasNext() {
        if (this.index < this.f37327b.getPreferenceCount()) {
            return true;
        }
        return false;
    }

    public void remove() {
        PreferenceGroup preferenceGroup = this.f37327b;
        int i11 = this.index - 1;
        this.index = i11;
        preferenceGroup.removePreference(preferenceGroup.getPreference(i11));
    }

    @NotNull
    public Preference next() {
        PreferenceGroup preferenceGroup = this.f37327b;
        int i11 = this.index;
        this.index = i11 + 1;
        Preference preference = preferenceGroup.getPreference(i11);
        if (preference != null) {
            return preference;
        }
        throw new IndexOutOfBoundsException();
    }
}
