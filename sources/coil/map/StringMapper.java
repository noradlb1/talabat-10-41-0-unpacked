package coil.map;

import android.net.Uri;
import coil.map.Mapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcoil/map/StringMapper;", "Lcoil/map/Mapper;", "", "Landroid/net/Uri;", "()V", "map", "data", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StringMapper implements Mapper<String, Uri> {
    public boolean handles(@NotNull String str) {
        return Mapper.DefaultImpls.handles(this, str);
    }

    @NotNull
    public Uri map(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(this)");
        return parse;
    }
}
