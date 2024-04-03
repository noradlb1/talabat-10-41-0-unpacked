package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

public abstract class AbstractMessageLite implements MessageLite {

    /* renamed from: b  reason: collision with root package name */
    public int f24746b = 0;

    public UninitializedMessageException a() {
        return new UninitializedMessageException(this);
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream, CodedOutputStream.a(CodedOutputStream.computeRawVarint32Size(serializedSize) + serializedSize));
        newInstance.writeRawVarint32(serializedSize);
        writeTo(newInstance);
        newInstance.flush();
    }

    public static abstract class Builder<BuilderType extends Builder> implements MessageLite.Builder {
        public static UninitializedMessageException a(MessageLite messageLite) {
            return new UninitializedMessageException(messageLite);
        }

        public abstract BuilderType clone();

        public abstract BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        public static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            public LimitedInputStream(InputStream inputStream, int i11) {
                super(inputStream);
                this.limit = i11;
            }

            public int available() throws IOException {
                return Math.min(super.available(), this.limit);
            }

            public int read() throws IOException {
                if (this.limit <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.limit--;
                }
                return read;
            }

            public long skip(long j11) throws IOException {
                long skip = super.skip(Math.min(j11, (long) this.limit));
                if (skip >= 0) {
                    this.limit = (int) (((long) this.limit) - skip);
                }
                return skip;
            }

            public int read(byte[] bArr, int i11, int i12) throws IOException {
                int i13 = this.limit;
                if (i13 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i11, Math.min(i12, i13));
                if (read >= 0) {
                    this.limit -= read;
                }
                return read;
            }
        }
    }
}
