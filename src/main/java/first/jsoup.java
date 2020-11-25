package test;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoup {

	public static void main(String[] args) throws IOException {
        Connection.Response loginForm = Jsoup.connect("http://tsquare.duckdns.org:8085/login")
        		.timeout(60000)
                .method(Connection.Method.GET)
                .execute(); 

        
            Connection.Response mainPage = Jsoup.connect("http://tsquare.duckdns.org:8085/j_acegi_security_check")
            		.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36")
                    .header("scheme", "https")
                    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("accept-encoding", "gzip, deflate, br")
                    .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6")
                    .header("cache-control", "no-cache")
                    .header("pragma", "no-cache")
                    .header("upgrade-insecure-requests", "1")
		    		.data("j_username", "francis_shin")
		    		.data("j_password", "1q2w3e4r")
	        		.timeout(60000)
                .cookies(loginForm.cookies())
                .method(Connection.Method.POST).execute(); 
//            System.out.println(mainPage.parse());

            System.out.println(loginForm.cookies());
            Map<String, String> cookies = mainPage.cookies();

            Document evaluationPage = Jsoup.connect("http://tsquare.duckdns.org:8085/job/APMall_Deploy_Android/lastBuild/api/json")
            		.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.66 Safari/537.36")
                    .header("scheme", "https")
                    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8")
                    .header("accept-encoding", "gzip, deflate, br")
                    .header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7,es;q=0.6")
                    .header("cache-control", "no-cache")
                    .header("pragma", "no-cache")
                    .header("upgrade-insecure-requests", "1")
            		.cookies(cookies)
            		.timeout(60000)
            		.ignoreContentType(true)
                .get();
            System.out.println(evaluationPage);
            System.out.println();
            System.out.println();
            int start = evaluationPage.toString().indexOf("\"result\"");
            int end = evaluationPage.toString().indexOf(",\"timestamp\"");
            String finals= evaluationPage.toString().substring(start,end);
            
            if(finals.indexOf("FAILURE")!=-1) {
            	System.out.println("Fail");
            }
            
            System.out.println(finals);
            
            
	}

}
