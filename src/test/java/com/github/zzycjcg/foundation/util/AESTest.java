package com.github.zzycjcg.foundation.util;

import org.junit.Assert;
import org.junit.Test;

import com.github.zzycjcg.foundation.util.AESUtil;

public class AESTest
{
    @Test
    public void encrtpt()
    {
        Assert.assertEquals("4619a817510e3c0118ca7f5250166bde", AESUtil.encrypt("abc%^&WSX--", AESUtil.DEFAULT_KEY));
    }
    
    @Test
    public void decrypt()
    {
        Assert.assertEquals("abc%^&WSX--", AESUtil.decrypt("4619a817510e3c0118ca7f5250166bde", AESUtil.DEFAULT_KEY));
    }
}
