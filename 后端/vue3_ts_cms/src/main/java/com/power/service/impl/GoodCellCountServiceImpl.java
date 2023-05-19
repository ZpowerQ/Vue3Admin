package com.power.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.dao.GoodCellCountDao;
import com.power.domain.Good_cell_count;
import com.power.service.IGoodCellCountService;
import org.springframework.stereotype.Service;

@Service
public class GoodCellCountServiceImpl extends ServiceImpl<GoodCellCountDao, Good_cell_count> implements IGoodCellCountService {
}
