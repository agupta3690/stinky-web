package com.bhf.automation.stepDefinitions;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestAPI{

	private static final int INIT_VECTOR_SIZE = 16;
	static  String CLEAR_TEXT;
	private static final String ENCRYPTION_KEY = "PFeNXWm18/Y3+MXU1s0eRCXGB2caflJfG/ZE8uPo+js=";
	static  String BHF_ENCRYPTED_TEXT = "ZZ1NiBaQT7Gq8A8n+4NvmTocGvY=";

	public TestAPI() {
		// TODO Auto-generated constructor stub
	}

	public static void main (String args[]) {


		Scanner in = new Scanner(System.in); 

		System.out.println("Enter Service Name"); 
		final String CLEAR_TEXT = in.nextLine(); 
		System.out.println("Service name is "+CLEAR_TEXT); 

		System.out.println("Enter Request Body"); 
		String RequestBody = in.nextLine(); 
		System.out.println("Request body is "+RequestBody); 


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


