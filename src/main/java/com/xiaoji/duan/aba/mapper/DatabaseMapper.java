package com.xiaoji.duan.aba.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DatabaseMapper {

    @Update({ "${_parameter}" })
    void execute(String sql);
}
