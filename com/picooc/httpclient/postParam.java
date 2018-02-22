import org.testng.annotations.Test;
/**
 * post请求 带参数
 * @author jiapeng
 *
 */

public class postParam {
	@Test
	public void doPostWithParam()throws Exception{
	CloseableHttpClient httpClient = HttpClients.createDefault();
	//创建一个post对象
	HttpPost post =new HttpPost("http://localhost:8082/httpclient/post.html");
	//创建一个Entity。模拟一个表单
	List<NameValuePair>kvList = new ArrayList<>();
	kvList.add(new BasicNameValuePair("username","zhangsan"));
	kvList.add(new BasicNameValuePair("password","123"));
	//包装成一个Entity对象
	StringEntity entity = new UrlEncodedFormEntity(kvList,"utf-8");
	//设置请求的内容
	post.setEntity(entity);
	//执行post请求
	CloseableHttpResponse response =httpClient.execute(post);
	String string = EntityUtils.toString(response.getEntity());
	System.out.println(string);
	response.close();
	httpClient.close();
	}
}
