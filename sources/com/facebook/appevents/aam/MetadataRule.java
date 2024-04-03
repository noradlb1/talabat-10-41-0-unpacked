package com.facebook.appevents.aam;

import androidx.annotation.RestrictTo;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058F¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/aam/MetadataRule;", "", "name", "", "keyRules", "", "valRule", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getKeyRules", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getValRule", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class MetadataRule {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String FIELD_K = "k";
    @NotNull
    private static final String FIELD_K_DELIMITER = ",";
    @NotNull
    private static final String FIELD_V = "v";
    /* access modifiers changed from: private */
    @NotNull
    public static final Set<MetadataRule> rules = new CopyOnWriteArraySet();
    @NotNull
    private final List<String> keyRules;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f33577name;
    @NotNull
    private final String valRule;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0007J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0007J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/aam/MetadataRule$Companion;", "", "()V", "FIELD_K", "", "FIELD_K_DELIMITER", "FIELD_V", "rules", "", "Lcom/facebook/appevents/aam/MetadataRule;", "constructRules", "", "jsonObject", "Lorg/json/JSONObject;", "getEnabledRuleNames", "", "getRules", "updateRules", "rulesFromServer", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void constructRules(JSONObject jSONObject) {
            boolean z11;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(MetadataRule.FIELD_K);
                    String optString2 = optJSONObject.optString("v");
                    Intrinsics.checkNotNullExpressionValue(optString, MetadataRule.FIELD_K);
                    if (optString.length() == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        Set access$getRules$cp = MetadataRule.rules;
                        Intrinsics.checkNotNullExpressionValue(next, "key");
                        List split$default = StringsKt__StringsKt.split$default((CharSequence) optString, new String[]{","}, false, 0, 6, (Object) null);
                        Intrinsics.checkNotNullExpressionValue(optString2, "v");
                        access$getRules$cp.add(new MetadataRule(next, split$default, optString2, (DefaultConstructorMarker) null));
                    }
                }
            }
        }

        @JvmStatic
        @NotNull
        public final Set<String> getEnabledRuleNames() {
            HashSet hashSet = new HashSet();
            for (MetadataRule name2 : MetadataRule.rules) {
                hashSet.add(name2.getName());
            }
            return hashSet;
        }

        @JvmStatic
        @NotNull
        public final Set<MetadataRule> getRules() {
            return new HashSet(MetadataRule.rules);
        }

        @JvmStatic
        public final void updateRules(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "rulesFromServer");
            try {
                MetadataRule.rules.clear();
                constructRules(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
    }

    private MetadataRule(String str, List<String> list, String str2) {
        this.f33577name = str;
        this.valRule = str2;
        this.keyRules = list;
    }

    public /* synthetic */ MetadataRule(String str, List list, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, str2);
    }

    @JvmStatic
    @NotNull
    public static final Set<String> getEnabledRuleNames() {
        return Companion.getEnabledRuleNames();
    }

    @JvmStatic
    @NotNull
    public static final Set<MetadataRule> getRules() {
        return Companion.getRules();
    }

    @JvmStatic
    public static final void updateRules(@NotNull String str) {
        Companion.updateRules(str);
    }

    @NotNull
    public final List<String> getKeyRules() {
        return new ArrayList(this.keyRules);
    }

    @NotNull
    public final String getName() {
        return this.f33577name;
    }

    @NotNull
    public final String getValRule() {
        return this.valRule;
    }
}
