package cn.a218.newproject.http.httputils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.webkit.MimeTypeMap;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import cn.a218.newproject.http.requestparams.BaseRequestParm;

/**
 * @author Administrator
 * @ClassName: HttpUtil
 * @date 2014-3-31 下午5:42:17
 */
public class HttpUtil {

    /**
     * 判断网络连接是否打开,包括移动数据连接
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                if (InternetUtil.getNetworkState(context).equals("None")) {
//                    SystemLog.Log("网络未连接");
                } else {
//                    SystemLog.Log("当前网络:" + InternetUtil.getNetworkState(context));
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }


    public static String uploadData(BaseRequestParm parm,
                                    String ebon_encrypt) {

        HttpURLConnection conn = null;
        try {
            URL url = new URL(parm.getUrl());
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(10 * 1000);
            conn.setReadTimeout(10 * 1000);
            conn.setDoInput(true);// 允许输入
            conn.setUseCaches(false);
            if (parm.getAuthorization() != null) {
                conn.setRequestProperty("token", parm.getAuthorization());// 认证
            }
            conn.setRequestProperty("connection", "keep-alive"); // 客户端到服务器端的连接持续有效
                conn.setRequestProperty("Content-Type", parm.getContentType());
            Log.i("path========", parm.getUrl());
            Log.i("data========", parm.getStringJsonData());
            Log.i("authorization======>", parm.getAuthorization());
            Log.i("request============>", parm.getRequest());
            Log.i("ContentType========>", parm.getContentType());
            if (parm.getRequest().equals("GET")) {
                // GET方式
                // httpurlconnection.setDoOutput(true); 这一句不要
                // httpurlconnection.setRequestMethod("GET"); 这一句不要，缺省就是get
            } else if (parm.getRequest().equals("DELETE")) {
                conn.setRequestMethod(parm.getRequest());
            } else if (parm.getRequest().equals("POST") || parm.getRequest().equals("PUT")) {
                // Post方式
                conn.setRequestMethod(parm.getRequest()); // Post方式
                conn.setDoOutput(true);// 允许输出

                OutputStream outputStream = conn.getOutputStream();
                byte[] bytes;
                bytes = parm.getStringJsonData().getBytes();
                outputStream.write(bytes);
                outputStream.flush();
                outputStream.close();
            }
            // int code = conn.getResponseCode();
//            SystemLog.Log("code = " + conn.getResponseCode());
            if (conn.getResponseCode() == 200) {
                InputStream in = conn.getInputStream();
                byte[] inputBbytes = InputStreamTOByte(in);
                String results;
//                if (ebon_encrypt.equals("1")) {
//                    // 解密
//                    results = JniUtils.decrypt(inputBbytes);
//                } else {
                results = new String(inputBbytes, "utf-8");
//                }
                return results;
            } else if (conn.getResponseCode() == 401) {
                // return "用户认证失败";
                return "401";
            } else if (conn.getResponseCode() == 403) {
                // return "用户授权失败";
                return null;
            } else if (conn.getResponseCode() == 404) {
                // return "请求地址错误";
                return null;
            } else if (conn.getResponseCode() == 405) {
                // return "请求方法错误";
                return null;
            } else if (conn.getResponseCode() == 400) {
                // return "请求数据格式错误";
                InputStream in = conn.getErrorStream();

                byte[] inputBbytes = InputStreamTOByte(in);
                String results;

                results = new String(inputBbytes, "utf-8");

                BufferedReader bf = new BufferedReader(new InputStreamReader(in));

                return "code400" + results;
            } else if (conn.getResponseCode() == 500) {
                // return "系统内部错误";
                return null;
            }
        } catch (Exception e) {
            System.out.println("---->超时了");
//            SystemLog.Log(e.toString());
        }
        return null;// 返回"401"：设置重新登陆
    }
    /**
     * 将InputStream转换成byte数组
     *
     * @param in InputStream
     * @return byte[]
     * @throws IOException
     */
    public static byte[] InputStreamTOByte(InputStream in) throws IOException {

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024 * 4];
        int count = -1;
        while ((count = in.read(data, 0, 1024 * 4)) != -1)
            outStream.write(data, 0, count);

        data = null;
        return outStream.toByteArray();
    }
}