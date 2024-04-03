package com.facebook.appevents.codeless.internal;

import com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/facebook/appevents/codeless/internal/PathComponent;", "", "component", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "className", "", "getClassName", "()Ljava/lang/String;", "description", "getDescription", "hint", "getHint", "id", "", "getId", "()I", "index", "getIndex", "matchBitmask", "getMatchBitmask", "tag", "getTag", "text", "getText", "Companion", "MatchBitmaskType", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PathComponent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String PATH_CLASS_NAME_KEY = "class_name";
    @NotNull
    private static final String PATH_DESCRIPTION_KEY = "description";
    @NotNull
    private static final String PATH_HINT_KEY = "hint";
    @NotNull
    private static final String PATH_ID_KEY = "id";
    @NotNull
    private static final String PATH_INDEX_KEY = "index";
    @NotNull
    private static final String PATH_MATCH_BITMASK_KEY = "match_bitmask";
    @NotNull
    private static final String PATH_TAG_KEY = "tag";
    @NotNull
    private static final String PATH_TEXT_KEY = "text";
    @NotNull
    private final String className;
    @NotNull
    private final String description;
    @NotNull
    private final String hint;

    /* renamed from: id  reason: collision with root package name */
    private final int f33581id;
    private final int index;
    private final int matchBitmask;
    @NotNull
    private final String tag;
    @NotNull
    private final String text;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/codeless/internal/PathComponent$Companion;", "", "()V", "PATH_CLASS_NAME_KEY", "", "PATH_DESCRIPTION_KEY", "PATH_HINT_KEY", "PATH_ID_KEY", "PATH_INDEX_KEY", "PATH_MATCH_BITMASK_KEY", "PATH_TAG_KEY", "PATH_TEXT_KEY", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/codeless/internal/PathComponent$MatchBitmaskType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ID", "TEXT", "TAG", "DESCRIPTION", "HINT", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum MatchBitmaskType {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);
        
        private final int value;

        private MatchBitmaskType(int i11) {
            this.value = i11;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public PathComponent(@NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, FluidHomeScreenViewModel.METADATA_COMPONENT_KEY);
        String string = jSONObject.getString(PATH_CLASS_NAME_KEY);
        Intrinsics.checkNotNullExpressionValue(string, "component.getString(PATH_CLASS_NAME_KEY)");
        this.className = string;
        this.index = jSONObject.optInt("index", -1);
        this.f33581id = jSONObject.optInt("id");
        String optString = jSONObject.optString("text");
        Intrinsics.checkNotNullExpressionValue(optString, "component.optString(PATH_TEXT_KEY)");
        this.text = optString;
        String optString2 = jSONObject.optString("tag");
        Intrinsics.checkNotNullExpressionValue(optString2, "component.optString(PATH_TAG_KEY)");
        this.tag = optString2;
        String optString3 = jSONObject.optString("description");
        Intrinsics.checkNotNullExpressionValue(optString3, "component.optString(PATH_DESCRIPTION_KEY)");
        this.description = optString3;
        String optString4 = jSONObject.optString("hint");
        Intrinsics.checkNotNullExpressionValue(optString4, "component.optString(PATH_HINT_KEY)");
        this.hint = optString4;
        this.matchBitmask = jSONObject.optInt(PATH_MATCH_BITMASK_KEY);
    }

    @NotNull
    public final String getClassName() {
        return this.className;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getHint() {
        return this.hint;
    }

    public final int getId() {
        return this.f33581id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getMatchBitmask() {
        return this.matchBitmask;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }
}
