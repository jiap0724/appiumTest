package com.picooc.com_api;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Login_APi {
	@Test
	public void Login() throws ClientProtocolException, IOException {
		// 接口url
		String url = "http://api2.picooc.com/v1/api/account/login?sign=8B694BD824DD8DE907340874EDD9850B&urlOfGetRequest=haveNotGetUrl&roleId=0&timestamp=1514343639&version=3.8.1&appver=3.8.1.0&requestByChildThread=0&os=iOS&userId=0&lang=zh-CN&timezone=Asia/Shanghai&push_token=iOS::44CD45FC-3EC7-442A-9B5F-676A321F78CC&device_id=44CD45FC-3EC7-442A-9B5F-676A321F78CC&device_mac=&method=user_login_new&userId=0&roleId=0&reqData=%257B%250A%2520%2520%2522sign%2522%2520%253A%2520%25228B694BD824DD8DE907340874EDD9850B%2522%252C%250A%2520%2520%2522urlOfGetRequest%2522%2520%253A%2520%2522haveNotGetUrl%2522%252C%250A%2520%2520%2522roleId%2522%2520%253A%25200%252C%250A%2520%2520%2522req%2522%2520%253A%2520%257B%250A%2520%2520%2520%2520%2522phone%2522%2520%253A%2520%252215210068667%2522%252C%250A%2520%2520%2520%2520%2522password%2522%2520%253A%2520%2522ppp000%2522%252C%250A%2520%2520%2520%2520%2522app%255Fversion%2522%2520%253A%2520%25223%252E8%252E1%2522%252C%250A%2520%2520%2520%2520%2522phone%255Fsystem%2522%2520%253A%2520%2522iOS11%252E1%252E2%2522%252C%250A%2520%2520%2520%2520%2522requestByChildThread%2522%2520%253A%2520false%252C%250A%2520%2520%2520%2520%2522app%255Fchannel%2522%2520%253A%2520%2522AppStore%2522%252C%250A%2520%2520%2520%2520%2522email%2522%2520%253A%2520%2522%2522%252C%250A%2520%2520%2520%2520%2522phone%255Ftype%2522%2520%253A%2520%2522iPhone7%252C2%2522%250A%2520%2520%257D%252C%250A%2520%2520%2522timestamp%2522%2520%253A%2520%25221514343639%2522%252C%250A%2520%2520%2522version%2522%2520%253A%2520%25223%252E8%252E1%2522%252C%250A%2520%2520%2522appver%2522%2520%253A%2520%25223%252E8%252E1%252E0%2522%252C%250A%2520%2520%2522requestByChildThread%2522%2520%253A%2520false%252C%250A%2520%2520%2522os%2522%2520%253A%2520%2522iOS%2522%252C%250A%2520%2520%2522userId%2522%2520%253A%25200%252C%250A%2520%2520%2522lang%2522%2520%253A%2520%2522zh%252DCN%2522%252C%250A%2520%2520%2522timezone%2522%2520%253A%2520%2522Asia%255C%252FShanghai%2522%252C%250A%2520%2520%2522push%255Ftoken%2522%2520%253A%2520%2522iOS%253A%253A44CD45FC%252D3EC7%252D442A%252D9B5F%252D676A321F78CC%2522%252C%250A%2520%2520%2522device%255Fid%2522%2520%253A%2520%252244CD45FC%252D3EC7%252D442A%252D9B5F%252D676A321F78CC%2522%252C%250A%2520%2520%2522device%255Fmac%2522%2520%253A%2520%2522%2522%252C%250A%2520%2520%2522method%2522%2520%253A%2520%2522user%255Flogin%255Fnew%2522%250A%257D";
		// 创建httpclient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建get请求
		HttpGet get = new HttpGet(url);
		// 创建response
		CloseableHttpResponse httpResponse = httpclient.execute(get);
		// 接收请求结果并转换为字符串
		String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		System.out.println(result);
		Reporter.log("返回结果是：" + result);
		httpResponse.close();
	}
}