package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractMessageLite;
import androidx.datastore.preferences.protobuf.AbstractMessageLite.Builder;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.MessageLite;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode = 0;

    public interface InternalOneOfEnum {
        int getNumber();
    }

    public static <T> void a(Iterable<T> iterable, List<? super T> list) {
        Builder.a(iterable, list);
    }

    public static void b(ByteString byteString) throws IllegalArgumentException {
        if (!byteString.isValidUtf8()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String getSerializingExceptionMessage(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    /* access modifiers changed from: package-private */
    public int c() {
        throw new UnsupportedOperationException();
    }

    public int d(Schema schema) {
        int c11 = c();
        if (c11 != -1) {
            return c11;
        }
        int serializedSize = schema.getSerializedSize(this);
        f(serializedSize);
        return serializedSize;
    }

    public UninitializedMessageException e() {
        return new UninitializedMessageException((MessageLite) this);
    }

    /* access modifiers changed from: package-private */
    public void f(int i11) {
        throw new UnsupportedOperationException();
    }

    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream newInstance = CodedOutputStream.newInstance(bArr);
            writeTo(newInstance);
            newInstance.checkNoSpaceLeft();
            return bArr;
        } catch (IOException e11) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e11);
        }
    }

    public ByteString toByteString() {
        try {
            ByteString.CodedBuilder g11 = ByteString.g(getSerializedSize());
            writeTo(g11.getCodedOutput());
            return g11.build();
        } catch (IOException e11) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e11);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream, CodedOutputStream.g(CodedOutputStream.computeRawVarint32Size(serializedSize) + serializedSize));
        newInstance.writeRawVarint32(serializedSize);
        writeTo(newInstance);
        newInstance.flush();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream, CodedOutputStream.g(getSerializedSize()));
        writeTo(newInstance);
        newInstance.flush();
    }

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {
        public static <T> void a(Iterable<T> iterable, List<? super T> list) {
            Internal.a(iterable);
            if (iterable instanceof LazyStringList) {
                List<?> underlyingElements = ((LazyStringList) iterable).getUnderlyingElements();
                LazyStringList lazyStringList = (LazyStringList) list;
                int size = list.size();
                for (Object next : underlyingElements) {
                    if (next == null) {
                        String str = "Element at index " + (lazyStringList.size() - size) + " is null.";
                        for (int size2 = lazyStringList.size() - 1; size2 >= size; size2--) {
                            lazyStringList.remove(size2);
                        }
                        throw new NullPointerException(str);
                    } else if (next instanceof ByteString) {
                        lazyStringList.add((ByteString) next);
                    } else {
                        lazyStringList.add((String) next);
                    }
                }
            } else if (iterable instanceof PrimitiveNonBoxingCollection) {
                list.addAll((Collection) iterable);
            } else {
                addAllCheckingNulls(iterable, list);
            }
        }

        private static <T> void addAllCheckingNulls(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T next : iterable) {
                if (next == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(next);
            }
        }

        public static UninitializedMessageException c(MessageLite messageLite) {
            return new UninitializedMessageException(messageLite);
        }

        private String getReadingExceptionMessage(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        public abstract BuilderType b(MessageType messagetype);

        public abstract BuilderType clone();

        public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            mergeFrom((InputStream) new LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)), extensionRegistryLite);
            return true;
        }

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

        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return mergeDelimitedFrom(inputStream, ExtensionRegistryLite.getEmptyRegistry());
        }

        public BuilderType mergeFrom(CodedInputStream codedInputStream) throws IOException {
            return mergeFrom(codedInputStream, ExtensionRegistryLite.getEmptyRegistry());
        }

        public BuilderType mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            try {
                CodedInputStream newCodedInput = byteString.newCodedInput();
                mergeFrom(newCodedInput);
                newCodedInput.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e11) {
                throw e11;
            } catch (IOException e12) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e12);
            }
        }

        public BuilderType mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            try {
                CodedInputStream newCodedInput = byteString.newCodedInput();
                mergeFrom(newCodedInput, extensionRegistryLite);
                newCodedInput.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e11) {
                throw e11;
            } catch (IOException e12) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e12);
            }
        }

        public BuilderType mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, 0, bArr.length);
        }

        public BuilderType mergeFrom(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException {
            try {
                CodedInputStream newInstance = CodedInputStream.newInstance(bArr, i11, i12);
                mergeFrom(newInstance);
                newInstance.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e11) {
                throw e11;
            } catch (IOException e12) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e12);
            }
        }

        public BuilderType mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return mergeFrom(bArr, 0, bArr.length, extensionRegistryLite);
        }

        public BuilderType mergeFrom(byte[] bArr, int i11, int i12, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            try {
                CodedInputStream newInstance = CodedInputStream.newInstance(bArr, i11, i12);
                mergeFrom(newInstance, extensionRegistryLite);
                newInstance.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e11) {
                throw e11;
            } catch (IOException e12) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e12);
            }
        }

        public BuilderType mergeFrom(InputStream inputStream) throws IOException {
            CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
            mergeFrom(newInstance);
            newInstance.checkLastTagWas(0);
            return this;
        }

        public BuilderType mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
            mergeFrom(newInstance, extensionRegistryLite);
            newInstance.checkLastTagWas(0);
            return this;
        }

        public BuilderType mergeFrom(MessageLite messageLite) {
            if (getDefaultInstanceForType().getClass().isInstance(messageLite)) {
                return b((AbstractMessageLite) messageLite);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }
}
