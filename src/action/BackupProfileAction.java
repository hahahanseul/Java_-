package action;

import data.ProfileData;
import utility.CommandRead;

public class BackupProfileAction implements Action {
	public void execute() {
		System.out.println("保存先のパスを入力してください");
		System.out.print("> ");
		String readPath = CommandRead.readString();

		// ProfileData型の変数dataを宣言し、ProfileDataクラスの
		// インスタンスを生成して代入する
		ProfileData data = new ProfileData();
		// 変数dataの参照するインスタンスのbackUpProfileメソッドを呼び出す
		data.backUpProfile(readPath);
		System.out.println("-----------------------------------");
		System.out.println("バックアップファイルを" + readPath + " に出力しました。");
		System.out.println("-----------------------------------");
	}
}
