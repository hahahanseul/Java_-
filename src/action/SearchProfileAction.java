package action;
import data.Profile;
import data.ProfileData;
import utility.CommandRead;
public class SearchProfileAction implements Action {
	// executeメソッドをオーバーライドする
	public void execute() {
		System.out.println("連絡先番号を入力してください");
		System.out.print("> ");
		// CommandReadクラスのreadNoメソッドを呼び出し、
		// 戻り値を変数readNoに代入する
		int readNo = CommandRead.readNo();
		// ProfileData型の変数dataを宣言し、ProfileDataクラスの
		// インスタンスを生成して代入する
		ProfileData data = new ProfileData();
		// 変数dataの参照するインスタンスのgetProfileByNoメソッドを呼び出し
		// 戻り値を変数profileに代入する
		Profile profile = data.getProfileByNo(readNo);
		// 変数profileが参照するインスタンスの値を表示する
		if (profile != null) {
			System.out.println("-----------------------------------");
			System.out.println("NO. 　　：" + profile.getNo());
			System.out.println("氏名　　：" + profile.getName());
			System.out.println("かな　　：" + profile.getKana());
			System.out.println("電話番号：" + profile.getTel());
			System.out.println("-----------------------------------");
		} else {
			System.out.println("-----------------------------------");
			System.out.println("連絡先は見つかりませんでした");
			System.out.println("-----------------------------------");
		}
	}
}
