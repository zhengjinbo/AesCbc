package com.zjb.aescbc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            setContentView(R.layout.activity_main);
            // 需要加密的字串
            String cSrc = "[{\"request_noz郑锦波ABCDEFGHIJKLMNOPQRTUVWXYZabcdefghijklmnopqrstuvwxyz\":\"!@#$%^&*()_+<>,./1001\",\"service_code\":\"FS0001\",\"contract_id\":\"100002\",\"order_id\":\"0\",\"phone_id\":\"13913996922\",\"plat_offer_id\":\"100094\",\"channel_id\":\"1\",\"activity_id\":\"100045\"}]";
            Log.e("需要加密的字串：", cSrc);
            // 加密
            long lStart = System.currentTimeMillis();
            String enString = null;
            enString = AESOperator.getInstance().encrypt(cSrc);
            Log.e("加密后的字串是：", enString);
            long lUseTime = System.currentTimeMillis() - lStart;
            Log.e("加密耗时：", lUseTime + "毫秒");
            // 解密
            lStart = System.currentTimeMillis();
            String DeString = AESOperator.getInstance().decrypt(enString);
            Log.e("解密后的字串是：", DeString);
            lUseTime = System.currentTimeMillis() - lStart;
            Log.e("解密耗时：", lUseTime + "毫秒");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
