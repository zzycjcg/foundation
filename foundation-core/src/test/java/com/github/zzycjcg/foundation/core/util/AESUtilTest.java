package com.github.zzycjcg.foundation.core.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * The Class AESTest.
 *
 * @author zhiyong zhu at 2015-10-6
 * @since v0.0.1
 */
public class AESUtilTest
{
    /**
     * Encrtpt.
     */
    @Test
    public void encrtpt()
    {
        Assert.assertEquals("4619a817510e3c0118ca7f5250166bde", AESUtil.encrypt("abc%^&WSX--", AESUtil.DEFAULT_KEY));
    }
    
    /**
     * Decrypt.
     */
    @Test
    public void decrypt()
    {
        Assert.assertEquals("abc%^&WSX--", AESUtil.decrypt("4619a817510e3c0118ca7f5250166bde", AESUtil.DEFAULT_KEY));
    }
}
