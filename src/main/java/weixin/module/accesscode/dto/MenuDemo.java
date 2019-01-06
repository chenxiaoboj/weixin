package weixin.module.accesscode.dto;

import java.util.List;

/**
 * @author chenx
 * @create 2018-08-03 11:16
 */
public class MenuDemo {

    /**
     * menu : {"button":[{"type":"click","name":"今日歌曲","key":"V1001_TODAY_MUSIC","sub_button":[]},{"type":"click","name":"歌手简介","key":"V1001_TODAY_SINGER","sub_button":[]},{"name":"菜单","sub_button":[{"type":"view","name":"搜索","url":"http://www.soso.com/","sub_button":[]},{"type":"view","name":"视频","url":"http://v.qq.com/","sub_button":[]},{"type":"click","name":"赞一下我们","key":"V1001_GOOD","sub_button":[]}]}]}
     */

    private MenuBean menu;

    public MenuBean getMenu() {
        return menu;
    }

    public void setMenu(MenuBean menu) {
        this.menu = menu;
    }

    public static class MenuBean {
        private List<ButtonBean> button;

        public List<ButtonBean> getButton() {
            return button;
        }

        public void setButton(List<ButtonBean> button) {
            this.button = button;
        }

        public static class ButtonBean {
            /**
             * type : click
             * name : 今日歌曲
             * key : V1001_TODAY_MUSIC
             * sub_button : []
             */

            private String type;
            private String name;
            private String key;
            private List<?> sub_button;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public List<?> getSub_button() {
                return sub_button;
            }

            public void setSub_button(List<?> sub_button) {
                this.sub_button = sub_button;
            }
        }
    }
}
