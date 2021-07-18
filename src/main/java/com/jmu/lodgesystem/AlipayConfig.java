package com.jmu.lodgesystem;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2016102400753330";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCG4YFqGYtJPomoSne2vC8XUHjJHedz9u6ZFvpS/B8K8oOQZ0MPjt+8JuC6krjRFmVYq/opkNDKBELp2108fiXi09VeyPcw+Z7KZ2bJklAcNN31bQawXSWTnfT7JIWyMM8NQdLQ4K365voTSepfK5SvtnFGywQtOLKGyNtsf5biwSAkLAq0F+sn+suZFdltiUC8VC5/KsM7dn3Ybm83jaMnY0kVl7cBMQFUryFt/xLRO4/voSYLDkXWzaIAaXjNAY8ZJwk8jFM6dreYEICRgLic974f1TAvwCtG2RLHcQbDdFp6pnFTZ74ky8K462oH9U1miGlw1gijziEp/KuaHt8vAgMBAAECggEAZLGpSao0P8P+RLMDWFp41XDwG0TF697nFUcALj+mdSfDbGSKveytvutPTjoG26Fam64YHjvMg2RXB/sKSgTrB8GZQx/I2rkgAH7dT5J5V/Vn1rdEDRoc2W1M3MjRPswNZxpC5kk12V/iRdAitlX0tJEBVBZv0crIDLOajA9cd38ZyDXETiHdZ3rwhFzyCTdkxEaQVuQ1FcFi19KE5Vekl3bqQVfFL+NVSlt2oyUgDTBPuGDpfhHp1BUkJz8RyRLxuEiPl+k6TDpmcy6GdAR5YYtoHUrCJBGE9W72m33LZuWo/6KIXMRDMSRTFiFYYl5FPS/vj4LbmEsQLc1Qv0GC4QKBgQDWnOMKkJSkAl7PyTRVCcGstc6luUSyupUuNNDbsWuL/bw7PRFEwP5TH+LJpQY6FzuDSame0x4GIsqYlAVxB78UceGRiFM1rePsFseX5ZQybZvS3Z0ZtVe4lD3fZhNVbrzmqrqOejfpyk6BuMqk60Nm2g9JmS3U09JybzAFOnbhBwKBgQCg5F8sN4fymEqD67BMlzeNLuih7uhFzP+dLUXLPTuP5ksXTftVzH8hSgGihXcI/7xRCuLPAHURgvqx9OsauLVmMuQamKo/xZT301gzKDWU+2sQNMcaPbwmhQBKURdVUihbhEN0mFgBB99RdY/Bu8REsVhK3bQYVhtYtGMcFBwOmQKBgCnVhTBfBIp/58lrOCdHcphfDDwjxC9uzXunUfsxN3yfZlzJx572W90KPyP9ZhxWwQQTjNvn3Vdm2sUpPXJOB0JN/KFoyIeTMPWpbxi96Mh3s0NEbcZAIixZwUHV3PjvUCVKrHjvfAy3odwJkH7bWVUoNoirMlLlQ4WJBPxP7DJrAoGAK7sG10jcraaRElw8VgT/92LZnjIGdfprO7hzcPNavhkVLednOgHUSCMKYLcwDIUeFVUFIsh4CWN1amssf93WiEmq0EPQenbkr5uFLJpwPec8SXJe75X6Duo1kv2JfwpOp9lCUG2b9ePC4iw2/6xeg2FEo0yxR7AXzLty+M3KdnkCgYEAsYjYyVTpLj3gHb0bcJ96xslY2mw5nphxh8oo0131dAzAe4fiM+bymfqcpDnS/09nAKsggshOuh0HqBqJZ9EDJ5KFmLImpwrIr0t+DcXWMWmADUbZaG39kVErgFidz05bxjLQPwlboYrRZTmV7I4EZIxXiuCCyOfzW7Rti5QIEn0=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwuh8MPkQFrLZKLYKW7txD2LIWorptyju+9FXkDMZ1WmX6GqEFEfP6gIkG73o/yvZRfBTZ/jrbmyAamnwjSqhb+O7fKYJSLohQnEnaictZg9rZfrX+7EWnRxwuCcCWR21wRkSM6DwwBPMWOs71SplPevs0avkzzNwWTQU0Yet4qTQFK91+bpP+Lw/nU06uUEI2A//pagErb6g3Mbb8qN+OXPezohfuUhmeBSgvB9h+YkTmR6EyczfZggPyZRTuXUscDSH/t+Vcg5qKSNQ1BDk8bpMsJUocMOCrI8BFMT3KsehyPyVSFKVHBUH6nWI6WWBqce/cc7JL/vP43KsZttOcQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/return1";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)
    public static String return_url = "http://localhost:8080/paySuccess";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(gatewayUrl + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
