package com.bhf.automation.stepDefinitions;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptDecrypt {

    /** Initialization vector block size. */
    private static final int INIT_VECTOR_SIZE = 16;
    private static final String CLEAR_TEXT = "{\"EiamIdReq\": \"7314C726AA454AFF8C7C04DF7B18A3E0\"}";
    private static final String ENCRYPTION_KEY = "PFeNXWm18/Y3+MXU1s0eRCXGB2caflJfG/ZE8uPo+js=";
    private static final String BHF_ENCRYPTED_TEXT = "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";
    		public EncryptDecrypt() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        try {

            final byte[] key = Base64.getDecoder().decode(ENCRYPTION_KEY.getBytes());
            final byte[] bhfEncryptedBytes = Base64.getDecoder().decode(BHF_ENCRYPTED_TEXT.getBytes());
            // Encrypt String
            final byte[] encryptedBytes = encryptIOT(CLEAR_TEXT.getBytes(), key);
            String str = new String(encryptedBytes);
            System.out.println("encypted bytes: " + new String(Base64.getEncoder().encode(encryptedBytes)));
            // Decrypt String
            final byte[] decryptString = decryptIOT(bhfEncryptedBytes, key);
            System.out.println("decrypt string: " + new String(decryptString));
            
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(":::::Completed:::::");
            System.exit(-1);
        }
    }

    public static byte[] encryptIOT(byte[] dataToEncrypt, byte[] encryptionKey) throws Exception {

        final byte[] initVector = new byte[INIT_VECTOR_SIZE];
        SecureRandom secuRand = new SecureRandom();
        // set IV into cipher to prefix encrypted bytes
        secuRand.nextBytes(initVector);
        SecretKeySpec keySpec = new SecretKeySpec(encryptionKey, "AES");
        IvParameterSpec ivspec = new IvParameterSpec(initVector);

        byte[] encryptedData = null;

        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, keySpec, ivspec);
            encryptedData = cipher.doFinal(dataToEncrypt);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("::::::ENCRYPTION FAILED::::::");
        }

        byte[] envelopedData = new byte[initVector.length + encryptedData.length];
        System.arraycopy(initVector, 0, envelopedData, 0, initVector.length);
        System.arraycopy(encryptedData, 0, envelopedData, initVector.length, encryptedData.length);
        return envelopedData;
    }

    public static byte[] decryptIOT(byte[] encryptedData, byte[] encryptionKey) throws Exception {

        byte[] initVector = Arrays.copyOfRange(encryptedData, 0, INIT_VECTOR_SIZE);
        byte[] dataToDecrypt = Arrays.copyOfRange(encryptedData, INIT_VECTOR_SIZE, encryptedData.length);
        SecretKeySpec keySpec = new SecretKeySpec(encryptionKey, "AES");
        IvParameterSpec initVectorSpec = new IvParameterSpec(initVector);

        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, keySpec, initVectorSpec);
            byte[] decryptedData = cipher.doFinal(dataToDecrypt);
            return decryptedData;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("::::::DECRYPTION FAILED::::::");
        }

    }

}