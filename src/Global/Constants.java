package Global;

public class Constants {
	
	public static enum EIDPanel{
		eNameLabel("                    이름"),
		eBirthdayLabel("                    생일"),
		eOkButton("확인"),
		eCancelButton("취소"),
		eErrorMessage("일치하는 아이디가 없습니다."),
		eIDMessage("아이디 : ");
		
		private String value;
		private EIDPanel(String value) {
			this.value = value;
		}
		public String getValue() {
			return this.value;
		}
	}
	
	public static enum EPWPanel{
		eNameLabel("                  아이디"),
		eBirthdayLabel("                    생일"),
		eOkButton("확인"),
		eCancelButton("취소"),
		eErrorMessage("일치하는 비밀번호가 없습니다."),
		ePWMessage("비밀번호 : ");
		
		private String value;
		private EPWPanel(String value) {
			this.value = value;
		}
		public String getValue() {
			return this.value;
		}
	}

	public static enum EMainFrame{
		eTitle("수강신청");
		
		private String value;
		private EMainFrame(String value) {
			this.value = value;
		}
		public String getString() {
			return this.value;
		}
	}
	
	public static enum EPersonalInfo {
		eInsaPostfix("님 환영합니다"),
		eFriendButton("친구 시간표"),
		eFriendToolTip("친구 시간표 보기"),
		eDetailButton("강의상세정보"),
		eDetailToolTip("수강신청한 강의의 세부 정보표시"),
		eLogoutButton("로그아웃");
		
		private String value;
		private EPersonalInfo(String value) {
			this.value = value;
		}
		public String getValue() {
			return this.value;
		}
	}
	
	public static enum EButtonPanel {
		eGoButton(">>"),
		eOutButton("<<");
		
		private String value;
		private EButtonPanel(String value) {
			this.value = value;
		}
		public String getValue() {
			return this.value;
		}
	}
	
	public static enum ETableHeader {
		eClass("강의"),
		eProfessor("교수");
		
		private String value;
		private ETableHeader(String value) {
			this.value = value;
		}
		public String getValue() {
			return this.value;
		}
	}
	
	public static enum EFriendFrame {
		className("강의명"),
		professor("교수"),
		grades("학점"),
		date("시간"),
		nameLabel("친구이름"),
		searchButton("검색"),
		errorMassage("존재하지 않는 학생");
		
		private String value;
		private EFriendFrame(String value) {
			this.value = value;
		}
		public String getValue() {
			return this.value;
		}
	}
}