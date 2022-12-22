package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.bean.StudentCsvBean;

public class FileManagement {
	// 文字コード
	private static final String CHARSET = "UTF-8";
	// 改行コード
	private static final String LF = "\n";
	// 区切り文字（カンマ）
	private static final String COMMA = ",";
//
//	// csvファイル読み込み
//	public StudentCsvBean[] csvReader() {
//		StudentCsvBean[] dataArray = new StudentCsvBean[20];
//		try {
//			// ファイルパス
//			// ファイルのパスを指定
//			String fileName = "C:/Users/s2104/Desktop/csv/students.csv";
//			File file = new File(fileName);
//			
//				// ファイルが存在しない場合に例外が発生するので確認
////				if (!file.exists()) {
////					System.out.print("ファイルが存在しません");
////					return;
////				} else {
////					System.out.println("ファイルが見つかりました");
////				}
////			
//			// BufferedReaderクラスのreadLineメソッドを使って1行ずつ読み込み表示する
//			FileReader fr = new FileReader(file);
//			BufferedReader br = new BufferedReader(fr);
////			String data;
//			
//			
//			// Student型へデータを格納する
//			// 初期化
//			for(int j = 0; j < dataArray.length; j++) {
//				dataArray[j] = new StudentCsvBean();
//			}
//			
//			// データの格納
//			String line;
//			for(int i = 0; (line = br.readLine()) != null; i++) {
//				String[] data = line.split(",", -1);
//				dataArray[i].setValue(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11],data[12],data[13],data[14],data[15],data[16],data[17]);
//			}
//			
//			// チェック用コンソール出力
//			  for (int i = 0; i < dataArray.length; i++) {
//				  System.out.println("dataArray" + i + ":" + dataArray[i].getId());
//				  }
//			  			  
//
//			// ファイルを閉じてリソースを解放する
//			br.close();			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return dataArray;
//
//	}
//	
//	// csvファイル書き込み
////	public void csvWriter() {
////		// 書き込むファイルのパス
////		String path = "C:/Users/s2104/Desktop/csv/students.csv";
////
////		try(FileOutputStream stream = new FileOutputStream(path);
////		    OutputStreamWriter writer = new OutputStreamWriter(stream);) {
////
////			StudentCsvBean[] newDataACsv = new StudentCsvBean[20];
////			
////			
////			// csvReader() 呼び出し
////			StudentCsvBean[] dataArr = csvReader();
////			
////			// 任意の行上書き
////			
////			
////			// 
////			
////
////		    writer.write(newDataACsv);
////
////		} catch (FileNotFoundException e) {
////		    e.printStackTrace();
////		} catch (IOException e) {
////		    e.printStackTrace();
////		} finally {
////		    writer.close();
////		    stream.close();
////		}
////
////
////	}
//	
//	
	
	public void csvWriter(File file, StudentCsvBean[] empData) {
		
		PrintWriter pw = null;
		BufferedWriter bw = null;
		OutputStreamWriter osw = null;
		FileOutputStream fos = null;
		
        try {
        		fos = new FileOutputStream(file);
        		// BOM付き
        		// EF
        		fos.write(0xef);
                // BB
                fos.write(0xbb);
                // BF
                fos.write(0xbf);
        	
                osw = new OutputStreamWriter(fos, CHARSET);
                bw = new BufferedWriter(osw);
                pw = new PrintWriter(file);
        	
        	// ヘッダ情報リスト
        	List<String> headerList = new ArrayList<String>(Arrays.asList("入力", "科名", "氏名", "管轄", "新卒", "適用", "ジョブカード", "希望地", "就職先", "実習先", "勤務地住所", "雇用形態", "雇用保険", "雇用期間", "就職経路", "関連", "職種"));
        	
 
        	for(String header: headerList) {
        		pw.print(header);
        		pw.print(COMMA);
        	}
        		pw.println("内定日");
        	
        	pw.flush();
        	
        } catch (IOException | IllegalArgumentException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (osw != null) {
					osw.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}



