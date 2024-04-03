package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, d2 = {"kotlinx/serialization/json/internal/AbstractJsonTreeEncoder$encodeTaggedInline$1", "Lkotlinx/serialization/encoding/AbstractEncoder;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "encodeByte", "", "value", "", "encodeInt", "", "encodeLong", "", "encodeShort", "", "putUnquotedString", "s", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AbstractJsonTreeEncoder$encodeTaggedInline$1 extends AbstractEncoder {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractJsonTreeEncoder f26440a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f26441b;
    @NotNull
    private final SerializersModule serializersModule;

    public AbstractJsonTreeEncoder$encodeTaggedInline$1(AbstractJsonTreeEncoder abstractJsonTreeEncoder, String str) {
        this.f26440a = abstractJsonTreeEncoder;
        this.f26441b = str;
        this.serializersModule = abstractJsonTreeEncoder.getJson().getSerializersModule();
    }

    public void encodeByte(byte b11) {
        putUnquotedString(UByte.m6390toStringimpl(UByte.m6347constructorimpl(b11)));
    }

    public void encodeInt(int i11) {
        putUnquotedString(UInt.m6468toStringimpl(UInt.m6423constructorimpl(i11)));
    }

    public void encodeLong(long j11) {
        putUnquotedString(ULong.m6546toStringimpl(ULong.m6501constructorimpl(j11)));
    }

    public void encodeShort(short s11) {
        putUnquotedString(UShort.m6650toStringimpl(UShort.m6607constructorimpl(s11)));
    }

    @NotNull
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public final void putUnquotedString(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "s");
        this.f26440a.putElement(this.f26441b, new JsonLiteral(str, false));
    }
}
