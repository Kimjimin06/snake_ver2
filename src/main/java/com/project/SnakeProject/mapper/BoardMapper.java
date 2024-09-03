package com.project.SnakeProject.mapper;

import com.project.SnakeProject.vo.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardVo> viewAll();
}
