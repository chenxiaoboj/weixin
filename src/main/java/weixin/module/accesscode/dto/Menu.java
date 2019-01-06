package weixin.module.accesscode.dto;

//再创建我们的菜单类：

/**
 * @author chenx
 */
public class Menu {
	// 一级菜单
	private Button[] button;

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

}