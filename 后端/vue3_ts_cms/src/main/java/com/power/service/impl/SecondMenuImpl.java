package com.power.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.dao.SecondMenuDao;
import com.power.domain.Second_menu;
import com.power.service.ISecondMenuService;
import org.springframework.stereotype.Service;

@Service
public class SecondMenuImpl extends ServiceImpl<SecondMenuDao,Second_menu> implements ISecondMenuService {
}
