package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

public final class Jsr305Settings$description$2 extends Lambda implements Function0<String[]> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Jsr305Settings f24566g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Jsr305Settings$description$2(Jsr305Settings jsr305Settings) {
        super(0);
        this.f24566g = jsr305Settings;
    }

    @NotNull
    public final String[] invoke() {
        Jsr305Settings jsr305Settings = this.f24566g;
        List createListBuilder = CollectionsKt__CollectionsJVMKt.createListBuilder();
        createListBuilder.add(jsr305Settings.getGlobalLevel().getDescription());
        ReportLevel migrationLevel = jsr305Settings.getMigrationLevel();
        if (migrationLevel != null) {
            createListBuilder.add("under-migration:" + migrationLevel.getDescription());
        }
        for (Map.Entry next : jsr305Settings.getUserDefinedLevelForSpecificAnnotation().entrySet()) {
            createListBuilder.add('@' + next.getKey() + AbstractJsonLexerKt.COLON + ((ReportLevel) next.getValue()).getDescription());
        }
        Object[] array = CollectionsKt__CollectionsJVMKt.build(createListBuilder).toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }
}
