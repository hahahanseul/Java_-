package utility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 標準入力機能を持つ（提供クラス）
public class CommandRead {
	// 数値を読み取るstaticメソッド
	public static int readNo() {
		BufferedReader br = null;
		int no = 0;
		try {
			// 変数brにBufferedReaderクラスのインスタンスを生成して代入する
			br = new BufferedReader(new InputStreamReader(System.in));
			// 変数brが参照するインスタンスのreadLineメソッドを呼び出す
			String strNo = br.readLine();
			// 読み取った値をint型に変換する
			no = Integer.parseInt(strNo);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("入力が正しくありません");
			System.out.println("処理を終了します");
			System.exit(-1);
		}
		return no;
	}
	// 文字列を読み取るstaticメソッド
	public static String readString() {
		BufferedReader br = null;
		String str = null;
		try {
			// 変数brにBufferedReaderクラスのインスタンスを生成して代入する
			br = new BufferedReader(new InputStreamReader(System.in));
			// 変数brが参照するインスタンスのreadLineメソッドを呼び出し、
			// 戻り値を変数strに代入する
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
