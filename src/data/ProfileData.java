package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProfileData {
	public ArrayList<Profile> getProfileList() {
		// ArrayList<Profile>型の変数profileListに、
		// ArrayList<Profile>クラスのインスタンスを生成して代入する
		ArrayList<Profile> profileList = new ArrayList<Profile>();
		// 変数を宣言する
		Connection con = null;
		Statement st = null;
		try {
			// データベースに接続する
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:65534/phone_book", "jdbc", "jdbc");
			// Statementオブジェクトを取得する
			st = con.createStatement();
			// SQL文を発行する
			ResultSet rs = st.executeQuery(
					"SELECT NO, NAME, KANA, TEL FROM PROFILE");
			while (rs.next()) {
				// SQL文の結果からデータを取り出し、Profileクラスの
				// インスタンスを生成する
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String kana = rs.getString("KANA");
				String tel = rs.getString("TEL");
				Profile profile = new Profile(no, name, kana, tel);
				// 変数profileListが参照するインスタンスに、Profileクラスの
				// インスタンスを追加する
				profileList.add(profile);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// リソースを解放する
			try {
				if (st != null)
					st.close();
			} catch (SQLException e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		// 変数profileListの参照を返す
		return profileList;
	}

	public Profile getProfileByNo(int readNo) {
		// 変数を宣言する
		Profile profile = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			// データベースに接続する
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:65534/phone_book", "jdbc", "jdbc");
			// PreparedStatementオブジェクトを取得する
			pst = con.prepareStatement("SELECT NO, NAME, KANA, TEL FROM PROFILE"
					+ " WHERE NO = ?");
			// プレースホルダに値をセットする
			pst.setInt(1, readNo);
			// SQL文を発行する
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				// SQL文の結果からデータを取り出し、Profileクラスの
				// インスタンスを生成する
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				String kana = rs.getString("KANA");
				String tel = rs.getString("TEL");
				profile = new Profile(no, name, kana, tel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// リソースを解放する
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		// 変数profileの参照を返す
		return profile;
	}

	public void insertProfile(
			int readNo, String readName, String readKana, String readTel) {
		// 変数を宣言する
		Connection con = null;
		PreparedStatement pst = null;
		try {
			// データベースに接続する
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:65534/phone_book", "jdbc", "jdbc");
			// PreparedStatementオブジェクトを取得する
			pst = con.prepareStatement(
					"INSERT INTO PROFILE VALUES(?, ?, ?, ?)");
			// プレースホルダに値を設定する
			pst.setInt(1, readNo);
			pst.setString(2, readName);
			pst.setString(3, readKana);
			pst.setString(4, readTel);
			// SQL文を発行する
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// リソースを解放する
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	public void deleteProfile(int readNo) {
		// 変数を宣言する
		Connection con = null;
		PreparedStatement pst = null;
		try {
			// データベースに接続する
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:65534/phone_book", "jdbc", "jdbc");
			// PreparedStatementオブジェクトを取得する
			pst = con.prepareStatement("DELETE FROM PROFILE WHERE NO = ?");
			// プレースホルダに値を設定する
			pst.setInt(1, readNo);
			// SQL文を発行する
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// リソースを解放する
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	public void updateProfile(
			int readNo, String readName, String readKana, String readTel) {
		// 変数を宣言する
		Connection con = null;
		PreparedStatement pst = null;
		try {
			// データベースに接続する
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:65534/phone_book", "jdbc", "jdbc");
			// PreparedStatementオブジェクトを取得する
			pst = con.prepareStatement(
					"UPDATE PROFILE SET NAME = ?, KANA = ?, TEL = ?"
							+ " WHERE NO = ?");
			// プレースホルダに値を設定する
			pst.setString(1, readName);
			pst.setString(2, readKana);
			pst.setString(3, readTel);
			pst.setInt(4, readNo);
			// SQL文を発行する
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// リソースを解放する
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	/**
	 * 最新のprofileListをCSVファイルへバックアップ
	 * @param path 保存先パス
	 */
	public void backUpProfile(String path) {

		// 最新のprofileListを取得
		ArrayList<Profile> profileList = this.getProfileList();

		// ファイルへの書き出し
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			// ファイル出力場所を設定
			fw = new FileWriter(path + "\\profileList.csv");
			bw = new BufferedWriter(fw);

			// 1行目のカラム出力
			bw.write("no,name,kana,tel");
			bw.newLine();

			// DBから取得した行数分ループ
			for (Profile profile : profileList) {
				bw.write(Integer.toString(profile.getNo())); // 文字列型に変換
				bw.write("," + profile.getName());
				bw.write("," + profile.getKana());
				bw.write("," + profile.getTel());
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 例外発生時も、必ずファイルを閉じる。
				bw.flush();
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}