package kotlin.experimental;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\f\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\b\u001a\r\u0010\u0004\u001a\u00020\u0003*\u00020\u0003H\b\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0005\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\f\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\f¨\u0006\u0007"}, d2 = {"and", "", "other", "", "inv", "or", "xor", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BitwiseOperationsKt {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte and(byte b11, byte b12) {
        return (byte) (b11 & b12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short and(short s11, short s12) {
        return (short) (s11 & s12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte inv(byte b11) {
        return (byte) (~b11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short inv(short s11) {
        return (short) (~s11);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte or(byte b11, byte b12) {
        return (byte) (b11 | b12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short or(short s11, short s12) {
        return (short) (s11 | s12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte xor(byte b11, byte b12) {
        return (byte) (b11 ^ b12);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short xor(short s11, short s12) {
        return (short) (s11 ^ s12);
    }
}
