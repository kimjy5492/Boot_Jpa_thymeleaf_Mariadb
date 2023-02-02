package com.example.jpa.comm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.*;

class CommEncryptTest {

    @Value("${encrypt.key16}")
    private String strKey16;

    @Test
    void encryptSha256() {
        /* 단방향 Test */
        CommEncrypt commEncrypt = new CommEncrypt();
        String strName = "1234!@#";
        String strNameEncrypt = commEncrypt.encryptSha256(strName);
        System.out.println(strNameEncrypt);
    }

    @Test
    void encryptAes() throws Exception {
        //String strKey16 = "abcdefg123he334g";
        String strName = "AES 방식으로 사용을 하였는 데 사용되는 key는 값이";
        System.out.println("strKey16 : " + strKey16);
        /* 양방향 Test */
        CommEncrypt commEncrypt = new CommEncrypt();
        String strNameEncrypt = commEncrypt.encryptAes(strName,strKey16);

        System.out.println(strNameEncrypt);
    }

    @Test
    void decryptAes() throws Exception {
        //String strKey16 = "abcdefg123he334g";
        String strName = "+ZZBpJCY37ZjhxbCblzb2IMEU067gpnClsxdkhC02PLN1OjNFJAVktXtYDdo6RtMPTO/50kZoHf/27hO0EClGkl5sB9925KVHRwsBd0PqE4=";
        /* 양방향 Test */
        CommEncrypt commEncrypt = new CommEncrypt();
        String strNameDecrypt = commEncrypt.decryptAes(strName,strKey16);
        System.out.println(strNameDecrypt);
    }
}