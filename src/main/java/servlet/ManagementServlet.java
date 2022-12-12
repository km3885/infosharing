package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.StudentCsvBean;

/**
 * Servlet implementation class ManagementServlet
 */
@WebServlet("/ManagementServlet")
public class ManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			// ファイルパス
			// ファイルのパスを指定
			String fileName = "C:/Users/miyagi/OneDrive/デスクトップ/csv/students.csv";
			File file = new File(fileName);
			
			
				// ファイルが存在しない場合に例外が発生するので確認
				if (!file.exists()) {
					System.out.print("ファイルが存在しません");
					return;
				} else {
					System.out.println("ファイルが見つかりました");
				}
			
			// BufferedReaderクラスのreadLineメソッドを使って1行ずつ読み込み表示する
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
//			String data;
			StudentCsvBean[] dataArray = new StudentCsvBean[20];
			
			// Student型へデータを格納する
			// 初期化
			for(int j = 0; j < dataArray.length; j++) {
				dataArray[j] = new StudentCsvBean();
			}
			
			// データの格納
			int index = 0;
			String line;
			for(int i = 0; (line = br.readLine()) != null; i++) {
				String[] data = line.split(",", -1);
				dataArray[i].setValue(Integer.parseInt(data[0]), data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8],data[9],data[10],data[11],data[12],data[13],data[14],data[15],data[16],data[17]);
			}
			
				//
				  for (int i = 0; i < dataArray.length; i++) {
					  System.out.println("dataArray" + i + ":" + dataArray[i] );
					  }
				
				index++;
			
			
			// ファイルを閉じてリソースを解放する
			br.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		// stuManagement.jspへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/stuManagement.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
