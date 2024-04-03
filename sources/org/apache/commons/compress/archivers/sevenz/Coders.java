package org.apache.commons.compress.archivers.sevenz;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.utils.FlushShieldFilterOutputStream;
import org.tukaani.xz.ARMOptions;
import org.tukaani.xz.ARMThumbOptions;
import org.tukaani.xz.FilterOptions;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.IA64Options;
import org.tukaani.xz.PowerPCOptions;
import org.tukaani.xz.SPARCOptions;
import org.tukaani.xz.X86Options;

class Coders {
    private static final Map<SevenZMethod, CoderBase> CODER_MAP = new HashMap<SevenZMethod, CoderBase>() {
        private static final long serialVersionUID = 1664829131806520867L;

        {
            put(SevenZMethod.COPY, new CopyDecoder());
            put(SevenZMethod.LZMA, new LZMADecoder());
            put(SevenZMethod.LZMA2, new LZMA2Decoder());
            put(SevenZMethod.DEFLATE, new DeflateDecoder());
            put(SevenZMethod.DEFLATE64, new Deflate64Decoder());
            put(SevenZMethod.BZIP2, new BZIP2Decoder());
            put(SevenZMethod.AES256SHA256, new AES256SHA256Decoder());
            put(SevenZMethod.BCJ_X86_FILTER, new BCJDecoder(new X86Options()));
            put(SevenZMethod.BCJ_PPC_FILTER, new BCJDecoder(new PowerPCOptions()));
            put(SevenZMethod.BCJ_IA64_FILTER, new BCJDecoder(new IA64Options()));
            put(SevenZMethod.BCJ_ARM_FILTER, new BCJDecoder(new ARMOptions()));
            put(SevenZMethod.BCJ_ARM_THUMB_FILTER, new BCJDecoder(new ARMThumbOptions()));
            put(SevenZMethod.BCJ_SPARC_FILTER, new BCJDecoder(new SPARCOptions()));
            put(SevenZMethod.DELTA_FILTER, new DeltaDecoder());
        }
    };

    public static class BCJDecoder extends CoderBase {
        private final FilterOptions opts;

        public BCJDecoder(FilterOptions filterOptions) {
            super(new Class[0]);
            this.opts = filterOptions;
        }

        public InputStream b(String str, InputStream inputStream, long j11, Coder coder, byte[] bArr, int i11) throws IOException {
            try {
                return this.opts.getInputStream(inputStream);
            } catch (AssertionError e11) {
                throw new IOException("BCJ filter used in " + str + " needs XZ for Java > 1.4 - see https://commons.apache.org/proper/commons-compress/limitations.html#7Z", e11);
            }
        }

        public OutputStream c(OutputStream outputStream, Object obj) {
            return new FlushShieldFilterOutputStream(this.opts.getOutputStream(new FinishableWrapperOutputStream(outputStream)));
        }
    }

    public static class BZIP2Decoder extends CoderBase {
        public BZIP2Decoder() {
            super(Number.class);
        }

        public InputStream b(String str, InputStream inputStream, long j11, Coder coder, byte[] bArr, int i11) throws IOException {
            return new BZip2CompressorInputStream(inputStream);
        }

        public OutputStream c(OutputStream outputStream, Object obj) throws IOException {
            return new BZip2CompressorOutputStream(outputStream, CoderBase.f(obj, 9));
        }
    }

    public static class CopyDecoder extends CoderBase {
        public CopyDecoder() {
            super(new Class[0]);
        }

        public InputStream b(String str, InputStream inputStream, long j11, Coder coder, byte[] bArr, int i11) throws IOException {
            return inputStream;
        }

        public OutputStream c(OutputStream outputStream, Object obj) {
            return outputStream;
        }
    }

    public static class Deflate64Decoder extends CoderBase {
        public Deflate64Decoder() {
            super(Number.class);
        }

        public InputStream b(String str, InputStream inputStream, long j11, Coder coder, byte[] bArr, int i11) throws IOException {
            return new Deflate64CompressorInputStream(inputStream);
        }
    }

    public static class DeflateDecoder extends CoderBase {
        private static final byte[] ONE_ZERO_BYTE = new byte[1];

        public static class DeflateDecoderInputStream extends InputStream {

            /* renamed from: b  reason: collision with root package name */
            public final InflaterInputStream f27612b;

            /* renamed from: c  reason: collision with root package name */
            public Inflater f27613c;

            public DeflateDecoderInputStream(InflaterInputStream inflaterInputStream, Inflater inflater) {
                this.f27612b = inflaterInputStream;
                this.f27613c = inflater;
            }

            public void close() throws IOException {
                try {
                    this.f27612b.close();
                } finally {
                    this.f27613c.end();
                }
            }

            public int read() throws IOException {
                return this.f27612b.read();
            }

            public int read(byte[] bArr, int i11, int i12) throws IOException {
                return this.f27612b.read(bArr, i11, i12);
            }

            public int read(byte[] bArr) throws IOException {
                return this.f27612b.read(bArr);
            }
        }

        public static class DeflateDecoderOutputStream extends OutputStream {

            /* renamed from: b  reason: collision with root package name */
            public final DeflaterOutputStream f27614b;

            /* renamed from: c  reason: collision with root package name */
            public Deflater f27615c;

            public DeflateDecoderOutputStream(DeflaterOutputStream deflaterOutputStream, Deflater deflater) {
                this.f27614b = deflaterOutputStream;
                this.f27615c = deflater;
            }

            public void close() throws IOException {
                try {
                    this.f27614b.close();
                } finally {
                    this.f27615c.end();
                }
            }

            public void write(int i11) throws IOException {
                this.f27614b.write(i11);
            }

            public void write(byte[] bArr) throws IOException {
                this.f27614b.write(bArr);
            }

            public void write(byte[] bArr, int i11, int i12) throws IOException {
                this.f27614b.write(bArr, i11, i12);
            }
        }

        public DeflateDecoder() {
            super(Number.class);
        }

        public InputStream b(String str, InputStream inputStream, long j11, Coder coder, byte[] bArr, int i11) throws IOException {
            Inflater inflater = new Inflater(true);
            return new DeflateDecoderInputStream(new InflaterInputStream(new SequenceInputStream(inputStream, new ByteArrayInputStream(ONE_ZERO_BYTE)), inflater), inflater);
        }

        public OutputStream c(OutputStream outputStream, Object obj) {
            Deflater deflater = new Deflater(CoderBase.f(obj, 9), true);
            return new DeflateDecoderOutputStream(new DeflaterOutputStream(outputStream, deflater), deflater);
        }
    }

    public static InputStream a(String str, InputStream inputStream, long j11, Coder coder, byte[] bArr, int i11) throws IOException {
        CoderBase c11 = c(SevenZMethod.byId(coder.f27608a));
        if (c11 != null) {
            return c11.b(str, inputStream, j11, coder, bArr, i11);
        }
        throw new IOException("Unsupported compression method " + Arrays.toString(coder.f27608a) + " used in " + str);
    }

    public static OutputStream b(OutputStream outputStream, SevenZMethod sevenZMethod, Object obj) throws IOException {
        CoderBase c11 = c(sevenZMethod);
        if (c11 != null) {
            return c11.c(outputStream, obj);
        }
        throw new IOException("Unsupported compression method " + sevenZMethod);
    }

    public static CoderBase c(SevenZMethod sevenZMethod) {
        return CODER_MAP.get(sevenZMethod);
    }
}
