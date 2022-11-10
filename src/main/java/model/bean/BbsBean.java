package model.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class BbsBean implements Serializable{
	    private String userName;
	    private String comment;
	    private Timestamp time;

	    public BbsBean() {
	    }

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public Timestamp getTime() {
			return time;
		}

		public void setTime(Timestamp time) {
			this.time = time;
		}

	    
}
