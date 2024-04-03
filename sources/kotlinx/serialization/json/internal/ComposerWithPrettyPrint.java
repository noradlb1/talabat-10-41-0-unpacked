package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/serialization/json/internal/ComposerWithPrettyPrint;", "Lkotlinx/serialization/json/internal/Composer;", "sb", "Lkotlinx/serialization/json/internal/JsonStringBuilder;", "json", "Lkotlinx/serialization/json/Json;", "(Lkotlinx/serialization/json/internal/JsonStringBuilder;Lkotlinx/serialization/json/Json;)V", "level", "", "indent", "", "nextItem", "space", "unIndent", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ComposerWithPrettyPrint extends Composer {
    @NotNull
    private final Json json;
    private int level;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerWithPrettyPrint(@NotNull JsonStringBuilder jsonStringBuilder, @NotNull Json json2) {
        super(jsonStringBuilder);
        Intrinsics.checkNotNullParameter(jsonStringBuilder, "sb");
        Intrinsics.checkNotNullParameter(json2, "json");
        this.json = json2;
    }

    public void indent() {
        a(true);
        this.level++;
    }

    public void nextItem() {
        a(false);
        print(StringUtils.LF);
        int i11 = this.level;
        for (int i12 = 0; i12 < i11; i12++) {
            print(this.json.getConfiguration().getPrettyPrintIndent());
        }
    }

    public void space() {
        print(' ');
    }

    public void unIndent() {
        this.level--;
    }
}
