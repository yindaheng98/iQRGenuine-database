import org.junit.Test;

import iQRGenuine.util.RSATool;

import java.nio.charset.StandardCharsets;

public class TestRSATool
{
    //@Test
    public void sign_verify()
    {
        try
        {
            //私钥加密 公钥解密
            //生成私钥-公钥对
            byte[][] v = RSATool.getKeyPairBytes();
            //获得摘要
            byte[] source = "okokokokokok".getBytes();
            //使用私钥对摘要进行加密 获得密文 即数字签名
            byte[] sign = RSATool.sign(v[0], source);
            //使用公钥对密文进行解密,解密后与摘要进行匹配
            boolean yes = RSATool.verify(v[1], source, sign);
            if (yes)
                System.out.println("yes!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void encrypt_decrypt()
    {
        try
        {
            //私钥加密公钥解密
            //获得摘要
            byte[] sourcepri_pub = "hahahaha".getBytes(StandardCharsets.UTF_8);

            //生成密钥对
            byte[][] v = RSATool.getKeyPairBytes();

            //使用私钥对摘要进行加密 获得密文
            byte[] signpri_pub = RSATool.encrypt(v[0], sourcepri_pub);

            //使用公钥对密文进行解密 返回解密后的数据
            byte[] newSourcepri_pub = RSATool.decrypt(v[1], signpri_pub);

            System.out.println("private key:" + RSATool.base64Encode(v[0]));
            System.out.println("public key:" + RSATool.base64Encode(v[1]));
            System.out.println("cipher text:" + RSATool.base64Encode(signpri_pub));
            System.out.println("plain text:" + new String(newSourcepri_pub, StandardCharsets.UTF_8));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
