//package dao;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//
//import model.bean.StudentCsvBean;
//
//public class FileManagement {
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
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
