package androidx.datastore.preferences.protobuf;

import org.apache.commons.compress.archivers.tar.TarConstants;

final class TextFormatEscaper {

    /* renamed from: androidx.datastore.preferences.protobuf.TextFormatEscaper$2  reason: invalid class name */
    final class AnonymousClass2 implements ByteSequence {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ byte[] f35830a;

        public byte byteAt(int i11) {
            return this.f35830a[i11];
        }

        public int size() {
            return this.f35830a.length;
        }
    }

    public interface ByteSequence {
        byte byteAt(int i11);

        int size();
    }

    private TextFormatEscaper() {
    }

    public static String a(final ByteString byteString) {
        return b(new ByteSequence() {
            public byte byteAt(int i11) {
                return byteString.byteAt(i11);
            }

            public int size() {
                return byteString.size();
            }
        });
    }

    public static String b(ByteSequence byteSequence) {
        StringBuilder sb2 = new StringBuilder(byteSequence.size());
        for (int i11 = 0; i11 < byteSequence.size(); i11++) {
            byte byteAt = byteSequence.byteAt(i11);
            if (byteAt == 34) {
                sb2.append("\\\"");
            } else if (byteAt == 39) {
                sb2.append("\\'");
            } else if (byteAt != 92) {
                switch (byteAt) {
                    case 7:
                        sb2.append("\\a");
                        break;
                    case 8:
                        sb2.append("\\b");
                        break;
                    case 9:
                        sb2.append("\\t");
                        break;
                    case 10:
                        sb2.append("\\n");
                        break;
                    case 11:
                        sb2.append("\\v");
                        break;
                    case 12:
                        sb2.append("\\f");
                        break;
                    case 13:
                        sb2.append("\\r");
                        break;
                    default:
                        if (byteAt >= 32 && byteAt <= 126) {
                            sb2.append((char) byteAt);
                            break;
                        } else {
                            sb2.append('\\');
                            sb2.append((char) (((byteAt >>> 6) & 3) + 48));
                            sb2.append((char) (((byteAt >>> 3) & 7) + 48));
                            sb2.append((char) ((byteAt & 7) + TarConstants.LF_NORMAL));
                            break;
                        }
                        break;
                }
            } else {
                sb2.append("\\\\");
            }
        }
        return sb2.toString();
    }

    public static String c(String str) {
        return a(ByteString.copyFromUtf8(str));
    }
}
