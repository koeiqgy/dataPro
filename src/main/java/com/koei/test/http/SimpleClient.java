package com.koei.test.http;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class SimpleClient {
    //private static Logger logger = Logger.getLogger(HttpUtil.class);

    /**
     * get请求
     * @return
     */
    public static String doGet(String url) {
        try {
            HttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());

                return strResult;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



    /**
     * post请求(用于key-value格式的参数)
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, Map params){

        BufferedReader in = null;
        try {
            // 定义HttpClient
            HttpClient client = new DefaultHttpClient();
            // 实例化HTTP方法
            HttpPost request = new HttpPost();
            request.setURI(new URI(url));

            //设置参数
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String value = String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name, value));

                //System.out.println(name +"-"+value);
            }
            request.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));

            HttpResponse response = client.execute(request);
            int code = response.getStatusLine().getStatusCode();
            if(code == 200){    //请求成功
                in = new BufferedReader(new InputStreamReader(response.getEntity()
                        .getContent(),"utf-8"));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }

                in.close();

                return sb.toString();
            }
            else{   //
                System.out.println("状态码：" + code);
                return null;
            }
        }
        catch(Exception e){
            e.printStackTrace();

            return null;
        }
    }






    /**
     * post请求（用于请求json格式的参数）
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, String params)  {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);// 创建httpPost
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-Type", "application/json");
        String charSet = "UTF-8";
        StringEntity entity = new StringEntity(params, charSet);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;

        try {
            response = httpclient.execute(httpPost);
            StatusLine status = response.getStatusLine();
            int state = status.getStatusCode();
            if (state == HttpStatus.SC_OK) {
                HttpEntity responseEntity = response.getEntity();
                String jsonString = EntityUtils.toString(responseEntity);
                return jsonString;
            }
            else{
                System.out.println("error");
                //logger.error("请求返回:"+state+"("+url+")");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    /**
     * 中转文件
     *
     * @param file
     *            上传的文件
     * @return 响应结果
     */
    public String httpClientUploadFile(MultipartFile file) {
        final String remote_url = "http://192.168.1.99:8080/demo/file/upload";// 第三方服务器请求地址
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        try {
            String fileName = file.getOriginalFilename();
            HttpPost httpPost = new HttpPost(remote_url);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody("file", file.getInputStream(), ContentType.MULTIPART_FORM_DATA, fileName);// 文件流
            builder.addTextBody("filename", fileName);// 类似浏览器表单提交，对应input的name和value
            HttpEntity entity = builder.build();
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);// 执行提交
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                // 将响应内容转换为字符串
                result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public void processUpload(HttpServletRequest request, HttpServletResponse response) throws  UnsupportedEncodingException{
        String uploadPath="";
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }

        System.out.println("Come on, baby .......");
        request.setCharacterEncoding("utf-8");

        //检测是不是存在上传文件
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if(isMultipart){
            DiskFileItemFactory factory = new DiskFileItemFactory();

            //指定在内存中缓存数据大小,单位为byte,这里设为1Mb
            factory.setSizeThreshold(1024*1024);

            //设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录
            factory.setRepository(new File("D:\\temp"));

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // 指定单个上传文件的最大尺寸,单位:字节，这里设为50Mb
            upload.setFileSizeMax(50 * 1024 * 1024);

            //指定一次上传多个文件的总尺寸,单位:字节，这里设为50Mb
            upload.setSizeMax(50 * 1024 * 1024);
            upload.setHeaderEncoding("UTF-8");

            List<FileItem> items = null;

            try {
                // 解析request请求
                items = upload.parseRequest((RequestContext)request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            if(items!=null){
                //解析表单项目
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();

                    //如果是普通表单属性
                    if (item.isFormField()) {
                        //相当于input的name属性   <input type="text" name="content">
                        String name = item.getFieldName();

                        //input的value属性
                        String value = item.getString();

                        System.out.println("属性:" + name + " 属性值:" + value);
                    }
                    //如果是上传文件
                    else {
                        //属性名
                        String fieldName = item.getFieldName();

                        //上传文件路径
                        String fileName = item.getName();
                        fileName = fileName.substring(fileName.lastIndexOf("/") + 1);// 获得上传文件的文件名

                        try {
                            item.write(new File(uploadPath, fileName));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        response.addHeader("token", "hello");
    }

    public void upload(String localFile){
        String URL_STR="http://www.woseek.com";
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();

            // 把一个普通参数和文件上传给下面这个地址 是一个servlet
            HttpPost httpPost = new HttpPost(URL_STR);

            // 把文件转换成流对象FileBody
            FileBody bin = new FileBody(new File(localFile));

            StringBody userName = new StringBody("Scott", ContentType.create(
                    "text/plain", Consts.UTF_8));
            StringBody password = new StringBody("123456", ContentType.create(
                    "text/plain", Consts.UTF_8));

            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    // 相当于<input type="file" name="file"/>
                    .addPart("file", bin)

                    // 相当于<input type="text" name="userName" value=userName>
                    .addPart("userName", userName)
                    .addPart("pass", password)
                    .build();

            httpPost.setEntity(reqEntity);

            // 发起请求 并返回请求的响应
            response = httpClient.execute(httpPost);

            System.out.println("The response value of token:" + response.getFirstHeader("token"));

            // 获取响应对象
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                // 打印响应长度
                System.out.println("Response content length: " + resEntity.getContentLength());
                // 打印响应内容
                System.out.println(EntityUtils.toString(resEntity, Charset.forName("UTF-8")));
            }

            // 销毁
            EntityUtils.consume(resEntity);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(response != null){
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(httpClient != null){
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
       // doGet("http://www.woseek.com");
        String ret=doPost("http://127.0.0.1:8080","");
        System.out.println(ret);
    }
}
