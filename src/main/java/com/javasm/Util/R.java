package com.javasm.Util;

import com.javasm.vo.ResultVO;

public class R {
    // 返回状态码
    private Integer code;
    // 返回消息
    private String msg;
    // 返回数据
    private Object data;
    public static ResultVO ok() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("操作成功");
        return resultVO;
    }
    public static ResultVO ok(Object data) {
        ResultVO resultVO = ok();
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO error(String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(500);
        resultVO.setMsg(msg);
        return resultVO;
    }


}
