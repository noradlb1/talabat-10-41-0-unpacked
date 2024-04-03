package org.objenesis.instantiator.basic;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import org.objenesis.ObjenesisException;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.instantiator.annotations.Instantiator;
import org.objenesis.instantiator.annotations.Typology;

@Instantiator(Typology.SERIALIZATION)
public class ObjectInputStreamInstantiator<T> implements ObjectInstantiator<T> {
    private final ObjectInputStream inputStream;

    public ObjectInputStreamInstantiator(Class<T> cls) {
        if (Serializable.class.isAssignableFrom(cls)) {
            try {
                this.inputStream = new ObjectInputStream(new MockStream(cls));
            } catch (IOException e11) {
                throw new Error("IOException: " + e11.getMessage());
            }
        } else {
            throw new ObjenesisException((Throwable) new NotSerializableException(cls + " not serializable"));
        }
    }

    public T newInstance() {
        try {
            return this.inputStream.readObject();
        } catch (ClassNotFoundException e11) {
            throw new Error("ClassNotFoundException: " + e11.getMessage());
        } catch (Exception e12) {
            throw new ObjenesisException((Throwable) e12);
        }
    }

    public static class MockStream extends InputStream {
        private static byte[] HEADER;
        private static final int[] NEXT = {1, 2, 2};
        private static byte[] REPEATING_DATA;
        private final byte[][] buffers;
        private byte[] data = HEADER;
        private int pointer = 0;
        private int sequence = 0;

        static {
            initialize();
        }

        public MockStream(Class<?> cls) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeByte(115);
                dataOutputStream.writeByte(114);
                dataOutputStream.writeUTF(cls.getName());
                dataOutputStream.writeLong(ObjectStreamClass.lookup(cls).getSerialVersionUID());
                dataOutputStream.writeByte(2);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeByte(120);
                dataOutputStream.writeByte(112);
                this.buffers = new byte[][]{HEADER, byteArrayOutputStream.toByteArray(), REPEATING_DATA};
            } catch (IOException e11) {
                throw new Error("IOException: " + e11.getMessage());
            }
        }

        private void advanceBuffer() {
            this.pointer = 0;
            int i11 = NEXT[this.sequence];
            this.sequence = i11;
            this.data = this.buffers[i11];
        }

        private static void initialize() {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeShort(-21267);
                dataOutputStream.writeShort(5);
                HEADER = byteArrayOutputStream.toByteArray();
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream2);
                dataOutputStream2.writeByte(115);
                dataOutputStream2.writeByte(113);
                dataOutputStream2.writeInt(8257536);
                REPEATING_DATA = byteArrayOutputStream2.toByteArray();
            } catch (IOException e11) {
                throw new Error("IOException: " + e11.getMessage());
            }
        }

        public int available() {
            return Integer.MAX_VALUE;
        }

        public int read() {
            byte[] bArr = this.data;
            int i11 = this.pointer;
            int i12 = i11 + 1;
            this.pointer = i12;
            byte b11 = bArr[i11];
            if (i12 >= bArr.length) {
                advanceBuffer();
            }
            return b11;
        }

        public int read(byte[] bArr, int i11, int i12) {
            int length = this.data.length - this.pointer;
            int i13 = i12;
            while (length <= i13) {
                System.arraycopy(this.data, this.pointer, bArr, i11, length);
                i11 += length;
                i13 -= length;
                advanceBuffer();
                length = this.data.length - this.pointer;
            }
            if (i13 > 0) {
                System.arraycopy(this.data, this.pointer, bArr, i11, i13);
                this.pointer += i13;
            }
            return i12;
        }
    }
}
