package com.xinyuan.Util;


import j2se.modules.Encryptor.MD5Encryptor;
import j2se.modules.Encryptor.RSAEncryptor;

import com.xinyuan.Crypto.AppKeysKeeper;
import com.xinyuan.model.User.User;

public class AppCryptoHelper {
    
    // convenient properties
    public static RSAEncryptor sharedInstance = null;
    public static RSAEncryptor getSharedInstance() throws Exception {
        if (sharedInstance == null) {
            sharedInstance = new RSAEncryptor();
            String prString = AppKeysKeeper.prKey.replaceAll("ZZ", "AA").replaceAll("MYQQ", "KOXQ");
            String puString = AppKeysKeeper.puKey.replaceAll("ZZ", "AA");
            sharedInstance.loadPrivateKey(prString);
            sharedInstance.loadPublicKey(puString);
        }
        return sharedInstance ;
    }
    
    
    public static String encodeWithRSA(String string) throws Exception {
        return getSharedInstance().encryptWithBase64(string);
    }
    public static String decodeWithRSA(String string) throws Exception {
        return getSharedInstance().decryptWithBase64(string);
    }
    

    
    
    public static String encodeWithMD5(String string) {
        return MD5Encryptor.encode2hex(string);
    }
    
    public static boolean isUserPasswordCorrect(User model, User persistence) {
        
        String modelPassword = model.getPassword();
        try {
            modelPassword = decodeWithRSA(modelPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String persistencePassword = persistence.getPassword();
        
        
        return MD5Encryptor.validate(modelPassword, persistencePassword);
    }
    
    
    
}
