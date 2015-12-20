package com.github.zzycjcg.foundation.core.util;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 * The Class AES. <br>
 * ref: http://my.oschina.net/nicsun/blog/95632 http://stackoverflow.com/questions/10193567/java-security-
 * nosuchalgorithmexception-cannot-find-any-provider-supporting-aes
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public abstract class AESUtil
{
    /** The Constant DEFAULT_KEY. */
    public static final byte[] DEFAULT_KEY =
        new byte[] {0x4d, 0x31, 0x5b, 0x3e, 0x07, 0x0c, 0x00, 0x03, 0x66, 0x71, 0x0f, 0x21, 0x44, 0x2b, 0x3f, 0x27};
        
    /** The Constant CIPHER_ALGORITHM. */
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    
    /** The Constant KEY_ALGORITHM. */
    private static final String KEY_ALGORITHM = "AES";
    
    /**
     * Generate key.
     *
     * @return the byte[]
     * @throws GeneralSecurityException the general security exception
     */
    public static byte[] generateKey()
        throws GeneralSecurityException
    {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        // java max 128
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }
    
    private static Key toSecretKey(byte[] key)
    {
        SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
        return secretKey;
    }
    
    /**
     * Encrypt.
     *
     * @param data the data
     * @param key the key
     * @return the string
     */
    public static String encrypt(String data, byte[] key)
    {
        try
        {
            Key k = toSecretKey(key);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, k);
            byte[] toByteArray = data.getBytes();
            byte[] encrypted = cipher.doFinal(toByteArray);
            return Hex.encodeHexString(encrypted);
        }
        catch (GeneralSecurityException e)
        {
            throw new RuntimeException("Failed to encrypt.", e);
        }
    }
    
    /**
     * Decrypt.
     *
     * @param data the data
     * @param key the key
     * @return the string
     */
    public static String decrypt(String data, byte[] key)
    {
        try
        {
            Key k = toSecretKey(key);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, k);
            byte[] toByteArray = Hex.decodeHex(data.toCharArray());
            byte[] decrypted = cipher.doFinal(toByteArray);
            return new String(decrypted, "UTF-8");
        }
        catch (GeneralSecurityException e)
        {
            throw new RuntimeException("Failed to decrypt.", e);
        }
        catch (UnsupportedEncodingException e)
        {
            throw new RuntimeException(e);
        }
        catch (DecoderException e)
        {
            throw new RuntimeException(e);
        }
    }
}
