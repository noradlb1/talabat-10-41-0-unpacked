package androidx.compose.ui.res;

import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.vector.ImageVector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0019\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0002R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/res/ImageVectorCache;", "", "()V", "map", "Ljava/util/HashMap;", "Landroidx/compose/ui/res/ImageVectorCache$Key;", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/res/ImageVectorCache$ImageVectorEntry;", "Lkotlin/collections/HashMap;", "clear", "", "get", "key", "prune", "configChanges", "", "set", "imageVectorEntry", "ImageVectorEntry", "Key", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ImageVectorCache {
    @NotNull
    private final HashMap<Key, WeakReference<ImageVectorEntry>> map = new HashMap<>();

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/res/ImageVectorCache$ImageVectorEntry;", "", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "configFlags", "", "(Landroidx/compose/ui/graphics/vector/ImageVector;I)V", "getConfigFlags", "()I", "getImageVector", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ImageVectorEntry {
        public static final int $stable = 0;
        private final int configFlags;
        @NotNull
        private final ImageVector imageVector;

        public ImageVectorEntry(@NotNull ImageVector imageVector2, int i11) {
            Intrinsics.checkNotNullParameter(imageVector2, "imageVector");
            this.imageVector = imageVector2;
            this.configFlags = i11;
        }

        public static /* synthetic */ ImageVectorEntry copy$default(ImageVectorEntry imageVectorEntry, ImageVector imageVector2, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                imageVector2 = imageVectorEntry.imageVector;
            }
            if ((i12 & 2) != 0) {
                i11 = imageVectorEntry.configFlags;
            }
            return imageVectorEntry.copy(imageVector2, i11);
        }

        @NotNull
        public final ImageVector component1() {
            return this.imageVector;
        }

        public final int component2() {
            return this.configFlags;
        }

        @NotNull
        public final ImageVectorEntry copy(@NotNull ImageVector imageVector2, int i11) {
            Intrinsics.checkNotNullParameter(imageVector2, "imageVector");
            return new ImageVectorEntry(imageVector2, i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ImageVectorEntry)) {
                return false;
            }
            ImageVectorEntry imageVectorEntry = (ImageVectorEntry) obj;
            return Intrinsics.areEqual((Object) this.imageVector, (Object) imageVectorEntry.imageVector) && this.configFlags == imageVectorEntry.configFlags;
        }

        public final int getConfigFlags() {
            return this.configFlags;
        }

        @NotNull
        public final ImageVector getImageVector() {
            return this.imageVector;
        }

        public int hashCode() {
            return (this.imageVector.hashCode() * 31) + this.configFlags;
        }

        @NotNull
        public String toString() {
            return "ImageVectorEntry(imageVector=" + this.imageVector + ", configFlags=" + this.configFlags + ')';
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\f\u001a\u00060\u0003R\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003R\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/res/ImageVectorCache$Key;", "", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "id", "", "(Landroid/content/res/Resources$Theme;I)V", "getId", "()I", "getTheme", "()Landroid/content/res/Resources$Theme;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Key {
        public static final int $stable = 8;

        /* renamed from: id  reason: collision with root package name */
        private final int f10113id;
        @NotNull
        private final Resources.Theme theme;

        public Key(@NotNull Resources.Theme theme2, int i11) {
            Intrinsics.checkNotNullParameter(theme2, "theme");
            this.theme = theme2;
            this.f10113id = i11;
        }

        public static /* synthetic */ Key copy$default(Key key, Resources.Theme theme2, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                theme2 = key.theme;
            }
            if ((i12 & 2) != 0) {
                i11 = key.f10113id;
            }
            return key.copy(theme2, i11);
        }

        @NotNull
        public final Resources.Theme component1() {
            return this.theme;
        }

        public final int component2() {
            return this.f10113id;
        }

        @NotNull
        public final Key copy(@NotNull Resources.Theme theme2, int i11) {
            Intrinsics.checkNotNullParameter(theme2, "theme");
            return new Key(theme2, i11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return Intrinsics.areEqual((Object) this.theme, (Object) key.theme) && this.f10113id == key.f10113id;
        }

        public final int getId() {
            return this.f10113id;
        }

        @NotNull
        public final Resources.Theme getTheme() {
            return this.theme;
        }

        public int hashCode() {
            return (this.theme.hashCode() * 31) + this.f10113id;
        }

        @NotNull
        public String toString() {
            return "Key(theme=" + this.theme + ", id=" + this.f10113id + ')';
        }
    }

    public final void clear() {
        this.map.clear();
    }

    @Nullable
    public final ImageVectorEntry get(@NotNull Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        WeakReference weakReference = this.map.get(key);
        if (weakReference != null) {
            return (ImageVectorEntry) weakReference.get();
        }
        return null;
    }

    public final void prune(int i11) {
        Iterator<Map.Entry<Key, WeakReference<ImageVectorEntry>>> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Key, WeakReference<ImageVectorEntry>> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "it.next()");
            ImageVectorEntry imageVectorEntry = (ImageVectorEntry) ((WeakReference) next.getValue()).get();
            if (imageVectorEntry == null || Configuration.needNewResources(i11, imageVectorEntry.getConfigFlags())) {
                it.remove();
            }
        }
    }

    public final void set(@NotNull Key key, @NotNull ImageVectorEntry imageVectorEntry) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(imageVectorEntry, "imageVectorEntry");
        this.map.put(key, new WeakReference(imageVectorEntry));
    }
}
