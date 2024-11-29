package Controller;

import Models.LoginModel;

public class ManageLogin {
		//receive
		private LoginModel user;
		public ManageLogin() {
			this.user=new LoginModel();
		}
		
		public ManageLogin(LoginModel user) {
			this.user=user;
		}
		public LoginModel getUser() {
			return user;
		}
		public void setUser(LoginModel user) {
			this.user = user;
		}
		//process
		public void login() {
			this.user = new JdbcLogin().login(this.user);
		}
		//send
	}
