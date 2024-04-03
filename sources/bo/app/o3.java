package bo.app;

import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.support.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u000bB-\b\u0002\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0011\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f¨\u0006\u0016"}, d2 = {"Lbo/app/o3;", "", "", "toString", "", "hashCode", "other", "", "equals", "backgroundColor", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "textColor", "c", "borderColor", "b", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Lorg/json/JSONObject;", "buttonThemeJson", "(Lorg/json/JSONObject;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public final class o3 {

    /* renamed from: d  reason: collision with root package name */
    public static final a f39097d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Integer f39098a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f39099b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f39100c;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lbo/app/o3$a;", "", "", "BACKGROUND_COLOR_KEY", "Ljava/lang/String;", "BORDER_COLOR_KEY", "TEXT_COLOR_KEY", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private o3(Integer num, Integer num2, Integer num3) {
        this.f39098a = num;
        this.f39099b = num2;
        this.f39100c = num3;
    }

    public final Integer a() {
        return this.f39098a;
    }

    public final Integer b() {
        return this.f39100c;
    }

    public final Integer c() {
        return this.f39099b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o3)) {
            return false;
        }
        o3 o3Var = (o3) obj;
        return Intrinsics.areEqual((Object) this.f39098a, (Object) o3Var.f39098a) && Intrinsics.areEqual((Object) this.f39099b, (Object) o3Var.f39099b) && Intrinsics.areEqual((Object) this.f39100c, (Object) o3Var.f39100c);
    }

    public int hashCode() {
        Integer num = this.f39098a;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.f39099b;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f39100c;
        if (num3 != null) {
            i11 = num3.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "MessageButtonTheme(backgroundColor=" + this.f39098a + ", textColor=" + this.f39099b + ", borderColor=" + this.f39100c + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public o3(JSONObject jSONObject) {
        this(JsonUtils.getColorIntegerOrNull(jSONObject, InAppMessageBase.BG_COLOR), JsonUtils.getColorIntegerOrNull(jSONObject, InAppMessageBase.MESSAGE_TEXT_COLOR), JsonUtils.getColorIntegerOrNull(jSONObject, "border_color"));
        Intrinsics.checkNotNullParameter(jSONObject, "buttonThemeJson");
    }
}
