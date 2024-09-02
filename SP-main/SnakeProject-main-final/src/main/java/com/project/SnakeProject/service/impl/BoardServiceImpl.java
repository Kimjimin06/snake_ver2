package com.project.SnakeProject.service.impl;

import com.project.SnakeProject.mapper.BoardMapper;
import com.project.SnakeProject.service.BoardService;
import com.project.SnakeProject.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper mapper;

    @Override
    public List<BoardVo> viewAll() {
        return mapper.viewAll();
    }
}
