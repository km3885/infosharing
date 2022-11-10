package model.bean;

import java.io.Serializable;

public class StudentBean implements Serializable {
		private int id;
		private int no;
		private String name;
		private String statu;
		
		// コンストラクタ
		public StudentBean() {
		}
		
		 // コンストラクタ引数4(id, no, name, statu)
		public StudentBean(int id, int no, String name, String statu) {
			this.no = no;
			this.name = name;
			this.statu = statu;
		}
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getStatu() {
			return statu;
		}

		public void setStatu(String statu) {
			this.statu = statu;
		}



		

}
