import org.testng.annotations.Test;
/**
 * get请求 带参数
 * @author jiapeng
 *
 */

public class getParam {
	@Test
	public void doGetWithParam()throws Exception{
	//创建一个httpclient对象
	CloseableHttpClient httpClient = HttpClients.createDefault();
	//创建一个uri对象
	URIBuilder uriBuilder = new URIBuilder("http://www.sogou.com/web");
	uriBuilder.addParameter("query","北京");
	HttpGet get = new HttpGet(uriBuilder.build());
	//执行请求
	CloseableHttpResponse response =httpClient.execute(get);
	//取响应的结果
	int statusCode =response.getStatusLine().getStatusCode();
	System.out.println(statusCode);
	HttpEntity entity =response.getEntity();
	String string = EntityUtils.toString(entity,"utf-8");
	System.out.println(string);
	//关闭httpclient
	response.close();
	httpClient.close();
	}
}
