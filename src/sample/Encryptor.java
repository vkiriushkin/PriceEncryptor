package sample;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

	public String encryptionKey;

	public String encrypt(String value) {
		try {
			// Get the KeyGenerator
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128);
			// Generate the secret key specs.
			SecretKey skey = kgen.generateKey();
			byte[] raw = skey.getEncoded();
			String key = new Base64().encodeAsString(raw);
			this.encryptionKey = key;
			System.out.println("------------------Key------------------");
			System.out.println("------Key length: "+ key.length() +"------------------");
			System.out.println(key);
			System.out.println("--------------End of Key---------------");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			String encrypt = (new Base64()).encodeAsString(cipher.doFinal(value.getBytes()));
			System.out.println("encrypted string:" + encrypt);
			return encrypt;
		} catch (NoSuchAlgorithmException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalBlockSizeException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		} catch (BadPaddingException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvalidKeyException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchPaddingException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		}
        return null;
	}

	public String getEncryptionKey() {
		return encryptionKey;
	}
}
