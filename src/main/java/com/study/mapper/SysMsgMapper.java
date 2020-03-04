package com.study.mapper;

import com.study.bean.Hr;
import com.study.bean.MsgContent;
import com.study.bean.SysMsg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMsgMapper {
    List<SysMsg> getSysMsgByPage(@Param("start") Integer start,
                                 @Param("size") Integer size,
                                 @Param("hrid") Long hrid);

    int markRead(@Param("flag") Long flag, @Param("hrid") Long hrid);

    int sendMsg(MsgContent msg);

    int addMsg2AllHr(@Param("hrs") List<Hr> hrs, @Param("mid") Long mid);
}

