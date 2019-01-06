package weixin.module.accesscode.dto;

//再创建ClickButton类

/**
 * @author chenx
 */
public class ClickButton extends Button {
	// Click类型菜单key
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
