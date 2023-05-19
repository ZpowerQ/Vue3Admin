package com.power.service.impl;

import com.power.dao.SystemInfoDao;
import com.power.service.ISystemInfoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemInfoServiceImpl implements ISystemInfoService {
    private SystemInfoDao systemInfoDao = new SystemInfoDao();
    @Override
    public Map getCpuInfo() {
        try {
            return systemInfoDao.getCpuInfo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new HashMap();
    }

    @Override
    public Map getDdrInfo() {
        return systemInfoDao.getDdrInfo();
    }

    @Override
    public List getDiskInfo() {
        return systemInfoDao.getDiskInfo();
    }
}
