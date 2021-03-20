package Global;

public class Constants {
	
	public static enum EIDPanel{
		eNameLabel("                    �̸�"),
		eBirthdayLabel("                    ����"),
		eOkButton("Ȯ��"),
		eCancelButton("���"),
		eErrorMessage("��ġ�ϴ� ���̵� �����ϴ�."),
		eIDMessage("���̵� : ");
		
		private String value;
		private EIDPanel(String value) {
			this.value = value;
		}
		public String getValue() {
			return this.value;
		}
	}
	
	public static enum EPWPanel{
		eNameLabel("                  ���̵�"),
		eBirthdayLabel("                    ����"),
		eOkButton("Ȯ��"),
		eCancelButton("���"),
		eErrorMessage("��ġ�ϴ� ��й�ȣ�� �����ϴ�."),
		ePWMessage("��й�ȣ : ");
		
		private String value;
		private EPWPanel(String value) {
			this.value = value;
		}
		public String getValue() {
			return this.value;
		}
	}

	public static enum EMainFrame{
		eTitle("������û");
		
		private String value;
		private EMainFrame(String value) {
			this.value = value;
		}
		public String getString() {
			return this.value;
		}
	}
	
	public static enum EPersonalInfo {
		eInsaPostfix("�� ȯ���մϴ�"),
		eFriendButton("ģ�� �ð�ǥ"),
		eFriendToolTip("ģ�� �ð�ǥ ����"),
		eDetailButton("���ǻ�����"),
		eDetailToolTip("������û�� ������ ���� ����ǥ��"),
		eLogoutButton("�α׾ƿ�");
		
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
		eClass("����"),
		eProfessor("����");
		
		private String value;
		private ETableHeader(String value) {
			this.value = value;
		}
		public String getValue() {
			return this.value;
		}
	}
	
	public static enum EFriendFrame {
		className("���Ǹ�"),
		professor("����"),
		grades("����"),
		date("�ð�"),
		nameLabel("ģ���̸�"),
		searchButton("�˻�"),
		errorMassage("�������� �ʴ� �л�");
		
		private String value;
		private EFriendFrame(String value) {
			this.value = value;
		}
		public String getValue() {
			return this.value;
		}
	}
}