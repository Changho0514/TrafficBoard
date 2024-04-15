package com.study.boardserver.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SHA256Util {

    public static final String ENCRYPTION_KEY = "SHA-256";

    public static String encryptSHA256(String str) {
        String SHA = null;

        MessageDigest sh;

        try {
            sh = MessageDigest.getInstance(ENCRYPTION_KEY);
            sh.update(str.getBytes());
            byte[] byteData = sh.digest();
            StringBuffer sb = new StringBuffer();
            for (byte byteDatum : byteData) {
                sb.append(Integer.toString((byteDatum & 0xff) + 0x100, 16).substring(1));

            }
            SHA = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("encryptSHA256 ERROR : {}", e.getMessage());
            SHA = null;
        }
        return SHA;
    }

}
