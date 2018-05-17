package control;
import action.Action;
import action.BackupProfileAction;
import action.DeleteProfileAction;
import action.InsertProfileAction;
import action.ProfileListAction;
import action.SearchProfileAction;
import action.UpdateProfileAction;
import utility.CommandRead;
public class ControlProfile {
	public static void main(String[] args) {
		System.out.println(
			"[メニュー]　全件検索：0、ナンバー検索：1、登録：2、削除：3、編集：4、バックアップ：5");
		System.out.print("> ");
		// CommandReadクラスのreadNoメソッドを呼び出し、
		// 戻り値を変数commandに代入する
		int command = CommandRead.readNo();
		// Action型の変数actionを宣言しする
		Action action = null;
		// 変数commandの値が０と等しい場合は、ProfileListActionクラスの
		// インスタンスを生成して変数actionに代入する
		if (command == 0) {
			action = new ProfileListAction();
		// 変数commandの値が１と等しい場合は、SearchProfileActionクラスの
		// インスタンスを生成して変数actionに代入する
		} else if (command == 1) {
			action = new SearchProfileAction();
		// 変数commandの値が２と等しい場合は、RegisterProfileActionクラスの
		// インスタンスを生成して変数actionに代入する
		} else if (command == 2) {
			action = new InsertProfileAction();
		// 変数commandの値が３と等しい場合は、DeleteProfileActionクラスの
		// インスタンスを生成して変数actionに代入する
		} else if (command == 3) {
			action = new DeleteProfileAction();
		// 変数commandの値が４と等しい場合は、EditProfileActionクラスの
		// インスタンスを生成して変数actionに代入する
		} else if (command == 4) {
			action = new UpdateProfileAction();
		// バックアップ用アクション追加
		} else if (command == 5) {
			action = new BackupProfileAction();
		}
		// 変数actionが参照するインスタンスのexecuteメソッドを呼び出す
		action.execute();
	}
}
