import org.testng.annotations.Test;
/**
 * 
 * @author jiapeng
 *post请求
 */
public class httppost {
	@Test
	public void doPost()throws Exception {
	CloseableHttpClient httpClient = HttpClients.createDefault();
	//创建一个post对象
	HttpPost post =new HttpPost("http://localhost:8082/httpclient/post.html");
	//执行post请求
	CloseableHttpResponse response =httpClient.execute(post);
	String string = EntityUtils.toString(response.getEntity());
	System.out.println(string);
	response.close();
	httpClient.close();
	}
}
