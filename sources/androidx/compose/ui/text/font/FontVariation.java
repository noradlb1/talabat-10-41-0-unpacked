package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@ExperimentalTextApi
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005\u0003\u001d\u001e\u001f\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ7\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0010\"\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u001b\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006 "}, d2 = {"Landroidx/compose/ui/text/font/FontVariation;", "", "()V", "Setting", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "name", "", "value", "", "Settings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "settings", "", "Settings-6EWAqTQ", "(Landroidx/compose/ui/text/font/FontWeight;I[Landroidx/compose/ui/text/font/FontVariation$Setting;)Landroidx/compose/ui/text/font/FontVariation$Settings;", "grade", "", "italic", "opticalSizing", "textSize", "Landroidx/compose/ui/unit/TextUnit;", "opticalSizing--R2X_6o", "(J)Landroidx/compose/ui/text/font/FontVariation$Setting;", "slant", "width", "SettingFloat", "SettingInt", "SettingTextUnit", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FontVariation {
    public static final int $stable = 0;
    @NotNull
    public static final FontVariation INSTANCE = new FontVariation();

    @Immutable
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0001\u0003\u000e\u000f\u0010ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$Setting;", "", "axisName", "", "getAxisName", "()Ljava/lang/String;", "needsDensity", "", "getNeedsDensity", "()Z", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/text/font/FontVariation$SettingFloat;", "Landroidx/compose/ui/text/font/FontVariation$SettingInt;", "Landroidx/compose/ui/text/font/FontVariation$SettingTextUnit;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface Setting {
        @NotNull
        String getAxisName();

        boolean getNeedsDensity();

        float toVariationValue(@Nullable Density density);
    }

    @Immutable
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingFloat;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "", "(Ljava/lang/String;F)V", "getAxisName", "()Ljava/lang/String;", "needsDensity", "", "getNeedsDensity", "()Z", "getValue", "()F", "equals", "other", "", "hashCode", "", "toString", "toVariationValue", "density", "Landroidx/compose/ui/unit/Density;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SettingFloat implements Setting {
        @NotNull
        private final String axisName;
        private final boolean needsDensity;
        private final float value;

        public SettingFloat(@NotNull String str, float f11) {
            Intrinsics.checkNotNullParameter(str, "axisName");
            this.axisName = str;
            this.value = f11;
        }

        public boolean equals(@Nullable Object obj) {
            boolean z11;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingFloat)) {
                return false;
            }
            SettingFloat settingFloat = (SettingFloat) obj;
            if (!Intrinsics.areEqual((Object) getAxisName(), (Object) settingFloat.getAxisName())) {
                return false;
            }
            if (this.value == settingFloat.value) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                return false;
            }
            return true;
        }

        @NotNull
        public String getAxisName() {
            return this.axisName;
        }

        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public final float getValue() {
            return this.value;
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + Float.floatToIntBits(this.value);
        }

        @NotNull
        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + this.value + ')';
        }

        public float toVariationValue(@Nullable Density density) {
            return this.value;
        }
    }

    @Immutable
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingInt;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "", "(Ljava/lang/String;I)V", "getAxisName", "()Ljava/lang/String;", "needsDensity", "", "getNeedsDensity", "()Z", "getValue", "()I", "equals", "other", "", "hashCode", "toString", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SettingInt implements Setting {
        @NotNull
        private final String axisName;
        private final boolean needsDensity;
        private final int value;

        public SettingInt(@NotNull String str, int i11) {
            Intrinsics.checkNotNullParameter(str, "axisName");
            this.axisName = str;
            this.value = i11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingInt)) {
                return false;
            }
            SettingInt settingInt = (SettingInt) obj;
            if (Intrinsics.areEqual((Object) getAxisName(), (Object) settingInt.getAxisName()) && this.value == settingInt.value) {
                return true;
            }
            return false;
        }

        @NotNull
        public String getAxisName() {
            return this.axisName;
        }

        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + this.value;
        }

        @NotNull
        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + this.value + ')';
        }

        public float toVariationValue(@Nullable Density density) {
            return (float) this.value;
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$SettingTextUnit;", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "axisName", "", "value", "Landroidx/compose/ui/unit/TextUnit;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAxisName", "()Ljava/lang/String;", "needsDensity", "", "getNeedsDensity", "()Z", "getValue-XSAIIZE", "()J", "J", "equals", "other", "", "hashCode", "", "toString", "toVariationValue", "", "density", "Landroidx/compose/ui/unit/Density;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class SettingTextUnit implements Setting {
        @NotNull
        private final String axisName;
        private final boolean needsDensity;
        private final long value;

        private SettingTextUnit(String str, long j11) {
            this.axisName = str;
            this.value = j11;
            this.needsDensity = true;
        }

        public /* synthetic */ SettingTextUnit(String str, long j11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SettingTextUnit)) {
                return false;
            }
            SettingTextUnit settingTextUnit = (SettingTextUnit) obj;
            if (Intrinsics.areEqual((Object) getAxisName(), (Object) settingTextUnit.getAxisName()) && TextUnit.m5656equalsimpl0(this.value, settingTextUnit.value)) {
                return true;
            }
            return false;
        }

        @NotNull
        public String getAxisName() {
            return this.axisName;
        }

        public boolean getNeedsDensity() {
            return this.needsDensity;
        }

        /* renamed from: getValue-XSAIIZE  reason: not valid java name */
        public final long m5146getValueXSAIIZE() {
            return this.value;
        }

        public int hashCode() {
            return (getAxisName().hashCode() * 31) + TextUnit.m5660hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return "FontVariation.Setting(axisName='" + getAxisName() + "', value=" + TextUnit.m5666toStringimpl(this.value) + ')';
        }

        public float toVariationValue(@Nullable Density density) {
            if (density != null) {
                return TextUnit.m5659getValueimpl(this.value) * density.getFontScale();
            }
            throw new IllegalArgumentException("density must not be null".toString());
        }
    }

    @Immutable
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/font/FontVariation$Settings;", "", "settings", "", "Landroidx/compose/ui/text/font/FontVariation$Setting;", "([Landroidx/compose/ui/text/font/FontVariation$Setting;)V", "needsDensity", "", "getNeedsDensity$ui_text_release", "()Z", "", "getSettings", "()Ljava/util/List;", "equals", "other", "hashCode", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Settings {
        private final boolean needsDensity;
        @NotNull
        private final List<Setting> settings;

        public Settings(@NotNull Setting... settingArr) {
            Intrinsics.checkNotNullParameter(settingArr, "settings");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            boolean z11 = false;
            for (Setting setting : settingArr) {
                String axisName = setting.getAxisName();
                Object obj = linkedHashMap.get(axisName);
                if (obj == null) {
                    obj = new ArrayList();
                    linkedHashMap.put(axisName, obj);
                }
                ((List) obj).add(setting);
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                boolean z12 = true;
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    String str = (String) entry.getKey();
                    List list = (List) entry.getValue();
                    if (list.size() != 1 ? false : z12) {
                        boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
                    } else {
                        throw new IllegalArgumentException(('\'' + str + "' must be unique. Actual [ [" + CollectionsKt___CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + AbstractJsonLexerKt.END_LIST).toString());
                    }
                } else {
                    ArrayList arrayList2 = new ArrayList(arrayList);
                    this.settings = arrayList2;
                    int size = arrayList2.size();
                    int i11 = 0;
                    while (true) {
                        if (i11 >= size) {
                            break;
                        } else if (((Setting) arrayList2.get(i11)).getNeedsDensity()) {
                            z11 = true;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    this.needsDensity = z11;
                    return;
                }
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Settings) && Intrinsics.areEqual((Object) this.settings, (Object) ((Settings) obj).settings)) {
                return true;
            }
            return false;
        }

        public final boolean getNeedsDensity$ui_text_release() {
            return this.needsDensity;
        }

        @NotNull
        public final List<Setting> getSettings() {
            return this.settings;
        }

        public int hashCode() {
            return this.settings.hashCode();
        }
    }

    private FontVariation() {
    }

    @NotNull
    public final Setting Setting(@NotNull String str, float f11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "name");
        if (str.length() == 4) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new SettingFloat(str, f11);
        }
        throw new IllegalArgumentException(("Name must be exactly four characters. Actual: '" + str + '\'').toString());
    }

    @NotNull
    /* renamed from: Settings-6EWAqTQ  reason: not valid java name */
    public final Settings m5144Settings6EWAqTQ(@NotNull FontWeight fontWeight, int i11, @NotNull Setting... settingArr) {
        Intrinsics.checkNotNullParameter(fontWeight, "weight");
        Intrinsics.checkNotNullParameter(settingArr, "settings");
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.add(weight(fontWeight.getWeight()));
        spreadBuilder.add(italic((float) i11));
        spreadBuilder.addSpread(settingArr);
        return new Settings((Setting[]) spreadBuilder.toArray(new Setting[spreadBuilder.size()]));
    }

    @NotNull
    public final Setting grade(int i11) {
        boolean z11 = false;
        if (-1000 <= i11 && i11 < 1001) {
            z11 = true;
        }
        if (z11) {
            return new SettingInt("GRAD", i11);
        }
        throw new IllegalArgumentException("'GRAD' must be in -1000..1000".toString());
    }

    @NotNull
    public final Setting italic(float f11) {
        boolean z11 = false;
        if (0.0f <= f11 && f11 <= 1.0f) {
            z11 = true;
        }
        if (z11) {
            return new SettingFloat("ital", f11);
        }
        throw new IllegalArgumentException(("'ital' must be in 0.0f..1.0f. Actual: " + f11).toString());
    }

    @NotNull
    /* renamed from: opticalSizing--R2X_6o  reason: not valid java name */
    public final Setting m5145opticalSizingR2X_6o(long j11) {
        if (TextUnit.m5662isSpimpl(j11)) {
            return new SettingTextUnit("opsz", j11, (DefaultConstructorMarker) null);
        }
        throw new IllegalArgumentException("'opsz' must be provided in sp units".toString());
    }

    @NotNull
    public final Setting slant(float f11) {
        boolean z11 = false;
        if (-90.0f <= f11 && f11 <= 90.0f) {
            z11 = true;
        }
        if (z11) {
            return new SettingFloat("slnt", f11);
        }
        throw new IllegalArgumentException(("'slnt' must be in -90f..90f. Actual: " + f11).toString());
    }

    @NotNull
    public final Setting weight(int i11) {
        boolean z11 = false;
        if (1 <= i11 && i11 < 1001) {
            z11 = true;
        }
        if (z11) {
            return new SettingInt("wght", i11);
        }
        throw new IllegalArgumentException(("'wght' value must be in [1, 1000]. Actual: " + i11).toString());
    }

    @NotNull
    public final Setting width(float f11) {
        boolean z11;
        if (f11 > 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return new SettingFloat("wdth", f11);
        }
        throw new IllegalArgumentException(("'wdth' must be strictly > 0.0f. Actual: " + f11).toString());
    }
}
