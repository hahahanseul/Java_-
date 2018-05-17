package action;
import data.ProfileData;
import utility.CommandRead;
public class DeleteProfileAction implements Action {
	public void execute() {
		System.out.println("連絡先番号を入力してください");
		System.out.print("> ");
		// CommandReadクラスのreadNoメソッドを呼び出し、
		// 戻り値を変数readNoに代入する
		int readNo = CommandRead.readNo();
		// ProfileData型の変数dataを宣言し、ProfileDataクラスの
		// インスタンスを生成して代入する
		ProfileData data = new ProfileData();
		// 変数dataの参照するインスタンスのdeleteProfileメソッドを呼び出す
		data.deleteProfile(readNo);
		System.out.println("-----------------------------------");
		System.out.println("連絡先を削除しました");
		System.out.println("-----------------------------------");
	}
}
