package coil.map;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcoil/map/ResourceIntMapper;", "Lcoil/map/Mapper;", "", "Landroid/net/Uri;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "handles", "", "data", "map", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ResourceIntMapper implements Mapper<Integer, Uri> {
    @NotNull
    private final Context context;

    public ResourceIntMapper(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public /* bridge */ /* synthetic */ boolean handles(Object obj) {
        return handles(((Number) obj).intValue());
    }

    public /* bridge */ /* synthetic */ Object map(Object obj) {
        return map(((Number) obj).intValue());
    }

    public boolean handles(@DrawableRes int i11) {
        try {
            return this.context.getResources().getResourceEntryName(i11) != null;
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }

    @NotNull
    public Uri map(@DrawableRes int i11) {
        Uri parse = Uri.parse("android.resource://" + this.context.getPackageName() + '/' + i11);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(this)");
        return parse;
    }
}
