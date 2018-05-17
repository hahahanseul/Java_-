package data;
public class Profile {
	private int no;			// ナンバー
	private String name;	// 氏名
	private String kana;	// かな
	private String tel;		// 電話番号
	public Profile(int no, String name, String kana, String tel) {
		this.no = no;
		this.name = name;
		this.kana = kana;
		this.tel = tel;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKana() {
		return kana;
	}
	public void setKana(String kana) {
		this.kana = kana;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
