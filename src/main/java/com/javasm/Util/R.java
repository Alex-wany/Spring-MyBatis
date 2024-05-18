package com.javasm.Util;

import com.javasm.vo.ResultVO;

//封装工具类 用于返回结果
public class R {
    // 返回状态码
    private Integer code;
    // 返回消息
    private String msg;
    // 返回数据
    private Object data;

    // 构造方法 无参 构造 返回状态码和消息
    public static ResultVO ok() {//为什么使用静态方法？因为不需要创建对象就可以调用 更方便调用
        ResultVO resultVO = new ResultVO();// 创建返回对象 无参构造
        resultVO.setCode(200);
        resultVO.setMsg("操作成功");
        return resultVO;
    }
    // 构造方法 重载 传入数据 返回状态码 消息和数据
    public static ResultVO ok(Object data) {
        ResultVO resultVO = ok();// 调用无参构造 创建返回对象 返回状态码和消息
        resultVO.setData(data);
        return resultVO;
    }
    // 构造方法 重载 传入总数和数据 返回状态码 消息 总数和数据
    public static ResultVO ok(Object data, long total) {
        ResultVO resultVO = ok(data);// 调用重载构造 创建返回对象 返回状态码和消息
        resultVO.setTotal(total);
        return resultVO;
    }



    // 构造方法 重载 传入状态码和消息 返回状态码和消息
    public static ResultVO error(Integer code, String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(message);
        return resultVO;
    }
}
