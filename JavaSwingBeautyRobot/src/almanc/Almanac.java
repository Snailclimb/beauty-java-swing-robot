package almanc;

/**
 * TODO 万年历实体类
 * @author 寇爽
 * @date 2017年11月18日
 * @version
 */
public class Almanac {
	private String solar;
	private String lunar;
	private String chineseAra;
	// 宜做的事
	private String should;
	// 避免做的事
	private String avoid;
	// 节日
	private String festival;

	public String getSolar() {
		return solar;
	}

	public void setSolar(String date) {
		this.solar = date;
	}

	public String getLunar() {
		return lunar;
	}

	public void setLunar(String lunar) {
		this.lunar = lunar;
	}

	public String getChineseAra() {
		return chineseAra;
	}

	public void setChineseAra(String chineseAra) {
		this.chineseAra = chineseAra;
	}

	public String getAvoid() {
		return avoid;
	}

	public void setAvoid(String avoid) {
		this.avoid = avoid;
	}

	public String getShould() {
		return should;
	}

	public void setShould(String should) {
		this.should = should;
	}

	public String getFestival() {
		return festival;
	}

	public void setFestival(String festival) {
		this.festival = festival;
	}

	public Almanac(String solar, String lunar, String chineseAra, String should, String avoid, String festival) {
		this.solar = solar;
		this.lunar = lunar;
		this.chineseAra = chineseAra;
		this.should = should;
		this.avoid = avoid;
		this.festival = festival;
	}
}