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

/**
 * Servlet implementation class EventInfoServlet
 */
@WebServlet("/EventInfoServlet")
public class EventInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// ファイルのパスを指定
			File file = new File("C:/Users/s2104/Desktop/csv/students.csv");
			
				// ファイルが存在しない場合に例外が発生するので確認
				if (!file.exists()) {
					System.out.print("ファイルが存在しません");
					return;
				}
			
			// BufferedReaderクラスのreadLineメソッドを使って1行ずつ読み込み表示する
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String data;
			String[][] dataArray;
			int index = 0;
			for(int i = 0; (data = br.readLine()) != null; i++) {
				dataArray[i][] = data.split(",");
				for(int j)
			}
			
				//
				  for (int i = 0; i < dataArray.length; i++) {
					  System.out.println("dataArray" + i + ":" + dataArray[i] );
					  }
				
				index++;
			}
			
			// ファイルを閉じてリソースを解放する
			br.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		// eventinfo.jspへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/eventinfo.jsp");
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
