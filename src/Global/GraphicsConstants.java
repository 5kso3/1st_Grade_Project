package Global;

import java.awt.Color;

public class GraphicsConstants {
	
	public static enum GMainFrmae{
		width(1000),
		height(800);
		
		private int value;
		GMainFrmae(int value) {
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
	}
	
	public static enum GLoginDialog {
		width(500),
		height(250);
		
		private int value;
		GLoginDialog(int value) {
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
	}
	
	public static enum GFriendFrame {
		width(400),
		height(600);
		
		private int value;
		GFriendFrame(int value) {
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
	}
	
	public static enum GColor {
		buttonColor(Color.LIGHT_GRAY),
		panelColor(Color.WHITE),
		defultButtonColor(null),
		defultButtonPanelColor(null),
		defultPanelColor(Color.WHITE);
		
		private Color value;
		GColor(Color value) {
			this.value = value;
		}
		public Color getValue() {
			return this.value;
		}
	}
}
