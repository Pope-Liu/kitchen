//Author:刘行
package whu.kitchen.Vo;

public class ResultVo {

    private int code;
    private String msg;
    private Object data;

    //查询数据失败
    public final static ResultVo SELECT_ERROR = new ResultVo(1,"查询数据失败",null);
    //更新数据失败
    public final static ResultVo UPDATE_ERROR = new ResultVo(2,"更新数据失败",null);
    //插入数据失败
    public final static ResultVo INSERT_ERROR = new ResultVo(3,"插入数据失败",null);
    //删除数据失败
    public final static ResultVo DELETE_ERROR = new ResultVo(4,"删除数据失败",null);

    public ResultVo() {
    }

    public ResultVo(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultVo SUCCESS(Object data){
        ResultVo success = new ResultVo();
        success.code = 0;
        success.msg = "操作成功";
        success.data = data;
        return success;
    }

}
