package action;
import data.ProfileData;
import utility.CommandRead;
public class InsertProfileAction implements Action {
	public void execute() {
		System.out.println("連絡先番号を入力してください");
		System.out.print("> ");
		// CommandReadクラスのreadNoメソッドを呼び出し、
		// 戻り値を変数readNoに代入する
		int readNo = CommandRead.readNo();
		System.out.println("氏名を入力してください");
		System.out.print("> ");
		// CommandReadクラスのreadStringメソッドを呼び出し、
		// 戻り値を変数readNameに代入する
		String readName = CommandRead.readString();
		System.out.println("かなを入力してください");
		System.out.print("> ");
		// CommandReadクラスのreadStringメソッドを呼び出し、
		// 戻り値を変数readKanaに代入する
		String readKana = CommandRead.readString();
		System.out.println("電話番号を入力してください");
		System.out.print("> ");
		// CommandReadクラスのreadStringメソッドを呼び出し、
		// 戻り値を変数readTelに代入する
		String readTel = CommandRead.readString();
		// ProfileData型の変数dataを宣言し、ProfileDataクラスの
		// インスタンスを生成して代入する
		ProfileData data = new ProfileData();
		// 変数dataの参照するインスタンスのinsertProfileメソッドを呼び出す
		data.insertProfile(readNo, readName, readKana, readTel);
		System.out.println("-----------------------------------");
		System.out.println("連絡先を登録しました");
		System.out.println("-----------------------------------");
	}
}
