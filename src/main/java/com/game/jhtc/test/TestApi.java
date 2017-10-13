package com.game.jhtc.test;



public class TestApi {

	/**
	 * 查询玩家分数接口测试
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	/*@Test
	public void testQueryScore(String[] args) throws ClientProtocolException, IOException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("http://127.0.0.1:8080/snake_api/snake/queryScore");
		CloseableHttpResponse reponse = httpclient.execute(httpPost);
		try{
			
			HttpEntity myEntity = reponse.getEntity();
			System.out.println(myEntity.getContentType());
			System.out.println(myEntity.getContentLength());
			
			String resString = EntityUtils.toString(myEntity);
			//使用返回的字符串直接构造一个JSONObject
			JSONObject jsonObj = new JSONObject(resString);
			
			
		}catch{
			
		}
	}
*/
}
