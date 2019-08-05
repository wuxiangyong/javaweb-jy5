package com.itdr.common;

/**
 * @author Excellent吴
 * @date 2019-07-31 17:54
 */
public class ResponseCode<T> {
    private Integer status;
    private  T data;
    private  String msg;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    //成功的时候获取的状态码和获取的数据就可以了
    public  static <T> ResponseCode successRs(Integer status,T data){
        ResponseCode rs=new ResponseCode();
        rs.setStatus( status);
        rs.setData(data);
        return rs;

    }
    public  static <T> ResponseCode successRs(T data) {
        ResponseCode rs = new ResponseCode();
        rs.setStatus(0);
        rs.setData(data );
        return rs;
    }
    //失败的时候获取的数
    public  static <T> ResponseCode defeatedRs(Integer status,String msg){
        ResponseCode rs=new ResponseCode();
        rs.setStatus( status);
         rs.setMsg(msg);
        return rs;

    }
    @Override
    public String toString() {
        return "ResponseCode{" +
                "status=" + status +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
