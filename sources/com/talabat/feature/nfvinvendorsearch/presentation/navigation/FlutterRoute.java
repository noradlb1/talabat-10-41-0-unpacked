package com.talabat.feature.nfvinvendorsearch.presentation.navigation;

import android.os.Parcelable;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&J\b\u0010\u0007\u001a\u00020\u0005H&J\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "Landroid/os/Parcelable;", "()V", "buildArguments", "", "", "", "buildPath", "buildRoute", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class FlutterRoute implements Parcelable {
    @NotNull
    public abstract Map<String, Object> buildArguments();

    @NotNull
    public abstract String buildPath();

    @NotNull
    public final String buildRoute() {
        String buildPath = buildPath();
        Map<String, Object> buildArguments = buildArguments();
        if (buildArguments.isEmpty()) {
            return buildPath;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(buildPath);
        sb2.append('?');
        for (Map.Entry next : buildArguments.entrySet()) {
            Object value = next.getValue();
            sb2.append((String) next.getKey());
            sb2.append(SignatureVisitor.INSTANCEOF);
            sb2.append(URLEncoder.encode(value.toString(), Charset.defaultCharset().name()));
            sb2.append(Typography.amp);
        }
        sb2.deleteCharAt(StringsKt__StringsKt.getLastIndex(sb2));
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
