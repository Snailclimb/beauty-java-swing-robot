package almanc;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author 寇爽
 * @Description: ${TODO}(获取网页内容) 
 */
public class AlmanacUtil {

	/**
	 * 单例工具类
	 */
	private AlmanacUtil() {
	}

	public static Almanac getAlmanac() {
		String url = "http://tools.2345.com/rili.htm";
		String html = pickData(url);
		Almanac almanac = analyzeHTMLByString(html);
		return almanac;
	}

	/*
	 * 爬取网页信息
	 */
	private static String pickData(String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpget = new HttpGet(url);
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				// 打印响应状态
				if (entity != null) {
					return EntityUtils.toString(entity);
				}
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/*
	 * 使用jsoup解析网页信息
	 */
	private static Almanac analyzeHTMLByString(String html) {
		String solarDate, lunarDate, chineseAra, should, avoid, festival = " ";
		Document document = Jsoup.parse(html);
		// 获取公历时间
		Element solar = document.getElementById("info_all");
		solarDate = solar.text().toString();
		// 获取农历时间
		Element eLunarDate = document.getElementById("info_nong");
		lunarDate = eLunarDate.child(0).html().substring(1, 3) + " " + eLunarDate.html().substring(11);
		//获取天干地支纪年法
		Element eChineseAra = document.getElementById("info_chang");
		chineseAra = eChineseAra.text().toString();
		// 获取宜
		should = getSuggestion(document, "yi");
		// 忌
		avoid = getSuggestion(document, "ji");
		// 节日
		festival = getSuggestion(document, "festival");
		Almanac almanac = new Almanac(solarDate, lunarDate, chineseAra, should, avoid, festival);
		return almanac;
	}

	/*
	 * 获取忌/宜
	 */
	private static String getSuggestion(Document doc, String id) {
		Element element = doc.getElementById(id);
		Elements elements = element.getElementsByTag("a");
		StringBuffer sb = new StringBuffer();
		for (Element e : elements) {
			sb.append(e.text() + "  ");
		}
		return sb.toString();
	}


}