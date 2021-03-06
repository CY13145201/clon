package com.xieke.test.demo.util;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * http请求工具类
 * 
 * @author jun hu
 *
 */
@SuppressWarnings("deprecation")
public class HttpClientUtils {
 
	/**
	 * 模拟post请求
	 * 
	 * @param url
	 *            资源地址
	 * @param map
	 *            参数列表
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static String sendPost(String url, Map<String, String> map) throws ParseException, IOException {
		String body = "";
 
		//创建httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		//创建post方式请求对象
		HttpPost httpPost = new HttpPost(url);
		
		//装填参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if(map!=null){
			for (Entry<String, String> entry : map.entrySet()) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		//设置参数到请求对象中
		httpPost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
 
		System.out.println("请求地址："+url);
		System.out.println("请求参数："+nvps.toString());
		
		//设置header信息
		//指定报文头【Content-type】、【User-Agent】
		httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
		httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		
		//执行请求操作，并拿到结果（同步阻塞）
		CloseableHttpResponse response = client.execute(httpPost);
		//获取结果实体
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			//按指定编码转换结果实体为String类型
			body = EntityUtils.toString(entity, HTTP.UTF_8);
		}
		EntityUtils.consume(entity);
		//释放链接
		response.close();

		System.out.println("响应内容：" + body);

        return body;
	}

	/**
	 * 模拟get请求
	 * 
	 * @param url
	 *            资源地址
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public static String sendGet(String url) throws ParseException, IOException {
		String body = "";

		// 创建httpclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		// 创建get方式请求对象
		HttpGet httpGet = new HttpGet(url);

		System.out.println("请求地址：" + url);

		// 设置header信息
		// 指定报文头【Content-type】、【User-Agent】
		httpGet.setHeader("Content-type", "application/x-www-form-urlencoded");
		httpGet.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		// 执行请求操作，并拿到结果（同步阻塞）
		CloseableHttpResponse response = client.execute(httpGet);


		//获取结果实体
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			//按指定编码转换结果实体为String类型
			body = EntityUtils.toString(entity, HTTP.UTF_8);
		}
		EntityUtils.consume(entity);
		//释放链接
		response.close();

		System.out.println("响应内容：" + body);

		return body;
	}

}