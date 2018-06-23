package www.wanlinruo.com.basemvpprobject.base;

/**
 * <pre>
 *     author : LinRuo
 *     time   : 2018/6/23
 *     desc   : eventbus 公共封装  发送的消息
 *     version: 1.0
 * </pre>
 */
public class BaseEvent {
    int tag;
    Object content;

    public BaseEvent(int tag, Object content) {
        this.tag = tag;
        this.content = content;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
