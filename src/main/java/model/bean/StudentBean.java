package model.bean;

import java.io.Serializable;

public class StudentBean implements Serializable {
		private int id;
		private String no;
		private String name;
		private String state;
		
		// コンストラクタ
		public StudentBean() {
		}
		
		// コンストラクタ引数1(no)
		public StudentBean(String no) {
			this.no = no;
		}
		
		 // コンストラクタ引数4(id, no, name, state)
		public StudentBean(int id, String no, String name, String state) {
			this.id = id;
			this.no = no;
			this.name = name;
			this.state = state;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public String getNo() {
			return no;
		}

		public void setNo(String no) {
			this.no = no;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getstate() {
			return state;
		}

		public void setstate(String state) {
			this.state = state;
		}



		

}
