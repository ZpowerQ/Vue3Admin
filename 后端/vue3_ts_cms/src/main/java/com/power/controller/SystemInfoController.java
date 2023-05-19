package com.power.controller;

import com.power.dao.SystemInfoDao;
import com.power.service.ISystemInfoService;
import com.power.service.impl.SystemInfoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/systemInfo")
public class SystemInfoController {
    private SystemInfoServiceImpl systemInfoService = new SystemInfoServiceImpl();

    @GetMapping("/getCpuInfo")
    public Map getCpuInfo() throws InterruptedException{
        return systemInfoService.getCpuInfo();
    }

    @GetMapping("/getDdrInfo")
    public Map getDdrInfo(){
        return systemInfoService.getDdrInfo();
    }

    @GetMapping("/getDiskInfo")
    public List getDiskInfo(){
        return systemInfoService.getDiskInfo();
    }
}
