package project.entity;

/**
 * @ClassName BasicPeople
 * @Description TODO 基类
 * @Author  mail@lixingyong.com
 * @Date 2018/12/26 14:29
 * @Version 1.0
 */
public abstract class BasicPeople {
    private int state;

    private String updateTime;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
