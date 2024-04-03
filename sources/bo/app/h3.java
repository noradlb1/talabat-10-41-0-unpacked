package bo.app;

import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.support.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u000bB]\b\u0002\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0019\u0010\u001aB\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u0019\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0016\u0010\fR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\f¨\u0006\u001e"}, d2 = {"Lbo/app/h3;", "", "", "toString", "", "hashCode", "other", "", "equals", "backgroundColor", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "textColor", "g", "closeButtonColor", "b", "iconColor", "f", "iconBackgroundColor", "e", "headerTextColor", "d", "frameColor", "c", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Lorg/json/JSONObject;", "messageThemeJson", "(Lorg/json/JSONObject;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class h3 {

    /* renamed from: h  reason: collision with root package name */
    public static final a f38607h = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Integer f38608a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f38609b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f38610c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f38611d;

    /* renamed from: e  reason: collision with root package name */
    private final Integer f38612e;

    /* renamed from: f  reason: collision with root package name */
    private final Integer f38613f;

    /* renamed from: g  reason: collision with root package name */
    private final Integer f38614g;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"Lbo/app/h3$a;", "", "", "BACKGROUND_COLOR_KEY", "Ljava/lang/String;", "CLOSE_BUTTON_COLOR_KEY", "FRAME_COLOR_KEY", "HEADER_TEXT_COLOR_KEY", "ICON_BG_COLOR_KEY", "ICON_COLOR_KEY", "TEXT_COLOR_KEY", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private h3(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
        this.f38608a = num;
        this.f38609b = num2;
        this.f38610c = num3;
        this.f38611d = num4;
        this.f38612e = num5;
        this.f38613f = num6;
        this.f38614g = num7;
    }

    public final Integer a() {
        return this.f38608a;
    }

    public final Integer b() {
        return this.f38610c;
    }

    public final Integer c() {
        return this.f38614g;
    }

    public final Integer d() {
        return this.f38613f;
    }

    public final Integer e() {
        return this.f38612e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h3)) {
            return false;
        }
        h3 h3Var = (h3) obj;
        return Intrinsics.areEqual((Object) this.f38608a, (Object) h3Var.f38608a) && Intrinsics.areEqual((Object) this.f38609b, (Object) h3Var.f38609b) && Intrinsics.areEqual((Object) this.f38610c, (Object) h3Var.f38610c) && Intrinsics.areEqual((Object) this.f38611d, (Object) h3Var.f38611d) && Intrinsics.areEqual((Object) this.f38612e, (Object) h3Var.f38612e) && Intrinsics.areEqual((Object) this.f38613f, (Object) h3Var.f38613f) && Intrinsics.areEqual((Object) this.f38614g, (Object) h3Var.f38614g);
    }

    public final Integer f() {
        return this.f38611d;
    }

    public final Integer g() {
        return this.f38609b;
    }

    public int hashCode() {
        Integer num = this.f38608a;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.f38609b;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f38610c;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f38611d;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.f38612e;
        int hashCode5 = (hashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.f38613f;
        int hashCode6 = (hashCode5 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.f38614g;
        if (num7 != null) {
            i11 = num7.hashCode();
        }
        return hashCode6 + i11;
    }

    public String toString() {
        return "InAppMessageTheme(backgroundColor=" + this.f38608a + ", textColor=" + this.f38609b + ", closeButtonColor=" + this.f38610c + ", iconColor=" + this.f38611d + ", iconBackgroundColor=" + this.f38612e + ", headerTextColor=" + this.f38613f + ", frameColor=" + this.f38614g + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public h3(JSONObject jSONObject) {
        this(JsonUtils.getColorIntegerOrNull(jSONObject, InAppMessageBase.BG_COLOR), JsonUtils.getColorIntegerOrNull(jSONObject, InAppMessageBase.MESSAGE_TEXT_COLOR), JsonUtils.getColorIntegerOrNull(jSONObject, "close_btn_color"), JsonUtils.getColorIntegerOrNull(jSONObject, InAppMessageBase.ICON_COLOR), JsonUtils.getColorIntegerOrNull(jSONObject, InAppMessageBase.ICON_BG_COLOR), JsonUtils.getColorIntegerOrNull(jSONObject, "header_text_color"), JsonUtils.getColorIntegerOrNull(jSONObject, "frame_color"));
        Intrinsics.checkNotNullParameter(jSONObject, "messageThemeJson");
    }
}
