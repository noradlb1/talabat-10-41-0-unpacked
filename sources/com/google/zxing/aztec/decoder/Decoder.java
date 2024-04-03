package com.google.zxing.aztec.decoder;

import androidx.exifinterface.media.ExifInterface;
import com.apptimize.c;
import com.apptimize.j;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.location.nlp.network.OnlineLocationService;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import datamodels.TypesAliasesKt;
import java.util.Arrays;
import java.util.List;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import org.apache.commons.lang3.StringUtils;
import org.json.HTTP;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class Decoder {
    private static final String[] DIGIT_TABLE = {"CTRL_PS", " ", "0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, OnlineLocationService.SRC_DEFAULT, "5", "6", "7", "8", "9", ",", RealDiscoveryConfigurationRepository.VERSION_DELIMETER, "CTRL_UL", "CTRL_US"};
    private static final String[] LOWER_TABLE = {"CTRL_PS", " ", "a", "b", c.f41585a, "d", "e", "f", "g", "h", "i", j.f43085a, "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", Param.X, Param.Y, CompressorStreamFactory.Z, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", StringUtils.LF, "\u000b", "\f", StringUtils.CR, "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", JavaConstant.Dynamic.DEFAULT_NAME, "`", "|", "~", "", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = {"", StringUtils.CR, HTTP.CRLF, ". ", IndicativeSentencesGeneration.DEFAULT_SEPARATOR, ": ", "!", "\"", "#", "$", "%", ContainerUtils.FIELD_DELIMITER, "'", "(", ")", "*", "+", ",", SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, RealDiscoveryConfigurationRepository.VERSION_DELIMETER, "/", CertificateUtil.DELIMITER, TypesAliasesKt.separator, "<", "=", ">", TypeDescription.Generic.OfWildcardType.SYMBOL, "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] UPPER_TABLE = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", RequestConfiguration.MAX_AD_CONTENT_RATING_G, "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private AztecDetectorResult ddata;

    /* renamed from: com.google.zxing.aztec.decoder.Decoder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.zxing.aztec.decoder.Decoder$Table[] r0 = com.google.zxing.aztec.decoder.Decoder.Table.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = r0
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.UPPER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.LOWER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.MIXED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.PUNCT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.DIGIT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.decoder.Decoder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static byte[] convertBoolArrayToByteArray(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = readByte(zArr, i11 << 3);
        }
        return bArr;
    }

    private boolean[] correctBits(boolean[] zArr) throws FormatException {
        int i11;
        GenericGF genericGF;
        boolean z11;
        boolean z12;
        if (this.ddata.getNbLayers() <= 2) {
            genericGF = GenericGF.AZTEC_DATA_6;
            i11 = 6;
        } else {
            i11 = 8;
            if (this.ddata.getNbLayers() <= 8) {
                genericGF = GenericGF.AZTEC_DATA_8;
            } else if (this.ddata.getNbLayers() <= 22) {
                genericGF = GenericGF.AZTEC_DATA_10;
                i11 = 10;
            } else {
                genericGF = GenericGF.AZTEC_DATA_12;
                i11 = 12;
            }
        }
        int nbDatablocks = this.ddata.getNbDatablocks();
        int length = zArr.length / i11;
        if (length >= nbDatablocks) {
            int length2 = zArr.length % i11;
            int[] iArr = new int[length];
            int i12 = 0;
            while (i12 < length) {
                iArr[i12] = readCode(zArr, length2, i11);
                i12++;
                length2 += i11;
            }
            try {
                new ReedSolomonDecoder(genericGF).decode(iArr, length - nbDatablocks);
                int i13 = (1 << i11) - 1;
                int i14 = 0;
                for (int i15 = 0; i15 < nbDatablocks; i15++) {
                    int i16 = iArr[i15];
                    if (i16 == 0 || i16 == i13) {
                        throw FormatException.getFormatInstance();
                    }
                    if (i16 == 1 || i16 == i13 - 1) {
                        i14++;
                    }
                }
                boolean[] zArr2 = new boolean[((nbDatablocks * i11) - i14)];
                int i17 = 0;
                for (int i18 = 0; i18 < nbDatablocks; i18++) {
                    int i19 = iArr[i18];
                    if (i19 == 1 || i19 == i13 - 1) {
                        int i21 = (i17 + i11) - 1;
                        if (i19 > 1) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        Arrays.fill(zArr2, i17, i21, z11);
                        i17 += i11 - 1;
                    } else {
                        int i22 = i11 - 1;
                        while (i22 >= 0) {
                            int i23 = i17 + 1;
                            if (((1 << i22) & i19) != 0) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            zArr2[i17] = z12;
                            i22--;
                            i17 = i23;
                        }
                    }
                }
                return zArr2;
            } catch (ReedSolomonException e11) {
                throw FormatException.getFormatInstance(e11);
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private boolean[] extractBits(BitMatrix bitMatrix) {
        int i11;
        int i12;
        BitMatrix bitMatrix2 = bitMatrix;
        boolean isCompact = this.ddata.isCompact();
        int nbLayers = this.ddata.getNbLayers();
        if (isCompact) {
            i11 = 11;
        } else {
            i11 = 14;
        }
        int i13 = i11 + (nbLayers << 2);
        int[] iArr = new int[i13];
        boolean[] zArr = new boolean[totalBitsInLayer(nbLayers, isCompact)];
        int i14 = 2;
        if (isCompact) {
            for (int i15 = 0; i15 < i13; i15++) {
                iArr[i15] = i15;
            }
        } else {
            int i16 = i13 / 2;
            int i17 = ((i13 + 1) + (((i16 - 1) / 15) * 2)) / 2;
            for (int i18 = 0; i18 < i16; i18++) {
                int i19 = (i18 / 15) + i18;
                iArr[(i16 - i18) - 1] = (i17 - i19) - 1;
                iArr[i16 + i18] = i19 + i17 + 1;
            }
        }
        int i21 = 0;
        int i22 = 0;
        while (i21 < nbLayers) {
            int i23 = (nbLayers - i21) << i14;
            if (isCompact) {
                i12 = 9;
            } else {
                i12 = 12;
            }
            int i24 = i23 + i12;
            int i25 = i21 << 1;
            int i26 = (i13 - 1) - i25;
            int i27 = 0;
            while (i27 < i24) {
                int i28 = i27 << 1;
                int i29 = 0;
                while (i29 < i14) {
                    int i31 = i25 + i29;
                    int i32 = i25 + i27;
                    zArr[i22 + i28 + i29] = bitMatrix2.get(iArr[i31], iArr[i32]);
                    int i33 = iArr[i32];
                    int i34 = i26 - i29;
                    boolean z11 = isCompact;
                    zArr[(i24 * 2) + i22 + i28 + i29] = bitMatrix2.get(i33, iArr[i34]);
                    int i35 = iArr[i34];
                    int i36 = i26 - i27;
                    zArr[(i24 * 4) + i22 + i28 + i29] = bitMatrix2.get(i35, iArr[i36]);
                    zArr[(i24 * 6) + i22 + i28 + i29] = bitMatrix2.get(iArr[i36], iArr[i31]);
                    i29++;
                    nbLayers = nbLayers;
                    isCompact = z11;
                    i14 = 2;
                }
                boolean z12 = isCompact;
                int i37 = nbLayers;
                i27++;
                i14 = 2;
            }
            boolean z13 = isCompact;
            int i38 = nbLayers;
            i22 += i24 << 3;
            i21++;
            i14 = 2;
        }
        return zArr;
    }

    private static String getCharacter(Table table, int i11) {
        int i12 = AnonymousClass1.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[table.ordinal()];
        if (i12 == 1) {
            return UPPER_TABLE[i11];
        }
        if (i12 == 2) {
            return LOWER_TABLE[i11];
        }
        if (i12 == 3) {
            return MIXED_TABLE[i11];
        }
        if (i12 == 4) {
            return PUNCT_TABLE[i11];
        }
        if (i12 == 5) {
            return DIGIT_TABLE[i11];
        }
        throw new IllegalStateException("Bad table");
    }

    private static String getEncodedData(boolean[] zArr) {
        int i11;
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb2 = new StringBuilder(20);
        Table table2 = table;
        int i12 = 0;
        while (i12 < length) {
            if (table == Table.BINARY) {
                if (length - i12 < 5) {
                    break;
                }
                int readCode = readCode(zArr, i12, 5);
                i12 += 5;
                if (readCode == 0) {
                    if (length - i12 < 11) {
                        break;
                    }
                    readCode = readCode(zArr, i12, 11) + 31;
                    i12 += 11;
                }
                int i13 = 0;
                while (true) {
                    if (i13 >= readCode) {
                        break;
                    } else if (length - i12 < 8) {
                        i12 = length;
                        break;
                    } else {
                        sb2.append((char) readCode(zArr, i12, 8));
                        i12 += 8;
                        i13++;
                    }
                }
            } else {
                if (table == Table.DIGIT) {
                    i11 = 4;
                } else {
                    i11 = 5;
                }
                if (length - i12 < i11) {
                    break;
                }
                int readCode2 = readCode(zArr, i12, i11);
                i12 += i11;
                String character = getCharacter(table, readCode2);
                if (character.startsWith("CTRL_")) {
                    table2 = getTable(character.charAt(5));
                    if (character.charAt(6) != 'L') {
                        Table table3 = table2;
                        table2 = table;
                        table = table3;
                    }
                } else {
                    sb2.append(character);
                }
            }
            table = table2;
        }
        return sb2.toString();
    }

    private static Table getTable(char c11) {
        if (c11 == 'B') {
            return Table.BINARY;
        }
        if (c11 == 'D') {
            return Table.DIGIT;
        }
        if (c11 == 'P') {
            return Table.PUNCT;
        }
        if (c11 == 'L') {
            return Table.LOWER;
        }
        if (c11 != 'M') {
            return Table.UPPER;
        }
        return Table.MIXED;
    }

    public static String highLevelDecode(boolean[] zArr) {
        return getEncodedData(zArr);
    }

    private static byte readByte(boolean[] zArr, int i11) {
        int readCode;
        int length = zArr.length - i11;
        if (length >= 8) {
            readCode = readCode(zArr, i11, 8);
        } else {
            readCode = readCode(zArr, i11, length) << (8 - length);
        }
        return (byte) readCode;
    }

    private static int readCode(boolean[] zArr, int i11, int i12) {
        int i13 = 0;
        for (int i14 = i11; i14 < i11 + i12; i14++) {
            i13 <<= 1;
            if (zArr[i14]) {
                i13 |= 1;
            }
        }
        return i13;
    }

    private static int totalBitsInLayer(int i11, boolean z11) {
        return ((z11 ? 88 : 112) + (i11 << 4)) * i11;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        boolean[] correctBits = correctBits(extractBits(aztecDetectorResult.getBits()));
        DecoderResult decoderResult = new DecoderResult(convertBoolArrayToByteArray(correctBits), getEncodedData(correctBits), (List<byte[]>) null, (String) null);
        decoderResult.setNumBits(correctBits.length);
        return decoderResult;
    }
}
