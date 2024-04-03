package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import j$.util.Optional;
import java.security.GeneralSecurityException;

@Immutable
public interface JwtPublicKeySignInternal {
    String signAndEncodeWithKid(RawJwt rawJwt, Optional<String> optional) throws GeneralSecurityException;
}
