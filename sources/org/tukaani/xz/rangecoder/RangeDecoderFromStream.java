package org.tukaani.xz.rangecoder;

import androidx.core.view.ViewCompat;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.CorruptedInputException;

public final class RangeDecoderFromStream extends RangeDecoder {
    private final DataInputStream inData;

    public RangeDecoderFromStream(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.inData = dataInputStream;
        if (dataInputStream.readUnsignedByte() == 0) {
            this.f63484b = dataInputStream.readInt();
            this.f63483a = -1;
            return;
        }
        throw new CorruptedInputException();
    }

    public boolean isFinished() {
        return this.f63484b == 0;
    }

    public void normalize() throws IOException {
        if ((this.f63483a & ViewCompat.MEASURED_STATE_MASK) == 0) {
            this.f63484b = (this.f63484b << 8) | this.inData.readUnsignedByte();
            this.f63483a <<= 8;
        }
    }
}
