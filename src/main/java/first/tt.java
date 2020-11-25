package first;


import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class tt {

	public static void main(String[] args) throws IOException {
		 OkHttpClient client = new OkHttpClient();
		 
		    String met = new String("");
		    String message = new String("");
		    String final_message = new String("");

		    String requestURL1 = new String("http://tsquare.duckdns.org:8085/job/APMall_Deploy_Android/lastBuild/api/json");
		    String requestURL2 = new String("http://tsquare.duckdns.org:8085/j_acegi_security_check");
		    String requestURL3 = new String("http://tsquare.duckdns.org:8085/login");

		    RequestBody body = new FormBody.Builder()
			.add("j_username", "francis_shin")
			.add("j_password", "1q2w3e4r")
			.build();
		    
		    Response response = client.newCall(new Request.Builder()
		    	      .url(requestURL3)
		    	      .get()
		    	      .build()).execute();
		    
		    Response response2 = client.newCall(new Request.Builder()
		    	      .url(requestURL2)
		    	      .get()
		    	      .build()).execute();

//	        Connection.Response loginForm = Jsoup.connect("http://tsquare.duckdns.org:8085/login")
//	                .method(Connection.Method.GET)
//	                .execute();
//		    
//		    
//		    
		    
		    
		    try {


		        final_message = response2.body().string();
		        
		        System.out.println(final_message.toString());

		      } catch(Exception e){

		        System.err.println(e.toString());

		        final_message = "Jenkins 정보가 비어있거나 잘못되었습니다.";

		        // final_message = requestURL;

		      }
	}

}
